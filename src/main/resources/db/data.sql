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

/*Create Job Seeker*/

insert into public.job_seekers (date_of_birth, first_name, last_name, gender,national_id,email, enabled,locked ,password,email_verify_id,role,phone)
VALUES ('10/6/1978', 'NESLIHAN', 'ZENGIN', 'WOMAN', '23480340824','1.userEmail1@example.com', true, false,'123456789', '1','USER',2562611),
       ('3/8/1949','SADET', 'YILDIRIM', 'WOMAN', '17111553172','2.userEmail1@example.com', true, true,'123456789', '1','USER',2562611);
      /* ('3/8/1949', 'SADET', 'YILDIRIM', 'WOMAN', '17111553172'),
       ('15/8/1987', 'GONUL', 'CETİN', 'WOMAN', '10499773538'),
       ('23/4/1983', 'MURAT', 'GENC', 'MAN', '35995199842');*/

/*Create Company*/

insert into public.company (company_name,website,email, is_active, password,email_verify_id,role,phone)
VALUES ('Name of company 1', 'www.company1.com', 'mail@company1.com', true, '123456789','2', 'USER',2562692);

/*Create User*/

/*insert into public.users (email, is_active, password,email_verify_id,role,job_seeker_id)
VALUES ('1.userEmail1@example.com', true, '123456789', '1','USER','1'),
       ('2.userEmail1@example.com', true, '123456789', '2','USER','2'),
       ('3.userEmail1@example.com', true, '123456789', '3','USER','3'),
       ('4.userEmail1@example.com', true, '123456789', '4','USER','4');
*/