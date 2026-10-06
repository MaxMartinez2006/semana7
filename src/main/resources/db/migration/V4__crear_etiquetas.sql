CREATE TABLE etiqueta (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE producto_etiqueta (
                                   producto_id INT NOT NULL,
                                   etiqueta_id INT NOT NULL,

                                   CONSTRAINT PK_producto_etiqueta
                                       PRIMARY KEY (producto_id, etiqueta_id),

                                   CONSTRAINT FK_producto_etiqueta_producto
                                       FOREIGN KEY (producto_id)
                                           REFERENCES producto(id),

                                   CONSTRAINT FK_producto_etiqueta_etiqueta
                                       FOREIGN KEY (etiqueta_id)
                                           REFERENCES etiqueta(id)
);