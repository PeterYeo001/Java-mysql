/*
SQLyog Ultimate v8.32 
MySQL - 5.0.96-community-nt : Database - wms
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wms`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL auto_increment,
  `goodsname` varchar(50) NOT NULL,
  `goodsstyle` varchar(50) NOT NULL,
  `goodsnumber` int(11) NOT NULL,
  `storageID` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goodsname`,`goodsstyle`,`goodsnumber`,`storageID`) values (1,'农夫山泉','矿泉水',10,1),(4,'冰峰','饮料',5,2),(6,'百事可乐','饮料',20,2);

/*Table structure for table `storage` */

DROP TABLE IF EXISTS `storage`;

CREATE TABLE `storage` (
  `id` int(11) NOT NULL auto_increment,
  `storagename` varchar(50) NOT NULL,
  `storagestyle` varchar(50) NOT NULL,
  `storageID` int(11) NOT NULL,
  PRIMARY KEY  (`id`,`storageID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `storage` */

insert  into `storage`(`id`,`storagename`,`storagestyle`,`storageID`) values (1,'日常用品','存货',1),(2,'饮品副食','存货',3),(3,'电子电器','出货',2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `userpwd` varchar(50) NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`userpwd`,`flag`) values (1,'yzh','123',2),(2,'lw','456',1),(3,'byp','123',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
