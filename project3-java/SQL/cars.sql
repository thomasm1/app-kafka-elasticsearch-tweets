-- Table: public.cars

-- DROP TABLE public.cars;

CREATE TABLE IF NOT EXISTS public.cars
(
    car_id integer,
    color character varying(50) COLLATE pg_catalog."default",
    make character varying(50) COLLATE pg_catalog."default",
    model character varying(50) COLLATE pg_catalog."default",
    seats integer,
    car_year character varying(50) COLLATE pg_catalog."default",
    user_id character varying(50) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cars
    OWNER to admin1;