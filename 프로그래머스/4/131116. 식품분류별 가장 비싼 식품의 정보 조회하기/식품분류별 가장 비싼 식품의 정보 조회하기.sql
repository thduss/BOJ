# CATEGORY별로 제일 비싼 식품
# 과자, 국, 김치, 식용유만
# 가격 내림차순 정렬

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT A
WHERE CATEGORY IN ('과자', '국', '김치', '식용유') AND 
      (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE)
                            FROM FOOD_PRODUCT B
                            WHERE A.CATEGORY = B.CATEGORY)
ORDER BY MAX_PRICE DESC;