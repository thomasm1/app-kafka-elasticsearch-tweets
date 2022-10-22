--------------------------------------------------------
--  File created - Friday-November-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "THOMAS"."CUSTOMER" 
   (	"C_ID" NUMBER(10,0), 
	"FNAME" VARCHAR2(50 BYTE), 
	"LNAME" VARCHAR2(50 BYTE), 
	"PHONE" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"PASS" VARCHAR2(20 BYTE), 
	"CUS_URL" VARCHAR2(500 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into THOMAS.CUSTOMER
SET DEFINE OFF;
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (275,'John','Doeson','225-555-5555','customer56@gmail.com','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p7.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (1,'Michael','Scott','888-888-8888','customer1@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p1.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (267,'Jain','Johnson','225-555-5555','customer40@gmail.com','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p7.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (2,'Dwight','Schrute','999-999-9999','customer2@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p2.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (3,'Jan','Levinson (no Gould)','111-111-1111','customer3@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p3.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (4,'Jim','Halpert','222-222-2222','customer4@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p4.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (5,'Pam','Beasley','777-777-7777','customer5@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p5.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (6,'Ryan','Howard','333-333-3333','customer6@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p6.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (7,'Kevin','Malone','444-444-4444','customer7@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p7.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (8,'Kelly','Kapoor','555-555-5555','customer8@gmail.com','password','https://doggywood.s3.amazonaws.com/assets/People/random_p8.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (272,'Brenda','Brendanson','225-555-5555','customer48@gmail.com','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p7.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (33,'cyndi','gleason','404-444-4455','cust','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p2.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (105,'a','a','1','a','a','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p8.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (141,'thomas','maestas','5055087707','thomas.maestas@hotmail.com','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p3.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (61,'february18','feb2020','505-555-5555','customer69@gmail.com','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p7.png');
Insert into THOMAS.CUSTOMER (C_ID,FNAME,LNAME,PHONE,EMAIL,PASS,CUS_URL) values (102,'newclient','pasteur','555555','newclient','password','https://doggywood-veterinary.s3.amazonaws.com/assets/People/random_p7.png');
--------------------------------------------------------
--  DDL for Index SYS_C004295
--------------------------------------------------------

  CREATE UNIQUE INDEX "THOMAS"."SYS_C004295" ON "THOMAS"."CUSTOMER" ("C_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CUS_EMAIL
--------------------------------------------------------

  CREATE UNIQUE INDEX "THOMAS"."CUS_EMAIL" ON "THOMAS"."CUSTOMER" ("EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "THOMAS"."CUSTOMER" ADD PRIMARY KEY ("C_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "THOMAS"."CUSTOMER" ADD CONSTRAINT "CUS_EMAIL" UNIQUE ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
