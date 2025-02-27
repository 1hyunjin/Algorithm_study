-- 코드를 입력하세요
SELECT YEAR(o.SALES_DATE) as 'YEAR', MONTH(o.SALES_DATE) as 'MONTH', i.GENDER, COUNT(DISTINCT(o.USER_ID))
FROM USER_INFO i join ONLINE_SALE o
on i.USER_ID = o.USER_ID
where i.GENDER is not null
group by YEAR, MONTH, GENDER
order by 1,2,3 asc;
