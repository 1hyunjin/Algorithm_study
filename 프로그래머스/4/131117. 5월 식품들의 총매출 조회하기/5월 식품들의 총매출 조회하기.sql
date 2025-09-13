-- 코드를 입력하세요
SELECT p.product_id, p.product_name, sum(o.amount)*p.price as 'TOTAL_SALES'
from food_product p ,food_order o  
where p.product_id = o.product_id
and year(o.produce_date)  = '2022' and month(o.produce_date) = '05'
group by p.product_id
order by sum(o.amount)*p.price desc, p.product_id asc;