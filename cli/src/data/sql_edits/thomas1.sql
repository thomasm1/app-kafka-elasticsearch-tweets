select * from users;
delete from users where username = '1';
delete from users where username LIKE 'x%';
alter table users add constraint unique_username unique(username);
alter table users disable constraint unique_username;
alter table users enable constraint unique_username;