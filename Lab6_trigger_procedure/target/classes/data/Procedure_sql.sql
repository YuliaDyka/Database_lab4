USE `db_jdbc_IMDB`;

-- 1. procedura 'add_country_info';
-- a.Забезпечити параметризовану вставку нових значень у довільну таблицю.
DROP PROCEDURE IF EXISTS add_country_info;
DELIMITER //
CREATE PROCEDURE add_country_info(
    IN in_country_id int, in_info VARCHAR(90)
)
BEGIN
INSERT INTO country_info (country_id, info)
VALUES(in_country_id, in_info);
SELECT * FROM country_info WHERE id = LAST_INSERT_ID();
END //
DELIMITER ;

-- 2. procedura 'add_film_actor'
-- b. Забезпечити реалізацію зв’язку М:М між 2ма таблицями, тобто вставити в стикувальну
--    таблицю відповідну стрічку за реально-існуючими значеннями (напр. surname, name) в цих основних таблицях.
DROP PROCEDURE IF EXISTS add_film_actor;
DELIMITER //
CREATE PROCEDURE add_film_actor(
    IN in_film_id int, in_actor_id int
)
BEGIN
	IF NOT EXISTS (SELECT * FROM films WHERE id = in_film_id)
		THEN
        SET @message = CONCAT('Cannot add record with Film ID:', in_film_id, ' because it does not exist in "films"');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
	IF NOT EXISTS (SELECT * FROM actors WHERE id = in_actor_id)
		THEN
        SET @message = CONCAT('Cannot add record with Actor ID:', in_actor_id, ' because it does not exist in "actors"');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
	IF EXISTS (SELECT * FROM filmactors WHERE film_id = in_film_id AND actor_id = in_actor_id)
		THEN
        SET @message = CONCAT('Cannot add record with Film ID:', in_film_id,
			' and Actor ID:', in_actor_id, ' because it already exist in "filmactors"');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
INSERT INTO filmactors (film_id, actor_id)
VALUES(in_film_id, in_actor_id);

SELECT * FROM filmactors WHERE id = LAST_INSERT_ID();
END //
DELIMITER ;

-- 3. procedura 'add_values_to_country'
-- c. Створити пакет, який вставляє 10 стрічок у довільну таблицю БД у форматі < Noname+№>,
--    наприклад: Noname5, Noname6, Noname7 і т.д.

DROP PROCEDURE IF EXISTS add_values_to_country;
DELIMITER //
CREATE PROCEDURE add_values_to_country(IN in_start_num int, in_count int)
BEGIN
	DECLARE counter int DEFAULT in_start_num;
    loop_label: WHILE  counter < in_start_num + in_count DO
		INSERT INTO countries (name)
		VALUES(CONCAT('Noname', counter));
        SET counter = counter + 1;
END WHILE loop_label;
SELECT * FROM countries WHERE name LIKE '%Noname%';
END //
DELIMITER ;

-- b. Написати користувацьку функцію, яка буде шукати Max, Min, Sum
-- чи Avg для стовпця довільної таблиці у БД. Написати процедуру, яка буде у SELECT викликати цю функцію.

DROP FUNCTION IF EXISTS raiting_avg;
DELIMITER //
CREATE FUNCTION raiting_avg() RETURNS FLOAT
READS SQL DATA
  
BEGIN
RETURN (SELECT AVG(raiting) FROM raitings);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS procedure_avg_raiting;
DELIMITER //
CREATE PROCEDURE procedure_avg_raiting()
BEGIN
SELECT raiting_avg();
END//
DELIMITER ;

-- CALL procedure_avg_raiting();

-- Використовуючи курсор, забезпечити динамічне створення таблиць з назвами+штамп часу, 
-- взятими зі стовпця з довільної таблиці БД, з випадковою кількістю стовпців
 -- (від 1 до 9). Імена та тип стовпців довільні.

-- CURSOR
DROP PROCEDURE IF EXISTS create_rating_with_cursor;
DELIMITER //
CREATE PROCEDURE create_rating_with_cursor()
BEGIN
    DECLARE done BOOL DEFAULT false;
    DECLARE copy_raiting INT;
    DECLARE column_count INT;
    DECLARE my_cursor CURSOR FOR SELECT raiting FROM `raitings`;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
    OPEN my_cursor;
    general_loop: LOOP
        FETCH my_cursor INTO copy_raiting;
        IF (done = true) THEN LEAVE general_loop;
        END IF;
        SET column_count = FLOOR( 1 + RAND( ) * 9);
        SET @table_name = CONCAT('raiting_', copy_raiting, '_');
        SET @my_query = CONCAT('CREATE TABLE ', @table_name, CURRENT_TIMESTAMP() + 1, ' (');
        
        add_columns_loop: LOOP
			IF column_count < 0 THEN LEAVE add_columns_loop;
            END IF;
            
            SET @my_query = CONCAT(@my_query, ' column', column_count,' int ');
			IF column_count!=0 THEN SET @my_query=concat(@my_query,',');
			end if;    
			SET column_count=column_count - 1;
        END LOOP add_columns_loop;
        SET @my_query = CONCAT(@my_query, ')');
        PREPARE create_query FROM @my_query;
        EXECUTE create_query;
        DEALLOCATE PREPARE create_query;
    END LOOP general_loop;
    CLOSE my_cursor;
END //
DELIMITER ;

-- CALL create_rating_with_cursor();