-- 코드를 입력하세요
SELECT o.animal_id , o.animal_type, o.name
from animal_outs o , animal_ins i
where o.animal_id = i.animal_id
and i.sex_upon_intake in ('Intact Male', 'Intact Female')
and o.sex_upon_outcome in ('Neutered Male', 'Spayed Female')
order by o.animal_id asc;