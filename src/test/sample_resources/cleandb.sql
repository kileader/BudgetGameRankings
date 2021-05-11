delete from user;
delete from wished_game;
delete from role;
delete from ranking_configuration;

alter table user auto_increment = 1;
alter table wished_game auto_increment = 1;
alter table role auto_increment = 1;
alter table ranking_configuration auto_increment = 1;

insert into user values (0, 'jcoyne', 'coynemcgoin@hotmail.com', 'supersecret1');
insert into user values (0, 'fhensen', 'scoobydoolover@yahoo.com', 'supersecret2');
insert into user values (0, 'bcurry', 'baconcurry@gmail.com', 'supersecret3');
insert into user values (0, 'kmack', 'mackattack@valdosta.edu', 'supersecret4');
insert into user values (0, 'dklein', 'inkleined@madisoncollege.edu', 'supersecret5');
insert into user values (0, 'dtillman', 'xxtillmanxx@hotmail.com', 'supersecret6');

insert into wished_game values (0, 1, "Valheim", 104967);
insert into wished_game values (0, 4, "Hades", 113112);
insert into wished_game values (0, 2, "Disco Elysium", 26472);
insert into wished_game values (0, 2, "Super Smash Bros. Ultimate", 90101);
insert into wished_game values (0, 1, "Super Mario 3D World + Bowser's Fury", 138227);
insert into wished_game values (0, 1, "Satisfactory", 90558);
insert into wished_game values (0, 5, "Sid Meier's Civilization III: Complete", 27820);
insert into wished_game values (0, 4, "Final Fantasy VII", 427);

insert into role values (0, 'admin', 1, 'jcoyne');
insert into role values (0, 'user', 2, 'fhensen');
insert into role values (0, 'user', 3, 'bcurry');
insert into role values (0, 'user', 4, 'kmack');
insert into role values (0, 'admin', 5, 'dklein');
insert into role values (0, 'user', 6, 'dtillman');

insert into ranking_configuration values (0, "Any Game for Past 5 Years", 1, "Any", "Any", 157784630);
insert into ranking_configuration values (0, "Any Game for Past 5 Years", 2, "Any", "Any", 157784630);
insert into ranking_configuration values (0, "Any Game for Past 5 Years", 3, "Any", "Any", 157784630);
insert into ranking_configuration values (0, "Any Game for Past 5 Years", 4, "Any", "Any", 157784630);
insert into ranking_configuration values (0, "Any Game for Past 5 Years", 5, "Any", "Any", 157784630);
insert into ranking_configuration values (0, "Any Game for Past 5 Years", 6, "Any", "Any", 157784630);