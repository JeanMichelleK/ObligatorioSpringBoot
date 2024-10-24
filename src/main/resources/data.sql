CREATE PROCEDURE If Not Exists cargar_datos_iniciales()
Begin
    Insert into categorias(nombre)
    Values
            ('Documentos'),
            ('Ropa'),
            ('Electronica'),
            ('Comestibles'),
            ('Medicamentos'),
            ('Libros'),
            ('Juguetes'),
            ('Hogar'),
            ('Herramientas'),
            ('Joyeria'),
            ('Fragiles'),
            ('Deportes'),
            ('Belleza'),
            ('Mascotas'),
            ('Automotriz'),
            ('Muebles'),
            ('Arte'),
            ('Instrumentos'),
            ('Limpieza'),
            ('Tecnologica');

    Insert into sucursales(id, nombre)
    Values  
        (1, 'Central'),
        (2, 'Norte'),
        (3, 'Sur'),
        (4, 'Este'),
        (5, 'Oeste'),
        (6, 'Centro Ciudad'),
        (7, 'Playa'),
        (8, 'Estación'),
        (9, 'Industrial'),
        (10, 'Mercado'),
        (11, 'Universitaria'),
        (12, 'Shopping'),
        (13, 'Barrio Viejo'),
        (14, 'San Martín'),
        (15, 'Rivera'),
        (16, 'Pocitos'),
        (17, 'Tres Cruces'),
        (18, 'Ciudad Vieja'),
        (19, 'Prado'),
        (20, 'Parque Rodó'),
        (21, 'Punta Carretas'),
        (22, 'Montevideo Centro'),
        (23, 'La Unión'),
        (24, 'Bella Vista'),
        (25, 'Pueblo Nuevo'),
        (26, 'Colón'),
        (27, 'Malvín'),
        (28, 'Carrasco'),
        (29, 'Salto'),
        (30, 'Canelones'),
        (31, 'La Blanqueada');
    Insert into roles(nombreRol)
    Values
        ('empleado')
        ('cliente')
    
    Insert into usuarios(nombre_usuario, clave_acceso, correo_electronico, activo)
    Values  
        ('usuario1', 'clave1', 'usuario1@ejemplo.com', 1),
        ('usuario2', 'clave2', 'usuario2@ejemplo.com', 1),
        ('usuario3', 'clave3', 'usuario3@ejemplo.com', 1),
        ('usuario4', 'clave4', 'usuario4@ejemplo.com', 1),
        ('usuario5', 'clave5', 'usuario5@ejemplo.com', 1),
        ('usuario6', 'clave6', 'usuario6@ejemplo.com', 1),
        ('usuario7', 'clave7', 'usuario7@ejemplo.com', 1),
        ('usuario8', 'clave8', 'usuario8@ejemplo.com', 1),
        ('usuario9', 'clave9', 'usuario9@ejemplo.com', 1),
        ('usuario10', 'clave10', 'usuario10@ejemplo.com', 1),
        ('usuario11', 'clave11', 'usuario11@ejemplo.com', 1),
        ('usuario12', 'clave12', 'usuario12@ejemplo.com', 1),
        ('usuario13', 'clave13', 'usuario13@ejemplo.com', 1),
        ('usuario14', 'clave14', 'usuario14@ejemplo.com', 1),
        ('usuario15', 'clave15', 'usuario15@ejemplo.com', 1),
        ('usuario16', 'clave16', 'usuario16@ejemplo.com', 1),
        ('usuario17', 'clave17', 'usuario17@ejemplo.com', 1),
        ('usuario18', 'clave18', 'usuario18@ejemplo.com', 1),
        ('usuario19', 'clave19', 'usuario19@ejemplo.com', 1),
        ('usuario20', 'clave20', 'usuario20@ejemplo.com', 1);
    
    Insert into empleados(nombre_usuario, sucursal_id)
    Values
        ('usuario1', 1),
        ('usuario2', 2),
        ('usuario3', 3),
        ('usuario4', 4),
        ('usuario5', 5),
        ('usuario6', 6),
        ('usuario7', 7),
        ('usuario8', 8),
        ('usuario9', 9),
        ('usuario10', 10);

    Insert into clientes(nombre_usuario, cedula, direccion, telefono)
    Values 
        ('usuario11', '12345678', 'Direccion 1', '091234567'),
        ('usuario12', '87654321', 'Direccion 2', '092345678'),
        ('usuario13', '11223344', 'Direccion 3', '093456789'),
        ('usuario14', '44332211', 'Direccion 4', '094567890'),
        ('usuario15', '55667788', 'Direccion 5', '095678901'),
        ('usuario16', '88776655', 'Direccion 6', '096789012'),
        ('usuario17', '99887766', 'Direccion 7', '097890123'),
        ('usuario18', '22334455', 'Direccion 8', '098901234'),
        ('usuario19', '33445566', 'Direccion 9', '099012345'),
        ('usuario20', '44556677', 'Direccion 10', '090123456');

    Insert into usuarios_roles(usuario_nombre_usuario, rol_nombre_rol)
    Values
        ('usuario1', 'empleado'),
        ('usuario2', 'empleado'),
        ('usuario3', 'empleado'),
        ('usuario4', 'empleado'),
        ('usuario5', 'empleado'),
        ('usuario6', 'empleado'),
        ('usuario7', 'empleado'),
        ('usuario8', 'empleado'),
        ('usuario9', 'empleado'),
        ('usuario10', 'empleado'),
        ('usuario11', 'cliente'),
        ('usuario12', 'cliente'),
        ('usuario13', 'cliente'),
        ('usuario14', 'cliente'),
        ('usuario15', 'cliente'),
        ('usuario16', 'cliente'),
        ('usuario17', 'cliente'),
        ('usuario18', 'cliente'),
        ('usuario19', 'cliente'),
        ('usuario20', 'cliente');

    Insert into estadorastreos(descripcion)
    Values 
        ('A levantar'),
        ('Levantado'),
        ('En reparto'),
        ('Entregado'),
        ('Devuelto');

    Insert into paquetes(fecha_hora_registro, nombre_destinatario, direccion_destinatario, telefono_destinatario, cobrar_al_destinatario, estadorastreo_id, cliente_usario, categoria_id)
    Values  
        ('2024-10-01 10:00:00', 'Juan Pérez', 'Av. 123, Montevideo', '091234567', 1, 1, 'usuario11', 1),
        ('2024-10-02 11:30:00', 'María López', 'Calle 456, Montevideo', '092345678', 0, 2, 'usuario12', 2),
        ('2024-10-03 09:45:00', 'Carlos García', 'Av. 789, Montevideo', '093456789', 1, 3, 'usuario13', 3),
        ('2024-10-04 14:15:00', 'Ana Martínez', 'Calle 101, Montevideo', '094567890', 0, 4, 'usuario14', 4),
        ('2024-10-05 15:30:00', 'Luis Fernández', 'Av. 202, Montevideo', '095678901', 1, 5, 'usuario15', 5),
        ('2024-10-06 08:00:00', 'Sofía Rodríguez', 'Calle 303, Montevideo', '096789012', 0, 1, 'usuario16', 6),
        ('2024-10-07 10:30:00', 'Javier Gómez', 'Av. 404, Montevideo', '097890123', 1, 2, 'usuario17', 7),
        ('2024-10-08 13:45:00', 'Clara Torres', 'Calle 505, Montevideo', '098901234', 0, 3, 'usuario18', 8),
        ('2024-10-09 12:00:00', 'Fernando Morales', 'Av. 606, Montevideo', '099012345', 1, 4, 'usuario19', 9),
        ('2024-10-10 16:20:00', 'Lucía Sánchez', 'Calle 707, Montevideo', '090123456', 0, 5, 'usuario20', 10),
        ('2024-10-11 09:00:00', 'Pedro Álvarez', 'Calle 808, Montevideo', '091234567', 1, 1, 'usuario11', 1),
        ('2024-10-12 14:00:00', 'Laura Méndez', 'Av. 909, Montevideo', '092345678', 0, 2, 'usuario12', 2),
        ('2024-10-13 11:30:00', 'Diego Pérez', 'Calle 1010, Montevideo', '093456789', 1, 3, 'usuario13', 3),
        ('2024-10-14 15:45:00', 'Valentina López', 'Av. 1111, Montevideo', '094567890', 0, 4, 'usuario14', 4),
        ('2024-10-15 12:30:00', 'Martín Romero', 'Calle 1212, Montevideo', '095678901', 1, 5, 'usuario15', 5),
        ('2024-10-16 13:00:00', 'Camila Ríos', 'Av. 1313, Montevideo', '096789012', 0, 1, 'usuario16', 6),
        ('2024-10-17 10:15:00', 'Nicolás Ruiz', 'Calle 1414, Montevideo', '097890123', 1, 2, 'usuario17', 7),
        ('2024-10-18 08:45:00', 'Sofia Jiménez', 'Av. 1515, Montevideo', '098901234', 0, 3, 'usuario18', 8),
        ('2024-10-19 16:00:00', 'Gabriel Castro', 'Calle 1616, Montevideo', '099012345', 1, 4, 'usuario19', 9),
        ('2024-10-20 17:30:00', 'Ana Martínez', 'Av. 1717, Montevideo', '090123456', 0, 5, 'usuario20', 10);
End^;

Call cargar_datos_iniciales()^;
