

INSERT INTO public.ad (id,"name",descr,pic,price,userid,city,phone,email,rubric) VALUES
('1','lexusCT200h','good car ',
 'http://piccy.info/view3/14184985/92ebaaba08b769a2024dba08b8f01fdf/1200/',12000,
 (select id FROM public."user" order by id desc limit 1),'1','+36889','test',1),
    ('2','CROSS_2016rx','cross car ',
    'http://piccy.info/view3/14184984/6d04fa963bd15903b3b2073494476dbf',10000,
    (select id FROM public."user" order by id desc limit 1),'1','+36889','test',1),
    ('3','Sedan_LexusIS300','sedan ',
    'http://piccy.info/view3/14184986/ff09521e4b453c6e1d7cd58b582df74c/1200/',10000,
    (select id FROM public."user" order by id desc limit 1),'2','+36889','test2',1);

commit;