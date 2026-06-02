select count(id), month(time) as month
from fish_info
group by month
order by month asc