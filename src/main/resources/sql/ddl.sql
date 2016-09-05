SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS movies;
CREATE TABLE IF NOT EXISTS movies (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  year SMALLINT NOT NULL,
  avg_rating decimal(3,2) NOT NULL COMMENT 'cached ratings',
  genre varchar(25) NOT NULL, /*enum('ACTION','ADVENTURE','COMEDY','CRIME','DRAMA','FANTASY','HISTORICAL','HISTORICAL_FICTION','HORROR','MAGICAL_REALISM','MYSTERY','PARANOID','PHILOSOPHICAL','POLITICAL','ROMANCE','SAGA','SATIRE','SCIENCE_FICTION','SLICE_OF_LIFE','SPECULATIVE','THRILLER','URBAN','WESTERN','ANIMATION')*/
  director varchar(20) DEFAULT NULL,
  dao_created datetime NOT NULL,
  dao_updated datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ;

DROP TABLE IF EXISTS rates;
CREATE TABLE IF NOT EXISTS rates (
  id INTEGER NOT NULL AUTO_INCREMENT,
  user_id INTEGER NOT NULL,
  movie_id INTEGER NOT NULL,
  rate decimal(3,2) NOT NULL,
  watched_date date NOT NULL,
  watched_time time NOT NULL,
  dao_created datetime NOT NULL,
  dao_updated datetime DEFAULT NULL,
  PRIMARY KEY (id),
--   KEY user_id (user_id),
--   KEY movie_id (movie_id)
) ;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
  id INTEGER NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  birthdate date NOT NULL,
  dao_created datetime NOT NULL,
  dao_updated datetime DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE (username,email)
) ;

-- ALTER TABLE rates
--   ADD CONSTRAINT rates_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
--   ADD CONSTRAINT rates_ibfk_2 FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE;
SET FOREIGN_KEY_CHECKS=1;
