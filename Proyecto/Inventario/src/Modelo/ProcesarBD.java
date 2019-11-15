package Modelo;


import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import vista.vistaClientes;

public class ProcesarBD {

    private Conexion con;
    private PreparedStatement preparedStatement;
    private ArrayList array = new ArrayList();

    public ProcesarBD() {

        this.con = new Conexion();

    }

   public void ingresarUsuario(String nombre, String contrasena,
            String insertar, String buscar, String modificar, String eliminar) throws SQLException {

        
        String datos[] = {nombre, contrasena, insertar, buscar, modificar, eliminar};
      
        insertar(datos, "INSERT INTO usuarios (nombre, contrasena, "
                + "insertar , buscar, modificar, eliminar) VALUES(?,?,?,?,?,?)");

        String insert = "create user " + nombre + "@localhost identified by '" + contrasena + "'";

        
        PreparedStatement ps = con.conectado().prepareStatement(insert);

        ps.execute();
        
        //show grants for angel@localhost  ,  comando para obtener los permisos de determinado usuario, devuelve tabla, y sacar la linea.

        if (insertar == "y") {

            String permiso = "GRANT insert ON tiendapp.* TO " + nombre + "@localhost";

            ps = con.conectado().prepareStatement(permiso);

            ps.execute();

        }

        
        
        if (buscar == "y") {

            String permiso = "GRANT select ON tiendapp.* TO " + nombre + "@localhost";

            ps = con.conectado().prepareStatement(permiso);

            ps.execute();

        }

        if (modificar == "y") {

            String permiso = "GRANT update ON tiendapp.* TO " + nombre + "@localhost";

            ps = con.conectado().prepareStatement(permiso);

            ps.execute();

        }

        if (eliminar == "y") {

            String permiso = "GRANT delete ON tiendapp.* TO " + nombre + "@localhost";

            ps = con.conectado().prepareStatement(permiso);

            ps.execute();

        }

        ps.close();

        JOptionPane.showMessageDialog(null, "Usuario creado");

    }
   
   public void eliminarUsuario(String nombre) throws SQLException {

        String deleteSQL = "DELETE FROM usuarios WHERE nombre = ?";
        delete(nombre, deleteSQL);

        String delete = "drop user " + nombre + " @" + "localhost";

        PreparedStatement ps = con.conectado().prepareStatement(delete);
        ps.execute();
        ps.close();

    }
   
    public void updateUsuario(String nombre,
            String contrasena, String insertar, String buscar,
            String modificar, String eliminar) {
        int resultado = 0;
        try {
            String nombre2 = "n";
            String contrasena2 = "n";
            String insertar2 = "n";
            String buscar2 = "n";
            String modificar2 = "n";
            String eliminar2 = "n";

            PreparedStatement ps;
            String updateSQL = "UPDATE usuarios SET  contrasena  = ?, insertar =  ? ,buscar =  ?,modificar= ?, eliminar = ?" + "  WHERE nombre =  ?";
            ps = con.conectado().prepareStatement(updateSQL);

            System.out.println("entra1");

            ps.setString(1, contrasena);
            ps.setString(2, insertar);
            ps.setString(3, buscar);
            ps.setString(4, modificar);
            ps.setString(5, eliminar);
            ps.setString(6, nombre);
            ps.execute();

            ps = con.conectado().prepareStatement("REVOKE ALL PRIVILEGES ON *.* FROM '"
                    + nombre + "'@'localhost';");
            ps.execute();

            //System.out.println("entra1");

            if (insertar == "y") {

                String permiso = "GRANT insert ON tiendapp.* TO " + nombre + "@localhost";

                ps = con.conectado().prepareStatement(permiso);

                ps.execute();

            }

            if (buscar == "y") {

                String permiso = "GRANT select ON tiendapp.* TO " + nombre + "@localhost";

                ps = con.conectado().prepareStatement(permiso);

                ps.execute();

            }

            if (modificar == "y") {

                String permiso = "GRANT update ON tiendapp.* TO " + nombre + "@localhost";

                ps = con.conectado().prepareStatement(permiso);

                ps.execute();

            }

            if (eliminar == "y") {

                String permiso = "GRANT delete ON tiendapp.* TO " + nombre + "@localhost";

                ps = con.conectado().prepareStatement(permiso);

                ps.execute();

            }
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Usuario modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }
    
    
    public String[] leerUsuario(String nombre) {

        boolean resultado = false;
        String[] datos = new String[6];
        try {
            String read = "SELECT * FROM usuarios WHERE nombre = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ps.setString(1, nombre);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("nombre");
                datos[1] = resultSet.getString("contrasena");
                datos[2] = resultSet.getString("insertar");
                datos[3] = resultSet.getString("buscar");
                datos[4] = resultSet.getString("modificar");
                datos[5] = resultSet.getString("eliminar");

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return datos;
    }
    public ArrayList buscar (String Nit,String insert){
        this.array=new ArrayList();
        try{
        PreparedStatement ps = con.conectado().prepareStatement(insert);
        if(Nit!=null){
            ps.setString(1, Nit);
        }
        ResultSet rs = ps.executeQuery(); 
        while(rs.next()){;
            ResultSetMetaData pss = rs.getMetaData(); 
            int columnCount = pss.getColumnCount(); 
            for (int i = 1; i <= columnCount; i++) { 
                String name = pss.getColumnName(i);
                array.add(rs.getString(name));
            }
        }
        }catch(SQLException e){
             System.out.println(e);
        }
        
  
        return array;
    }
    
    
    public boolean tipoUsuario(String nombre){
        String datos[]=leerUsuario(nombre);
        if (nombre.equals("root")) {
            return true;
        }else if(datos[5].equals("y")){
            return true;
        }else
            return false;
    }   
    
    public void ingresarPedido(int id,String proveedor, String fecha, String fecha_entrega, int valortotal) {
        
        String datos[] = {String.valueOf(id),proveedor, fecha, fecha_entrega, String.valueOf(valortotal)};
        insertar(datos, "INSERT INTO pedido(id_pedido,proveedor,fecha,fecha_entrega,valortotal) VALUES(?,?,?,?,?)");
        
    }
   
    public void ingresarPedido_producto(int id_pedido,String nom_producto, int cantidad) {
        
        String datos[] = {String.valueOf(id_pedido),nom_producto, String.valueOf(cantidad)};
        insertar(datos, "INSERT INTO pedido_productos(id_pedido,nom_producto,cantidad) VALUES(?,?,?)");
        
    }
  

    public void eliminarCliente(int nit) {
        String deleteSQL = "DELETE FROM clientes WHERE nit = ?";
        delete(String.valueOf(nit), deleteSQL);
    }
    
      public void ingresarProducto(String nombre,
           Integer precioCompra, Integer precioVenta, Integer ganancia,Integer unidades, String proveedor) throws SQLException {

        
        String datos[] = {nombre, String.valueOf(precioCompra),
            String.valueOf(precioVenta), String.valueOf(ganancia),String.valueOf(unidades) ,proveedor};
      
        insertar(datos, "INSERT INTO productos (nom_producto, "
                + "preciocompra , precioventa, ganancia, unidades, proveedor) VALUES(?,?,?,?,?,?)");


        JOptionPane.showMessageDialog(null, "Producto creado");

    }

    public String[] leerProducto(String nombre) {

        boolean resultado = false;
        String[] datos = new String[6];
        try {
            //vistaClientes vistaClientes;
            String read = "SELECT * FROM productos WHERE nom_producto = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

           
            ps.setString(1, nombre);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("nom_producto");
                datos[1] = resultSet.getString("preciocompra");
                datos[2] = resultSet.getString("precioventa");
                datos[3] = resultSet.getString("ganancia");
                datos[4] = resultSet.getString("unidades");
                datos[5] = resultSet.getString("proveedor");

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return datos;
    }

    public void updateCliente(int nit, String nombre, String direccion, String telefono, String ciudad, String tipo) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE clientes SET  nombre  = ?, direccion =  ? ,telefono =  ? , ciudad = ?, tipo = ? " + "  WHERE nit =  ?";
            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, ciudad);
            ps.setString(5, tipo);
            ps.setInt(6, nit);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cliente modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

//    public void ingresarComprobante(String comprobante, String descripcion, String tipo, int cuenta) {
//        String datos[] = {comprobante, descripcion, tipo, String.valueOf(cuenta)};
//        insertar(datos, "INSERT INTO comprobante (comprobante, descripcion,tipo,cuenta) VALUES(?,?,?,?)");
//
//    }
//
//    public void eliminarComprobante(String comprobante) {
//        String deleteSQL = "DELETE FROM comprobante WHERE comprobante = ?";
//        delete(comprobante, deleteSQL);
//    }
/*
    public String[] leerComprobante(String comprobante) {

        boolean resultado = false;
        String[] datos = new String[3];
        try {
            vistaClientes vistaClientes;
            String read = "SELECT * FROM comprobante WHERE comprobante = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ps.setString(1, comprobante);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("descripcion");
                datos[1] = resultSet.getString("tipo");
                datos[2] = resultSet.getString("cuenta");

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return datos;
    }
*/
//    public void updateComprobante(String comprobante, String descripcion, String tipo, String cuenta) {
//        int resultado = 0;
//        try {
//
//            String updateSQL = "UPDATE comprobante SET  descripcion  = ?, tipo =  ? ,cuenta =  ?" + "  WHERE comprobante =  ?";
//            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);
//
//            ps.setString(1, descripcion);
//            ps.setString(2, tipo);
//            ps.setString(3, cuenta);
//            ps.setString(4, comprobante);
//
//            ps.execute();
//            ps.close();
//
//            JOptionPane.showMessageDialog(null, "Comprobante modificado");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
//        }
//    }

    public void ingresarProducto(int id, String descripcion, String linea, double precio) {
        String datos[] = {String.valueOf(id), descripcion, linea, String.valueOf(precio)};
        insertar(datos, "INSERT INTO productos (id, descripcion,linea,precio) VALUES(?,?,?,?)");

    }

    public void eliminarProducto(int id) {
        String deleteSQL = "DELETE FROM productos WHERE id = ?";
        delete(String.valueOf(id), deleteSQL);
    }
/*
    public String[] leerProducto(int id) {

        boolean resultado = false;
        String[] datos = new String[3];
        try {
            vistaClientes vistaClientes;
            String read = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ps.setString(1, String.valueOf(id));

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("descripcion");
                datos[1] = resultSet.getString("linea");
                datos[2] = resultSet.getString("precio");

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return datos;
    }
*/
    public void updateProducto(int id, String descripcion, String linea, double precio) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE productos SET  descripcion = ?, linea =  ? , precio =  ?" + "  WHERE id =  ?";
            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            ps.setString(1, descripcion);
            ps.setString(2, linea);
            ps.setDouble(3, precio);
            ps.setInt(4, id);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Producto modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

    public void ingresarVendedor(int id_Vdor, String nombre, String direccion, int telefono, String ciudad) {
        String datos[] = {String.valueOf(id_Vdor), nombre, direccion, String.valueOf(telefono), ciudad};
        insertar(datos, "INSERT INTO vendedor (id_Vdor, nombre,direccion,telefono,ciudad) VALUES(?,?,?,?,?)");

    }

    public void eliminarVendedor(int id_Vdor) {
        String deleteSQL = "DELETE FROM vendedor WHERE id_Vdor = ?";
        delete(String.valueOf(id_Vdor), deleteSQL);
    }

    public String[] leerVendedor(int id_Vdor) {

        boolean resultado = false;
        String[] datos = new String[4];
        try {
            String read = "SELECT * FROM vendedor WHERE id_Vdor = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ps.setString(1, String.valueOf(id_Vdor));

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("nombre");
                datos[1] = resultSet.getString("direccion");
                datos[2] = resultSet.getString("telefono");
                datos[3] = resultSet.getString("ciudad");

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return datos;
    }

    public void updateVendedor(int id_Vdor, String nombre, String direccion, int telefono, String ciudad) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE vendedor SET  nombre  = ?, direccion =  ? ,telefono =  ?, ciudad = ?" + "  WHERE id_Vdor =  ?";
            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            ps.setString(4, ciudad);
            ps.setInt(5, id_Vdor);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Vendedor modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

    public void ingresarMovimiento(int numFactura, int id_Vdor, int nit, Date fechaFactura,
            int id, int cantidad, int valorFactura, String FPago, String comprobante) {

        String datos[] = {String.valueOf(numFactura), String.valueOf(id_Vdor), String.valueOf(nit),
            String.valueOf(fechaFactura), String.valueOf(id), String.valueOf(cantidad),
            String.valueOf(valorFactura), FPago, comprobante};

        insertar(datos, "INSERT INTO movimientos (numFactura,id_Vdor ,nit,fechaFactura,id,cantidad,valorFactura,FPago,comprobante) VALUES(?,?,?,?,?,?,?,?,?)");
      
    }

    public void eliminarMovimiento(int numFactura) {

        String deleteSQL = "DELETE FROM movimientos WHERE numFactura = ?";
        delete(String.valueOf(numFactura), deleteSQL);

    }

    public String[] leerMovimiento(int numFactura) {

        boolean resultado = false;
        String[] datos = new String[8];
        try {
            String read = "SELECT * FROM movimientos WHERE numFactura = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ps.setString(1, String.valueOf(numFactura));

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("id_Vdor");
                datos[1] = resultSet.getString("nit");
                datos[2] = resultSet.getString("fechaFactura");
                datos[3] = resultSet.getString("id");
                datos[4] = resultSet.getString("cantidad");
                datos[5] = resultSet.getString("valorFactura");
                datos[6] = resultSet.getString("FPago");
                datos[7] = resultSet.getString("comprobante");

            }
            System.out.println("Entra");

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return datos;
    }

    public void updateMovimientos(int numFactura, int id_Vdor, int nit, Date fechaFactura,
            int id, int cantidad, int valorFactura, String FPago, String comprobante) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE movimientos SET "
                    + "id_Vdor =  ? ,nit =  ?, fechaFactura = ?, id = ?,"
                    + "cantidad = ?, valorFactura = ?, FPago = ?,  comprobante = ?" + "  WHERE numFactura =  ?";
            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            ps.setInt(1, id_Vdor);
            ps.setInt(2, nit);
            ps.setDate(3, (java.sql.Date) fechaFactura);
            ps.setInt(4, id);
            ps.setInt(5, cantidad);
            ps.setInt(6, valorFactura);
            ps.setString(7, FPago);
            ps.setString(8, comprobante);
            ps.setInt(9, numFactura);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Movimiento modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

    public boolean insertar(String datos[], String insert) {
        boolean estado = false;

        try {
            //Connection dbC= (Connection) con.conectado();
            //PreparedStatement ps = dbC.prepareStatement(insert);	
            PreparedStatement ps = con.conectado().prepareStatement(insert);

            //System.out.println(datos.length);
            for (int i = 0; i <= datos.length - 1; i++) {
                ps.setString(i + 1, datos[i]);

                //System.out.println("Entra");
            }

            ps.execute();
            ps.close();
            estado = true;
            JOptionPane.showMessageDialog(null, "agregado exitoso");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Problemas con el agregado");
        }
        return estado;
    }

    public boolean delete(String id, String delete) {
        boolean resultado = false;
        try {

            PreparedStatement ps = con.conectado().prepareStatement(delete);

            ps.setString(1, id);

            ps.execute();
            ps.close();
            resultado = true;
            JOptionPane.showMessageDialog(null, "Borrado exitoso");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con el Borrado");
        }

        return resultado;

    }

   

    


    /*
    public void eliminarUsuario(String nombre) {
        String delete = "DELETE FROM usuario WHERE nombre = ?";
        delete(nombre, deleteSQL);
        
         PreparedStatement ps = con.conectado().prepareStatement(delete);
    }
     */
   

    public DefaultTableModel listar(DefaultTableModel tabla) {
        String strConsulta = "SELECT *FROM productos";
        try {
            PreparedStatement ps = con.conectado().prepareStatement(strConsulta);
            ResultSet res = ps.executeQuery();
            
            

            String nom_producto = "";
            String proveedor ="";
            int unidades = 0;
            int precio_venta = 0;
            
            while (res.next()) {
                nom_producto = res.getString("nom_producto");
                proveedor = res.getString("proveedor");
                unidades = res.getInt("unidades");
                precio_venta = res.getInt("precioventa");
                Object entrada[]={nom_producto,proveedor,unidades,precio_venta};
                //System.out.println(codigo + "\t" + nombre + "\t" + precio);
                tabla.addRow(entrada);
            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        
        return tabla;
    }

    String result = "";

    
}
