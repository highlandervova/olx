CREATE TABLE IF NOT EXISTS public.message (
    id character varying COLLATE pg_catalog."default" NOT NULL,
    message character varying COLLATE pg_catalog."default",
    fromuserid character varying COLLATE pg_catalog."default",
    touserid character varying COLLATE pg_catalog."default",
    adid character varying COLLATE pg_catalog."default",
    ts date,
    CONSTRAINT message_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

ALTER TABLE public.message
    OWNER to postgres;