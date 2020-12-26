INSERT INTO city VALUES (1,'BLR','Bangalore'),(2,'CHE','Chennai'),(3,'KOL','Kolkatta'),(4,'PAT','Patna');
INSERT INTO city(id, city_code, city_name) values(5, 'DEL', 'DELHI');

INSERT INTO theatre(id,theatre_code,theatre_name,city_id) VALUES (1,'GPL','Gopalan Cinema', 1);
INSERT INTO theatre(id,theatre_code,theatre_name,city_id) VALUES (2,'LXM','Laxmi', 1);
INSERT INTO theatre(id,theatre_code,theatre_name,city_id) VALUES (3,'MMBS1','Mantri-Mall-Screen-1', 1);
INSERT INTO theatre(id,theatre_code,theatre_name,city_id) VALUES (4,'GPMS3','Gopalan-Mall-PVR-Screen-3', 1);
INSERT INTO theatre(id,theatre_code,theatre_name,city_id) VALUES (5,'BPS2','Brigade-PVR-S2', 3);
INSERT INTO theatre(id,theatre_code,theatre_name,city_id) VALUES (6,'MMDS2','Mantri-Mall-S2', 2);

INSERT INTO seat_category(id, category_code, category_name) values(1, 'NORMAL',	'Normal');
INSERT INTO seat_category(id, category_code, category_name) values(2, 'SILVER',	'Silver');
INSERT INTO seat_category(id, category_code, category_name) values(3, 'GOLD',	'Gold');

INSERT INTO show_time(id, show_time, movie_name, theatre_id) values(1, '9am-12pm', 'Dream Girl', 4);
INSERT INTO show_time(id, show_time, movie_name, theatre_id) values(2, '12pm-3pm', 'Challang', 4);
INSERT INTO show_time(id, show_time, movie_name, theatre_id) values(3, '3pm-6pm', 'Lion King', 4);
INSERT INTO show_time(id, show_time, movie_name, theatre_id) values(4, '6pm-9pm', 'DDLG', 4);
INSERT INTO show_time(id, show_time, movie_name, theatre_id) values(5, '3pm-6pm', 'DDLG', 6);


INSERT INTO seat(id, theatre_id, seat_number, seat_category_id) values(1,4,'N1',1);
INSERT INTO seat(id, theatre_id, seat_number, seat_category_id) values(2,4,'N6',1);
INSERT INTO seat(id, theatre_id, seat_number, seat_category_id) values(3,4,'S4',2);
INSERT INTO seat(id, theatre_id, seat_number, seat_category_id) values(4,4,'G1',3);
INSERT INTO seat(id, theatre_id, seat_number, seat_category_id) values(5,4,'G2',3);
INSERT INTO seat(id, theatre_id, seat_number, seat_category_id) values(6,4,'N2',1);

INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(1,false,'2020-12-01',1, 3);
INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(2,true,'2020-12-01',2, 3);
INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(3,false,'2020-12-01',3, 3);
INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(4,true,'2020-12-01',4, 3);
INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(5,false,'2020-12-01',5, 3);
INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(6,false,'2020-12-01',6, 3);
INSERT INTO seat_availability(id,is_available,availability_date,seat_id,show_time_id) values(7,false,'2020-12-01',2, 2);









