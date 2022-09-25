-- Table: public.batches

-- DROP TABLE public.batches;

CREATE TABLE IF NOT EXISTS public.batches
(
    batch_number integer NOT NULL,
    batch_location character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT batches_pkey PRIMARY KEY (batch_number)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.batches
    OWNER to admin1;