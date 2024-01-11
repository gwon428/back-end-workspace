-- employee 테이블의 전체 사원의 모든 컬럼(*) 정보 조회
SELECT *
FROM employee;

-- employee 테이블의 전체 사원들의 사번(emp_id), 이름(emp_name), 급여(salary) 조회
SELECT emp_id, emp_name, salary
FROM employee;


-- 실습문제 ------------------------
-- 1. job 테이블의 모든 정보 조회
SELECT *
FROM job;

-- 2. job 테이블의 직급 이름(job_name) 조회
SELECT job_name
FROM job;

-- 3. department 테이블의 모든 정보 조회
SELECT *
FROM department;

-- 4. employee 테이블의 직원명(emp_name), 이메일(email), 전화번호(phone), 입사일(hire_date) 정보만 조회
SELECT emp_name, email, phone, hire_date
FROM employee;

-- 5. employee 테이블의 입사일(hire_date), 직원명(emp_name), 급여(salary) 조회
SELECT hire_date, emp_name, salary
FROM employee;


-- employee 테이블에서 직원명(emp_name), 직원 연봉 조회
SELECT emp_name, salary*12
FROM employee;

-- employee 테이블에서 직원명(emp_name), 직원 연봉(salary * 12) 조회
SELECT emp_name, salary*12 '연봉'
FROM employee;

-- employee 테이블에서 사번(emp_id), 직원명(emp_name), 급여(salary), 단위(원) 조회
SELECT emp_id, emp_name, salary, format((salary*12),0) '원'
FROM employee;

-- employee 테이블에 직급코드(job_code) 조회
SELECT job_code
FROM employee;

-- employee 테이블에 부서코드(dept_code) 조회
SELECT dept_code
FROM employee;


-- employee에서 부서코드(dept_code)가 'D9'인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE dept_code = "D9";


-- 실습문제 ------------------------
-- employee 테이블에서
-- 1. 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드만 조회
SELECT emp_name, salary, dept_code
FROM employee
WHERE dept_code = "D1";

-- 2. 부서코드가 'D1'이 아닌 사람들의 사번, 사원명, 부서코드 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE dept_code != "D1";

-- 3. 급여가 400만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE salary >= 4000000;

-- 4. 재직중 (ent_yn 컬럼값이 'N')인 사원들의 사번, 사원명, 입사일 조회
SELECT emp_id, emp_name, hire_date
FROM employee
WHERE ent_yn = 'N';

-- OR (또는), AND (그리고)
-- 부서코드가 'D6'이거나 급여가 300만원 이상인 사원들의 사원명, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE dept_code = 'D6' OR salary >= 3000000;

-- 급여를 350만원 이상 600만원 이하를 받는 사원들의 사원명, 사번, 급여 조회
SELECT emp_name, emp_id, salary
FROM employee
WHERE salary BETWEEN 3500000 AND 6000000;


-- 입사일이 '1990-01-01' ~ '2001-01-01' 사원들 중 성이 전씨인 사원들의 사원명, 급여, 입사일 조회
SELECT emp_name, salary, hire_date
FROM employee
WHERE hire_date BETWEEN '1990-01-01' AND '2001-01-01';

-- 이름 중 하 가 포함된 사원들의 사원명, 주민번호(emp_no), 전화번호(phone)조회
SELECT emp_name, emp_no, phone
FROM employee
WHERE emp_name LIKE '%하%';

-- 이름의 가운데 글자가 하 인 사원들의 사원명, 전화번호 조회 (이름이 3글자)
SELECT emp_name, phone
FROM employee
WHERE emp_name LIKE '_하_';

-- 전화번호의 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호, 이메일 조회
 SELECT emp_id, emp_name, phone, email
 FROM employee
 WHERE phone LIKE '__1%';

-- 이메일 중 _ 앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
-- ESCAPE OPTION : 나만의 와일드 카드를 만들어서 사용!
SELECT emp_id, emp_name, email
FROM employee
WHERE email LIKE '___#_%' ESCAPE '#';

-- 보너스를 받지 않는 사원(bonus 값이 null인 경우)
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE bonus IS NULL;

-- 부서 배치를 아직 받지 않고 보너스는 받은 경우 이름, 보너스, 부서코드 조회
SELECT emp_name, bonus, dept_code
FROM employee
WHERE dept_code IS NULL AND bonus IS NOT NULL;

-- 부서코드가 D6, D5, D8인 부서원들의 이름, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE dept_code IN ('D6', 'D5', 'D8');

-- 실습문제 ----------------------------
-- 1. 직급코드가 J7이거나 J2인 사원들 중 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE job_code IN ('J7', 'J2') AND salary >= 2000000;

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사수사번, 부서코드 조회
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE manager_id IS NULL AND dept_code IS NULL;

-- 3. 연봉(보너스 포함 X)이 3000만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE salary*12 >= 30000000 AND bonus IS NULL;

-- 4. 입사일이 '1995-01-01' 이상이고 부서배치를 받은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT emp_id, emp_name, hire_date, dept_code
FROM employee
WHERE hire_date >= '1995-01-01';

-- 5. 급여가 200만원 이상 500만원 이하이고 입사일이 '2001-01-01' 이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000 AND hire_date >= '2001-01-01' ANd bonus IS NULL;

-- 6. 보너스 포함 연봉이 NULL이 아니고 이름에 '하'가 포함되어 있는 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회(별칭)
-- 보너스 포함 연봉 : (SALARY + SALARY * BONUS) * 12
SELECT emp_id, emp_name, salary, (salary+salary*bonus)*12
FROM employee
WHERe emp_name LIKE '%하%';

-- 전체 사원의 사원명, 보너스 조회
SELECT emp_name, bonus
FROM employee;

-- 연봉이 높은 5명의 사원의 사원명, 급여 조회
SELECT emp_name, format(salary, 0)
FROM employee
ORDER BY 2 DESC
LIMIT 5;




















