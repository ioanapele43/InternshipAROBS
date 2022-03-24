SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

	select * 
    from shows 
    where idshow=2;
    
    do sleep(10);
    
    select * 
    from shows 
    where idshow=2;
    