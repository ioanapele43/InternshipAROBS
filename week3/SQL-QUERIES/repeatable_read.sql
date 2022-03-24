START TRANSACTION;
	insert into shows ( title, director, releasedate,lastmodification) 
    values ("r2","aaaA",now(),now());
    
COMMIT;
    
	