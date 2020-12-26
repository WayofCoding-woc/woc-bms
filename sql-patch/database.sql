DROP DATABASE IF EXISTS woc_bms;
CREATE DATABASE woc_bms;
USE woc_bms;

CREATE TABLE city (
  id int(11) NOT NULL AUTO_INCREMENT,
  city_code varchar(255) NOT NULL UNIQUE,
  city_name varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL UNIQUE,
  name varchar(255) NOT NULL,
  mobile bigint(20) DEFAULT NULL,

  login_id varchar(255) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  created_date datetime(6) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE seat_category (
  id int(11) NOT NULL AUTO_INCREMENT,
  category_code varchar(255) NOT NULL UNIQUE,
  category_name varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE theatre (
  id int(11) NOT NULL AUTO_INCREMENT,
  theatre_code varchar(255) NOT NULL UNIQUE,
  theatre_name varchar(255) NOT NULL,
  city_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_theatre_city_id (city_id),
  CONSTRAINT fk_theatre_city_id FOREIGN KEY (city_id) REFERENCES city (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE show_time (
  id int(11) NOT NULL AUTO_INCREMENT,
  movie_name varchar(255) NOT NULL,
  show_time varchar(255) NOT NULL,
  theatre_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_show_time_theatre_id (theatre_id),
  CONSTRAINT fk_show_time_theatre_id FOREIGN KEY (theatre_id) REFERENCES theatre (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE seat (
  id int(11) NOT NULL AUTO_INCREMENT,
  seat_number varchar(255) NOT NULL,
  seat_category_id int(11) DEFAULT NULL,
  theatre_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_seat_category_id (seat_category_id),
  KEY fk_seat_theatre_id (theatre_id),
  CONSTRAINT fk_seat_category_id FOREIGN KEY (seat_category_id) REFERENCES seat_category (id),
  CONSTRAINT fk_seat_theatre_id FOREIGN KEY (theatre_id) REFERENCES theatre (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE seat_availability (
  id int(11) NOT NULL AUTO_INCREMENT,
  is_available bit(1) DEFAULT NULL,
  availability_date date NOT NULL,
  version bigint(20) DEFAULT 0,
  seat_id int(11) DEFAULT NULL,
  show_time_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_seat_availability_seat_id (seat_id),
  KEY fk_seat_availability_show_time_id (show_time_id),
  CONSTRAINT fk_seat_availability_seat_id FOREIGN KEY (seat_id) REFERENCES seat (id),
  CONSTRAINT fk_seat_availability_show_time_id FOREIGN KEY (show_time_id) REFERENCES show_time (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE ticket_booking (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  booking_date date NOT NULL,
  ticket_reference_number varchar(255) NOT NULL UNIQUE,
  customer_id int(11) DEFAULT NULL,
  seat_id int(11) DEFAULT NULL,
  show_time_id int(11) DEFAULT NULL,
  created_date datetime(6) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_ticket_booking_customer_id (customer_id),
  KEY fk_ticket_booking_seat_id (seat_id),
  KEY fk_ticket_booking_show_time_id (show_time_id),
  CONSTRAINT fk_ticket_booking_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
  CONSTRAINT fk_ticket_booking_seat_id FOREIGN KEY (seat_id) REFERENCES seat (id),
  CONSTRAINT fk_ticket_booking_show_time_id FOREIGN KEY (show_time_id) REFERENCES show_time (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
