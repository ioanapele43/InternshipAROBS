CREATE TABLE `user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `address` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(15) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `idUser_UNIQUE` (`idUser`)
) ;
CREATE TABLE `place` (
  `idplace` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `venue` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idplace`),
  UNIQUE KEY `idplace_UNIQUE` (`idplace`)
) ;
CREATE TABLE `shows` (
  `idshow` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  `ReleaseDate` datetime NOT NULL,
  `lastModification` datetime DEFAULT NULL,
  PRIMARY KEY (`idshow`),
  UNIQUE KEY `idshow_UNIQUE` (`idshow`)
) ;
CREATE TABLE `ticket` (
  `idticket` int NOT NULL AUTO_INCREMENT,
  `idshow` int NOT NULL,
  `row` int NOT NULL,
  `seat` int NOT NULL,
  `value` int NOT NULL,
  PRIMARY KEY (`idticket`),
  UNIQUE KEY `idticket_UNIQUE` (`idticket`),
  KEY `idShow_idx` (`idshow`),
  CONSTRAINT `idShow` FOREIGN KEY (`idshow`) REFERENCES `shows` (`idshow`)
);
CREATE TABLE `showlocation` (
  `idshowlocation` int NOT NULL,
  `idshow` int NOT NULL,
  `idlocation` int NOT NULL,
  PRIMARY KEY (`idshowlocation`),
  KEY `idshow_idx` (`idshow`),
  KEY `place_idx` (`idlocation`),
  CONSTRAINT `place` FOREIGN KEY (`idlocation`) REFERENCES `place` (`idplace`),
  CONSTRAINT `show` FOREIGN KEY (`idshow`) REFERENCES `shows` (`idshow`)
);

CREATE TABLE `soldtickets` (
  `id` int NOT NULL,
  `iduser` int NOT NULL,
  `idbilet` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `iduser_idx` (`iduser`),
  KEY `bilet_idx` (`idbilet`),
  CONSTRAINT `ticket` FOREIGN KEY (`idbilet`) REFERENCES `ticket` (`idticket`),
  CONSTRAINT `user` FOREIGN KEY (`iduser`) REFERENCES `user` (`idUser`)
);

 insert into user(name, address, username, password, role) values
 ('Tudor Mihai', 'Cluj,Marasti','tudormihai','1234','client'),
 ('Pele Ioana','Cluj, Gheorgheni', 'ioanap','1234','administrator'),
  ('Moldovan Ana', 'Dej','anam','1234','operator');
  
INSERT INTO `arobs-internship`.`shows` (`idshow`, `title`, `director`, `ReleaseDate`) VALUES ('1', 'batman', 'Matt Reeves', '2022-3-23 14:44:00');
INSERT INTO `arobs-internship`.`shows` (`idshow`, `title`, `director`, `ReleaseDate`) VALUES ('2', 'ORASUL PIERDUT', 'Aaron Nee, Adam Nee', '2022-3-24 10:00:00');

INSERT INTO `arobs-internship`.`place` (`idplace`, `name`, `address`, `venue`) VALUES ('1', 'cinema city', 'cluj', 'iulius mall');
INSERT INTO `arobs-internship`.`place` (`idplace`, `name`, `address`, `venue`) VALUES ('2', 'cinema city', 'cluj', 'vivo');
INSERT INTO `arobs-internship`.`place` (`idplace`, `name`, `address`, `venue`) VALUES ('3', 'happy cinema', 'bistrita', 'mall');

INSERT INTO `arobs-internship`.`showlocation` (`idshowlocation`, `idshow`, `idlocation`) VALUES ('1', '1', '1');
INSERT INTO `arobs-internship`.`showlocation` (`idshowlocation`, `idshow`, `idlocation`) VALUES ('2', '2', '3');

INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('1', '1', '1', '1', '10');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('2', '1', '1', '2', '10');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('3', '1', '1', '3', '10');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('4', '1', '1', '4', '10');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('5', '1', '1', '5', '10');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('6', '2', '1', '1', '20');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('7', '2', '1', '2', '20');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('8', '2', '1', '3', '20');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('9', '2', '1', '4', '20');
INSERT INTO `arobs-internship`.`ticket` (`idticket`, `idshow`, `row`, `seat`, `value`) VALUES ('10', '2', '1', '5', '20');

INSERT INTO `arobs-internship`.`soldtickets` (`id`, `iduser`, `idbilet`) VALUES ('1', '1', '1');
INSERT INTO `arobs-internship`.`soldtickets` (`id`, `iduser`, `idbilet`) VALUES ('2', '3', '2');
INSERT INTO `arobs-internship`.`soldtickets` (`id`, `iduser`, `idbilet`) VALUES ('3', '2', '10');
INSERT INTO `arobs-internship`.`soldtickets` (`id`, `iduser`, `idbilet`) VALUES ('4', '1', '5');
