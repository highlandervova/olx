CREATE TABLE public.ad
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default",
    descr character varying COLLATE pg_catalog."default",
    pic character varying COLLATE pg_catalog."default",
    price integer,
    userid character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    phone character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    rubric integer,
    CONSTRAINT ad_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

 ALTER TABLE public.ad
    OWNER to postgres;

ALTER TABLE ad ADD COLUMN date TIMESTAMP