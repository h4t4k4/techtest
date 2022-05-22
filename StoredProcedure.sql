CREATE PROCEDURE db_demoapi.sp_migrateMasterAccount()
BEGIN
	INSERT INTO MasterAccount (Name,AccountNo,AvailableBalance) 
SELECT A.Name,A.AccountNo,(A.OriginalBalance-B.HoldBalance) as OriginalBalance 
FROM Account A INNER JOIN HoldBalance B ON A.AccountNo =B.AccountNo 
ON DUPLICATE KEY UPDATE AvailableBalance=VALUES(AvailableBalance) ;
END
