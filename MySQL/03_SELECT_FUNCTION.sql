/* 함수
	함수 : 전달된 칼럼값을 읽어들여서 함수를 실행한 결과를 반환
    
    - 단일행 함수 : n개의 값을 읽어서 n개의 결과값을 리턴 (매 행마다 함수 실행 결과 반환)
    - 그룹 함수 : n개의 값을 읽어서 1개의 결과값을 리턴 (그룹별로 함수 실행 결과 반환)
    
    >> SELECT 절에 당일행 함수와 그룹 함수는 함께 사용하지 못함! (결과 행의 개수가 다르기 때문)
    
    >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/

-- 단일행 함수

/*
	문자 처리 함수
    
    LENGTH(컬럼|'문자열') : 해당 문자열값의 BYTE 길이 수 반환
    - 한글 한 글자 -> 3BYTE
    - 영문자, 숫자, 특수문자 한 글자 -> 1BYTE
    
    CHAR_LENGTH(컬럼|'문자열') : 해당 문자열값의 글자 수 반환
*/
SELECT length('데이터베이스'), char_length('데이터베이스'),
length('database'), char_length('database');
-- FROM DUAL;	-- DUAL : 가상 테이블 ㅣ: 데이터베이스 자체에서 제공하는 테이블 (MySQL 생략 가능!)

-- 사원명, 사원명의 글자수, 이메일, 이메일의 글자수 조회
SELECT emp_name, char_length(emp_name), email, char_length(email)
FROM employee
LIMIT 10;

/*
	INSTR(칼럼|'문자열', '찾으려는 문자열')
    - 특정 문자열에서 찾고자하는 문자열의 위치 반환
    - 없으면 0 반환
*/
SELECT instr('AABAACAABBAA', 'B');	-- 3
SELECT instr('AABAACAABBAA', 'D');	-- 0]

-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회
SELECT email, instr(email, '@')
FROM employee
WHERE email LIKE '%s%';

/*
	LPAD | RPAD (컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
    - 문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 덧붙여서 최종적으로 반환할 문자의 길이만큼 문자열 반환
*/

SELECT lpad('HELLO', 10, ' ');
SELECT lpad('HELLO', 10, 'A');
SELECT rpad('HELLO', 10, '*');

/*
	TRIM (컬럼 | '문자열')
    TRIM ([LEADING | TRAILING | BOTH] 제거하고자하는문자들 FROM 컬럼 | '문자열')
    - 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT trim('         K  H   ');	-- 기본적으로 양쪽에 있는 공백 제거
SELECT trim(LEADING 'Z' FROM 'ZZZKHZZZ');	-- KHZZZ
SELECT trim(TRAILING 'Z' FROM 'ZZZKHZZZ');	-- ZZZKH
SELECT trim(BOTH 'Z' FROM 'ZZZKHZZZ');	-- KH

-- LTRIM, RTRIM
SELECT trim(LEADING ' ' FROM '         K  H   ');	-- 앞쪽의 공백 제거
SELECT ltrim('         K  H   ');
SELECT trim(TRAILING ' ' FROM '         K  H   ');	-- 뒤쪽의 공백 제거
SELECT rtrim('         K  H   ');

/*
	SUBSTR | SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
	- 문자열에서 특정 문자열을 추출해서 반환
*/
SELECT substr('PROGRAMMING', 5, 2);		-- RA
SELECT substring('PROGRAMMING', 1, 6);	-- PROGRA
SELECT substr('PROGRAMMING', -8, 3);	-- GRA (뒤에서 8번째 문자부터 3개)

SELECT *
FROM employee;
-- 여자 사원들만 조회
SELECT emp_name, emp_no
FROM employee
WHERE substring(emp_no, 8, 1) = 2;
-- substr(emp_no, instr(emp_no, '-') +1, 1) = 2;
-- 남자 사원들만 조회
SELECT emp_name, emp_no
FROM employee
WHERE substring(emp_no, 8, 1) = 1;

/*
	LOWER|UPPER(컬럼|'문자열')
    - LOWER : 다 소문자로 변경한 문자열 반환
    - UPPER : 다 대문자로 변경한 문자열 반환
*/
SELECT lower('Welcome To My World!'), upper('Welcome To My World!');

/*
	REPLACE(컬럼| '문자열', '바꾸고싶은문자열', '바꿀문자열')
    - 특정 문자열로 변경하여 반환
*/
SELECT REPLACE('서울특별시 강남구 역삼동', '역삼동', '삼성동');

/*
	CONCAT(컬럼| '문자열', 컬럼|'문자열', ...)
    - 문자열을 하나로 합친 후 결과 반환
*/
SELECT CONCAT('가나다라', 'ABCD');
SELECT CONCAT('가나다라', 'ABCD', '1234');

-- 실습문제 -----------------------------------------
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회
SELECT emp_name, email '변경 전', REPLACE(email, 'kh.or.kr', 'gmail.com') '변경 후'
FROM employee;

-- 2. 사원명과 주민등록번호(000000-0******)로 조회
-- replace, concat, rpad, substr
SELECT emp_name, replace(emp_no, substr(emp_no, 9, 14), '******')
FROM employee;

SELECT emp_name, rpad(substr(emp_no, 1, 8), 14, '*')
FROM employee;

SELECT emp_name, CONCAT(substr(emp_no, 1, 8), '******')
FROM employee;

-- 2번 풀이
-- 2-1. replace
SELECT emp_name, replace(emp_no, substr(emp_no, -6, 6), '******')
FROM employee;

-- 2-2. rpad
SELECT emp_name, rpad(substr(emp_no, 1, instr(emp_no, '-')+1), char_length(emp_no), '*')
FROM employee;

-- 2-3. concat
SELECT emp_name, concat(substr(emp_no, 1, 8), '******')
FROM employee;

-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회
-- replace, trim, substr
SELECT emp_name, email, substr(email, 1, instr(email, '@')-1) as 아이디
FROM employee;

SELECT emp_name, email, trim(trailing'@kh.or.kr' FROM email) as 아이디
FROM employee;

-- 3번 풀이
-- 3-1. replace
SELECT emp_name, email, replace(email, '@kh.or.kr', '')
FROM employee;

-- 3-2. trim
SELECT emp_name, email, trim(trailing '@kh.or.kr' FROM email)
FROM employee;

-- 3-3. substr
SELECT emp_name, email, substr(email, 1, instr(email, '@')-1)
FROM employee;


/*
	숫자 처리 함수
    
    ABS(숫자)
    - 숫자의 절대값 반환
*/
SELECT ABS(-253);

/*
	숫자 DIV 숫자 = 숫자 / 숫자
    MOD(숫자, 숫자) | 숫자 MOD 숫자 = 숫자 % 숫자
*/
SELECT
	10 DIV 3, 10/3,
	MOD(10, 3), 10 MOD 3, 10%3;

/*
	ROUND(숫자, [위치: 생략 가능])
    - 반올림한 결과를 반환
*/
SELECT ROUND(123.456);	-- 123, 위치 기본값: 0 (소수점 제거)
SELECT ROUND(123.456, 1);	-- 123.5, 소수점 첫번째 자리까지
SELECT ROUND(123.456, -1);	-- 120
SELECT ROUND(123.456, -2);	-- 100
SELECT ROUND(123.456, -3);	-- 0

/*
	CEIL(숫자)
	- 올림 처리해서 반환
*/
SELECT CEIL(123.152);	-- 124

/*
	FLOOR(숫자)
	- 버림 처리해서 반환
*/
SELECT FLOOR(123.789);	-- 123

/*
	TRUNCATE(숫자, 위치)
    - 위치 지정하여 버림 처리해서 반환
*/
-- 기본값이 없음 설정 안하면 안나옴
SELECT TRUNCATE(123.789, 2);	-- 123.78
SELECT TRUNCATE(123.789, -1);	-- 120

/*
	날짜 처리 함수
    NOW(), CURRENT_TIMESTAMP() : 현재 날짜와 시간 반환
    CURDATE(), CURRENT_DATE() : 현재 날짜 반환
    CURTIME(), CURRENT_TIME() : 현재 시간 반환
*/
SELECT
	now(), current_timestamp(), 
	curdate(), current_date(),
    curtime(), current_time();

/*
	DAYOFYEAR(날짜) : 날짜가 해당 연도에서 몇 번째 날인지 반환
    DAYOFMONTH(날짜) : 날짜가 해당 월에서 몇 번째 날인지 반환
    DAYOFWEEK(날짜) : 날짜가 해당 주에서 몇 번째 날인지 반환 (일요일=1, 토요일=7)
*/
SELECT
	DAYOFYEAR(now()),
    DAYOFMONTH(now()),
    DAYOFWEEK(now());

/*
	PERIOD_DIFF(YYYYMM | YYMM, YYYYMM | YYMM) : 두 기간의 차이를 숫자로 반환
    DATEDIFF (날짜, 날짜) : 두 날짜 사이의 일수를 숫자로 반환
    TIMEDIFF (날짜, 날짜) : 두 시간의 차이를 날짜 형식으로 반환
    TIMESTAMPDIFF(날짜단위, 날짜, 날짜) : 두 날짜 사이의 기간을 날짜 단위에 따라 변환
    
    * 날짜 단위 : YEAR (연도), QUARTER (분기), MONTH (월), WEEK (주), DAY (일), HOUR (시간), MINUTE (분), SECOND (초)
*/
SELECT period_diff(202312, 202403);	-- -3
SELECT period_diff(202403, 202312);	-- 3

SELECT datediff('2023-12-31', now());
SELECT timediff('2024-01-01 00:00:00', now());

-- 직원명, 입사일, 근무일수, 근무 개월 수, 근무 년 수 조회
SELECT
	emp_name,
	hire_date,
	datediff(now(), hire_date) as "근무 일 수",
	timestampdiff(month, hire_date, now()) as "근무 개월 수",
	timestampdiff(year, hire_date, now()) as "근무연수"
FROM employee;

/*
	ADDDATE(날짜, INTERVAL 숫자 날짜단위 (YEAR, MONTH, DAY, HOUR, MINUTE, SECOND)
    ADDTIME(날짜, 시간 정보)
    - 특정 날짜에 입력받은 정보만큼 더한 날짜를 반환
    
    SUBDATE(날짜, INTERVAL 숫자 날짜단위 (YEAR, MONTH, DAY, HOUR, MINUTE, SECOND)
    SUBTIME(날짜, 시간 정보)
    - 특정 날짜에 입력받은 정보만큼 뺀 날짜를 반환
*/
SELECT now(), adddate(now(), interval 15 day);
SELECT now(), subdate(now(), interval 15 day);

SELECT now(), addtime(now(), "1 01:01");
SELECT now(), subtime(now(), "3 01:01");
    
-- 직원명, 입사일, 입사 후 6개월이 된 날짜를 조회
SELECT emp_name, hire_date,
	adddate(hire_date, interval 6 month) as '입사 후 6개월'
FROM employee;

/*
	LAST_DAY(날짜) : 해당 월의 마지막 날짜 반환
*/
SELECT last_day(now());
SELECT last_day('2024-02-04');

/*
	YEAR(날짜)
	MONTH(날짜)
    DAY(날짜)
    HOUR (날짜)
    MINUTE(날짜)
    SECOND(날짜)
    - 특정 날짜에 연도, 월, 일, 시간, 분, 초 정보를 각각 추출해서 반환
*/
SELECT year(now()), month(now()), day(now()), hour(now()), minute(now()), second(now());

-- 연도별 오래된 순으로 직원명, 입사연도, 입사월, 입사일 조회
SELECT emp_name, hire_Date, year(hire_date) as '입사연도', month(hire_date) as '입사월', day(hire_date) as '입사일'
FROM employee
-- order by에서는 별칭 사용 가능
ORDER BY 2;

/*
	형 변환 함수
    CAST(값 AS 데이터형식)
    CONVERT (값, 데이터형식[길이])
*/
SELECT CAST(1234 AS CHAR);
SELECT CONVERT(1234, CHAR);

/*
	포맷 함수
    FORMAT(숫자, 위치) : 숫자에 3단위씩 콤마 추가해서 반환 [위치 : 소수점 자리]
    DATE_FORMAT(날짜, 포맷 형식) : 날짜 형식을 변경해서 반환
*/
SELECT emp_name, salary, FORMAT(salary, 0)
FROM employee;

SELECT now(), date_format(now(), '%Y.%m.%d');
SELECT now(), date_format(now(), '%Y. %m. %d. %T'); -- %T는 시간 관련 초까지 다 가져옴
SELECT now(), date_format(now(), '%Y년 %m월 %d일 %H시 %i분 %s초');

-- 직원명, 입사일 (2023년 12월 26일) 조회
SELECT emp_name as 직원명, date_format(hire_date, '%Y년 %m월 %d일 %H시 %i분 %s초') as 입사일
FROM employee
ORDER BY 2;

/*
	null 처리 함수
    
    COALESCE |IFNULL(값, 값이 NULL일 경우 반환할 값)
*/
SELECT emp_name, bonus, COALESCE(bonus, 0)
FROM employee;

-- 전 사원의 직원명, 보너스, 보너스 포함 연봉 (급여 + 급여 * 보너스) * 12 조회
SELECT emp_name, bonus, FORMAT(salary,0) as 월급, (salary + salary * ifnull(bonus,0)) * 12 as 보너스연봉, FORMAT(((salary + (salary * COALESCE(bonus, 0))) * 12), 0) as '보너스 포함 연봉'
FROM employee;

-- 직원명, 부서 코드 조회 (부서 코드가 없으면 '부서없음')
SELECT emp_name, COALESCE(dept_code, '부서없음') as 부서코드
FROM employee;

/*
	NULLIF(값1, 값2)
    - 두 개의 값이 동일하면 NULL 반환, 두 개의 값이 동일하지 않으면 값1 반환
*/
SELECT nullif('123', '123');	-- null 일치하기 때문
SELECT nullif('123', '456');	-- 123 일치하지 않기 때문에 값1 반환

SELECT nullif('1234', 1234);	-- null. 같은 것으로 인식

/*
	IF(값1, 값2, 값3) | IF(조건, 조건T인경우, 조건F인경우)
    - 값1이 null이 아니면 값2 반환, null이면 값3 반환
*/
SELECT emp_name, bonus, IF(bonus, 0.7, 0.1) 보너스
FROM employee;

-- 직원명, 부서 코드가 있으면 '부서있음', 없으면 '부서없음'으로 조회
SELECT emp_name, dept_code, IF(dept_code IS NOT NULL, '부서있음', '부서없음')
FROM employee;

-- 사번, 사원명, 주민번호, 성별(남, 여) 조회
SELECT emp_id, emp_name, emp_no, IF(substr(emp_no, 8, 1) = 1, '남', '여') as 성별
FROM employee;

-- 사원명, 직급 코드(job_code), 기존 급여(salary), 인상된 급여 조회
-- 정렬 : 직급 코드 j1부터, 인상된 급여 높은 순서대로 
-- 직급 코드가 j7인 사원은 급여를 10% 인상
-- 직급 코드가 j6인 사원은 급여를 15% 인상
-- 직급 코드가 j5인 사원은 급여를 20% 인상
-- 그 외의 사원은 급여를 5%만 인상

SELECT emp_name, job_code, salary, format(if(job_code = 'J7', salary*1.1, IF(job_code ='j6', salary*1.15, IF(job_code = 'j5', salary*1.2, salary*1.05 ))), 0) as 인상된급여
FROM employee
ORDER BY 2, 4 DESC;

/*
	CASE WHEN 조건식 1 THEN 결과값 1
		WHEN 조건식 2 THEN 결과값 2
        ...
        ELSE 결과값 N
	END
    
    -> if ~ else if문과 유사
*/

 SELECT emp_name, job_code, salary,
 FORMAT (CASE WHEN job_code = 'J7' THEN salary*1.1
	WHEN job_code = 'J6' THEN salary*1.5
	WHEN job_code = 'J5' THEN salary*1.2
	ELSE salary*1.05
	END,0) "인상된 급여"
FROM employee
ORDER BY 2;

SELECT
	emp_id, emp_name, emp_no,
	CASE WHEN substr(emp_no, 8, 1) = 1 THEN '남자'
		WHEN substr(emp_no, 8, 1) = 2 THEN '여자'
        ELSE "잘못된 주민번호입니다"
        END "성별"
FROM employee;

-- 사원명, 급여, 급여 등급(1~4등급) 조회
-- SALARY 값이 500만원 초과일 경우 1등급
-- SALARY 값이 500만원 이하 350만원 초과일 경우 2등급
-- SALARY 값이 350만원 이하 200만원 초과일 경우 3등급
-- 그 외의 경우 4등급

SELECT emp_name "사원명", format(salary,0) "급여",
	CASE WHEN salary > 5000000 THEN "1등급"
		WHEN salary > 3500000 THEN "2등급"
        WHEN salary > 2000000 THEN "3등급"
        ELSE "4등급"
        END "급여 등급"
	FROM employee
    ORDER BY 2 DESC, 3;

-- 그룹함수(집계함수)----------------------------------------------------------------
-- n개의 값을 읽어서 1개의 결과값을 리턴 (그룹별로 함수 실행 결과 반환)
/*
	그룹함수 --> 결과값 1개!
    - 대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우 사용되는 함수들
    - 모든 그룹함수는 NULL 값을 자동으로 제외하고 값이 있는 것들만 계산
    
    SUM(숫자)
    - 해당 컬럼 값들의 총 합계를 반환
*/
-- 전체 사원의 총 급여 합 조회
SELECT format(SUM(salary),0) AS "급여 합계"
FROM employee;

-- 부서코드가 D5인 사원들의 총 연봉(급여 * 12) 합 조회
SELECT format(sum(salary*12), 0) as '부서 D5 연봉 합'
FROM employee
WHERE dept_code = 'D5';
 /*
	AVG(숫자)
    - 해당 컬럼 값들의 평균을 반환
    - 모든 그룹 함수는 NULL 값을 자동으로 제외하기 때문에 AVG 함수를 사용할 때는 COALESCE 또는 IFNULL 함수와 함께 
 */
 -- 전체 사원의 평균 급여 조회
SELECT avg(salary), avg(ifnull(salary,0)), avg(bonus), avg(ifnull(bonus,0))
FROM employee;

/*
	MIN|MAX(모든타입의컬럼)
    - 컬럼 자리에 문자, 날짜도 올 수 있음
    - MIN : 해당 컬럼 값들 중에 가장 작은 값을 반환
    - MAX : 해당 컬럼 갓들 중에 갖아 큰 값을 반환
*/

-- 가장 작은 값에 해당하는 사원명, 급여, 입사일
-- 가장 큰 값에 해당하는 사원명, 급여, 입사일 조회
SELECT MIN(emp_name), MIN(salary), MIN(hire_date),
	MAX(emp_name), MAX(salary), MAX(hire_date)
FROM employee;

/*
	COUNT(*|컬럼|DISTINCT 컬럼)
    - DISTINCT : 중복된 값 한번만 표시
    - 컬럼 또는 행의 개수를 세서 반환
    
    COUNT (*) : 모든 조회 결과에 해당하는 모든 행 개수를 반환
    COUNT (컬럼) : 해당 컬럼값이 NULL이 아닌 행 개수를 반환 (NULL이 없으면 *와 같은 결과값)
    COUNT (DISTINCT 컬럼) : 해당 컬럼값의 중복을 제거한 행 개수를 반환
*/
-- 전체 사원 수 조회
SELECT COUNT(*)
FROM employee;

-- 보너스를 받은 사원 수 조회
SELECT COUNT(bonus)
FROM employee;

-- 부서가 배치된 사원 수 조회
SELECT COUNT(dept_code)
FROM employee;

-- 현재 사원들이 속해있는 부서 수 조회
SELECT COUNT(distinct dept_code)
FROM employee;

-- 현재 사원들이 분포되어 있는 직급 수 조회
SELECT COUNT(distinct job_code) 
FROM employee;

-- 퇴사한 직원의 수 조회 (ent_date | ent_yn이 y인 경우)
SELECT COUNT(ent_date) 
FROM employee;

SELECT COUNT(*) 
FROM employee
WHERE ent_yn = 'y';











