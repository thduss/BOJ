# 사원별 성과금 정보를 조회
# 사번, 성명, 평가 등급, 성과금을 조회
# 평가등급: GRADE, 성과금: BONUS
# 사번 기준으로 오름차순 정렬

SELECT A.EMP_NO, B.EMP_NAME, CASE WHEN AVG(A.SCORE) >= 96 THEN 'S'
                                  WHEN AVG(A.SCORE) >= 90 THEN 'A'
                                  WHEN AVG(A.SCORE) >= 80 THEN 'B'
                                  ELSE 'C' END AS GRADE, 
                            CASE WHEN AVG(A.SCORE) >= 96 THEN B.SAL*0.2
                                 WHEN AVG(A.SCORE) >= 90 THEN B.SAL*0.15
                                 WHEN AVG(A.SCORE) >= 80 THEN B.SAL*0.10
                                 ELSE 0 END AS BONUS
FROM HR_GRADE A
LEFT JOIN HR_EMPLOYEES B ON A.EMP_NO = B.EMP_NO
GROUP BY A.EMP_NO, B.EMP_NAME
ORDER BY EMP_NO ASC;