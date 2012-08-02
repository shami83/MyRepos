/* U_ADMIN table*/
CREATE TABLE `ukpl`.`U_ADMIN` (
  `ID` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `SEX` INTEGER UNSIGNED NOT NULL,
  `URL` VARCHAR(200),
  PRIMARY KEY (`ID`)
)
ENGINE = InnoDB;

ALTER TABLE `ukpl`.`u_admin` ADD COLUMN `PASSWORD` VARCHAR(100) NOT NULL AFTER `URL`;

/* u_album*/
CREATE TABLE `ukpl`.`u_album` (
  `ID` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(100),
  `date` DATETIME,
  PRIMARY KEY (`ID`)
)
ENGINE = InnoDB;
ALTER TABLE `ukpl`.`u_album` ADD COLUMN `gamemode` VARCHAR(100) NOT NULL AFTER `date`,
 ADD COLUMN `site` VARCHAR(100) NOT NULL AFTER `gamemode`;


/* u_img*/
CREATE TABLE `ukpl`.`u_img` (
  `ID` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `album_id` VARCHAR(45) NOT NULL,
  `displayname` VARCHAR(100) NOT NULL,
  `internalname` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`)
)
ENGINE = InnoDB;

ALTER TABLE `ukpl`.`u_img` ADD COLUMN `gamemode` VARCHAR(100) NOT NULL AFTER `internalname`,
 ADD COLUMN `site` VARCHAR(100) NOT NULL AFTER `gamemode`;


/*
 * u_player*/
CREATE TABLE `ukpl`.`u_player` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(90) NOT NULL,
  `grade` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `team` VARCHAR(45),
  `image` VARCHAR(90),
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

ALTER TABLE `ukpl`.`u_player` MODIFY COLUMN `team` INTEGER UNSIGNED DEFAULT 0;


/*u_team*/
CREATE TABLE `ukpl`.`u_team` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `owner` VARCHAR(100) NOT NULL,
  `adress` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;


/*
 * u_player_football*/
CREATE TABLE `ukpl`.`u_player_football` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(90) NOT NULL,
  `grade` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `team` VARCHAR(45),
  `image` VARCHAR(90),
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

ALTER TABLE `ukpl`.`u_player_football` MODIFY COLUMN `team` INTEGER UNSIGNED DEFAULT 0;


/*u_team_football*/
CREATE TABLE `ukpl`.`u_team_football` (
  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `owner` VARCHAR(100) NOT NULL,
  `adress` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

ALTER TABLE `ukpl`.`u_team_football` ADD COLUMN `phone` VARCHAR(100) AFTER `adress`;




