/*	DML (Data Manipulation Language)
	- 데이터 조작 언어로 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE)하거나, 삭제(DELETE)하는 구문
    
    1. INSERT
	- 테이블에 새로운 행을 추가하는 구문
    
    1) INSERT INTO 테이블명 VALUES (값, 값, ...);
		- 테이블에 '모든 컬럼'에 대한 값을 INSERT 하고자 할 때 사용
        - 컬럼 순번을 지켜서 VALUES에 값을 나열해야 함.
        
    2) INSERT INTO 테이블명 (컬럼명, 컬럼명, ...) VALUES (값, 값, ...);
		- 테이블의 특정 컬럼에 대한 값만 INSERT 하고자 할 때 사용
        - 선택이 안된 컬럼들은 기본적으로 NULL 값이 들어감.
			(NOT NULL 조건이 걸려 있는 컬럼은 반드시 값을 입력해야 한다.)
		- 기본값(DEFAULT)이 지정되어 있으면 NULL이 아닌 기본값이 들어간다.
        
    3) INSERT INTO 테이블명 서브쿼리;
		- VALUES 대신 서브쿼리를 조회한 결과값이 통째로 INSERT.
        - 서브쿼리 결과값이 INSERT 문에 지정된 테이블 컬럼 개수와 같아야 한다.
*/
-- 사용할 테이블 생성
DROP TABLE emp;
CREATE TABLE emp(
	emp_id INT PRIMARY KEY,
    emp_name VARCHAR(30) NOT NULL,
    dept_title VARCHAR(30) DEFAULT '개발팀',
    hire_date DATE DEFAULT(current_date)
);
-- 1)
INSERT INTO emp VALUES(100, '강지원', '서비스 개발팀', default);

	-- 모든 컬럼 값을 지정하지 않아서 에러 발생! Error Code: 1136. Column count doesn't match value count at row 1
INSERT INTO emp VALUES(200, '유지혁', '개발 지원팀');

	-- 에러는 발생하지 않지만 데이터가 잘못 저장됨
INSERT INTO emp VALUES(300, '유아지원팀', '박민환', default);

	-- datatype이 맞지 않아서 에러 발생!
INSERT INTO emp VALUES('유아지원팀', 400, '정수민', default);


-- 2)
INSERT INTO emp(emp_id, emp_name, dept_title, hire_date) VALUES (400, '백은호', '인사팀', null);

	-- 컬럼을 순서대로 넣을 필요는 없지만, 삽입 쿼리문 내의 순서는 맞춰야 함.
INSERT INTO emp(emp_name, dept_title, emp_id) VALUES ('양주란', '보안팀', 500);
DELETE FROM emp
WHERE emp_id = 500;
	-- 기본값이 부여된 컬럼을 제외하고 입력해도 정상적으로 데이터 삽입 가능 
INSERT INTO emp(emp_id, emp_name) VALUES (600, '유희연');

	-- emp_name 컬럼에 not null 제약 조건으로 인해 에러 발생
INSERT INTO emp(emp_id, dept_title) VALUES (700, '마켓팅팀');


-- 3)
-- kh.employee 테이블에서 사번, 이름, 부서명, 입사일을 그대로 가져오기
SELECT * FROM emp;
INSERT INTO emp
SELECT emp_id, emp_name, dept_title, hire_date
FROM kh.employee
	LEFT JOIN kh.department ON (dept_code = dept_id);

INSERT INTO emp
SELECT emp_name, emp_id, dept_title, hire_date
FROM kh.employee
	LEFT JOIN kh.department ON (dept_code = dept_id);
-- Error Code: 1366. Incorrect integer value:


	-- 컬럼명을 명시하면 순서가 상관이 없음.
INSERT INTO emp(emp_name, emp_id, dept_title, hire_date)
SELECT emp_name, emp_id, dept_title, hire_date
FROM kh.employee
	LEFT JOIN kh.department ON (dept_code = dept_id);


INSERT INTO emp
SELECT emp_id, emp_name, dept_title, hire_date
FROM kh.employee
LEFT JOIN kh.department ON (dept_code = dept_id);

ALTER TABLE emp
ADD dept_code CHAR(2);

INSERT INTO emp
SELECT emp_id, emp_name, dept_title, hire_date, dept_code
FROM kh.employee
LEFT JOIN kh.department ON (dept_code = dept_id);

DELETE FROM emp;    -- 뒤에 조건이 없으면 데이터를 모두 삭제할 수 있음.
SELECT * FROM emp;

-- 테이블 구조만 복사!
CREATE TABLE emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE 1=0;

CREATE TABLE emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE 1=0;

SELECT * FROM emp_dept;
SELECT * FROM emp_manager;

-- emp_dept 테이블에 employee에서 부서 코드가 D1인 직원의 사번, 이름, 부서코드, 입사일 추가하고
-- emp_manager 테이블에 부서 코드가 D1인 직원의 사번, 이름, 관리자 사번을 추가

INSERT INTO emp_dept 
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE dept_code = 'D1';

INSERT INTO emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE dept_code = 'D1';

/* Oracle에서만 가능! ㅠㅠ 
INSERT ALL
INTO emp_dept SELECT emp_id, emp_name, dept_code, hire_date
INTO emp_manager SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE dept_code = 'D1';
*/

/*	2. UPDATE
	- 테이블에 기록된 데이터를 수정하는 구문
    
    UPDATE 테이블명 
    SET 컬럼명 = 변경하려는값,
		컬럼명 = 변경하려는값,
		...
	WHERE 조건
    
    - SET 절에서 여러 개의 컬럼을 콤마(,)로 나열해서 값을 동시에 변경할 수 있다.
    - WHERE 절을 생략하면 모든 행의 데이터가 변경된다. (MySQL 방지)
    - 사실 서브쿼리 사용 가능! 잘 쓰이지도 않고 버전마다 또 상황이 다름
*/
SELECT * FROM dept_copy;
SELECT * FROM emp_salary;

START transaction;

-- emp_salary에서 선동일 사장의 급여를 7000000원으로, 보너스를 0.2로 하락
UPDATE emp_salary
SET salary = 7000000,
	bonus = 0.2
WHERE emp_name = '선동일';

-- 모든 사원의 급여를 기존 급여에서 10프로 인상한 금액(기존 급여 * 1.1)으로 변경
UPDATE emp_salary
SET salary = salary * 1.1;

-- 사번이 200인 사원의 사원번호를 null로 변경
UPDATE emp_salary
SET emp_id = null
WHERE emp_id = 200;
	-- > emp_id는 NOT NULL 제약 조건이 걸려있기 때문에 수정이 되지 X.

DESC emp_salary;


-- 아시아 지역에 근무하는 직원들의 보너스를 0.3으로 변경
UPDATE emp_salary
SET bonus = 0.3
WHERE emp_id IN (SELECT emp_id
				FROM kh.employee
					JOIN kh.department ON (dept_code = dept_id)
					JOIN kh.location ON (local_code = location_id)
				WHERE local_name LIKE 'ASIA%');


                
SELECT * FROM kh.employee;	-- emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn
SELECT * FROM dept_copy;	-- dept_id, dept_title, location_id
SELECT * FROM emp_salary;	-- emp_id, emp_name, dept_code, salary, bonus
SELECT * FROM location_copy;-- local_code, national_code, local_name

ROLLBACK;

/*	3. DELETE
	- 테이블에 기록된 데이터를 삭제하는 구문
    
    DELETE FROM 테이블명
    WHERE 조건식;
    
    - WHERE 절을 제시하지 않으면 전체 행이 삭제된다.
*/
-- emp_salary에서 dept_code가 D5인 직원들을 삭제
DELETE FROM emp_salary
WHERE dept_code = 'D5';

SELECT * FROM emp_salary;

ROLLBACK;

/*	4. TRUNCATE
	- 테이블의 전체 행을 삭제할 때 사용하는 구문 
    - DELETE 보다 수행 속도가 더 빠르다.
    - 별도의 조건을 제시할 수 없고, ROLLBACK이 불가능하다.
    
    TRUNCATE TABLE 테이블명;
*/

START transaction;

SELECT * FROM dept_copy;
SELECT * FROM emp_salary;

DELETE FROM dept_copy;
DELETE FROM emp_salary;

ROLLBACK;	-- DELETE는 ROLLBACK 가능
-- DELETE 사용 시 ROLLBACK하면 값들이 복구가 됨.

TRUNCATE TABLE dept_copy;
TRUNCATE TABLE emp_salary;

ROLLBACK;	-- TRUNCATE는 ROLLBACK 불가능
-- TRUNCATE 사용 시 ROLLBACK해도 값들이 복구가 X.

DROP TABLE dept_copy;
DROP TABLE emp_salary;

ROLLBACK;
-- DROP TABLE도 ROLLBACK이 되지 않음.














