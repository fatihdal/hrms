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
    id        INT GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    role_name CHARACTER VARYING NOT NULL UNIQUE,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id         INT GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    user_email CHARACTER VARYING     NOT NULL UNIQUE,
    role_id    INT                   NOT NULL,
    pass       CHARACTER VARYING(60) NOT NULL,
    is_active  BOOLEAN               NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE public.persons
(
    person_id     INT,
    first_name    CHARACTER VARYING(20) NOT NULL,
    last_name     CHARACTER VARYING(30) NOT NULL,
    date_of_birth TIMESTAMP             NOT NULL,
    gender        CHARACTER VARYING(5),
    CONSTRAINT pk_persons PRIMARY KEY (person_id),
    CONSTRAINT fk_person_id FOREIGN KEY (person_id)
        REFERENCES public.users (id)
        ON DELETE CASCADE
);

CREATE TABLE public.staff
(
    staff_id INT,
    CONSTRAINT pk_staffs PRIMARY KEY (staff_id),
    CONSTRAINT fk_staff_id FOREIGN KEY (staff_id)
        REFERENCES public.persons (person_id)
        ON DELETE CASCADE
);

CREATE TABLE public.job_seekers
(
    job_seeker_id   INT,
    national_id     CHARACTER VARYING(11) NOT NULL UNIQUE,
    email_verify_id INT                   NOT NULL,
    CONSTRAINT pk_job_seekers PRIMARY KEY (job_seeker_id),
    CONSTRAINT fk_job_seekers_users FOREIGN KEY (job_seeker_id)
        REFERENCES public.persons (person_id)
        ON DELETE CASCADE
);

CREATE TABLE public.companies
(
    company_id      INT,
    staff_verify_id INT                   NOT NULL,
    email_verify_id INT                   NOT NULL,
    company_name    character varying(60) NOT NULL UNIQUE,
    phone           character varying(20) NOT NULL,
    website         character varying(60) NOT NULL,
    CONSTRAINT pk_companies PRIMARY KEY (company_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id)
        REFERENCES public.users (id)
        ON DELETE CASCADE
);

CREATE TABLE public.verifications
(
    id           INT     NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    is_confirmed BOOLEAN NOT NULL,
    CONSTRAINT pk_verifications PRIMARY KEY (id)
);

CREATE TABLE public.staff_verifications
(
    staff_verification_id INT,
    verified_staff_id     INT  NOT NULL,
    verify_date           DATE NOT NULL,
    CONSTRAINT pk_staff_verifications PRIMARY KEY (staff_verification_id),
    CONSTRAINT fk_staff_verification_id FOREIGN KEY (staff_verification_id)
        REFERENCES public.verifications (id)
        ON DELETE CASCADE
);

CREATE TABLE public.email_verifications
(
    email_verify_id   INT,
    verification_code CHARACTER VARYING(60) NOT NULL UNIQUE,
    code_date         DATE                  NOT NULL,
    CONSTRAINT pk_email_verifications PRIMARY KEY (email_verify_id),
    CONSTRAINT fk_email_verification_id FOREIGN KEY (email_verify_id)
        REFERENCES public.verifications (id)
        ON DELETE CASCADE
);

CREATE TABLE public.job_categories
(
    id          INT                   NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    title       CHARACTER VARYING(20) NOT NULL UNIQUE,
    description CHARACTER VARYING(50) NOT NULL,
    CONSTRAINT pk_job_categories PRIMARY KEY (id)
);

CREATE TABLE public.jobs
(
    id              INT                   NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2444444 CACHE 1 ),
    job_category_id INT                   NOT NULL,
    job_title       CHARACTER VARYING(30) NOT NULL UNIQUE,
    job_description CHARACTER VARYING(50) NOT NULL,
    CONSTRAINT pk_jobs PRIMARY KEY (id),
    CONSTRAINT fk_job_category_id FOREIGN KEY (job_category_id)
        REFERENCES public.job_categories (id)
        ON DELETE CASCADE
);

--
-- PostgreSQL database dump complete
--