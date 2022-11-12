CREATE TABLE product_tbl_10(
    product_id NUMBER PRIMARY KEY,
	product_name VARCHAR2(20) NOT NULL,
	product_price NUMBER,
	product_info VARCHAR2(2000),
	product_date DATE,
	company VARHCAR2(50),
	manager_id varchar2(12)
);

INSERT INTO product_tbl_10 VALUES (1001, 'TVU45', 4000, '삼성 45인치 UHD TV', TO_DATE('2018-01-10', 'yyyy-MM-dd'), '삼성', 'E201');
INSERT INTO product_tbl_10 VALUES (1002, 'TVU45_LG', 3500, 'LG 45인치 UHD TV', TO_DATE('2018-02-10', 'yyyy-MM-dd'), 'LG', 'E202');
INSERT INTO product_tbl_10 VALUES (1003, 'IPHONE9', 2500, '스마트폰 아이폰 9', TO_DATE('2018-03-15', 'yyyy-MM-dd'), '애플', 'E202');
INSERT INTO product_tbl_10 VALUES (1004, 'SMNOTE9', 3000, '스마트폰 삼성노트9', TO_DATE('2018-04-10', 'yyyy-MM-dd'), '삼성', 'E202');

CREATE TABLE sale_tbl_10(
    sale_seq NUMBER PRIMARY KEY,
	sale_date DATE,
	product_id NUMBER,
	sale_qty NUMBER,
	sale_price NUMBER,
	manager_id VARCHAR2(12)
);

INSERT INTO sale_tbl_10 VALUES (30001, TO_DATE('2018-09-04', 'yyyy-MM-dd'), 1004, 4, 12000, '홍길동');
INSERT INTO sale_tbl_10 VALUES (30002, TO_DATE('2018-09-05', 'yyyy-MM-dd'), 1003, 2, 5000, '김유신');
INSERT INTO sale_tbl_10 VALUES (30003, TO_DATE('2018-09-05', 'yyyy-MM-dd'), 1001, 1, 4000, '이기자');
INSERT INTO sale_tbl_10 VALUES (30004, TO_DATE('2018-09-06', 'yyyy-MM-dd'), 1002, 1, 35000, '이순신');
INSERT INTO sale_tbl_10 VALUES (30005, TO_DATE('2018-09-06', 'yyyy-MM-dd'), 1001, 4, 12000, '홍길동');
INSERT INTO sale_tbl_10 VALUES (30006, TO_DATE('2018-09-06', 'yyyy-MM-dd'), 1002, 3, 10500, '김유신');
INSERT INTO sale_tbl_10 VALUES (30007, TO_DATE('2018-09-07', 'yyyy-MM-dd'), 1003, 2, 5000, '이순신');
INSERT INTO sale_tbl_10 VALUES (30008, TO_DATE('2018-09-07', 'yyyy-MM-dd'), 1001, 5, 20000, '이기자');
INSERT INTO sale_tbl_10 VALUES (30009, TO_DATE('2018-09-07', 'yyyy-MM-dd'), 1002, 4, 14000, '김유신');
INSERT INTO sale_tbl_10 VALUES (30010, TO_DATE('2018-09-07', 'yyyy-MM-dd'), 1003, 4, 10000, '홍길동');

commit;