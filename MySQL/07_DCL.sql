/*
	보안 및 권한 관리를 위해 root 계정을 직접 사용하지 앟는 것을 권장
*/

-- 사용자 계정 생성
CREATE USER test IDENTIFIED BY 'test';	-- '' 속에 들어있는 것이 비밀번호
	-- test USER는 sys라는 데이터 베이스가 없기 때문에 그 안에서 다른 사용자 계정 생성이 안됨.
CREATE USER test2@localhost IDENTIFIED BY 'test2';	-- localhost : 사용하고 있는 컴퓨터 [MySQL만]

-- 사용자 계정 삭제
DROP USER test;
DROP USER test2@localhost;

-- 현재 사용자에게 부여된 권한 목록 (sys 데이터베이스 한해서)
SHOW PRIVILEGES;

/* DCL (Data Control Language) : 데이터 제어어
    - 계정에게 객체 접근 권한을 부여(GRANT)하거나 회수(REVOKE)하는 구문
    
    GRANT 권한, 권한, ... (ON 위치) TO 계정;
    REVOKE 권한, 권한, ... FROM 계정;
*/
-- 데이터베이스(스키마) 권한 부여
GRANT ALL PRIVILEGES ON kh.* TO test;
GRANT CREATE ON kh.* TO test;		-- SELECT가 안됨..
GRANT SELECT ON kh.* TO test;		-- SELECT 권한을 따로 부여

-- 데이터베이스(스키마) 권한 회수
-- REVOKE ALL PRIVILEGES ON *.* FROM test;			-- FROM에서 뜨는 오류는 Workbench 문제

/*	데이터베이스, 스키마

	* 데이터베이스 (Database) : 데이터의 집합을 저장하고 관리하는 시스템
		- 데이터를 구조화하고 조직화하는 데 사용
        - 여러 테이블, 뷰, 프로시저, 함수 등을 포함
	
    * 스키마 (Schema) : 데이터베이스 내에 특정 테이블, 뷰, 프로시저, 함수 등을 그룹화
    
    --> 데이터베이스와 스키마를 같은 의미로 사용을 하지만, 몇몇 DBMS에서는 다르게 해석
		MySQL에서는 대부분 두 용어를 같이 사용!
*/
-- 스키마 생성
CREATE SCHEMA sample;

-- 스키마 삭제
DROP SCHEMA IF EXISTS sample;

-- 데이터베이스 생성
CREATE DATABASE sample2;

-- 데이터베이스 삭제
DROP DATABASE IF EXISTS sample2;

