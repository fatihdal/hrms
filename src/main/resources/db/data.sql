/*Create Job Categories*/
insert into public.job_categories ("title", "description")
VALUES ('Cateogry 1', 'Description of Cateogry 1');
insert into public.job_categories ("title", "description")
VALUES ('Cateogry 2', 'Description of Cateogry 2');
insert into public.job_categories ("title", "description")
VALUES ('Cateogry 3', 'Description of Cateogry 3');
insert into public.job_categories ("title", "description")
VALUES ('Cateogry 4', 'Description of Cateogry 4');
insert into public.job_categories ("title", "description")
VALUES ('Cateogry 5', 'Description of Cateogry 5');

/*Create Jobs*/
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (1, '1.job of category 1', 'Description of Job 1');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (1, '2.job of category 1', 'Description of Job 2');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (1, '3.job of category 1', 'Description of Job 3');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (1, '4.job of category 1', 'Description of Job 4');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (2, '1.job of category 2', 'Description of Job 1');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (2, '2.job of category 2', 'Description of Job 2');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (2, '3.job of category 2', 'Description of Job 3');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (2, '4.job of category 2', 'Description of Job 4');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (3, '1.job of category 3', 'Description of Job 1');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (3, '2.job of category 3', 'Description of Job 2');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (3, '3.job of category 3', 'Description of Job 3');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (3, '4.job of category 3', 'Description of Job 4');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (4, '1.job of category 4', 'Description of Job 1');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (4, '2.job of category 4', 'Description of Job 2');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (4, '3.job of category 4', 'Description of Job 3');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (4, '4.job of category 4', 'Description of Job 4');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (5, '1.job of category 5', 'Description of Job 1');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (5, '2.job of category 5', 'Description of Job 2');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (5, '3.job of category 5', 'Description of Job 3');
insert into public.jobs (job_category_id, job_title, job_description)
VALUES (5, '4.job of category 5', 'Description of Job 4');

/*Create Roles*/
insert into public.roles (role_name)
VALUES ('Admin');
insert into public.roles (role_name)
VALUES ('Staff');
insert into public.roles (role_name)
VALUES ('User');

/*Create Users*/
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('1.userEmail1@example.com', true, '123456789', '1984/05/05', '1.User First Name',
        '1.User Last Name', 'MAN', null, '12345678945', 1);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('2.userEmail1@example.com', true, '123456789', '1984/05/05', '2.User First Name',
        '2.User Last Name', 'WOMAN', null, '12345678998', 1);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('3.userEmail1@example.com', true, '123456789', '1984/05/05', '3.User First Name',
        '3.User Last Name', 'WOMAN', null, '12345678978', 2);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('4.userEmail1@example.com', true, '123456789', '1984/05/05', '4.User First Name',
        '4.User Last Name', 'WOMAN', null, '12345678947', 3);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('5.userEmail1@example.com', true, '123456789', '1984/05/05', '5.User First Name',
        '5.User Last Name', 'WOMAN', null, '12345678996', 3);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('6.userEmail1@example.com', true, '123456789', '1984/05/05', '6.User First Name',
        '6.User Last Name', 'WOMAN', null, '12347678975', 3);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('7.userEmail1@example.com', true, '123456789', '1984/05/05', '7.User First Name',
        '7.User Last Name', 'WOMAN', null, '12345678961', 3);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('8.userEmail1@example.com', true, '123456789', '1984/05/05', '8.User First Name',
        '8.User Last Name', 'MAN', null, '12345678932', 3);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('9.userEmail1@example.com', true, '123456789', '1984/05/05', '9.User First Name',
        '9.User Last Name', 'MAN', null, '12345678172', 3);
insert into public.job_seekers (user_email, is_active, pass, date_of_birth, first_name, last_name, gender,
                                email_verify_id, national_id, role_id)
VALUES ('10.userEmail1@example.com', true, '123456789', '1984/05/05', '10.User First Name',
        '10.User Last Name', 'MAN', null, '12345678975', 3);