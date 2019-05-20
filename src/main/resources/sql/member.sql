-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.21 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 member 的数据库结构
CREATE DATABASE IF NOT EXISTS `member` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `member`;

-- 导出  表 member.card 结构
CREATE TABLE IF NOT EXISTS `card` (
  `card_id` varchar(15) NOT NULL COMMENT '卡id=电话号',
  `card_grade` int(11) DEFAULT NULL COMMENT '会员等级(0 普通 1 vip 2 贵宾)',
  `card_balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `card_points` decimal(10,2) DEFAULT NULL COMMENT '积分',
  `card_create_time` datetime DEFAULT NULL COMMENT '开卡时间',
  `card_pay_times` int(11) DEFAULT NULL COMMENT '累计消费次数',
  `card_pay_money` decimal(10,2) DEFAULT NULL COMMENT '累计消费金额',
  `card_charge_times` int(11) DEFAULT NULL COMMENT '累计充值次数',
  `card_charge_momey` decimal(10,2) DEFAULT NULL COMMENT '累计充值金额',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  member.card 的数据：~15 rows (大约)
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` (`card_id`, `card_grade`, `card_balance`, `card_points`, `card_create_time`, `card_pay_times`, `card_pay_money`, `card_charge_times`, `card_charge_momey`) VALUES
	('10068', 2, 0.00, 0.00, '2019-05-16 21:42:25', 0, 0.00, 0, 0.00),
	('15277361363', 0, 0.00, 0.00, '2019-05-16 21:38:51', 0, 0.00, 0, 0.00),
	('15277361367', 2, 0.00, 0.00, '2019-05-16 21:39:54', 0, 0.00, 0, 0.00),
	('15277361368', 1, 0.00, 0.00, '2019-05-16 21:40:33', 0, 0.00, 0, 0.00),
	('1600300000', 2, 5000.00, 56781.00, '2019-05-06 22:08:09', 0, 0.00, 0, 0.00),
	('1600300620', 0, 2000.00, 992640.00, '2019-05-05 20:08:00', 5, 100.00, 0, 300.00),
	('1600300625', 0, 6000000.00, 200000.00, '2019-05-07 11:36:39', 0, 0.00, 0, 0.00),
	('1600300626', 2, 600000.00, 1587250.00, '2019-05-06 18:28:41', 0, 0.00, 0, 0.00),
	('1600300699', 0, 0.00, 0.00, '2019-05-08 01:12:49', 0, 0.00, 0, 0.00),
	('1600300996', 0, 0.00, 0.00, '2019-05-06 18:22:08', 0, 0.00, 0, 0.00),
	('21214654', 2, 0.00, 0.00, '2019-05-16 22:04:43', 0, 0.00, 0, 0.00),
	('432908743', 2, 0.00, 0.00, '2019-05-16 22:03:34', 0, 0.00, 0, 0.00),
	('777888', 0, 0.00, 0.00, '2019-05-16 21:57:18', 0, 0.00, 0, 0.00),
	('78561456', 2, 0.00, 0.00, '2019-05-16 22:05:27', 0, 0.00, 0, 0.00),
	('80710', 0, 0.00, 0.00, '2019-05-17 18:40:28', 0, 0.00, 0, 0.00),
	('8784841', 2, 0.00, 0.00, '2019-05-16 22:00:23', 0, 0.00, 0, 0.00),
	('8820', 1, 0.00, 0.00, '2019-05-16 21:58:51', 0, 0.00, 0, 0.00);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;

-- 导出  表 member.chargeinfo 结构
CREATE TABLE IF NOT EXISTS `chargeinfo` (
  `charge_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值id',
  `charge_catd_id` bigint(20) DEFAULT NULL COMMENT '充值卡号',
  `charge_method` int(11) DEFAULT NULL COMMENT '充值方式(0 现金 1 支付宝 2 微信)',
  `charge_money` decimal(10,2) DEFAULT NULL COMMENT '充值金额',
  `charge_time` datetime DEFAULT NULL COMMENT '充值时间',
  `charge_handler` varchar(10) DEFAULT NULL COMMENT '处理者',
  PRIMARY KEY (`charge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  member.chargeinfo 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `chargeinfo` DISABLE KEYS */;
INSERT INTO `chargeinfo` (`charge_id`, `charge_catd_id`, `charge_method`, `charge_money`, `charge_time`, `charge_handler`) VALUES
	(1, 123, 0, 300.00, '2019-05-05 20:10:33', 'zhangsan');
/*!40000 ALTER TABLE `chargeinfo` ENABLE KEYS */;

-- 导出  表 member.goods 结构
CREATE TABLE IF NOT EXISTS `goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `goods_img` varchar(100) DEFAULT NULL COMMENT '商品图片',
  `goods_points` decimal(10,2) DEFAULT NULL COMMENT '商品积分',
  `goods_left` int(11) DEFAULT NULL COMMENT '商品剩余个数',
  `goods_desc` varchar(100) DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 正在导出表  member.goods 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`goods_id`, `goods_name`, `goods_img`, `goods_points`, `goods_left`, `goods_desc`) VALUES
	(12, '玩具熊', NULL, 100.00, 88, '本店推出的定制版小熊，可爱又好康'),
	(13, '水杯', NULL, 50.00, 95, '可以喝水的水杯，自动加水。应付淡水资源缺乏，始于非洲等缺水地区。'),
	(14, '贵重物品', NULL, 5000.00, 100, '真的很贵！'),
	(15, '很便宜的东西', NULL, 1.00, 120, '只用1积分，还不便宜吗？');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;

-- 导出  表 member.manager 结构
CREATE TABLE IF NOT EXISTS `manager` (
  `manager_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `manager_name` varchar(10) DEFAULT NULL COMMENT '管理员姓名',
  `manager_username` varchar(30) DEFAULT NULL COMMENT '管理员用户名',
  `manager_password` varchar(30) DEFAULT NULL COMMENT '管理员密码',
  `manager_last_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `manager_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  member.manager 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`manager_id`, `manager_name`, `manager_username`, `manager_password`, `manager_last_time`, `manager_create_time`) VALUES
	(2, 'zhangsan', 'zhangsan', '123', '2019-05-16 22:36:59', '2019-05-05 20:11:22');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- 导出  表 member.member 结构
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_grade` int(11) DEFAULT NULL COMMENT '会员等级(0 普通 1 vip 2 贵宾)',
  `member_name` varchar(10) DEFAULT NULL COMMENT '会员姓名',
  `member_sex` varchar(1) DEFAULT NULL COMMENT '会员性别(M 男 F 女)',
  `member_birthday` date DEFAULT NULL COMMENT '会员生日',
  `member_phone` varchar(15) DEFAULT NULL COMMENT '会员电话=会员卡ID',
  `member_join_time` datetime DEFAULT NULL COMMENT '会员加入时间',
  `member_handler` varchar(10) DEFAULT NULL COMMENT '处理者名',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=139804 DEFAULT CHARSET=utf8;

-- 正在导出表  member.member 的数据：~17 rows (大约)
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`member_id`, `member_grade`, `member_name`, `member_sex`, `member_birthday`, `member_phone`, `member_join_time`, `member_handler`) VALUES
	(139777, 0, '张三', 'M', '2019-05-05', '1600300996', '2019-05-05 20:06:12', 'zhangsan'),
	(139778, 0, '老王1', 'M', '2019-05-22', '1600300625', '2019-05-06 17:41:34', 'zhangsan'),
	(139783, 2, '老王2', 'M', '2019-03-06', '1600300626', '2019-05-06 18:29:04', 'zhangsan'),
	(139785, 0, '贵宾会员', 'M', '2019-05-07', '1600300699', '2019-05-06 22:08:09', 'zhangsan'),
	(139788, 2, 'song', 'F', '2019-05-17', '1600300600', '2019-05-07 17:23:29', 'zhangsan'),
	(139789, 0, '宁某人', 'F', '2019-05-17', '1600300620', '2019-05-07 17:23:59', 'zhangsan'),
	(139793, 0, 'wjc', 'F', '2019-05-11', '15277361363', '2019-05-16 21:38:51', 'zhangsan'),
	(139794, 2, 'wjc2', 'M', '2019-05-26', '15277361367', '2019-05-16 21:39:54', 'zhangsan'),
	(139795, 1, 'nx', 'M', '2019-05-10', '15277361368', '2019-05-16 21:40:33', 'zhangsan'),
	(139796, 2, '王杰城', 'M', '2019-05-25', '10068', '2019-05-16 21:42:25', 'zhangsan'),
	(139797, 0, 'lisisa', 'F', '2019-05-03', '777888', '2019-05-16 21:57:18', 'zhangsan'),
	(139798, 1, '89485', 'M', '2019-05-31', '8820', '2019-05-16 21:58:51', 'zhangsan'),
	(139799, 2, 'anifsp', 'M', '2019-05-10', '8784841', '2019-05-16 22:00:23', 'zhangsan'),
	(139800, 2, '487', 'M', '2019-05-23', '432908743', '2019-05-16 22:03:34', 'zhangsan'),
	(139801, 2, '211', 'F', '2019-05-18', '21214654', '2019-05-16 22:04:43', 'zhangsan'),
	(139802, 2, '张三', 'F', '2019-05-25', '78561456', '2019-05-16 22:05:27', 'zhangsan'),
	(139803, 0, '老王', 'M', '2019-05-19', '80710', '2019-05-17 18:40:28', 'zhangsan');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

-- 导出  表 member.payinfo 结构
CREATE TABLE IF NOT EXISTS `payinfo` (
  `pay_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消费id',
  `pay_card_id` bigint(20) DEFAULT NULL COMMENT '卡id',
  `pay_kind` int(11) DEFAULT NULL COMMENT '消费类别(0 住宿 1 商品 2 服务)',
  `pay_desc` varchar(50) DEFAULT NULL COMMENT '消费描述',
  `pay_money` decimal(10,2) DEFAULT NULL COMMENT '消费金额',
  `pay_method` int(11) DEFAULT NULL COMMENT '支付方式(0 现金 1 支付宝 2 微信)',
  `pay_time` datetime DEFAULT NULL COMMENT '消费时间',
  `pay_handler` varchar(10) DEFAULT NULL COMMENT '处理者',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  member.payinfo 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `payinfo` DISABLE KEYS */;
INSERT INTO `payinfo` (`pay_id`, `pay_card_id`, `pay_kind`, `pay_desc`, `pay_money`, `pay_method`, `pay_time`, `pay_handler`) VALUES
	(1, 123, 0, '住宿', 100.00, 0, '2019-05-05 20:13:08', 'zhangsan');
/*!40000 ALTER TABLE `payinfo` ENABLE KEYS */;

-- 导出  表 member.points_exchange_record 结构
CREATE TABLE IF NOT EXISTS `points_exchange_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `record_goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `record_card_id` varchar(15) DEFAULT NULL COMMENT '会员卡id',
  `record_exchange_num` int(11) DEFAULT NULL COMMENT '兑换数量',
  `record_exchange_time` datetime DEFAULT NULL COMMENT '兑换时间',
  `record_handler` varchar(10) DEFAULT NULL COMMENT '处理者(名称)',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- 正在导出表  member.points_exchange_record 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `points_exchange_record` DISABLE KEYS */;
INSERT INTO `points_exchange_record` (`record_id`, `record_goods_id`, `record_card_id`, `record_exchange_num`, `record_exchange_time`, `record_handler`) VALUES
	(12, 12, '1600300626', 1, '2019-05-16 21:07:24', 'zhangsan'),
	(13, 12, '1600300626', 12, '2019-05-16 21:19:05', 'zhangsan'),
	(14, 12, '1600300626', 1, '2019-05-16 21:19:32', 'zhangsan'),
	(15, 13, '1600300626', 2, '2019-05-16 22:28:49', 'zhangsan'),
	(16, 12, '1600300626', 114, '2019-05-17 17:09:10', 'zhangsan'),
	(17, 13, '1600300626', 5, '2019-05-17 17:51:48', 'zhangsan');
/*!40000 ALTER TABLE `points_exchange_record` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
