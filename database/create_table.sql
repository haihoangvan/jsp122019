use jspservlet122019;

CREATE TABLE role (
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL, 
	code VARCHAR(255) NOT NULL
)

CREATE TABLE user (
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL, 
	fullname VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
)

CREATE TABLE user_role (
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userid bigint NOT NULL, 
	roleid bigint NOT NULL
)

ALTER TABLE user_role ADD FOREIGN KEY (userid) REFERENCES user(id);
ALTER TABLE user_role ADD FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE building (
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NULL,
	ward VARCHAR(255) NULL,
	street VARCHAR(255) NULL,
	structure VARCHAR(100) NULL,
	namberofbasement INT NULL,
	floorarea INT NULL,
	direction VARCHAR(255) NULL,
	level VARCHAR(255) NULL,
	rentareadescription TEXT NULL,
	rentcost VARCHAR(255) NULL,
	costdescription TEXT NULL,
	servicecost VARCHAR(255) NULL,
	carcost VARCHAR(255) NULL,
	motorcost VARCHAR(255) NULL,
	overtimecost VARCHAR(255) NULL,
	electricbill VARCHAR(255) NULL,
	deposit VARCHAR(255) NULL,
	payment VARCHAR(255) NULL,
	timedecorator VARCHAR(255) NULL,
	managername VARCHAR(255) NULL,
	manegerphone VARCHAR(255) NULL,
	district VARCHAR(255) NULL,
	type TEXT NULL
)

CREATE TABLE rentarea (
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
	value int NOT NULL, 
	buildingid bigint NOT NULL
)

ALTER TABLE rentarea ADD FOREIGN KEY (buildingid) REFERENCES building(id);

CREATE TABLE assignmentbuilding (
	id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
	staffid bigint NOT NULL, 
	buildingid bigint NOT NULL
)

ALTER TABLE assignmentbuilding ADD FOREIGN KEY (staffid) REFERENCES user(id);
ALTER TABLE assignmentbuilding ADD FOREIGN KEY (buildingid) REFERENCES building(id);




