-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME 
FROM ANIMAL_OUTS o 
where o.ANIMAL_ID not in (select ANIMAL_ID from ANIMAL_INS);