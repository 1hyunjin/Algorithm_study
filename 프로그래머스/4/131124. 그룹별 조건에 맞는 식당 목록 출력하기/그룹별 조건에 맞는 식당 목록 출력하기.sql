-- 코드를 입력하세요
SELECT m.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE m LEFT JOIN REST_REVIEW r ON m.MEMBER_ID = r.MEMBER_ID
WHERE r.MEMBER_ID IN (
                SELECT MEMBER_ID
                FROM REST_REVIEW
                GROUP BY MEMBER_ID
                HAVING COUNT(*) = (
                        SELECT COUNT(MEMBER_ID)
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                        ORDER BY COUNT(MEMBER_ID) DESC LIMIT 1
                    )
            )
ORDER BY 3 ASC, 2 ASC;