/* 데이터, 관계형 데이터베이스, SQL, DML, DQL
- 데이터(data) : 필요에 의해 수집했지만, 아직 특정 목적을 위해 '정제하지 않은' 값
	vs 정보(info) : 수집한 데이터를 어떠한 목적을 위해 '분석'하거나 '가공'하여 '새로운 의미' 부여
- 데이터베이스 : 데이터(data) + 베이스(base)
// SELECT : 데이터 가공할 때 (가지고 올 때!) //
- DBMS(DataBase Management System) : 데이터베이스 관리 시스템 [ex.MySQL, Oracle 등]

- 관계형(Relational) 데이터베이스
	1. 가장 대표적인 데이터베이스 시스템
    2. 데이터를 테이블 형태로 저장하고 여러 테이블을 조합하여 비즈니스 관계(로직)를 도출하는 구조
		//front-end와 DB를 연결하는 logic.//
    3. 데이터의 중복을 최소화할 수 있으며 사용하기 편리하고 데이터의 무결성, 트랜잭션 처리 등 데이터베이스 관리 시스템으로 뛰어난 성능을 보여준다.
    
- SQL(Structured Query Language)
	: 관계형 데이터베이스에서 데이터를 조회하거나 조작하기 위해 사용하는 표준 검색 언어 (CRUD)
    
- SQL 종류
	1. DML (Data Manipulation Language) : 데이터 조작어
		- 실제 데이터를 조작하기 위해 사용하는 언어
			(INSERT: 추가, UPDATE: 수정, DELETE: 삭제, (SELECT))
	2. DQL (Data Query Language) : 데이터 질의어
		- 데이터를 조회(검색)하기 위해 사용하는 언어 (SELECT: 조회)
	3. DCL (Data Control Language) : 데이터 제어어
		- DBMS에 대한 보안, 무결성, 복구 등 DBMS를 제어하기 위한 언어
			(GRANT : 권한 부여, REVOKE : 권한 회수)
	4. DDL (Data Definition Language) : 데이터 정의어
		- DBMS의 구조를 정의하거나 변경, 삭제하기 위해 사용하는 언어
			(CREATE : 생성, ALTER : 수정, DROP : 삭제)	- 테이블 변경과 관련
*/

/* SELECT
	SELECT 컬럼, 컬럼, ....
    FROM 테이블명;
    
    - 테이블에서 데이터를 조회할 때 사용하는 SQL문
    - SELECT를 통해서 조회된 결과를 RESULT SET이라고 한다. (즉, 조회된 행들의 집합)
    - 조회하고자 하는 컬럼들은 반드시 'FROM 절에 기술한 테이블'에 존재(하거나 연관있)는 컬럼이어야 한다.
    - '모든 컬럼'을 조회할 경우 컬럼명 대신 * 기호 사용
*/

-- employee 테이블의 전체 사원의 모든 컬럼(*) 정보 조회 query문
SELECT *  /*모든 컬럼 조회를 위해 '*' 기호 사용*/
FROM employee;

-- employee 테이블의 전체 사원들의 사번(emp_id), 이름(emp_name), 급여(salary) 조회
SELECT emp_id, emp_name, salary
FROM employee;

-- 관례상 대문자로 작성 (소문자로 작성해도 적용은 됨)
select emp_id, emp_name, salary
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

/* 컬럼 산술 연산
	컬럼 산술 연산
    - SELECT 절에 컬럼명 입력 부분에 산술연산자를 사용하여 결과를 조회할 수 있다.
*/

-- employee 테이블에서 직원명(emp_name), 직원 연봉 조회
SELECT emp_name, salary * 12, salary
FROM employee;

/* 컬럼 별칭 부여
	컬럼 별칭
    컬럼 as 별칭 / 컬럼 as "별칭" / 컬럼 별칭 / 컬럼 "별칭"
    
    - 산술연산을 하면 컬럼명이 지저분해진다.
      이때 컬럼명에 별칭을 부여해서 깔끔하게 보여줄 수 있다.
	- 별칭을 부여할 때 '띄어쓰기' 혹은 '특수문자가 포함'될 경우 반드시 큰따옴표("")로 감싸줘야 한다.
*/
-- employee 테이블에서 직원명(emp_name), 직원 연봉(salary * 12) 조회
SELECT emp_name 직원명, salary*12 as"연봉"
FROM employee;

/* 리터럴
	리터럴
    - SELECT 절에 리터절을 사용하면 테이블에 존재하는 데이터처럼 조회가 가능
*/
-- employee 테이블에서 사번(emp_id), 직원명(emp_name), 급여(salary), 단위(원) 조회
SELECT emp_id 사번, emp_name 직원명, salary 급여, '원' as "단위(원)"
FROM employee;

/* DISTINCT (중복된 값 제거)
	DISTINCT
    - 컬럼의 중복된 값들을 한번씩만 표시하고자 할 때 사용
*/
-- employee 테이블에 직급코드(job_code) 조회
SELECT DISTINCT job_code 
FROM employee;

-- employee 테이블에 부서코드(dept_code) 조회
SELECT DISTINCT dept_code
FROM employee;

-- 유의사항! DISTINCT는 SELECT절에 딱 한 번만 기술 가능
SELECT DISTINCT job_code, dept_code /*두번째 컬럼명이 다르면 첫번째 컬럼도 같아도 출력되기도*/
FROM employee;

/* WHERE절

	SELECT 컬럼, 컬럼, ...
	FROM 테이블명
	WHERE 조건식;
    
    - 조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만 조회하고자 할 때 사용
    - 이때 WHERE절에 조건식을 제시
    - 조건식에는 다양한 연산자를 사용 가능!
    
    비교 연산자
    >, <, >=, <= : 대소 비교
    = 			: 같은지 비교
    !=, ^=, <> : 같지 않은지 비교
    
    OR AND
    
*/
-- employee에서 부서코드(dept_code)가 'D9'인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE dept_code = 'D9';


-- 실습문제 ------------------------
-- employee 테이블에서
-- 1. 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드만 조회
SELECT emp_name, salary, dept_code
FROM employee
WHERE dept_code = 'D1';

-- 2. 부서코드가 'D1'이 아닌 사람들의 사번, 사원명, 부서코드 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE dept_code <> 'D1';

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
WHERE salary >= 3500000 AND salary <= 6000000;

/* BETWEEN AND
	- 조건식에서 사용되는 구문
    - n 이상 m 이하인 범위에 대한 조건을 제시할 때 사용되는 연산자
    - 비교대상컬럼 BETWEEN 하한값 AND 상한값
*/
-- 급여를 350만원 이상 600만원 이하를 받는 사원들의 사원명, 사번, 급여 조회
SELECT emp_name, emp_id, salary
FROM employee
WHERE salary BETWEEN 3500000 AND 6000000;

-- 입사일이 '1990-01-01' ~ '2001-01-01'
SELECT *
FROM employee
WHERE hire_date BETWEEN '1990-01-01' AND '2001-01-01';

/* LIKE
	- 비교하고자 하는 컬럼값이 내가 제시한 특정 패턴에 만족될 경우 조회
    
    비교대상컬럼 LIKE '특정 패턴'
    - 특정패턴에는 '%', '_'를 와일드카드로 사용
    
    '%' : 0글자 이상
    비교대상 LIKE '문자%' => 비교대상컬럼값이 문자로 시작되는 것을 조회
    비교대상 LIKE '%문자' => 비교대상컬럼값이 문자로 끝나는 것을 조회
    비교대상 LIKE '%문자%' => 비교대상컬럼값이 문자를 포함하는 것을 조회 [키워드 검색]
    '_' : 1글자
    비교대상 LIKE '_문자' => 비교대상컬럼 값 문자 앞에 무조건 한 글자가 올 경우
    비교대상 LIKE '__문자' => 비교대상컬럼 값 문자 앞에 무조건 두 글자가 올 경우
    비교대상 LIKE '_문자_' => 비교대상컬럼 값 문자 앞과 뒤에 무조건 한 글자씩 올 경우
    
    //비교대상 LIKE '문자_' => 비교대상컬럼값이 문자로 시작되는 2글자 문자 조회
    비교대상 LIKE '[^문자]' => 첫글자가 '문자'가 아닌 것을 조회//
*/
-- 사원들 중 성이 전씨인 사원들의 사원명, 급여, 입사일 조회
SELECT emp_name, salary, hire_date
FROM employee
WHERE emp_name LIKE '전%';

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
WHERE email LIKE '___#_%' ESCAPE'#';

-- 위의 사원들 이외의 사원들을 조회
-- 논리부정연산자 : NOT (NOT의 위치는 WHERE NOT/ NOT LIKE) => 비교대상컬럼 앞/비교대상컬럼 뒤
SELECT emp_id, emp_name, email
FROM employee
WHERE email NOT LIKE '___#_%' ESCAPE '#';

/*	IS NULL / IS NOT NULL
	- 컬럼값이 NULL이 있을 경우 NULL 값 비교에 사용되는 연산자
*/
-- 보너스를 받지 않는 사원(bonus 값이 null인 경우)
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE bonus IS NULL;

-- 부서 배치를 아직 받지 않고 보너스는 받은 경우 이름, 보너스, 부서코드 조회
SELECT emp_name, bonus, dept_code
FROM employee
WHERE bonus IS NOT NULL AND dept_code IS NULL;

/* IN
	- 비교대상컬럼값이 내가 제시한 목록 중에 일치하는 값이 있는지
    비교대상컬럼 IN ('값1', '값2', ...)
*/
-- 부서코드가 D6, D5, D8인 부서원들의 이름, 부서코드, 급여 조회
SELECT emp_name, dept_code, salary
FROM employee
WHERE dept_code IN ('D6', 'D5', 'D8');

-- 실습문제 ----------------------------
-- 1. 직급코드가 J7이거나 J2인 사원들 중 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM employee
WHERE job_code IN ('J7','J2')
AND salary >= 2000000;

-- 연산자 우선순위 : AND가 OR보다 우선수위가 높음 (주의!!)
SELECT *
FROM employee
WHERE job_code = 'J7'
OR job_code = 'J2' AND salary >= 2000000;

/* 연산자 우선순위
	0. ()
	1. 산술연산자 : *, /, DIV, %, MOD, +, -
    2. 비교연산자 : =, <, <=, >, >=, <>, !=, ^=
    3. IS NULL / LIKE / IN
    4. BETWEEN AND
    5. NOT
    6. AND
    7. OR
*/

-- 2. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사수사번, 부서코드 조회
SELECT emp_name, manager_id, dept_code
FROM employee
WHERE manager_id IS NULL
AND dept_code IS NULL;

-- 3. 연봉(보너스 포함 X)이 3000만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT emp_id, emp_name, salary, bonus
FROM employee
WHERE salary*12 >= 30000000
AND bonus IS NULL;

-- 4. 입사일이 '1995-01-01' 이상이고 부서배치를 받은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT emp_id, emp_name, hire_date, dept_code
FROM employee
WHERE hire_date >= '1995-01-01'
AND dept_code IS NOT NULL;

-- 5. 급여가 200만원 이상 500만원 이하이고 입사일이 '2001-01-01' 이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT emp_id, emp_name, salary, hire_date, bonus
FROM employee
WHERE salary BETWEEN 2000000 AND 5000000
AND hire_date >= '2001-01-01'
AND bonus IS NULL;

-- 6. 보너스 포함 연봉이 NULL이 아니고 이름에 '하'가 포함되어 있는 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회(별칭)
-- 보너스 포함 연봉 : (SALARY + SALARY * BONUS) * 12
SELECT emp_id, emp_name, salary, (SALARY + SALARY*BONUS)*12 as 연봉
FROM employee
WHERE emp_name LIKE '%하%'                                                                                            
AND (SALARY + SALARY*BONUS)*12 IS NOT NULL;

/* ORDER BY
	- SELECT문 가장 마지막 줄에 작성 뿐만 아니라 실행 순서 또한 마지막에 실행
    
    3. SELECT 컬럼, 컬럼, ...
    1. FROM 테이블명
    2. WHERE 조건식
    4. ORDER BY 정렬하고자 하는 컬럼값 [ASC|DESC];
	
    - ASC 오름차순 정렬 (생략 시 기본값)
    - DESC 내림차순 정렬
*/
-- 전체 사원의 사원명, 보너스 조회
SELECT emp_name, bonus
FROM employee
WHERE bonus IS NOT NULL
-- ORDER BY bonus;	-- 보너스 기준 오름차순 정렬 (NULL이 맨앞)
ORDER BY bonus DESC; -- 보너스 기준 내림차순 정렬 (NULL이 맨뒤)
-- ORDER BY 2 DESC; -- 보너스 기준 내림차순 정렬 (숫자는 SELECT 컬럼값에 준 인덱스값)

/* LIMIT
	- ORDER BY 절보다 뒤에 조건을 걸고 싶을 때 사용
    - 출력되는 행 수를 제한하는 MySQL 전용 비표준 구문
    - 데이터 양을 제한하고자 할 때 유용
*/
-- 연봉이 높은 5명의 사원의 사원명, 급여 조회
SELECT emp_name, salary
FROM employee
ORDER BY 2 DESC
LIMIT 5;

-- 페이징 처리를 위함 LIMIT.
-- LIMIT 절은 두 개의 값이 있을 수 있음
-- 첫번째 값은 오프셋(offset, 0부터 시작) => 시작 행을 지정,
-- 두번째 값은 반환할 최대 행 수를 지정

SELECT emp_name, salary
FROM employee
ORDER BY 2 DESC
LIMIT 5, 5;  -- = (LIMIT 10 OFFSET 5;)

















