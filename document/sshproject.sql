/*
Navicat MySQL Data Transfer

Source Server         : mysql连接
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : sshproject

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-07 09:25:57
*/
use sshproject;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id_string` varchar(36) NOT NULL,
  `title_string` varchar(50) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `address_string` varchar(100) DEFAULT NULL,
  `content_string` text,
  `logo_string` varchar(500) DEFAULT NULL,
  `url_string` varchar(36) DEFAULT NULL,
  `buildings_id_string` varchar(36) DEFAULT NULL,
  `status_int` int(255) DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  `manager_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('402880015e182cad015e185fac5a0005', '七夕买房大优惠', '2017-08-28 00:00:00', '2017-08-29 00:00:00', '江西省赣州市章贡区', '<p>七夕买房大优惠七夕买房大优惠七夕买房大优惠七夕买房大优惠</p>', 'upfile/1.png', 'upfile/activityinfo.jsp', '402880015e182cad015e1852ba340002', '0', '402880115e2b678d015e2b69b32c0000', null);
INSERT INTO `t_activity` VALUES ('402880115e0d036b015e0d0774290000', '返回的发给好', '2017-08-26 00:00:00', '2017-08-26 00:00:00', '江西省赣州市章贡区九曲河路', '外国人买走英国的房子，英国本地人买不起房子，究竟是谁的错？如果开发商和中介不在海外大力宣传，外国人会来英国买房子吗？如果外国买家不买预售房，英国的开发商能得到贷款盖房吗？', 'upfile/4.png', 'upfile/activityinfo.jsp', '4028800d5d8bd60f015d8bd988230000', '0', '1', null);
INSERT INTO `t_activity` VALUES ('402880115e0d1ef3015e0d2378f20001', '平台活动', '2017-08-18 00:00:00', '2017-08-12 00:00:00', '江西省赣州市章贡区登峰大道', '外国人买走英国的房子，英国本地人买不起房子，究竟是谁的错？如果开发商和中介不在海外大力宣传，外国人会来英国买房子吗？如果外国买家不买预售房，英国的开发商能得到贷款盖房吗？', 'upfile/3.png', 'upfile/activityinfo.jsp', '4028800d5d988e9b015d9898902c0002', '1', null, '402880115db21c6a015db21e37bf0000');
INSERT INTO `t_activity` VALUES ('402880115e266302015e26aa6c7a0021', '爱上对方过后就哭了看见韩国', '2017-08-17 00:00:00', '2017-08-24 00:00:00', '江西省赣州市章贡区', '', 'upfile/2.png', 'upfile/1503887256695.html', '4028800d5d988e9b015d9898902c0002', '0', null, '1');
INSERT INTO `t_activity` VALUES ('402880115e2b841b015e2b8d49720008', '七夕巨惠，预定有礼~~~', '2017-08-28 00:00:00', '2017-08-30 00:00:00', '江西省赣州市章贡区海会路6号', '<p><span style=\"color: rgb(34, 34, 34); font-family: Consolas, \">Hui-iconfont</span></p>', 'upfile/8343577754674.jpg', 'upfile/1503969233260.html', '402880115e2bc2d6015e2bf96a450004', '0', '402880115e2b678d015e2b69b32c0000', null);
INSERT INTO `t_activity` VALUES ('402880115e2bc2d6015e2bebffbf0003', '七夕巨惠，预定有礼~~~', '2017-08-09 00:00:00', '2017-08-10 00:00:00', '江西省赣州市章贡区迎宾大道23', '<p><br/></p><p style=\"display:none;\"><br/></p>', 'upfile/14550503177756.jpg', 'upfile/1503975440317.html', '402880115e2b841b015e2b9690e9000c', '0', '402880115e2b678d015e2b69b32c0000', null);
INSERT INTO `t_activity` VALUES ('4028ab8e5e4f93ee015e4fb76071002d', '时代感是', '2017-09-23 00:00:00', '2017-09-30 00:00:00', '北京市北京市丰台区', '<p>设置V型<br/></p>', 'upfile/7176468674136.jpg', 'upfile/1504575971439.html', '402880115e2b841b015e2b9690e9000c', '0', '402880125e4cf3c2015e4cfa96860000', null);

-- ----------------------------
-- Table structure for t_ads
-- ----------------------------
DROP TABLE IF EXISTS `t_ads`;
CREATE TABLE `t_ads` (
  `id_string` varchar(36) NOT NULL,
  `title_string` varchar(50) DEFAULT NULL,
  `content_string` varchar(50) DEFAULT NULL,
  `logo_string` varchar(500) DEFAULT NULL,
  `ad_url_string` varchar(500) DEFAULT NULL,
  `show_status_string` varchar(2) DEFAULT NULL,
  `show_order_int` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ads
-- ----------------------------
INSERT INTO `t_ads` VALUES ('qwe', 'asd', 'sss', 'sss', 'ddd', 'Y', '111', '2017-07-21 10:13:39', '2');

-- ----------------------------
-- Table structure for t_agency
-- ----------------------------
DROP TABLE IF EXISTS `t_agency`;
CREATE TABLE `t_agency` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `email_string` varchar(20) DEFAULT NULL,
  `pwd_string` varchar(50) NOT NULL,
  `leader_string` varchar(20) DEFAULT NULL,
  `phone_string` varchar(11) NOT NULL,
  `tel_string` varchar(11) DEFAULT NULL,
  `address_string` varchar(100) DEFAULT NULL,
  `logo_string` varchar(500) DEFAULT NULL,
  `intro_string` varchar(500) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `checked_status_int` int(11) DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `reason_string` varchar(500) DEFAULT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`),
  UNIQUE KEY `phone_string` (`phone_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_agency
-- ----------------------------
INSERT INTO `t_agency` VALUES ('1', '桃源盛景', '275300002@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '陈飞龙', '17607975702', '15679760322', '北京市北京市房山区S208(阎东路)', 'upfile/1294136523545.jpg', '诚信经营，童叟无欺.。', '2017-08-04 15:59:19', '2', '0', '审核通过', '402880115da5d162015da5d2edfa0003');
INSERT INTO `t_agency` VALUES ('402880125e4cf3c2015e4cfa96860000', '天虹', '1654905415@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '少昊', '18296652908', '15679760329', '江西省赣州市章贡区章江南大道', 'upfile/47386173274843.jpg', '销售以诚信为主', '2017-09-04 21:00:45', '2', '0', '审核通过', '1');
INSERT INTO `t_agency` VALUES ('4028ab8e5e4f93ee015e4fb83eee002e', '啊', '275300091@QQ.COM', '05868E10ED7CBB988E7821FAD2B75941', '啊', '17370134036', '15679760329', '北京市北京市丰台区', 'upfile/7233422809350.jpg', '程序', '2017-09-05 09:47:08', '2', '0', '审核通过', '4028ab8e5e4f93ee015e4f9f7c940000');

-- ----------------------------
-- Table structure for t_appointment
-- ----------------------------
DROP TABLE IF EXISTS `t_appointment`;
CREATE TABLE `t_appointment` (
  `id_string` varchar(36) NOT NULL,
  `emp_id_string` varchar(36) DEFAULT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  `app_arrive_time` datetime DEFAULT NULL,
  `arrive_time` datetime DEFAULT NULL,
  `house_id_string` varchar(36) DEFAULT NULL,
  `app_status_int` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  `reason_string` text,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_appointment
-- ----------------------------
INSERT INTO `t_appointment` VALUES ('402880015e187dce015e18804d530002', '402880015dac5401015dac5a01550000', '1', '2017-08-15 00:00:00', '2017-09-04 09:01:41', '4028800d5d97e731015d97e813c10000', '3', '2017-08-25 16:26:55', '0', '1', '已成功购房');
INSERT INTO `t_appointment` VALUES ('402880115e36e320015e3707a7a60004', '402880015dac5401015dac5a01550000', '402880115e36e320015e36f2d10c0000', '2017-08-31 00:00:00', '2017-09-01 14:46:34', '402880115dc44675015dc44fcc0f0003', '2', '2017-08-31 14:43:22', '0', '1', '已经看房');
INSERT INTO `t_appointment` VALUES ('4028ab8e5e4f6104015e4f6e546f0003', '402880015dac5401015dac5a01550000', '402880115e477bda015e477ff6980000', '2017-09-05 00:00:00', null, '402880125e404eeb015e408cc7fb0000', '0', '2017-09-05 08:26:24', '0', '1', '预约看心仪的户型');
INSERT INTO `t_appointment` VALUES ('4028ab8e5e4f93ee015e4fa37fb00004', '402880015dac5401015dac5a01550000', '4028ab8e5e4f93ee015e4f9f7c940000', '2017-09-05 00:00:00', '2017-09-06 09:27:22', '402880125e404eeb015e408cc7fb0000', '2', '2017-09-05 09:24:29', '0', '1', '已经看房，购房意愿非常强');

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id_string` varchar(36) NOT NULL,
  `title_string` varchar(50) DEFAULT NULL,
  `abstracts_string` varchar(100) DEFAULT NULL,
  `content_string` text,
  `content_url_string` varchar(255) DEFAULT NULL,
  `logo_string` varchar(500) DEFAULT NULL,
  `created_time` date DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `type_string` varchar(36) DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  `publicusername_string` varchar(11) DEFAULT NULL,
  `managerid_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('4', '亚洲中产阶级热衷伦敦房产 买房多用于出租', '溢价174%! 一位英国女房东的房产投资生意经', '外国人买走英国的房子，英国本地人买不起房子，究竟是谁的错？如果开发商和中介不在海外大力宣传，外国人会来英国买房子吗？如果外国买家不买预售房，英国的开发商能得到贷款盖房吗？', 'upfile/articleinfo.jsp', 'upfile/1.png', '2017-08-08', '0', '402880115dc0aa44015dc0b0e9b60000', '', '陈飞龙', '402880115db21c6a015db21e37bf0000');
INSERT INTO `t_article` VALUES ('402880015dbc7691015dbc77f3e20000', '这些华人青睐的英国低房价投资热点地区你知道吗！', '溢价174%! 一位英国女房东的房产投资生意经', '最近的十多年来，英国的房价持续攀升。一方面造就了投资者的乐途，另一方面也让初购者的处境日益艰难。因此，如何找到物美价廉而又适合华人投资的地产热点，也就成了很多人关心的话题，为此涌正总结了一些华人青睐', 'upfile/articleinfo.jsp', 'upfile/2.png', '2017-08-08', '0', '402880115dc0aa44015dc0b0e9b60000', '1', '张三', null);
INSERT INTO `t_article` VALUES ('402880015dbc951e015dbc95cf5c0000', '溢价174%! 一位英国女房东的房产投资生意经', '溢价174%! 一位英国女房东的房产投资生意经', '<table><tbody><tr class=\"firstRow\"><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">是否扫地<br/></td><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">&nbsp;艾佛森大</td><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">啊撒地方官sa</td><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">发斯阿瑟发啥蒂芬</td></tr><tr><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">三大发送到</td><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">sdfsa</td><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">&nbsp;as</td><td width=\"181\" valign=\"top\" style=\"word-break: break-all;\">发斯蒂芬</td></tr></tbody></table><p><br/></p>', 'upfile/articleinfo.jsp', 'upfile/3.png', '2017-09-02', '0', '402880115dc0aa44015dc0b0e9b60000', '1', '张三', null);
INSERT INTO `t_article` VALUES ('402880015e182cad015e185b9efc0004', '七夕大优惠等你来', '8月28日赣州万象城热盘实时报价', '<p>8月28日赣州万象城热盘实时报价8月28日赣州万象城热盘实时报价8月28日赣州万象城热盘实时报价8月28日赣州万象城热盘实时报价</p>', 'upfile/articleinfo.jsp', 'upfile/4.png', '2017-08-25', '0', '402880115dc0cce9015dc0d8a1590002', '402880015e12db27015e12e564140000', '乐兮', null);
INSERT INTO `t_article` VALUES ('4028ab8e5e4f93ee015e4fb61aff002c', '阿发', '阿发', '<p>施工队<br/></p>', 'upfile/1504575888125.html', 'upfile/7093142975475.jpg', '2017-09-05', '0', '402880115dc0aa44015dc0b0e9b60000', '402880125e4cf3c2015e4cfa96860000', 'as', null);

-- ----------------------------
-- Table structure for t_article_type
-- ----------------------------
DROP TABLE IF EXISTS `t_article_type`;
CREATE TABLE `t_article_type` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `des_string` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article_type
-- ----------------------------
INSERT INTO `t_article_type` VALUES ('402880115dc0aa44015dc0b0e9b60000', '通知', '出示各种');
INSERT INTO `t_article_type` VALUES ('402880115dc0cce9015dc0d8a1590002', '公告', '平台的公告');
INSERT INTO `t_article_type` VALUES ('402880125e23110f015e2311b1240000', '22', '撒地方');

-- ----------------------------
-- Table structure for t_building
-- ----------------------------
DROP TABLE IF EXISTS `t_building`;
CREATE TABLE `t_building` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `total_floor_int` int(11) DEFAULT NULL,
  `total_lift_int` int(11) DEFAULT NULL,
  `floor_rooms_int` int(11) DEFAULT NULL,
  `total_room_int` int(11) DEFAULT NULL,
  `buildings_id` varchar(36) DEFAULT NULL,
  `created_time_string` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `jxsid_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_building
-- ----------------------------
INSERT INTO `t_building` VALUES ('1', 'A111', '10', '20', '30', '300', '4028800d5d988e9b015d989116a80000', '2017-08-31 15:31:23', '0', '1');
INSERT INTO `t_building` VALUES ('2', 'S1楼栋1', '18', '20', '12', '216', '1', '2017-08-08 21:13:40', '0', '1');
INSERT INTO `t_building` VALUES ('3', 'S栋1', '18', '20', '12', '216', '1', '2017-07-21 10:25:47', '0', '1');
INSERT INTO `t_building` VALUES ('402880015e187dce015e18a262ed0003', '起点壹中心楼栋', '30', '60', '6', '180', '1', '2017-08-25 17:04:09', '1', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_building` VALUES ('4028800d5d8d6720015d8d67c53d0000', 'A栋', '32', '40', '18', '576', '1', '2017-07-29 16:12:54', '0', '1');
INSERT INTO `t_building` VALUES ('4028800d5d8d6720015d8d6ff4420001', 'B栋', '32', '30', '10', '320', '1', '2017-07-29 16:21:51', '0', '1');
INSERT INTO `t_building` VALUES ('4028800d5d8d715f015d8d72150d0000', 'C栋', '32', '54', '22', '704', '1', '2017-07-29 16:24:10', '0', '1');
INSERT INTO `t_building` VALUES ('4028800d5d8d7308015d8d75b3230001', 'D栋', '21', '11', '21', '441', '402880115dc44675015dc44e41120001', '2017-08-31 15:31:09', '0', '1');
INSERT INTO `t_building` VALUES ('4028800d5d8d79d2015d8db5fc860000', 'FF', '11', '11', '11', '121', '1', '2017-07-29 17:38:20', '0', '1');
INSERT INTO `t_building` VALUES ('4028800d5d961af0015d961bd40c0000', 'S11楼栋', '32', '32', '4', '128', '1', '2017-07-31 08:47:13', '0', '1');
INSERT INTO `t_building` VALUES ('402880115dc44675015dc44eac610002', 'A栋', '4', '20', '4', '16', '1', '2017-08-09 08:04:37', '1', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_building` VALUES ('402880115e264a0b015e264e2abf0000', 'AD栋', '10', '10', '4', '40', '1', '2017-08-28 08:46:51', '0', '1');
INSERT INTO `t_building` VALUES ('402880115e2bc2d6015e2bc30a0c0000', '8栋', '22', '5', '5', '110', '1', '2017-08-29 11:16:22', '0', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_building` VALUES ('4028ab8e5e4d3c9b015e4d403af40000', 'A栋', '32', '64', '2', '64', '402880125e4cf3c2015e4d021e040001', '2017-09-04 22:16:49', '0', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_building` VALUES ('4028ab8e5e4d4118015e4d4561e10000', 'B栋', '24', '48', '2', '48', '402880125e4cf3c2015e4d021e040001', '2017-09-04 22:22:26', '0', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_building` VALUES ('4028ab8e5e4d4118015e4d465bcd0001', 'C栋', '64', '128', '4', '256', '402880125e4cf3c2015e4d021e040001', '2017-09-04 22:23:30', '0', '402880125e4cf3c2015e4cfa96860000');

-- ----------------------------
-- Table structure for t_buildings
-- ----------------------------
DROP TABLE IF EXISTS `t_buildings`;
CREATE TABLE `t_buildings` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `area_string` varchar(50) DEFAULT NULL,
  `address_string` varchar(100) DEFAULT NULL,
  `floor_area_string` double DEFAULT NULL,
  `building_area_string` double DEFAULT NULL,
  `house_type_string` varchar(20) DEFAULT NULL,
  `building_type_string` varchar(20) DEFAULT NULL,
  `longitude_double` double DEFAULT NULL,
  `latitude_double` double DEFAULT NULL,
  `avg_price_double` double DEFAULT NULL,
  `company_string` varchar(100) DEFAULT NULL,
  `open_date` datetime DEFAULT NULL,
  `total_rooms_int` int(11) DEFAULT NULL,
  `reception_address_string` varchar(100) DEFAULT NULL,
  `tel_string` varchar(11) DEFAULT NULL,
  `green_ratio_double` double DEFAULT NULL,
  `plot_ratio_double` double DEFAULT NULL,
  `property_company` varchar(100) DEFAULT NULL,
  `property_fee_double` double DEFAULT NULL,
  `car_station_int` int(11) DEFAULT NULL,
  `traffic_string` text,
  `equipments_string` text,
  `logo_string` varchar(500) DEFAULT NULL,
  `intro_string` varchar(500) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `jxsid_string` varchar(36) NOT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_buildings
-- ----------------------------
INSERT INTO `t_buildings` VALUES ('1', '泰禾院子系', '章江新区橙乡大道26号', '上海章江新区橙乡大道26号', '1000', '5000', '写字楼', '别墅', '114.914122', '25.808312', '9000', '航宇有限公司', '2017-07-12 15:01:31', '112', '章江新区橙乡大道26号', '18174099439', '10', '4', '江西嘉福房地产经营管理有限公司', '300', '300', '南门口乘坐28路到中央生态公园下车，再沿章江路走约300米，到江边即到。', '嘉福金融中心', 'upfile/26468241810197.jpg', '嘉福金融中心项目位于赣州章江新区金融商务区，由一栋酒店、一栋写字楼及6栋39层住宅组成。总用地面积54412.8㎡，总建筑面积269960.86㎡，其中商业裙楼面积12429.33㎡，酒店及公寓式酒店建筑面积37989.7㎡，写字楼建筑面积26252.45㎡；容积率3.69；建筑密度31.56%；住宅总户数874户。', '2017-07-02 15:10:05', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d87a091015d87fdc9fd0004', '大宁金茂府', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区赣县路', '4000', '3000', '写字楼', '钟塔楼', '114.939271', '25.840334', '111111', '1111', '2017-07-28 14:56:39', '1111', '111111', '15679760329', '10', '1', '发过的', '2000', '1111', '便捷', '配套完好', 'upfile/29793982770924.jpg', '精美套房', '2017-07-28 14:56:39', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d8bd60f015d8bd988230000', '苏州桃花源', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区', '20000', '12000', '写字楼', '钟塔楼', '114.978295', '25.852559', '3000', '群成', '2017-07-29 08:56:05', '2000', '江西赣州', '15679760329', '10', '11', '中通', '3000', '222', '222', '良好', 'upfile/29815388546229.jpg', '卡塞到福建省来看待', '2017-07-29 08:56:05', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d8d093f015d8d0aa1920000', '锦绣', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区赣康路', '2000', '1000', '住宅', '板房', '114.914122', '25.808312', '3000', '群成', '2017-07-29 14:29:50', '2000', '江西赣州', '15679760329', '10', '11', '中通', '3000', '222', '222', '良好', 'upfile/29837618691466.jpg', '精美套房', '2017-07-29 14:29:50', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d920b51015d923ac6530000', '景秀', '安徽省-蚌埠市-五河县', '江西省赣州市章贡区钨都大道', '6000', '3000', '商业', '板房', '114.932783', '25.848287', '6000', '雷克萨就', '2017-07-04 00:00:00', '6000', '江西赣州', '15679760320', '10', '1', '顺丰快递', '3000', '300', '良好', '良好', 'upfile/29874274509034.jpg', '精美套房', '2017-07-30 14:34:00', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d988e9b015d989116a80000', '红树林', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区', '30000', '19000', '写字楼', '钟塔楼', '114.95926', '25.809183', '3000', '千红', '2017-07-25 00:00:00', '3000', '江西赣州', '15679760329', '10', '30', '顺丰', '3000', '3000', '良好', '良好', 'upfile/29890804587617.jpg', '精美套房', '2017-07-31 20:11:58', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d988e9b015d9894d0c80001', '红古轩', '澳门-澳门', '江西省赣州市章贡区五洲大道15号', '20000', '16000', '工业', '欧美风格', '114.968239', '25.829141', '3000', '千红', '2017-07-26 00:00:00', '2999', '江西赣州', '15679760329', '10', '30', '顺丰', '3000', '3000', '良好', '良好', 'upfile/29856597112407.jpg', '良好', '2017-07-31 20:16:25', '0', '1');
INSERT INTO `t_buildings` VALUES ('4028800d5d988e9b015d9898902c0002', '海城', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区', '3000', '2000', '写字楼', '钟塔楼', '114.945296', '25.846763', '6000', '千红', '2017-07-26 00:00:00', '3000', '江西赣州', '15679760329', '10', '20', '顺丰', '3000', '3000', '良好', '良好', 'upfile/29874274509034.jpg', '良好', '2017-07-31 20:20:39', '0', '1');
INSERT INTO `t_buildings` VALUES ('402880115dc44675015dc44e41120001', '玖龙', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区章江南大道', '3000', '24000', '写字楼', '钟塔楼', '114.937095', '25.845621', '6000', '玖龙', '2017-08-09 00:00:00', '3000', '江西赣州', '15679760329', '10', '1', '中通', '3000', '3000', '好', '好', 'upfile/29837618691466.jpg', '号', '2017-08-09 08:02:51', '0', '1');
INSERT INTO `t_buildings` VALUES ('402880115deed196015deedd934a0000', '兴盛楼盘', '江西省-赣州市-章贡区', '江西省赣州市章贡区红都大道', '3000', '2000', '写字楼', '钟塔楼', '114.940694', '25.810509', '4000', '兴盛开发公司', '2017-08-24 00:00:00', '3000', '章贡区', '15679760329', '10', '1', '中通', '300', '300', '良好', '良好', 'upfile/29815388546229.jpg', 'IAO', '2017-08-17 14:22:56', '0', '1');
INSERT INTO `t_buildings` VALUES ('402880115e04db00015e04e29add0000', '飞蝗', '安徽省-蚌埠市-淮上区', '江西省赣州市章贡区', '3000', '2000', '写字楼', '钟塔楼', '114.923325', '25.823228', '6900', '飞蝗有限公司', '2017-08-23 00:00:00', '3000', '江西赣州', '15679760329', '10', '1', '飞蝗物业', '300', '300', '良好', '良好', 'upfile/29771394362107.jpg', '良好', '2017-08-21 21:00:10', '0', '1');
INSERT INTO `t_buildings` VALUES ('402880115e2b841b015e2b9690e9000c', '风陵渡口', '江西省-赣州市-章贡区', '江西省赣州市章贡区稼轩路', '8000', '50000', '写字楼', '钟塔楼', '114.936439', '25.851474', '8888', '阁下集团', '2017-08-29 00:00:00', '800', '九方购物中心', '12456712347', '10', '500', '天鸽物业', '800', '600', '畅通', '汽车站', 'upfile/29890804587617.jpg', '天鸽帕克 ', '2017-08-29 09:20:00', '0', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings` VALUES ('402880115e2bc2d6015e2bf96a450004', '广寒宫', '江西省-赣州市-章贡区', '江西省赣州市章贡区文明大道54-15', '999999', '10000', '写字楼', '钟塔楼', '114.948952', '25.851018', '8888', '南天门', '2017-08-28 00:00:00', '2', '凌霄宝殿', '52199521992', '10', '1', '天兵天将', '1', '2', '特别特别畅通', '滇池', 'upfile/29793982770924.jpg', '两个人的楼盘，为您专业定制', '2017-08-29 11:07:36', '0', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings` VALUES ('402880125e4cf3c2015e4d021e040001', '天虹楼盘', '江西省-抚州市-南丰县', '江西省南昌市东湖区阳明路38号', '9000', '4000', '住宅', '钟塔楼', '115.90578', '28.69338', '6000', '天虹速递', '2017-09-04 00:00:00', '300', '江西赣州章贡区', '18296652908', '10', '1', '天虹快递', '600', '600', '便捷', '交通便捷，工具齐全', 'upfile/6662705002605.jpg', '楼盘位于赣州的新城区，有赣州第一楼盘的称号，布局和装修堪称绝美', '2017-09-04 21:04:08', '0', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings` VALUES ('402880c15e371366015e37297e540001', '广寒宫殿', '江西省-赣州市-章贡区', '江西省赣州市章贡区', '500', '400000', '写字楼', '钟塔楼', '114.976241', '25.852805', '8888', '南天门', '2017-08-28 00:00:00', '999', '凌霄宝殿', '52152152152', '10', '1', '天兵天将', '666', '888', '特别特别畅通', '滇池傍身', 'upfile/29019810445153.jpg', '专业打造二人世界，七夕单身狗专享楼盘', '2017-08-31 15:16:58', '0', '1');

-- ----------------------------
-- Table structure for t_buildings_img
-- ----------------------------
DROP TABLE IF EXISTS `t_buildings_img`;
CREATE TABLE `t_buildings_img` (
  `id_string` varchar(36) NOT NULL,
  `img_path_string` varchar(500) DEFAULT NULL,
  `img_des_string` varchar(50) DEFAULT NULL,
  `buildings_id_string` varchar(36) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_buildings_img
-- ----------------------------
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476a57000f', 'upfile/47439103958877.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:24', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476bc30010', 'upfile/47465268986577.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476cee0011', 'upfile/47487439379760.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476dbe0012', 'upfile/47487922160345.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476e880013', 'upfile/47517259554870.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476ef60014', 'upfile/47517397076545.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476f3d0015', 'upfile/47517521723354.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:26', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e193bf9015e19476f6e0016', 'upfile/47517730954859.jpg', '楼盘图片', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 20:04:26', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926665000f', 'upfile/11151670100708.JPG', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:22', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e2692691e0010', 'upfile/11152558100095.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:23', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e269269c40011', 'upfile/11152841891572.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:23', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926a390012', 'upfile/11153262949955.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:23', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926b1b0013', 'upfile/11153475805638.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:23', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926bdb0014', 'upfile/11154250986955.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:24', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926c320015', 'upfile/11155751262559.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:24', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926c8a0016', 'upfile/11156708037578.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:24', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926cf40017', 'upfile/11157023547459.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:24', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926d510018', 'upfile/11158018917419.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:24', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26926f1f0019', 'upfile/11158343351704.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26927100001a', 'upfile/11159715103688.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26927200001b', 'upfile/11160194674215.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e2692729e001c', 'upfile/11160574873653.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:25', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e26927301001d', 'upfile/11160885758323.JPG', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:26', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e269273b2001e', 'upfile/11161034283068.JPG', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:26', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e266302015e2692746f001f', 'upfile/11161156676368.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-28 10:01:26', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2baf77015e2bafe0170000', 'upfile/10607535314548.jpg', '楼盘图片', '402880115e2b841b015e2b9690e9000c', '2017-08-29 09:51:40', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_buildings_img` VALUES ('402880115e2bb533015e2bb7a68b0000', 'upfile/11115633117739.jpg', '楼盘图片', '402880115e2b841b015e2b9690e9000c', '2017-08-29 10:00:10', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_buildings_img` VALUES ('402880115e2bb533015e2bb7a7d40001', 'upfile/11116046520768.jpg', '楼盘图片', '402880115e2b841b015e2b9690e9000c', '2017-08-29 10:00:10', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_buildings_img` VALUES ('402880115e2bba93015e2bbb66900000', 'upfile/11361511343267.jpg', '楼盘图片', '402880115e2b841b015e2b9690e9000c', '2017-08-29 10:04:15', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_buildings_img` VALUES ('402880115e2bbd12015e2bbdad080001', 'upfile/11511691711388.jpg', '楼盘图片', '402880115e2b841b015e2b9690e9000c', '2017-08-29 10:06:44', '402880115e2b678d015e2b69b32c0000');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db9101b0002', 'upfile/44757480484581.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:57', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db910fd0003', 'upfile/44757680106402.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:57', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db912330004', 'upfile/44757833855865.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:57', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db912a10005', 'upfile/44757985622060.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:57', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db912fc0006', 'upfile/44758160618755.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:57', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db913e80007', 'upfile/44758347056824.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db9143d0008', 'upfile/44758484907541.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db914de0009', 'upfile/44758696064918.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db91515000a', 'upfile/44758874588026.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db9155e000b', 'upfile/44759104037354.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db915b8000c', 'upfile/44759651817210.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db91631000d', 'upfile/44760231386711.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db9165d000e', 'upfile/44760383047253.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db916ce000f', 'upfile/44760687138098.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db917250010', 'upfile/44760962108410.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db917710011', 'upfile/44761169806992.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:58', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db9179f0012', 'upfile/44761448854926.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:59', '1');
INSERT INTO `t_buildings_img` VALUES ('402880115e2daaff015e2db918030013', 'upfile/44761615419260.jpg', '楼盘图片', '4028800d5d988e9b015d989116a80000', '2017-08-29 19:20:59', '1');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44918000b', 'upfile/6963070600544.JPG', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb449b2000c', 'upfile/6963956259769.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44a0b000d', 'upfile/6964295083699.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44a85000e', 'upfile/6964490286757.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44abb000f', 'upfile/6964648338784.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44b0c0010', 'upfile/6964999798351.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44b460011', 'upfile/6965149966764.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44b8f0012', 'upfile/6965311758345.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:49', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44c160013', 'upfile/6965641342061.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44c830014', 'upfile/6965742639072.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44cfe0015', 'upfile/6966094645023.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44d4a0016', 'upfile/6966102246691.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44dcf0017', 'upfile/6966234604826.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44e330018', 'upfile/6966582796358.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44eb80019', 'upfile/6967014165510.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44ef1001a', 'upfile/6967178665460.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44f34001b', 'upfile/6967303192507.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:50', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44f8a001c', 'upfile/6967717552541.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb44fce001d', 'upfile/6968117783894.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb4504b001e', 'upfile/6969068465122.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb4508a001f', 'upfile/6969087350657.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb450bb0020', 'upfile/6969115243967.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb450ee0021', 'upfile/6969559761933.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb451240022', 'upfile/6969711948039.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb451520023', 'upfile/6969873489069.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb451880024', 'upfile/6970026271065.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb451b60025', 'upfile/6970165528116.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb451e70026', 'upfile/6970328288094.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb452300027', 'upfile/6970361682666.JPG', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb452660028', 'upfile/6970448017233.JPG', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb4529f0029', 'upfile/6970493942392.JPG', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb45308002a', 'upfile/6970766958855.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:51', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('4028ab8e5e4f93ee015e4fb453f2002b', 'upfile/6970872188617.jpg', '楼盘图片', '402880125e4cf3c2015e4d021e040001', '2017-09-05 09:42:52', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_buildings_img` VALUES ('ff8080815e401b13015e401cda150000', 'upfile/4225088984977.jpg', '楼盘图片', '4028800d5d988e9b015d9898902c0002', '2017-09-02 09:03:06', '1');
INSERT INTO `t_buildings_img` VALUES ('ff8080815e401b13015e401cdac40001', 'upfile/4225172388998.jpg', '楼盘图片', '4028800d5d988e9b015d9898902c0002', '2017-09-02 09:03:06', '1');
INSERT INTO `t_buildings_img` VALUES ('ff8080815e401b13015e401cdb090002', 'upfile/4225207262125.jpg', '楼盘图片', '4028800d5d988e9b015d9898902c0002', '2017-09-02 09:03:07', '1');
INSERT INTO `t_buildings_img` VALUES ('ff8080815e401b13015e401cdb600003', 'upfile/4225530629753.jpg', '楼盘图片', '4028800d5d988e9b015d9898902c0002', '2017-09-02 09:03:07', '1');
INSERT INTO `t_buildings_img` VALUES ('ff8080815e401b13015e401cdbb90004', 'upfile/4225654413598.jpg', '楼盘图片', '4028800d5d988e9b015d9898902c0002', '2017-09-02 09:03:07', '1');
INSERT INTO `t_buildings_img` VALUES ('ff8080815e401b13015e401cdbfa0005', 'upfile/4225895396918.jpg', '楼盘图片', '4028800d5d988e9b015d9898902c0002', '2017-09-02 09:03:07', '1');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id_string` varchar(36) NOT NULL,
  `content_string` text,
  `buildings_id_string` varchar(36) DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '1', '2017-07-26 11:02:56', '402880015e3ae165015e3b1d827b0000', '0');
INSERT INTO `t_comment` VALUES ('10', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '402880115deed196015deedd934a0000', '2017-07-26 11:02:56', '402880015e3ae165015e3b1d827b0000', '0');
INSERT INTO `t_comment` VALUES ('11', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '402880115e04db00015e04e29add0000', '2017-07-26 11:02:56', '402880015e3ae165015e3b1d827b0000', '0');
INSERT INTO `t_comment` VALUES ('12', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '402880115e2b841b015e2b9690e9000c', '2017-07-26 11:02:56', '402880015e3ae165015e3b1d827b0000', '0');
INSERT INTO `t_comment` VALUES ('13', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '402880115e2bc2d6015e2bf96a450004', '2017-07-26 11:02:56', '1', '0');
INSERT INTO `t_comment` VALUES ('14', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '402880c15e371366015e37297e540001', '2017-07-26 11:02:56', '1', '0');
INSERT INTO `t_comment` VALUES ('2', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d87a091015d87fdc9fd0004', '2017-07-26 11:02:56', '1', '0');
INSERT INTO `t_comment` VALUES ('3', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d8bd60f015d8bd988230000', '2017-07-26 11:02:56', '402880115da5d162015da5d2edfa0003', '0');
INSERT INTO `t_comment` VALUES ('4', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d8d093f015d8d0aa1920000', '2017-07-26 11:02:56', '402880115da5d162015da5d2edfa0003', '0');
INSERT INTO `t_comment` VALUES ('402880115e1d268b015e1d2e4b480000', '挺好', '2', '2017-08-26 14:15:27', '402880115da5d162015da5d2edfa0003', '0');
INSERT INTO `t_comment` VALUES ('402880115e1d2ef4015e1d30f7110000', '挺好', '2', '2017-08-26 14:18:22', '402880115e1bd9c5015e1bf331dc0000', '0');
INSERT INTO `t_comment` VALUES ('402880115e1d2ef4015e1d31d78f0001', '挺好', '2', '2017-08-26 14:19:19', '402880115e1bd9c5015e1bf331dc0000', '0');
INSERT INTO `t_comment` VALUES ('5', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d920b51015d923ac6530000', '2017-07-26 11:02:56', '402880115e1bd9c5015e1bf331dc0000', '0');
INSERT INTO `t_comment` VALUES ('6', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d988e9b015d989116a80000', '2017-07-26 11:02:56', '402880115e1c4429015e1c488c5f0000', '0');
INSERT INTO `t_comment` VALUES ('7', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d988e9b015d9894d0c80001', '2017-07-26 11:02:56', '402880115e1c4429015e1c488c5f0000', '0');
INSERT INTO `t_comment` VALUES ('8', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d988e9b015d9898902c0002', '2017-07-26 11:02:56', '402880115e1c4429015e1c488c5f0000', '0');
INSERT INTO `t_comment` VALUES ('9', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '402880115dc44675015dc44e41120001', '2017-07-26 11:02:56', '402880115e36e320015e36f2d10c0000', '0');
INSERT INTO `t_comment` VALUES ('qaz', '涌正的客户咨询中，经常有客户问到我们这个话题：是否需要去实地看一下心仪的房产？当然，这是根据客户个人的情况而决定的。不过就实际情况而言，我们的很多客户都是看着图纸买房的，尤其是在曼彻斯特和利...', '4028800d5d8bd60f015d8bd988230000', '2017-07-26 11:02:56', '402880115e477bda015e477ff6980000', '0');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id_string` varchar(36) NOT NULL,
  `name_string` text,
  `headicon_string` varchar(36) DEFAULT NULL,
  `gender_string` varchar(2) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `identity_id_string` varchar(18) DEFAULT NULL,
  `email_string` varchar(50) DEFAULT NULL,
  `phone_string` varchar(11) DEFAULT NULL,
  `address_string` varchar(100) DEFAULT NULL,
  `customer_type_string` int(20) DEFAULT NULL,
  `together_string` varchar(100) DEFAULT NULL,
  `contract_string` varchar(500) DEFAULT NULL,
  `archives_string` varchar(500) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `employee_id` varchar(36) DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('402880015d985cef015d98612bf50000', '钟明旭', 'images/people.gif', '男', '1885-12-10 00:00:00', '360826188512103821', '1654905413@qq.com', '18296652902', '江西吉安', '1', '无', '', '5.jpg', '2017-07-31 19:21:31', '0', '402880015dac5e2a015dac6173730001', '1');
INSERT INTO `t_customer` VALUES ('402880015d985cef015d9862889a0001', '苏莎', 'images/people.gif', '女', '1990-10-10 00:00:00', '360826199010103826', '1654905413@qq.com', '18296652903', '江西省赣州市章贡区', '2', '留小勇', '', '7.jpg', '2017-07-31 19:23:01', '0', '402880015dac5401015dac5a01550000', '1');
INSERT INTO `t_customer` VALUES ('402880015d988bbb015d988e45a70000', '钟明', 'images/people.gif', '男', '1885-12-12 00:00:00', '360826188512123826', '1654905415@qq.com', '18296652904', '江西吉安泰和县', '1', '曾小丹', '', '3.jpg', '2017-07-31 20:10:47', '0', '402880015dac5401015dac5a01550000', '1');
INSERT INTO `t_customer` VALUES ('402880015d989ea2015d98a081350000', '魏薇', 'images/people.gif', '女', '1990-08-05 00:00:00', '36082619900805', '1654905416@qq.com', '15007964533', '江西省赣州市章贡区', '1', '无', '', '7.jpg', '2017-07-31 20:30:42', '0', '402880115dba500a015dba50f01e0000', '1');
INSERT INTO `t_customer` VALUES ('402880115e2d149a015e2d1696b30000', '夏菲', 'images/people.gif', '女', '2017-05-08 00:00:00', '12365479889546525', '1654905415@qq.com', '18296652908', '北京市北京市海淀区', '1', null, 'upfile/47936289334968.jpg', null, '2017-08-29 16:23:29', '0', '402880015dac5401015dac5a01550000', '1');
INSERT INTO `t_customer` VALUES ('402880115e37235c015e372595e60000', '陈飞龙', 'images/people.gif', '男', null, '360730199712200617', '275300091@qq.com', '15679760320', '北京市北京市西城区广安门外大街504号', '2', '陈飞龙', 'upfile/23268105497854.png', null, '2017-08-31 15:16:04', '0', '402880015dac5401015dac5a01550000', '1');
INSERT INTO `t_customer` VALUES ('402880115e4787a0015e4795227c0004', '陈飞龙', 'images/people.gif', '男', null, '360730199712200617', '275300091@qq.com', '15679760329', '江西省赣州市章贡区登峰大道', '1', '陈飞龙', null, null, '2017-09-03 19:51:50', '0', '402880115dba500a015dba5c198a0001', '1');
INSERT INTO `t_customer` VALUES ('4028ab8e5e4f93ee015e4fa72cdb0005', '张三', 'images/people.gif', '男', null, '360730199712200612', '275300091@QQ.COM', '17370134036', '北京市北京市丰台区', '2', '张三', null, null, '2017-09-05 09:28:30', '0', '402880015dac5401015dac5a01550000', '1');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `email_string` varchar(50) DEFAULT NULL,
  `pwd_string` varchar(50) DEFAULT NULL,
  `phone_string` varchar(11) DEFAULT NULL,
  `qq_string` varchar(20) DEFAULT NULL,
  `wechat_string` varchar(50) DEFAULT NULL,
  `gender_string` varchar(2) DEFAULT NULL,
  `exp_string` varchar(50) DEFAULT NULL,
  `des_string` varchar(100) DEFAULT NULL,
  `address_string` varchar(100) DEFAULT NULL,
  `basic_salary_double` double DEFAULT NULL,
  `headicon_string` varchar(500) DEFAULT NULL,
  `intro_string` varchar(500) DEFAULT NULL,
  `angency_id_string` varchar(36) DEFAULT NULL,
  `building_id_string` varchar(36) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `type_int` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('402880015dac5401015dac5a01550000', '刘小凤', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '18174099381', '1654905415', '18174099383', '女', '无', '积极向上 认真负责', '江西赣州', '3500', 'images/people.gif', '积极向上 认真负责', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-04 16:26:06', '0', '1');
INSERT INTO `t_employee` VALUES ('402880015dac5e2a015dac5f7bbd0000', '张小勇', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '18174099383', '1654905415', '18174099381', '男', '无', '积极向上 认真负责', '江西吉安', '3500', 'images/people.gif', '积极向上 认真负责', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-04 16:32:05', '0', '1');
INSERT INTO `t_employee` VALUES ('402880015dac5e2a015dac6173730001', '胡八一', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '13237675702', '1654905415', '15679760329', '男', '拥有丰富的开发经验', '积极向上 认真负责', '江西赣州', '3500', 'images/people.gif', '积极向上 认真负责', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-04 16:34:14', '1', '1');
INSERT INTO `t_employee` VALUES ('402880015e182cad015e18587ced0003', '张强', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '13237675700', '237865490', '237865490', '男', '工作5年', '经验丰富', '江西省赣州市章贡区', '3500', 'images/people.gif', '经验丰富  和同事友好相处', '402880115e2b678d015e2b69b32c0000', '-1', '2017-08-25 15:43:26', '0', '1');
INSERT INTO `t_employee` VALUES ('402880115dba500a015dba50f01e0000', '陈飞龙', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '15679760329', '275300091', 'xljx_888888', '男', 'asdfa', null, '江西省赣州市章贡区赣康路', '8000', 'images/people.gif', 'asdfas', '1', '402880115dc44675015dc44e41120001', '2017-08-07 09:30:53', '0', '0');
INSERT INTO `t_employee` VALUES ('402880115dba500a015dba5c198a0001', '天穹', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '15679760322', '275300091', 'xljx_888888', '男', '16456556', '16456556', '江西省赣州市南康市府后路', '8000', 'images/people.gif', '16456556', '1', '402880115deed196015deedd934a0000', '2017-08-07 09:43:04', '1', '0');
INSERT INTO `t_employee` VALUES ('402880115e2bc2d6015e2c01f2710005', '少昊', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '15679760320', '1234321234', '12345678', '男', '', '', '', '2500', 'images/people.gif', '', '402880115e2b678d015e2b69b32c0000', '402880115e2b841b015e2b9690e9000c', '2017-08-29 11:21:19', '0', '2');
INSERT INTO `t_employee` VALUES ('402880125dc2002b015dc20189fc0000', '王五', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '15679760323', '11', '111', '男', '11', '111', '', '11', 'images/people.gif', '11111', '1', '4028800d5d8d093f015d8d0aa1920000', '2017-08-08 21:21:07', '1', '1');
INSERT INTO `t_employee` VALUES ('402880c15e371366015e371deb580000', '王胖子', '275300091@qq.com', '05868E10ED7CBB988E7821FAD2B75941', '17607975702', '1231312', '12345678', '男', '', '', '江西省赣州市章贡区摊儿上路', '2222', 'images/people.gif', '', '1', '4028800d5d988e9b015d9898902c0002', '2017-08-31 15:07:41', '0', '2');

-- ----------------------------
-- Table structure for t_employeesalary
-- ----------------------------
DROP TABLE IF EXISTS `t_employeesalary`;
CREATE TABLE `t_employeesalary` (
  `salary_id_string` varchar(36) NOT NULL,
  `emoloyee_id_string` varchar(36) DEFAULT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  `salary_double` double DEFAULT NULL,
  `reason` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`salary_id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employeesalary
-- ----------------------------

-- ----------------------------
-- Table structure for t_getprize
-- ----------------------------
DROP TABLE IF EXISTS `t_getprize`;
CREATE TABLE `t_getprize` (
  `id_string` varchar(36) NOT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  `prize_name_string` varchar(20) DEFAULT NULL,
  `prize_type_int` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_getprize
-- ----------------------------
INSERT INTO `t_getprize` VALUES ('402880115e1233a5015e1237fde10000', '17607975702', '购房送购房基金3000', '0', '2017-08-24 11:10:13');
INSERT INTO `t_getprize` VALUES ('402880115e123999015e123a6ca10001', '15007964533', '购房送oppoR11一部', '1', '2017-08-24 11:12:52');
INSERT INTO `t_getprize` VALUES ('4028ab8e5e4f6104015e4f69ed740001', '15679760329', '购房送ipad一部', '0', '2017-09-05 08:21:36');
INSERT INTO `t_getprize` VALUES ('4028ab8e5e4f93ee015e4fae96aa0009', '17370134036', '看房下午茶', '0', '2017-09-05 09:36:35');

-- ----------------------------
-- Table structure for t_history
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id_string` varchar(36) NOT NULL,
  `user_id_string` varchar(50) DEFAULT NULL,
  `buildings_id_string` varchar(36) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `ip_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_history
-- ----------------------------
INSERT INTO `t_history` VALUES ('402880015e0e0b97015e0e5190480000', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-23 16:59:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e0e0b97015e0e5540780003', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-23 17:03:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e11edbf015e1201d8420000', '1', '4028800d5d988e9b015d989116a80000', '2017-08-24 10:11:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e12fcde015e13010a4e0000', '402880115da5d162015da5d2edfa0012', '4028800d5d8bd60f015d8bd988230000', '2017-08-24 14:49:49', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e12fcde015e130110190001', '402880115da5d162015da5d2edfa0012', '4028800d5d8bd60f015d8bd988230000', '2017-08-24 14:49:50', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e16d0f1015e16e6239a0001', '1', '1', '2017-08-25 08:58:55', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e16d0f1015e16e69a160002', '1', '1', '2017-08-25 08:59:25', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e16d0f1015e171b288f0004', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 09:56:49', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e16d0f1015e172f28150005', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 10:18:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e16d0f1015e173330310007', '1', '1', '2017-08-25 10:23:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e16d0f1015e1735437c0008', '1', '402880115e04db00015e04e29add0000', '2017-08-25 10:25:20', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e182cad015e182d5a130000', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 14:56:19', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e182cad015e187a01ff0007', '1', '4028800d5d8bd60f015d8bd988230000', '2017-08-25 16:20:03', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e187dce015e18a3cca60004', '1', '402880015e182cad015e1852ba340002', '2017-08-25 17:05:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e19212d015e192cf2ab0000', '1', '4028800d5d8bd60f015d8bd988230000', '2017-08-25 19:35:30', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e19212d015e192cf7f30001', '1', '402880015e182cad015e1852ba340002', '2017-08-25 19:35:31', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880015e4042c6015e4043c8e60000', '1', '402880115e04db00015e04e29add0000', '2017-09-02 09:45:38', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115de99956015de9a30b820000', '402880015da1c880015da1d2c50c0000', '4028800d5d87a091015d87fdc9fd0004', '2017-01-16 14:02:43', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115de9b21c015de9b2ef5f0000', '402880015da1c880015da1d2c50c0000', '4028800d5d87a091015d87fdc9fd0004', '2017-02-16 14:20:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115de9b582015de9b6570e0000', '402880015da1c880015da1d2c50c0000', '4028800d5d87a091015d87fdc9fd0004', '2017-05-16 14:23:47', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115df882e6015df88462f10000', '402880115da5d162015da5d2edfa0000', '402880115deed196015deedd934a0000', '2017-06-19 11:23:32', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115df882e6015df88537c50002', '402880115da5d162015da5d2edfa0000', '402880115deed196015deedd934a0000', '2017-08-19 11:24:26', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e0f21f2015e0f22763d0000', '402880115da5d162015da5d2edfa0012', '4028800d5d8bd60f015d8bd988230000', '2017-08-23 20:47:50', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e13075c015e130f2e760006', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-24 15:05:16', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e183301015e183f4d450000', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:15:55', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e1841795a0000', '402880115da5d162015da5d2edfa0003', '4028800d5d8bd60f015d8bd988230000', '2017-08-25 15:18:18', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e185126e70001', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:35:25', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e18536a530002', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:37:53', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e1853841e0003', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:38:00', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e1853c6cf0004', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:38:17', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e18540d230005', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:38:35', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e185444980006', '402880115da5d162015da5d2edfa0003', '2', '2017-08-25 15:38:49', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1840a0015e185d0aa50007', '402880115da5d162015da5d2edfa0003', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 15:48:24', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e186308400000', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:54:57', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e186583b70001', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:57:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e1865b4960002', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:57:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e1865c3bb0003', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:57:56', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e1865e4500004', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:58:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e1866293d0005', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:58:22', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e186682d30006', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:58:45', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e1867b1ea0007', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:00:03', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1860dc015e186857190008', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:00:45', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1868ff015e186aa0f50000', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:03:15', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1868ff015e186b49120001', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:03:58', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1868ff015e186b864b0002', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:04:14', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1868ff015e186ba8ac0003', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:04:22', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e186d02015e1873cf560000', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 16:13:16', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e1bd9c5015e1bfc8cf90002', '402880115e1bd9c5015e1bf331dc0000', '1', '2017-08-26 08:41:30', '192.168.0.205');
INSERT INTO `t_history` VALUES ('402880115e1c31e7015e1c3339420000', '402880115da5d162015da5d2edfa0002', '402880015e182cad015e1852ba340002', '2017-08-26 09:41:13', '192.168.0.205');
INSERT INTO `t_history` VALUES ('402880115e263a90015e263d4b190000', '402880115da5d162015da5d2edfa0003', '4028800d5d8bd60f015d8bd988230000', '2017-08-28 08:28:25', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e263a90015e263fd35c0001', '402880115da5d162015da5d2edfa0003', '1', '2017-08-28 08:31:11', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e263a90015e26401af70002', '402880115da5d162015da5d2edfa0003', '3', '2017-08-28 08:31:29', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e263a90015e26424ee60003', '402880115da5d162015da5d2edfa0003', '2', '2017-08-28 08:33:53', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e264a0b015e2660c4d10002', '1', '4028800d5d8bd60f015d8bd988230000', '2017-08-28 09:07:10', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e266302015e2681083d0008', '1', '1', '2017-08-28 09:42:24', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e268c7826000b', '1', '2', '2017-08-28 09:54:54', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e269389850020', '1', '402880115e266302015e268ebc1d000d', '2017-08-28 10:02:37', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e26b54ff40027', '402880115da5d162015da5d2edfa0001', '402880115e266302015e268607380009', '2017-08-28 10:39:30', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e26b5d0e30028', '402880115da5d162015da5d2edfa0001', '402880115e266302015e268607380009', '2017-08-28 10:40:03', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e26b639f00029', '402880115da5d162015da5d2edfa0001', '402880115e266302015e268607380009', '2017-08-28 10:40:30', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e26b658ea002b', '402880115da5d162015da5d2edfa0001', '4028800d5d988e9b015d9898902c0002', '2017-08-28 10:40:38', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e26b6d0f6002c', '402880115da5d162015da5d2edfa0002', '4', '2017-08-28 10:41:09', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e2782fd38002d', '1', '3', '2017-08-28 14:24:09', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e266302015e278f8b52002e', '1', '4028800d5d988e9b015d9898902c0002', '2017-08-28 14:37:52', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e279893015e27a114930000', '402880115da5d162015da5d2edfa0003', '1', '2017-08-28 14:57:02', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e279893015e27a1dcca0001', '402880115da5d162015da5d2edfa0003', '4028800d5d8d093f015d8d0aa1920000', '2017-08-28 14:57:53', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e279893015e27a2379e0002', '402880115e1bd9c5015e1bf331dc0000', '4028800d5d87a091015d87fdc9fd0004', '2017-08-28 14:58:16', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e288d67015e288d85140000', '402880115da5d162015da5d2edfa0003', '4', '2017-08-28 19:15:17', '192.168.0.205');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b85cd6e0001', '402880115e27ae60015e27bf99a40001', '2', '2017-08-29 09:05:43', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8639fd0002', '402880115e27ae60015e27bf99a40001', '4028800d5d988e9b015d9898902c0002', '2017-08-29 09:06:11', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b86d5fe0003', '402880115e27ae60015e27bf99a40001', '4028800d5d988e9b015d989116a80000', '2017-08-29 09:06:50', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8702e90004', '402880115e27ae60015e27bf99a40001', '4', '2017-08-29 09:07:02', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8853470005', '402880115e27ae60015e27bf99a40001', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 09:08:28', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8868610006', '402880115e27ae60015e27bf99a40001', '402880115deed196015deedd934a0000', '2017-08-29 09:08:34', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8a9a850007', '402880115e27ae60015e27bf99a40001', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 09:10:57', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8e41fd0009', '402880115e27ae60015e27bf99a40001', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 09:14:57', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8e7f90000a', '402880115e27ae60015e27bf99a40001', '402880115e04db00015e04e29add0000', '2017-08-29 09:15:13', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2b841b015e2b8ef100000b', '402880115e27ae60015e27bf99a40001', '4028800d5d988e9b015d989116a80000', '2017-08-29 09:15:42', '192.168.0.65');
INSERT INTO `t_history` VALUES ('402880115e2d0685015e2d07e2f80000', '402880115da5d162015da5d2edfa0003', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 16:07:25', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e2d1c91015e2d37e58e0001', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-29 16:59:52', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d6709140000', '1', '1', '2017-08-29 17:51:21', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d6cdb120001', '1', '1', '2017-08-29 17:57:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d6dcfca0002', '1', '1', '2017-08-29 17:58:45', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d6f32f80003', '1', '1', '2017-08-29 18:00:16', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d75ddc50004', '1', '1', '2017-08-29 18:07:33', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d77fc540007', '1', '1', '2017-08-29 18:09:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7afaf70009', '1', '1', '2017-08-29 18:13:08', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7b8f21000a', '1', '1', '2017-08-29 18:13:46', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7bd9ac000b', '1', '1', '2017-08-29 18:14:05', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7c26db0011', '1', '1', '2017-08-29 18:14:25', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7dd5c70012', '1', '1', '2017-08-29 18:16:15', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7f0b600014', '1', '1', '2017-08-29 18:17:34', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7f23ca0016', '1', '1', '2017-08-29 18:17:41', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7f4fab0017', '1', '1', '2017-08-29 18:17:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d7fa1740018', '1', '1', '2017-08-29 18:18:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d80b1af0019', '1', '1', '2017-08-29 18:19:22', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d80c72a001b', '1', '1', '2017-08-29 18:19:28', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d8192090024', '1', '1', '2017-08-29 18:20:20', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2d667b015e2d840d130026', '1', '1', '2017-08-29 18:23:02', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2daaff015e2daf90330000', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-29 19:10:34', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e2daaff015e2dafff880001', '402880115da5d162015da5d2edfa0003', '402880115deed196015deedd934a0000', '2017-08-29 19:11:03', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e332ef9d80000', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 20:47:50', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3330b6580001', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 20:49:44', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e33317cb10002', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 20:50:35', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3331bf340003', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 20:50:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e333da9c70004', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:03:53', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e333df7850005', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:04:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e333f800c0006', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:05:53', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3341edd70007', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:08:32', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334369c90008', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:10:10', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3345278d0009', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:12:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334611f8000a', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:13:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e33472e0d000b', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:14:16', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e33487103000c', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:15:39', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3348fe71000d', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:16:15', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e33497c75000e', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:16:48', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3349c7ec000f', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:17:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334a352e0010', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:17:35', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334ab3f70011', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:18:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334adf920012', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:18:19', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334b10d60013', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:18:31', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334b770c0014', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:18:57', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334bf09b0015', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:19:28', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334d7a750016', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:21:09', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334e05b40017', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:21:45', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e334e7a480018', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:22:15', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3350242a0019', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:24:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3354fba9001a', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:29:21', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e33556d5b001b', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:29:50', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e32fab1015e3355f23f001c', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-30 21:30:24', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e361b14e80000', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:24:58', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e361b9f9e0001', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:25:34', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e361e65fc0002', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:28:35', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e361ea8cc0003', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:28:53', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e3620169b0004', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:30:26', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e362054430005', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:30:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e362086670006', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:30:55', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36211e070007', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:31:34', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36213b0a0008', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:31:41', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e362215050009', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:32:37', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36222447000a', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:32:41', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e362232fb000b', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:32:45', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36224af7000c', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:32:51', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e3622b067000d', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:33:17', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e3622be7a000e', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:33:20', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e3622c977000f', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:33:23', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e3623a30d0010', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:34:19', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e362405740011', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 10:34:44', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e362638950012', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:37:08', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36312e290013', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:49:06', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36360b120014', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:54:25', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e363656240015', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:54:44', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e363716580016', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:55:33', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e36383b4a0017', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:56:48', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e363919020018', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:57:45', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e363970290019', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:58:08', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e363a519f001a', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:59:05', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e3612ac015e363ab86a001b', '1', '402880115e04db00015e04e29add0000', '2017-08-31 10:59:32', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e363d33970000', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:02:14', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e363d92550001', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:02:38', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e363f4b970002', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:04:31', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e363fb3000003', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:04:58', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e364039c60004', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:05:32', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e3641704a0005', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:06:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e36424ba40006', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:07:48', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e3642d0e50007', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:08:22', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e364322780008', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:08:43', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e36432e100009', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:08:46', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e364385af000a', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:09:08', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e363c09015e3643c350000b', '1', '402880115e04db00015e04e29add0000', '2017-08-31 11:09:24', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e36700a015e36727f310000', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 12:00:27', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e36700a015e36738c410001', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-31 12:01:36', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e36e320015e37064cb10001', '402880115e36e320015e36f2d10c0000', '402880115deed196015deedd934a0000', '2017-08-31 14:41:53', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e36e320015e37071a2d0003', '402880115e36e320015e36f2d10c0000', '402880115deed196015deedd934a0000', '2017-08-31 14:42:46', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e376276015e377157c50000', '402880c15e371366015e375f3c520007', '4028800d5d988e9b015d9898902c0002', '2017-08-31 16:38:49', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e477bda015e4786555c0002', '402880115e477bda015e477ff6980000', '402880115e2bc2d6015e2bf96a450004', '2017-09-03 19:35:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e477bda015e478672e80003', '402880115e477bda015e477ff6980000', '402880c15e371366015e37297e540001', '2017-09-03 19:35:47', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e4787a0015e478829b00000', '402880115e477bda015e477ff6980000', '402880115e2bc2d6015e2bf96a450004', '2017-09-03 19:37:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880115e4787a0015e478bdcd50002', '402880115e477bda015e477ff6980000', '402880c15e371366015e37297e540001', '2017-09-03 19:41:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de383cb015de386749f0000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 09:33:46', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de383cb015de38c1b090001', '402880015da1c880015da1d2c50c0000', '4', '2017-02-21 09:39:56', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45524015de455d7130000', '402880015da1c880015da1d2c50c0000', '4028800d5d920b51015d923ac6530000', '2017-09-15 13:20:17', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45741015de4577c2d0000', '402880015da1c880015da1d2c50c0000', '4028800d5d87a091015d87fdc9fd0004', '2017-12-15 13:22:05', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de458cd015de45919350000', '402880015da1c880015da1d2c50c0000', '4028800d5d87a091015d87fdc9fd0004', '2017-06-28 13:23:51', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de459fb015de45a604d0000', '402880015da1c880015da1d2c50c0000', '4028800d5d988e9b015d989116a80000', '2017-04-15 13:25:14', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de459fb015de45abe460001', '402880015da1c880015da1d2c50c0000', '4028800d5d988e9b015d989116a80000', '2017-03-15 13:25:39', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45b84015de45bab900000', '402880015da1c880015da1d2c50c0000', '4028800d5d988e9b015d989116a80000', '2017-08-15 13:26:39', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45b84015de45bf3150001', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-05-15 13:26:58', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45b84015de45c253b0002', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 13:27:10', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45ce0015de45d0b460000', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-11-29 13:28:09', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45ce0015de45d4e8f0001', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-10-15 13:28:27', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45f8f015de45fb74b0000', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 13:31:04', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de45f8f015de45ff66a0001', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 13:31:21', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4613c015de461de890000', '402880015da1c880015da1d2c50c0000', '4028800d5d920b51015d923ac6530000', '2017-08-15 13:33:26', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de462a0015de462c4980000', '402880015da1c880015da1d2c50c0000', '4028800d5d920b51015d923ac6530000', '2017-08-15 13:34:24', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de462a0015de463206d0001', '402880015da1c880015da1d2c50c0000', '4028800d5d920b51015d923ac6530000', '2017-08-15 13:34:48', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de463cb015de46472310000', '402880015da1c880015da1d2c50c0000', '4028800d5d920b51015d923ac6530000', '2017-08-15 13:36:14', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4662b015de466f13c0000', '402880015da1c880015da1d2c50c0000', '4028800d5d988e9b015d9898902c0002', '2017-08-15 13:38:58', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de469b7015de46a15200000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:42:24', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de46aea015de46b11420000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:43:28', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de46aea015de46b88010001', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:43:59', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de46bb6015de46bda7f0000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:44:20', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de46e86015de46f69870000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:48:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de46e86015de470d4d20001', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:49:46', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de473b8015de4743ea00000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:53:30', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de473b8015de474ef610001', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:54:15', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de473b8015de4757cdb0002', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 13:54:51', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de483c2015de4868d400000', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:13:30', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de483c2015de487200f0001', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:14:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de483c2015de4875d190002', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:14:23', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de483c2015de487a6610003', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:14:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de483c2015de488b2920004', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:15:50', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de483c2015de488f3040005', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:16:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de48be9015de48c63ad0000', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:19:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49533050000', '402880015da1c880015da1d2c50c0000', '4028800d5d988e9b015d9898902c0002', '2017-08-15 14:29:29', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de4955eb10001', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:29:41', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de495bff40003', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:30:06', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de4964f0b0005', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:30:42', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de496d96b0006', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:31:18', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de4970b3a0008', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:31:30', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de497c8120009', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:32:19', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de497e50f000b', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:32:26', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de498641d000c', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:32:59', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de498af78000d', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:33:18', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de4991ece000f', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:33:46', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de4999cc20012', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:34:19', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de499e5b90015', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:34:37', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de499f9ae0017', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:34:42', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49a74e50019', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:35:14', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49b1531001a', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:35:55', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49bf091001c', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:36:51', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49c092f001e', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:36:58', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49c1e4c0020', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:37:03', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49201015de49c62b80021', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:37:20', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49ed7015de49f24cc0000', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:40:21', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49ed7015de49f5ab90002', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:40:35', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de49ed7015de49fb53f0006', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:40:58', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a108015de4a1ca520000', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:43:15', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a108015de4a20b230001', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:43:31', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a108015de4a228b50003', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:43:39', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a108015de4a2f3c40004', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:44:31', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a3d6f60000', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:45:29', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a4034e0002', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:45:40', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a462bd0003', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:46:05', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a4ba5a0004', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:46:27', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a4eadc0006', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:46:40', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a51a5d0007', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:46:52', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a66fb70008', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:48:19', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a6bfe80009', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:48:40', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a71254000a', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:49:01', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a758c1000b', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:49:19', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a777b1000d', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:49:27', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a7f5cb000e', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 14:49:59', '127.0.0.1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a93dde000f', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:51:23', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4a988110010', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:51:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4ab9f2f0011', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:53:59', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4ac45eb0012', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:54:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4ac7f860013', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:54:56', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4acb6340015', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:55:10', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4acc7800017', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:55:15', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4ad92b10018', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:56:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4adf40d0019', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:56:32', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4ae17f2001b', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:56:41', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4ae7f9d001c', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:57:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4aea4d8001e', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:57:17', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4aebe1d0020', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:57:23', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4aeff6e0021', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 14:57:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b13cea0022', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:00:07', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b302310023', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:02:03', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b4c17a0024', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:03:58', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b52d910025', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:04:25', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b56ee20026', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:04:42', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b5e7db0027', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:05:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b61b200028', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:05:26', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4b6cca60029', '402880015da1c880015da1d2c50c0000', '4028800d5d8d093f015d8d0aa1920000', '2017-08-15 15:06:11', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880125de4a37e015de4e3a058002a', '402880015da1c880015da1d2c50c0000', '4028800d5d8bd60f015d8bd988230000', '2017-08-15 15:55:09', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880135e891397015e891f9a9b0000', '402880115e477bda015e477ff6980000', '402880c15e371366015e37297e540001', '2017-09-16 13:18:23', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880135e891397015e8920a1a50001', '402880115e477bda015e477ff6980000', '402880125e4cf3c2015e4d021e040001', '2017-09-16 13:19:31', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e132f54015e13304c430000', '402880115da5d162015da5d2edfa0002', '4', '2017-08-24 15:41:26', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e16b7b81f0000', '402880115da5d162015da5d2edfa0002', '2', '2017-08-25 08:08:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e1710610d0001', '402880115da5d162015da5d2edfa0002', '4028800d5d8bd60f015d8bd988230000', '2017-08-25 09:45:03', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e1725b8d00004', '402880115da5d162015da5d2edfa0002', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 10:08:22', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e17261cc40006', '402880115da5d162015da5d2edfa0002', '1', '2017-08-25 10:08:47', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e17269c720007', '402880115da5d162015da5d2edfa0002', '2', '2017-08-25 10:09:20', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e1726f039000a', '402880115da5d162015da5d2edfa0002', '1', '2017-08-25 10:09:41', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028804d5e16b635015e172724c8000b', '402880115da5d162015da5d2edfa0002', '2', '2017-08-25 10:09:55', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e0cade2015e0cbccda60000', '402880115da5d162015da5d2edfa0002', '4028800d5d8bd60f015d8bd988230000', '2017-08-23 09:37:34', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e0cade2015e0cbda52a0001', '402880115da5d162015da5d2edfa0002', '4028800d5d8bd60f015d8bd988230000', '2017-08-23 09:38:29', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e0cade2015e0cbdcca50002', '402880115da5d162015da5d2edfa0002', '4028800d5d8bd60f015d8bd988230000', '2017-08-23 09:38:39', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e0cade2015e0cbe97130003', '402880115da5d162015da5d2edfa0002', '2', '2017-08-23 09:39:31', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e0cade2015e0cc39bdd0004', '402880115da5d162015da5d2edfa0002', '2', '2017-08-23 09:45:00', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e0cade2015e0cc6a9ad0005', '402880115da5d162015da5d2edfa0002', '2', '2017-08-23 09:48:20', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1219fe015e13151bd80000', '402880115da5d162015da5d2edfa0003', '4028800d5d87a091015d87fdc9fd0004', '2017-08-24 15:11:43', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e18335aea0000', '1', '4028800d5d8bd60f015d8bd988230000', '2017-08-25 15:02:52', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e183580f60001', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:05:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e184760380003', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:24:44', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e1850c71f0004', '402880115da5d162015da5d2edfa0003', '1', '2017-08-25 15:35:01', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e185108b50005', '402880115da5d162015da5d2edfa0003', '3', '2017-08-25 15:35:17', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e185c5b710006', '402880115da5d162015da5d2edfa0003', '4028800d5d87a091015d87fdc9fd0004', '2017-08-25 15:47:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e186074b00007', '402880115da5d162015da5d2edfa0003', '402880115deed196015deedd934a0000', '2017-08-25 15:52:08', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1804ea015e1861ebe40008', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-25 15:53:44', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1c5b28015e1c84b66f0000', '402880115da5d162015da5d2edfa0003', '4', '2017-08-26 11:10:13', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1c5b28015e1c8520e40001', '402880115da5d162015da5d2edfa0003', '402880115e04db00015e04e29add0000', '2017-08-26 11:10:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1c5b28015e1c85cdc20002', '402880115da5d162015da5d2edfa0003', '4', '2017-08-26 11:11:25', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1c5b28015e1c85e3bf0003', '402880115da5d162015da5d2edfa0003', '4', '2017-08-26 11:11:30', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e1c5b28015e1c8649ff0004', '402880115da5d162015da5d2edfa0003', '2', '2017-08-26 11:11:56', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e30f7ae015e330add950000', '402880115da5d162015da5d2edfa0003', '4028800d5d8bd60f015d8bd988230000', '2017-08-30 20:08:24', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('402880c15e371366015e376141c20008', '402880c15e371366015e375f3c520007', '4028800d5d920b51015d923ac6530000', '2017-08-31 16:21:14', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880c15e371366015e376879ed0009', '402880c15e371366015e375f3c520007', '4028800d5d988e9b015d989116a80000', '2017-08-31 16:29:07', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880c15e371366015e37687a77000a', '402880c15e371366015e375f3c520007', '4028800d5d988e9b015d989116a80000', '2017-08-31 16:29:08', '192.168.0.184');
INSERT INTO `t_history` VALUES ('402880c15e371366015e37687b4c000b', '402880c15e371366015e375f3c520007', '4028800d5d988e9b015d989116a80000', '2017-08-31 16:29:08', '192.168.0.184');
INSERT INTO `t_history` VALUES ('4028ab8e5e4f6104015e4f6a195f0002', '402880115e477bda015e477ff6980000', '402880c15e371366015e37297e540001', '2017-09-05 08:21:47', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028ab8e5e4f93ee015e4fa079f50001', '4028ab8e5e4f93ee015e4f9f7c940000', '402880c15e371366015e37297e540001', '2017-09-05 09:21:11', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('4028ab8e5e4f93ee015e4fa1d59b0003', '4028ab8e5e4f93ee015e4f9f7c940000', '402880c15e371366015e37297e540001', '2017-09-05 09:22:40', '0:0:0:0:0:0:0:1');
INSERT INTO `t_history` VALUES ('kg', '2121', '23232', '2017-07-03 11:12:54', '127.0.0.1');

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `logo_string` varchar(500) DEFAULT NULL,
  `intro_string` varchar(500) DEFAULT NULL,
  `area_double` double DEFAULT NULL,
  `unit_price_double` double DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `build_id_string` varchar(36) DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES ('4028800d5d97e731015d97e813c10000', 'C户型', 'upfile/30109398223057.jpg', '撒的发生', '320', '6000', '2017-07-31 17:09:15', '0', '1', '1');
INSERT INTO `t_house` VALUES ('4028800d5d97fbfa015d980184790000', '00000', 'upfile/30109398223057.jpg', '111111111', '1111', '111', '2017-07-31 17:37:03', '0', '1', '1');
INSERT INTO `t_house` VALUES ('402880115dc44675015dc44fcc0f0003', 'A户型', 'upfile/30109398223057.jpg', '坐南朝北', '200', '4000', '2017-08-09 08:05:50', '1', '402880115dc44675015dc44eac610002', '1');
INSERT INTO `t_house` VALUES ('402880125dc1d131015dc1d1aa3d0000', '1111', 'upfile/30109398223057.jpg', '1111', '111', '111', '2017-08-08 20:28:50', '1', '4028800d5d8d7308015d8d75b3230001', '1');
INSERT INTO `t_house` VALUES ('402880125dc1d737015dc1d8700d0000', '22000', 'upfile/30109398223057.jpg', '22222', '222', '2222', '2017-08-08 20:36:13', '1', '4028800d5d8d7308015d8d75b3230001', '1');
INSERT INTO `t_house` VALUES ('402880125e404eeb015e408cc7fb0000', 'A户型', 'upfile/11566482607207.jpg', '精美户型', '600', '6000', '2017-09-02 11:05:22', '1', '2', '1');
INSERT INTO `t_house` VALUES ('4028ab8e5e4d4118015e4d490ac90002', 'A户型', 'upfile/52527973998962.jpg', '采光好，环境优美', '400', '7000', '2017-09-04 22:26:26', '0', '4028ab8e5e4d3c9b015e4d403af40000', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_house` VALUES ('4028ab8e5e4d4118015e4d4e32950003', 'B户型', 'upfile/52865869508807.jpg', '采光交换，幽静', '500', '7800', '2017-09-04 22:32:04', '0', '4028ab8e5e4d3c9b015e4d403af40000', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_house` VALUES ('4028ab8e5e4d4118015e4d4f15eb0004', 'A户型', 'upfile/52924044382340.jpg', '精美装修', '8900', '8900', '2017-09-04 22:33:02', '0', '4028ab8e5e4d4118015e4d4561e10000', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_house` VALUES ('4028ab8e5e4d4118015e4d5038f90005', 'A户型', 'upfile/52998581911387.jpg', '采光好', '900', '9000', '2017-09-04 22:34:17', '0', '4028ab8e5e4d4118015e4d465bcd0001', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_house` VALUES ('4028ab8e5e4f93ee015e4fb36115000a', 'C户型', 'upfile/6914423284492.jpg', '好呀', '9000', '9000', '2017-09-05 09:41:49', '0', '4028ab8e5e4d3c9b015e4d403af40000', '402880125e4cf3c2015e4cfa96860000');
INSERT INTO `t_house` VALUES ('dsd', 'F111', 'upfile/30109398223057.jpg', '空气清晰', '45555', '999999', '2017-07-17 11:15:11', '0', '1', '1');

-- ----------------------------
-- Table structure for t_like
-- ----------------------------
DROP TABLE IF EXISTS `t_like`;
CREATE TABLE `t_like` (
  `id_string` varchar(36) NOT NULL,
  `user_id_string` varchar(50) DEFAULT NULL,
  `buildings_id_string` varchar(36) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_like
-- ----------------------------
INSERT INTO `t_like` VALUES ('101', '1', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('102', '2', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('103', '3', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('104', '4', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('105', '5', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('106', '6', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('107', '7', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('108', '8', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('109', '9', '402880115e04db00015e04e29add0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('11', '1', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('111', '1', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('112', '2', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('113', '3', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('114', '4', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('115', '5', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('116', '6', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('117', '7', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('118', '8', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('119', '9', '402880115e2b841b015e2b9690e9000c', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('12', '2', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('121', '1', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('122', '2', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('123', '3', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('124', '4', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('125', '5', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('126', '6', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('127', '7', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('128', '8', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('129', '9', '402880115e2bc2d6015e2bf96a450004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('13', '3', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('14', '4', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('15', '5', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('16', '6', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('17', '7', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('18', '8', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('19', '9', '4028800d5d87a091015d87fdc9fd0004', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('2', '402880115da5d162015da5d2edfa0003', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('21', '1', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('22', '2', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('23', '3', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('24', '4', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('25', '5', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('26', '6', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('27', '7', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('28', '8', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('29', '9', '4028800d5d8bd60f015d8bd988230000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('3', '402880115e1bd9c5015e1bf331dc0000', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('31', '1', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('32', '2', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('33', '3', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('34', '4', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('35', '5', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('36', '6', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('37', '7', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('38', '8', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('39', '9', '4028800d5d8d093f015d8d0aa1920000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('4', '402880115e1c4429015e1c488c5f0000', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('402880115e2d667b015e2d819a830025', '1', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('402880115e36e320015e370668690002', '402880115e36e320015e36f2d10c0000', '402880115deed196015deedd934a0000', '2017-08-31 14:42:00');
INSERT INTO `t_like` VALUES ('402880115e4787a0015e478943170001', '402880115e477bda015e477ff6980000', '402880115e2bc2d6015e2bf96a450004', '2017-09-03 19:38:52');
INSERT INTO `t_like` VALUES ('4028ab8e5e4f93ee015e4fa090580002', '4028ab8e5e4f93ee015e4f9f7c940000', '402880c15e371366015e37297e540001', '2017-09-05 09:21:16');
INSERT INTO `t_like` VALUES ('41', '1', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('42', '2', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('43', '3', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('44', '4', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('45', '5', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('46', '6', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('47', '7', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('48', '8', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('49', '9', '4028800d5d920b51015d923ac6530000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('5', '2', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('51', '1', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('52', '2', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('53', '3', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('54', '4', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('55', '5', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('56', '6', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('57', '7', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('58', '8', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('59', '9', '4028800d5d988e9b015d989116a80000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('6', '3', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('61', '1', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('62', '2', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('63', '3', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('64', '4', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('65', '5', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('66', '6', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('67', '7', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('68', '8', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('69', '9', '4028800d5d988e9b015d9894d0c80001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('7', '4', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('71', '1', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('72', '2', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('73', '3', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('74', '4', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('75', '5', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('76', '6', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('77', '7', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('78', '8', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('79', '9', '4028800d5d988e9b015d9898902c0002', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('8', '5', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('81', '1', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('82', '2', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('83', '3', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('84', '4', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('85', '5', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('86', '6', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('87', '7', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('88', '8', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('89', '9', '402880115dc44675015dc44e41120001', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('9', '6', '1', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('91', '1', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('92', '2', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('93', '3', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('94', '4', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('95', '5', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('96', '6', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('97', '7', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('98', '8', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');
INSERT INTO `t_like` VALUES ('99', '9', '402880115deed196015deedd934a0000', '2017-08-29 18:20:22');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
  `id_string` varchar(36) NOT NULL,
  `phone_string` varchar(50) DEFAULT NULL,
  `password_string` varchar(100) DEFAULT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `sex_int` int(11) DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `type_int` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `reason_string` varchar(255) DEFAULT NULL,
  `headicon_string` varchar(255) DEFAULT NULL,
  `checked_status_int` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES ('1', '15007964531', '05868E10ED7CBB988E7821FAD2B75941', '凌骁', '1', '0', '0', '2017-08-23 08:52:24', '审核不通过', 'images/people.gif', '3');
INSERT INTO `t_manager` VALUES ('402880115db21c6a015db21e37bf0000', '17607975702', '05868E10ED7CBB988E7821FAD2B75941', '絮落锦乡', '0', '0', '1', '2017-08-05 19:18:31', '请求提交成功，我们会尽快处理！', 'upfile/29016044291176.jpg', '0');
INSERT INTO `t_manager` VALUES ('65234567', '15679760329', '05868E10ED7CBB988E7821FAD2B75941', '钟明旭', '0', '0', '0', '2017-08-13 09:31:27', '审核为通过', 'images/people.gif', '0');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id_string` varchar(36) NOT NULL,
  `content` text,
  `buildings_id_string` varchar(36) DEFAULT NULL,
  `reply_string` text,
  `leave_time` datetime DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('ytrfd', '诚心购买', 'dsadfg', '你带好钱我带好房契', '2017-07-11 11:18:57', '2017-07-12 11:19:00', 'dafdsf', '2');

-- ----------------------------
-- Table structure for t_mission
-- ----------------------------
DROP TABLE IF EXISTS `t_mission`;
CREATE TABLE `t_mission` (
  `id_string` varchar(36) NOT NULL,
  `quantity_int` int(11) DEFAULT NULL,
  `monthesint` int(11) DEFAULT NULL,
  `emp_id_string` varchar(36) DEFAULT NULL,
  `bonus_percent_double` double DEFAULT NULL,
  `jxs_id_string` varchar(36) DEFAULT NULL,
  `last_quantity_int` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_mission
-- ----------------------------
INSERT INTO `t_mission` VALUES ('1', '5', '7', '402880015dac5e2a015dac5f7bbd0000', '55.5', '1', '0');
INSERT INTO `t_mission` VALUES ('402880115e026924015e026d24ea0000', '5', '8', '402880125dc2002b015dc20189fc0000', '10', '1', '0');
INSERT INTO `t_mission` VALUES ('402880115e12c691015e12d68ab90001', '5', '8', '402880015dac5e2a015dac6173730001', '10', '1', '9');
INSERT INTO `t_mission` VALUES ('402880115e12ddf4015e12e1de450000', '12', '6', '402880125dc2002b015dc20189fc0000', '10', '1', '0');
INSERT INTO `t_mission` VALUES ('402880115e12e576015e12ea6edd0000', '5', '8', '402880115dba500a015dba50f01e0000', '10', '1', '1');
INSERT INTO `t_mission` VALUES ('fhgjhg', '5', '7', '402880015dac5401015dac5a01550000', '55.5', '1', '3');

-- ----------------------------
-- Table structure for t_page
-- ----------------------------
DROP TABLE IF EXISTS `t_page`;
CREATE TABLE `t_page` (
  `id_string` varchar(36) NOT NULL,
  `q1_1` varchar(20) DEFAULT NULL,
  `q1_2` varchar(20) DEFAULT NULL,
  `q1_3` varchar(20) DEFAULT NULL,
  `q2` int(255) DEFAULT NULL,
  `q3` varchar(255) DEFAULT NULL,
  `q4` int(255) DEFAULT NULL,
  `q5` int(255) DEFAULT NULL,
  `q6` int(255) DEFAULT NULL,
  `q7` varchar(255) DEFAULT NULL,
  `q8` int(255) DEFAULT NULL,
  `q9` varchar(20) DEFAULT NULL,
  `q10` varchar(20) DEFAULT NULL,
  `q11` varchar(20) DEFAULT NULL,
  `q12` varchar(255) DEFAULT NULL,
  `q13` varchar(255) DEFAULT NULL,
  `q14` int(255) DEFAULT NULL,
  `q15` int(255) DEFAULT NULL,
  `q16` varchar(255) DEFAULT NULL,
  `q17` varchar(255) DEFAULT NULL,
  `q18` varchar(255) DEFAULT NULL,
  `q19` varchar(255) DEFAULT NULL,
  `q20` varchar(255) DEFAULT NULL,
  `q21` int(255) DEFAULT NULL,
  `q22` varchar(255) DEFAULT NULL,
  `q23` varchar(255) DEFAULT NULL,
  `q24` int(255) DEFAULT NULL,
  `q25` varchar(255) DEFAULT NULL,
  `q26` varchar(255) DEFAULT NULL,
  `q27` varchar(255) DEFAULT NULL,
  `q28` int(255) DEFAULT NULL,
  `q29` int(255) DEFAULT NULL,
  `q30` int(255) DEFAULT NULL,
  `q31` int(255) DEFAULT NULL,
  `q32` int(255) DEFAULT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_page
-- ----------------------------
INSERT INTO `t_page` VALUES ('402880115dfa8094015dfa9f33590001', '陈飞龙', '21', '15679760329', '1', '3', '3', '1', '3', '1', '1', '6', '2', '1, 5', '1', '1', '4', '1', '1', '1, 2, 3, ', '2, 5', '2', '2, 5, 7', '2', '3', '5', '4', '2, 3, 5, ', '1, 3', '2, 3', '1', '1', '2', '3', '1', '1');
INSERT INTO `t_page` VALUES ('402880115e1214bf015e12153eb60000', '此傲视', '21', '15679760329', '1', '3', '1', '1', '4', '1', '1', '1, 2', '1, 2', '2, 3', '2', '2', '2', '3', '3', '1, 2, 3, ', '3, 4, 5', '1', '2, 5, 7', '2', '2', '2', '3', '1, 2, 3, ', '1, 3', '2, 3', '3', '2', '1', '2', '1', '402880115da5d162015da5d2edfa0003');
INSERT INTO `t_page` VALUES ('402880115e123999015e123a45aa0000', '此傲视', '21', '15007964533', '1', '3', '1', '1', '4', '1', '1', '1, 2', '1, 2', '2, 3', '2', '2', '2', '3', '3', '1, 2, 3, ', '3, 4, 5', '1', '2, 5, 7', '2', '2', '2', '3', '1, 2, 3, ', '1, 3', '2, 3', '3', '2', '1', '2', '1', '402880115da5d162015da5d2edfa0012');
INSERT INTO `t_page` VALUES ('402880c15e0dbad3015e0f1c2a940000', 'sdzfghjkl;\'fdghjkl;', 'dfgh', 'tfyg', '2', '1', '1', '1', '1', '1', '1', '2, 3, 4, 5, 6', '1, 3, 4', '1, 2, 4, 5, 6', '4', '1', '2', '3', '1', '1, 2, 3, ', '2, 3, 5', '2', '2, 4, 5', '2', '1', '2', '2', '1, 2, 3, ', '1, 2', '2, 3', '1', '2', '7', '1', '4', '1');
INSERT INTO `t_page` VALUES ('4028ab8e5e4f6104015e4f6983780000', '张三', '21', '15679760329', '1', '1', '1', '1', '2', '1', '1', '1, 2, 6', '1, 2', '1, 2', '2', '1', '4', '1', '1', '1, 2, 3, ', '1, 3, 6', '2', '2, 4, 6', '1', '1', '2', '3', '1, 2, 3, ', '1, 3', '1, 3', '5', '4', '8', '3', '3', '402880115e477bda015e477ff6980000');
INSERT INTO `t_page` VALUES ('4028ab8e5e4f93ee015e4fae82e90008', '张三', '21', '15679760329', '1', '1', '1', '1', '2', '1', '1', '1, 2, 6', '1, 2', '1, 2', '2', '1', '4', '1', '1', '1, 2, 3, ', '1, 3, 6', '2', '2, 4, 6', '1', '1', '2', '3', '1, 2, 3, ', '1, 3', '1, 3', '5', '4', '8', '3', '3', '4028ab8e5e4f93ee015e4f9f7c940000');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(500) DEFAULT NULL,
  `des_string` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('wwddss', 'qqwwss', 'eewwsa', '2017-07-25 11:21:18', '2');

-- ----------------------------
-- Table structure for t_phonecode
-- ----------------------------
DROP TABLE IF EXISTS `t_phonecode`;
CREATE TABLE `t_phonecode` (
  `id_string` varchar(36) NOT NULL,
  `phone_string` varchar(36) DEFAULT NULL,
  `phonecode` int(11) DEFAULT NULL,
  `sendtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_phonecode
-- ----------------------------
INSERT INTO `t_phonecode` VALUES ('402880115e3da252015e3da52e790000', '0:0:0:0:0:0:0:1', '254288', '2017-09-01 21:33:09');
INSERT INTO `t_phonecode` VALUES ('402880115e477bda015e4784361b0001', '0:0:0:0:0:0:0:1', '359082', '2017-09-03 19:33:21');
INSERT INTO `t_phonecode` VALUES ('402880125e4bff6e015e4bffe5a80000', '0:0:0:0:0:0:0:1', '756500', '2017-09-04 16:26:55');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id_string` varchar(36) NOT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `des_string` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('rrffss', 'edaddsd', 'sdsada', '2017-07-11 11:22:27', '2');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id_string` varchar(36) NOT NULL,
  `role_id_string` varchar(500) DEFAULT NULL,
  `permission_id_string` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('wdgvb', 'ewf', 'fdcbfd', '2017-07-26 11:23:09');

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room` (
  `id_string` varchar(36) NOT NULL,
  `house_id_string` varchar(36) DEFAULT NULL,
  `building_id_string` varchar(36) DEFAULT NULL,
  `name_string` varchar(50) DEFAULT NULL,
  `sale_status_int` int(11) DEFAULT NULL,
  `roominfo_string` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES ('12', 'dsd', '1', '10111', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('13', 'dsd', '1', '1021', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('14', 'dsd', '1', '103', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('15', 'dsd', '1', '104', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('16', 'dsd', '1', '201', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('17', 'dsd', '1', '202', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('22', 'dsd', '1', '203', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('23', 'dsd', '1', '204', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('24', 'dsd', '1', '301', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('25', 'dsd', '1', '302', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('26', 'dsd', '1', '303', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('27', 'dsd', '1', '304', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('4028800d5d9bc8c4015d9bc9a4470000', '4028800d5d97e731015d97e813c10000', '1', '302', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('4028800d5d9bcef8015d9bdcbb970000', 'dsd', '1', '1011', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('4028800d5d9bcef8015d9be2f1a10001', '4028800d5d97e731015d97e813c10000', '1', '101', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('402880115dc44675015dc450bbca0004', '402880115dc44675015dc44fcc0f0003', '402880115dc44675015dc44eac610002', '101', '1', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('402880125dc1f0c6015dc1f699bd0002', '402880125dc1d737015dc1d8700d0000', '4028800d5d8d7308015d8d75b3230001', '1100', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('402880125dc1f0c6015dc1f8a1a40003', '4028800d5d97e731015d97e813c10000', '1', '110', '0', '精装房，坐北朝南');
INSERT INTO `t_room` VALUES ('4028ab8e5e4d4118015e4d512bd50006', '4028ab8e5e4d4118015e4d490ac90002', '4028ab8e5e4d3c9b015e4d403af40000', 'A101', '0', '内部设施完美');
INSERT INTO `t_room` VALUES ('4028ab8e5e4d5221015e4d53d4570000', '4028ab8e5e4d4118015e4d4e32950003', '4028ab8e5e4d3c9b015e4d403af40000', 'B101', '0', '陈设合理');
INSERT INTO `t_room` VALUES ('4028ab8e5e4d5221015e4d54f3a30001', '4028ab8e5e4d4118015e4d4f15eb0004', '4028ab8e5e4d4118015e4d4561e10000', 'B-A101', '0', '陈设合理，环境优美');
INSERT INTO `t_room` VALUES ('4028ab8e5e4d5221015e4d5641880002', '4028ab8e5e4d4118015e4d5038f90005', '4028ab8e5e4d4118015e4d465bcd0001', 'C-A101', '0', '采光好，幽静');

-- ----------------------------
-- Table structure for t_sale
-- ----------------------------
DROP TABLE IF EXISTS `t_sale`;
CREATE TABLE `t_sale` (
  `id_string` varchar(36) NOT NULL,
  `customer_id_string` varchar(50) DEFAULT NULL,
  `sale_time_string` datetime DEFAULT NULL,
  `unit_price_double` double DEFAULT NULL,
  `room_id_string` varchar(36) DEFAULT NULL,
  `discount_double` double DEFAULT NULL,
  `total_cost_double` double DEFAULT NULL,
  `emp_id_string` varchar(36) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `sale_house_status_int` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sale
-- ----------------------------
INSERT INTO `t_sale` VALUES ('402880115dfebd32015dfec89b000000', '402880015d985cef015d9862889a0001', '2017-08-23 00:00:00', '3000', '13', '1', '800000', '402880115dba500a015dba50f01e0000', '2017-08-20 16:35:46', '0', '1', '审核通过');
INSERT INTO `t_sale` VALUES ('402880115e2d1c91015e2d20aa310000', '402880115e2d149a015e2d1696b30000', '2017-08-29 00:00:00', '9000', '12', '1', '59', '402880015dac5401015dac5a01550000', '2017-08-29 16:34:29', '0', '0', '请求审核');
INSERT INTO `t_sale` VALUES ('402880115e37235c015e3726cfc60001', '402880115e37235c015e372595e60000', '2017-08-31 00:00:00', '8000', '12', '1', '600000', '402880015dac5401015dac5a01550000', '2017-08-31 15:17:24', '0', '1', '审核通过');
INSERT INTO `t_sale` VALUES ('402880115e4787a0015e4795a7870005', '402880115e4787a0015e4795227c0004', '2017-09-05 00:00:00', '6000', '12', '1', '500000', '402880115dba500a015dba5c198a0001', '2017-09-03 19:52:24', '0', '0', '请求审核');
INSERT INTO `t_sale` VALUES ('402880c15e371366015e373d523d0003', '402880015d985cef015d98612bf50000', '2017-08-17 00:00:00', '0', '27', '0', '0', '402880015dac5e2a015dac6173730001', '2017-08-31 15:41:59', '0', '1', '请求审核');
INSERT INTO `t_sale` VALUES ('4028ab8e5e4f93ee015e4fa83cc00006', '4028ab8e5e4f93ee015e4fa72cdb0005', '2017-09-05 00:00:00', '8000', '402880115dc44675015dc450bbca0004', '1', '800000', '402880015dac5401015dac5a01550000', '2017-09-05 09:29:39', '0', '1', '恭喜你！');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id_string` varchar(36) NOT NULL,
  `email_string` varchar(50) DEFAULT NULL,
  `phone_string` varchar(11) DEFAULT NULL,
  `pwd_string` varchar(50) DEFAULT NULL,
  `qq_string` varchar(20) DEFAULT NULL,
  `wechat_string` varchar(50) DEFAULT NULL,
  `gender_string` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `nickname_string` varchar(50) DEFAULT NULL,
  `name_string` varchar(20) DEFAULT NULL,
  `headicon_string` varchar(500) DEFAULT NULL,
  `status_int` int(11) DEFAULT NULL,
  `reason_string` varchar(500) DEFAULT NULL,
  `usertype_int` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1654905415@qq.com', '182966529', '05868E10ED7CBB988E7821FAD2B75941', '1654905415', '2123', '男', '2017-05-08', '兮兮饿呢', '夏菲', 'upfile/12695481736013.jpg', '0', '成功注册成为用户', '1', '2017-08-07 16:37:09');
INSERT INTO `t_user` VALUES ('402880015e3ae165015e3b1d827b0000', '123@qq.com', '18296652907', '05868E10ED7CBB988E7821FAD2B75941', '16549054250', '18296652907', '女', '1992-06-05', '薇薇', '魏薇', 'images/people.gif', '0', '成功注册成为用户', '0', '2017-09-26 11:13:13');
INSERT INTO `t_user` VALUES ('402880115da5d162015da5d2edfa0003', '275300091@qq.com', '17607975702', '4AF5BDC2163D6C8026A8F4621A4248D6', '27530091', '4145445', '男', '2017-08-23', '自尊', '蒙黑航', 'images/people.gif', '0', '审核通过', '1', '2017-08-04 08:28:49');
INSERT INTO `t_user` VALUES ('402880115e1bd9c5015e1bf331dc0000', '275300091@qq.com', '13672297775', '05868E10ED7CBB988E7821FAD2B75941', '1654905415', '18174099380', '男', '2017-08-23', '心之语', '乐兮', 'images/people.gif', '0', '成功注册成为用户', '0', '2017-08-26 08:31:16');
INSERT INTO `t_user` VALUES ('402880115e1c4429015e1c488c5f0000', '275300091@qq.com', '13237675702', '05868E10ED7CBB988E7821FAD2B75941', '1234567891', '123456789', '男', '2017-08-10', '金新干线', '侠盗飞车1', 'images/people.gif', '0', '成功注册成为用户', '1', '2017-08-26 10:04:30');
INSERT INTO `t_user` VALUES ('402880115e36e320015e36f2d10c0000', '275300091@qq.com', '15679760320', '05868E10ED7CBB988E7821FAD2B75941', '275300091', '15679760320', '男', '2017-09-27', '絮落锦乡', '陈飞龙', 'images/people.gif', '4', '成功注册成为用户', '0', '2017-08-31 14:20:36');
INSERT INTO `t_user` VALUES ('402880115e477bda015e477ff6980000', '275300091@qq.com', '15679760329', '05868E10ED7CBB988E7821FAD2B75941', '27530091', 'xljx_888888', '男', '2017-08-29', '陈飞龙', '陈飞龙', 'images/people.gif', '4', '成功注册成为用户', '0', '2017-09-03 19:28:42');
INSERT INTO `t_user` VALUES ('4028ab8e5e4f93ee015e4f9f7c940000', '275300091@QQ.COM', '17370134036', '05868E10ED7CBB988E7821FAD2B75941', '23532525', '239572352', '男', null, '展示', '张三', 'images/people.gif', '4', '成功注册成为用户', '1', '2017-09-05 09:20:06');

-- ----------------------------
-- Table structure for t_userprize
-- ----------------------------
DROP TABLE IF EXISTS `t_userprize`;
CREATE TABLE `t_userprize` (
  `id_string` varchar(36) NOT NULL,
  `user_id_string` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `prize` double(11,0) DEFAULT NULL,
  `employee_id_string` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userprize
-- ----------------------------
INSERT INTO `t_userprize` VALUES ('402880115e03bc87015e03bda1680000', '402880015d985cef015d98612bf50000', '2017-08-21 15:41:53', '500', '402880015dac5e2a015dac5f7bbd0000');
INSERT INTO `t_userprize` VALUES ('402880115e12c691015e12c9c5630000', '402880015d985cef015d9862889a0001', '2017-08-24 13:49:27', '700', '402880015dac5e2a015dac6173730001');
INSERT INTO `t_userprize` VALUES ('402880115e12f592015e12f63eaa0000', '402880015d985cef015d9862889a0001', '2017-08-24 14:38:01', '860', '402880015dac5e2a015dac6173730001');
INSERT INTO `t_userprize` VALUES ('402880115e140ac2015e140d626b0000', '402880015d985cef015d9862889a0001', '2017-08-24 19:42:55', '740', '402880015dac5e2a015dac6173730001');
INSERT INTO `t_userprize` VALUES ('402880115e140ac2015e140e063a0001', '402880015d985cef015d9862889a0001', '2017-08-24 19:43:37', '630', '402880115dba500a015dba50f01e0000');
INSERT INTO `t_userprize` VALUES ('402880115e140ac2015e140e3ad80002', '402880015d985cef015d98612bf50000', '2017-08-24 19:43:50', '690', '402880015dac5e2a015dac6173730001');
INSERT INTO `t_userprize` VALUES ('402880115e140ac2015e140e6c640003', '402880115e2d149a015e2d1696b30000', '2017-08-24 19:44:03', '500', '402880015dac5e2a015dac6173730001');
INSERT INTO `t_userprize` VALUES ('402880115e37235c015e372775240002', '402880115e2d149a015e2d1696b30000', '2017-08-31 15:18:06', '600', '402880015dac5401015dac5a01550000');
INSERT INTO `t_userprize` VALUES ('4028ab8e5e4f93ee015e4fa8f7df0007', '4028ab8e5e4f93ee015e4fa72cdb0005', '2017-09-05 09:30:27', '800', '402880015dac5401015dac5a01550000');
