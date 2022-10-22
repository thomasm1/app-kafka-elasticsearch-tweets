--------------------------------------------------------
--  File created - Friday-November-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PET
--------------------------------------------------------

  CREATE TABLE "THOMAS"."PET" 
   (	"P_ID" NUMBER(10,0), 
	"C_ID" NUMBER(10,0), 
	"P_NAME" VARCHAR2(50 BYTE), 
	"P_WEIGHT" NUMBER(10,0), 
	"P_COLOR" VARCHAR2(50 BYTE), 
	"P_TYPE" NUMBER(10,0), 
	"P_BREED" VARCHAR2(30 BYTE), 
	"NEUTER" NUMBER(1,0) DEFAULT 0, 
	"P_DESCRIPTION" VARCHAR2(100 BYTE), 
	"PET_URL" VARCHAR2(500 BYTE), 
	"DOB" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into THOMAS.PET
SET DEFINE OFF;
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (76,61,'sss',0,null,0,null,0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (77,61,'45',0,null,0,null,0,'55',null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (78,61,'hry',0,null,0,null,0,'55','https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg',null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (79,4,'harry',0,'black',0,'siamese',0,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg',null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (80,4,'sara',0,null,0,null,0,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a4.jpg',null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (106,105,'aa',1,'aa',3,'aa',3,'a','https://doggywood.s3.amazonaws.com/assets/Animals/random_a7.jpg','2020-11-10');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (142,141,'bud',120,'brown',3,'terrier',2,'https://doggywood ','https://doggywood.s3.amazonaws.com/assets/Animals/random_a4.jpg','2020-11-08');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (143,141,'pet2',234,'white',2,'terrier2',4,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a7.jpg','2020-11-15');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (144,141,'pet3',23,'brown/black',2,'terrier3',2,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a5.jpg','2020-11-24');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (148,141,'pet4',23,'blue',0,'terrier',0,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a5.jpg',null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (149,141,'asasasasdf',23,'asasd',0,'asasasasdf',0,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg',null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (150,141,'pet7',23,'red',0,'terrier7',0,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg',null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (151,141,'pet8',44,'reddish',0,'terrier8',0,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a3.jpg','2020-11-11');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (153,141,'6',6,'6',0,'6',0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (157,141,'7',7,'7',0,'7',0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (162,141,'tryon',234,'black',3,'terrier',2,null,'https://doggywood.s3.amazonaws.com/assets/Animals/random_a4.jpg','2020-11-10');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (82,1,'randy',55,'black',1,'dog',2,'sick from Corona!','https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg','2020-07-09');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (2,1,'Mary Puppins',30,'Brown',1,'Bichon Frise',1,'Not an attractive breed. Has all 3 legs.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a4.jpg','2011-08-19');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (3,1,'Ozzy Pawsborne',15,'Black',2,'Bombay Cat',1,'Affinity for hunting bats.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a1.jpg','2009-11-14');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (4,2,'Winnie the Poodle',45,'Purple',1,'Poodle',1,'Was taught to do tricks for honey.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a5.jpg','2005-03-15');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (5,2,'Schrodinger',15,'Black',2,'Birman',1,'Lives under a box.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a6.jpg','2017-12-16');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (6,2,'Catrick Swayze',1000,'Black/Brown',2,'Russian Blue',0,'Likes to dance with ghosts.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a2.jpg','2016-07-17');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (7,3,'Sarah Jessica Barker',55,'Brown',1,'Border Collie',1,'Enjoys herding anything that moves.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a7.jpg','2017-04-18');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (8,3,'Picatso',8,'Black/White',2,'Manx Cat',1,'Unusual face shape.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg','2018-01-13');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (1,1,'Bark Twain',60,'Black',1,'Malinois',0,'Long haired with undercoat. Has 4 legs.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a9.jpg','2020-01-20');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (12,2,'Chewbarka',112,'Brown',1,'Chihuahua',1,'Swollen cranium with bulbous eyes. Has legs.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a4.jpg','2020-04-20');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (13,3,'Kareem Abdul Ja-Bark',35,'Brown',1,'Doberman',1,'Passive-aggressive with shifty eyes.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a5.jpg','2020-03-16');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (14,4,'Santa Paws',35,'White',1,'French Bulldog',0,'Narrow hips due to inbreeding. Tragic.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a7.jpg','2020-02-07');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (15,5,'Catrick Stewart',40,'Beige',2,'Sphinx',1,'Mostly hairless. Asker of riddles.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a1.jpg','2020-6-21');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (16,6,'Oprah Whisker',0,'White',2,'Siamese',0,'Separated from twin at birth.','https://doggywood.s3.amazonaws.com/assets/Animals/random_a2.jpg','2020-8-23');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (18,7,'Meowly Cyrus',20,'Tan',2,'Persian',1,'High ATK and SPD. Learns Slash at Lvl. 51','https://doggywood.s3.amazonaws.com/assets/Animals/random_a6.jpg','2020-07-15');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (19,8,'Garfield',2900,'Orange',2,'Mixed-Breed',0,'Lasagna vacuum','https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg','2020-09-11');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (103,102,'pesteur',22,'brown',3,'sheepish',2,'sdf','https://doggywood.s3.amazonaws.com/assets/Animals/random_a8.jpg','2020-10-15');
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (152,141,'9',9,'9',0,'9',0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (154,141,'3',3,'3',0,'3',0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (155,141,'33',3,'3',0,'33',0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (156,141,'33',3,'3',0,'33',0,null,null,null);
Insert into THOMAS.PET (P_ID,C_ID,P_NAME,P_WEIGHT,P_COLOR,P_TYPE,P_BREED,NEUTER,P_DESCRIPTION,PET_URL,DOB) values (158,141,'11',1,'11',0,'11',0,null,null,null);
--------------------------------------------------------
--  DDL for Index SYS_C004740
--------------------------------------------------------

  CREATE UNIQUE INDEX "THOMAS"."SYS_C004740" ON "THOMAS"."PET" ("P_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PET
--------------------------------------------------------

  ALTER TABLE "THOMAS"."PET" ADD PRIMARY KEY ("P_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
