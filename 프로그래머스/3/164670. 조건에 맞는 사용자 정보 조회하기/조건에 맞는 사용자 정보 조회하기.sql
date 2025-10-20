-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, CONCAT(u.CITY, ' ', u.STREET_ADDRESS1, ' ', u.STREET_ADDRESS2) as 전체주소, 
        CONCAT(
            SUBSTRING(TLNO, 1, 3), '-',
            SUBSTRING(TLNO, 4, 4), '-',
            SUBSTRING(TLNO, 8, 4)
        ) AS TLNO
FROM USED_GOODS_USER u
WHERE  u.USER_ID IN (
            SELECT WRITER_ID
            FROM USED_GOODS_BOARD
            GROUP BY WRITER_ID
            HAVING COUNT(WRITER_ID) >= 3
        )
ORDER BY u.USER_ID DESC;
