select * from users;
delete from users where username = '1';
delete from users where username LIKE 'x%';
alter table users add constraint unique_username unique(username);
alter table users disable constraint unique_username;
alter table users enable constraint unique_username;

ALTER table users MODIFY  username varchar2(60);
DELETE from users where username LIKE 'rand%';
DELETE FROM users WHERE username = 'random_user25.0';
ALTER TABLE users MODIFY username VARCHAR2(60) NULL;
commit;
rollback;