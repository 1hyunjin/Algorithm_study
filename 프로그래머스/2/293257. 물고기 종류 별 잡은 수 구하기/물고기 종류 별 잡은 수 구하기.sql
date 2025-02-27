-- 코드를 작성해주세요
# select * from fish_info;
# select * from fish_name_info;

select count(*) as 'FISH_COUNT', n.fish_name
from fish_info i, fish_name_info n
where i.fish_type = n.fish_type
group by n.fish_name
order by 1 desc;