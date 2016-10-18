DROP DATABASE IF EXISTS missbe;
CREATE DATABASE IF NOT EXISTS missbe;
use missbe;

#--����Ա�ʻ�
DROP TABLE IF EXISTS admin_inf;
CREATE TABLE IF NOT EXISTS admin_inf(
   id int primary key AUTO_INCREMENT,
   username varchar(20) NOT NULL,
   userpass varchar(20) NOT NULL,
   update_time datetime
);
#--��ȡenjoykorea������
DROP TABLE IF EXISTS `enjoykorea_spider`;
CREATE TABLE IF NOT EXISTS `enjoykorea_spider` (
  `ID` int(64) NOT NULL AUTO_INCREMENT COMMENT 'Ψһ��ʶ',
  `Title` varchar(100) NOT NULL COMMENT '����',
  `Tags` varchar(50) NOT NULL COMMENT '����',
  `Author` varchar(50) NOT NULL COMMENT '����',
  `Date` datetime NOT NULL COMMENT '��������',
  `View` int(64) NOT NULL COMMENT '�鿴',
  `Comment` int(64) NOT NULL COMMENT '����',
  `Content` MEDIUMTEXT CHARACTER SET utf8mb4  COMMENT '����',
  `Url` varchar(100) NOT NULL UNIQUE,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

#--��ȡinckr��̳������
DROP TABLE IF EXISTS `inckr_spider`;
CREATE TABLE IF NOT EXISTS `inckr_spider` (
  `ID` int(64) NOT NULL AUTO_INCREMENT COMMENT 'Ψһ��ʶ',
  `Title` varchar(100) NOT NULL COMMENT '����',
  `Tags` varchar(50) NOT NULL COMMENT '����',
  `Author` varchar(50) NOT NULL COMMENT '����',
  `Date` datetime NOT NULL COMMENT '��������',
  `View` int(64) NOT NULL COMMENT '�鿴',
  `Comment` int(64) NOT NULL COMMENT '����',
  `Content` MEDIUMTEXT CHARACTER SET utf8mb4  COMMENT '����',
  `Url` varchar(100) NOT NULL UNIQUE,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

#--���ڲ�������������
DROP TABLE IF EXISTS test;
CREATE TABLE IF NOT EXISTS test(
   id int primary key AUTO_INCREMENT,
   author varchar(50)  NOT NULL COMMENT '����', 
   view int(64) NOT NULL COMMENT '�鿴',
   comment int(64) NOT NULL COMMENT '����' 
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

#--�û��������ݲ���
DROP TABLE IF EXISTS `HappyKorea_Activepersonnelrank`;
CREATE TABLE `HappyKorea_Activepersonnelrank` (
`Rank`  int(32) NOT NULL AUTO_INCREMENT COMMENT '����' ,
`Author`  varchar(100) NOT NULL COMMENT '����' ,
`Postnumber`  int(32) NOT NULL COMMENT '������' ,
`Websitename`  varchar(100) NULL COMMENT '��վ��' ,
PRIMARY KEY (`Rank`),
UNIQUE INDEX (`Rank`) 
)DEFAULT CHARACTER SET=utf8;

#--�����ݽ��в��봦��
INSERT INTO test(author,view,comment)
SELECT Author,View,Comment
FROM enjoykorea_spider;

#--ѡ��ǰ10����������
select * from (select distinct * from test limit 10) aa 
order by view desc,comment desc;

#--��������ѡ��ǰ10��
select * from ( 
select * from test 
order by view desc,comment desc) aa 
limit 10;

#--ѡ������
select distinct author,Postnumber from HappyKorea_Activepersonnelrank 
limit 10;
��״ͼ-��Ծ��Աͳ�Ʊ�
����ͼ-��Ծ��Աͳ�Ʊ�
��״ͼ-��Ծ��Աͳ�Ʊ�
�������û�����

#--��ʾ��������
show variables like '%max_allowed_packet%';


