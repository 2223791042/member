/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.17 : Database - member
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`member` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `member`;

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `schedule_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程id',
  `schedule_name` varchar(100) DEFAULT NULL COMMENT '日程名称',
  `schedule_addr` varchar(100) DEFAULT NULL COMMENT '日程地点',
  `schedule_time` varchar(50) DEFAULT NULL COMMENT '日程时间',
  `schedule_status` int(11) DEFAULT NULL COMMENT '日程状态(0 未完成 1完成)',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `schedule` */

insert  into `schedule`(`schedule_id`,`schedule_name`,`schedule_addr`,`schedule_time`,`schedule_status`) values (1,'打游戏','宿舍','今天下午',0),(2,'睡觉','宿舍','今天晚上',1),(3,'敲代码','社团','今天晚上',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
