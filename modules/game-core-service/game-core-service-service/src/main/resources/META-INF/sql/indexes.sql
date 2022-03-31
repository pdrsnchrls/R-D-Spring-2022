create index IX_588783 on ReactGame_Ability (abilityName[$COLUMN_LENGTH:75$]);
create index IX_F5F8B9F2 on ReactGame_Ability (uuid_[$COLUMN_LENGTH:75$]);

create index IX_7AAA443 on ReactGame_Enemy (enemyName[$COLUMN_LENGTH:75$]);
create index IX_E1BCD4 on ReactGame_Enemy (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E3EE304F on ReactGame_Player (userId);
create index IX_A7DD7AFF on ReactGame_Player (uuid_[$COLUMN_LENGTH:75$]);

create index IX_27AE171D on ReactGame_PlayerEnemyAbility (uuid_[$COLUMN_LENGTH:75$]);