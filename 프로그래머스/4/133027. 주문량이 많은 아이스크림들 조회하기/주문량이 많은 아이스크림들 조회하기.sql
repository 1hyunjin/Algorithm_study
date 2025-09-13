-- 코드를 입력하세요
SELECT f.flavor
from FIRST_HALF f  left join JULY j on f.FLAVOR = j.FLAVOR
group by f.flavor
order by sum(f.total_order + j.total_order) desc limit 3;
