-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회
SELECT emp_name, email, replace(email, 'kh.or.kr', 'gmail.com')
FROM employee;

-- 2. 사원명과 주민등록번호 (000000-0******)로 조회
SELECT emp_name, replace(emp_no, substr(emp_no, 9, 14), '******')
FROM employee;

-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회
SELECT emp_name, email, substr(email, 1, instr(email, '@')-1)
FROM employee;

-- 1. 직원명, 부서 코드가 있으면 ‘부서있음’, 없으면 ‘부서없음’으로 조회
SELECT emp_name, if(dept_code IS NOT NULL, '부서있음', '부서없음')
FROM employee;

-- 2. 사번, 사원명, 주민번호, 성별(남, 여) 조회
SELECT emp_id, emp_name, emp_no, IF(substr(emp_no, 8, 1)=1, '남', '여')
FROM employee;

/*
-- 사원명, 직급 코드(job_code), 기존 급여(salary), 인상된 급여 조회
-- 정렬 : 직급 코드 j1부터, 인상된 급여 높은 순서대로 
-- 직급 코드가 j7인 사원은 급여를 10% 인상
-- 직급 코드가 j6인 사원은 급여를 15% 인상
-- 직급 코드가 j5인 사원은 급여를 20% 인상
-- 그 외의 사원은 급여를 5%만 인상
*/
-- 3. 사원명, 직급코드(job_code), 기존 급여, 인상된 급여 조회
SELECT emp_name, job_code, salary, format(IF(job_code = 'j5', salary * 1.2, IF(job_code = 'j6', salary * 1.15, IF(job_code = 'j7', salary * 1.2, salary * 1.05))),0) as 인상된연봉
FROM employee
ORDER BY 2, 4 DESC
;
