# 2021년 가입 회원
# (상품 구매 회원수) / (2021년 가입 회원수) -> 년, 월 별로 출력
# 비율은 소수점 두 번째에서 반올림 round()
# 년 기준으로 오름차순, 월 기준으로 오름차순

SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, 
        COUNT(DISTINCT O.USER_ID) AS PURCHASED_USERS, 
        ROUND(COUNT(DISTINCT O.USER_ID)/(SELECT COUNT(*)
                                           FROM USER_INFO
                                          WHERE YEAR(JOINED)=2021), 1) 
                                          AS PUCHASED_RATIO
FROM ONLINE_SALE O
LEFT JOIN USER_INFO U ON O.USER_ID = U.USER_ID
WHERE YEAR(U.JOINED)=2021
GROUP BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE)
ORDER BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE);