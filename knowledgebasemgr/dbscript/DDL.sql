DROP DATABASE if exists `ioss`;
CREATE DATABASE `ioss`;

USE `ioss`;

DROP TABLE if exists `hotword`;
CREATE TABLE `hotword` (
  `hotword` varchar(200) NOT NULL DEFAULT '',
  `count` int(11) DEFAULT NULL,
  `searchTime` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`hotword`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE if exists `kb_ods_itsm_dealinfo`;
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

DROP TABLE IF exists `kb_ods_itsm_maininfo`;
CREATE TABLE `kb_ods_itsm_maininfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` varchar(32) DEFAULT NULL COMMENT '事件单号',
  `report_area` text COMMENT '报告地区',
  `reportor` text COMMENT '提交人',
  `commit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `event_title` text COMMENT '事件标题',
  `event_descr` text COMMENT '事件描述',
  `event_type` text COMMENT '事件类型',
  `event_classify` text COMMENT '事件分类',
  `owner_system` text COMMENT '归属系统',
  `owner_module` text COMMENT '归属模块',
  `sub_module` text COMMENT '子模块',
  `func_menu` text COMMENT '功能模块',
  `affect_range` text COMMENT '影响范围',
  `affect_degree` text COMMENT '影响度',
  `critical_degree` text COMMENT '紧急程度',
  `pri` text COMMENT '优先级',
  `event_source` text COMMENT '事件来源',
  `event_status` text COMMENT '事件状态',
  `status_reason` text COMMENT '事件理由',
  `solve_code` longtext COMMENT '解决代码',
  `close_code` text COMMENT '关闭代码',
  `current_deal_group` text COMMENT '当前受理组织',
  `current_dealor` text COMMENT '当前受理人',
  `solution` longtext COMMENT '解决方案',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `request_id` varchar(255) COMMENT '访问ID',
  `entry_id` varchar(255) COMMENT '工单实体ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sync_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sync_type` varchar(255) DEFAULT NULL,
  `sync_url` varchar(255) DEFAULT NULL,
  `sync_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
