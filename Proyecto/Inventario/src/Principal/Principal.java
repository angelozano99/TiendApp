/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controlador.controladorInicio;
import Vista.vistaInicio2;

/**
 *
 * @author Labingpush
 */

/*create database tiendapp;
use tiendapp;

create table productos (nom_producto varchar(20) primary key, preciocompra int, precioventa int,
ganancia int, unidades int, proveedor varchar(45));

create table pedido(id_pedido int not null primary key , proveedor varchar(45),  fecha varchar(20), fecha_entrega varchar(20), valortotal int);

create table pedido_productos(id_pedido int, nom_producto varchar(20), cantidad int,
foreign key(id_pedido) references pedido(id_pedido));
 
create table ventas(id_venta int not null auto_increment primary key, fecha varchar(20), preciototal int, gananciaventa int);

create table venta_productos(id_venta int, nom_producto varchar(20), cantidad int,
foreign key(id_venta) references ventas(id_venta), foreign key(nom_producto) references productos(nom_producto));

create table usuarios (nombre varchar(45) not null primary key,contrasena varchar (45), insertar varchar(45),
 buscar varchar(45), modificar varchar(45) , eliminar varchar(45));
*/
public class Principal {
    
    public static void main(String []args){
        
        vistaInicio2 vistaInicio = new vistaInicio2();
        controladorInicio controladorInicio = new controladorInicio(vistaInicio);
        
    }
    
}
