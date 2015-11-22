CREATE DATABASE frog;

CREATE TABLE `partners` (
  `id` bigint(20) NOT NULL auto_increment,
  `api_key` varchar(255) NOT NULL,
  `enabled` int NOT NULL DEFAULT 1,
  `created_at` datetime default NULL,
  `main_phone` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL auto_increment,
  ckey varchar(255) NOT NULL,
  enabled int NOT NULL DEFAULT 1,
  name varchar(255) null,
  description varchar(4096) null,
  main_phone varchar(64) null,
  partner_id bigint(20) NOT NULL,
  `created_at` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;