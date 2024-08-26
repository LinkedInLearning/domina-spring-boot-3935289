INSERT INTO verdura (id, nombre, precio, troceable, owner) VALUES ('2001', 'Tomate H2 Test', '3.82', false, 'carmen');
INSERT INTO verdura (id, nombre, precio, troceable, owner) VALUES ('2002', 'Calabaza H2 Test', '4.82', true, 'carmen');
INSERT INTO verdura (id, nombre, precio, troceable, owner) VALUES ('2003', 'Lechuga H2 Test', '2.82', false, 'carmen');
 
INSERT INTO users (id, username, password, role, enabled) VALUES (2001, 'admin', '$2a$10$pktXnUlLW7EPtFNElALMsOLe9mNVquZGUmdRLqWSbnGTrqP0r2DQ2', 'ROLE_ADMIN', 1); -- password
INSERT INTO users (id, username, password, role, enabled) VALUES (2002, 'carmen', '$2a$10$ImPwXJsXWkvh7IZzG5jyAezLkVannAM5hdl99jVatqjZLZ7Q3we6G', 'ROLE_USER', 1); -- lechuguita123
-- contraseñas generadas con https://bcrypt-generator.com/
