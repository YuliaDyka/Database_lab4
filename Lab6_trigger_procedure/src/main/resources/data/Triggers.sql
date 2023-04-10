USE `db_jdbc_IMDB`;

-- 1. Додати до БД 1 додаткову довільну таблицю і зв’язати з іншою існуючою таблицею зв’язком  1:M.
--    Однак для забезпечення цілісності значень використати тригери замість фізичного зовнішнього ключа.

CREATE TABLE IF NOT EXISTS country_info
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    info   VARCHAR(90) NOT NULL
    );

-- triggers for table insert CountryInfo (if exist country id)
DROP TRIGGER IF EXISTS insertTriggerCountryInfo;
DELIMITER //
CREATE TRIGGER insertTriggerCountryInfo
    BEFORE INSERT
    ON country_info
    FOR EACH ROW
BEGIN
    IF NOT EXISTS (SELECT * FROM countries WHERE id = NEW.country_id)
		THEN
        SET @message = CONCAT('TRIGGER - Cannot insert info because country ID:', NEW.country_id, ' does not exist');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
END //
DELIMITER ;

-- triggers for table update CountryInfo (if exist country id)
DROP TRIGGER IF EXISTS updateTriggerCountryInfo;
DELIMITER //
CREATE TRIGGER updateTriggerCountryInfo
    BEFORE UPDATE
    ON country_info
    FOR EACH ROW
BEGIN
    IF NOT EXISTS (SELECT * FROM countries WHERE id = NEW.country_id)
		THEN
        SET @message = CONCAT('TRIGGER - Cannot update info because country ID:', NEW.country_id, ' does not exist');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
END //
DELIMITER ;

-- triggers for table delete countries
DROP TRIGGER IF EXISTS deleteTriggerCountry;
DELIMITER //
CREATE TRIGGER deleteTriggerCountry
    BEFORE DELETE
    ON countries
    FOR EACH ROW
BEGIN
    IF EXISTS (SELECT * FROM country_info WHERE country_id = OLD.id)
		THEN
        SET @message = CONCAT('TRIGGER - Cannot delete country with ID:', OLD.id, ' because it is used in: "country_info"');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
END //
DELIMITER ;


-- triggers for table update countries
DROP TRIGGER IF EXISTS updateTriggerCountry;
DELIMITER //
CREATE TRIGGER updateTriggerCountry
    BEFORE UPDATE
    ON countries
    FOR EACH ROW
BEGIN
    IF EXISTS (SELECT * FROM country_info WHERE country_id = OLD.id)
		THEN
        SET @message = CONCAT('TRIGGER - Cannot update country _inwith ID:', OLD.id, ' because it is used in: "country_info"');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
END //
DELIMITER ;

-- DELETE FROM countries WHERE id = 1;
-- UPDATE countries SET name = "test" WHERE id = 1;


-- INSERT INTO country_info (country_id, info)
-- VALUES(23, 'Test_info_1');

-- UPDATE country_info
-- SET country_id = 1
-- WHERE id = 1