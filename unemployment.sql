CREATE TABLE month (
  id int NOT NULL AUTO_INCREMENT,
  month varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE duration (
  id int NOT NULL AUTO_INCREMENT,
  duration varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ageGroup (
  id int NOT NULL AUTO_INCREMENT,
  age_group varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE unemployment (
  id int NOT NULL AUTO_INCREMENT,
  month_id int NOT NULL,
  duration_id int NOT NULL,
  age_group_id int NOT NULL,
  male double NOT NULL DEFAULT '0',
  female double NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  KEY MonthId_idx (month_id),
  KEY DurationId_idx (duration_id),
  KEY AgeGroupId_idx (age_group_id),
  CONSTRAINT AgeGroupId FOREIGN KEY (age_group_id) REFERENCES ageGroup (id),
  CONSTRAINT DurationId FOREIGN KEY (duration_id) REFERENCES duration (id),
  CONSTRAINT MonthId FOREIGN KEY (month_id) REFERENCES month (id)
);

INSERT INTO month (month)												
VALUES 
('Mar'),
('Jun'),
('Sep'),
('Dec');

INSERT INTO duration (duration)												
VALUES 
('1-4 weeks'),
('5-13 weeks'),
('14-25 weeks'),
('26 weeks'),
('27-51 weeks'),
('52 weeks'),
('53 weeks or more'),
('unknown');

INSERT INTO ageGroup (age_group)												
VALUES 
('15-19'),
('20-24'),
('25-44'),
('45-54'),
('55-64'),
('65 years and over');

INSERT INTO unemployment (month_id, duration_id, age_group_id, male, female)
VALUES 
(1, 1, 1, 18.4, 11.4), 
(1, 1, 2, 24.7, 12.6), 
(1, 1, 3, 34.6, 32.8), 
(1, 1, 4, 9.9, 10.3), 
(1, 1, 5, 14.6, 8.2), 
(1, 1, 6, 2, 0), 
(1, 2, 1, 7.7, 6.1), 
(1, 2, 2, 13.4, 7.4), 
(1, 2, 3, 31.7, 23.2), 
(1, 2, 4, 7.9, 7.5), 
(1, 2, 5, 10.8, 7.8), 
(1, 2, 6, 0, 0), 
(1, 3, 1, 2.7, 1.5), 
(1, 3, 2, 6.1, 4.9), 
(1, 3, 3, 13.3, 11.8), 
(1, 3, 4, 5.5, 4.2), 
(1, 3, 5, 4.4, 2.1), 
(1, 3, 6, 1.7, 0), 
(1, 4, 1, 0, 0), 
(1, 4, 2, 0, 0), 
(1, 4, 3, 0, 0), 
(1, 4, 4, 0, 0), 
(1, 4, 5, 0, 0), 
(1, 4, 6, 0, 0), 
(1, 5, 1, 0, 0), 
(1, 5, 2, 0, 0), 
(1, 5, 3, 6, 6.8), 
(1, 5, 4, 2.5, 2.4), 
(1, 5, 5, 3.3, 1.9), 
(1, 5, 6, 2.6, 0), 
(1, 6, 1, 0, 0), 
(1, 6, 2, 0, 0), 
(1, 6, 3, 6, 2.9), 
(1, 6, 4, 2.1, 0), 
(1, 6, 5, 0, 0), 
(1, 6, 6, 0, 0), 
(1, 7, 1, 0, 0), 
(1, 7, 2, 0, 0), 
(1, 7, 3, 4.3, 4), 
(1, 7, 4, 2.9, 2.6), 
(1, 7, 5, 5.3, 3.4), 
(1, 7, 6, 0, 0), 
(1, 8, 1, 0, 1.5), 
(1, 8, 2, 2.6, 0), 
(1, 8, 3, 5.2, 3.3), 
(1, 8, 4, 2.3, 0), 
(1, 8, 5, 0, 2.1), 
(1, 8, 6, 0, 0), 
(2, 1, 1, 15.8, 22.8), 
(2, 1, 2, 22.2, 19.4), 
(2, 1, 3, 26.9, 32.1), 
(2, 1, 4, 6.8, 8.8), 
(2, 1, 5, 8.4, 5.6), 
(2, 1, 6, 0, 0), 
(2, 2, 1, 8.8, 8.5), 
(2, 2, 2, 11, 7.6), 
(2, 2, 3, 21, 18.8), 
(2, 2, 4, 7.7, 7.2), 
(2, 2, 5, 11.7, 3.7), 
(2, 2, 6, 1.6, 0), 
(2, 3, 1, 3.7, 0), 
(2, 3, 2, 4.4, 3.2), 
(2, 3, 3, 20.5, 18.1), 
(2, 3, 4, 6.2, 4.3), 
(2, 3, 5, 7.5, 5.2), 
(2, 3, 6, 0, 0), 
(2, 4, 1, 0, 0), 
(2, 4, 2, 0, 0), 
(2, 4, 3, 1.5, 0), 
(2, 4, 4, 0, 0), 
(2, 4, 5, 0, 0), 
(2, 4, 6, 0, 0), 
(2, 5, 1, 0, 0), 
(2, 5, 2, 2.3, 1.8), 
(2, 5, 3, 7.7, 5), 
(2, 5, 4, 3.4, 3), 
(2, 5, 5, 1.8, 2.9), 
(2, 5, 6, 0, 0), 
(2, 6, 1, 0, 0), 
(2, 6, 2, 0, 0), 
(2, 6, 3, 2, 2), 
(2, 6, 4, 3.6, 2), 
(2, 6, 5, 3, 0), 
(2, 6, 6, 0, 0), 
(2, 7, 1, 0, 0), 
(2, 7, 2, 0, 0), 
(2, 7, 3, 3.9, 1.7), 
(2, 7, 4, 0, 1.9), 
(2, 7, 5, 3, 2.6), 
(2, 7, 6, 0, 0), 
(2, 8, 1, 2, 1.7), 
(2, 8, 2, 1.6, 2.1), 
(2, 8, 3, 3.3, 2.6), 
(2, 8, 4, 0, 0), 
(2, 8, 5, 1.5, 0), 
(2, 8, 6, 0, 0), 
(3, 1, 1, 24.4, 18), 
(3, 1, 2, 18, 21.7), 
(3, 1, 3, 34.4, 38.6), 
(3, 1, 4, 6.5, 9.5), 
(3, 1, 5, 6.6, 12.8), 
(3, 1, 6, 0, 0), 
(3, 2, 1, 12.7, 10.5), 
(3, 2, 2, 13.7, 9.2), 
(3, 2, 3, 20.4, 24.9), 
(3, 2, 4, 5.3, 8), 
(3, 2, 5, 7, 8.4), 
(3, 2, 6, 1.6, 2.2), 
(3, 3, 1, 2, 2.4), 
(3, 3, 2, 5.2, 2), 
(3, 3, 3, 12.8, 7.1), 
(3, 3, 4, 4.8, 3.8), 
(3, 3, 5, 4, 2.2), 
(3, 3, 6, 0, 0), 
(3, 4, 1, 0, 0), 
(3, 4, 2, 0, 0), 
(3, 4, 3, 0, 0), 
(3, 4, 4, 0, 0), 
(3, 4, 5, 0, 0), 
(3, 4, 6, 0, 0), 
(3, 5, 1, 0, 0), 
(3, 5, 2, 0, 2), 
(3, 5, 3, 9.9, 8), 
(3, 5, 4, 4.1, 2.7), 
(3, 5, 5, 2.5, 1.9), 
(3, 5, 6, 0, 0), 
(3, 6, 1, 0, 0), 
(3, 6, 2, 0, 0), 
(3, 6, 3, 4.1, 1.9), 
(3, 6, 4, 1.5, 0), 
(3, 6, 5, 0, 2.2), 
(3, 6, 6, 0, 0), 
(3, 7, 1, 0, 0), 
(3, 7, 2, 0, 0), 
(3, 7, 3, 2.3, 0), 
(3, 7, 4, 0, 1.9), 
(3, 7, 5, 3.7, 2), 
(3, 7, 6, 0, 0), 
(3, 8, 1, 0, 2.7), 
(3, 8, 2, 2.5, 0), 
(3, 8, 3, 6.1, 11.4), 
(3, 8, 4, 0, 5.9), 
(3, 8, 5, 1.5, 4.7), 
(3, 8, 6, 0, 0), 
(4, 1, 1, 11.5, 11.4), 
(4, 1, 2, 15, 10.8), 
(4, 1, 3, 31.8, 24.2), 
(4, 1, 4, 8.4, 9.1), 
(4, 1, 5, 9.8, 8.4), 
(4, 1, 6, 0, 0), 
(4, 2, 1, 8, 7.3), 
(4, 2, 2, 10.6, 8.7), 
(4, 2, 3, 25, 23.7), 
(4, 2, 4, 5.8, 7.9), 
(4, 2, 5, 5.2, 4.6), 
(4, 2, 6, 0, 0), 
(4, 3, 1, 2, 0), 
(4, 3, 2, 5.9, 2.2), 
(4, 3, 3, 15.1, 8.6), 
(4, 3, 4, 4.4, 3.1), 
(4, 3, 5, 4.7, 2.9), 
(4, 3, 6, 1.6, 1.9), 
(4, 4, 1, 0, 0), 
(4, 4, 2, 0, 0), 
(4, 4, 3, 0, 0), 
(4, 4, 4, 0, 0), 
(4, 4, 5, 0, 0), 
(4, 4, 6, 0, 0), 
(4, 5, 1, 0, 0), 
(4, 5, 2, 2.6, 0), 
(4, 5, 3, 7.5, 3.9), 
(4, 5, 4, 2.6, 1.6), 
(4, 5, 5, 3.8, 2.3), 
(4, 5, 6, 0, 0), 
(4, 6, 1, 0, 0), 
(4, 6, 2, 1.5, 0), 
(4, 6, 3, 3.4, 3.2), 
(4, 6, 4, 1.8, 1.8), 
(4, 6, 5, 0, 0), 
(4, 6, 6, 0, 0), 
(4, 7, 1, 0, 0), 
(4, 7, 2, 0, 2.3), 
(4, 7, 3, 3.2, 2.4), 
(4, 7, 4, 0, 3.3), 
(4, 7, 5, 2.1, 2.7), 
(4, 7, 6, 0, 0), 
(4, 8, 1, 0, 0), 
(4, 8, 2, 0, 0), 
(4, 8, 3, 2.8, 2.7), 
(4, 8, 4, 0, 0), 
(4, 8, 5, 0, 1.6), 
(4, 8, 6, 0, 0);


SELECT m.month, d.duration, format(sum(u.male), 1) AS male, format(sum(u.female), 1) AS female, format(sum(u.male + u.female), 1) AS total
FROM unemployment u
JOIN month m
ON u.month_id = m.id
JOIN duration d
ON u.duration_id = d.id
GROUP BY m.id, d.id
ORDER BY m.id, d.id;

SELECT m.month, ag.age_group, format(sum(u.male), 1) AS male, format(sum(u.female), 1) AS female, format(sum(u.male + u.female), 1) AS total
FROM unemployment u
JOIN month m
ON u.month_id = m.id
JOIN ageGroup ag
ON u.age_group_id = ag.id
GROUP BY m.id, ag.id
ORDER BY m.id, ag.id;


SELECT u.id, m.month, d.duration, ag.age_group, format(sum(u.male), 1) AS male, format(sum(u.female), 1) AS female, format(sum(u.male + u.female), 1) AS total
FROM unemployment u
JOIN month m
ON u.month_id = m.id
JOIN duration d
ON u.duration_id = d.id
JOIN ageGroup ag
ON u.age_group_id = ag.id
GROUP BY u.id, m.id, d.id, ag.id
ORDER BY u.id, m.id, d.id, ag.id;
