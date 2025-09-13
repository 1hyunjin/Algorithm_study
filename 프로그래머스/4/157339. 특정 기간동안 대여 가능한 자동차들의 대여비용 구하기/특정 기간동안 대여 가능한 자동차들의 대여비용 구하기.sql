-- 코드를 입력하세요
SELECT c.car_id, c.car_type , ROUND(c.daily_fee * 30 * (1-d.discount_rate/100),0) as 'FEE'
from car_rental_company_car c, car_rental_company_discount_plan d, car_rental_company_rental_history h
where c.car_id = h.car_id 
and c.car_type = d.car_type 
and c.car_type in ('세단', 'SUV') 
and d.duration_type = "30일 이상"
and h.car_id not in (select car_id from car_rental_company_rental_history h where end_date >= "2022-11-01" and start_date <= "2022-11-30") 
and  c.daily_fee * 30 * (1-d.discount_rate/100) >= 500000 and  c.daily_fee * 30 * (1-d.discount_rate/100) < 2000000
order by c.car_type asc, c.car_id desc
;


SELECT c.CAR_ID, c.CAR_TYPE, FLOOR(c.DAILY_FEE * (100 - d.DISCOUNT_RATE) / 100 * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR c
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d
ON c.CAR_TYPE = d.CAR_TYPE 
AND d.DURATION_TYPE = '30일 이상'
WHERE c.CAR_TYPE IN ('세단', 'SUV')
AND CAR_ID NOT IN (
    SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE NOT (END_DATE < '2022-11-01' OR START_DATE > '2022-11-30')
) 
AND FLOOR(c.DAILY_FEE * (100 - d.DISCOUNT_RATE) / 100 * 30) BETWEEN 500000 AND 1999999
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;