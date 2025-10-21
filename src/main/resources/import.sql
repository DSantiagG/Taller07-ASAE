INSERT INTO persona (dtype,id, nombre, apellido, correo,identificacion) VALUES ('DocenteEntity',1, 'Ana', 'Gonzalez', 'ana.gonzalez@example.com','10026547458');
INSERT INTO persona (dtype,id, nombre, apellido, correo,identificacion) VALUES ('DocenteEntity',2, 'Luis', 'Martinez', 'luis.martinez@example.com','10026547459');
INSERT INTO persona (dtype,id, nombre, apellido, correo,identificacion) VALUES ('DocenteEntity',3, 'Maria', 'Lopez', 'maria.lopez@example.com','10026547460');

INSERT INTO espacio_fisico (id, nombre, ubicacion,estado, capacidad,tipo) VALUES (1, 'Aula 101', 'Edificio A', true, 30,'SALON');
INSERT INTO espacio_fisico (id, nombre, ubicacion,estado, capacidad,tipo) VALUES (2, 'Laboratorio 202', 'Edificio B', true, 20,'LABORATORIO');
INSERT INTO espacio_fisico (id, nombre, ubicacion,estado, capacidad,tipo) VALUES (3, 'Auditorio Principal', 'Edificio C', true, 100,'AUDITORIO');

INSERT INTO asignatura (id, nombre, codigo, numeroCreditos) VALUES (1, 'Programacion Orientada a Objetos', 'MAT101', 4);
INSERT INTO asignatura (id, nombre, codigo, numeroCreditos) VALUES (2, 'Estructuras de Datos', 'MAT102', 4);
INSERT INTO asignatura (id, nombre, codigo, numeroCreditos) VALUES (3, 'Bases de Datos', 'MAT103', 4);

INSERT INTO curso (id, nombre, cupo, asignatura_id) VALUES (1, 'A', 30, 1);
INSERT INTO curso (id, nombre, cupo, asignatura_id) VALUES (2, 'B', 25, 2);
INSERT INTO curso (id, nombre, cupo, asignatura_id) VALUES (3, 'C', 20, 3);

INSERT INTO curso_docente (curso_id, docente_id) VALUES (1, 1);
INSERT INTO curso_docente (curso_id, docente_id) VALUES (1, 2);
INSERT INTO curso_docente (curso_id, docente_id) VALUES (2, 3);

INSERT INTO franja_horaria (id, dia, hora_inicio, hora_fin, curso_id, espacio_fisico_id) VALUES (1, 'LUNES', '08:00:00', '10:00:00', 1, 1);