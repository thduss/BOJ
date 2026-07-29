# 노선별로 총 누계거리, 역 사이 거리 조회
# 총 누계거리 = 역사이 거리의 총합
# 총 누계거리 소수 둘째자리, 평균 역 사이 거리 셋째자리 반올림 + km
# 총 누게거리 내림차순 정렬

SELECT ROUTE, CONCAT(ROUND(SUM(D_BETWEEN_DIST),1), 'km') AS TOTAL_DISTANCE, 
    CONCAT(ROUND(AVG(D_BETWEEN_DIST),2), 'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY SUM(D_BETWEEN_DIST) DESC