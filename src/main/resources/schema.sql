delete from person;
insert into person values (1);
insert into person values (2);
insert into person values (3);

delete from capability;
insert into capability (capability_id, description, name) values (default,'Capability Description 1', 'Capability 1');

delete from skill_general;
insert into skill_general (general_skill_id, general_skill_name, general_skill_description) values (default, 'General Skill 1', 'General Skill Description 1');
insert into skill_general (general_skill_id, general_skill_name, general_skill_description) values (default, 'General Skill 2', 'General Skill Description 2');
