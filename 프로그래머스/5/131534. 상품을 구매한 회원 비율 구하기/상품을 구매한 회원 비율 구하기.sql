-- 코드를 입력하세요
SELECT 
    year(o.sales_date) as 'YEAR', 
    month(o.sales_date) as 'MONTH', 
    count(distinct(o.user_id)) as 'PURCHASED_USERS',
    round(count(distinct(o.user_id))/(select count(user_id) from user_info where year(joined) = '2021'), 1) as 'PUCHASED_RATIO'


from online_sale o , user_info i 
where i.user_id = o.user_id
and year(i.joined) = '2021'
group by year(o.sales_date), month(o.sales_date)
order by year(o.sales_date), month(o.sales_date);
