-- 각 부서별 조회
SELECT count(*) 사원수, format(sum(salary), 0) 부서총급여, format(avg(ifnull(salary,0)), 0) 평균급여,
		min(salary) 최저급여, max(salary) 최고급여
FROM employee
GROUP BY dept_code;

-- 직급 코드별 사원 수 조회
SELECT job_code, count(job_code)
FROM employee
group by job_code;

-- 성별 별(남자/여자) 사원 수
SELECT IF(substr(emp_no, 8, 1) = 1, '남', '여') 성별, count(*)
FROM employee
GROUP BY 성별;

-- 부서별 평균 급여가 300만원 이상인 부서의 평균 급여 조회
SELECT dept_code, avg(salary)
FROM employee
GROUP BY dept_code
HAVING avg(salary) >= 3000000;

-- 직급별 총 급여의 합이 1000만원 이상인 직급만 조회
SELECT job_code
FROM employee
gROUP BY job_code
HAVING sum(salary) >= 10000000;


-- 부서별 보너스를 받는 사원이 없는 부서만 조회
SELECT dept_code, count(bonus)
FROM employee
GROUP BY dept_code
HAVING count(bonus) = 0;


-- 보너스를 받는 사원이 있는 부서들만 조회
SELECT dept_code, count(*)
FROM employee
WHERE bonus IS NOT NULL
GROUP BY dept_code;




