CREATE TABLE public.user
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    login character varying COLLATE pg_catalog."default",
    pass character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    phone character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    ads character varying COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.user
    OWNER to postgres;