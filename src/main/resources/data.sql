USE market;

INSERT INTO event (id, title, start_time, end_time, created_by, created_at)
VALUES (1, '타임딜 봄맞이 이벤트', NOW(), DATE_ADD(NOW(), INTERVAL 3 HOUR), 1, NOW());

INSERT INTO product (id, event_id, name, description, price, stock, created_at)
VALUES (101, 1, '무선 이어폰', '고음질 블루투스 이어폰', 129000, 3, NOW());