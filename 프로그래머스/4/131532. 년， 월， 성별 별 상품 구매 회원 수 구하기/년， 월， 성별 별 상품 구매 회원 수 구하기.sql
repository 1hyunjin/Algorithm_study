-- 코드를 입력하세요
SELECT YEAR(o.SALES_DATE) as 'YEAR', MONTH(o.SALES_DATE) as 'MONTH', i.GENDER, COUNT(DISTINCT(o.USER_ID)) as USERS
FROM USER_INFO i join ONLINE_SALE o
on i.USER_ID = o.USER_ID
where i.GENDER is not null
group by YEAR, MONTH, GENDER
order by 1,2,3 asc;


# select year(o.sales_date) as YEAR, month(o.sales_date) as MONTH, i.gender as GENDER, count(distinct(o.user_id)) as USERS
# from user_info i join online_sale o 
# on o.user_id = i.user_id
# where i.gender is not null
# group by year(o.sales_date), year(o.sales_date), i.gender
# order by 1,2, 3 asc;