START TRANSACTION;

	 do sleep(10); 
     
     UPDATE shows 
     set title="orasul pierdut" 
     where idshow=2;
     
     do sleep(10);
     
	 select * 
     from shows ;

COMMIT;