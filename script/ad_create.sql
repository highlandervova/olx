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

ALTER TABLE public.ad ADD COLUMN date TIMESTAMP;

UPDATE public.ad SET date=current_timestamp WHERE date IS NULL;

ALTER TABLE public.ad ADD COLUMN favor integer;

ALTER TABLE public.ad alter COLUMN date set NOT NULL;

update public.ad set pic=null;

ALTER TABLE public.ad ADD COLUMN pictypeNew   varchar;

ALTER TABLE public.ad drop column pic;

ALTER TABLE public.ad RENAME COLUMN pictypeNew to pictype;

ALTER TABLE public.AD ADD picture bytea;
