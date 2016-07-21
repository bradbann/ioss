/*
Navicat MySQL Data Transfer

Source Server         : gzw
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : ioss

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-07-20 17:41:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kb_ods_itsm_dealinfo
-- ----------------------------
DROP TABLE IF EXISTS `kb_ods_itsm_dealinfo`;
CREATE TABLE `kb_ods_itsm_dealinfo` (
  `event_id` varchar(32) NOT NULL COMMENT '事件单号',
  `step_id` int(11) NOT NULL COMMENT '步骤',
  `commitor` varchar(256) DEFAULT NULL COMMENT '提交人',
  `commit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `file_numbers` int(11) DEFAULT NULL COMMENT '文件数',
  `deal_suggest` varchar(4096) DEFAULT NULL COMMENT '处理意见',
  `next_deal_group` varchar(32) DEFAULT NULL COMMENT '下一受理组',
  `next_dealor` varchar(32) DEFAULT NULL COMMENT '下一受理人',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`event_id`,`step_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
