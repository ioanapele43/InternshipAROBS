SET TRANSACTION ISOLATION LEVEL READ COMMITTED;

	do sleep(10);
    
	select * 
    from shows 
    where idshow=2;
    
    do sleep(10);
    
    select * 
    from shows 
    where idshow=2;
    
COMMIT;
    
    