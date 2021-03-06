package com.lmzqm.mybatis.Controller;

import org.apache.catalina.LifecycleState;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by lmzqm on 2017/7/4.
 */
@Controller
public class FileUploadController {

    private Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private HttpServletRequest request;

    @Value("${upload.filename}")
    private String uploadFile;

    @GetMapping("/upload")
    public String upload(){
        logger.info("the template file dir is "+uploadFile);
        return "fileUpload";
    }


    /**
     * 单文件上传
     * @param file 文件名
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
///Users/lmzqm/Downloads/mybatis/src/main/resources
//        logger.info("the template file dir is "+uploadFile);

//        ClassPathResource resource = new ClassPathResource("upload/tmp");
//        if(!resource.exists()){
//
//        }
//        File fileSourcePath = new File("src/main/resources/upload/tmp");
//        if (!fileSourcePath.exists()) {
//            fileSourcePath.mkdirs();
//        }

        if(!file.isEmpty()){
            try {
                //文件的保存路径
//                String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/"+file.getOriginalFilename();
//                file.transferTo(new File(filePath));

                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(uploadFile+file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败" + e.getLocalizedMessage();
            }
            catch (IOException e) {
                e.printStackTrace();
                return "上传失败"+e.getLocalizedMessage();
            }
            return "上传成功";
        }else{
            return "上传失败，因为文件是空的";
        }
    }


    @PostMapping(value = "/upload/batch")
    @ResponseBody
    public String batchUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;

            for (int i= 0;i<files.size();i++){
                file = files.get(i);
            if(!file.isEmpty()){
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    stream = null;
                    return "上传失败";
                } catch (IOException e) {
                    e.printStackTrace();
                    return "上传失败";
                }
            }else {
                return "文件为空";
            }


        }
        return "上传成功";
    }


    @GetMapping("/download")
    public void downLoadFile(HttpServletResponse res) throws IOException{
        String fileName = "weixin.jpg";
        res.setHeader("content-type","application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition","attachment;filename="+fileName);
        ClassPathResource resource = new ClassPathResource("static/images/weixin.jpg");
        File file = resource.getFile();
        FileOutputStream fos = new FileOutputStream(file);
        res.setContentLengthLong(file.length());
        fos.close();
    }

}
