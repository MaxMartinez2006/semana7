CREATE TABLE proveedor (
                          id SERIAL PRIMARY KEY,
                          nombre VARCHAR(150) NOT NULL,
                          telefono VARCHAR(10) NOT NULL,
                          correo VARCHAR(50) NOT NULL ,
                          activa BOOLEAN NOT NULL
);
