--  insert into user(name, address, username, password, role) values
--  ('Tudor Mihai', 'Cluj,Marasti','tudormihai','1234','client'),
--  ('Pele Ioana','Cluj, Gheorgheni', 'ioanap','1234','administrator'),
--   ('Moldovan Ana', 'Dej','anam','1234','operator');


-- update user set role='operator' where idUser=4;

-- delete from user where iduser=6;
-- select sum(ticket.value) as total from ticket, soldtickets where ticket.idticket=soldtickets.idbilet;

-- select *  from ticket Inner JOIN shows on ticket.idshow=shows.idshow ;
-- select * from ticket left outer JOIN shows on ticket.idshow=shows.idshow ;
-- select * from ticket right outer JOIN shows on ticket.idshow=shows.idshow ;
-- select * from ticket full  JOIN shows on ticket.idshow=shows.idshow ;

-- select *,sum(value) as ' total value' ,count(idticket) as 'number of tickets' from ticket group by ticket.idshow;