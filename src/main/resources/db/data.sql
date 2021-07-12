/*Create Job Categories*/
insert into public.job_categories ("title", "description")
VALUES ('Cateogry 1', 'Description of Cateogry 1'),
       ('Cateogry 2', 'Description of Cateogry 2'),
       ('Cateogry 3', 'Description of Cateogry 3'),
       ('Cateogry 4', 'Description of Cateogry 4'),
       ('Cateogry 5', 'Description of Cateogry 5');

/*Create Jobs*/
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (1, '1.job of category 1', 'Description of Job 1'),
       (1, '2.job of category 1', 'Description of Job 2'),
       (1, '3.job of category 1', 'Description of Job 3'),
       (1, '4.job of category 1', 'Description of Job 4'),
       (2, '1.job of category 2', 'Description of Job 1'),
       (2, '2.job of category 2', 'Description of Job 2'),
       (2, '3.job of category 2', 'Description of Job 3'),
       (2, '4.job of category 2', 'Description of Job 4'),
       (3, '1.job of category 3', 'Description of Job 1'),
       (3, '2.job of category 3', 'Description of Job 2'),
       (3, '3.job of category 3', 'Description of Job 3'),
       (3, '4.job of category 3', 'Description of Job 4'),
       (4, '1.job of category 4', 'Description of Job 1'),
       (4, '2.job of category 4', 'Description of Job 2'),
       (4, '3.job of category 4', 'Description of Job 3'),
       (4, '4.job of category 4', 'Description of Job 4'),
       (5, '1.job of category 5', 'Description of Job 1'),
       (5, '2.job of category 5', 'Description of Job 2'),
       (5, '3.job of category 5', 'Description of Job 3'),
       (5, '4.job of category 5', 'Description of Job 4');


/*Create User*/

insert into public.users (email, is_active, pass,email_verify_id,role)
VALUES ('1.userEmail1@example.com', true, '123456789', '1',
        'user');

/*Create Job Seeker*/

insert into public.job_seekers (date_of_birth, first_name, last_name, gender,national_id, user_id)
VALUES ('2/10/1947', 'DENEME', 'SOYADI', 'MAN', '123456789','1');
       /*
       ('2.userEmail1@example.com', true, '123456789', '1984/05/05', '2.User First Name',
        '2.User Last Name', 'WOMAN', null, '12345678998', 'USER'),
       ('3.userEmail1@example.com', true, '123456789', '1984/05/05', '3.User First Name',
        '3.User Last Name', 'WOMAN', null, '12345678978', 'USER'),
       ('4.userEmail1@example.com', true, '123456789', '1984/05/05', '4.User First Name',
        '4.User Last Name', 'WOMAN', null, '12345678947', 'USER'),
       ('5.userEmail1@example.com', true, '123456789', '1984/05/05', '5.User First Name',
        '5.User Last Name', 'WOMAN', null, '12345678996', 'USER'),
       ('6.userEmail1@example.com', true, '123456789', '1984/05/05', '6.User First Name',
        '6.User Last Name', 'WOMAN', null, '12347678975', 'USER'),
       ('7.userEmail1@example.com', true, '123456789', '1984/05/05', '7.User First Name',
        '7.User Last Name', 'WOMAN', null, '12345678961', 'USER'),
       ('8.userEmail1@example.com', true, '123456789', '1984/05/05', '8.User First Name',
        '8.User Last Name', 'MAN', null, '12345678932', 'USER'),
       ('9.userEmail1@example.com', true, '123456789', '1984/05/05', '9.User First Name',
        '9.User Last Name', 'MAN', null, '12345678172', 'USER'),
       ('10.userEmail1@example.com', true, '123456789', '1984/05/05', '10.User First Name',
        '10.User Last Name', 'MAN', null, '12345678975', 'USER');
       */