CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idusers_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);
CREATE TABLE `albums` (
  `id` int NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `label` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `songs` (
  `id` int NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `durration` time DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `alternative_titles` (
  `id` int NOT NULL,
  `song_id` int DEFAULT NULL,
  `alternative_title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tosong_idx` (`song_id`),
  CONSTRAINT `tosong` FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`)
);
CREATE TABLE `playlists` (
  `id` int NOT NULL,
  `owner_user_id` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id user_idx` (`owner_user_id`),
  CONSTRAINT `id user` FOREIGN KEY (`owner_user_id`) REFERENCES `users` (`id`)
);
CREATE TABLE `artists` (
  `id` int NOT NULL,
  `activity_start_date` date DEFAULT NULL,
  `activity_end_date` date DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `person` (
  `id` int NOT NULL,
  `artist_id` int DEFAULT NULL,
  `fisrt_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `stage_name` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idpa_idx` (`artist_id`),
  CONSTRAINT `idpa` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`)
);
CREATE TABLE `band` (
  `id` int NOT NULL,
  `artist_id` int DEFAULT NULL,
  `band_name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idba_idx` (`artist_id`),
  CONSTRAINT `idba` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`)
);
CREATE TABLE `band_members` (
  `id` int NOT NULL,
  `band_id` int DEFAULT NULL,
  `person_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bandmembers_idx` (`person_id`),
  KEY `inband_idx` (`band_id`),
  CONSTRAINT `bandmembers` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `inband` FOREIGN KEY (`band_id`) REFERENCES `band` (`id`)
);
CREATE TABLE `playlist-songs` (
  `id` int NOT NULL,
  `playlist_id` int DEFAULT NULL,
  `song_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idp_idx` (`playlist_id`),
  KEY `ids_idx` (`song_id`),
  CONSTRAINT `idp` FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`id`),
  CONSTRAINT `ids` FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`)
);
CREATE TABLE `song-artist` (
  `id` int NOT NULL,
  `song_id` int DEFAULT NULL,
  `artist_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `song_idx` (`song_id`),
  KEY `artist_idx` (`artist_id`),
  CONSTRAINT `artist` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`),
  CONSTRAINT `song` FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`)
) ;
CREATE TABLE `song-album` (
  `id` int NOT NULL,
  `song_id` int DEFAULT NULL,
  `album_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id song_idx` (`song_id`),
  KEY `id album_idx` (`album_id`),
  CONSTRAINT `id album` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`),
  CONSTRAINT `id song` FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`)
);
CREATE TABLE `album-artist` (
  `id` int NOT NULL,
  `album_id` int DEFAULT NULL,
  `artist_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `album_idx` (`album_id`),
  KEY `artist_idx` (`artist_id`),
  CONSTRAINT `album` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`),
  CONSTRAINT `artistid` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`)
);
CREATE TABLE `musify`.`followed_playlists_by_user` (
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `playlist_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_who_is_following_idx` (`user_id` ASC) VISIBLE,
  INDEX `playlist_followed_idx` (`playlist_id` ASC) VISIBLE,
  CONSTRAINT `user_who_is_following`
    FOREIGN KEY (`user_id`)
    REFERENCES `musify`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `playlist_followed`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `musify`.`playlists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
