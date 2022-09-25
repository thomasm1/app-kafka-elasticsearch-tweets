-- select * from admins;
-- update admins SET user_name='admin1' WHERE admin_id = '101';
-- insert into admins values(1, 'admin1');
-- delete from admins WHERE user_name='admin1';

--  select * from cars;


-- ALTER TABLE public.batches DROP CONSTRAINT  batches_pkey cascade;
-- ALTER TABLE public.users DROP CONSTRAINT fk1m32c5mv3u88kf1og2yabmhxh;
-- drop TABLE users cascade;

-- CREATE TABLE users ( user_id integer  PRIMARY KEY, email VARCHAR (50) NOT NULL,
--     first_name VARCHAR (50) NOT NULL,
-- 	h_address VARCHAR (50) ,
-- 	h_city VARCHAR(50) ,
-- 	h_zip VARCHAR(50) ,
-- 	h_state VARCHAR(50) ,
-- 	is_driver BOOLEAN ,
-- 	is_active BOOLEAN,
-- 	is_accepting_rides BOOLEAN,
-- 	last_name VARCHAR(50),
-- 	phone_number VARCHAR(50),
--     user_name VARCHAR(50) NOT NULL,
-- 	w_address VARCHAR(50) ,
-- 	w_city VARCHAR(50) ,
-- 	w_zip VARCHAR(50) ,
-- 	w_state VARCHAR(50) ,
-- 	batch_number integer
-- );
--  ALTER TABLE  users    ADD CONSTRAINT usersbatches  FOREIGN KEY (batch_number)
--   REFERENCES public.batches (batch_number) MATCH SIMPLE    ON UPDATE NO ACTION    ON DELETE NO ACTION;
-- INSERT into users values
-- (1, 'gpichmann0@artisteer.com', 'Grady', '5 Carpenter Plaza', 'New York City', 'NY', '10275', false, false, false, 'Pichmann', '212-374-3466', 'gpichmann0', '30401 Esker Point', 'Des Moines', 'IA', '50347', 1),
-- (2, 'smigheli1@indiatimes.com', 'Salvidor', '6371 Elka Court', 'Columbus', 'OH', '43220', true, true, true, 'Migheli', '614-513-2776', 'smigheli1', '35747 3rd Park', 'Philadelphia', 'PA', '19131', 1),
-- (3, 'fbraunroth2@ebay.co.uk', 'Fabien', '830 Pierstorff Parkway', 'Omaha', 'NE', '68197', true, true, true, 'Braunroth', '402-694-8099', 'fbraunroth2', '747 Crownhardt Place', 'New York City', 'NY', '10270', 1),
-- (4, 'aocullen3@google.com.au', 'Aldon', '86978 Sage Junction', 'Elmira', 'NY', '14905', true, false, false, 'O''Cullen', '607-732-5313', 'aocullen3', '2 Killdeer Avenue', 'Norwalk', 'CT', '06859', 1),
-- (5, 'hgledhill4@hatena.ne.jp', 'Hilda', '496 High St', 'Morgantown', 'WV', '26505', true, true, true, 'Gledhill', '239-528-0279', 'hgledhill4', '45476 Oriole Drive', 'Winston Salem', 'NC', '27110', 1),
-- select * from users;
-- commit;

-- select * from batches;
-- select * from batches where batch_number=1;
-- update batches SET batch_location='Pittsburgh' WHERE batch_number=4;
-- Constraint: batches_pkey
-- ALTER TABLE public.batches DROP CONSTRAINT batches_pkey;
--  ALTER TABLE public.batches
  --  ADD CONSTRAINT batches_pkey PRIMARY KEY (batch_number);
