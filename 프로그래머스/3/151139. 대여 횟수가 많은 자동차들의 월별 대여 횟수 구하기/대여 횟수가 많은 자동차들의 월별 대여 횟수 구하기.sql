select month(start_date) as MONTH, car_id, count(car_id) as RECORDS
from car_rental_company_rental_history
where car_id in (select car_id 
                        from car_rental_company_rental_history
                        where year(start_date) = '2022' and month(start_date) in (8,9,10)
                        group by car_id
                        having count(car_id) >= 5
                    
                )
and year(start_date) = '2022' and month(start_date) in (8,9,10)
group by month(start_date), car_id
order by month(start_date), car_id desc;