-- Proveedores (uno por producto, porque la relación es @OneToOne)
INSERT INTO proveedor (nombre) VALUES ('Tecnosur');
INSERT INTO proveedor (nombre) VALUES ('Informática Aragón');
INSERT INTO proveedor (nombre) VALUES ('Periféricos Norte');
INSERT INTO proveedor (nombre) VALUES ('Distribuciones Levante');
INSERT INTO proveedor (nombre) VALUES ('Componentes Ibérica');
INSERT INTO proveedor (nombre) VALUES ('Oficina Express');

-- Productos
INSERT INTO producto (codigo, nombre, precio, proveedor_id) VALUES ('P001', 'Portátil 15 pulgadas', 649.99, 1);
INSERT INTO producto (codigo, nombre, precio, proveedor_id) VALUES ('P002', 'Ratón inalámbrico', 19.95, 2);
INSERT INTO producto (codigo, nombre, precio, proveedor_id) VALUES ('P003', 'Teclado mecánico', 59.90, 3);
INSERT INTO producto (codigo, nombre, precio, proveedor_id) VALUES ('P004', 'Monitor 24 pulgadas', 129.00, 4);
INSERT INTO producto (codigo, nombre, precio, proveedor_id) VALUES ('P005', 'Disco SSD 1TB', 74.50, 5);
INSERT INTO producto (codigo, nombre, precio, proveedor_id) VALUES ('P006', 'Auriculares Bluetooth', 45.00, 6);

-- Clientes
INSERT INTO cliente (nombre) VALUES ('Laura Gómez');
INSERT INTO cliente (nombre) VALUES ('Carlos Ruiz');
INSERT INTO cliente (nombre) VALUES ('Marta Navarro');
INSERT INTO cliente (nombre) VALUES ('Pablo Torres');
INSERT INTO cliente (nombre) VALUES ('Elena Romero');

-- Pedidos (precio_total = suma de sus productos)
INSERT INTO pedido (cliente_id) VALUES (1);
INSERT INTO pedido (cliente_id) VALUES (1);
INSERT INTO pedido (cliente_id) VALUES (2);
INSERT INTO pedido (cliente_id) VALUES (3);
INSERT INTO pedido (cliente_id) VALUES (3);
INSERT INTO pedido (cliente_id) VALUES (4);
INSERT INTO pedido (cliente_id) VALUES (5);
INSERT INTO pedido (cliente_id) VALUES (2);

-- Tabla intermedia pedidos_clientes (columna pedidos = id del pedido, productos = código del producto)
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (1, 'P001');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (1, 'P002');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (2, 'P003');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (2, 'P004');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (3, 'P005');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (4, 'P002');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (4, 'P003');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (4, 'P006');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (5, 'P004');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (6, 'P001');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (6, 'P005');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (7, 'P006');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (7, 'P002');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (8, 'P003');
INSERT INTO pedidos_clientes (pedidos, productos) VALUES (8, 'P005');