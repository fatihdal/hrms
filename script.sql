--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


SET default_tablespace = '';

SET default_with_oids = false;

---
--- drop tables
---

DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS job_categories;
DROP TABLE IF EXISTS job_seekers;
DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS email_verifications;
DROP TABLE IF EXISTS staff_verifications;
DROP TABLE IF EXISTS staff;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS verifications;
DROP TABLE IF EXISTS roles;


CREATE TABLE public.roles
(
    id        integer           NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    role_name character varying NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id        integer               NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    role_id   integer               NOT NULL,
    email     character varying     NOT NULL UNIQUE,
    pass      character varying(60) NOT NULL,
    is_active boolean               NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_seekers
(
    job_seeker_id   integer               NOT NULL,
    email_verify_id integer               NOT NULL,
    national_id     character varying(11) NOT NULL UNIQUE,
    gender          "char",
    PRIMARY KEY (job_seeker_id)
);

CREATE TABLE public.persons
(
    person_id  integer               NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name  character varying(30) NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE public.companies
(
    company_id      integer               NOT NULL,
    staff_verify_id integer               NOT NULL,
    email_verify_id integer               NOT NULL,
    company_name    character varying(60) NOT NULL UNIQUE,
    phone           character varying(20) NOT NULL,
    website         character varying(60) NOT NULL,
    PRIMARY KEY (company_id)
);

CREATE TABLE public.staff
(
    staff_id integer NOT NULL,
    PRIMARY KEY (staff_id)
);

CREATE TABLE public.email_verifications
(
    email_verify_id   integer               NOT NULL,
    verification_code character varying(60) NOT NULL,
    code_date         date                  NOT NULL,
    PRIMARY KEY (email_verify_id)
);

CREATE TABLE public.staff_verifications
(
    staff_verify_id   integer NOT NULL,
    verified_staff_id integer NOT NULL,
    verify_date       date    NOT NULL,
    PRIMARY KEY (staff_verify_id)
);

CREATE TABLE public.verifications
(
    id           integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    is_comfirmed "char"  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.jobs
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    job_category_id integer NOT NULL,
    job_name character varying(20) NOT NULL UNIQUE,
    job_description character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_categories
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    title character varying(20) NOT NULL UNIQUE ,
    description character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.persons
    ADD FOREIGN KEY (person_id)
        REFERENCES public.users (id)
        NOT VALID;


ALTER TABLE public.users
    ADD FOREIGN KEY (role_id)
        REFERENCES public.roles (id)
        NOT VALID;


ALTER TABLE public.companies
    ADD FOREIGN KEY (company_id)
        REFERENCES public.users (id)
        NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (job_seeker_id)
        REFERENCES public.persons (person_id)
        NOT VALID;


ALTER TABLE public.staff
    ADD FOREIGN KEY (staff_id)
        REFERENCES public.persons (person_id)
        NOT VALID;


ALTER TABLE public.email_verifications
    ADD FOREIGN KEY (email_verify_id)
        REFERENCES public.verifications (id)
        NOT VALID;


ALTER TABLE public.staff_verifications
    ADD FOREIGN KEY (staff_verify_id)
        REFERENCES public.verifications (id)
        NOT VALID;


ALTER TABLE public.staff_verifications
    ADD FOREIGN KEY (verified_staff_id)
        REFERENCES public.staff (staff_id)
        NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (email_verify_id)
        REFERENCES public.email_verifications (email_verify_id)
        NOT VALID;


ALTER TABLE public.companies
    ADD FOREIGN KEY (staff_verify_id)
        REFERENCES public.staff_verifications (staff_verify_id)
        NOT VALID;


ALTER TABLE public.companies
    ADD FOREIGN KEY (email_verify_id)
        REFERENCES public.email_verifications (email_verify_id)
        NOT VALID;

INSERT INTO "public"."job_categories" (title,description) VALUES('Engineering','Descriptions');
INSERT INTO "public"."job_categories" (title,description) VALUES('Advertising','Descriptions');

INSERT INTO "public"."jobs" (job_category_id,job_name,job_description) VALUES(1,'Software Developer','computer');
INSERT INTO "public"."jobs" (job_category_id,job_name,job_description) VALUES(2,'Advertise','advertise');

--
-- PostgreSQL database dump complete
--