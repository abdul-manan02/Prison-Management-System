use PMS;

CREATE TABLE Prisoners
(
	id int primary key,
	pass varchar(20),
    prisonerName varchar(45),
    blockNo int,
    roomNo int,
    dateOfEnrollment varchar(45),
    crimeCommitted varchar(45),
    
    jobTitle varchar(45),
    jobPay int,
	jobChangeRequest BOOLEAN,
    jobAppliedFor varchar(45),
    
    cellChangeRequest BOOLEAN,
    cellChangeReason varchar(45),
    cellChangeTo int,
    
    meetingRequest BOOLEAN,
    meetingTime varchar(45),
    
    itemRequest BOOLEAN,
    itemType varchar(45)	
);

CREATE TABLE Heads
(
	serviceNumber int primary key,
    username varchar(45),
    pass varchar(45),
    designatedBlock int
);

CREATE TABLE Staff
(
	id int primary key,
	designatedBlock int,
	designatedJob varchar(45),
    pay int,
    dateOfEnrollment varchar(45)
);

Create TABLE CellChange_Record
(
	prisonerId int,
    reason varchar(45),
    permission boolean,
    oldRoomNo int,
    newRoomNo int 
);

CREATE TABLE Meeting_Record
(
	prisonerID int,
    meetingTime varchar(45),
    permission boolean
);

CREATE TABLE Items_Record
(
	prisonerId int,
    itemType varchar(45),
    permission boolean
);

CREATE TABLE Time_Table
(
	weekNo int primary key,
    wakeUp_Time varchar(45),
    outdoor_Time varchar(45),
    lightsOut_Time varchar(45)
);

Select * from Prisoners;		
Select * from Heads;
Select * from Staff;
Select * from CellChange_Record;
Select * from Meeting_Record;
Select * from Items_Record;
Select * from Time_Table;