CREATE DATABASE  IF NOT EXISTS `silang-db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `silang-db`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: silang-db
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(120) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'wlemfmflfa123j.jpg','jpg'),(2,'cc81d5d6f62e4570a622c1c73a4bc405.mp4','mp4'),(3,'39ce03d958d744bc953c0f1cca717126.mp4','mp4'),(4,'d3c45e0ef4d449429fc50f2dea3b494e.mp4','mp4'),(5,'16f29b4a01ec48878661e92579266b41.mp4','mp4'),(6,'f344176a5398492a938f579509a0c77e.mp4','mp4'),(7,'caa6b2d124644068a467960e0b313f66.mp4','mp4'),(8,'540f80fe1c6e478fa560b2624406505d.mp4','mp4'),(9,'fd4c57da83a44ef29a33f5725ab36c92.mp4','mp4'),(10,'3965c2f664f145c991f324175610acdf.mp4','mp4'),(11,'07196a94de204697bf3c73bc24a0040c.mp4','mp4'),(12,'8594c08ca63e4cbfb2bb2897d850adde.mp4','mp4'),(13,'c0b67c116c4d42489367ca72abdefd3b.mp4','mp4'),(14,'be9e89c07068446cb9b439533f912892.mp4','mp4'),(15,'7694004f861a48928a551965abdee21b.mp4','mp4'),(16,'63a9d6e68bf74eb08d41779ed9c71fb1.mp4','mp4'),(17,'d62b7da2e6ef40b28ae314b50199315d.mp4','mp4'),(18,'2e4c375e4468454f92ddabede189c1a1.mp4','mp4'),(19,'f3ad6e16bba745e3a87c646a81f4e6ba.mp4','mp4'),(20,'12acf8585d7c45a2ae62a1e7a199e7ce.mp4','mp4'),(21,'efec56cfb43640eca54527efcff5fa5a.mp4','mp4'),(22,'3e0f3631df5b48e588ee65bd26ec2f81.mp4','mp4'),(23,'dd80a2d317444b719bd04e6812d49e9d.mp4','mp4'),(24,'01ffe6ff2bfc43b8ae857c821b2d5fe4.mp4','mp4'),(25,'b0b66769e20f4246998544986531a216.mp4','mp4'),(26,'20037010ca5f4549af92242409c6b9dd.mp4','mp4'),(27,'432d59552fee4423aecf340e6d5aa5e4.mp4','mp4'),(28,'9b0edd1242b44032a18558918ca8b456.mp4','mp4'),(29,'61b3454462bd4e91826e104afa833a2f.mp4','mp4'),(30,'46c8b4b0b28f46e0b1ef70215f97db8f.mp4','mp4'),(31,'d79ea10d29874399a0d35ce381fd9a36.mp4','mp4'),(32,'93ce7f7953cf4c529785cf9f5118ad1e.mp4','mp4'),(33,'97156edf802341f8be76fbd109c2034f.mp4','mp4'),(34,'113799f50de748b59db498da5b3ef2d7.mp4','mp4'),(35,'fcc59f3e0eb34a3590f773c135923ef5.mp4','mp4'),(36,'0e8ee8e8d9c74a01979688c5aad95ef6.mp4','mp4'),(37,'7c8dabc866bb413391f79db86ea43cb4.mp4','mp4'),(38,'9841f241254045e388181854469f8ddf.mp4','mp4'),(39,'9b84909198ee4c60b6edac18cd06484c.mp4','mp4'),(40,'6146a1922a404d88b23a005babc6dad9.mp4','mp4'),(41,'be00fed4a10140408adcdb5dc1128d15.mp4','mp4'),(42,'bfbfb5723bf8420985b4fe238a9006c2.mp4','mp4'),(43,'5d4bfa8baba54be08223390590ff9df0.mp4','mp4'),(44,'87ffadc1b0324e1d9eeff9f2fa3289f9.mp4','mp4'),(45,'0bf493b52b8547d5a0d54f53b81481e3.mp4','mp4'),(46,'a1b5d26caaee4ce494d0b71820989014.mp4','mp4'),(47,'3d87f5e35fef4875bc4e3a0a30c188a7.mp4','mp4'),(48,'a5b9f8a7a3fa40398ff67c0d5cc9877b.mp4','mp4'),(49,'3898971b4c0d4b34aed068b6935008bf.mp4','mp4'),(50,'02eb0a15a8174b9fad2ef26659187cd9.mp4','mp4'),(51,'6796081043344de4abed81cd7dc594be.mp4','mp4'),(52,'93f688f619404dde8d8a22c1d0984b15.mp4','mp4');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` text NOT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_post_user1_idx` (`user_id`),
  CONSTRAINT `fk_post_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` text,
  `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`post_id`),
  KEY `fk_reply_user1_idx` (`user_id`),
  KEY `fk_reply_post1_idx` (`post_id`),
  CONSTRAINT `fk_reply_post1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `fk_reply_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `displayname` varchar(45) NOT NULL,
  `role` tinyint(4) NOT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `file_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_file1_idx` (`file_id`),
  CONSTRAINT `fk_user_file1` FOREIGN KEY (`file_id`) REFERENCES `file` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'1','1','1',2,'2019-04-07 06:20:26','2019-04-07 16:10:03',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(45) NOT NULL,
  `content` text NOT NULL,
  `title` varchar(45) NOT NULL,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `file_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`file_id`),
  KEY `fk_video_user_idx` (`user_id`),
  KEY `fk_video_file1_idx` (`file_id`),
  CONSTRAINT `fk_video_file1` FOREIGN KEY (`file_id`) REFERENCES `file` (`id`),
  CONSTRAINT `fk_video_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (11,'','','test','2019-04-07 16:10:37','2019-04-07 16:10:37',1,52);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-08  0:11:58
