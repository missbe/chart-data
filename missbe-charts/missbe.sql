DROP DATABASE IF EXISTS missbe;
CREATE DATABASE IF NOT EXISTS missbe;
use missbe;

#--管理员帐户
DROP TABLE IF EXISTS admin_inf;
CREATE TABLE IF NOT EXISTS admin_inf(
   id int primary key AUTO_INCREMENT,
   username varchar(20) NOT NULL,
   userpass varchar(20) NOT NULL,
   update_time datetime
);
#--获取enjoykorea的数据
DROP TABLE IF EXISTS `enjoykorea_spider`;
CREATE TABLE IF NOT EXISTS `enjoykorea_spider` (
  `ID` int(64) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `Title` varchar(100) NOT NULL COMMENT '标题',
  `Tags` varchar(50) NOT NULL COMMENT '分类',
  `Author` varchar(50) NOT NULL COMMENT '作者',
  `Date` datetime NOT NULL COMMENT '发帖日期',
  `View` int(64) NOT NULL COMMENT '查看',
  `Comment` int(64) NOT NULL COMMENT '评论',
  `Content` MEDIUMTEXT CHARACTER SET utf8mb4  COMMENT '内容',
  `Url` varchar(100) NOT NULL UNIQUE,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

#--获取inckr论坛的数据
DROP TABLE IF EXISTS `inckr_spider`;
CREATE TABLE IF NOT EXISTS `inckr_spider` (
  `ID` int(64) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `Title` varchar(100) NOT NULL COMMENT '标题',
  `Tags` varchar(50) NOT NULL COMMENT '分类',
  `Author` varchar(50) NOT NULL COMMENT '作者',
  `Date` datetime NOT NULL COMMENT '发帖日期',
  `View` int(64) NOT NULL COMMENT '查看',
  `Comment` int(64) NOT NULL COMMENT '评论',
  `Content` MEDIUMTEXT CHARACTER SET utf8mb4  COMMENT '内容',
  `Url` varchar(100) NOT NULL UNIQUE,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

#--用于测试数据所建表
DROP TABLE IF EXISTS test;
CREATE TABLE IF NOT EXISTS test(
   id int primary key AUTO_INCREMENT,
   author varchar(50)  NOT NULL COMMENT '作者', 
   view int(64) NOT NULL COMMENT '查看',
   comment int(64) NOT NULL COMMENT '评论' 
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

#--用户排名数据测试
DROP TABLE IF EXISTS `HappyKorea_Activepersonnelrank`;
CREATE TABLE `HappyKorea_Activepersonnelrank` (
`Rank`  int(32) NOT NULL AUTO_INCREMENT COMMENT '排名' ,
`Author`  varchar(100) NOT NULL COMMENT '作者' ,
`Postnumber`  int(32) NOT NULL COMMENT '发帖量' ,
`Websitename`  varchar(100) NULL COMMENT '网站名' ,
PRIMARY KEY (`Rank`),
UNIQUE INDEX (`Rank`) 
)DEFAULT CHARACTER SET=utf8;

#--对数据进行插入处理
INSERT INTO test(author,view,comment)
SELECT Author,View,Comment
FROM enjoykorea_spider;

#--选择前10个进行排序
select * from (select distinct * from test limit 10) aa 
order by view desc,comment desc;

#--先排序再选择前10个
select * from ( 
select * from test 
order by view desc,comment desc) aa 
limit 10;

#--选择数据
select distinct author,Postnumber from HappyKorea_Activepersonnelrank 
limit 10;
饼状图-活跃人员统计表
折线图-活跃人员统计表
柱状图-活跃人员统计表
发帖量用户走向

#--显示最大包数据
show variables like '%max_allowed_packet%';


