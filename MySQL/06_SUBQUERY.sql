/* 서브쿼리 (SUBQUERY) [중첩query라고도 함 (select 안의 select문)]
	- 하나의 SQL문 안에 포함된 또 다른 SQL문
    - 서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류
    - 서브쿼리 종류에 따라 서브쿼리와 사용하는 연산자가 달라짐
    
    1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때 (한 행 한 열)
    - 일반 비교연산자 사용 가능 : =, !=, ^=, <>, >, <, >=, <=, ...
*/
-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = '노옹철'; -- D9

-- 2) 부서코드가 'D9'인 사원들 조회
SELECT emp_name
FROM employee
WHERE dept_code = 'D9';

-- 3) 위의 2단계를 하나의 쿼리문으로! (쿼리문 내의 쿼리문)
SELECT emp_name
FROM employee
WHERE dept_code = (
		SELECT dept_code
		FROM employee
		WHERE emp_name = '노옹철');

-- 전 직원의 평균 급여보다 더 맣은 급여를 받는 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT emp_id, emp_name, job_code, format(salary, 0) 급여
FROM employee
WHERE salary > (SELECT avg(salary)
					FROM employee)
ORDER BY 4 DESC;

-- 최저급여를 받는 사원의 사번, 이름, 직급 코드, 급여, 입사일 조회
SELECT emp_id, emp_name, job_code, format(salary, 0), hire_date
FROM employee
ORDER BY 4
LIMIT 1;

SELECT emp_id, emp_name, job_code, format(salary, 0), hire_date
FROM employee
WHERE salary = (SELECT min(salary)
		FROM employee);

-- 전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회
-- 단, 전지연 사원은 제외
SELECT dept_id
FROM department
	JOIN employee ON (dept_code = dept_id)
WHERE emp_name = '전지연';

SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee
	JOIN job USING (job_code)
    JOIN department ON (dept_code = dept_id)
WHERE dept_code = (SELECT dept_code
			FROM employee
			-- JOIN department ON (dept_code = dept_id)
			WHERE emp_name = '전지연')
		AND emp_name <> '전지연';

SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee e, job j, department
WHERE e.job_code = j.job_code
	AND dept_code = dept_id
    AND dept_code = (SELECT dept_code
						FROM employee
						WHERE emp_name = '전지연')
	AND emp_name <> '전지연';

-- 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합 조회
SELECT dept_code, sum(salary) 급여의합
FROM employee
GROUP BY dept_code
ORDER BY 2 DESC
LIMIT 1;

-- 서브쿼리문 사용
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code; -- > 결과값이 테이블


SELECT dept_code, sum(salary) sum_sal
FROM employee
GROUP BY dept_code;

-- 1. 부서별 합계가 가장 큰 값
SELECT max(sum_sal)
FROM (SELECT dept_code, sum(salary) sum_sal
		FROM employee
		GROUP BY dept_code) dept_sum;

-- 서브쿼리 다 배우고 다시 볼 것
-- 서브쿼리 특징! 쿼리 자체는 직관적! 
-- 쿼리 속도 중요 --> 서브 쿼리는 느림
-- 가급적으로 서브쿼리를 사용하지 않아도 되는거면 안 쓰는 걸 추천
SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
HAVING sum(salary) = (SELECT max(sum_sal)
						FROM (SELECT dept_code, sum(salary) sum_sal
								FROM employee
								GROUP BY dept_code) dept_sum);
							

/* 2. 다중행 서브쿼리
	- 서브쿼리의 조회 결과 값의 개수가 여러 행일 때 (여러 행 한 열[컬럼])
    
    IN 서브쿼리 : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면 
*/
-- 각 부서별 최고 급여를 받는 직원의 이름, 직급 코드, 부서코드, 급여 조회
-- 1) 각 부서별 최고 급여 조회 (조건)
SELECT MAX(salary)
FROM employee
GROUP BY dept_code;

-- 2) 위의 값들을 받은 직원의 이름, 직급 코드, 부서코드, 급여 조회
SELECT emp_name, job_code, dept_code, format(salary, 0)
FROM employee
WHERE salary IN (SELECT MAX(salary)
				FROM employee
				GROUP BY dept_code)
ORDER BY 3;

-- 직원에 대해 사번, 이름, 부서코드, 구분(사수/사원) 조회
SELECT * FROM employee;

-- 내가 푼 거 !!!
SELECT e.emp_id, e.emp_name, e.dept_code,
	CASE WHEN e.emp_id IN (SELECT distinct e.manager_id FROM employee e) THEN '사수'
			ELSE '사원'
			END 구분
FROM employee e
	JOIN employee m USING (emp_id);
    
-- 누군가의 사수인 사람들의 emp_id
SELECT distinct manager_id
FROM employee
WHERE manager_id IS NOT NULL;

-- 사수 테이블 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE emp_id IN (SELECT distinct manager_id
					FROM employee
					WHERE manager_id IS NOT NULL);

-- 사원 테이블 조회
SELECT emp_id, emp_name, dept_code
FROM employee
WHERE emp_id NOT IN (SELECT distinct manager_id
					FROM employee
					WHERE manager_id IS NOT NULL);
                    
-- >> 오로지 서브쿼리로만 사용하는 방법! 힌트 : SELECT 절에서도 서브쿼리를 사용할 수 있다.
-- IF/ CASE ~
SELECT emp_id, emp_name, dept_code,
	IF(emp_id IN (SELECT distinct manager_id
					FROM employee
                    WHERE manager_id is not null), "사수", "사원") 구분
FROM employee;

SELECT emp_id, emp_name, dept_code,
	CASE WHEN emp_id IN (SELECT distinct manager_id
						FROM employee
                        WHERE manager_id is not null)
		THEN "사수"
        ELSE "사원"
        END 구분
FROM employee;


--
SELECT e.emp_id, e.emp_name, e.dept_code,
	CASE WHEN e.emp_id IN (SELECT distinct e.manager_id
							FROM employee e
							WHERE e.manager_id IS NOT NULL)
		THEN '사수'
		ELSE '사원'
        END 구분,
	m.emp_id 사수사번, m.emp_name 사수이름, m.dept_code 사수부서
FROM employee e
	LEFT JOIN employee m ON(e.manager_id = m.emp_id);

/* ANY [or]
	컬럼 > ANY (서브쿼리) : 여러 개의 결과값 중에서 "한 개라도" 클 경우
							(여러 개의 결과값 중에서 가장 작은 값보다 클 경우)
	컬럼 < ANY (서브쿼리) : 여러 개의 결과값 중에서 "한 개라도" 작을 경우
							(여러 개의 결과값 중에서 가장 큰 값보다 작을 경우)
*/
-- 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
-- 과장 직급들의 급여
SELECT salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '과장';

SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = '대리'
	AND salary > ANY(SELECT salary
						FROM employee
						JOIN job USING (job_code)
						WHERE job_name = '과장');
-- salary > 2200000 OR salary > 2500000 OR salary > 3760000

/* ALL [and]
	컬럼 > ALL (서브쿼리) : 여러 개의 "모든" 결과값들보다 클 경우
						(여러 개의 결과값 중에서 가장 큰 값보다 클 경우)
	컬럼 < ALL (서브쿼리) : 여러 개의 "모든" 결과값들보다 작을 경우
						(여러 개의 결과값 중에서 가장 큰 작은 값보다 작을 경우)
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회
-- 차장 직급의 최대 급여
SELECT emp_name, job_name, salary
FROM employee
	JOIN job USING(job_code)
WHERE job_name ="차장";


SELECT emp_id, emp_name, job_name, salary
FROM employee
	JOIN job USING (job_code)
WHERE job_name = "과장"
	AND salary > ALL (SELECT salary
						FROM employee
							JOIN job USING(job_code)
						WHERE job_name = "차장");

SELECT emp_id, emp_name, job_name, salary
FROM employee e, job j
WHERE e.job_code = j.job_code
	AND job_name = "과장"
    AND salary > ALL (SELECT salary
						FROM employee e, job j
						WHERE e.job_code = j.job_code
                        AND job_name = "차장");

/* 3. 다중열 서브쿼리
	- 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러 개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는 사원들의 사원명, 부서코드, 직급 코드 조회
SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (SELECT dept_code
					FROM employee
					WHERE emp_name = "하이유")
	AND job_code = (SELECT job_code
					FROM employee
					WHERE emp_name = "하이유");

-- 내가 푼 겅.
SELECT emp_name, dept_code, job_code
FROM employee
WHERE (dept_code, job_code) in (SELECT dept_code, job_code
								FROM employee
								WHERE emp_name = "하이유");

-- 하이유 사원과 같은 부서 코드
SELECT dept_code
FROM employee
WHERE emp_name = "하이유";  -- D5

-- 하이유 사원과 같은 직급 코드
SELECT job_code
FROM employee
WHERE emp_name = "하이유";	-- J5

-- 사원명, 부서코드, 직급 코드 조회
SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = (SELECT dept_code
					FROM employee
					WHERE emp_name = "하이유")
AND job_code = (SELECT job_code
				FROM employee
				WHERE emp_name = "하이유");

-- >> 다중열 서브쿼리로!
SELECT emp_name, dept_code, job_code
FROM employee
WHERE dept_code = 'D5'
	AND job_code = 'J5';
-- WHERE (dept_code, job_code) = (('D5', 'J5')) => 문자로 넣을 땐 괄호가 2개여야 함.;

SELECT emp_name, dept_code, job_code
FROM employee
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
								FROM employee
                                WHERE emp_name = "하이유");

-- 박나라 사원과 직급 코드가 일치하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급 코드, 사수 사번 조회
SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) = (SELECT job_code, manager_id
								FROM employee
								WHERE emp_name = "박나라");

/* 4. 다중행 다중열 서브쿼리
	- 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급 코드, 급여 조회
-- 각 직급별로 최소 급여를 받는 사원들의 급여
SELECT job_code, min(salary)
FROM employee
GROUP BY job_code;	-- group by의 컬럼명은 여러 개 지을 수 있음. 그러나 여기서 명시한 것들만 SELECT에 사용 가능
          
SELECT emp_id, emp_name, job_code, salary
FROM employee
WHERE (job_code, salary) IN (SELECT job_code, min(salary)
							FROM employee
							GROUP BY job_code)
                            -- (('J1', 8000000), ('J2', 3700000), ... )
ORDER BY 3;

-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서 코드, 급여 조회 (부서없음 명시)
SELECT IFNULL(dept_code, '부서없음'), max(salary)
FROM employee
GROUP BY dept_code;

SELECT emp_id, emp_name, IFNULL(dept_code, '부서없음'), salary
FROM employee
WHERE (IFNULL(dept_code, '부서없음'), salary) IN (SELECT IFNULL(dept_code, '부서없음'), max(salary)
								FROM employee
                                GROUP BY dept_code)
ORDER BY 3;

SELECT emp_id, emp_name, IFNULL(dept_code, '부서없음'), salary
FROM employee
WHERE (IFNULL(dept_code, '부서없음'), salary) IN (SELECT IFNULL(dept_code, '부서없음'), max(salary)
								FROM employee
                                GROUP BY dept_code);

/* RANK 함수
	- RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위를 계산
								(ex. 공동 1위가 2명이면 다음 순위는 3위)
    - DENSE_RANK() OVER (정렬 기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가한다.
								(ex. 공동 1위가 2명이면 다음 순위는 2위)
*/
-- 사원별 급여가 높은 순서대로 순위 매겨서 순위, 사원명, 급여 조회
SELECT
	rank() over(ORDER BY salary DESC) 순위,
	emp_name 사원명, salary 급여
FROM employee;

SELECT
	dense_rank() over (ORDER BY salary DESC) 순위,
    emp_name 사원명, salary 급여
FROM employee;

-- 




