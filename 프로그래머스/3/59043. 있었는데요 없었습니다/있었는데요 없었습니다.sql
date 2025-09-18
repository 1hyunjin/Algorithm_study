-- 코드를 입력하세요
select i.animal_id, i.name from animal_ins i, animal_outs o
where i.animal_id = o.animal_id and i.datetime > o.datetime
order by i.datetime;

SELECT i.ANIMAL_ID, i.NAME FROM ANIMAL_INS i, ANIMAL_OUTS o
WHERE i.ANIMAL_ID = o.ANIMAL_ID AND i.DATETIME > o.DATETIME
ORDER BY i.DATETIME ASC;