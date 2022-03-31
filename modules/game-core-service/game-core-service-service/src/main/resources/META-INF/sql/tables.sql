create table ReactGame_Ability (
	uuid_ VARCHAR(75) null,
	abilityId LONG not null primary key,
	abilityName VARCHAR(75) null,
	healing BOOLEAN,
	hitPoints INTEGER
);

create table ReactGame_Enemy (
	uuid_ VARCHAR(75) null,
	enemyId LONG not null primary key,
	enemyName VARCHAR(75) null,
	level INTEGER,
	hitPoints INTEGER,
	xpDrop INTEGER,
	imageURL VARCHAR(75) null
);

create table ReactGame_Player (
	uuid_ VARCHAR(75) null,
	playerId LONG not null primary key,
	userId LONG,
	playerName VARCHAR(75) null,
	level INTEGER,
	xpPoints INTEGER,
	hitPoints INTEGER
);

create table ReactGame_PlayerEnemyAbility (
	uuid_ VARCHAR(75) null,
	playerEnemyAbilityId LONG not null primary key,
	enemy BOOLEAN,
	playerOrEnemyId LONG,
	abilityId LONG
);