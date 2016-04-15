CREATE DATABASE inmobiliaria;
use inmobiliaria;

CREATE TABLE Propietario(
	dni varchar(9) primary key,
    nombre varchar(20) not null,
    apellidos varchar(40) not null,
    tlf varchar(9) not null,
    correo varchar(60) not null,
    usuario varchar(20) references Autentifica (usuario) on delete cascade on update cascade
);

CREATE TABLE Piso(
	cod_piso int primary key,
    imagen varchar(100),
    direccion varchar (100) not null,
    descripcion varchar (500),
    plazas int not null,
	precio float not null,
    dni_p varchar(9) references Propietario (dni) on delete cascade on update cascade
);

CREATE TABLE Autentifica(
	usuario varchar(20) primary key,
    pass varchar(20) not null
);

CREATE TABLE Alumnos(
	dni varchar(9) primary key,
    nombre varchar(20) not null,
    apellidos varchar(40) not null,
    fecha_nacimiento varchar(10),
    tlf varchar(9) not null,
    correo varchar(60) not null,
    usuario varchar(20) not null references Autentifica (usuario) on delete cascade on update cascade 
    
);

INSERT INTO Autentifica Values("mno00845", "asd");
INSERT INTO Autentifica Values("irr00123", "asd");
INSERT INTO Autentifica Values("lfd12039", "asd");
INSERT INTO Autentifica Values("eom01564", "asd");
INSERT INTO Autentifica Values("joc78500", "asd");
INSERT INTO Autentifica Values("pbz00159", "asd");
INSERT INTO Autentifica Values("amg05940", "asd");
INSERT INTO Autentifica Values("rpv00258", "asd");
INSERT INTO Autentifica Values("ebt45201", "asd");
INSERT INTO Autentifica Values("sat00123", "asd");
INSERT INTO Autentifica Values("pepe", "asd");
INSERT INTO Autentifica Values("antonia", "asd");
INSERT INTO Autentifica Values("maria", "asd");
INSERT INTO Autentifica Values("jesus", "asd");
INSERT INTO Autentifica Values("federico", "asd");
INSERT INTO Autentifica Values("sergio", "asd");
INSERT INTO Autentifica Values("noemi", "asd");
INSERT INTO Autentifica Values("laura", "asd");
INSERT INTO Autentifica Values("francisco", "asd");
INSERT INTO Autentifica Values("conchi", "asd");

INSERT INTO Propietario VALUES("26314529P", "Pepe", "Martinez Ruiz", 953752364, "pepe@gmail.com", "pepe");
INSERT INTO Propietario VALUES("15632984A", "Antonia", "Lopez Fernandez", 123541896, "antonia@gmail.com", "antonia");
INSERT INTO Propietario VALUES("78541236M", "Maria", "Garcia Costa", 856214532, "maria@gmail.com", "maria");
INSERT INTO Propietario VALUES("75632156J", "Jesus", "Martinez Sanchez", 123456789, "jesus@gmail.com", "jesus");
INSERT INTO Propietario VALUES("96215862L", "Laura", "Moreno Navarro", 452169874, "laura@gmail.com", "laura");
INSERT INTO Propietario VALUES("58963186F", "Federico", "Rodriguez Gomez", 362105840, "federico@gmail.com", "federico");
INSERT INTO Propietario VALUES("87456752N", "Noemi", "De la Torre Jimenez", 741236589, "noemi@gmail.com", "noemi");
INSERT INTO Propietario VALUES("89617850S", "Sergio", "Raya Toral", 745698216, "sergio@gmail.com", "sergio");
INSERT INTO Propietario VALUES("57941665F", "Francisco", "Agullo Cruz", 785136982, "Francisco@gmail.com", "francisco");
INSERT INTO Propietario VALUES("98941668C", "Conchi", "Lopez Jimenez", 256301589, "conchi@gmail.com", "conchi");

INSERT INTO Alumnos VALUES("45236985M", "Martin", "Núñez Ordoñez", "01/09/1995", 785236954, "martin@gmail.com", "mno00845");
INSERT INTO Alumnos VALUES("56301255I", "Iñigo", "Ramirez Rodriguez", "12/06/1994", 45236982, "iñigo@gmail.com", "irr00123");
INSERT INTO Alumnos VALUES("45687105L", "Lucia", "Fernandez Díez", "09/07/1993", 521698403, "lucia@gmail.com", "lfd12037");
INSERT INTO Alumnos VALUES("78567122E", "Emilio", "Ocaña Martinez", "01/02/1994", 856301269, "emilio@gmail.com", "eom01564");
INSERT INTO Alumnos VALUES("69751058J", "Jorge", "Ortiz Camara", "03/11/1995", 451032692, "jorge@gmail.com", "joc78500");
INSERT INTO Alumnos VALUES("45893015P", "Pedro", "Bautista Zafora", "09/10/1993", 4521029, "pedro@gmail.com", "pbz00159");
INSERT INTO Alumnos VALUES("78941311A", "Ana", "Mayengo Gomez", "01/04/1994", 45236951, "ana@gmail.com", "amg05940");
INSERT INTO Alumnos VALUES("45036981R", "Rocio", "Padilla Villacañas", "25/12/1995", 452306591, "rocio@gmail.com", "rpv00258");
INSERT INTO Alumnos VALUES("45047895E", "Elisabet", "Berlanga Toral", "16/07/1993", 452615920, "elisabet@gmail.com", "ebt45201");
INSERT INTO Alumnos VALUES("96301248S", "Silvia", "Agea Tamargo", "23/08/1994", 78501369, "silvia@gmail.com", "sat00123");

INSERT INTO Piso VALUES(1,"resources/imagenes/pisos/001/pasillo.jpg","Calle jaén, 2,Centro Ciudad","Dúplex en perfecto estado, situado en urbanización Oretania junto al Corte Inglés. Muy luminoso, completamente amueblado, y excelentemente acondicionado. Sexta planta con ascensor y aire acondicionado. Plaza de garaje incluida en el precio. Segunda mano/buen estado, Armarios empotrados totalmente amueblado y equipado",4,138,"26314529P");

INSERT INTO Piso VALUES(2,"resources/imagenes/pisos/002/salon.jpg","Distrito Centro Ciudad Linares Comarca norte - El Condado, Jaén","Piso muy amplio y luminoso, muy céntrico en calle República Argentina, habitaciones muy amplias, en pleno centro de Linares, Jaén. totalmente amueblado. Dos dormitorios, baño, cocina amplia, como nuevo... Se busca inquilino de larga duración, para familias que quieran vivir en una zona privilegiada de la ciudad y con las mejores comodidades. Un sitio para vivir, con magníficas vistas y en una zona muy tranquila de la ciudad.",2,155, "15632984A");

INSERT INTO Piso VALUES(3,"resources/imagenes/pisos/003/mesa.jpg","Barrio de la Paz, 33, La Paz-Las Américas","Particular vende piso de 77m2 (Construidos) totalmente amueblado y equipado, para entrar a vivir. Muy luminoso, en zona tranquila a 5 min andando del centro de Linares, a tres minutos de Mercadona y de una escuela.",4,88,"78541236M");

INSERT INTO Piso VALUES(4,"resources/imagenes/pisos/004/salon.jpg","Calle alemania, 4, San Gonzalo","Precioso piso totalmente nuevo, en una de las mejores Urbanizaciones de Linares, con zonas verdes, zona infantil, piscina. Puerta blindada, tarima flotante, gas natural, canalizado en todo el piso con bomba de frío y calor. Cocina equipada con todos los electrodomésticos de alta gama. Patio con trastero. 3 amplios dormitorios, dos de ellos con camas de 105cm de ancho. 2 Baños completos, uno de ellos en el dormitorio principal con bañera. Terraza de 12 metros cuadrados,3,167",3,167,"75632156J");

INSERT INTO Piso VALUES(5,"resources/imagenes/pisos/005/salon.jpg","Plaza colón, 7","Precioso piso en zona inmejorable, céntrica y tranquila. Apartamento totalmente equipado con calidades de lujo. Paredes de cristal con vistas a la plaza Colón, aire acondicionado con bomba de calor en todo el apartamento, cocina totalmente equipada. Posibilidad de alquiler de garaje en el mismo edificio, con acceso directo. No fumadores ni mascotas. Precio del alquiler sin garaje: 350€. Con garaje: 380€. Si lo ves, te lo quedas. Preferible alquileres largos.",1,350,"96215862L");

INSERT INTO Piso VALUES(6,"resources/imagenes/pisos/006/salon.jpg","Calle canalejas, 10, Centro Ciudad","Se alquila piso amueblado de aproximadamente 90 metros cuadrados en el centro de Linares. Calle Canalejas, dentro del pasaje. El piso dispone de tres dormitorios, uno de matrimonio y dos individuales, dos baños, cocina con comedor, salón con balcón que da a la calle Canalejas y un lavadero que da a un patio interior donde está la lavadora y se puede tender. También tiene máquinas de aire acondicionado frío/calor.",3,134,"58963186F");

INSERT INTO Piso VALUES(7,"resources/imagenes/pisos/007/salon.jpg","Avenida andalucia, 2, Centro Ciudad","Enfrente de El Corte Inglés, colegios, comercios,bares, restaurantes... Totalmente amueblado con 2 dormitorios, 2 baños, salón y balcón. Cocina totalmente equipada, cuarto de pila con tendedero y lavadora. Aire acondicionado centralizado, calefacción y armario empotrado en pasillo. 2ª Planta con ascensor. Posibilidad de plaza de garaje. Muy buen estado. Comunidad incluida en el precio",2,180,"87456752N");

INSERT INTO Piso VALUES(8,"resources/imagenes/pisos/008/salon.jpg","Calle zambrana, 12","75 m² construidos, 65 m² útiles, 3 habitaciones, 1 wc, terrazasegunda mano/buen estado, armarios empotrados, trastero, totalmente amueblado y equipado",3,107,"89617850S");

INSERT INTO Piso VALUES(9,"resources/imagenes/pisos/009/salon.jpg","Pintor Pablo Picasso, Zona Hospital","Piso con 2, 3 y 4 dormitorios, amueblados y sin amueblar.Urbanización con piscina.Posibilidad de garaje.Comunidad Incluida. Cerca de institutos, Residencia San Agustin, supermercados.Buena zona. Cuarta planta con ascensor",2,125,"57941665F");

INSERT INTO Piso VALUES(10,"resources/imagenes/pisos/010/salon.jpg","Calle Bailen Bloques, 10","47 m² construidos, 40 m² útiles, 1 habitación, 1 wc, segunda mano/buen estado, armarios empotrados, totalmente amueblado y equipado. Primera planta con ascensor",1,325,"98941668C");

create user ClientePisos;
set password for ClientePisos = 'pass';
grant select, delete, update, insert on piso to ClientePisos;
grant select , delete, update, insert on Autentifica to ClientePisos;
grant select, delete, update, insert on Alumnos to ClientePisos;
grant select, delete, update, insert on Propietario to ClientePisos;
