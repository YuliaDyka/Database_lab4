USE `db_jdbc_IMDB`;

-- a. Значення певного стовпця не може закінчувати двома нулями

DROP TRIGGER IF EXISTS canNotHaveLastZerroTriggerRaitings;
DELIMITER //
CREATE TRIGGER canNotHaveLastZerroTriggerRaitings
    BEFORE INSERT
    ON raitings_entity
    FOR EACH ROW
BEGIN
    SET @rait = CONVERT(NEW.raiting, CHAR(50));
	IF  (SUBSTRING(@rait, -2)='00')
		THEN
        SET @message = CONCAT('Cannot add rating:', NEW.raiting, ', because it ends with two "00"');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END IF;
END //
DELIMITER ;

-- b. Заборонити будь-яку модифікацію даних в таблиці
DROP TRIGGER IF EXISTS canNotUpdateTriggerRaitings;
DELIMITER //
CREATE TRIGGER canNotUpdateTriggerRaitings
    BEFORE UPDATE
    ON raitings_entity
    FOR EACH ROW
BEGIN
    SET @message = CONCAT('You cannot modify table "raitings"');
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END //
DELIMITER ;


-- c. Заборонити видалення стрічок з таблиці
DROP TRIGGER IF EXISTS canNotDeleteRowTriggerRaitings;
DELIMITER //
CREATE TRIGGER canNotDeleteRowTriggerRaitings
    BEFORE DELETE
    ON raitings_entity
    FOR EACH ROW
BEGIN
    SET @message = CONCAT('You cannot delete row from "raitings"');
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message;
END //
DELIMITER ;

