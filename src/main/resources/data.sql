
--
-- Table structure for table `alias`
--

DROP TABLE IF EXISTS `alias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `artist_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alias`
--

LOCK TABLES `alias` WRITE;
/*!40000 ALTER TABLE `alias` DISABLE KEYS */;
INSERT INTO `alias` VALUES (1,'Metalica',1),(2,'메탈리카',1),(3,'Lady Ga Ga',2),(4,'Stefani Joanne Angelina Germanotta',2),(5,'Mott The Hoppie',4),(6,'Mott The Hopple',4),(7,'Megadeath',5),(8,'John Coltraine',6),(9,'John William Coltrane',6),(10,'Mogwa',7),(11,'Johhny Cash',9),(12,'Jonny Cash',9),(13,'Jack Hody Johnson',10),(14,'John Anthony Frusciante',11),(15,'E. John',12),(16,'Elthon John',12),(17,'Elton Jphn',12),(18,'John Elton',12),(19,'Reginald Kenneth Dwight',12),(20,'ランシド',13),(21,'The Transplants',14),(22,'Op Ivy',15);
/*!40000 ALTER TABLE `alias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `unique_identifier` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'Metallica','US','65f4f0c5-ef9e-490c-aee3-909e7ae6b2ab '),(2,'Lady Gaga','US','650e7db6-b795-4eb5-a702-5ea2fc46c848'),(3,'Mumford & Sons','US','c44e9c22-ef82-4a77-9bcd-af6c958446d6'),(4,'Mott the Hoople','US','435f1441-0f43-479d-92db-a506449a686b'),(5,'Megadeth','US','a9044915-8be3-4c7e-b11f-9e2d2ea0a91e'),(6,'John Coltrane','US','b625448e-bf4a-41c3-a421-72ad46cdb831'),(7,'Mogwai','US','d700b3f5-45af-4d02-95ed-57d301bda93e'),(8,'John Mayer','US','144ef525-85e9-40c3-8335-02c32d0861f3'),(9,'Johnny Cash','US','18fa2fd5-3ef2-4496-ba9f-6dae655b2a4f'),(10,'Jack Johnson','US','6456a893-c1e9-4e3d-86f7-0008b0a3ac8a'),(11,'John Frusciante','US','f1571db1-c672-4a54-a2cf-aaa329f26f0b'),(12,'Elton John','US','b83bc61f-8451-4a5d-8b8e-7e9ed295e822'),(13,'Rancid','US','24f8d8a5-269b-475c-a1cb-792990b0b2ee'),(14,'Transplants','US','29f3e1bf-aec1-4d0a-9ef3-0cb95e8a3699'),(15,'Operation Ivy','US','931e1d1f-6b2f-4ff8-9f70-aa537210cd46');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;
