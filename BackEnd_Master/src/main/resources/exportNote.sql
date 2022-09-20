--------------------------------------------------------
--  File created - Friday-November-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table NOTE
--------------------------------------------------------

  CREATE TABLE "THOMAS"."NOTE" 
   (	"N_ID" NUMBER(10,0), 
	"A_ID" NUMBER(10,0), 
	"P_ID" NUMBER(10,0), 
	"N_MESSAGE" VARCHAR2(4000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into THOMAS.NOTE
SET DEFINE OFF;
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (279,278,72,'Received ice for toe problems.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (21,21,61,'Was very well-behaved for an attack dog. Would treat again.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (22,22,62,'Required a muzzle and sedatives. Would not treat again.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (23,23,63,'Recommend diet of carrots and celery.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (24,24,64,'Is now 3 lbs overweight. Recommend Crossfit.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (25,25,65,'Exhibited hissing, clawing, biting, and looking mean. All healthy cat behavior.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (26,26,66,'Was very well-behaved for an attack cat. Would treat again.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (27,27,67,'Not the most photogenic cat.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (28,28,68,'Recommend eating less lasagna.');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (271,270,76,'He is a hypo-condree-act');
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (164,101,16,null);
Insert into THOMAS.NOTE (N_ID,A_ID,P_ID,N_MESSAGE) values (165,101,16,null);
--------------------------------------------------------
--  DDL for Index SYS_C004298
--------------------------------------------------------

  CREATE UNIQUE INDEX "THOMAS"."SYS_C004298" ON "THOMAS"."NOTE" ("N_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table NOTE
--------------------------------------------------------

  ALTER TABLE "THOMAS"."NOTE" ADD PRIMARY KEY ("N_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
