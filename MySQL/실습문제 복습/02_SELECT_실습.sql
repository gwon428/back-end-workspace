-- 1. job 테이블의 모든 정보 조회
SELECT *
FROM job;

-- 2. job 테이블의 직급 이름(job_name) 조회
SELECT job_name
FROM job;

-- 3. department 테이블의 모든 정보 조회
SELECT *
FROM department;

-- 4. employee 테이블의 직원명, 이메일, 전화번호(phone), 입사일 정보 조회
SELECT emp_name, email, phone, hire_date
FROM employee;

-- 5. employee 테이블의 입사일, 직원명 급여 조회
SELECT hire_date, emp_name
FROM employee;


-- 1. 부서코드가 ‘D1’인 사원들의 사원명, 급여, 부서코드만 조회
SELECT emp_name, salary, dept_code
FROM employee
WHERE dept_code = 'D1';

-- 2. 부서코드가 ‘D1’이 아닌 사람들의 사번, 사원명, 부서코드 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE dept_code != 'D1';

-- 3. 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE salary >= 4000000;

-- 4. 재직중 (ent_yn 컬럼값이 ‘N’)인 사원들의 사번, 사원명, 입사일 조회
SELECT emp_id, emp_name, hire_date
FROM employee
WHERE ent_yn = 'N';


-- 1. 직급코드(job_code) J7이거나 J2인 사원들 중 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE (job_code = 'J7' OR job_code = 'J2') AND salary >= 2000000;

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사수사번, 부서코드 조회
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE manager_id IS NULL AND dept_code IS NULL;

-- 3. 연봉(보너스 포함X)이 3000만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE salary*12 >= 30000000 AND bonus IS NULL;

-- 4. 입사일이 ‘1995-01-01’ 이상이고 부서배치를 받은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT emp_id, emp_name, hire_date, dept_code
FROM employee
WHERE hire_date >= '1995-01-01' AND dept_code IS NOT NULL;

-- 5. 급여가 200만원 이상 500만원 이하이고 입사일이 ‘2001-01-01’ 이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000 
AND hire_date >= '2001-01-01'
AND bonus IS NULL;

-- 6. 보너스 포함 연봉((SALARY + SALARY*BONUS)*12)이 NULL이 아니고 이름이 ‘하’가 포함되어 있는 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회
SELECT emp_id, emp_name, salary, (salary + (salary*bonus))*12 보너스포함연봉
FROM employee
WHERE (salary + (salary*bonus))*12 IS NOT NULL AND emp_name LIKE'%하%';
