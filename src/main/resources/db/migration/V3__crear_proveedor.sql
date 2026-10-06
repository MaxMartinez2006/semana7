CREATE TABLE proveedor (
                           id INT IDENTITY(1,1) PRIMARY KEY,
                           nombre VARCHAR(150) NOT NULL,
                           telefono VARCHAR(10) NOT NULL,
                           correo VARCHAR(50) NOT NULL,
                           activa BIT NOT NULL
);