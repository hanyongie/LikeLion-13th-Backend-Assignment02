USE Assignment;
SELECT * FROM musical;

SELECT * FROM customer;

SELECT
customer.name as 고객,
musical. name as 뮤지컬,
musical. time as 공연시간
FROM customer
JOIN musical
ON customer.c_id = musical.id;