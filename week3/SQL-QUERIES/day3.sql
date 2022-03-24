START TRANSACTION;

-- 2. Get the latest order number
SELECT 
    @maxprice:=MAX(ticket.value)+1
FROM
    ticket;

-- 3. insert a new order for customer 145
INSERT INTO ticket(idshow,ticket.row,ticket.seat,ticket.value)
VALUES(1,2,3,@maxprice);
        
-- 4. Insert order line items
INSERT INTO ticket(idshow,ticket.row,ticket.seat,ticket.value)
VALUES(1,2,4,@maxprice),
      (1,2,5,@maxprice); 
      
-- 5. commit changes    
COMMIT;