DROP TABLE IF EXISTS  bugs;
CREATE TABLE bugs(id INT(10), open_date TIMESTAMP, close_date TIMESTAMP, severity VARCHAR(10));
TRUNCATE TABLE bugs;
INSERT INTO bugs VALUES
(1,'2017-05-21','2017-06-02', '1'),
(2,'2017-05-22','2017-06-03', '2'),
(3,'2017-05-15','2017-06-03', '2'),
(4,'2017-04-30','2017-05-17', '3'),
(5,'2017-05-22',null, '1');


DROP PROCEDURE IF EXISTS dateRange;

CREATE PROCEDURE dateRange(dateStart DATE, dateEnd DATE)
-- CALL dateRange('2017-05-16','2017-06-03');
BEGIN
DECLARE cnt INT DEFAULT 0;
DROP TABLE IF EXISTS MisFechas;
WHILE dateStart <= dateEnd DO
   SET cnt = (SELECT COUNT(*) AS COUNT FROM bugs WHERE DATE(open_date) <= dateStart AND DATE(close_date) >= dateStart);
	CREATE TEMPORARY TABLE IF NOT EXISTS MisFechas (
		myDate DATE,
		COUNT INT
	);
	INSERT INTO MisFechas (mydate, COUNT) VALUES (dateStart, cnt);
		SET dateStart = DATE_ADD(dateStart, INTERVAL 1 DAY);
END WHILE;
SELECT * FROM MisFechas;
END;
|
DELIMITER ;