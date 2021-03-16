CREATE TABLE public.city
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default",

    CONSTRAINT city_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.city
    OWNER to postgres;