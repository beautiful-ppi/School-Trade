/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : dbthings

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-06-02 21:59:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tmanager
-- ----------------------------
DROP TABLE IF EXISTS `tmanager`;
CREATE TABLE `tmanager` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `weixin` varchar(100) NOT NULL,
  `photo` varchar(200) DEFAULT NULL,
  `create_date` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=777889000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmanager
-- ----------------------------
INSERT INTO `tmanager` VALUES ('159357', 'yantong', 'ed3f910153109eb360b5b98fd799d492', '炎烔', '123', '123', 'timg.jpg', '2019', '2', '1');
INSERT INTO `tmanager` VALUES ('6741103', 'fhkjajhf', 'd9b1d7db4cd6e70935368a1efb10e377', 'ff', '23123', '1231', '', '2019-10-29', '2', '1');
INSERT INTO `tmanager` VALUES ('7758258', 'wen', '202cb962ac59075b964b07152d234b70', '文', '123', '123', 'map.png', '2019', '2', '1');
INSERT INTO `tmanager` VALUES ('8625205', 'nihao', '202cb962ac59075b964b07152d234b70', 'ff', '23123', '1231', '', '2019-10-29', '2', '1');
INSERT INTO `tmanager` VALUES ('28973459', '发发发放', '202cb962ac59075b964b07152d234b70', 'ff', 'ff', 'ewqe', 'pp.jpg', '2019-10-24 21:33:40', '2', '1');
INSERT INTO `tmanager` VALUES ('30141078', 'ggg', '202cb962ac59075b964b07152d234b70', 'gg', '123', '123', 'apple.png', '2019-11-15', '2', '1');
INSERT INTO `tmanager` VALUES ('30899602', 'aiwenbin', '202cb962ac59075b964b07152d234b70', 'wenbin', '123456', '123456', 'marks.jpg', '2019-11-07', '2', '1');
INSERT INTO `tmanager` VALUES ('36145304', 'xionger', '202cb962ac59075b964b07152d234b70', '刘文鑫', '123', '123', 'marks.jpg', '2019-10-02 08:52:53', '2', '1');
INSERT INTO `tmanager` VALUES ('56433656', 'dfsagsa', '202cb962ac59075b964b07152d234b70', 'ff', '23123', '1231', '', '2019-10-29', '2', '1');
INSERT INTO `tmanager` VALUES ('56897364', 'fff', '202cb962ac59075b964b07152d234b70', 'ff', '23123', '1231', '', '2019-10-29', '2', '1');
INSERT INTO `tmanager` VALUES ('62407710', 'gg', '9bd5ee6fe55aaeb673025dbcb8f939c1', 'gg', 'gg', '1231', '', '2019-10-24 21:34:25', '2', '1');
INSERT INTO `tmanager` VALUES ('64264971', 'ggggg', '9bd5ee6fe55aaeb673025dbcb8f939c1', 'gggg', 'gg', '1231', 'welcome.jpg', '2019-10-24 21:34:38', '2', '1');
INSERT INTO `tmanager` VALUES ('78913978', 'leo', '202cb962ac59075b964b07152d234b70', 'ff', '23123', '1231', '', '2019-10-29', '2', '1');
INSERT INTO `tmanager` VALUES ('91401559', 'gggggg', '202cb962ac59075b964b07152d234b70', 'gggggg', '123', '123', '', '2019-11-15', '2', '1');
INSERT INTO `tmanager` VALUES ('111222333', 'liu', '202cb962ac59075b964b07152d234b70', '刘', '123', '123', 'marks.jpg', '2019', '2', '1');
INSERT INTO `tmanager` VALUES ('123456789', 'admin', '202cb962ac59075b964b07152d234b70', '老大', '123', '123', 'Chrysanthemum.jpg', '2019-09-24 23:21:10', '1', '1');
INSERT INTO `tmanager` VALUES ('444555666', 'answer', '202cb962ac59075b964b07152d234b70', '答案', '123', '123', 'marks.jpg', '2019', '2', '1');
INSERT INTO `tmanager` VALUES ('777888999', 'daye', '202cb962ac59075b964b07152d234b70', '大爷', '123', '123', 'message.png', '2019', '2', '1');

-- ----------------------------
-- Table structure for trequestmatch
-- ----------------------------
DROP TABLE IF EXISTS `trequestmatch`;
CREATE TABLE `trequestmatch` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_user` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `message` varchar(200) NOT NULL,
  `message_date` varchar(50) NOT NULL,
  `_thing` int(11) NOT NULL,
  `isRead` int(11) NOT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_trequestmatchAndtuser_user` (`_user`),
  KEY `fk_trequestmatchAndtthings_things` (`_thing`),
  CONSTRAINT `fk_trequestmatchAndtthings_things` FOREIGN KEY (`_thing`) REFERENCES `tthings` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trequestmatchAndtuser_user` FOREIGN KEY (`_user`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=80296224 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trequestmatch
-- ----------------------------
INSERT INTO `trequestmatch` VALUES ('789456', '71503978', '二手水杯需求匹配通知', '点击了解更多', '2019-11-29', '94858026', '1');
INSERT INTO `trequestmatch` VALUES ('5369719', '75146075', 'dsafs', 'fdafdfdas', '2019-10-24 15:51:23', '12397957', '1');
INSERT INTO `trequestmatch` VALUES ('10524957', '75146075', 'dsadssa', 'fdafdfdas', '2019-10-30', '12397957', '1');
INSERT INTO `trequestmatch` VALUES ('15108798', '75146075', '匹配啦', '冲冲冲', '2019-09-29 15:24:22', '12397957', '1');
INSERT INTO `trequestmatch` VALUES ('33915137', '12123', '匹配成功', '发顺丰哈设计开发贺卡是否健康', '2019-12-15', '13609680', '1');
INSERT INTO `trequestmatch` VALUES ('37331537', '63973143', '匹配成功', '匹配', '2019-12-14', '40811810', '0');

-- ----------------------------
-- Table structure for trequests
-- ----------------------------
DROP TABLE IF EXISTS `trequests`;
CREATE TABLE `trequests` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_owner` int(11) NOT NULL,
  `thing_name` varchar(20) NOT NULL,
  `new_old` float NOT NULL,
  `memo` varchar(200) NOT NULL,
  `price_low` float NOT NULL,
  `price_high` float NOT NULL,
  `exchangeable` int(11) NOT NULL,
  `publish_date` varchar(50) NOT NULL,
  `_thing` int(11) DEFAULT NULL,
  `finished` int(11) NOT NULL,
  `finished_date` varchar(50) DEFAULT NULL,
  `_thing2` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `request_provider` int(11) DEFAULT NULL,
  `isComplaint` int(11) DEFAULT NULL,
  `isResist` int(11) DEFAULT NULL,
  `isJudged` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_trequestAndtuser_owner` (`_owner`),
  KEY `fk_trequestAndtthings` (`_thing`) USING BTREE,
  KEY `fk_trequestAndtthings_getThing` (`_thing2`),
  CONSTRAINT `fk_trequestAndtthings_getThing` FOREIGN KEY (`_thing2`) REFERENCES `tthings` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trequestAndtthings_thing` FOREIGN KEY (`_thing`) REFERENCES `tthings` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trequestAndtuser_owner` FOREIGN KEY (`_owner`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=444555667 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trequests
-- ----------------------------
INSERT INTO `trequests` VALUES ('583952', '36310332', '数据线', '0.9', '华为数据线，黑色的。', '10', '40', '2', '2019-11-13', null, '1', '2019-11-14', null, '10', '36310332', null, null, null);
INSERT INTO `trequests` VALUES ('778899', '12123', '手机', '1', '华为nova3,前后4800万像素', '1000', '1500', '1', '2019-01-14', '14928858', '1', '2019-10-18', '94858026', '0', '71503978', '0', '0', '0');
INSERT INTO `trequests` VALUES ('1854705', '44739952', '智能手环', '0.9', '计时手环', '50', '100', '1', '2019-11-08', '42066277', '1', '2019-11-13', null, '50', '44739952', '1', null, '1');
INSERT INTO `trequests` VALUES ('2115975', '64572214', '草稿本', '0.9', '做草稿用的本子。', '10', '30', '2', '2019-11-13', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('2721716', '44739952', '音响', '0.8', '小型音响，班级聚会可以用的。', '50', '152', '1', '2019-11-13', '53242054', '2', '2019-11-13', null, '50', '64572214', null, null, null);
INSERT INTO `trequests` VALUES ('2779343', '44739952', '蛋糕', '0.9', '好吃又便宜的蛋糕。', '10', '40', '2', '2019-11-13', null, '1', '2019-11-13', null, '10', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('8286637', '36310332', '联想电脑', '0.9', '联想笔记本电脑', '1000', '5000', '2', '2019-11-14', null, '1', '2019-11-14', null, '1000', '63973143', null, null, null);
INSERT INTO `trequests` VALUES ('10601087', '44739952', '化妆镜', '0.9', '化妆镜，女生', '23.09', '60.98', '2', '2019-12-02', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('11462208', '44739952', '巴旦木', '0.7', '百草味的。', '10', '60', '2', '2019-11-08', null, '1', '2019-11-13', null, '10', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('14049376', '71503978', '大王卡', '0.6', '无限流量的那种', '20', '40', '2', '2019-02-19 ', null, '2', '2019-09-19', null, '20', '59525250', '1', '1', '0');
INSERT INTO `trequests` VALUES ('14675796', '17500335', '四六级试题', '0.88', '英语四六级题册', '11', '25', '2', '2019-12-16', null, '1', '2019-12-16', null, '18', '17500335', null, null, null);
INSERT INTO `trequests` VALUES ('14934663', '63973143', '明信片', '0.9', '李现明信片。', '10', '30', '2', '2019-11-14', null, '1', '2019-11-15', null, '10', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('15501770', '35848425', '奶茶', '1', '好喝就可以', '10', '15', '2', '2019-11-15', null, '1', '2019-11-19', null, '10', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('15879720', '71503978', '眼药水', '0.8', '抗疲劳，防止眼干', '10', '20', '1', '2019-03-22 ', '62981780', '1', '2019-10-30', '62981780', '0', '12123', null, null, null);
INSERT INTO `trequests` VALUES ('16604887', '44739952', '电脑U盘', '0.9', '32GU盘', '10', '30', '2', '2019-11-15', null, '1', '2019-11-15', null, '10', '44739952', '1', null, null);
INSERT INTO `trequests` VALUES ('19461581', '71503978', '发胶', '0.8', '固定头发、塑型', '10', '20', '1', '2019-04-22 ', '98744319', '2', '2019-11-13', null, '10', '71503978', null, null, null);
INSERT INTO `trequests` VALUES ('21572162', '49913287', '收音机', '0.8', '老式收音机', '10', '30', '2', '2019-11-15', null, '1', '2019-11-15', null, '10', '53460234', null, null, null);
INSERT INTO `trequests` VALUES ('25997567', '35848425', '充电宝', '0.9', '五千万毫安', '30', '90', '1', '2019-12-02', '49713238', '2', '2019-12-02', '49713238', '0', '35848425', null, null, null);
INSERT INTO `trequests` VALUES ('26512239', '36310332', '鼠标垫', '0.7', '黑色的，耐脏的。', '10', '70', '2', '2019-11-14', null, '1', '2019-11-14', null, '10', '63973143', null, null, null);
INSERT INTO `trequests` VALUES ('28826104', '59525250', '雨伞', '0.5', '不仅能遮雨还能遮阳', '10', '20', '2', '2019-05-18 ', null, '2', '2019-07-18 ', null, '15', '71503978', '1', '1', '1');
INSERT INTO `trequests` VALUES ('29480080', '53460234', '手表', '0.88', '准时', '20', '70', '2', '2019-12-02', null, '2', '2019-12-02', '5903950', '0', '53460234', null, null, null);
INSERT INTO `trequests` VALUES ('29661710', '35848425', '充电宝', '0.9', '五万毫安', '30', '90', '1', '2019-12-02', '49713238', '1', '2019-12-16', '49713238', '0', '17500335', null, null, null);
INSERT INTO `trequests` VALUES ('34148754', '44739952', '红米手机', '0.8', '红米Note3', '1000', '2000', '2', '2019-11-15', null, '1', '2019-11-15', null, '1000', '63973143', null, null, null);
INSERT INTO `trequests` VALUES ('34515762', '6038435', '耳机', '0.8', '能用', '15', '25', '2', '2019-12-17', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('36883225', '44739952', '发圈', '0.9', '女生发圈', '10', '30', '2', '2019-11-15', null, '1', '2019-11-19', null, '10', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('37927411', '53460234', '屏保', '0.9', '电脑屏保', '30', '30', '1', '2019-12-02', '5903950', '1', '2019-12-16', '5903950', '0', '17500335', null, null, null);
INSERT INTO `trequests` VALUES ('38396275', '44739952', '化妆镜', '0.9', '女生化妆镜', '33', '99', '2', '2019-12-02', null, '1', '2019-12-15', null, '66', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('40888461', '44739952', '按摩仪', '0.9', '按摩，放松用的。', '100', '300', '2', '2019-11-15', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('41025605', '53460234', '鼠标垫', '0.8', '电脑鼠标垫', '9.9', '39.9', '1', '2019-12-02', '10716261', '1', '2019-12-15', '10716261', '0', '35848425', null, null, null);
INSERT INTO `trequests` VALUES ('41574632', '64572214', '贝雷帽子', '0.9', '王一博同款帽子。', '50', '100', '2', '2019-11-13', null, '1', '2019-11-13', null, '50', '64572214', null, null, null);
INSERT INTO `trequests` VALUES ('43179423', '35848425', '手机钢化膜', '1', '保护手机，防止摔碎屏', '10', '15', '1', '2019-12-15', '8854728', '2', '2019-12-15', '8854728', '0', '35848425', null, null, null);
INSERT INTO `trequests` VALUES ('44171758', '53460234', '耳机', '0.9', 'oppo耳机线', '9.9', '30', '1', '2019-12-02', '10716261', '2', '2019-12-15', null, '9.9', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('44559065', '71503978', '人民日报', '0.9', '', '10', '20', '1', '2019-10-31', '18490503', '1', '2019-11-01', '18490503', '0', '12123', null, null, null);
INSERT INTO `trequests` VALUES ('46470896', '61574799', '台灯', '0.98', '便携式台灯', '10.9', '50', '2', '2019-12-16', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('48860135', '6046943', '字帖', '0.8', '楷书练字字帖', '10', '30', '2', '2019-12-15', null, '1', '2019-12-16', null, '20', '6046943', null, null, null);
INSERT INTO `trequests` VALUES ('49965573', '71503978', '鸡胸肉', '1', '增肌,减脂均可食用，高蛋白。', '15', '40', '1', '2019-06-12 ', '57255891', '2', '2019-08-19', '57255891', '0', '59525250', '1', '1', '0');
INSERT INTO `trequests` VALUES ('50574614', '56615766', '唇膏', '0.9', '防止嘴干裂', '10', '20', '2', '2019-11-06', null, '1', '2019-11-13', null, '10', '56615766', null, null, null);
INSERT INTO `trequests` VALUES ('50587694', '36310332', '电脑鼠标', '0.8', '静音，黑色的。', '20', '40', '2', '2019-11-13', null, '1', '2019-11-13', null, '20', '64572214', null, null, null);
INSERT INTO `trequests` VALUES ('53058765', '36310332', '《浮生物语》', '0.9', '《浮生物语》系列书籍。', '10', '30', '2', '2019-11-13', null, '1', '2019-11-13', null, '10', '64572214', null, null, null);
INSERT INTO `trequests` VALUES ('55074321', '53460234', '扇子', '0.85', '汉服扇子', '20.99', '50', '1', '2019-12-02', '5903950', '2', '2019-12-02', '5903950', '0', '53460234', null, null, null);
INSERT INTO `trequests` VALUES ('57451108', '17500335', '水杯', '0.9', '多啦杯子', '11', '99', '2', '2019-12-16', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('61693955', '6038435', '乔丹篮球', '0.7', '没什么问题就可以', '50', '100', '1', '2019-12-15', '58142111', '1', '2019-12-15', '58142111', '0', '35848425', null, null, null);
INSERT INTO `trequests` VALUES ('64647570', '71503978', '自拍杆', '0.7', '可以用来自拍，拍摄角度还有距离变得更好', '20', '30', '1', '2019-07-25', '98744319', '1', '2019-08-25', '98744319', '0', '24729147', '1', '1', '1');
INSERT INTO `trequests` VALUES ('65728843', '17500335', '水杯', '0.9', '多啦杯子', '11', '99', '2', '2019-12-16', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('67470926', '35848425', '雨衣', '0.9', '中号雨衣', '2', '16', '1', '2019-12-02', '5903950', '1', '2019-12-15', '5903950', '0', '12123', null, null, null);
INSERT INTO `trequests` VALUES ('69783712', '53460234', '纸杯', '0.9', '一次性纸杯', '10', '30', '1', '2019-11-15', '47848176', '2', '2019-11-15', null, '10', '49913287', null, null, null);
INSERT INTO `trequests` VALUES ('72590587', '71503978', '美颜相机', '0.7', '自带美颜效果', '500', '1000', '1', '2019-08-23', '98744319', '1', '2019-10-26', null, '0', '69597689', '1', '1', '1');
INSERT INTO `trequests` VALUES ('73425360', '44739952', '接口转换器', '0.9', '电脑接口转换器。', '10', '30', '2', '2019-11-15', null, '1', '2019-11-15', null, '10', '44739952', '1', null, null);
INSERT INTO `trequests` VALUES ('74289385', '44739952', '马克杯', '0.9', '粉色的。', '10', '30', '2', '2019-11-13', null, '1', '2019-11-14', null, '10', '36310332', '1', null, null);
INSERT INTO `trequests` VALUES ('76692176', '44739952', '烤箱', '0.7', '小型烤箱', '15', '99', '2', '2019-11-07', null, '1', '2019-11-13', null, '15', '44739952', '1', null, '1');
INSERT INTO `trequests` VALUES ('77117508', '61574799', '杯子', '0.8', '黑色的。', '19', '29.99', '2', '2019-12-16', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('77755540', '63973143', '学士服', '0.9', '拍毕业照用的。', '30', '100', '2', '2019-11-14', null, '1', '2019-11-15', null, '30', '44739952', null, null, null);
INSERT INTO `trequests` VALUES ('80349348', '35848425', '发夹', '0.6', '夹碎发用的', '2', '10', '1', '2019-11-27', '49713238', '2', '2019-12-15', null, '2', '61574799', null, null, null);
INSERT INTO `trequests` VALUES ('80888921', '61574799', '鼠标垫', '0.9', '联想笔记本鼠标垫', '10', '30', '2', '2019-12-15', null, '1', '2019-12-15', null, '20', '61574799', null, null, null);
INSERT INTO `trequests` VALUES ('81656525', '12123', '笔记本电脑', '0.8', '可以用，不卡就行', '1500', '2500', '2', '2019-12-15', null, '1', '2019-12-16', null, '1500', '61574799', null, null, null);
INSERT INTO `trequests` VALUES ('82117273', '71503978', '英语读物', '0.6', '中英互译', '10', '20', '1', '2019-09-25', '98744319', '2', '2019-11-13', null, '10', '71503978', null, null, null);
INSERT INTO `trequests` VALUES ('82605568', '49913287', '读卡器', '0.9', '电脑读卡器', '10', '30', '2', '2019-11-15', null, '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('82650062', '71503978', '1L大水杯', '0.8', '用来日常的喝水', '20', '30', '1', '2019-11-06', '48853395', '2', '2019-11-13', null, '20', '71503978', null, null, null);
INSERT INTO `trequests` VALUES ('85777834', '36310332', '维达纸巾', '0.9', '小包的，方便携带。', '10', '30', '2', '2019-11-13', null, '1', '2019-11-13', null, '10', '36310332', null, null, null);
INSERT INTO `trequests` VALUES ('87366003', '53460234', '自嗨锅', '0.9', '海底捞自嗨锅', '10', '60', '2', '2019-11-15', null, '1', '2019-11-15', null, '10', '49913287', '1', null, null);
INSERT INTO `trequests` VALUES ('91249572', '44739952', '滑板', '0.8', '滑板滑板', '100', '200', '1', '2019-12-16', '63378503', '0', null, null, null, null, null, null, null);
INSERT INTO `trequests` VALUES ('91361341', '71503978', '围巾', '0.9', '1111111', '100', '200', '2', '2019-11-13', null, '1', '2019-11-13', null, '100', '36310332', null, null, null);
INSERT INTO `trequests` VALUES ('93503824', '44739952', '瑜伽垫', '0.7', '可以做瑜伽的瑜伽垫，耐脏。', '10', '60', '2', '2019-11-13', null, '1', '2019-11-13', null, '10', '64572214', null, null, null);
INSERT INTO `trequests` VALUES ('94739611', '64572214', '墨镜', '0.7', '太阳眼镜。', '10', '30', '2', '2019-11-13', null, '1', '2019-11-13', null, '10', '64572214', null, null, null);
INSERT INTO `trequests` VALUES ('97841196', '35848425', '雨伞', '0.6', '遮阳伞', '45', '50', '1', '2019-11-27', null, '2', '2019-12-16', null, '47.5', '35848425', null, null, null);
INSERT INTO `trequests` VALUES ('99413201', '53460234', '郁金香花束', '0.9', '包装好看的', '20', '50', '1', '2019-12-02', '10716261', '2', '2019-12-15', null, '20', '17500335', null, null, null);

-- ----------------------------
-- Table structure for tsystemmessage
-- ----------------------------
DROP TABLE IF EXISTS `tsystemmessage`;
CREATE TABLE `tsystemmessage` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_user` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `message` varchar(200) NOT NULL,
  `message_date` varchar(50) NOT NULL,
  `isRead` int(11) NOT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_tsystemAndtuser_user` (`_user`),
  CONSTRAINT `fk_tsystemAndtuser_user` FOREIGN KEY (`_user`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=444555667 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tsystemmessage
-- ----------------------------
INSERT INTO `tsystemmessage` VALUES ('123456', '71503978', '更新', '今晚将会有个更新', '2019-10-20', '1');
INSERT INTO `tsystemmessage` VALUES ('11568451', '2633246', '你好', '发就发', '2019-10-31', '0');
INSERT INTO `tsystemmessage` VALUES ('33882433', '12123', '大萨达撒多', '奥术大师多撒', '2019-12-16', '0');
INSERT INTO `tsystemmessage` VALUES ('56799253', '12123', '阿凡达你是覅你覅', '反对三覅你十分恼怒的念佛i啊 ', '2019-12-15', '1');
INSERT INTO `tsystemmessage` VALUES ('59255554', '12123', '院运会来啦', '周日信息技术学院院运会来啦', '2019-10-31', '1');
INSERT INTO `tsystemmessage` VALUES ('64362376', '24729147', '艾弗森发', '发发', '2019-10-31', '0');
INSERT INTO `tsystemmessage` VALUES ('69381921', '71503978', '升级通知', '凌晨1点到5点会有维护', '2019-10-30', '1');
INSERT INTO `tsystemmessage` VALUES ('111222333', '71503978', '优惠促销', '下载APP，全场五折。', '2019-10-20', '1');
INSERT INTO `tsystemmessage` VALUES ('444555666', '71503978', '粤食越湘', '新店开张，正宗湘菜味', '2019-10-21', '1');

-- ----------------------------
-- Table structure for tthings
-- ----------------------------
DROP TABLE IF EXISTS `tthings`;
CREATE TABLE `tthings` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_owner` int(11) NOT NULL,
  `thing_name` varchar(50) NOT NULL,
  `new_old` float NOT NULL,
  `memo` varchar(200) NOT NULL,
  `price` float NOT NULL,
  `exchangeable` int(11) NOT NULL,
  `publish_date` varchar(50) NOT NULL,
  `finished` int(11) NOT NULL,
  `finished_date` varchar(50) DEFAULT NULL,
  `_thing` int(11) DEFAULT NULL,
  `_buyer` int(11) DEFAULT NULL,
  `isComplaint` int(11) DEFAULT NULL,
  `isResist` int(11) DEFAULT NULL,
  `isJudged` int(11) DEFAULT NULL,
  `picture1` varchar(100) DEFAULT NULL,
  `picture2` varchar(100) DEFAULT NULL,
  `picture3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_tthingsAndtuser_owner` (`_owner`),
  KEY `fk_tthingsAndtuser_buyer` (`_buyer`),
  KEY `fk_tthingsAndtthings_thing` (`_thing`),
  CONSTRAINT `fk_tthingsAndtthings_thing` FOREIGN KEY (`_thing`) REFERENCES `tthings` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tthingsAndtuser_buyer` FOREIGN KEY (`_buyer`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tthingsAndtuser_owner` FOREIGN KEY (`_owner`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=631548542 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tthings
-- ----------------------------
INSERT INTO `tthings` VALUES ('386692', '35848425', '贴纸', '0.6', '可爱的贴纸', '8', '2', '2019-11-28', '1', '2019-12-05', null, '44739952', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.ri3e4MkJW48i9ad3d84d6114d7b3b27078823b145d2a.jpg', '', '');
INSERT INTO `tthings` VALUES ('4345588', '12123', 'wifi路由器', '0.9', '接收信号', '100', '1', '2019-12-16', '2', '2019-12-16', null, '6038435', '1', '1', null, 'feed.png', '', '');
INSERT INTO `tthings` VALUES ('5097534', '61574799', '梳子', '0.9', '头发不打结', '18', '2', '2019-12-15', '1', '2019-12-16', '5097534', '17500335', null, null, null, 'mmexport1576425366160.jpg', 'mmexport1576425364012.jpg', 'mmexport1576425359603.jpg');
INSERT INTO `tthings` VALUES ('5903950', '53460234', '大头贴', '5', '动物大头贴', '30', '2', '2019-12-02', '1', '2019-12-16', '5903950', '17500335', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.ELQW4OpEEsLq2b04df3ecc1d94afddff082d139c6f15.jpg', '', '');
INSERT INTO `tthings` VALUES ('6814661', '44739952', '乐扣保温杯', '0.7', '黑色', '99', '1', '2019-12-03', '2', '2019-12-05', null, '44739952', '1', '1', null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.tQCG54mtiEhEeeed87d382a2d45b55a60e4fdda15053.png', '', '');
INSERT INTO `tthings` VALUES ('8109267', '64572214', '牛肉丸面', '0.9', '潮汕牛肉丸面', '10', '1', '2019-11-13', '2', '2019-11-13', null, '36310332', '1', '1', '1', '', '', '');
INSERT INTO `tthings` VALUES ('8297649', '17500335', '台灯', '0.88', '宿舍夜用台灯', '88', '2', '2019-12-16', '0', null, null, null, null, null, null, 'tmp_dc89d0ac1a7b159da6cc6401bf56a78dfc405fc3b868929b.jpg', '', '');
INSERT INTO `tthings` VALUES ('8854728', '35848425', '卡通校章', '0.9', '哆啦的', '3', '2', '2019-11-28', '1', '2019-12-15', null, '35848425', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.oh9gqjziW5OOf996b2a6868e388602e927f567b93b06.jpg', '', '');
INSERT INTO `tthings` VALUES ('9883269', '71503978', '学士服', '0.9', '拍毕业照穿的、只穿过一次。穿上贼有气质。', '80', '1', '2019-05-26', '1', '2019-10-30', '12397957', '71503978', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('10716261', '53460234', '鲜花售卖', '20', '好看的花花', '60', '1', '2019-12-02', '1', '2019-12-15', '10716261', '35848425', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.44kOwLLbWL2xfafa5efeaf3cbe3b23b2748d13e629a1.jpg', '', '');
INSERT INTO `tthings` VALUES ('11304516', '17500335', '单车', '0.9', '黑色单车', '88', '2', '2019-12-16', '1', '2019-12-16', '11304516', '17500335', null, null, null, 'tmp_09d4580ea620302fa48d7e47eefdbf3ff761e2aa68b83728.jpg', '', '');
INSERT INTO `tthings` VALUES ('12397957', '14466010', '充电宝', '0.5', '20000毫安', '200', '2', '2019-06-21 ', '1', '2019-10-30', '9883269', '71503978', '0', '0', '0', '', '', '');
INSERT INTO `tthings` VALUES ('13562318', '95271087', '手机', '0.8', '用了一年的xx手机', '2000', '2', '2019-11-14', '0', null, null, null, null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('13609680', '6038435', '笔记本电脑', '0.6', '惠普', '2000', '1', '2019-12-15', '1', '2019-12-16', '13609680', '6038435', null, null, null, 'request.png', '', '');
INSERT INTO `tthings` VALUES ('13992229', '17500335', '单车', '0.9', '黑色单车', '88', '2', '2019-12-16', '1', '2019-12-16', null, '61574799', '1', '1', null, 'tmp_7102f142f6ce9ca7a346dbf1d52c347aa7825191d0c2f5a5.jpg', '', '');
INSERT INTO `tthings` VALUES ('14480117', '17500335', '鞋子', '0.9', 'aj鞋子', '99', '2', '2019-12-16', '0', null, null, null, null, null, null, 'tmp_d8aa5071cf1a5b40d67934e5d0266e449e4e45d5b32dfab8.jpg', '', '');
INSERT INTO `tthings` VALUES ('14928858', '12123', '俯卧撑器+哑铃', '0.8', '用来锻炼手臂力量、肱二头肌', '100', '1', '2019-10-30', '1', '2019-10-31', '18490503', '12123', null, null, null, 'request.png', 'second_hand.png', 'sell.png');
INSERT INTO `tthings` VALUES ('16953694', '40118734', '洗面奶', '0.6', '补水、保湿、抗痘', '100', '1', '2019-07-25', '1', '2019-10-30', '62509033', '71503978', null, null, null, 'Chrysanthemum.jpg', 'email.png', 'map.png');
INSERT INTO `tthings` VALUES ('18490503', '71503978', '黄道益活络油', '0.6', '专治跌打扭伤，肌肉酸肿疼痛，只用过几次，还有好多没用。', '40', '1', '2019-10-31', '1', '2019-11-01', '14928858', '12123', '1', null, null, 'web.png', '', '');
INSERT INTO `tthings` VALUES ('19289013', '35848425', '王一博的专辑《Fire》', '1', '王一博的专辑大卖！！！', '2', '2', '2019-11-28', '1', '2019-12-15', '19289013', '35848425', null, null, null, 'tmp_187560a59170be239945d78d0214a20b233541beb84f3c32.jpg', '', '');
INSERT INTO `tthings` VALUES ('19607665', '49913287', '动物园门票', '0.93', '广州长隆动物园门票', '39', '1', '2019-11-15', '0', null, null, null, null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('21696289', '44739952', '小黄鸭玩偶', '0.9', '可爱的，可以当抱枕。', '59.9', '1', '2019-12-16', '2', '2019-12-16', null, '61574799', '1', '1', null, 'mmexport1576470839371.jpg', 'mmexport1576470847247.jpg', 'mmexport1576470843103.jpg');
INSERT INTO `tthings` VALUES ('22729464', '71503978', '荣耀八青春版', '0.6', '换新手机了，这个手机不要了。64G内存', '500', '1', '2019-08-26', '1', '2019-10-26', '37531141', '12123', '1', null, null, 'search_web.png', '', '');
INSERT INTO `tthings` VALUES ('23291589', '6038435', 'iphonex', '0.7', '准备换手机了', '4000', '1', '2019-12-15', '1', '2019-12-15', '39383599', '35848425', null, null, null, 'apple.png', '', '');
INSERT INTO `tthings` VALUES ('24882963', '17500335', '暴龙眼镜', '0.8', '酷，帅', '100', '1', '2019-12-16', '2', '2019-12-16', null, '61574799', '1', '1', null, 'apple.png', 'email.png', 'feed.png');
INSERT INTO `tthings` VALUES ('27105621', '64572214', '鲜花', '0.9', '鲜花，好看的。', '49.9', '2', '2019-11-13', '0', null, null, null, null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('27148244', '12123', '眼镜', '0.9', '500度的黑色眼镜', '100', '1', '2019-12-16', '0', null, null, null, null, null, null, 'post.png', 'request.png', 'school.jpg');
INSERT INTO `tthings` VALUES ('27572122', '35848425', '海报', '20', '混合海报', '30', '2', '2019-11-28', '1', '2019-12-15', '27572122', '35848425', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.1ksmel024cJBc8eaf2a980143d0ce46721fa74e393ac.jpg', '', '');
INSERT INTO `tthings` VALUES ('30433097', '35848425', '盆栽', '0.9', '各种植物', '66', '2', '2019-11-28', '1', '2019-12-15', null, '44739952', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.VyCdAi9MtBEc43406c20faa9ef1eec52025e6fd17d52.jpg', '', '');
INSERT INTO `tthings` VALUES ('31253203', '13817817', '纸巾', '0.5', '挺好用的', '5', '2', '2019-09-27 ', '1', '2019-11-15', null, '44739952', '0', '0', '0', '', '', '');
INSERT INTO `tthings` VALUES ('31599800', '35848425', '卡通校章', '0.9', '哆啦的', '3', '2', '2019-11-28', '0', null, null, null, null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.iR9u9tyydiY06a715e5ea05be6b9e79a7666570de4e8.jpg', '', '');
INSERT INTO `tthings` VALUES ('31841883', '44739952', '多啦玩偶', '0.9', '好看的，舒服的', '59.9', '1', '2019-11-15', '2', '2019-11-20', null, '62363177', '1', '1', null, '', '', '');
INSERT INTO `tthings` VALUES ('32066844', '95271087', '手机', '0.8', '用了一年的xx手机', '2000', '2', '2019-11-14', '0', null, null, null, null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('36152302', '13817817', 'U盘', '0.5', '很方便的', '20', '1', '2019-10-27 ', '1', '2019-12-18', '69736761', '71503978', '1', '1', '1', 'mmexport1547121218573.jpg', 'marks.jpg', '');
INSERT INTO `tthings` VALUES ('37314508', '35848425', '海报', '0.99', '《请回答1988》', '23', '2', '2019-11-28', '0', null, null, null, null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('37531141', '86590146', '腹肌轮', '0.9', '锻炼全身肌肉', '25', '1', '2019-10-26', '2', '2019-11-15', '22729464', '44739952', null, null, null, 'marks.jpg', '', '');
INSERT INTO `tthings` VALUES ('38140387', '62363177', '鼠标', '0.9', '游戏鼠标', '50', '2', '2019-11-20', '1', '2019-11-23', null, '44739952', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('39383599', '35848425', '哆啦壁纸', '0.9', '好可爱的', '39', '2', '2019-11-28', '1', '2019-12-15', '23291589', '6038435', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.QRmpqWkPncRM442f2d557393feb1672ac74ca52c23e5.jpg', '', '');
INSERT INTO `tthings` VALUES ('39564905', '17500335', '鞋子', '0.9', 'aj鞋子', '99', '1', '2019-12-16', '0', null, null, null, null, null, null, 'tmp_12fe9a14938537521645ea3e9c5421d6f65449027d023706.jpg', '', '');
INSERT INTO `tthings` VALUES ('39787787', '44739952', '冰淇淋', '0.9', '好吃的冰淇淋', '29.9', '1', '2019-11-15', '2', '2019-11-15', null, '44739952', '1', null, null, '', '', '');
INSERT INTO `tthings` VALUES ('40811810', '35848425', '明信片', '0.9', '陈情令', '22', '2', '2019-11-28', '1', '2019-12-15', '45309423', '6038435', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.5IJHlKGU4KHU951f502cb4231ab635ea031425a429c2.jpg', '', '');
INSERT INTO `tthings` VALUES ('41222604', '49913287', '动物园门票', '0.93', '广州长隆动物园门票', '39', '1', '2019-11-15', '2', '2019-11-24', null, '44739952', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('41786215', '12123', '购物车', '0.7', '买东西用的', '30', '1', '2019-11-07', '1', '2019-12-15', '61844454', '12123', null, null, null, 'request.png', '', '');
INSERT INTO `tthings` VALUES ('42066277', '44739952', '壁纸', '0.9', '千与千寻壁纸', '18', '1', '2019-11-14', '1', '2019-11-14', '42066277', '63973143', '1', null, null, '', '', '');
INSERT INTO `tthings` VALUES ('42855696', '49913287', '胡一天', '0.9', '胡一天明信片', '29', '1', '2019-11-15', '2', '2019-11-15', null, '53460234', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('43971821', '35848425', '哆啦公仔', '0.9', '蓝色', '100', '2', '2019-12-02', '1', '2019-12-03', '43971821', '44739952', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.nGUZcRVz9VXXf996b2a6868e388602e927f567b93b06.jpg', '', '');
INSERT INTO `tthings` VALUES ('44518348', '35848425', '盆栽', '0.9', '各种植物', '66', '2', '2019-11-28', '2', '2019-12-16', null, '17500335', '1', null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.EqAS3VvPsJ3Q8fbc286c835482d68f49eb09a318f25f.jpg', '', '');
INSERT INTO `tthings` VALUES ('45309423', '6038435', 'android开发', '0.8', '从入门到精通', '15', '1', '2019-12-15', '1', '2019-12-15', '40811810', '35848425', null, null, null, 'map.png', '', '');
INSERT INTO `tthings` VALUES ('45686540', '12123', '耳机', '0.8', '好听', '20', '1', '2019-12-17', '0', null, null, null, null, null, null, 'tell.png', '', '');
INSERT INTO `tthings` VALUES ('46194358', '71503978', '校服', '0.7', '牛逼的校服', '15', '2', '2019-04-22 ', '2', '2019-06-22', null, '59525250', null, null, null, 'map.png', 'marks.jpg', 'post.png');
INSERT INTO `tthings` VALUES ('47848176', '53460234', '昨日青空画报', '0.9', '昨日青空电影画报', '30', '2', '2019-11-15', '1', '2019-11-15', null, '49913287', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('48853395', '71503978', '润唇膏', '0.9', '防止嘴巴裂开，嘴巴干燥', '12', '1', '2019-11-05', '2', '2019-11-13', null, '44739952', null, null, null, 'map.png', 'marks.jpg', '');
INSERT INTO `tthings` VALUES ('49713238', '12123', '奶茶', '1', 'MCHA，三分糖', '10', '1', '2019-11-15', '1', '2019-12-16', null, '17500335', null, null, null, 'request.png', 'school.jpg', 'search.png');
INSERT INTO `tthings` VALUES ('50081039', '35848425', '卡通校章', '0.9', '哆啦的', '3', '2', '2019-11-28', '2', '2019-12-15', null, '6038435', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.41y20okvZu2o442f2d557393feb1672ac74ca52c23e5.jpg', '', '');
INSERT INTO `tthings` VALUES ('51999027', '49913287', '动物园门票', '0.93', '广州长隆动物园门票', '39', '1', '2019-11-15', '2', '2019-11-19', null, '53460234', '1', null, '1', '', '', '');
INSERT INTO `tthings` VALUES ('52525721', '12123', '保温杯', '0.5', '太小了', '100', '1', '2019-04-19 ', '2', '2019-11-15', '75621723', '63973143', '0', '0', '0', '', '', '');
INSERT INTO `tthings` VALUES ('53000964', '35848425', '《侧耳倾听》海报', '1', '动漫海报', '100', '2', '2019-11-28', '1', '2019-12-13', '53000964', '44739952', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.OnMaZlVxA6Qv7529806dceb4a881622f1f8922eff6f7.jpg', '', '');
INSERT INTO `tthings` VALUES ('53242054', '44739952', '千与千寻海报', '0.7', '千与千寻电影的海报。', '19.9', '1', '2019-11-13', '2', '2019-11-13', null, '64572214', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('53369644', '17500335', '《长长的路我们慢慢走》', '0.8', '作者余光中', '15', '1', '2019-12-16', '1', '2019-12-16', '55457269', '35848425', null, null, null, 'post.png', 'request.png', 'school.jpg');
INSERT INTO `tthings` VALUES ('55318296', '35848425', '海报', '0.2', '混合海报', '30', '2', '2019-11-28', '2', '2019-12-16', null, '17500335', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.xd2nDWzFV21r2471ca396eba2f69b88daacaa8be07c6.jpg', '', '');
INSERT INTO `tthings` VALUES ('55353445', '71503978', '披风', '0.8', '好看的披风,注意长度,注意风度。', '50', '1', '2018-10-12 ', '2', '2019-10-19', '57255891', '59525250', '1', '1', '1', 'post.png', '', '');
INSERT INTO `tthings` VALUES ('55457269', '35848425', '海报', '0.99', '《请回答1988》', '23', '2', '2019-11-28', '1', '2019-12-16', '53369644', '17500335', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('57255891', '71503978', '毛概课本', '0.5', '毛泽东思想', '10', '2', '2018-10-12 ', '2', '2019-10-19', null, '59525250', '0', '0', '0', 'marks.jpg', '', '');
INSERT INTO `tthings` VALUES ('57797041', '35848425', '贴纸', '0.6', '可爱的贴纸', '8', '2', '2019-11-28', '0', null, null, null, null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.tDGkkJUNJQPLc8eaf2a980143d0ce46721fa74e393ac.jpg', '', '');
INSERT INTO `tthings` VALUES ('58142111', '6038435', 'AJ乔丹鞋', '0.6', '穿了挺久的，但是一点都没坏', '100', '1', '2019-12-15', '1', '2019-12-15', null, '35848425', null, null, null, 'post.png', '', '');
INSERT INTO `tthings` VALUES ('58932170', '13817817', '耳机', '0.5', '很新的', '50', '1', '2018-09-27 ', '1', '2019-11-19', '62509033', '71503978', '0', '0', '0', '', '', '');
INSERT INTO `tthings` VALUES ('59773669', '64572214', '鲜花', '0.9', '鲜花，好看的。', '49.9', '2', '2019-11-13', '0', null, null, null, null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('61844454', '35848425', '哆啦公仔', '0.9', '蓝色', '100', '2', '2019-12-02', '1', '2019-12-15', '41786215', '12123', '1', '1', '1', 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.7Gr6ztJOBelx9ad3d84d6114d7b3b27078823b145d2a.jpg', '', '');
INSERT INTO `tthings` VALUES ('62509033', '71503978', 'g7咖啡', '0.8', '提神醒脑、亢奋，由于买了太多，喝不完，现在想出售一些。', '20', '1', '2018-10-23', '1', '2019-10-30', null, '12123', '0', null, null, 'marks.jpg', '', '');
INSERT INTO `tthings` VALUES ('62981780', '71503978', '内存条', '0.7', '4G内存条，极大提高运行速度', '180', '1', '2019-10-30', '1', '2019-10-30', null, '12123', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('63378503', '44739952', '海报', '0.8', '动漫海报', '20', '2', '2019-12-16', '0', null, null, null, null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.BSurEeNxSiHO8b33d75d2e630f9abb3557c203f8e878.jpg', '', '');
INSERT INTO `tthings` VALUES ('68800302', '6046943', '保温杯', '0.9', '持久保温', '55', '2', '2019-12-15', '2', '2019-12-15', null, '6038435', null, null, null, 'mmexport1576420170165.jpg', 'mmexport1576420166317.jpg', 'mmexport1576420173887.jpg');
INSERT INTO `tthings` VALUES ('69736761', '71503978', '古龙香水', '0.6', '香气迷人', '50', '2', '2017-10-14 ', '2', '2019-08-19', null, '59525250', '0', '0', '0', '', '', '');
INSERT INTO `tthings` VALUES ('72069585', '35848425', '哆啦公仔', '0.9', '蓝色', '100', '2', '2019-12-02', '1', '2019-12-02', '72069585', '44739952', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.eTH1M5SR5nhxc94370aebc2cad8e08e21e0986662d79.jpg', '', '');
INSERT INTO `tthings` VALUES ('73306001', '44739952', '轻院风景图', '0.9', '广轻的风景图片。', '9.9', '2', '2019-11-13', '1', '2019-11-13', null, '36310332', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('75452528', '44739952', '长草君贴纸', '0.8', '可爱的长草君。', '9.9', '2', '2019-11-13', '1', '2019-11-14', '75452528', '63973143', '1', '1', null, '', '', '');
INSERT INTO `tthings` VALUES ('75621723', '13817817', '充电宝', '0.6', '10000毫安', '200', '2', '2018-09-21 ', '0', null, null, null, '0', '0', '0', '', '', '');
INSERT INTO `tthings` VALUES ('75921556', '53460234', '荒野行动', '0.9', '荒野行动壁纸', '13.99', '2', '2019-11-15', '1', '2019-11-15', null, '49913287', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('76503041', '53460234', '鲜花售卖', '20', '好看的花花', '60', '1', '2019-12-02', '1', '2019-12-02', '76503041', '44739952', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.Vl0gHex21S2rbdf3bf1da3405725be763540d6601144.jpg', '', '');
INSERT INTO `tthings` VALUES ('76702351', '61574799', '明星海报', '0.9', '明星海报，好看的。', '29.98', '2', '2019-12-15', '1', '2019-12-15', '76702351', '61574799', null, null, null, 'hdImg_ff7b97e56d2995088ef2360555f3301d1576159093889.jpg', 'img-95d9a203f5478f4528fe4add5ba2b042.jpg', '59420cd94696d1f9d53b7c64999bcffb.jpg');
INSERT INTO `tthings` VALUES ('78572170', '44739952', '蛋糕', '0.7', '好吃的蛋糕。', '29.9', '2', '2019-11-13', '1', '2019-11-13', null, '44739952', '1', null, null, '', '', '');
INSERT INTO `tthings` VALUES ('79831343', '61574799', '羽毛球拍', '0.9', '体育器材', '29.98', '1', '2019-12-15', '1', '2019-12-15', '79831343', '61574799', null, null, null, 'mmexport1576396272220.jpg', 'mmexport1576396263742.jpg', 'mmexport1576396267667.jpg');
INSERT INTO `tthings` VALUES ('80739911', '44739952', '手办', '0.9', '海贼王手办', '99.88', '2', '2019-12-16', '1', '2019-12-16', '80739911', '44739952', null, null, null, '超级截屏_20191216_121425.png', '超级截屏_20191216_121443.png', '超级截屏_20191216_121503.png');
INSERT INTO `tthings` VALUES ('82534089', '13817817', '充电宝', '0.5', '5000毫安', '200', '1', '2018-09-27 ', '2', '2019-11-18', null, '71503978', '0', '0', '0', 'search_web.png', 'marks.jpg', 'message.png');
INSERT INTO `tthings` VALUES ('83935421', '44739952', '晾衣架', '0.8', '宿舍阳台简易可折叠的小型晾衣架', '50', '2', '2019-12-15', '1', '2019-12-15', null, '61574799', '1', null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.OsbWWfq1n8t6e2cce2e0fe66a1fb8b090e556c7774c4.jpg', '', '');
INSERT INTO `tthings` VALUES ('85020927', '61574799', '小背包', '0.9', '好看，可爱的。', '19.99', '2', '2019-12-16', '1', '2019-12-16', null, '17500335', '1', '1', null, 'mmexport1576470781557.jpg', 'mmexport1576470789068.jpg', 'mmexport1576470797095.jpg');
INSERT INTO `tthings` VALUES ('85362678', '44739952', '搞笑图集', '0.9', '搞笑图集，开心。', '8.9', '1', '2019-11-14', '1', '2019-11-14', '85362678', '36310332', null, null, null, '', '', '');
INSERT INTO `tthings` VALUES ('86696224', '35848425', '贴纸', '0.6', '可爱的贴纸', '8', '2', '2019-11-28', '1', '2019-12-16', null, '17500335', null, null, null, 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.rPAFweTmiuyd6a715e5ea05be6b9e79a7666570de4e8.jpg', '', '');
INSERT INTO `tthings` VALUES ('87299972', '17500335', '鞋子', '0.9', 'aj鞋子', '99', '1', '2019-12-16', '0', null, null, null, null, null, null, 'tmp_b3246c233a110f3def04b27696a72f3fce0d9c2ae946133d.jpg', '', '');
INSERT INTO `tthings` VALUES ('87354620', '17500335', '单车', '0.9', '黑色单车', '99', '2', '2019-12-16', '0', null, null, null, null, null, null, 'tmp_5a361707619bf7719b2af2a1bb303380bc3970d0a9318079.jpg', '', '');
INSERT INTO `tthings` VALUES ('89408541', '42171527', '信封', '0.8', '封装信', '10', '1', '2019-10-30', '2', '2019-10-30', null, '71503978', null, null, null, 'email.png', '', '');
INSERT INTO `tthings` VALUES ('91724028', '44739952', '书签', '0.9', '书籍书签，好看的。', '9.98', '2', '2019-12-16', '0', null, null, null, null, null, null, 'mmexport1576469351367.jpg', 'mmexport1576469345068.jpg', 'mmexport1576469341333.jpg');
INSERT INTO `tthings` VALUES ('93889449', '64572214', '牛肉丸面', '0.9', '潮汕牛肉丸面', '10', '1', '2019-11-13', '2', '2019-11-14', null, '95271087', '1', '1', '1', '', '', '');
INSERT INTO `tthings` VALUES ('94858026', '12123', '饮水机', '0.4', '好看好用', '100', '1', '2018-09-19 ', '1', '2018-12-10', null, '23622042', '1', '1', '1', '', '', '');
INSERT INTO `tthings` VALUES ('97576625', '44739952', '罗技Pebble鼠标', '0.9', '可同时链接两台电脑，支持USB和蓝牙两种连接方式', '149', '2', '2019-12-15', '1', '2019-12-15', '97576625', '44739952', '1', null, null, 'tmp_0404fe3177ce859d1dad0eb932c0c939c410c00a87500761e51ff7053dbf570b.unknown', '', '');
INSERT INTO `tthings` VALUES ('97863057', '6046943', '滑板', '0.9', '好玩的滑板，好看的。', '99', '2', '2019-12-15', '2', '2019-12-15', null, '17500335', '1', null, null, 'mmexport1576419635341.jpg', 'mmexport1576419627758.jpg', 'mmexport1576419631798.jpg');
INSERT INTO `tthings` VALUES ('98744319', '71503978', '信息技术学院会服', '0.8', '当助班的时候穿过', '20', '1', '2018-10-22 ', '1', '2019-11-26', null, '69597689', null, null, null, 'marks.jpg', '', '');
INSERT INTO `tthings` VALUES ('631548541', '59525250', '单车', '0.8', '高端', '1000', '2', '2016-10-01 ', '1', '2019-12-05 ', null, '13817817', '0', '0', '0', '', '', '');

-- ----------------------------
-- Table structure for tthingscomplain
-- ----------------------------
DROP TABLE IF EXISTS `tthingscomplain`;
CREATE TABLE `tthingscomplain` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_thing` int(11) NOT NULL,
  `because` varchar(200) NOT NULL,
  `memo` varchar(500) DEFAULT NULL,
  `complain_date` varchar(50) NOT NULL,
  `photo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=98742037 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tthingscomplain
-- ----------------------------
INSERT INTO `tthingscomplain` VALUES ('879370', '55353445', '掉毛', '掉毛、褪色', '2019-09-20 ', '');
INSERT INTO `tthingscomplain` VALUES ('881704', '97863057', '一点都不好看', '没有那么酷炫', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('4686125', '51999027', '假的门票', '', '2019-11-19', null);
INSERT INTO `tthingscomplain` VALUES ('7555975', '42066277', '不好看', '', '2019-11-14', null);
INSERT INTO `tthingscomplain` VALUES ('11882664', '87366003', '量好少呀，与实际描述不符', '包装漏气了', '2019-11-25', null);
INSERT INTO `tthingscomplain` VALUES ('13054998', '83935421', '晾衣架是坏的，螺丝松动', '', '2019-12-15', null);
INSERT INTO `tthingscomplain` VALUES ('13348352', '97576625', '鼠标右键坏了', '右键不是很灵敏', '2019-12-15', null);
INSERT INTO `tthingscomplain` VALUES ('15380159', '6814661', '不保温', '', '2019-12-10', null);
INSERT INTO `tthingscomplain` VALUES ('21429248', '85020927', '太小了。', '不是很好看。', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('23702610', '1854705', '计时不准，老是延时。', '', '2019-11-19', null);
INSERT INTO `tthingscomplain` VALUES ('25086109', '39787787', '', '', '2019-12-09', null);
INSERT INTO `tthingscomplain` VALUES ('25424943', '16604887', '内存不符合大小', '', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('27129769', '76692176', '烤箱太小啦。', '', '2019-11-19', null);
INSERT INTO `tthingscomplain` VALUES ('32410677', '28826104', '不能遮阳', '内部是透明的，没有遮阳效果', '2019-10-20 ', '');
INSERT INTO `tthingscomplain` VALUES ('34687231', '22729464', '网络太差', '连不上wifi', '2019-11-01', 'feed.png');
INSERT INTO `tthingscomplain` VALUES ('37284160', '93889449', '不符合描述', '与实际不符合', '2019-11-14', null);
INSERT INTO `tthingscomplain` VALUES ('45667081', '36152302', '垃圾U盘，用了发热', '', '2019-09-20', '');
INSERT INTO `tthingscomplain` VALUES ('47466230', '64647570', '存在欺瞒现象', '自拍杆不能拉伸', '2019-10-25 ', '');
INSERT INTO `tthingscomplain` VALUES ('47910220', '74289385', '瓶盖破损漏水', '', '2019-12-10', null);
INSERT INTO `tthingscomplain` VALUES ('49427882', '14049376', '乱收费', '各种不必要的收费，比如服务费、彩铃费。', '2019-10-20 ', '');
INSERT INTO `tthingscomplain` VALUES ('51265498', '42066277', '壁纸质量不行', '', '2019-11-14', null);
INSERT INTO `tthingscomplain` VALUES ('56485044', '18490503', '效果贼差，商家有期满行为', '', '2019-11-01', '');
INSERT INTO `tthingscomplain` VALUES ('56568319', '75452528', '不值这个价钱', '', '2019-11-14', null);
INSERT INTO `tthingscomplain` VALUES ('65637666', '31841883', '与描述不符合', '表面有明显的毁坏', '2019-11-20', null);
INSERT INTO `tthingscomplain` VALUES ('66488688', '73425360', '接口转换器不发转换，发生松动。', '', '2019-11-19', null);
INSERT INTO `tthingscomplain` VALUES ('69269819', '72590587', '货不真实', '没有美颜效果，相机发热', '2019-10-30', '');
INSERT INTO `tthingscomplain` VALUES ('71422037', '39787787', '过期了', '', '2019-12-09', null);
INSERT INTO `tthingscomplain` VALUES ('74972363', '49965573', '变质了', '', '2019-10-25', 'Chrysanthemum.jpg');
INSERT INTO `tthingscomplain` VALUES ('77096946', '61844454', '太小了', '实物与图片差异太大', '2019-12-15', null);
INSERT INTO `tthingscomplain` VALUES ('77166998', '4345588', '差评', '信号不好', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('81794986', '78572170', '难吃', '', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('83077521', '94858026', '不干净', '残留着很多水垢', '2019-09-10 ', '');
INSERT INTO `tthingscomplain` VALUES ('87701561', '44518348', '盆栽泥土松动', '不好养活。', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('89623981', '24882963', '一点都不好看', '不是很适合我。', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('95505839', '21696289', '线散开了，没有缝好。', '难看，实际与图片相差较大。', '2019-12-16', null);
INSERT INTO `tthingscomplain` VALUES ('98742036', '13992229', '部分零件缺失', '很旧，很破。', '2019-12-16', null);

-- ----------------------------
-- Table structure for tthingscomplainjudge
-- ----------------------------
DROP TABLE IF EXISTS `tthingscomplainjudge`;
CREATE TABLE `tthingscomplainjudge` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_complain` int(11) NOT NULL,
  `judge` varchar(500) NOT NULL,
  `judge_date` varchar(50) NOT NULL,
  `isAccepted` int(11) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_judgeAndcomplain_complain` (`_complain`),
  CONSTRAINT `fk_judgeAndcomplain_complain` FOREIGN KEY (`_complain`) REFERENCES `tthingscomplain` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=96159847 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tthingscomplainjudge
-- ----------------------------
INSERT INTO `tthingscomplainjudge` VALUES ('778899', '83077521', '卖方存在狡辩行为', '2019-11-15', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('2255496', '45667081', '卖方说的对', '2019-10-20 ', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('3898003', '27129769', '仲裁成功', '2019-12-14 21:04:16', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('5242452', '47466230', '卖方的问题', '2019-10-25', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('5959782', '77096946', '大手大脚撒谎', '2019-12-16 19:42:45', '0');
INSERT INTO `tthingscomplainjudge` VALUES ('5990927', '32410677', '卖方说的对', '2019-10-20 ', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('14005146', '4686125', '好好的哈', '2019-12-14 21:08:24', '0');
INSERT INTO `tthingscomplainjudge` VALUES ('20573566', '879370', '卖方说法不实，具有期满行为。', '2019-12-14 22:38:04', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('40724500', '69269819', '卖方没问题', '2019-10-30 ', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('46791899', '879370', 'fnadosdnfoasdnfond', '2020-06-02 20:09:06', '0');
INSERT INTO `tthingscomplainjudge` VALUES ('67725423', '879370', 'sfafafsaf', '2020-06-02 20:02:46', '0');
INSERT INTO `tthingscomplainjudge` VALUES ('84159997', '23702610', '好好的哈', '2019-12-14 21:14:38', '0');
INSERT INTO `tthingscomplainjudge` VALUES ('84480766', '77096946', '卖方无误，买方问题。', '2019-12-15 14:08:22', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('88990011', '37284160', '买方说的对', '2019-11-14', '1');
INSERT INTO `tthingscomplainjudge` VALUES ('96159846', '879370', 'fnadosdnfoasdnfond', '2020-06-02 20:03:59', '0');

-- ----------------------------
-- Table structure for tthingscomplainphotos
-- ----------------------------
DROP TABLE IF EXISTS `tthingscomplainphotos`;
CREATE TABLE `tthingscomplainphotos` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_complain` int(11) NOT NULL,
  `photo` varchar(50) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63205675 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tthingscomplainphotos
-- ----------------------------
INSERT INTO `tthingscomplainphotos` VALUES ('25502398', '3385644', 'map.png');
INSERT INTO `tthingscomplainphotos` VALUES ('63205674', '68891091', 'web.png');

-- ----------------------------
-- Table structure for tthingscomplainresist
-- ----------------------------
DROP TABLE IF EXISTS `tthingscomplainresist`;
CREATE TABLE `tthingscomplainresist` (
  `_id` int(11) NOT NULL,
  `_complain` int(11) NOT NULL,
  `resist` varchar(300) NOT NULL,
  `resist_date` varchar(50) NOT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_complainAndresist_complain` (`_complain`),
  CONSTRAINT `fk_complainAndresist_complain` FOREIGN KEY (`_complain`) REFERENCES `tthingscomplain` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tthingscomplainresist
-- ----------------------------
INSERT INTO `tthingscomplainresist` VALUES ('3570476', '77096946', '图片仅供参考，具体以实物为准', '2019-12-15');
INSERT INTO `tthingscomplainresist` VALUES ('3611535', '47466230', '不好意思，让你体验感这么差，我一定弥补你的损失', '2019-10-25 ');
INSERT INTO `tthingscomplainresist` VALUES ('5560546', '45667081', '电脑的热量传给u盘的，质量没问题', '2019-10-20');
INSERT INTO `tthingscomplainresist` VALUES ('6297801', '65637666', '表面的损坏实在运输过程中造成的，是属于快递服务的责任。', '2019-11-20');
INSERT INTO `tthingscomplainresist` VALUES ('19961969', '83077521', '正常现象', '2019-11-15');
INSERT INTO `tthingscomplainresist` VALUES ('25061739', '49427882', '这些收费都是有必要的。。请见谅！', '2019-10-25 ');
INSERT INTO `tthingscomplainresist` VALUES ('33854081', '15380159', '真的是保温杯', '2019-12-10');
INSERT INTO `tthingscomplainresist` VALUES ('46120314', '69269819', '相机用久了是会变热的', '2019-10-30');
INSERT INTO `tthingscomplainresist` VALUES ('52794549', '74972363', '运输的途中变质的，原本没变质。', '2019-10-26');
INSERT INTO `tthingscomplainresist` VALUES ('55539623', '37284160', '对方诬陷我', '2019-11-14');
INSERT INTO `tthingscomplainresist` VALUES ('55706927', '21429248', '本来就是小背包，容量不是很大。', '2019-12-16');
INSERT INTO `tthingscomplainresist` VALUES ('60241667', '89623981', '很好看的。', '2019-12-16');
INSERT INTO `tthingscomplainresist` VALUES ('70802311', '32410677', '该伞用了特殊的材质，用来阻挡紫外线', '2019-10-20 ');
INSERT INTO `tthingscomplainresist` VALUES ('72285006', '98742036', '零件没有缺失。', '2019-12-16');
INSERT INTO `tthingscomplainresist` VALUES ('73142897', '879370', '洗的方式不正确。。', '2019-10-25');
INSERT INTO `tthingscomplainresist` VALUES ('80081745', '56568319', '就是这个价钱', '2019-11-20');
INSERT INTO `tthingscomplainresist` VALUES ('81642326', '77166998', '12345', '2019-12-16');
INSERT INTO `tthingscomplainresist` VALUES ('92094959', '95505839', '买家骗人', '2019-12-16');

-- ----------------------------
-- Table structure for tthingsphoto
-- ----------------------------
DROP TABLE IF EXISTS `tthingsphoto`;
CREATE TABLE `tthingsphoto` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_thing` int(11) NOT NULL,
  `photo` varchar(200) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94723341 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tthingsphoto
-- ----------------------------
INSERT INTO `tthingsphoto` VALUES ('7808472', '68945709', 'message.png');
INSERT INTO `tthingsphoto` VALUES ('22338643', '32360018', 'map.png');
INSERT INTO `tthingsphoto` VALUES ('29203399', '63476136', 'map.png');
INSERT INTO `tthingsphoto` VALUES ('30199233', '35099192', 'tell.png');
INSERT INTO `tthingsphoto` VALUES ('31352406', '68945709', 'marks.jpg');
INSERT INTO `tthingsphoto` VALUES ('41709908', '123456', 'school.jpg');
INSERT INTO `tthingsphoto` VALUES ('57619925', '35099192', 'web.png');
INSERT INTO `tthingsphoto` VALUES ('62440425', '123456', 'tell.png');
INSERT INTO `tthingsphoto` VALUES ('76997022', '68945709', 'map.png');
INSERT INTO `tthingsphoto` VALUES ('77400215', '35099192', 'search_web.png');
INSERT INTO `tthingsphoto` VALUES ('77417745', '12397957', '暴风截图2019227129850593.jpg');
INSERT INTO `tthingsphoto` VALUES ('79465841', '12397957', '暴风截图2019227129850953.jpg');
INSERT INTO `tthingsphoto` VALUES ('94723340', '75621723', '暴风截图2019227129850593.jpg');

-- ----------------------------
-- Table structure for ttrade
-- ----------------------------
DROP TABLE IF EXISTS `ttrade`;
CREATE TABLE `ttrade` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_thing` int(11) NOT NULL,
  `finished_date` varchar(50) NOT NULL,
  `finished` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `getThing` int(11) DEFAULT NULL,
  `seller_id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL,
  PRIMARY KEY (`_id`),
  KEY `fk_tradeAnduser_buyer` (`buyer_id`),
  KEY `fk_tradeAndthing_thing` (`getThing`),
  KEY `fk_tradeAnduser_seller` (`seller_id`),
  CONSTRAINT `fk_tradeAndthing_thing` FOREIGN KEY (`getThing`) REFERENCES `tthings` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tradeAnduser_buyer` FOREIGN KEY (`buyer_id`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tradeAnduser_seller` FOREIGN KEY (`seller_id`) REFERENCES `tuser` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98798504 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ttrade
-- ----------------------------
INSERT INTO `ttrade` VALUES ('956848', '31253203', '2019-10-18', '2', '5', null, '13817817', '59525250');
INSERT INTO `ttrade` VALUES ('5601554', '55353445', '2019-10-19 8:17', '2', '50', null, '71503978', '59525250');
INSERT INTO `ttrade` VALUES ('5750611', '6666', '2019', '2', '100', null, '14466010', '71503978');
INSERT INTO `ttrade` VALUES ('9208315', '52525721', '2033', '2', '0', '75621723', '59525250', '75146075');
INSERT INTO `ttrade` VALUES ('9700447', '28826104', '2019-10-18 16:17:30', '2', '15', null, '71503978', '59525250');
INSERT INTO `ttrade` VALUES ('17793832', '36152302', '2033', '2', '0', '75621723', '13817817', '59525250');
INSERT INTO `ttrade` VALUES ('22189917', '9511420', '2019-10-16', '2', '100', null, '12123', '71503978');
INSERT INTO `ttrade` VALUES ('24416903', '778899', '2020-10-18', '1', '0', '94858026', '71503978', '12123');
INSERT INTO `ttrade` VALUES ('24606091', '6666', '2019', '2', '200', null, '14466010', '71503978');
INSERT INTO `ttrade` VALUES ('43723552', '778899', '2019-10-18', '2', '1000', null, '71503978', '12123');
INSERT INTO `ttrade` VALUES ('49771802', '49965573', '2019-10-19', '2', '0', '57255891', '59525250', '71503978');
INSERT INTO `ttrade` VALUES ('53393447', '82534089', '2020-10-18', '2', '200', null, '13817817', '71503978');
INSERT INTO `ttrade` VALUES ('53803962', '631548541', '2019-10-05 10:05:20', '1', '1000', null, '59525250', '13817817');
INSERT INTO `ttrade` VALUES ('56627282', '111222333', '2033', '2', '0', '75621723', '59525250', '75146075');
INSERT INTO `ttrade` VALUES ('62567857', '6666', '2019-10-05 15:05:05', '2', '0', '12397957', '14466010', '12123');
INSERT INTO `ttrade` VALUES ('64452127', '36152302', '2019-10-18', '1', '0', '69736761', '13817817', '71503978');
INSERT INTO `ttrade` VALUES ('65809696', '46194358', '2019-10-22', '2', '15', null, '71503978', '59525250');
INSERT INTO `ttrade` VALUES ('74381910', '789456', '2033', '1', '50', null, '59525250', '75146075');
INSERT INTO `ttrade` VALUES ('80003794', '69736761', '2019-10-19 8:16', '2', '50', null, '71503978', '59525250');
INSERT INTO `ttrade` VALUES ('85829984', '57255891', '2019-10-19', '2', '10', null, '71503978', '59525250');
INSERT INTO `ttrade` VALUES ('97116858', '31253203', '2033', '1', '100', null, '59525250', '75146075');
INSERT INTO `ttrade` VALUES ('98798503', '14049376', '2019-10-19', '2', '20', null, '59525250', '71503978');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `_id` int(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `mobile` varchar(200) NOT NULL,
  `weixin` varchar(200) NOT NULL,
  `department` varchar(200) NOT NULL,
  `_class` varchar(200) NOT NULL,
  `photo` varchar(200) DEFAULT NULL,
  `register_date` varchar(50) NOT NULL,
  `state` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=98776746 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('12123', 'answer', '827ccb0eea8a706c4c34a16891f84e7b', '刘文鑫', '13798355665', '123', '信息技术学院', '软件172', 'marks.jpg', '2017-01-12', '1', '10');
INSERT INTO `tuser` VALUES ('1002787', 'liuwenxin', '827ccb0eea8a706c4c34a16891f84e7b', '鑫鑫', '123', '1111111', '信息技术', 'software', '微信图片_20190324152357.jpg', '2019-02-14 ', '1', '0');
INSERT INTO `tuser` VALUES ('2633246', 'suhuaqin', '827ccb0eea8a706c4c34a16891f84e7b', '华勤', '123', '123', '123', '123', '微信图片_20190324152357.jpg', '2019-03-14 ', '1', '0');
INSERT INTO `tuser` VALUES ('6038435', 'lisi', '827ccb0eea8a706c4c34a16891f84e7b', '李四', '13798355665', '123', '信息技术学院', '软件172', 'marks.jpg', '2019-12-15', '1', '1');
INSERT INTO `tuser` VALUES ('6046943', '15876157978', '25f9e794323b453885f5181f1b624d0b', '刘惠珊', '15876157978', 'lhsweixin0703', '信息技术学院', '软件172', 'mmexport1525393851436.jpg', '2019-12-15', '1', '1');
INSERT INTO `tuser` VALUES ('7132366', '2967017365@qq.com', '9d4d6204ee943564637f06093236b181', 'liu', '15876157979', 'weixin', '信息技术学院', '软件172', 'mmexport1547121211142.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('10895129', '123456787@qq.com', '25f9e794323b453885f5181f1b624d0b', 'Change', '13531323814', 'changeweiixn', '信息技术学院', '软件172', 'mmexport1547121211142.jpg', '2019-11-18', '1', '1');
INSERT INTO `tuser` VALUES ('11058012', '15876157777', '25f9e794323b453885f5181f1b624d0b', 'kaola2', '15876157777', 'kaolaweixn', '信息技术学院', 'soft172', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.C1GoHYqtPnup2b04df3ecc1d94afddff082d139c6f15.jpg', '2019-12-02', '1', '1');
INSERT INTO `tuser` VALUES ('13817817', '12123', '202cb962ac59075b964b07152d234b70', '666', '123', '123', '信息', '666', 'Chrysanthemum.jpg', '2019-04-16 ', '2', '0');
INSERT INTO `tuser` VALUES ('13826318', '15876157872', '25f9e794323b453885f5181f1b624d0b', 'kaola', '15876157872', '123456789', '信息技术学院', '软件172', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.z0YRL3liCQfW2b04df3ecc1d94afddff082d139c6f15.jpg', '2019-11-29', '1', '1');
INSERT INTO `tuser` VALUES ('14466010', 'chouchou', '202cb962ac59075b964b07152d234b70', '臭臭', '123', '123', '信息', '软件', 'Chrysanthemum.jpg', '2019-05-21 ', '1', '1');
INSERT INTO `tuser` VALUES ('16527336', 'call', 'e10adc3949ba59abbe56e057f20f883e', '刘惠珊', '15876157979', '15876157979weixin', '信息技术学院', '软件172', 'mmexport1572431444787.jpg', '2019-11-01', '1', '1');
INSERT INTO `tuser` VALUES ('17500335', '13533221100', 'e10adc3949ba59abbe56e057f20f883e', 'huhu', '13533221100', 'weixinhuhu', '信息技术学院', '软件172', 'wxaf62c8d89eb6ad72.o6zAJs0wsPW5JraFNSEJMRqaAgiA.oLtJCHccj4yC9ad3d84d6114d7b3b27078823b145d2a.jpg', '2019-12-15', '1', '1');
INSERT INTO `tuser` VALUES ('17514491', '15876157589', '25f9e794323b453885f5181f1b624d0b', '于金华', '15876157589', '12345679', '信息技术学院', '软件172', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.jPAMKH9oujJBfafa5efeaf3cbe3b23b2748d13e629a1.jpg', '2019-11-29', '1', '1');
INSERT INTO `tuser` VALUES ('19906056', 'liuhao', '202cb962ac59075b964b07152d234b70', '刘浩', '123', '123', '123', '123', 'Chrysanthemum.jpg', '2019-10-28', '1', '1');
INSERT INTO `tuser` VALUES ('23622042', 'dasha', '202cb962ac59075b964b07152d234b70', '小可爱', '123', '123', 'xx', 'yy', '暴风截图2019227129850953.jpg', '2019-06-16 ', '1', '0');
INSERT INTO `tuser` VALUES ('24729147', 'hongbin', '827ccb0eea8a706c4c34a16891f84e7b', '陈鸿彬', '123', '123', '123', '123', 'marks.jpg', '2019-07-23 ', '2', '1');
INSERT INTO `tuser` VALUES ('27317396', 'songzhou', '202cb962ac59075b964b07152d234b70', '陈松州', '123', '123', '123', '123', '侧耳倾听08.jpg', '2019-10-28', '1', '1');
INSERT INTO `tuser` VALUES ('32849342', '1111', '698d51a19d8a121ce581499d7b701668', '1', '289', 'hj', '1', '1', '', '2019-10-31', '1', '1');
INSERT INTO `tuser` VALUES ('33104683', 'daye', '202cb962ac59075b964b07152d234b70', '大爷', '123', '123', '信息', '软件', 'Chrysanthemum.jpg', '2019-08-04 ', '1', '1');
INSERT INTO `tuser` VALUES ('35848425', 'zhangsan', '827ccb0eea8a706c4c34a16891f84e7b', '张三', '13798355665', 'xin13798355665', '信息技术学院', '软件172', '微信图片_20190324152357.jpg', '2019-11-15', '2', '1');
INSERT INTO `tuser` VALUES ('36310332', '123456783@qq.com', '25f9e794323b453885f5181f1b624d0b', '颜沫', '15876157979', 'yanmo15876157979', '信息技术学院', '软件172', 'mmexport1547121218573.jpg', '2019-11-13', '1', '1');
INSERT INTO `tuser` VALUES ('39695104', 'yaozhi', '827ccb0eea8a706c4c34a16891f84e7b', '石耀之', '13798355665', 'yaozhi', '信息技术学院', '软件172', 'tell.png', '2019-10-31', '1', '1');
INSERT INTO `tuser` VALUES ('40118734', 'wenbin', '202cb962ac59075b964b07152d234b70', '艾文斌', '456', '456', '123', '123', 'Chrysanthemum.jpg', '2019-10-25', '1', '1');
INSERT INTO `tuser` VALUES ('42171527', 'dabenzhong', '202cb962ac59075b964b07152d234b70', '大笨钟', '123', '123', '123', '123', 'map.png', '2019-10-30', '1', '1');
INSERT INTO `tuser` VALUES ('43665090', '123456799@qq.com', '827ccb0eea8a706c4c34a16891f84e7b', '刘惠珊同学', '15876157979', '15876157979weixin', '信息技术学院', '软件172', 'mmexport1547121218573.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('44739952', '13531323814', '25f9e794323b453885f5181f1b624d0b', 'Bill', '13531323814', 'hujie13531323822', '信息技术学院', '软件172', 'img-1191040301f905a7ab49ea845f110044.jpg', '2019-11-07', '1', '1');
INSERT INTO `tuser` VALUES ('44825046', '15876187956', '0266e33d3f546cb5436a10798e657d97', 'liu', '15876187956', '信息', 'xxxxx', 'xx', 'img-2eaf641dead11af885ba721e5c095e4b.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('45486203', 'haofei', '827ccb0eea8a706c4c34a16891f84e7b', '郝飞', '13798355665', '123', '信息技术学院', '软件172', 'email.png', '2019-11-06', '1', '1');
INSERT INTO `tuser` VALUES ('46833891', '123456789@qq.com', '58d350d4328e91f9a6b0f67305611ff9', '刘惠珊同学', '15876157979', '15876157979weixin', '信息技术学院', '软件172', 'mmexport1547121218573.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('49913287', '1234567896@qq.com', '25f9e794323b453885f5181f1b624d0b', 'Bandary', '15876157979', 'lhs125876157979', '信息技术学院', '软件172', 'img-ca6806f670d9cc45555ecb574695321c.jpg', '2019-11-15', '1', '1');
INSERT INTO `tuser` VALUES ('51541659', 'call2', '202cb962ac59075b964b07152d234b70', '133', '3684850', '245', '信息技术学院', '234', 'mmexport1572431437043.jpg', '2019-11-01', '1', '1');
INSERT INTO `tuser` VALUES ('53460234', '123456785@qq.com', '25f9e794323b453885f5181f1b624d0b', 'Amazy', '13531323814', 'weixinhao', '信息技术学院', '软件172', 'mmexport1527434114902.jpg', '2019-11-15', '1', '1');
INSERT INTO `tuser` VALUES ('54788928', '15876157878', '25f9e794323b453885f5181f1b624d0b', 'kaola', '15876157878', 'kaolameiyouweixin', '信息技术学院', 'soft172', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.9xFVqGlETtEn2b04df3ecc1d94afddff082d139c6f15.jpg', '2019-11-29', '1', '1');
INSERT INTO `tuser` VALUES ('56615766', 'junjie', 'e10adc3949ba59abbe56e057f20f883e', '俊杰', '13798355665', 'junjie', '信息技术学院', '软件163', 'apple.png', '2019-10-31', '1', '1');
INSERT INTO `tuser` VALUES ('58696285', '15876157676', '25f9e794323b453885f5181f1b624d0b', 'kaola03', '15876157676', 'kaola', '信息技术学院', 'soft172', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.xwTDiuWqCBcv2b04df3ecc1d94afddff082d139c6f15.jpg', '2019-12-02', '1', '1');
INSERT INTO `tuser` VALUES ('59346936', 'jiayong', '202cb962ac59075b964b07152d234b70', '马佳勇', '123', '123', '123', '123', 'feed.png', '2019-10-31', '1', '1');
INSERT INTO `tuser` VALUES ('59525250', 'yantong', 'e10adc3949ba59abbe56e057f20f883e', '炎烔', '123', '123', '123', '123', 'marks.jpg', '2019-09-14 ', '1', '0');
INSERT INTO `tuser` VALUES ('59660803', '15876158686', '25f9e794323b453885f5181f1b624d0b', 'kaola03', '15876158686', 'kaola', '信息技术学院', 'soft172', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.xwTDiuWqCBcv2b04df3ecc1d94afddff082d139c6f15.jpg', '2019-12-02', '1', '1');
INSERT INTO `tuser` VALUES ('61213379', '13531323815', '25f9e794323b453885f5181f1b624d0b', 'Document', '13531323815', 'documentWeixin', '信息技术学院', '软件172', 'mmexport1527434033873.jpg', '2019-11-18', '1', '1');
INSERT INTO `tuser` VALUES ('61574799', '15876157979', '25f9e794323b453885f5181f1b624d0b', '刘惠珊', '15876157978', 'wei15876157979', '信息技术学院', '软件172', 'mmexport1527434107780.jpg', '2019-12-15', '1', '1');
INSERT INTO `tuser` VALUES ('61923632', 'luwei', '202cb962ac59075b964b07152d234b70', '卢炜', '123', '123', '123', '123', 'request.png', '2019-10-28', '1', '1');
INSERT INTO `tuser` VALUES ('62363177', 'ABC', '827ccb0eea8a706c4c34a16891f84e7b', '欧阳', '13060644233', '1939557454', '信息技术学院', '软件172', '', '2019-11-20', '1', '1');
INSERT INTO `tuser` VALUES ('63973143', '123456784@qq.com', '25f9e794323b453885f5181f1b624d0b', '天线宝宝', '13531323814', 'lhsweixinlixian', '信息技术学院', '软件172', 'mmexport1512228551075.jpg', '2019-11-14', '1', '1');
INSERT INTO `tuser` VALUES ('64572214', 'liu', '25f9e794323b453885f5181f1b624d0b', '刘同学', '15876157979', 'lhs15876157979', '信息技术学院', '软件172', 'img-9566a9d0a808962be95948afbed6d5b5.jpg', '2019-11-13', '1', '1');
INSERT INTO `tuser` VALUES ('66563760', 'huishan', '550a141f12de6341fba65b0ad0433500', '惠珊', '123', '123', '123', '123', '', '2019-12-11 ', '1', '1');
INSERT INTO `tuser` VALUES ('69597689', 'jintao', '202cb962ac59075b964b07152d234b70', '林金涛', '123', '123', '123', '123', 'Chrysanthemum.jpg', '2019-10-26', '1', '1');
INSERT INTO `tuser` VALUES ('70304253', '2967017362@qq.com', '58d350d4328e91f9a6b0f67305611ff9', '刘惠珊', '15876157979', '没有微信', '信息技术学院', '软件172', 'mmexport1547121232795.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('71503978', 'weisheng', 'e10adc3949ba59abbe56e057f20f883e', '伟生', '13798355665', '123', '信息技术学院', '软件172', 'email.png', '2019-10-11 ', '1', '1');
INSERT INTO `tuser` VALUES ('72638001', 'jinyuan', '202cb962ac59075b964b07152d234b70', '金源', '123', '123', '123', '123', '', '2019-10-11 ', '1', '1');
INSERT INTO `tuser` VALUES ('75146075', 'xiangxiang', 'e10adc3949ba59abbe56e057f20f883e', '香香', '123', '123', '信息', '软件', '', '2019-09-21 ', '1', '1');
INSERT INTO `tuser` VALUES ('75487223', 'zixuan', '202cb962ac59075b964b07152d234b70', '梓轩', '123', '123', '123', '123', 'me.png', '2019-10-30', '1', '1');
INSERT INTO `tuser` VALUES ('80974336', '15876187997', '0266e33d3f546cb5436a10798e657d97', 'liu', '15876187997', '信息', 'xxxxx', 'xx', 'img-2eaf641dead11af885ba721e5c095e4b.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('84574374', '13690175681', '854d9fca60b4bd07f9bb215d59ef5561', '刘回答', '578', '47', '信息', '软件', 'pt2019_10_04_21_16_31.jpg', '2019-11-02', '1', '1');
INSERT INTO `tuser` VALUES ('86590146', 'canjie', '202cb962ac59075b964b07152d234b70', '洪灿杰', '123', '123', '123', '123', 'request.png', '2019-10-26', '1', '1');
INSERT INTO `tuser` VALUES ('87650514', 'guangyao', '202cb962ac59075b964b07152d234b70', '广耀', '123', '123', '123', '123', 'second_hand.png', '2019-10-26', '1', '1');
INSERT INTO `tuser` VALUES ('92384178', 'hujie', '827ccb0eea8a706c4c34a16891f84e7b', '胡杰', '123', '123', '123', '123', '', '2019-11-11 ', '1', '1');
INSERT INTO `tuser` VALUES ('92858745', 'sugerui', 'e10adc3949ba59abbe56e057f20f883e', '苏国锐', '13798355665', '123', '信息技术学院', '软件171', 'search_web.png', '2019-11-06', '1', '1');
INSERT INTO `tuser` VALUES ('93365772', '123', '6512bd43d9caa6e02c990b0a82652dca', '刘惠珊', '15876157979', 'weixin', '信息技术学院', '软件172', 'mmexport1572431437043.jpg', '2019-11-01', '1', '1');
INSERT INTO `tuser` VALUES ('95271087', 'AAA', 'e10adc3949ba59abbe56e057f20f883e', '姚广耀', '13060644233', '123456', '信息技术学院', '软件172', 'apple.png', '2019-11-14', '1', '1');
INSERT INTO `tuser` VALUES ('95837410', '123456780@qq.com', '25f9e794323b453885f5181f1b624d0b', '企鹅', '15876157272', 'qieweixin', 'zoo', 'animal', 'wxaf62c8d89eb6ad72.o6zAJswpMFUe_1IGpoaWEqOJCoFc.hIvVa14b4GAv9d377b10ce778c4938b3c7e2c63a229a.jpg', '2019-12-02', '1', '1');
INSERT INTO `tuser` VALUES ('98776745', '93365772', '81dc9bdb52d04dc20036dbd8313ed055', '姓名', '1234', '微信', '信息', '班级', 'mmexport1572431437043.jpg', '2019-11-01', '1', '1');
