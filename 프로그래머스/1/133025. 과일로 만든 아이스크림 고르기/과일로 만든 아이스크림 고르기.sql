-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF f join ICECREAM_INFO i
on f.FLAVOR = i.FLAVOR
where i.INGREDIENT_TYPE = 'fruit_based'
and f.TOTAL_ORDER > 3000
order by f.TOTAL_ORDER DESC;