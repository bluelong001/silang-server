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
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (143,'2765a1aaa0fd4d158b66ca06af16b6be.jpg','jpg'),(144,'df100e2d5cc841c28c74b0f5e7c94c23.mp4','mp4'),(145,'79f21c74510c47ab9996c8d9ad097d73.mp4','mp4'),(146,'ff81418812134daa990d2d7fcb9de20f.jpg','jpg'),(147,'0e9eb44a88f249299eba27e9437d33dd.jpg','jpg'),(148,'69c641f087224369b22ca4e14a236490.jpg','jpg'),(149,'47558408cf2545dcbaad5809db873a0e.jpg','jpg'),(150,'22a69415e9cd4aebbe75e4729174df38.jpg','jpg'),(151,'8a692859d09e4fc6bf42e30dcae4d448.mp4','mp4'),(152,'8fd383edd4f44e5fa5e821959475b172.jpg','jpg'),(153,'18fbb656b80e4ff6b0f059007c515709.jpg','jpg'),(154,'3c1eb709d58f486593d3a618d376fe79.jpg','jpg'),(155,'4a18c8ce60c54eb8b84f785d6911d9ca.jpg','jpg'),(156,'0749cab9e0704393bbe98f89148827fe.jpg','jpg'),(157,'c66494e8633f4db0b66acd557d16b190.jpg','jpg'),(158,'1476db07c7f24fd1bd5a5c7af1fa6bc9.jpg','jpg'),(159,'4d114dd31272451381be95be8a4daadd.jpg','jpg'),(160,'8997710f51c049be9cd180ac3d04c2ce.jpg','jpg'),(161,'6c1ae544a4fa4c71b9db3a43ddaa31e6.jpg','jpg'),(162,'b25263c1aafa41fc814e31ce8ca20125.jpg','jpg'),(163,'4b435157e8ea42919241df44eb30b8f3.jpg','jpg'),(164,'b630227f5f2b4ea6a05ff81e15bc7396.jpg','jpg'),(165,'14ffc9c25d4b4333a4327694028f416d.jpg','jpg'),(166,'8ff0a539b20e42718faf9066d27fea1a.jpg','jpg'),(167,'66ba3104903b45169e5566777be80fde.jpg','jpg'),(168,'1745e62185754f6db4297d76784a5d07.jpg','jpg'),(169,'a53d3b2da1894da6bd4e3672868534e3.jpg','jpg'),(170,'0978fdf5d0c34a5395403a9b80b7a8d2.jpg','jpg'),(171,'a6501ca93fa944b8b91fc8cec22b16ea.jpg','jpg'),(172,'204a1580c0174bbd8aca45d6618f997c.jpg','jpg'),(173,'57b5cc52bff74a6ca827540c46b3dd4d.jpg','jpg'),(174,'8b4eb0cdab4342b0ad7a9a78c04bc233.jpg','jpg'),(175,'e1f8c4d500ae4174846e68f068b3f088.jpg','jpg'),(176,'6f8261651ad749d9ab876fe8ed8fbe1c.jpg','jpg'),(177,'c1483b79a90e4e57906c43cb607c7c9f.jpg','jpg'),(178,'8505e1207bc64070b7572413a966411e.jpg','jpg'),(179,'903bd99b0dc54dbbba3e1a3d60a0a1e2.jpg','jpg'),(180,'db2b7c31381940669e54c83e78860d90.mp4','mp4'),(181,'6bfd8589a67a4c64b31685c4f8292052.mp4','mp4'),(182,'e51fe835b9c2494f963281268a27c0b6.jpg','jpg'),(183,'8bb532e8bced4946adea37a3972289c4.mp4','mp4'),(184,'8366dc8f29324b9d8484cf24932f1bc3.mp4','mp4'),(185,'9a73eb4d41564953b1d656d8c0083e83.mp4','mp4'),(186,'9ee6b33ce8814d3688c4d5bc9d208826.jpg','jpg'),(187,'2dba84609e684591b56c07024804b188.jpg','jpg'),(188,'8219f6a322824920825fb49ffa4ee805.jpg','jpg'),(189,'02b061397d1b433d92f099ec1f6221d6.jpg','jpg');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (7,'admin刚才发表了一个主题：等等'),(8,'admin刚才发表了一个主题：顶顶顶'),(9,'admin刚才发表了一个主题：打'),(10,'admin刚才发表了一个主题：呃呃');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
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
  CONSTRAINT `fk_post_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (48,'我是一个主题','','2019-04-28 11:51:18','2019-04-28 11:51:18',7),(49,'测试哦','<p>真的只是测试</p>','2019-05-01 09:08:09','2019-05-01 09:08:09',7),(50,'测试哦哦哦','<p>测试</p>','2019-05-01 09:11:24','2019-05-01 09:11:24',7),(51,'第二次测试','<p>第二次测试</p>','2019-05-01 09:12:29','2019-05-01 09:12:29',7),(52,'我来告诉你是谁','<p>我来告诉你是谁</p>','2019-05-01 09:24:22','2019-05-01 09:24:22',7),(53,'test','<p>test</p>','2019-05-01 09:36:11','2019-05-01 09:36:11',7),(54,'啊啊啊','<p>啊啊啊</p>','2019-05-01 09:36:28','2019-05-01 09:36:28',7),(55,'呃呃呃','<p>呃呃呃</p>','2019-05-01 09:36:54','2019-05-01 09:36:54',7),(56,'等等','<p>等等</p>','2019-05-01 09:37:01','2019-05-01 09:37:01',7),(58,'打','<p>打</p>','2019-05-01 09:40:06','2019-05-01 09:40:06',7),(59,'呃呃','<p>呃呃呃</p>','2019-05-01 09:41:54','2019-05-01 09:41:54',7);
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
  CONSTRAINT `fk_reply_post1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_reply_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (16,'wohuifuleni','2019-04-28 12:08:07','2019-04-28 12:08:07',7,48),(17,'woyouhuifuleni','2019-04-28 12:09:00','2019-04-28 12:09:00',7,48),(18,'test','2019-04-28 12:18:57','2019-04-28 12:18:57',7,48),(19,'aa','2019-04-28 12:19:01','2019-04-28 12:19:01',7,48);
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
  `signature` varchar(100) DEFAULT '这个人很懒，什么都没留下来',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_file1_idx` (`file_id`),
  CONSTRAINT `fk_user_file1` FOREIGN KEY (`file_id`) REFERENCES `file` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (7,'admin','123456','admin',2,'2019-04-28 11:33:28','2019-04-28 11:34:13',143,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_message`
--

DROP TABLE IF EXISTS `user_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`message_id`),
  KEY `fk_message_id_idx` (`message_id`),
  KEY `fk_user_id_idx` (`user_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_message_id` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_message`
--

LOCK TABLES `user_message` WRITE;
/*!40000 ALTER TABLE `user_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_message` ENABLE KEYS */;
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
  `img_list` longtext,
  PRIMARY KEY (`id`,`user_id`,`file_id`),
  KEY `fk_video_user_idx` (`user_id`),
  KEY `fk_video_file1_idx` (`file_id`),
  CONSTRAINT `fk_video_file1` FOREIGN KEY (`file_id`) REFERENCES `file` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_video_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (24,'我迟到了','为啥要迟到，请看我们的手语','我迟到了','2019-04-28 11:48:25','2019-04-28 11:48:25',7,144,NULL),(25,'我才没迟到','请看我们的展示','我才没迟到','2019-04-28 11:49:03','2019-04-28 11:49:03',7,145,NULL),(26,'摸鱼','摸鱼','摸鱼','2019-04-28 12:38:18','2019-04-28 12:38:18',7,151,NULL),(27,'啊啊','啊','啊啊','2019-04-28 14:07:20','2019-04-28 14:07:20',7,181,NULL),(28,'te','','te','2019-04-28 14:07:41','2019-04-28 14:07:41',7,183,NULL),(29,'123','123','123','2019-04-28 14:10:29','2019-04-28 14:10:29',7,187,'[\"http://192.168.199.225:8080/9ee6b33ce8814d3688c4d5bc9d208826.jpg\",\"http://192.168.199.225:8080/2dba84609e684591b56c07024804b188.jpg\"]');
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

-- Dump completed on 2019-05-01 18:01:39
