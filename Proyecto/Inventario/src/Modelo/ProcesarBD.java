package Modelo;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.Date;
//import vista.vistaClientes;

public class ProcesarBD {

    private Conexion con;
    private PreparedStatement preparedStatement;

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
    
    
    public void ingresarCliente(int nit, String nombre, String direccion, String telefono, String ciudad, String tipo) {
        String datos[] = {String.valueOf(nit), nombre, direccion, telefono, ciudad, tipo};
        insertar(datos, "INSERT INTO clientes (nit, nombre,direccion,telefono,ciudad,tipo) VALUES(?,?,?,?,?,?)");
        
    }

    public void eliminarCliente(int nit) {
        String deleteSQL = "DELETE FROM clientes WHERE nit = ?";
        delete(String.valueOf(nit), deleteSQL);
    }
/*
    public String[] leerCliente(int nit) {

        boolean resultado = false;
        String[] datos = new String[5];
        try {
            vistaClientes vistaClientes;
            String read = "SELECT * FROM clientes WHERE nit = ?";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ps.setString(1, String.valueOf(nit));

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                datos[0] = resultSet.getString("nombre");
                datos[1] = resultSet.getString("direccion");
                datos[2] = resultSet.getString("telefono");
                datos[3] = resultSet.getString("ciudad");
                datos[4] = resultSet.getString("tipo");

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

    public void ingresarComprobante(String comprobante, String descripcion, String tipo, int cuenta) {
        String datos[] = {comprobante, descripcion, tipo, String.valueOf(cuenta)};
        insertar(datos, "INSERT INTO comprobante (comprobante, descripcion,tipo,cuenta) VALUES(?,?,?,?)");

    }

    public void eliminarComprobante(String comprobante) {
        String deleteSQL = "DELETE FROM comprobante WHERE comprobante = ?";
        delete(comprobante, deleteSQL);
    }
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
    public void updateComprobante(String comprobante, String descripcion, String tipo, String cuenta) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE comprobante SET  descripcion  = ?, tipo =  ? ,cuenta =  ?" + "  WHERE comprobante =  ?";
            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            ps.setString(1, descripcion);
            ps.setString(2, tipo);
            ps.setString(3, cuenta);
            ps.setString(4, comprobante);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Comprobante modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

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

            System.out.println(datos.length);
            for (int i = 0; i <= datos.length - 1; i++) {
                ps.setString(i + 1, datos[i]);

                System.out.println("Entra");
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
   

    public void listar() {
        String strConsulta = "SELECT *FROM articulo";
        try {
            PreparedStatement ps = con.conectado().prepareStatement(strConsulta);
            ResultSet res = ps.executeQuery();

            String codigo = "";
            String nombre = "";
            int precio = 0;
            while (res.next()) {
                codigo = res.getString("id_arti");
                nombre = res.getString("nom_art");
                precio = res.getInt("precio_art");
                System.out.println(codigo + "\t" + nombre + "\t" + precio);
            }
            res.close();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    String result = "";

    public String query1(String nit) throws SQLException {

        PreparedStatement ps;
        String query1 = "select M.numfactura,M.fechaFactura,M.cantidad,M.valorFactura  "
                + "from clientes as C, movimientos as M where C.nit = M.nit and M.nit = " + nit;

        ps = con.conectado().prepareStatement(query1);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            
            result += " " + " Numero Factura: " + resultSet.getString("numfactura");
            result += " " + " Fecha Factura: " + resultSet.getString("fechaFactura");
            result += " " + " Cantidad: " + resultSet.getString("cantidad");
            result += " " + " valor Factura: " + resultSet.getString("valorFactura") + " ||| ";

        }

        ps.execute();
        ps.close();

        return result;
    }
    
        public String query2(String date1, String date2) throws SQLException {

        PreparedStatement ps;
        String query1 = "select M.numfactura,M.fechaFactura,M.cantidad,M.valorFactura "
                + "from movimientos as M where M.fechaFactura between '"+date1+"' and '"+date2+"'";

        ps = con.conectado().prepareStatement(query1);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            
            result += " " + " Numero Factura: " + resultSet.getString("numfactura");
            result += " " + " Fecha Factura: " + resultSet.getString("fechaFactura");
            result += " " + " Cantidad: " + resultSet.getString("cantidad");
            result += " " + " valor Factura: " + resultSet.getString("valorFactura") + " ||| ";

        }

        ps.execute();
        ps.close();

        return result;
    }
        
          public String query3(String numFactura) throws SQLException {

        PreparedStatement ps;
        String query1 = "select P.id, P.descripcion, P.linea, P.precio  "
                + "from productos as P, movimientos as M where P.id = M.id and M.numFactura = " + numFactura;

        ps = con.conectado().prepareStatement(query1);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            
            result += " " + " id: " + resultSet.getString("id");
            result += " " + " Descripcion: " + resultSet.getString("descripcion");
            result += " " + " Linea: " + resultSet.getString("linea");
            result += " " + " Precio: " + resultSet.getString("precio") + " ||| ";

        }

        ps.execute();
        ps.close();

        return result;
    }
          
        
        public String query4(int id_vdor) throws SQLException {

        PreparedStatement ps;
        String query1 = " select sum(M.valorFactura)  "
                + "from movimientos as M,vendedor as V where V.id_Vdor = " + id_vdor+" and M.id_Vdor= "+id_vdor;

        ps = con.conectado().prepareStatement(query1);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            
            result += " " + " Valor total de ventas: " + resultSet.getString("sum(M.valorFactura)");
        
        }

        ps.execute();
        ps.close();

        return result;
    }
        
  

        
        public String query5() throws SQLException {

        PreparedStatement ps;
        String query1 = " select M.id,count(M.id) as total  "
                + "from movimientos as M group by M.id order by 2 desc";

        ps = con.conectado().prepareStatement(query1);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            
            result += " " + " Id_producto: " + resultSet.getString("id");
            result += " " + " total: " + resultSet.getString("total");
            result += " " + " /////////" ;
        }

        ps.execute();
        ps.close();

        return result;
    }
}
