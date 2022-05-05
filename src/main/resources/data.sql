insert into users( email, password, user_name) values ('admin@gmail.com','$2a$10$eejbPMwgHMHvJAaYv6lmL.SUtufKzhPIJgvmOE7b.ZJloVJI5ESD.','admin');
INSERT INTO roles(role_name) VALUES('ROLE_USER');
INSERT INTO roles(role_name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(role_name) VALUES('ROLE_ADMIN');
insert into user_roles(user_id, role_id) VALUES (1,1);
insert into user_roles(user_id, role_id) VALUES (1,2);