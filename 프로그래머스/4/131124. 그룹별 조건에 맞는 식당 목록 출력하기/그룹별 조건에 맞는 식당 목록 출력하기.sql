-- 코드를 입력하세요
SELECT p.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as 'REVIEW_DATE'
from member_profile p left join rest_review r on p.member_id = r.member_id
where r.member_id in (
    select member_id
    from rest_review
    group by member_id
    having count(*) = (
        select max(CNT)
        from (
            select member_id, count(*) as CNT
            from rest_review
            group by member_id
        ) T
    ) 
)
order by r.review_date asc, r.review_text asc;