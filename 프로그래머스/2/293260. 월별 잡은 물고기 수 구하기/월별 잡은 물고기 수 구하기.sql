-- 코드를 작성해주세요
select count(*) FISH_COUNT, MONTH(TIME) as MONTH
from fish_info
group by MONTH(TIME)
having count(*) > 0
order by MONTH(TIME) asc;