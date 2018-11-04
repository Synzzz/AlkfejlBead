--ide jonnek majd a kezdo adatok


-- 1234 a pw
INSERT INTO user (id,name,username, password, role) values (1,'adminbacsi','admin', '$2a$10$KzjHavOxl1fjxXJDb22Q1OZsCNcW.f07lSyJsgjLck34ugGNRwoBO', 'ROLE_ADMIN');
INSERT INTO user (id,name,username, password, role) values (2,'Fradi Zoltan','fradi', '$2a$10$KzjHavOxl1fjxXJDb22Q1OZsCNcW.f07lSyJsgjLck34ugGNRwoBO', 'ROLE_ADMIN');
INSERT INTO user (id,name,username, password, role) values (3,'Neptun Peter','user', '$2a$10$KzjHavOxl1fjxXJDb22Q1OZsCNcW.f07lSyJsgjLck34ugGNRwoBO', 'ROLE_USER');
INSERT INTO user (id,name,username, password, role) values (4,'Maxpont Ferenc','user2', '$2a$10$KzjHavOxl1fjxXJDb22Q1OZsCNcW.f07lSyJsgjLck34ugGNRwoBO', 'ROLE_USER');


INSERT INTO SUBJECT (id,`NAME`) VALUES (1,'Analizis 5 EA');
INSERT INTO SUBJECT (id,`NAME`) VALUES (2,'Analizis 6 EA');
INSERT INTO SUBJECT (id,`NAME`) VALUES (3,'Analizis 7 EA');
INSERT INTO SUBJECT (id,`NAME`) VALUES (4,'Analizis 8 EA');
INSERT INTO SUBJECT (id,`NAME`) VALUES (5,'Analizis 9 EA');
INSERT INTO SUBJECT (id,`NAME`) VALUES (6,'OPRE EA');



INSERT INTO course (id,student_count,student_limit,subject_id,teacher_id) values (1,0,50,1,1);
INSERT INTO course (id,student_count,student_limit,subject_id,teacher_id) values (2,0,666,6,2);

INSERT INTO subject_registration (course_id,student_id) values (2,3);
INSERT INTO subject_registration (course_id,student_id) values (1,3);