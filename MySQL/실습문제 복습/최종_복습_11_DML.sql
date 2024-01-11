 -- INSERT
 -- 1) INSERT INTO 테이블명 VALUES (값, 값, ...);
 -- 2) INSERT INTO 테이블명 (컬럼명, 컬럼명, ...) VALUES (값, 값, ...);
 -- 3) INSERT INTO 테이블명 서브쿼리;
 
 
-- emp_dept 테이블에 employee에서 부서 코드가 D1인 직원의 사번, 이름, 부서코드, 입사일 추가하고
-- emp_manager 테이블에 부서 코드가 D1인 직원의 사번, 이름, 관리자 사번을 추가

CREATE TABLE emp_dept
SELECT emp_id, emp_name, dept_code, hire_date
FROM kh.employee
WHERE 1=0;

CREATE TABLE emp_manager
SELECT emp_id, emp_name, manager_id
FROM kh.employee
WHERE 1=0;

INSERT INTO emp_dept
	SELECT emp_id, emp_name, dept_code, hire_date
    FROM kh.employee
    WHERE dept_code = 'D1';
    
INSERT INTO emp_manager
	SELECT emp_id, emp_name, manager_id
    FROM kh.employee
    WHERE dept_code = 'D1';
    
-- UPDATE
/*UPDATE 테이블명 
    SET 컬럼명 = 변경하려는값,
		컬럼명 = 변경하려는값,
		...
	WHERE 조건
*/
CREATE TABLE emp_salary
SELECT *
FROM kh.employee;
-- emp_salary에서 선동일 사장의 급여를 7000000원으로, 보너스를 0.2로 하락
UPDATE emp_salary
SET salary = 7000000,
	bonus = 0.2
WHERE emp_name = '선동일';

-- 모든 사원의 급여를 기존 급여에서 10프로 인상한 금액(기존 급여 * 1.1)으로 변경
UPDATE emp_salary
SET salary = salary*1.1;

-- DELETE
/*  DELETE FROM 테이블명
    WHERE 조건식;
*/
-- emp_salary에서 dept_code가 D5인 직원들을 삭제
DELETE FROM emp_salary
WHERE dept_code = 'D5';








