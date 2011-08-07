-- MySQL dump 10.13  Distrib 5.1.55, for Win32 (ia32)
--
-- Host: localhost    Database: fhp
-- ------------------------------------------------------
-- Server version	5.1.55-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `js_auth_dict`
--

DROP TABLE IF EXISTS `js_auth_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `js_auth_dict` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DICT_NAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DICT_CODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DICT_STATUS` tinyint(11) DEFAULT NULL COMMENT '0:启用\r\n            1:禁用',
  `DICT_INFO` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CAN_MODIFIED` int(11) NOT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `IS_LEAF` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DICT_SELF` (`PARENT_ID`),
  CONSTRAINT `FK_DICT_SELF` FOREIGN KEY (`PARENT_ID`) REFERENCES `js_auth_dict` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `js_auth_dict`
--

LOCK TABLES `js_auth_dict` WRITE;
/*!40000 ALTER TABLE `js_auth_dict` DISABLE KEYS */;
INSERT INTO `js_auth_dict` VALUES (1,'性别','JS010',1,'性别',1,NULL,1),(2,'机构类型','JS020',1,'机构类型',1,NULL,1),(3,'资源类型','JS030',1,'资源类型',1,NULL,1),(4,'状态','JS040',1,'状态',1,NULL,1),(5,'是否有效','JS050',1,'是否有效',1,NULL,1),(6,'审批决定','JS060',1,'审批决定',1,NULL,1),(7,'请假事由','JS070',1,'请假事由',1,NULL,1),(9,'废止原因','JS1009',1,'废止原因',1,NULL,1),(10,'注销类别','JS1010',1,'注销类别',1,NULL,1),(11,'再生育申请类型','JS1011',1,'再生育申请类型',1,NULL,1),(12,'取环类型','JS1012',1,'取环类型',1,NULL,1),(13,'查环对象类型','JS1013',1,'查环对象类型',1,NULL,1),(14,'户口性质','JS1014',1,'户口性质',1,NULL,1),(15,'婚姻状况','JS1015',1,'婚姻状况',1,NULL,1),(16,'查环查孕类型','JS1016',1,'查环查孕类型',1,NULL,1),(17,'职业类型','JS1017',1,'职业类型',1,NULL,1),(18,'避孕节育措施','JS1018',1,'避孕节育措施',1,NULL,1),(19,'保险类型','JS1019',1,'保险类型',1,NULL,1),(20,'换证原因','JS1020',1,'换证原因',1,NULL,1),(21,'废止原因','JS1021',1,'废止原因',1,NULL,1),(22,'五期教育','JS1022',1,'五期教育',1,NULL,1),(23,'变更类型','JS1023',1,'变更类型',1,NULL,1),(24,'安排生育类型','JS1024',1,'安排生育类型',1,NULL,1),(25,'安排生育未生类型','JS1025',1,'安排生育未生类型',1,NULL,1),(26,'已婚无孩情况','JS1026',1,'已婚无孩情况',1,NULL,1),(27,'安排生育类型','JS1027',1,'安排生育类型',1,NULL,1),(28,'安排生育情况','JS1028',1,'安排生育情况',1,NULL,1),(29,'孕产情况','JS1029',1,'孕产情况',1,NULL,1),(30,'现孕状态','JS1030',1,'现孕状态',1,NULL,1),(31,'补救措施类型','JS1031',1,'补救措施类型',1,NULL,1),(32,'妇女孕产结果','JS1032',1,'妇女孕产结果',1,NULL,1),(33,'避孕节育未落实措施类型','JS1033',1,'避孕节育未落实措施类型',1,NULL,1),(34,'补救措施未落实措施类型','JS1034',1,'补救措施未落实措施类型',1,NULL,1),(35,'疾病类型','JS1035',1,'疾病类型',1,NULL,1),(36,'避孕失败类型','JS1036',1,'避孕失败类型',1,NULL,1),(37,'政策内外','JS1037',1,'政策内外',1,NULL,1),(38,'房屋类型','JS1038',1,'房屋类型',1,NULL,1),(39,'房屋属性','JS1039',1,'房屋属性',1,NULL,1),(40,'与户主的关系','JS1040',1,'与户主的关系',1,NULL,1),(41,'学历','JS1041',1,'学历',1,NULL,1),(42,'流动原因','JS1042',1,'流动原因',1,NULL,1),(43,'证件类型','JS1043',1,'证件类型',1,NULL,1),(44,'民族','JS1044',1,'民族',1,NULL,1),(45,'国籍','JS1045',1,'国籍',1,NULL,1),(46,'迁入(流入)类别','JS1046',1,'迁入(流入)类别',1,NULL,1),(47,'迁出(流出)类别','JS1047',1,'迁出(流出)类别',1,NULL,1),(48,'户口类别','JS1048',1,'户口类别',1,NULL,1),(49,'政治面貌','JS1049',1,'政治面貌',1,NULL,1),(50,'人员类别','JS1050',1,'人员类别',1,NULL,1),(51,'持证情况','JS1051',1,'持证情况',1,NULL,1);
/*!40000 ALTER TABLE `js_auth_dict` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-08-07 15:26:19
