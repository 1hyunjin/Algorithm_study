-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
FROM ANIMAL_INS i join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE IN ('Intact Male', 'Intact Female') and o.SEX_UPON_OUTCOME IN ('Neutered Male', 'Spayed Female')
ORDER BY ANIMAL_ID;