-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    h_address character varying(50) COLLATE pg_catalog."default",
    h_city character varying(50) COLLATE pg_catalog."default",
    h_zip character varying(50) COLLATE pg_catalog."default",
    h_state character varying(50) COLLATE pg_catalog."default",
    is_driver boolean,
    is_active boolean,
    is_accepting_rides boolean,
    last_name character varying(50) COLLATE pg_catalog."default",
    phone_number character varying(50) COLLATE pg_catalog."default",
    user_name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    w_address character varying(50) COLLATE pg_catalog."default",
    w_city character varying(50) COLLATE pg_catalog."default",
    w_zip character varying(50) COLLATE pg_catalog."default",
    w_state character varying(50) COLLATE pg_catalog."default",
    batch_number integer,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT usersbatches FOREIGN KEY (batch_number)
        REFERENCES public.batches (batch_number) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to admin1;