# 2022-10-05 등록된 게시글 조회
# SALE: 판매중, RESERVED: 예약중, DONE: 거래완료
# 게시글 ID 내림차순

SELECT A.BOARD_ID, A.WRITER_ID, A.TITLE, A.PRICE, CASE WHEN A.STATUS = 'SALE' THEN '판매중'
                                               WHEN A.STATUS = 'RESERVED' THEN '예약중'
                                               ELSE '거래완료' END AS 'SATAUS'
FROM USED_GOODS_BOARD A
WHERE YEAR(CREATED_DATE) = 2022 AND MONTH(CREATED_DATE) = 10 AND DAY(CREATED_DATE)=5
ORDER BY BOARD_ID DESC;