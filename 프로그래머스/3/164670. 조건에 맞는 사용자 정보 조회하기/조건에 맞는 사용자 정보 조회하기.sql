# 중고 거래 게시물 3건 이상
# 주소: 시, 도로명 주소, 상세 주소 함께
# 전화번호: xxx-xxxx-xxxx
# ID 내림차순

SELECT USER_ID, NICKNAME, CONCAT(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) AS '전체주소', CONCAT(SUBSTR(TLNO, 1, 3), "-", SUBSTR(TLNO, 4, 4), "-", SUBSTR(TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_USER
WHERE USER_ID IN (SELECT B.USER_ID
                 FROM USED_GOODS_BOARD A 
                 LEFT JOIN USED_GOODS_USER B ON B.USER_ID = A.WRITER_ID
                 GROUP BY B.USER_ID
                 HAVING COUNT(*)>=3)
ORDER BY USER_ID DESC;