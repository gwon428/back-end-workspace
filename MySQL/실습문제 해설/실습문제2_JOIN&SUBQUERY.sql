-- Sakila : DVD 대여 및 영화 정보와 관련된 데이터 포함

SELECT * FROM category; -- 영화 카테고리 정보 : category_id
SELECT * FROM rental; -- DVD 대여 정보 : customer_id, inventory_id
SELECT * FROM inventory; -- DVD 대여점에서 관리하는 정보 : inventory_id, film_id
SELECT * FROM customer; -- DVD 대여 고객 정보 : customer_id, address_id
SELECT * FROM film; -- 영화 정보 : film_id
SELECT * FROM actor; -- 영화 배우 정보 : actor_id

SELECT * FROM film_category; -- film과 category 연결 : film_id, category_id
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id

SELECT * FROM address; -- 고객 주소 정보 : address_id, city_id
SELECT * FROM city; -- city_id, country_id
SELECT * FROM country; -- country_id;

-- 1. first_name이 TRACY인 사람들 조회 
-- 내가 푼 거
SELECT country, city, address, district, first_name, last_name
FROM city
	JOIN country USING (country_id)
    JOIN address USING (city_id)
    JOIN customer USING (address_id)
WHERE first_name LIKE 'TRACY';	-- LIKE 쓸 필요 X

-- 풀이
-- 필요한 컬럼 : country, city, address, district, first_name, last_name
-- 필요한 테이블 : country, city, address, customer

SELECT country, city, address, district, first_name, last_name
FROM customer
	JOIN address USING(address_id)
    JOIN city USING(city_id)
    JOIN country USING(country_id)
WHERE first_name = 'TRACY';
    
    
-- 2. 배우 JULIA MCQUEEN이 찍은 영화 제목 조회 (title 기준 정렬 10개까지)
-- 내가 푼 거
SELECT first_name, last_name, title
FROM film_actor
	JOIN film USING (film_id)
    JOIN actor USING (actor_id)
WHERE first_name LIKE 'JULIA'
	AND last_name LIKE 'MCQUEEN'
ORDER BY 3
LIMIT 10;

-- 풀이
-- 필요한 테이블 : actor(actor_id), film(film_id), film_actor(actor_id, film_id)
-- 필요한 컬럼 : first_name, last_name, title
SELECT * FROM actor;	-- actor_id, first_name, last_name
SELECT * FROM film;		-- film_id, title
SELECT * FROM film_actor;	-- actor_id, film_id

SELECT first_name, last_name, title
FROM film_actor
	JOIN film USING (film_id)
    JOIN actor USING (actor_id)
WHERE first_name LIKE 'JULIA'
	AND last_name LIKE 'MCQUEEN'
ORDER BY 3
LIMIT 10;

-- 3. 영화 NOON PAPI에 나오는 배우들의 이름 조회
-- 내가 푼 거
SELECT first_name, last_name
FROM film_actor
	JOIN film USING (film_id)
    JOIN actor USING (actor_id)
WHERE title LIKE 'NOON PAPI';

-- 풀이 (JOIN)
-- 필요한 테이블 : film(film_id), actor(actor_id), film_actor
-- 필요한 컬럼 : first_name, last_name
SELECT first_name, last_name, title
FROM film_actor
	JOIN film USING (film_id)
    JOIN actor USING (actor_id)
WHERE title = 'NOON PAPI';

-- 풀이 (서브쿼리)
-- 조회에 필요한 테이블은 actor뿐 -> 서브쿼리 가능
SELECT film_id
FROM film
WHERE title = 'NOON PAPI';

SELECT actor_id
FROM film_actor
WHERE film_id = (SELECT film_id
					FROM film
					WHERE title = 'NOON PAPI'
);

-- 답
SELECT first_name, last_name
FROM actor
WHERE actor_id IN (SELECT actor_id
					FROM film_actor
					WHERE film_id = (SELECT film_id
										FROM film
										WHERE title = 'NOON PAPI'
));


-- 4. 각 카테고리별 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 빌린 DVD 대여 수 조회 
-- 내가 푼 거
SELECT name, count(*)
FROM rental
	JOIN customer USING (customer_id)
    JOIN inventory USING (inventory_id)
    JOIN film USING (film_id)				-- JOIN할 필요가 없는 테이블 
    JOIN film_category USING (film_id)
    JOIN category USING (category_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
GROUP BY category_id;

-- 풀이
-- 필요한 테이블 : category, customer, rental
-- 필요한 컬럼 : , count
SELECT * FROM category;		-- (category_id, name) --> film_category
SELECT * FROM film_category;-- (film_id, category_id)
SELECT * FROM customer;					-- (customer_id		--> rental)
SELECT * FROM rental;					-- (rental_id, customer_id, (inventory_id	--> inventory))
SELECT * FROM inventory;				-- (inventory_id, film_id)

-- 1 JOIN
SELECT name category, count(*) count
FROM rental
	JOIN inventory USING (inventory_id)
    JOIN customer USING (customer_id)
    JOIN film_category USING (film_id)
    JOIN category USING (category_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
GROUP BY name;

-- 2 JOIN&서브쿼리
SELECT name, count(*)
FROM rental
	JOIN inventory USING (inventory_id)
    JOIN film_category USING (film_id)
	JOIN category USING (category_id)
WHERE customer_id = (SELECT customer_id
					FROM customer
					WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org')
GROUP BY name;

SELECT customer_id
FROM customer
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org';

-- 5. 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 가장 최근에 빌린 영화 제목과 영화 내용을 조회 
-- 내가 푼 거
SELECT title, description
FROM rental
	JOIN customer USING (customer_id)
    JOIN inventory USING (inventory_id)
    JOIN film USING (film_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
ORDER BY rental_date DESC
LIMIT 1;

-- 풀이
-- 필요한 테이블 : 
-- 필요한 컬럼 : title, description
SELECT * FROM customer;		-- customer_id, email
SELECT * FROM rental;		-- rental_id, rental_date, customer_id, inventory_id
SELECT * FROm inventory;	-- inventory_id, film_id
SELECT * FROM film;			-- film_id, title, description

-- 1) JOIN
SELECT title, description
FROM rental
	JOIN customer USING (customer_id)
    JOIN inventory USING (inventory_id)
    JOIN film USING (film_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org'
ORDER BY rental_date DESC
LIMIT 1;

-- 2) JOIN&서브쿼리
SELECT title, description
FROM rental
	JOIN customer USING (customer_id)
    JOIN inventory USING (inventory_id)
    JOIN film USING (film_id)
WHERE rental_date = (SELECT max(rental_date)
					FROM rental
						JOIN customer USING (customer_id)
					WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org');

-- 이메일이 'JOYCE.EDWARDS@sakilacustomer.org'인 사람이 가장 최근에 대여한 날짜
SELECT max(rental_date)
FROM rental
	JOIN customer USING (customer_id)
WHERE email = 'JOYCE.EDWARDS@sakilacustomer.org';

