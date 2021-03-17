select * from ad a where lower(a.city) like ('k__v%') --for Kyiv
--update ad  set city  ='1'  where lower(city) like ('k__v%');
--commit ;--for example other cities


select * from ad a where lower(a.city) like ('o%d%s%a')
--update ad  set city  ='2'  where lower(city) like ('o%d%s%a');
--commit ;--for Odessa


