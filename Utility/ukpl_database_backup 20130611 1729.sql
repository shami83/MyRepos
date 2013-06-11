-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ukpl
--

CREATE DATABASE IF NOT EXISTS ukpl;
USE ukpl;

--
-- Definition of table `u_admin`
--

DROP TABLE IF EXISTS `u_admin`;
CREATE TABLE `u_admin` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `SEX` int(10) unsigned NOT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_admin`
--

/*!40000 ALTER TABLE `u_admin` DISABLE KEYS */;
INSERT INTO `u_admin` (`ID`,`Name`,`SEX`,`URL`,`PASSWORD`) VALUES 
 (1,'shamik',1,'acsd','password');
/*!40000 ALTER TABLE `u_admin` ENABLE KEYS */;


--
-- Definition of table `u_album`
--

DROP TABLE IF EXISTS `u_album`;
CREATE TABLE `u_album` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `gamemode` varchar(100) NOT NULL,
  `site` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_album`
--

/*!40000 ALTER TABLE `u_album` DISABLE KEYS */;
INSERT INTO `u_album` (`ID`,`name`,`description`,`date`,`gamemode`,`site`) VALUES 
 (1,'TestAlbum','test',NULL,'cricket','UKPL'),
 (2,'ABC','abc',NULL,'cricket','UKPL'),
 (3,'album2','album2',NULL,'cricket','UKPL');
/*!40000 ALTER TABLE `u_album` ENABLE KEYS */;


--
-- Definition of table `u_img`
--

DROP TABLE IF EXISTS `u_img`;
CREATE TABLE `u_img` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `album_id` varchar(45) NOT NULL,
  `displayname` varchar(100) NOT NULL,
  `internalname` varchar(100) NOT NULL,
  `gamemode` varchar(100) NOT NULL,
  `site` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_img`
--

/*!40000 ALTER TABLE `u_img` DISABLE KEYS */;
INSERT INTO `u_img` (`ID`,`album_id`,`displayname`,`internalname`,`gamemode`,`site`) VALUES 
 (3,'1','Winter.jpg','1339413023156.jpg','cricket','UKPL');
/*!40000 ALTER TABLE `u_img` ENABLE KEYS */;


--
-- Definition of table `u_player`
--

DROP TABLE IF EXISTS `u_player`;
CREATE TABLE `u_player` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(90) NOT NULL,
  `grade` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `team` int(10) unsigned DEFAULT '0',
  `image` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=427 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_player`
--

/*!40000 ALTER TABLE `u_player` DISABLE KEYS */;
INSERT INTO `u_player` (`id`,`name`,`grade`,`category`,`team`,`image`) VALUES 
 (34,'Nepal Ghosh','a','allrounder',14,'nepalara.jpg'),
 (35,'Sandip Prasad Hela','a','allrounder',17,'sandipara.jpg'),
 (36,'Krishnendu Manna','a','allrounder',9,'krishnenduara.jpg'),
 (37,'Prosenjit Bhattacharya','a','allrounder',15,'prosenjitara.jpg'),
 (38,'Lalit Shaw','a','allrounder',7,'lalitara.jpg'),
 (39,'Sajal Paul','a','allrounder',11,'sajalara.jpg'),
 (40,'Ajit singh','a','allrounder',8,'ajitara.jpg'),
 (41,'Debashis Kundu','a','allrounder',16,'debashisara.jpg'),
 (42,'Arani Mukherjee','a','allrounder',6,'araniara.jpg'),
 (43,'Bhola Das','a','allrounder',13,'bholaara.jpg'),
 (44,'Kishnendu Mondal','a','allrounder',10,'krishnendu1ara.jpg'),
 (45,'Arka Chal','a','allrounder',12,'arkaara.jpg'),
 (64,'Rana Das','cb','batsman',12,'ranacb.jpg'),
 (65,'Subir Ghosh','cb','batsman',9,'subircb.jpg'),
 (66,'Sandip Das','cb','batsman',13,'sandipcb.jpg'),
 (67,'Sanat Adhikary','cb','batsman',14,'sanatcb.jpg'),
 (68,'Prabir Shaw','cb','batsman',15,'prabircb.jpg'),
 (69,'Subhash Biswas','cb','batsman',11,'subhashcb.jpg'),
 (70,'Sandip Kesh','cb','batsman',10,'sandip1cb.jpg'),
 (71,'Gopeswar RoyChowdhuri','cb','batsman',17,'gopeswarcb.jpg'),
 (72,'Sumit Chakrabarty','cb','batsman',7,'sumitcb.jpg'),
 (73,'Arup Kr Acharya','cb','batsman',16,'arupcb.jpg'),
 (74,'Goutam Mitra','cb','batsman',6,'goutamcb.jpg'),
 (75,'Koushik Biswas','cb','batsman',8,'koushikcb.jpg'),
 (124,'Rajib Ghosh','ca','batsman',11,'rajibca.jpg'),
 (125,'Mukesh Sing','ca','batsman',16,'mukeshca.jpg'),
 (126,'Pintu Sarnokar','ca','batsman',14,'pintuca.jpg'),
 (127,'Anirban Palchowdhury','ca','batsman',7,'anirbanca.jpg'),
 (128,'Sandip Mondal','ca','batsman',15,'chiranjitca.jpg'),
 (129,'Binod Shaw','ca','batsman',9,'binodca.jpg'),
 (130,'Sudip Ganguly','ca','batsman',12,'sudipca.jpg'),
 (131,'Prosenjit Das','ca','batsman',8,'prosenjitca.jpg'),
 (132,'Prabir Sengupta','ca','batsman',17,'prabirca.jpg'),
 (133,'Achintya Chakroborty','ca','batsman',10,'achintyaca.jpg'),
 (134,'Subrata Saha','ca','batsman',6,'subrataca.jpg'),
 (135,'Sulipto Mukherjee','ca','batsman',13,'sudiptoca.jpg'),
 (154,'Akashdeep Mitra','ja','allrounder',14,'akashdeepja.jpg'),
 (155,'Abhijit Chowdhuri','ja','allrounder',10,'abhijitja.jpg'),
 (156,'Bijay yadav','ja','allrounder',17,'bijayja.jpg'),
 (157,'Ankur Dasgupta','ja','allrounder',8,'ankurja.jpg'),
 (158,'Anish Maity','ja','allrounder',9,'anishja.jpg'),
 (159,'Rahul Shaw','ja','allrounder',13,'rahulja.jpg'),
 (160,'Amit Yadav','ja','allrounder',16,'amitja.jpg'),
 (161,'Monoj Mahato','ja','allrounder',6,'manojja.jpg'),
 (162,'Pintu jana','ja','allrounder',11,'pintuja.jpg'),
 (163,'Santosh Kumar Singh','ja','allrounder',7,'santoshja.jpg'),
 (164,'Sanju Saha','ja','allrounder',12,'sanjuja.jpg'),
 (169,'Rohit Kumar Shaw','ja','allrounder',15,'rohitja.jpg'),
 (200,'Upendra Sharma','b','allrounder',15,'upendraarb.jpg'),
 (201,'Sayantan Das','b','allrounder',13,'sayantanarb.jpg'),
 (202,'Hrishikesh Ghosh','b','allrounder',10,'hrishikesharb.jpg'),
 (203,'Debraj Nandy','b','allrounder',7,'debrajarb.jpg'),
 (204,'Shamik Mitra','b','allrounder',14,'shamikarb.jpg'),
 (205,'Abhishek Ghosal','b','allrounder',9,'abhishekarb.jpg'),
 (206,'Satyendra Jha','b','allrounder',16,'satyendraarb.jpg'),
 (207,'Anil Kumar Yadav','b','allrounder',8,'anilarb.jpg'),
 (208,'Anurag Vyas','b','allrounder',12,'anuragarb.jpg'),
 (209,'Rahul Jain','b','allrounder',11,'rahularb.jpg'),
 (210,'Rohit Jain','b','allrounder',6,'rohitarb.jpg'),
 (211,'Bablu Basak','b','allrounder',17,'babluarb.jpg'),
 (215,'Goutam Kundu','c','allrounder',16,'goutamarc.jpg'),
 (216,'Binod Mahato','c','allrounder',12,'binodarc.jpg'),
 (217,'Aditya Upadhyay','c','allrounder',9,'adityaarc.jpg'),
 (218,'Gourav Ghosh','c','allrounder',11,'gourabarc.jpg'),
 (219,'Pramod Mahato','c','allrounder',7,'pramodarc.jpg'),
 (220,'Rajesh Ghosh','c','allrounder',10,'rajesharc.jpg'),
 (221,'Shankar Singh','c','allrounder',8,'shankararc.jpg'),
 (222,'Dharmendra Kumar Rai','c','allrounder',14,'dharmendraarc.jpg'),
 (223,'Arpan Banarjee','c','allrounder',17,'arpanarc.jpg'),
 (224,'Siddhartha Goutam','c','allrounder',13,'siddharthaarc.jpg'),
 (225,'Indar Shaw','c','allrounder',15,'indararc.jpg'),
 (226,'Anurag Sharma','c','allrounder',6,'anuragarc.jpg'),
 (230,'Prosenjit Bhattacharya','a','batsman',9,'prosenjitba.jpg'),
 (231,'Rahul Singh','a','batsman',11,'rahulba.jpg'),
 (232,'Chotu Shaw','a','batsman',6,'chotuba.jpg'),
 (233,'Samir Dey','a','batsman',17,'samirba.jpg'),
 (234,'Aniruddha Dhara','a','batsman',13,'aniruddhaba.jpg'),
 (235,'Jayanta Maity','a','batsman',16,'jayantaba.jpg'),
 (236,'Partha Maity','a','batsman',10,'parthaba.jpg'),
 (237,'Tuhin Mukhejee','a','batsman',7,'tuhinba.jpg'),
 (238,'Prosenjit pal','a','batsman',8,'prosenjit1ba.jpg'),
 (239,'Sanjay Shaw','a','batsman',12,'sanjayba.jpg'),
 (240,'Sunny Hela','a','batsman',14,'sunnyba.jpg'),
 (241,'Jeet Bhakta','a','batsman',15,'jeetba.jpg'),
 (245,'Manoj Sharma','a','bowler',11,'manojbwa.jpg'),
 (246,'Sanjoy Shaw','a','bowler',14,'sanjaybwa.jpg'),
 (247,'Surojit Mitra','a','bowler',6,'surojitbwa.jpg'),
 (248,'Anikit Singh','a','bowler',7,'ankitbwa.jpg'),
 (249,'Amirchand Sharma','a','bowler',9,'amirchandbwa.jpg'),
 (250,'Subrata Das','a','bowler',15,'subratabwa.jpg'),
 (251,'Praveen Mishra','a','bowler',12,'praveenbwa.jpg'),
 (252,'Haresh Goswami','a','bowler',8,'hareshbwa.jpg'),
 (253,'Bicky Hela','a','bowler',10,'bickybwa.jpg'),
 (254,'Aman Prasad','a','bowler',13,'amanbwa.jpg'),
 (255,'Suman Paul','a','bowler',16,'sumanbwa.jpg'),
 (256,'Subhomoy Chatterjee','a','bowler',17,'subhomoybwa.jpg'),
 (275,'Rahul Tiwary','b','batsman',17,'rahulbb.jpg'),
 (276,'Byomkesh Ghosh','b','batsman',11,'byomkeshbb.jpg'),
 (277,'Rajendra Shaw','b','batsman',10,'rajendrabb.jpg'),
 (278,'Amitabh Seal','b','batsman',13,'amitabhbb.jpg'),
 (280,'Amit Kumar Maitra','b','batsman',12,'amitbb.jpg'),
 (281,'Snjay Yadav','b','batsman',9,'sanjaybb.jpg'),
 (282,'Rahul Mazumdar','b','batsman',6,'rahul1bb.jpg'),
 (283,'Subha Brata Roy','b','batsman',16,'subhabb.jpg'),
 (284,'Ashok Sing','b','batsman',7,'ashokbb.jpg'),
 (285,'Ankaj Singh','b','batsman',14,'ankajbb.jpg'),
 (286,'Amitava Saha','b','batsman',15,'amitavabb.jpg'),
 (290,'Kinkar Chandra Dey','zc','batsman',6,'kinkarbc.jpg'),
 (291,'Manick Shaw','zc','batsman',16,'manickbc.jpg'),
 (292,'Anand Shaw','zc','batsman',7,'anandbc.jpg'),
 (293,'Subhrojit Ghosh','zc','batsman',10,'subhrojitbc.jpg'),
 (294,'Bijoy Singh','zc','batsman',14,'bijoybc.jpg'),
 (295,'Gourav Chowdhury','zc','batsman',8,'gouravbc.jpg'),
 (296,'sovick Podder','zc','batsman',11,'sovikbc.jpg'),
 (297,'Amitava Chakraborty','zc','batsman',9,'amitavabc.jpg'),
 (298,'Biswajit Bairagi','zc','batsman',12,'biswajitbc.jpg'),
 (299,'Prasanta Banerjee','zc','batsman',15,'prasantabc.jpg'),
 (300,'Raju Das','zc','batsman',13,'rajubc.jpg'),
 (301,'Koushik Ghosh','zc','batsman',17,'koushikbc.jpg'),
 (305,'Ashok Mitra','b','bowler',16,'ashokbwb.jpg'),
 (306,'Sourav Ghosh','b','bowler',12,'souravbwb.jpg'),
 (307,'Manab Polley','b','bowler',11,'manabbwb.jpg'),
 (308,'Somnath Paul','b','bowler',10,'somnathbwb.jpg'),
 (309,'Sanjay Yadav','b','bowler',14,'sanjaybwb.jpg'),
 (310,'Ajoy Singh','b','bowler',13,'ajoybwb.jpg'),
 (311,'Romeo Hore','b','bowler',17,'romeobwb.jpg'),
 (312,'Amit Dubey','b','bowler',7,'amit1bwb.jpg'),
 (313,'Amit Mondal','b','bowler',8,'amit2bwb.jpg'),
 (314,'Nilasish Mukherjee','b','bowler',6,'nilashishbwb.jpg'),
 (315,'Toton Paul','b','bowler',9,'totonbwb.jpg'),
 (316,'Shibaji Senupta','b','bowler',15,'shibajibwb.jpg'),
 (317,'Shamik Mitra','systemadmin','System Adminitrator',0,'shamikarb.jpg'),
 (318,'Kinkar Ch Dey','systemadmin','System Adminitrator',0,'kinkarbc.jpg'),
 (320,'Joynarayan  Das','b','batsman',8,'janardanbb.jpg'),
 (321,'Dr. Amit Chowdhuri','owner','owner',6,'amitow.jpg'),
 (322,'Sanjay das','owner','owner',7,'dow.jpg'),
 (323,'Goutam Saha','owner','owner',8,'goutamow.jpg'),
 (324,'Amar Maity','owner','owner',10,'amarow.jpg'),
 (325,'Srabani Das','owner','owner',11,'srabaniow.jpg'),
 (326,'Manoj Vyas','owner','owner',12,'manojow.jpg'),
 (327,'Bimal Pal','owner','owner',13,'bimalow.jpg'),
 (328,'Angel Sengupta','owner','owner',9,'angelow.jpg'),
 (329,'Abhijit Sarkar','owner','owner',14,'abhijitow.jpg'),
 (330,'Dibendu Saha','owner','owner',15,'dibenduow.jpg'),
 (331,'Bhim Chowdhury','owner','owner',16,'bhimow.jpg'),
 (332,'Yadav Bose','owner','owner',17,'yadavow.jpg'),
 (395,'Nemai Chandra Das','commitee','commitee',0,'nemaicom.jpg'),
 (396,'Rabin Chatterjee','commitee','commitee',0,'rabincom.jpg'),
 (397,'Tapan Bhattacharjee','commitee','commitee',0,'tapancom.jpg'),
 (398,'Sukumar Saha','commitee','commitee',0,'sukumarcom.jpg'),
 (399,'Buddhadeb Bakshi','commitee','commitee',0,'buddhacom.jpg'),
 (400,'Asit Ghosh','commitee','commitee',0,'asitcom.jpg'),
 (401,'Swapan Dutta','commitee','commitee',0,'swapancom.jpg'),
 (402,'Sasanka Saha','commitee','commitee',0,'sasankacom.jpg'),
 (403,'Netai Chandra Das','commitee','commitee',0,'netaicom.jpg'),
 (404,'Niladri Ghosh','commitee','commitee',0,'niladricom.jpg'),
 (405,'Mahendra Shaw','commitee','commitee',0,'mahendracom.jpg'),
 (406,'Rupa Chowdhury','commitee','commitee',0,'rupacom.jpg'),
 (407,'Madhab Bose','commitee','commitee',0,'madhabcom.jpg'),
 (408,'Subodh Saha','commitee','commitee',0,'subodhcom.jpg'),
 (409,'Rajkumar Rai','commitee','commitee',0,'rajkumarcom.jpg'),
 (410,'Aniruddha Ghosh','commitee','commitee',0,'anicom.jpg'),
 (411,'Swapan Chakraborty','commitee','commitee',0,'swapan1com.jpg'),
 (412,'Rakesh Mondal','commitee','commitee',0,'rakeshcom.jpg'),
 (413,'Sujit Singh','commitee','commitee',0,'sujitcom.jpg'),
 (426,'Soumen Bose','commitee','commitee',0,'soumencom.jpg');
/*!40000 ALTER TABLE `u_player` ENABLE KEYS */;


--
-- Definition of table `u_player_football`
--

DROP TABLE IF EXISTS `u_player_football`;
CREATE TABLE `u_player_football` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(90) NOT NULL,
  `grade` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `team` int(10) unsigned DEFAULT '0',
  `image` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_player_football`
--

/*!40000 ALTER TABLE `u_player_football` DISABLE KEYS */;
INSERT INTO `u_player_football` (`id`,`name`,`grade`,`category`,`team`,`image`) VALUES 
 (1,'Shamik Mitra','a','midfielder',1,'shamikarb.jpg'),
 (2,'Ani Dhara','a','striker',0,'soumencom.jpg'),
 (3,'Kinkar','b','defender',0,'kinkarbc.jpg'),
 (4,'Tuhin','a','goalkeeper',0,'tuhinba.jpg');
/*!40000 ALTER TABLE `u_player_football` ENABLE KEYS */;


--
-- Definition of table `u_team`
--

DROP TABLE IF EXISTS `u_team`;
CREATE TABLE `u_team` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `owner` varchar(100) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_team`
--

/*!40000 ALTER TABLE `u_team` DISABLE KEYS */;
INSERT INTO `u_team` (`id`,`name`,`owner`,`adress`,`phone`) VALUES 
 (6,'MOVEMENT','Dr. Amit Chowdhury','mm tola','9830471739'),
 (7,'SHAW DIAGNOSTICS','Dr. Chatterjee','--','null'),
 (8,'AT CATERER','Goutam Saha',';;',NULL),
 (9,'AIKYA','Angel Sengupta','9 a,skb lane',NULL),
 (10,'AMAR XI STAR','Amar Maity','--',NULL),
 (11,'GURANTEED PROFIT.IN','Sourav Saha','--',NULL),
 (12,'NAMRATA UNITED','Monoj Vyas','--',NULL),
 (13,'N.C.U CLUB JAGATDHATTRI PUJA COMMITEE','Vimal Paul','--',NULL),
 (14,'NAYAGRA RED BULLS','Abhijeet Sarkar','--',NULL),
 (15,'M.K.DECORATERS','Dibendu Saha','--',NULL),
 (16,'1/X1 SPORTING CLUB','Bhim Chowdhury','--',NULL),
 (17,'J.P.IMPEX','Madhab Bose','--',NULL);
/*!40000 ALTER TABLE `u_team` ENABLE KEYS */;


--
-- Definition of table `u_team_football`
--

DROP TABLE IF EXISTS `u_team_football`;
CREATE TABLE `u_team_football` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `owner` varchar(100) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u_team_football`
--

/*!40000 ALTER TABLE `u_team_football` DISABLE KEYS */;
INSERT INTO `u_team_football` (`id`,`name`,`owner`,`adress`,`phone`) VALUES 
 (1,'Arsenal','Arsenal','England','1234');
/*!40000 ALTER TABLE `u_team_football` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
