-- 코드를 작성해주세요
select sum(g.score) as SCORE, g.emp_no as EMP_NO,
        e.EMP_NAME, e.POSITION, e.EMAIL
from HR_GRADE g join HR_EMPLOYEES e
on g.EMP_NO = e.EMP_NO
group by EMP_NO
order by score desc limit 1;