# 헤비 유저 : 공간 >= 2 
# 헤비 유저가 등록한 공간의 정보
# 아이디 순으로 조회

SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID 
                  FROM PLACES
                 GROUP BY HOST_ID
                 HAVING COUNT(*)>=2)
ORDER BY ID;