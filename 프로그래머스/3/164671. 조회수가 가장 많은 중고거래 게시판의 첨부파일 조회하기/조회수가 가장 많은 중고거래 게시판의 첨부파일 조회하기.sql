-- 코드를 입력하세요
SELECT concat('/home/grep/src/', b.BOARD_ID, '/', f.file_name, f.file_ext) as FILE_PATH
from used_goods_board b join used_goods_file f on b.board_id = f.board_id
 WHERE b.views = (SELECT MAX(views) FROM used_goods_board)
order by f.file_id desc;

SELECT
  CONCAT('/home/grep/src/', f.board_id, '/', f.file_id, f.file_name, '.', f.file_ext) AS FILE_PATH
FROM used_goods_file AS f
WHERE f.board_id = (
  SELECT b.board_id
  FROM used_goods_board AS b
  ORDER BY b.views DESC
  LIMIT 1
)
ORDER BY f.file_id DESC;

SELECT CONCAT_WS('/', '/home/grep/src', F.BOARD_ID, CONCAT(F.FILE_ID, F.FILE_NAME, F.FILE_EXT)) AS FILE_PATH
FROM USED_GOODS_FILE F
WHERE F.BOARD_ID = (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)
ORDER BY F.FILE_ID DESC