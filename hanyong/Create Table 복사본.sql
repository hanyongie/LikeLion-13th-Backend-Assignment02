USE Assignment;
 CREATE TABLE musical(
	id INTEGER PRIMARY KEY, #기본키
    name VARCHAR(20) NOT NULL, #뮤지컬 이름 반드시 입력
    time TIME NOT NULL #시간도 입력 필요
    );
CREATE TABLE customers(
	id INTEGER PRIMARY KEY AUTO_INCREMENT, #기본키, 자동증가
    name VARCHAR(10) NOT NULL, #이름입력 필요
    c_id INTEGER,
    FOREIGN KEY (c_id) REFERENCES musical(id)#musical 테이블의 id을 외래키로 참조하기 때문에
		ON DELETE CASCADE #뮤지컬 id삭제되면 해당 고객 정보도 삭제
        ON UPDATE CASCADE #뮤지컬 id변경되면 고객 테이블 변경
	);