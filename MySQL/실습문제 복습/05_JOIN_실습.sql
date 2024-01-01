-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회 (employee, department)
SELECT emp_id, emp_name, bonus
FROM employee JOIN department ON (dept_code = dept_id)
WHERE dept_title = '인사관리부';

SELECT emp_id, emp_name, bonus
FROM employee, department
WHERE dept_code = dept_id
	AND dept_title = '인사관리부';

-- 2. 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회 (department, location)
SELECT dept_id, dept_title, local_code, local_name
FROM department JOIN location ON (location_id = local_code);

SELECT dept_id, dept_title, local_code, local_name
FROM department, location
WHERE location_id = local_code;

-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회 (employee, department)
SELECT emp_id, emp_name, bonus, dept_title
FROM employee JOIN department ON (dept_code = dept_id)
WHERE bonus IS NOT NULL;

SELECT emp_id, emp_name, bonus, dept_title
FROM employee, department
WHERE dept_code = dept_id
	AND bonus IS NOT NULL;

-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회 (employee, department)
SELECT emp_name, salary
FROM employee JOIN department ON (dept_code = dept_id)
WHERE dept_title != '총무부';

SELECT emp_name, salary
FROM employee, department
WHERE dept_code = dept_id
	AND dept_title != '총무부';


-- 종합 실습 문제 ---------------------------------------------------
-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의 사번, 직원명, 직급명, 부서명, 근무지역, 급여를 조회
SELECT emp_id, emp_name, job_name, dept_title, local_code, salary
FROM employee
	JOIN job USING (job_code)
    JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
WHERE job_name = "대리"
	AND local_name LIKE 'ASIA%';

-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 직원명, 주민번호, 부서명, 직급명 조회
SELECT emp_name, emp_no, dept_title, job_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN job USING (job_code)
WHERE substr(emp_no, 1, 6) BETWEEN '700101' AND '791231'
	AND substr(emp_no, 8, 1) = 2
    AND emp_name LIKE '전%';

-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역 조회 (단, 부서 코드가 없는 사원도 출력될 수 있게! OUTER JOIN 사용!)
SELECT emp_name, bonus, bonus*12 연봉, dept_title, local_code
FROM employee
	LEFT JOIN department ON (dept_code = dept_id)
    LEFT JOIN location ON (location_id = local_code)
WHERE bonus IS NOT NULL;

-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역, 근무 국가를 조회
SELECT emp_name, dept_title, national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
    JOIN national USING (national_code)
WHERE national_name IN ('한국', '일본');

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여(format 사용)를 조회 (단, 부서 코드가 없는 사원들의 평균도 같이 나오게끔! OUTER JOIN 필요)
SELECT dept_title, format(avg(salary), 0)
FROM employee
	LEFT JOIN department ON (dept_code = dept_id)
GROUP BY dept_title;

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회
SELECT dept_title, sum(salary)
FROM employee
	JOIN department ON (dept_code = dept_id)
GROUP BY dept_title
HAVING sum(salary) >= 10000000;


-- 7. 사번, 직원명, 직급명, 급여 등급, 구분을 조회
--    이때 구분에 해당하는 값은 아래와 같이 조회 되도록!
--    급여 등급이 S1, S2인 경우 '고급'
--    급여 등급이 S3, S4인 경우 '중급'
--    급여 등급이 S5, S6인 경우 '초급'
SELECT emp_id, emp_name, job_name, sal_level,
	CASE WHEN sal_level IN ('S1', 'S2') THEN '고급'
		WHEN sal_level IN ('S3', 'S4') THEN '중급'
        ELSE '초급'
	END 구분
FROM employee e, department, job j, sal_grade
WHERE e.job_code = j.job_code
    AND salary BETWEEN min_sal AND max_sal;

-- 8. 보너스를 받지 않은 직원들 중 직급 코드가 J4 또는 J7인 직원들의 직원명, 직급명, 급여를 조회
SELECT emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE bonus IS NULL
	AND job_code = 'J4' OR job_code = 'J7';

-- 9. 부서가 있는 직원들의 직원명, 직급명, 부서명, 근무 지역을 조회
SELECT emp_name, job_name, dept_title, local_code, local_name
FROM employee
	JOIN job USING (job_code)
    JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
WHERE dept_code IS NOT NULL;

-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명을 조회
SELECT emp_name, job_name, dept_code, dept_title
FROM employee
	JOIN job USING (job_code)
    JOIN department ON (dept_code = dept_id)
WHERE dept_title LIKE '해외영업%';

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 직원명, 직급명을 조회
SELECT emp_id, emp_name, job_name
FROM employee
	JOIN job USING (job_code)
WHERE emp_name LIKE '%형%';









