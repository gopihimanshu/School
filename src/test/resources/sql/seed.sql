use studenttest;

TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;

INSERT INTO students (email) VALUES
  ('hkums@allstate.com');

insert into klasses (credits, department, fee, name, semester) values
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00'),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00'),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00');

INSERT INTO teachers (name, age, gender) values
  ('Andreas',32,'MALE'),
  ('Chyld', 40, 'MALE'),
  ('Nathan', 29, 'MALE'),
  ('Swarna', 23, 'FEMALE');