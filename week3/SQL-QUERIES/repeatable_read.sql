START TRANSACTION;

	select * 
    from shows ;
    
    do sleep(15);
    
    UPDATE shows 
    set title="orasul " 
    where idshow=2;
    
    select * 
    from shows;
    
COMMIT;