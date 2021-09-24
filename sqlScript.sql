
/*******************************************************************************
   Chinook Database - Version 1.4
   Script: Chinook_MySql_AutoIncrementPKs.sql
   Description: Creates and populates the Chinook database.
   DB Server: MySql
   Author: Luis Rocha
   License: http://www.codeplex.com/ChinookDatabase/license
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP DATABASE IF EXISTS `chinook`;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE DATABASE `chinook`;

USE `chinook`;


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE `album`
(
    `album_id` INT NOT NULL AUTO_INCREMENT,
    `title` NVARCHAR(160) NOT NULL,
    `artist_id` INT NOT NULL,
    CONSTRAINT `pk_album` PRIMARY KEY  (`album_id`)
);

CREATE TABLE `artist`
(
    `artist_id` INT NOT NULL AUTO_INCREMENT,
    `name` NVARCHAR(120),
    CONSTRAINT `pk_artist` PRIMARY KEY  (`artist_id`)
);


/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE `album` ADD CONSTRAINT `fk_album_artist_id`
    FOREIGN KEY (`artist_id`) REFERENCES `artist` (`artist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE INDEX `ifk_album_artist_id` ON `album` (`artist_id`);

/*******************************************************************************
   Populate Tables
********************************************************************************/

INSERT INTO `artist` (`name`) VALUES (N'AC/DC');
INSERT INTO `artist` (`name`) VALUES (N'Accept');
INSERT INTO `artist` (`name`) VALUES (N'Aerosmith');
INSERT INTO `artist` (`name`) VALUES (N'Alanis Morissette');
INSERT INTO `artist` (`name`) VALUES (N'Alice In Chains');
INSERT INTO `artist` (`name`) VALUES (N'Antônio Carlos Jobim');
INSERT INTO `artist` (`name`) VALUES (N'Apocalyptica');
INSERT INTO `artist` (`name`) VALUES (N'Audioslave');

INSERT INTO `album` (`title`, `artist_id`) VALUES (N'For Those About To Rock We Salute You', 1);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Balls to the Wall', 2);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Restless and Wild', 2);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Let There Be Rock', 1);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Big Ones', 3);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Jagged Little Pill', 4);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Facelift', 5);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Warner 25 Anos', 6);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Plays Metallica By Four Cellos', 7);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Audioslave', 8);
INSERT INTO `album` (`title`, `artist_id`) VALUES (N'Out Of Exile', 8);

COMMIT;