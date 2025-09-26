-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(s.SALES) AS TOTAL_SALES
FROM BOOK_SALES s JOIN BOOK b ON s.BOOK_ID = b.BOOK_ID
WHERE s.SALES_DATE LIKE '2022-01%'
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY;

select b.category, sum(s.sales) as TOTAL_SALES
from book b join book_sales s 
where b.book_id = s.book_id
and YEAR(s.sales_date) = 2022 and MONTH(s.sales_date) = 1
group by b.category
order by b.category asc;