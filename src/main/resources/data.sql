delete  from userinfo;
delete  from role;
delete  from user_roles;

insert into userinfo(id,mobile_no,password,username)
values(1,'9654116888','arti','arti'),
(2,'9898989898','user1','test'),
(3,'123456789','mob','mob');

insert into role(id,role)
values(1,'user'),(2,'admin');

insert into user_roles(user_id,role_id)
values (1,2),(1,1);