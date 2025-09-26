-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,  DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
    CASE 
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 30 THEN '장기 대여'
        
        ELSE '단기 대여'
    END AS RENT_TYPE
    
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) = 9 
ORDER BY HISTORY_ID DESC;

# select history_id, car_id, date_format(start_date, '%Y-%m-%d') as start_date , date_format(end_date, '%Y-%m-%d') as end_date, 
#         case 
#             when datediff(start_date, end_date) + 1 >= 30 then '장기 대여'
#             else '단기 대여'
#         end as RENT_TYPE
# from car_rental_company_rental_history
# where MONTH(start_date) = 9
# order by history_id desc;