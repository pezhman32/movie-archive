SET FOREIGN_KEY_CHECKS=0;

INSERT INTO movies (id, name, year, avg_rating, genre, director, dao_create, dao_updated) VALUES
(1, 'Customer', 2016, '4.50', 'DRAMA', 'Asghar Farhadi', '2016-09-03 00:00:00', NULL);

INSERT INTO users (id, username, email, password, birthdate, dao_created, dao_updated) VALUES
(3, 'pezhman32', 'pezhman32@gmail.com', '', '2016-03-21', '2016-09-03 00:00:00', NULL),
(4, 'keyhan', 'keyhangholami@gmail.com', '', '1987-09-01', '2016-09-03 00:00:00', NULL);

INSERT INTO rates (id, user_id, movie_id, rate, watched_date, watched_time, dao_created, dao_updated) VALUES
(1, 3, 1, '5.00', '2016-09-02', '23:00:00', '2016-09-03 00:00:00', NULL),
(2, 4, 1, '4.00', '2016-09-03', '16:00:00', '2016-09-03 00:00:00', NULL);

SET FOREIGN_KEY_CHECKS=1;
