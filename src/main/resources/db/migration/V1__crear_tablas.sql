CREATE TABLE categoria (
                           id INT IDENTITY(1,1) PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           activa BIT NOT NULL DEFAULT 1
);

CREATE TABLE producto (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          codigo VARCHAR(30) NOT NULL UNIQUE,
                          nombre VARCHAR(150) NOT NULL,
                          precio_venta DECIMAL(12,2) NOT NULL,
                          existencia INT NOT NULL DEFAULT 0,
                          categoria_id INT NOT NULL,

                          CONSTRAINT fk_producto_categoria
                              FOREIGN KEY (categoria_id)
                                  REFERENCES categoria(id)
);