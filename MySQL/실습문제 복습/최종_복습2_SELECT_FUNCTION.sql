-- 사원명, 사원명의 글자수, 이메일, 이메일의 글자수 조회
SELECT emp_name, char_length(emp_name), email, char_length(email)
FROM employee;

-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회
SELECT email, instr(email, '@')
FROM employee
WHERE email LIKE '%s%';

-- 여자 사원들만 조회
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, 8, 1) = 2;

-- 남자 사원들만 조회
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, 8, 1) = 1;


-- 실습문제 -----------------------------------------
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회
SELECT emp_name, email, REPLACE(email, 'kh.or.kr', 'gmail.com') 
FROM employee;

-- 2. 사원명과 주민등록번호(000000-0******)로 조회
-- replace, concat, rpad, substr

-- 2-1. replace
SELECT emp_name, replace(emp_no, substr(emp_no, 9, 14), '******')
FROM employee;

-- 2-2. rpad
SELECT emp_name, rpad(substr(emp_no, 1, 8), 14, '*')
FROM employee;

-- 2-3. concat
SELECT emp_name, concat(substr(emp_no, 1, 8), '******')
FROM employee;

-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회
-- replace, trim, substr
SELECT emp_name, email, replace(email, '@kh.or.kr', ' ')
FROM employee;

SELECT emp_name, email, trim(trailing '@kh.or.kr' FROM email)
FROM employee;

SELECT emp_name, email, substr(email, 1, instr(email, '@')-1)
FROM employee;

-- 직원명, 입사일, 근무일수, 근무 개월 수, 근무 년 수 조회
SELECT emp_name, hire_date,
 datediff(now(), hire_date),
 timestampdiff(month, hire_date, now()),
 timestampdiff(year, hire_date, now())
FROM employee;


-- 직원명, 입사일, 입사 후 6개월이 된 날짜를 조회
SELECT emp_name, hire_date, ADDDATE(hire_date, INTERVAL 6 month)
FROM employee;

-- 연도별 오래된 순으로 직원명, 입사연도, 입사월, 입사일 조회
SELECT emp_name, YEAR(hire_date), MONTH(hire_date), hire_date
FROM employee
ORDER BY 4;

-- 직원명, 입사일 (2023년 12월 26일) 조회
SELECT emp_name, DATE_FORMAT(hire_date, '%Y년 %m월 %d일')
FROM employee;



-- 전 사원의 직원명, 보너스, 보너스 포함 연봉 (급여 + 급여 * 보너스) * 12 조회
SELECT emp_name, bonus, (salary + salary*bonus) * 12
FROM employee;

-- 직원명, 부서 코드 조회 (부서 코드가 없으면 '부서없음')
SELECT emp_name, ifnull(dept_code, '부서없음')
FROM employee;


-- 직원명, 부서 코드가 있으면 '부서있음', 없으면 '부서없음'으로 조회
SELECT emp_name, if(dept_code IS NOT NULL, '부서있음', '부서없음')
FROM employee;

-- 사번, 사원명, 주민번호, 성별(남, 여) 조회
SELECT emp_id, emp_name, emp_no, if(substr(emp_no, 8, 1) =1, '남', '여') 성별
FROM employee;

-- 사원명, 직급 코드(job_code), 기존 급여(salary), 인상된 급여 조회
-- 정렬 : 직급 코드 j1부터, 인상된 급여 높은 순서대로 
-- 직급 코드가 j7인 사원은 급여를 10% 인상
-- 직급 코드가 j6인 사원은 급여를 15% 인상
-- 직급 코드가 j5인 사원은 급여를 20% 인상
-- 그 외의 사원은 급여를 5%만 인상

SELECT emp_name, job_code, salary,
format(	CASE WHEN job_code = 'j7' THEN salary * 1.1
		WHEN job_code = 'j6' THEN salary * 1.15
        WHEN job_code = 'j5' THEN salary * 1.2
        ELSE salary * 1.05
	END , 0)'인상된 급여'
FROM employee
ORDER BY 2;

-- 사원명, 급여, 급여 등급(1~4등급) 조회
-- SALARY 값이 500만원 초과일 경우 1등급
-- SALARY 값이 500만원 이하 350만원 초과일 경우 2등급
-- SALARY 값이 350만원 이하 200만원 초과일 경우 3등급
-- 그 외의 경우 4등급

SELECT emp_name, salary,
	CASE WHEN salary > 5000000 THEN '1등급'
		WHEN salary > 3500000 THEN '2등급'
        WHEN salary > 2000000 THEN '3등급'
        ELSE '4등급'
	END '급여 등급'
FROM employee;

-- 전체 사원의 총 급여 합 조회
SELECT sum(salary)
FROM employee;

-- 부서코드가 D5인 사원들의 총 연봉(급여 * 12) 합 조회
SELECT sum(salary)
FROM employee
WHERE dept_code = 'D5';


 -- 전체 사원의 평균 급여 조회
SELECT avg(salary)
FROM employee;


-- 가장 작은 값에 해당하는 사원명, 급여, 입사일
-- 가장 큰 값에 해당하는 사원명, 급여, 입사일 조회
SELECt min(emp_name), min(salary), min(hire_date),
	max(emp_name), max(salary), max(hire_date)
FROM employee;

-- 전체 사원 수 조회
SELECT COUNT(*)
FROM employee;


-- 보너스를 받은 사원 수 조회
SELECT COUNT(*)
FROM employee
WHERE bonus IS NOT NULL;


-- 부서가 배치된 사원 수 조회
SELECT COUNT(*)
FROM employee
WHERE dept_code IS NOT NULL;


-- 현재 사원들이 속해있는 부서 수 조회
SELECT COUNT(distinct dept_code)
FROM employee;


-- 현재 사원들이 분포되어 있는 직급 수 조회
SELECT COUNT(distinct job_code)
FROM employee;


-- 퇴사한 직원의 수 조회 (ent_date | ent_yn이 y인 경우)
SELECT count(*)
FROM employee
WHERE ent_yn = 'y';














