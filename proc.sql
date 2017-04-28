DELIMITER 
CREATE  PROCEDURE orderP(IN IDp int,IN IDc int,IN quantityC int )
BEGIN
	
  set @aux=(Select quantity from Product where ID = IDp);

if (quantityC<@aux) then
INSERT INTO OrderProduct (IDp, IDc, quantity)
VALUES (IDp,IDc,quantityC);

UPDATE Product
set quantity = quantity - quantityC
where ID = IDp;
end if;

    
END

