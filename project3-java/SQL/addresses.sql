-- Table: public.addresses

-- DROP TABLE public.addresses;

CREATE TABLE IF NOT EXISTS public.addresses
(
    address_id integer NOT NULL DEFAULT nextval('addresses_address_id_seq'::regclass),
    city character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    zip character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT addresses_pkey PRIMARY KEY (address_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.addresses
    OWNER to admin1;