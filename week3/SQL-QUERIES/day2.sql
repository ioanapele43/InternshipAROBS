DELIMITER //
create procedure GetAllShows()
	begin
		select * from shows;
	end //
DELIMITER ;
call GetAllShows();

DELIMITER //
create trigger showDelete2 AFTER DELETE
on shows for each row
begin 
	delete from ticket where ticket.idshow=OLD.idshow;
end //
DELIMITER ;

DELIMITER //
DROP TRIGGER IF EXISTS my_update_trigger//

CREATE TRIGGER my_update_trigger
    BEFORE UPDATE ON `shows`
    FOR EACH ROW
BEGIN
    SET NEW.lastModification = NOW();
END//
DELIMITER ;

-- scalar valued function

-- CREATE DEFINER=`student`@`%` FUNCTION `tickets`(datap datetime) RETURNS char(20) CHARSET utf8mb4
--     DETERMINISTIC
-- BEGIN
-- 	declare myItem char(20);
--     if datap< now() then 
-- 		set myItem="a fost in trecut";
-- 	else
-- 		set myItem="urmeaza";
-- 	end if;
-- 	RETURN myItem;
-- END

-- table valued functons nu se pot crea in mysql workbench, nu recunoaste tipul table....alter

select shows.title, ticketsDate(shows.ReleaseDate) from shows;
DELIMITER //
create procedure GetAllShowsStatusDate()
	begin
		select shows.title, ticketsDate(shows.ReleaseDate) from shows;
	end //
DELIMITER ;
call GetAllShowsStatusDate();



