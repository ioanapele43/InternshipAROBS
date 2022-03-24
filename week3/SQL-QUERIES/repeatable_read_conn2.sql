SET TRANSACTION ISOLATION LEVEL repeatable read;

	insert into shows ( title, director, releasedate,lastmodification) 
    values ("r2","aaaA",now(),now());
    
COMMIT;
    