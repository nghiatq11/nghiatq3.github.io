alter PROC spGetImgsByPageAndSize
@Page INT,
@Size INT
AS
BEGIN
	SELECT * FROM picture
	ORDER BY id DESC
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END

select * from product
EXECUTE spGetImgsByPageAndSize 1, 4

