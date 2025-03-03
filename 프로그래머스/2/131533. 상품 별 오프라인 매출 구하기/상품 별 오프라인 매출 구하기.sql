-- 코드를 입력하세요
select p.product_code, sum(o.sales_amount) * p.price as 'SALES'
from offline_sale o join  product p on o.product_id = p.product_id
group by o.product_id
order by sum(o.sales_amount) * p.price desc, p.product_code asc;