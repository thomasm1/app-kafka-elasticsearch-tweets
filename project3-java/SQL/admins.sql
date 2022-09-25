-- Table: public.admins

-- DROP TABLE public.admins;

CREATE TABLE IF NOT EXISTS public.admins
(
    admin_id character varying(50) COLLATE pg_catalog."default",
    user_name text COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.admins
    OWNER to admin1;