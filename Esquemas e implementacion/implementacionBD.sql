||﻿DROP TABLE IF EXISTS area CASCADE;
CREATE TABLE area
(
	codigo_area VARCHAR(30) PRIMARY KEY NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	descripcion VARCHAR(60)
);

DROP TABLE IF EXISTS cama CASCADE;
CREATE TABLE cama
(
	num_cama VARCHAR(30) PRIMARY KEY NOT NULL,
	descripcion VARCHAR(60), 
	codigo_area VARCHAR(30) NOT NULL,
	estado VARCHAR(15) NOT NULL,

	FOREIGN KEY (codigo_area) REFERENCES area (codigo_area)
);

DROP TABLE IF EXISTS persona CASCADE;
CREATE TABLE persona
(
	id_persona VARCHAR(30) PRIMARY KEY,
	nombre VARCHAR(60) NOT NULL,
	direccion VARCHAR(50),
	telefono VARCHAR(20)
);

DROP TABLE IF EXISTS historia_clinica CASCADE;
CREATE TABLE historia_clinica
(
	num_historia VARCHAR(30) PRIMARY KEY NOT NULL,
	fecha_apertura DATE NOT NULL
);

DROP TABLE IF EXISTS paciente CASCADE;
CREATE TABLE paciente
(
	id_persona VARCHAR(30) PRIMARY KEY NOT NULL,
	num_historia VARCHAR(30) NOT NULL,
	seguridad_social VARCHAR(30) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	actividad_economica VARCHAR(30),

	FOREIGN KEY (id_persona) REFERENCES persona (id_persona),
	FOREIGN KEY (num_historia) REFERENCES historia_clinica (num_historia)
);

DROP TABLE IF EXISTS asignada CASCADE;
CREATE TABLE asignada
(
	id_persona VARCHAR(30) NOT NULL,
	num_cama VARCHAR(30) NOT NULL,
	fecha DATE NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES paciente (id_persona),
	FOREIGN KEY (num_cama) REFERENCES cama (num_cama)
);

DROP TABLE IF EXISTS empleado CASCADE;
CREATE TABLE empleado
(
	id_persona VARCHAR(30) PRIMARY KEY NOT NULL,
	cargo VARCHAR(20) NOT NULL,
	salario FLOAT(30) NOT NULL,
	email VARCHAR(30) NOT NULL,
	codigo_area VARCHAR(30) NOT NULL,
	id_jefe VARCHAR(30) NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES persona (id_persona),
	FOREIGN KEY (codigo_area) REFERENCES area (codigo_area),
	FOREIGN KEY (id_jefe) REFERENCES empleado (id_persona)
);

DROP TABLE IF EXISTS agenda CASCADE;
CREATE TABLE agenda
(
	num_agenda VARCHAR(30) PRIMARY KEY NOT NULL,
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	disponibilidad CHAR(2) NOT NULL
);

DROP TABLE IF EXISTS medico CASCADE;
CREATE TABLE medico
(
	id_persona VARCHAR(30) PRIMARY KEY NOT NULL,
	especialidad VARCHAR(30) NOT NULL,
	num_licencia VARCHAR(30) NOT NULL,
	universidad VARCHAR(30) NOT NULL,
	num_agenda VARCHAR(30) NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES empleado (id_persona),
	FOREIGN KEY (num_agenda) REFERENCES agenda (num_agenda)
);

DROP TABLE IF EXISTS campana CASCADE;
CREATE TABLE campana
(
	codigo_campana VARCHAR(30) PRIMARY KEY NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	objetivo VARCHAR(60) NOT NULL,
	fecha DATE NOT NULL,
	id_persona VARCHAR(30) NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES medico (id_persona)
);

DROP TABLE IF EXISTS enfermera CASCADE;
CREATE TABLE enfermera
(
	id_persona VARCHAR(30) PRIMARY KEY,
	anios_exp INTEGER NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES empleado (id_persona)
);

DROP TABLE IF EXISTS habilidades CASCADE;
CREATE TABLE habilidades
(
	id_persona VARCHAR(30) NOT NULL,
	habilidad VARCHAR(30) NOT NULL,
	PRIMARY KEY (id_persona, habilidad),

	FOREIGN KEY (id_persona) REFERENCES enfermera (id_persona)
);

DROP TABLE IF EXISTS asiste CASCADE;
CREATE TABLE asiste
(
	id_persona VARCHAR(30) NOT NULL,
	codigo_campana VARCHAR(30) NOT NULL,
	descuento INTEGER NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES paciente (id_persona)
);

DROP TABLE IF EXISTS causa CASCADE;
CREATE TABLE causa
(
	codigo_causa VARCHAR(30) PRIMARY KEY NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	descripcion VARCHAR(60) NOT NULL
);

DROP TABLE if EXISTS registro CASCADE;
CREATE TABLE registro
(
	num_historia VARCHAR(30) NOT NULL,
	codigo_causa VARCHAR(30) NOT NULL,
	id_persona VARCHAR(30) NOT NULL,
	precio FLOAT(30) NOT NULL,
	fecha DATE NOT NULL,

	FOREIGN KEY (num_historia) REFERENCES historia_clinica (num_historia),
	FOREIGN KEY (codigo_causa) REFERENCES causa (codigo_causa),
	FOREIGN KEY (id_persona) REFERENCES medico (id_persona)
);

DROP TABLE IF EXISTS cita CASCADE;
CREATE TABLE cita
(
	id_medico VARCHAR(30) NOT NULL,
	id_paciente VARCHAR(30) NOT NULL,
	fecha DATE NOT NULL,
	hora TIME NOT NULL,

	FOREIGN KEY (id_medico) REFERENCES medico (id_persona),
	FOREIGN KEY (id_paciente) REFERENCES paciente (id_persona)
);

DROP TABLE IF EXISTS medicamento CASCADE;
CREATE TABLE medicamento
(
	codigo_medicamento VARCHAR(30) PRIMARY KEY NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	descripcion VARCHAR(60) NOT NULL,
	costo FLOAT(30) NOT NULL
);

DROP TABLE IF EXISTS formula CASCADE;
CREATE TABLE formula
(
	codigo_medicamento VARCHAR(30) NOT NULL,
	id_medico VARCHAR(30) NOT NULL,

	FOREIGN KEY (codigo_medicamento) REFERENCES medicamento (codigo_medicamento),
	FOREIGN KEY (id_medico) REFERENCES medico (id_persona)
);

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario
(
	usuario VARCHAR(30) PRIMARY KEY NOT NULL,
	contraseña VARCHAR(30) NOT NULL,
	tipo_u VARCHAR(30)
);
