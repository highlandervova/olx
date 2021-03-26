CREATE TABLE public.rubric
(
    id integer  NOT NULL,
    name character varying COLLATE pg_catalog."default",

    CONSTRAINT rubric_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.rubric
    OWNER to postgres;