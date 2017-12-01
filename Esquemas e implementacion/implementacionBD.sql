DROP TABLE IF EXISTS area CASCADE;
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
	descripcion VARCHAR(60) NOT NULL, 
	codigo_area VARCHAR(30), 
	estado VARCHAR(15) NOT NULL,

	FOREIGN KEY (codigo_area) REFERENCES area (codigo_area) 
);

DROP TABLE IF EXISTS persona CASCADE;
CREATE TABLE persona
(
	id_persona VARCHAR(30) PRIMARY KEY,
	nombre VARCHAR(60) NOT NULL,
	direccion VARCHAR(50),
	telefono VARCHAR(30)
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

	FOREIGN KEY (id_persona) REFERENCES persona (id_persona) ON DELETE CASCADE,
	FOREIGN KEY (num_historia) REFERENCES historia_clinica (num_historia) ON DELETE CASCADE
);

DROP TABLE IF EXISTS asignada CASCADE;
CREATE TABLE asignada
(
	id_persona VARCHAR(30) NOT NULL,
	num_cama VARCHAR(30) NOT NULL,
	fecha_entrada DATE NOT NULL,
	fecha_salida DATE NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES paciente (id_persona) ON DELETE CASCADE,
	FOREIGN KEY (num_cama) REFERENCES cama (num_cama) ON DELETE CASCADE
);

DROP TABLE IF EXISTS empleado CASCADE;
CREATE TABLE empleado
(
	id_persona VARCHAR(30) PRIMARY KEY NOT NULL,
	cargo VARCHAR(20) NOT NULL,
	salario FLOAT(30) NOT NULL,
	email VARCHAR(30) NOT NULL,
	codigo_area VARCHAR(30),
	id_jefe VARCHAR(30),

	FOREIGN KEY (id_persona) REFERENCES persona (id_persona) ON DELETE CASCADE,
	FOREIGN KEY (codigo_area) REFERENCES area (codigo_area),
	FOREIGN KEY (id_jefe) REFERENCES empleado (id_persona)
);

DROP TABLE IF EXISTS agenda CASCADE;
CREATE TABLE agenda
(
	id_medico VARCHAR(30) NOT NULL,
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	disponibilidad CHAR(2) NOT NULL,
	
	FOREIGN KEY (id_medico) REFERENCES medico (id_persona) ON DELETE CASCADE
);

DROP TABLE IF EXISTS medico CASCADE;
CREATE TABLE medico
(
	id_persona VARCHAR(30) PRIMARY KEY NOT NULL,
	especialidad VARCHAR(30) NOT NULL,
	num_licencia VARCHAR(30) NOT NULL,
	universidad VARCHAR(30) NOT NULL,	

	FOREIGN KEY (id_persona) REFERENCES empleado (id_persona) ON DELETE CASCADE	
);

DROP TABLE IF EXISTS campana CASCADE;
CREATE TABLE campana
(
	codigo_campana VARCHAR(30) PRIMARY KEY NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	objetivo VARCHAR(60) NOT NULL,
	fecha DATE NOT NULL,
	id_persona VARCHAR(30) NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES medico (id_persona) ON DELETE CASCADE
);

DROP TABLE IF EXISTS enfermera CASCADE;
CREATE TABLE enfermera
(
	id_persona VARCHAR(30) PRIMARY KEY,
	anios_exp INTEGER NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES empleado (id_persona) ON DELETE CASCADE
);

DROP TABLE IF EXISTS habilidades CASCADE;
CREATE TABLE habilidades
(
	id_persona VARCHAR(30) NOT NULL,
	habilidad VARCHAR(30) NOT NULL,
	PRIMARY KEY (id_persona, habilidad),

	FOREIGN KEY (id_persona) REFERENCES enfermera (id_persona) ON DELETE CASCADE
);

DROP TABLE IF EXISTS asiste CASCADE;
CREATE TABLE asiste
(
	id_persona VARCHAR(30) NOT NULL,
	codigo_campana VARCHAR(30) NOT NULL,
	descuento INTEGER NOT NULL,

	FOREIGN KEY (id_persona) REFERENCES paciente (id_persona) ON DELETE CASCADE
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
	fecha DATE NOT NULL,

	FOREIGN KEY (num_historia) REFERENCES historia_clinica (num_historia) ON DELETE CASCADE,
	FOREIGN KEY (codigo_causa) REFERENCES causa (codigo_causa) ON DELETE CASCADE,
	FOREIGN KEY (id_persona) REFERENCES medico (id_persona) ON DELETE CASCADE
);

DROP TABLE IF EXISTS cita CASCADE;
CREATE TABLE cita
(
	id_medico VARCHAR(30) NOT NULL,
	id_paciente VARCHAR(30) NOT NULL,
	fecha DATE NOT NULL,
	hora TIME NOT NULL,
	precio FLOAT(30) NOT NULL,

	FOREIGN KEY (id_medico) REFERENCES medico (id_persona) ON DELETE CASCADE,
	FOREIGN KEY (id_paciente) REFERENCES paciente (id_persona) ON DELETE CASCADE
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
	id_formula VARCHAR(30) PRIMARY KEY NOT NULL,
	codigo_medicamento VARCHAR(30) NOT NULL,
	id_medico VARCHAR(30) NOT NULL,
	id_paciente VARCHAR(30) NOT NULL,

	FOREIGN KEY (codigo_medicamento) REFERENCES medicamento (codigo_medicamento) ON DELETE CASCADE,
	FOREIGN KEY (id_medico) REFERENCES medico (id_persona) ON DELETE CASCADE,
	FOREIGN KEY (id_paciente) REFERENCES paciente (id_persona) ON DELETE CASCADE
);

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario
(
	id_persona VARCHAR(30) PRIMARY KEY NOT NULL,
	password VARCHAR(30) NOT NULL,
	tipo_u VARCHAR(30)
);

INSERT INTO area VALUES ('123','Area de emergencias','Casos de vida o muerte');

INSERT INTO cama VALUES ('001','Esta limpia','123', 'Disponible');
INSERT INTO cama VALUES ('002','Esta sucia','123', 'Ocupada');

INSERT INTO persona VALUES ('111','Juan David','Car 77A #2B', '310 653 06 58');
INSERT INTO persona VALUES ('222','Diana Sofia','Calle 12A #3C', '314 600 40 57');
INSERT INTO persona VALUES ('333','Luis','Car 60B #1A', '212 541 12 78');
INSERT INTO persona VALUES ('444','Miguel Angel','Corinto :v', '300 400 50 60');

INSERT INTO historia_clinica VALUES ('01', '27-11-2001');

INSERT INTO paciente VALUES ('111','01','123456', '31-07-1998', 'Gasta mucho');

INSERT INTO asignada VALUES ('111','002','31-07-2017', '31-12-2017');

INSERT INTO empleado VALUES ('444','Administrador','15000000', 'Miguel@', '123', null);
INSERT INTO empleado VALUES ('333','Medico','10000000', 'luis@', '123', '444');
INSERT INTO empleado VALUES ('222','Enfermera','2000000', 'diana@', '123', '333');

INSERT INTO agenda VALUES ('333','31-12-2017','5:30', 'No');
INSERT INTO agenda VALUES ('333','31-12-2017','2:30', 'No');
INSERT INTO agenda VALUES ('333','31-12-2017','9:30', 'Si');

INSERT INTO medico VALUES ('333','Neurologia','321', 'Valle');

INSERT INTO campana VALUES ('1','Maluma','Fondos para curar el cancer', '31-12-2017', '333');

INSERT INTO enfermera VALUES ('222',3);

INSERT INTO habilidades VALUES ('222','Vacunar');

INSERT INTO asiste VALUES ('111','1', 50);

INSERT INTO causa VALUES ('1000','Dolor en espalda', 'Fuertes dolores lumbares');

INSERT INTO registro VALUES ('01','1000', '333', '16-10-2017');

INSERT INTO cita VALUES ('333','111', '31-12-2017','5:30', 50000);

INSERT INTO medicamento VALUES ('1212','Dolex', 'Ayuda contra el malestar general', 700);

INSERT INTO formula VALUES ('0001','1212', '333', '111');

INSERT INTO usuario VALUES ('1','1','Admin');
