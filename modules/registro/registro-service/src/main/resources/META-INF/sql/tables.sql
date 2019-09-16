create table REG_Registro (
	registroId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userName VARCHAR(75) null,
	lastname VARCHAR(75) null,
	email VARCHAR(75) null,
	birthDate DATE null,
	createDate DATE null
);