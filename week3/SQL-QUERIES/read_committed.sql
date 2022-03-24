START TRANSACTION;

     UPDATE shows 
     set title="orasul pierdut" 
     where idshow=2;
     

COMMIT;