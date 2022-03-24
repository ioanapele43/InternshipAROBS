SET TRANSACTION ISOLATION LEVEL repeatable read;

	do sleep(5);
    
	insert into shows ( title, director, releasedate,lastmodification) 
    values ("r2","aaaA",now(),now());
    
COMMIT;
    