/*
Navicat MySQL Data Transfer

Source Server         : gzw
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : ioss

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-07-20 17:41:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kb_ods_itsm_maininfo
-- ----------------------------
DROP TABLE IF EXISTS `kb_ods_itsm_maininfo`;
CREATE TABLE `kb_ods_itsm_maininfo` (
  `event_id` varchar(32) NOT NULL COMMENT '事件单号',
  `report_area` varchar(32) DEFAULT NULL COMMENT '报告地区',
  `reportor` varchar(32) DEFAULT NULL COMMENT '提交人',
  `commit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `event_title` varchar(256) DEFAULT NULL COMMENT '事件标题',
  `event_descr` varchar(4096) DEFAULT NULL COMMENT '事件描述',
  `event_type` varchar(32) DEFAULT NULL COMMENT '事件类型',
  `event_classify` varchar(32) DEFAULT NULL COMMENT '事件分类',
  `owner_system` varchar(32) DEFAULT NULL COMMENT '归属系统',
  `owner_module` varchar(32) DEFAULT NULL COMMENT '归属模块',
  `sub_module` varchar(32) DEFAULT NULL COMMENT '子模块',
  `func_menu` varchar(128) DEFAULT NULL COMMENT '功能模块',
  `affect_range` varchar(32) DEFAULT NULL COMMENT '影响范围',
  `affect_degree` varchar(32) DEFAULT NULL COMMENT '影响度',
  `critical_degree` varchar(32) DEFAULT NULL COMMENT '紧急程度',
  `pri` varchar(32) DEFAULT NULL COMMENT '优先级',
  `event_source` varchar(32) DEFAULT NULL COMMENT '事件来源',
  `event_status` varchar(32) DEFAULT NULL COMMENT '事件状态',
  `status_reason` varchar(32) DEFAULT NULL COMMENT '事件理由',
  `solve_code` varchar(32) DEFAULT NULL COMMENT '解决代码',
  `close_code` varchar(32) DEFAULT NULL COMMENT '关闭代码',
  `current_deal_group` varchar(32) DEFAULT NULL COMMENT '当前受理组织',
  `current_dealor` varchar(32) DEFAULT NULL COMMENT '当前受理人',
  `solution` varchar(4096) DEFAULT NULL COMMENT '解决方案',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
