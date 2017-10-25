SET FOREIGN_KEY_CHECKS=0;

--
--  Table Structure for `users`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
  `id`  INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` VARCHAR(32) DEFAULT NULL COMMENT '用户名',
  `password` VARCHAR(32) DEFAULT NULL COMMENT '密码',
  `sex` VARCHAR(32) DEFAULT NULL COMMENT '性别',
  `nick_name` VARCHAR(32) DEFAULT NULL COMMENT '别名',
  PRIMARY KEY (`id`)
)ENGINE = InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for activity
-- ----------------------------

DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_province` VARCHAR(255) NOT NULL COMMENT '地址 省',
  `address_city` VARCHAR(255) NOT NULL COMMENT '地址 市',
  `address_district` VARCHAR(255) NOT NULL COMMENT '地址 区',
  `address_street` VARCHAR(255) NOT NULL COMMENT '地址 街道',
  `address` VARCHAR(255) NOT NULL COMMENT '地址 详细',
  `coord_long` DOUBLE NOT NULL COMMENT '经度',
  `coord_lat` DOUBLE NOT NULL COMMENT '维度',
  `service_type` VARCHAR(255) NOT NULL COMMENT '服务类型',
  `service_object` VARCHAR(255) NOT NULL COMMENT '服务对象',
  `recruit_time` VARCHAR(255) NOT NULL ,
  `recruit_person_num` INT(11) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `description` TEXT NOT NULL ,
  `time` VARCHAR(255) NOT NULL ,
  `principal_name` VARCHAR(255) NOT NULL ,
  `principal_contack` VARCHAR(255) NOT NULL ,
  `activity_status_id` INT(11) NOT NULL COMMENT '活动状态',
  `working_hours` DOUBLE(11,0) NOT NULL COMMENT '机工时长',
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `picture` VARCHAR(255) NOT NULL DEFAULT '',
  `code` INT(11) NOT NULL COMMENT '随机六位数',
  `organization_id` int(11) NOT NULL,
  `tribe_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`),
  KEY `activity_status_id` (`activity_status_id`),
  CONSTRAINT `activity_status_id` FOREIGN KEY (`activity_status_id`) REFERENCES `activity_status` (`id`) ON DELETE NO ACTION
)ENGINE = InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET =utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '浙江省', '杭州市', '西湖区', '紫荆花路', '西湖区紫荆花路9号紫庭南弄紫金庭园芦荻苑9幢3号商铺', '120.10045467807049', '30.276733980070816', '敬老助残', '老人', '3月3号', '20', '为老人开展志愿服务', '为老人开展志愿服务，要求会理发，义诊，缝补，磨剪刀，心理咨询，清洗眼镜，量血压', '3月5号', '卜丽萍', '13805771623', '3', '8', '2017-02-21 00:00:00', '/public/img/9629ec51-4968-4173-b109-4ac89616350a.jpeg', '120932', '3', '2084525335');
INSERT INTO `activity` VALUES ('2', '浙江省', '杭州市', '拱墅区', '丰潭路', '西湖区丰潭路255号（近政苑小区）', '120.11228674951892', '30.30248685539544', '便民服务', '老人', '即日起至2月18日止', '40', '理发捶背等服务老', '理发捶背等服务老人的志愿者，司机，拍摄人员', '2月18号', '阿惠', '13968164404', '3', '2', '2017-02-21 20:32:22', '/public/img/5640d09f-f89b-44ae-97f0-5aa71dd71587.png', '101746', '3', '2084525335');
INSERT INTO `activity` VALUES ('3', '浙江省', '杭州市', '江干区', '金沙大道', '江干区金沙大道龙湖时代天街6层-001', '120.33427116078644', '30.315655589097755', '便民服务', '“好家风”党员志愿者服务队队员和其他爱心人士', '即日起至2月18日止', '30', '弯腰一秒，捡起垃圾，为城市增光', '弯腰一秒，捡起垃圾，为城市增光', '2月19号', '方卫生', '13868030016', '3', '20', '2017-02-22 00:00:00', '/public/img/574faf4c-a919-4fb6-9bf6-d861640ca40d.jpeg', '145933', '3', '2084525335');
INSERT INTO `activity` VALUES ('4', '浙江省', '杭州市', '上城区', '湖滨路', '上城区学士路58号（东坡路至长生路左拐，即可到达学士路九井店门口）', '120.16888851527868', '30.261106821572888', '便民服务', '杭州环境', '即日起至2月19日止', '20', '清蓝行动，倡导垃圾你不落地', '清蓝行动，倡导垃圾你不落地，志愿杭州，相识杭州创业杭州', '2月19号', '黄元淑', '18905812538', '1', '15', '2017-02-21 20:32:24', '/public/img/4784a926-3bbd-4da3-a3f7-495b7ef833f7.jpeg', '124431', '3', '2084525335');
INSERT INTO `activity` VALUES ('5', '浙江省', '杭州市', '上城区', '湖滨路', '上城区学士路58号（东坡路至长生路左拐，即可到达学士路九井店门口）', '120.16888851527868', '30.261106821572888', '大型活动', '送花车队', '3月4号下午1点止', '60', '为“百姓身边的活雷锋”送去鲜花与祝福', '同当地道德模范、社会精英名人、奥运或亚运冠军、最美志愿者和广电名主持一同发出为“百姓身边的活雷锋”送去鲜花与祝福', '3月4号', '应丰蔚', '0571-85174221', '1', '5', '2017-02-21 00:00:00', '/public/img/27cf115d-5161-4cd8-909d-a49c7d107eef.jpeg', '184353', '3', '2084525335');
INSERT INTO `activity` VALUES ('6', '浙江省', '杭州市', '萧山区', '萧绍路', '萧山区萧绍路1131号（315车站往东150米）', '120.28156726929555', '30.170919633318324', '青少年服务', '志愿者档案', '即日起至2月6号', '3', '协助进行大屋顶志愿者管理工作', '协助进行大屋顶志愿者管理工作', '2月6号', '马晨阳', '15088626056', '2', '7', '2017-02-21 00:00:00', '/public/img/b072d18f-2f6e-449c-be81-68da7d33d4e3.png', '148477', '3', '2084525335');
INSERT INTO `activity` VALUES ('7', '浙江省', '杭州市', '萧山区', '城河街', '萧山区城河街33-34号（新华书店旁）', '120.27334012750275', '30.16913332703096', '社会管理', '献血', '即日起至2月8号', '100', '引导献血人员填写信息、化验以及献血过程中的协助', '引导献血人员填写信息、化验以及献血过程中的协助。在献血车中为献血者提供热水及饮食服务等献血后的恢复工作。户外志愿献血宣传', '2月8号', '周洪华', '15990085180', '1', '6', '2017-02-21 20:32:27', '/public/img/ef0afd6e-b4eb-429d-bed1-9498450a2ebe.jpeg', '189324', '3', '2084525335');
INSERT INTO `activity` VALUES ('8', '浙江省', '杭州市', '江干区', '金沙大道', '江干区金沙大道龙湖时代天街6层-001', '120.33427116078644', '30.315655589097755', '文化体育', '梅花', '即日起至2月28号', '50', '进化梅花节期间志愿服务工作', '进化梅花节期间志愿服务工作', '1月26号', '陈清峰', '13968038789', '1', '6', '2017-02-21 20:32:28', '/public/img/0a23ca1b-2d33-48c8-8a48-661a6af05caf.jpeg', '101192', '3', '2084525335');
INSERT INTO `activity` VALUES ('9', '浙江省', '杭州市', '上城区', '翰林街', '下城区翰林街88号（庆春路）', '120.19134245380603', '30.26173419140316', '环境保护', '韩美林艺术馆', '即日起到12月31号', '30', '志愿者提供志愿服务，包括活动前期准备', '志愿者提供志愿服务，包括活动前期准备，活动帮助，结束后的场所整理', '12月31号', '韩旖旎', '13588150826', '1', '8', '2017-02-21 20:32:29', '/public/img/f129776e-1b44-4f67-a526-79796c051a38.jpeg', '137988', '3', '2084525335');
INSERT INTO `activity` VALUES ('10', '浙江省', '杭州市', '余杭区', '南大街', '余杭区南大街139号', '120.31353300015603', '30.41707196018103', '青少年服务', '特殊青少年群体', '即日起至4月7号', '30', '帮助特殊群体', '帮助特殊群体', '4月7号', '张风旗', '15355465906', '1', '7', '2017-02-21 20:32:30', '/public/img/8ffa23e8-b49d-447a-807c-3390e87df515.png', '186366', '3', '2084525335');
INSERT INTO `activity` VALUES ('11', '浙江省', '杭州市', '上城区', '庆春路', '上城区长生路太平里3号（衣之家广场屈臣氏对面）', '120.16773569466515', '30.26375483370823', '环境保护', '医院', '即日起至12月31号', '30', '在社区为患者提供导医', '在社区为患者提供导医、咨询以及帮助患者使用新设备等志愿服务', '12月31号', '李东华', '15858218132', '1', '8', '2017-02-21 20:32:31', '/public/img/3f21f0f4-38a4-4a34-a03f-fed31399be53.jpeg', '117867', '3', '2084525335');
INSERT INTO `activity` VALUES ('12', '浙江省', '杭州市', '滨江区', '江陵路', '滨江区江陵路2030号（滨盛路与江陵路交叉口）', '120.2207886978211', '30.218845388295104', '便民服务', '骨伤医院', '即日起至10月25号', '100', '引导、帮助、陪同就医患者挂号、候诊、检查', '热情接待每位患者，引导、帮助、陪同就医患者挂号、候诊、检查、缴费、缴费、治疗等', '10月27号', '刘建立', '13588391208', '1', '8', '2017-02-21 20:32:32', '/public/img/86fc3686-2ab6-4e96-a7d1-121fad176368.jpeg', '130238', '3', '2084525335');
INSERT INTO `activity` VALUES ('13', '浙江省', '杭州市', '萧山区', '市心北路', '萧山区市心北路227号中誉万豪广场（建设三路地铁站B出口）', '120.27367787869653', '30.2118478608464', '便民服务', '浙一医院', '即日起11月1号', '30', '期望长期在我院行志愿服务', '期望长期在我院行志愿服务', '11月1号', '王颖', '0571-87235000', '1', '8', '2017-02-21 20:32:33', '/public/img/c2a36ba3-91dc-442f-a864-06c6162c6ded.jpeg', '197588', '3', '2084525335');
INSERT INTO `activity` VALUES ('14', '浙江省', '杭州市', '西湖区', '西溪路', '西湖区西溪路399号', '120.13418585413956', '30.274306022913304', '平安守护', '公粮应急救援服务中心', '即日起至9月8号', '100', '有爱心，责任心处事认真谨慎', '有爱心，责任心处事认真谨慎，有户外经验者优先考虑', '9月8号', '韩强', '13148305415', '1', '8', '2017-02-21 20:32:33', '/public/img/ddf21b9c-aebf-4c0d-9d4e-64240c257d27.jpeg', '197228', '3', '2084525335');
INSERT INTO `activity` VALUES ('15', '浙江省', '杭州市', '上城区', '开元路', '上城区惠兴路9-2号（解放路与惠兴路交叉口，吴山夜市解放路入口）', '120.1701772926345', '30.2538463715128', '环境保护', '超山景区', '即日起至2月19日止', '20', '户外活动请注意安全', '户外活动请注意安全，请携带小学以上的家长务必照顾负责好孩子的安全。请自带手套以及垃圾袋等工具', '2月19号', '王海英', '15158182190', '1', '3', '2017-02-21 20:32:34', '/public/img/14b91879-b85b-4f97-8901-0a27d060d452.jpeg', '193380', '3', '2084525335');
INSERT INTO `activity` VALUES ('16', '浙江省', '杭州市', '西湖区', '天目山路', '西湖区西溪路550号西溪新座7幢101A', '120.11678488410583', '30.27480017782277', '文化体育', '杭州图书馆环保分馆', '即日起至3月31号', '30', '图书馆管理、图书整理', '图书馆管理、图书整理、借还书处理、活动协助', '3月31号', '胡云华', '13735456540', '1', '7', '2017-02-21 20:32:35', '/public/img/3f2c2e9e-4080-4ad8-b837-0b52d9fa2f24.jpeg', '175219', '3', '2084525335');
INSERT INTO `activity` VALUES ('17', '浙江省', '杭州市', '萧山区', '万达北路', '萧山区万达北路278号阿莲大锅台（郁金香岸对面）', '120.16798603624129', '30.14290101927445', '环境保护', '黑马公益服务中心', '即日起至2月18日止', '200', '对市民不文明现象进行劝导', '对市民不文明现象进行劝导以及清理地面小垃圾', '2月18号', '黑马公益', '13735587115', '1', '7', '2017-02-21 20:32:36', '/public/img/1be30877-9706-4e9f-bb95-4342eb4e9350.jpeg', '195952', '3', '2084525335');
INSERT INTO `activity` VALUES ('18', '浙江省', '杭州市', '临安市', '锦江路', '临安市锦江路87号（中国体育彩票隔壁）', '119.71829300258979', '30.234053770555963', '青少年服务', '儿童', '即日起至9月30号', '100', '对多动症的小朋友进行感觉统合训练', '志愿者对多动症的小朋友进行感觉统合训练，其中有篮球训练，平衡力训练等等', '9月30号', '龙森', '13967171102', '1', '8', '2017-02-21 20:32:37', '/public/img/c5b48bd6-ae6c-4539-aa3e-a3b90d07dae1.jpeg', '154108', '3', '2084525335');
INSERT INTO `activity` VALUES ('19', '浙江省', '杭州市', '萧山区', '建设三路', '萧山区市心北路217号德意中兴广场3楼（近建设三路）', '120.27319289882288', '30.210691907071695', '便民服务', '手语翻译志愿者', '即日起至12月5号', '100', '消除沟通障碍，促进参与共享', '消除沟通障碍，促进参与共享，用爱心点燃希望的火种，用行动传递公益的力量', '12月5号', '茹万龙', '13588033183', '1', '8', '2017-02-21 00:00:00', '/public/img/c0f074bf-201a-4e45-a391-b646f430cdf4.jpg', '151090', '3', '2084525335');
INSERT INTO `activity` VALUES ('20', '浙江省', '杭州市', '滨江区', '商业街', '滨江区高教园商业街4号楼(近华润超市)', '120.16044789028312', '30.1762190302109', '环境保护', '江南红巷AAA级景区', '即日起至5月25号', '100', '我们正在寻找加入称为亲民君的伙伴', '我们正在寻找有兴趣、愿意参与、加入称为亲民君的伙伴', '5月25号', '王主任', '86906731', '1', '8', '2017-02-21 00:00:00', '/public/img/8ba5d5db-5ca1-4ba2-b684-45a96e2b6439.jpg', '107405', '3', '2084525335');
INSERT INTO `activity` VALUES ('25', '浙江省', '杭州市', '江干区', '二号大街', '杭州电子科技大学', '120.10000000000049', '30.27673398', '敬老助残', '老人', '即日起到2月25号', '200', '为老人开展志愿服务', '为老人洗脚', '2月24号', '吴晓明', '13588002512', '1', '8', '2017-02-22 00:00:00', '/public/img/9629ec51-4968-4173-b109-4ac89616350a.jpeg', '785621', '3', '2084525335');
INSERT INTO `activity` VALUES ('26', '浙江省', '杭州市', '江干区', '二号大街', '杭州电子科技大学', '120.10000000000049', '30.27673398', '敬老助残', '老人', '即日起到2月25号', '200', '为老人开展志愿服务', '为老人洗脚', '2月24号', '吴晓明', '13588002512', '1', '8', '2017-02-22 00:00:00', '/public/img/9629ec51-4968-4173-b109-4ac89616350a.jpeg', '785622', '3', '2084525335');
INSERT INTO `activity` VALUES ('27', '浙江省', '杭州市', '江干区', '二号大街', '杭州电子科技大学', '120.10000000000049', '30.27673398', '敬老助残', '老人', '即日起到2月25号', '200', '为老人开展志愿服务', '为老人洗脚', '2月24号', '吴晓明', '13588002512', '1', '8', '2017-02-22 00:00:00', '/public/img/9629ec51-4968-4173-b109-4ac89616350a.jpeg', '660088', '3', '2084525335');
INSERT INTO `activity` VALUES ('28', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-25 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '453419', '3', '2084525335');
INSERT INTO `activity` VALUES ('29', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '525027', '3', '2084525335');
INSERT INTO `activity` VALUES ('30', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '803929', '3', '2084525335');
INSERT INTO `activity` VALUES ('31', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '346480', '3', '2084525335');
INSERT INTO `activity` VALUES ('32', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '339539', '3', '2084525335');
INSERT INTO `activity` VALUES ('33', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '595510', '3', '2084525335');
INSERT INTO `activity` VALUES ('34', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '577113', '3', '2084525335');
INSERT INTO `activity` VALUES ('35', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '117388', '3', '2084525335');
INSERT INTO `activity` VALUES ('36', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '282837', '3', '2084525335');
INSERT INTO `activity` VALUES ('37', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '870487', '3', '2084525335');
INSERT INTO `activity` VALUES ('38', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '50338', '3', '2084525335');
INSERT INTO `activity` VALUES ('39', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '897682', '3', '2084525335');
INSERT INTO `activity` VALUES ('41', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '642521', '3', '2084525335');
INSERT INTO `activity` VALUES ('42', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '110037', '3', '0');
INSERT INTO `activity` VALUES ('43', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-26 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '335588', '3', '2084547479');
INSERT INTO `activity` VALUES ('45', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-27 10:46:28', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '161043', '3', '2084521020');
INSERT INTO `activity` VALUES ('46', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '环保助力中国梦', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-27 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '813957', '3', '2082387294');
INSERT INTO `activity` VALUES ('47', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '测试活动', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-27 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '7646', '3', '2082391566');
INSERT INTO `activity` VALUES ('48', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '测试活动2222', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-27 00:00:00', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '22968', '3', '2085272719');
INSERT INTO `activity` VALUES ('49', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '测试活动3333', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-27 14:42:50', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '328077', '3', '2084777001');
INSERT INTO `activity` VALUES ('51', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '环境保护', '地球', '即日起至3月3日', '20', '测试活动5555', '搞卫生', '3月4日', '吴大明', '13155555555', '1', '5', '2017-02-27 19:26:37', '/public/img/3db4436f-976b-4876-b1bd-af31c80d9e79.jpg', '558262', '3', '2085180457');
INSERT INTO `activity` VALUES ('52', '浙江省', '杭州市', '江干区', '金沙东路', '杭州电子科技大学', '120.35043127267346', '30.319567170311355', '平安守护', '学生', '即日起至3月1日', '1', '消防应急体验活动', '参与消防应急体验活动', '3月1日', '吴大明', '13555555555', '3', '10', '2017-02-28 00:00:00', '/public/img/e5feff96-6d52-46ba-8bce-815e1718a566.jpg', '855529', '4', '2086393047');
INSERT INTO `activity` VALUES ('53', '浙江省', '杭州市', '江干区', '学林街', '杭州电子科技大学五餐门口', '120.35053996764016', '30.322873226171176', '便民服务', '青少年', '即日起至3月4日', '20', '爱心献血', '在3月4号星期六早上8点到12点，杭电五餐门口，会举行无偿献血活动，欢迎同学们的爱心献血', '3月4日', '吴大涛', '13569956369', '1', '4', '2017-02-28 17:38:21', '/public/img/ffb8c086-5b02-4db9-b548-5c610934777a.jpg', '607135', '4', '2086599564');
INSERT INTO `activity` VALUES ('54', '浙江省', '杭州市', '下城区', '武林广场西通道', '杭州大厦', '120.16793018768944', '30.277692909332732', '青少年服务', '少年儿童', '即日起至3月16日', '5', '爱心教学活动', '教孩子们学习音乐', '3月16日', '徐海涛', '13258468512', '1', '5', '2017-03-02 15:52:41', '/public/img/91a8ef46-18e7-43cc-bbc2-c37f3401cc2b.jpg', '282325', '8', '2089605692');


-- ----------------------------
-- Table structure for activity_status
-- ----------------------------

DROP TABLE IF EXISTS `activity_status`;
CREATE TABLE `activity_status`(

  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`)

)ENGINE = InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of activity_status
-- ----------------------------
INSERT  INTO  `activity_status` VALUES ('1','活动正在招募');
INSERT INTO `activity_status` VALUES ('2','活动进行');
INSERT INTO `activity_status` VALUES ('3','活动结束');

#
# DROP DATABASE IF EXISTS db_blog;
#
# create DATABASE db_blog DEFAULT CHARACTER SET utf8;
#
# USE db_blog;

DROP TABLE  IF EXISTS `t_blogger`;
CREATE TABLE `t_blogger`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博主id',
  `username` VARCHAR(255) NOT NULL COMMENT '博主名字',
  `password` VARCHAR(100) NOT NULL COMMENT '博主密码',
  `profile` TEXT COMMENT '博主信息',
  `nick_name` VARCHAR(50) DEFAULT NULL COMMENT '博主昵称',
  `sign` VARCHAR(255) DEFAULT NULL  COMMENT '博主签名',
  `imageurl` VARCHAR(100) DEFAULT NULL  COMMENT '博主头像路径',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET = utf8;


INSERT INTO `t_blogger` values('2','lmzqm','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('3','钟超','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('4','徐悦','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('5','阳光岛主','123123','阳光、快乐、创新.','IT-Homer','欢迎访问我的新博客： http://blog.mimvp.com','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('6','丁码农','123123','擅长大规模（高并发、高可用、海量数据）互联网架构','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('7','iter_zc','123123','关注互联网架构方向','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('8','java-er','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('9','patyer','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('10','NBAPlayer','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('11','FaceYoue','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('12','NO i Cane','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('13','张是一个中文','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('14','活动活动和','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('15','对的','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');
INSERT INTO `t_blogger` values('16','没有听到','123123','爱哭爱闹爱开玩笑....','会飞的猪','新的时代，新的征程','http://avatar.csdn.net/7/8/4/1_xuyue1987.jpg');


DROP TABLE  IF EXISTS `t_blog`;
CREATE TABLE `t_blog`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` VARCHAR(255) NOT NULL COMMENT '博客的标题',
  `content` TEXT COMMENT '博客的内容',
  `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '博客发布时间',
  `bloger_id` INT(11) NOT NULL DEFAULT '2' COMMENT '作者的ID',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_blogger` FOREIGN KEY (`bloger_id`) REFERENCES `t_blogger` (`id`) ON DELETE NO ACTION
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO `t_blog` VALUES ('1001','Python 使用 os.fork() 创建子进程','Linux 操作系统提供了一个 fork() 函数用来创建子进程，这个函数很特殊，调用一次，返回两次，因为操作系统是将当前的进程（父进程）复制了一份（子进程），然后分别在父进程和子进程内返回。子进程永远返回0，而父进程返回子进程的 PID。我们可以通过判断返回值是不是 0 来判断当前是在父进程还是子进程中执行。在 Python 中同样提供了 fork() 函数，此函数位于 os 模块下。下面是一个例...',now(),2);
INSERT INTO `t_blog` VALUES ('1002','SSH 首次登录太慢问题','这两天在使用 Docker 做测试，发现新建的容器在首次 ssh 登录的时候经常超时，我们简单将超时时间设置成60秒，但仍然会偶尔超时。所以简单延迟超时时间此路不通。于是想到是否可以通过修改 sshd 的参数，来解决问题。大概查了一下 SSH 登录太慢可能是 DNS 解析的问题，默认配置 ssh的 初次接受 ssh 连接时会自动反向解析客户端 IP 地址以得到 ssh 客户端的主机名。如果此时 DN...',now(),2);
INSERT INTO `t_blog` VALUES ('1003','我们为什么要使用AOP？','谢谢 前言 一年半前写了一篇文章Spring3：AOP，是当时学习如何使用Spring AOP的时候写的，比较基础。这篇文章最后的推荐以及回复认为我写的对大家有帮助的评论有很多，但是现在',now(),2);
INSERT INTO `t_blog` VALUES ('1004','Java虚拟机14：Java对象大小、对象内存布局及锁状态变化','摘要: 一个对象占多少字节？ 关于对象的大小，对于C/C++来说，都是有sizeof函数可以直接获取的，但是Java似乎没有这样的方法。不过还好，在JDK1.5之后引入了Instrumentation类，这个类提供了计算对象内存占用量的方法。至于具体Instrumentation类怎么用就不说了，可以参看这',now(),2);
INSERT INTO `t_blog` VALUES ('1005','【MyBatis源码解析】MyBatis一二级缓存','MyBatis缓存 我们知道，频繁的数据库操作是非常耗费性能的（主要是因为对于DB而言，数据是持久化在磁盘中的，因此查询操作需要通过IO，IO操作速度相比内存操作速度慢了好几个量级），尤其是对于一些相同的查询语句，完全可以把查询结果存储起来，下次查询同样的内容的时候直接从内存中获取数据即可，这样在某',now(),2);
INSERT INTO `t_blog` VALUES ('1006','【MyBatis源码分析】插件实现原理',' MyBatis插件原理 从<plugins>解析开始 本文分析一下MyBatis的插件实现原理，在此之前，如果对MyBatis插件不是很熟悉的朋友，可参看此文MyBatis7：MyBatis插件及示例 打印每条SQL语句及其执行时间，本文我以一个例子说明了MyBatis插件是什么以及如何实现。由于M',now(),2);
INSERT INTO `t_blog` VALUES ('1007','【MyBatis源码分析】select源码分析及小结','示例代码 之前的文章说过，对于MyBatis来说insert、update、delete是一组的，因为对于MyBatis来说它们都是update；select是一组的，因为对于MyBatis来说它就是select。 本文研究一下select的实现流程，示例代码为： selectMailById方法的',now(),2);
INSERT INTO `t_blog` VALUES ('1008','MyBatis7：MyBatis插件及示例----打印每条SQL语句及其执行时间',' Plugins 摘一段来自MyBatis官方文档的文字。 MyBatis允许你在某一点拦截已映射语句执行的调用。默认情况下，MyBatis允许使用插件来拦截方法调用 Executor（update、query、flushStatements、commint、rollback、getTransacti',now(),2);
INSERT INTO `t_blog` VALUES ('1009','【MyBatis源码分析】insert方法、update方法、delete方法处理流程（下篇）','Configuration的newStatementHandler分析 SimpleExecutor的doUpdate方法上文有分析过： 这两天重看第5行的newStatementHandler方法的时候，发现方法上文在这个方法中分析地太简略了，这里过一遍一下Configuration的newSta',now(),2);
INSERT INTO `t_blog` VALUES ('10010','TCP：三次握手、四次握手、backlog及其他','TCP是什么 首先看一下OSI七层模型： 然后数据从应用层发下来，会在每一层都加上头部信息进行封装，然后再发送到数据接收端，这个基本的流程中每个数据都会经过数据的封装和解封的过程，流程如下图所示： 在OSI七层模型中，每一层的作用和对应的协议如下图所示： 说回TCP，简单说TCP（Transmiss',now(),2);
INSERT INTO `t_blog` VALUES ('10011','图解集合8：红黑树的移除节点操作',' 红黑树移除节点 上文详细讲解了红黑树的概念，红黑树的插入及旋转操作，根据测试代码建立起来的红黑树结构为： 本文先研究一下红黑树的移除操作是如何实现的，移除操作比较复杂，具体移除的操作要进行几次旋转和移除的节点在红黑树中的位置有关，这里也不特意按照旋转次数选择节点了，就找三种位置举例演示红黑树移除操作',now(),2);
INSERT INTO `t_blog` VALUES ('10012','图解集合7：红黑树概念、红黑树的插入及旋转操作详细解读','原文地址http://www.cnblogs.com/xrq730/p/6867924.html，转载请注明出处，谢谢！ 初识TreeMap 之前的文章讲解了两种Map，分别是HashMap与LinkedHashMap，它们保证了以O(1)的时间复杂度进行增、删、改、查，从存储角度考虑，这两种数据结',now(),2);
INSERT INTO `t_blog` VALUES ('10013','【MyBatis源码分析】insert方法、update方法、delete方法处理流程（上篇）',' 打开一个会话Session 前文分析了MyBatis将配置文件转换为Java对象的流程，本文开始分析一下insert方法、update方法、delete方法处理的流程，至于为什么这三个方法要放在一起说，是因为： 示例代码为这段： 首先关注的是第2行的代码，ssf是SqlSessionFactory，',now(),2);
INSERT INTO `t_blog` VALUES ('10014','【MyBatis源码分析】Configuration加载（下篇）',' 元素设置 继续MyBatis的Configuration加载源码分析： 上回看到了第7行的<typeAlias>标签的解析，后面先暂时跳过<plugins>、<objectFactory>、<objectWrapperFactory>、<reflectorFactory>、<typeHandlers',now(),2);
INSERT INTO `t_blog` VALUES ('10015','【MyBatis源码分析】Configuration加载（上篇）','config.xml解析为org.w3c.dom.Document 本文首先来简单看一下MyBatis中将config.xml解析为org.w3c.dom.Document的流程，代码为上文的这部分： 第3行的代码实现为： 相当于就是将输入的路径转换为一个字符输入流并返回。 接着继续看静态块第4行的',now(),2);



DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`(
  `c_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `blog_id` INT(11) NOT NULL COMMENT '外键链接相对应的blog',
  `user_id` INT(11) NOT NULL COMMENT '评论者id',
  `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `desc` VARCHAR(255) NOT NULL DEFAULT '暂时还么有评论' COMMENT '评论的信息',
  PRIMARY KEY (`c_id`),
  CONSTRAINT `fk_blog` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `t_blogger` (`id`) ON DELETE NO ACTION
)ENGINE = InnoDB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8;

INSERT INTO `t_comment` VALUES ('2','1001','2',now(),'写的很详细，表达很透彻');
INSERT INTO `t_comment` VALUES ('3','1001','3',now(),'请问这个图是用什么画的');
INSERT INTO `t_comment` VALUES ('4','1001','4',now(),'模糊的 全清楚了 ！收藏了！');
INSERT INTO `t_comment` VALUES ('5','1001','5',now(),'6666666');
INSERT INTO `t_comment` VALUES ('6','1001','6',now(),'说的好!');
INSERT INTO `t_comment` VALUES ('7','1001','7',now(),'您好博主，ArrayDequeTest的第一个输出顺序错误');
INSERT INTO `t_comment` VALUES ('8','1001','8',now(),'ArrayDequeTest 第三个和第五和输出顺序也有误');

INSERT INTO `t_comment` VALUES ('9','1002','2',now(),'很不错，很实用');
INSERT INTO `t_comment` VALUES ('10','1002','3',now(),'可以可以，正好自己也在研究');
INSERT INTO `t_comment` VALUES ('11','1002','4',now(),'看到博主的博文之后，理解更加深刻了');
INSERT INTO `t_comment` VALUES ('12','1002','5',now(),'为什么你该开始学习编程了？');
INSERT INTO `t_comment` VALUES ('13','1002','6',now(),'小printf的故事：什么是真正的程序员？');
INSERT INTO `t_comment` VALUES ('14','1002','7',now(),'程序员的工作、学习与绩效');

INSERT INTO `t_comment` VALUES ('15','1003','2',now(),'唱吧DevOps的落地，微服务CI/CD的范本技术解读');
INSERT INTO `t_comment` VALUES ('16','1003','3',now(),'是框架自动生成的，是springfox-swagger-ui.jar包下的一个文件');
INSERT INTO `t_comment` VALUES ('17','1003','4',now(),'404啊，没有错误信息，打开不了那个页面，这些页面是框架自动生成的吗');
INSERT INTO `t_comment` VALUES ('18','1003','5',now(),'解决方法：swagger 版本升级2.5.2');
INSERT INTO `t_comment` VALUES ('19','1003','6',now(),'把maven引用顺序调一下，把swagger放在 Feign前面引用');
INSERT INTO `t_comment` VALUES ('20','1003','7',now(),'请问是否有不使用注解而是配置文件的方法，感觉注解太多比较臃肿。');


DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info`(
  `user_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` VARCHAR(255) NOT NULL UNIQUE COMMENT '姓名 需要保证唯一性的操作',
  `city` VARCHAR(255) DEFAULT NULL COMMENT '城市',
  `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号码',
  `avatar_url` VARCHAR(255) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`)
)ENGINE = InnoDB AUTO_INCREMENT=200  DEFAULT CHARSET = utf8;

INSERT INTO `user_info` VALUES ('220', '秋明_hhh', '深圳', '18271631256', 'http://www.xunluji.com/static/upload/images//20151108/20151108201119402.jpg');
INSERT INTO `user_info` VALUES ('221', '宋慧乔', '深圳', '18271631259', 'http://xlj2015.image.alimmdn.com/test/2CB0FF56-B3D0-4ABF-A566-8DCD0D4746FD');
INSERT INTO `user_info` VALUES ('222', '李俊PUWQ', '福建', '18680665708', 'http://wx.qlogo.cn/mmopen/0pygn8iaZdEcicKh86wSIlTcu24PIRt0wTz6xKrxkTRVD8ClPicYA034xFywBeA5d24B0I60TsxWYjhrOjw0amZxNBab6rVNQUV/0');
INSERT INTO `user_info` VALUES ('223', '饭饭', null, '13760867720', 'http://xlj2015.image.alimmdn.com/xlj/659092100346989119.png?t=1461409060067');

DROP TABLE IF EXISTS `focus`;

CREATE TABLE `focus`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '关注的id',
  `user_id` INT(11) DEFAULT NULL COMMENT '用户Id',
  `focus_id` INT(11) DEFAULT NULL COMMENT '关注ID',
  `focus_state` INT(2) DEFAULT '0' COMMENT '关注的状态 0 表示没关注 1 表示关注 2 表示互相关注',
  `focus_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '关注的时间',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`) REFERENCES user_info (`user_id`) ON DELETE NO ACTION ,
  CONSTRAINT `fk_focusid` FOREIGN KEY (`focus_id`) REFERENCES user_info (`user_id`) ON DELETE NO ACTION
)ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;

INSERT INTO `focus` VALUES ('1','220','221','1',now());
INSERT INTO `focus` VALUES ('2','220','222','1',now());
INSERT INTO `focus` VALUES ('3','220','223','1',now());
INSERT INTO `focus` VALUES ('4','221','220','1',now());
INSERT INTO `focus` VALUES ('5','221','221','1',now());
INSERT INTO `focus` VALUES ('6','221','222','1',now());
INSERT INTO `focus` VALUES ('7','220','223','1',now());

# DROP TABLE IF EXISTS `focus_status`;
# CREATE TABLE `focus_status`(
#
#   `id` INT(11) NOT NULL AUTO_INCREMENT,
#   `description` VARCHAR(255) NOT NULL ,
#   PRIMARY KEY (`id`)
#
# )ENGINE = InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET = utf8;
#
# INSERT INTO `focus_status` VALUES ('0','未关注');
# INSERT INTO `focus_status` VALUES ('1','已关注');
# INSERT INTO `focus_status` VALUES ('2','互相关注');

-- ----------------------------
-- 问题的表单，主要是存储表单的题目还有表单的选项已经表单的正确答案
-- ----------------------------

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions`(
  `question_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '问题的id',
  `question_title` VARCHAR(255) NOT NULL COMMENT '问题的题目',
  `question_options` VARCHAR(255) NOT NULL COMMENT '问题的选项',
  `question_current` TINYINT(1) NOT NULL COMMENT '正确的选项',
  PRIMARY KEY (`question_id`)
)ENGINE = InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET =utf8;

INSERT INTO `questions` VALUES ('1','Java 中能创建 volatile 数组吗？','能 不能','1');
INSERT INTO `questions` VALUES ('2','Java 中应该使用什么数据类型来代表价格？','使用BigDecimal  double 类型','2');


-- ----------------------------
-- 量表 量表中包含了标题，描述，状态，还有量表中的题目
-- ----------------------------
DROP TABLE IF EXISTS `scale`;

CREATE TABLE `scale`(
  `scale_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '量表的ID',
  `scale_title` VARCHAR(255) NOT NULL COMMENT '量表的题目',
  `scale_type` INT(11) NOT NULL COMMENT '量表的类型',
  `scale_desc` VARCHAR(255) NOT NULL COMMENT '量表的描述',
  `scale_status` INT(11) NOT NULL COMMENT '量表的状态',
  `scale_questions` VARCHAR(255) NOT NULL COMMENT '量表的题目',
  `scale_test_persons` INT(11) NOT NULL DEFAULT 1000 COMMENT '参加测试的人数',
  PRIMARY KEY (`scale_id`),
  CONSTRAINT `fk_type` FOREIGN KEY (`scale_type`) REFERENCES scale_type_t (`type_id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_status` FOREIGN KEY (`scale_status`) REFERENCES activity_status (`id`) ON DELETE NO ACTION
)ENGINE =InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET = utf8;

INSERT INTO `scale` VALUES ('1','步态与跌倒问卷','1','用于评估患者运动症状类病情情况','1','1,2','1000');
INSERT INTO `scale` VALUES ('2','Berg平衡表','1','用于评估患者运动症状类病情情况','1','2,1','1001');
INSERT INTO `scale` VALUES ('3','帕金森自主神经症状量表','1','用于评估患者运动症状类病情情况','1','1,2','1002');
INSERT INTO `scale` VALUES ('4','Epworth嗜睡量表','2','用于评估患者运动症状类病情情况','1','1,2','1003');
INSERT INTO `scale` VALUES ('5','国际不宁腿综合研究','2','用于评估患者运动症状类病情情况','1','1,2','1004');


-- ----------------------------
-- 量表的类型
-- ----------------------------
DROP TABLE IF EXISTS `scale_type_t`;

CREATE TABLE `scale_type_t`(
  `type_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type_desc` VARCHAR(255) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`type_id`)
)ENGINE = InnoDB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8;

INSERT INTO `scale_type_t` VALUES ('1','运动症状类量表');
INSERT INTO `scale_type_t` VALUES ('2','非运动症状类量表');

-- ----------------------------
-- 用户的量表记录
-- ----------------------------

DROP TABLE IF EXISTS `scale_record`;

CREATE TABLE `scale_record`(
  `recordid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '量表记录id',
  `scaleid` INT(11) NOT NULL COMMENT '量表的ID',
  `score` INT(11) NOT NULL COMMENT '量表分数',
  `result` VARCHAR(255) NOT NULL COMMENT '量表的结论',
  `record_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束答题的时间',
  `datas` VARCHAR(255) NOT NULL COMMENT '量表的结果集合',
  `userid` INT(11) NOT NULL COMMENT '用户的Id',
  PRIMARY KEY (`recordid`),
  CONSTRAINT `fk_scaleId` FOREIGN KEY (`scaleid`) REFERENCES scale (`scale_id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_user_record` FOREIGN KEY (`userid`) REFERENCES users (`id`) ON DELETE NO ACTION
)ENGINE = InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET = utf8;

INSERT INTO `scale_record` VALUES ('1','1','97','当前步态特征不显著',now(),'1,2','2')


# 注意外键重名的问题会导致 022 (23000): Can't write; duplicate key in table






