SELECT A.EMP_NO, A.EMP_NAME, CASE WHEN AVG(SCORE)>=96 THEN 'S'
                                  WHEN AVG(SCORE)>=90 THEN 'A'
                                  WHEN AVG(SCORE)>=80 THEN 'B'
                                  ELSE 'C' END AS GRADE,
                             CASE WHEN AVG(SCORE)>=96 THEN 0.2*A.SAL
                                  WHEN AVG(SCORE)>=90 THEN 0.15*A.SAL
                                  WHEN AVG(SCORE)>=80 THEN 0.1*A.SAL
                                  ELSE 0 END AS BONUS
FROM HR_EMPLOYEES A
LEFT JOIN HR_DEPARTMENT B ON A.DEPT_ID=B.DEPT_ID
JOIN HR_GRADE C ON A.EMP_NO=C.EMP_NO
GROUP BY A.EMP_NO, A.EMP_NAME
ORDER BY EMP_NO;