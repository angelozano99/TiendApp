package Modelo;

import Vista.vistaInventario;
import Vista.vistaRecordatorio;
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

    public ArrayList buscar(String Nit, String insert) {
        this.array = new ArrayList();
        try {
            PreparedStatement ps = con.conectado().prepareStatement(insert);
            if (Nit != null) {
                ps.setString(1, Nit);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {;
                ResultSetMetaData pss = rs.getMetaData();
                int columnCount = pss.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String name = pss.getColumnName(i);
                    array.add(rs.getString(name));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return array;
    }

    public boolean tipoUsuario(String nombre) {
        String datos[] = leerUsuario(nombre);

        if (nombre.equals("root")) {
            return true;
        } else if (datos[5].equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Usuarioexist(String nombre) {
        String datos[] = leerUsuario(nombre);
        System.out.println(datos[3]);
        if (datos[3] == null) {
            return false;
        } else {
            return true;
        }
    }

    public void ingresarPedido(int id, String proveedor, String fecha, String fecha_entrega, int valortotal) {

        String datos[] = {String.valueOf(id), proveedor, fecha, fecha_entrega, String.valueOf(valortotal)};
        insertar(datos, "INSERT INTO pedido(id_pedido,proveedor,fecha,fecha_entrega,valortotal) VALUES(?,?,?,?,?)");

    }

    public void ingresarPedido_producto(int id_pedido, String nom_producto, int cantidad) {

        String datos[] = {String.valueOf(id_pedido), nom_producto, String.valueOf(cantidad)};
        insertar(datos, "INSERT INTO pedido_productos(id_pedido,nom_producto,cantidad) VALUES(?,?,?)");

    }

    public void ingresarProducto(String nombre,
            Integer precioCompra, Integer precioVenta, Integer ganancia, Integer unidades, String proveedor) throws SQLException {

        String datos[] = {nombre, String.valueOf(precioCompra),
            String.valueOf(precioVenta), String.valueOf(ganancia), String.valueOf(unidades), proveedor};

        insertar(datos, "INSERT INTO productos (nom_producto, "
                + "preciocompra , precioventa, ganancia, unidades, proveedor) VALUES(?,?,?,?,?,?)");

    }

    public void ingresarVenta(int id_venta, String fecha, int preciototal, int gananciaventa) {

        String datos[] = {String.valueOf(id_venta), fecha, String.valueOf(preciototal), String.valueOf(gananciaventa)};
        insertar(datos, "INSERT INTO ventas (id_venta,fecha,preciototal,gananciaventa) VALUES(?,?,?,?)");

    }

    public void ingresarVenta_producto(int id_venta, String nom_producto, int cantidad) {

        String datos[] = {String.valueOf(id_venta), nom_producto, String.valueOf(cantidad)};
        insertar(datos, "INSERT INTO venta_productos (id_venta,nom_producto,cantidad) VALUES(?,?,?)");

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

    int i = 0;

    public int leerNumeroProductos() {

        boolean resultado = false;

        try {

            String read = "SELECT * FROM productos";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                i++;

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return i;
    }

    public int ProductoC(String nom_producto) {

        //boolean resultado = false;
        //vistaInventario vistaInventario = new vistaInventario();
        String[] datos = null;
        int unidades = 0;
        try {
            String read = "SELECT * FROM productos WHERE nom_producto = '" + nom_producto + "'";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                unidades = Integer.valueOf(resultSet.getString("unidades"));
            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return unidades;
    }

    public int leerTablaProducto2(String nom_producto) {

        //boolean resultado = false;
        //vistaInventario vistaInventario = new vistaInventario();
        String[] datos = null;
        int ganancia = 0;
        try {
            String read = "SELECT * FROM productos WHERE nom_producto = '" + nom_producto + "'";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ganancia = Integer.valueOf(resultSet.getString("ganancia"));
            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
        return ganancia;
    }

    public void leerTablaProducto(DefaultTableModel model) {

        boolean resultado = false;

        vistaInventario vistaInventario = new vistaInventario();
        String[] datos = null;

        try {
            String read = "SELECT * FROM productos";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                datos = new String[6];
                datos[0] = resultSet.getString("nom_producto");
                datos[1] = resultSet.getString("preciocompra");
                datos[2] = resultSet.getString("precioventa");
                datos[3] = resultSet.getString("ganancia");
                datos[4] = resultSet.getString("unidades");
                datos[5] = resultSet.getString("proveedor");

                Object filas[] = {datos[0], Integer.valueOf(datos[1]), Integer.valueOf(datos[2]),
                    Integer.valueOf(datos[4]), datos[5]};

                model.addRow(filas);

            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
    }

    public void updateProductoVenta(String nombre_producto, int cantidad) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE productos SET unidades =" + cantidad + "  WHERE nom_producto = '" + nombre_producto + "'";

            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            //ResultSet resultSet = ps.executeQuery();
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Producto modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

    public void updateProducto(String nombre,
            Integer precioCompra, Integer precioVenta, Integer ganancia, Integer unidades, String proveedor) {
        int resultado = 0;
        try {

            String updateSQL = "UPDATE productos SET  preciocompra = ?, precioventa =  ? , ganancia =  ?,"
                    + "unidades = ?, proveedor = ?" + "  WHERE nom_producto =  ?";

            PreparedStatement ps = con.conectado().prepareStatement(updateSQL);

            ps.setInt(1, precioCompra);
            ps.setInt(2, precioVenta);
            ps.setInt(3, ganancia);
            ps.setInt(4, unidades);
            ps.setString(5, proveedor);
            ps.setString(6, nombre);

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Producto modificado");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas con la actualizacion de un Contacto Comuniquese con el Administrador");
        }
    }

    public void ingresarProducto(int id, String descripcion, String linea, double precio) {
        String datos[] = {String.valueOf(id), descripcion, linea, String.valueOf(precio)};
        insertar(datos, "INSERT INTO productos (id, descripcion,linea,precio) VALUES(?,?,?,?)");

    }

    public void eliminarProducto(String nombre) {
        String deleteSQL = "DELETE FROM productos WHERE nom_producto = ?";
        delete(nombre, deleteSQL);
    }

    public void leerTablaVentas(DefaultTableModel model) {

        boolean resultado = false;

        vistaInventario vistaInventario = new vistaInventario();
        String[] datos = new String[6];

        try {
            String read = "SELECT * FROM ventas";
            PreparedStatement ps = con.conectado().prepareStatement(read);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                datos[0] = resultSet.getString("id_venta");
                leerTablaVentasAux(datos[0], model);
            }

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
        }
    }

    public void leerTablaVentasAux(String aux, DefaultTableModel model) {

        boolean resultado = false;

        String[] datos = new String[6];

        try {
            String read = "select V.cantidad,V.nom_producto,P.precioventa,P.preciocompra,P.ganancia  "
                    + "from venta_productos as V, productos as P where P.nom_producto = V.nom_producto and V.id_venta = " + aux;
            PreparedStatement ps = con.conectado().prepareStatement(read);

            int total = 0;
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                datos[0] = resultSet.getString("V.cantidad");
                datos[1] = resultSet.getString("V.nom_producto");
                datos[2] = resultSet.getString("P.precioventa");
                datos[3] = resultSet.getString("P.preciocompra");

                int f = Integer.valueOf(datos[0]) * Integer.valueOf(resultSet.getString("P.ganancia"));
                datos[4] = String.valueOf(f);

                Object filas[] = {datos[0], datos[1], Integer.valueOf(datos[2]),
                    datos[3], datos[4]};

                total += Integer.valueOf(datos[4]);

                model.addRow(filas);

            }
            

            //String read = "select M.numfactura,M.fechaFactura,M.cantidad,M.valorFactura  "
            //      + "from clientes as C, movimientos as M where C.nit = M.nit and M.nit = " + nit;
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas en la Consulta Comuniquese con el Administrador");
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
            JOptionPane.showMessageDialog(null, "Agregado Exitoso");
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

    //Metodos PEDIDO
    public DefaultTableModel listarpedido(DefaultTableModel tabla) {
        String strConsulta = "SELECT *FROM pedido";
        try {
            PreparedStatement ps = con.conectado().prepareStatement(strConsulta);
            ResultSet res = ps.executeQuery();

            String proveedor = "";
            String fecha = "";
            String fecha_entrega = "";
            int valortotal = 0;

            while (res.next()) {
                proveedor = res.getString("proveedor");
                fecha = res.getString("fecha");
                fecha_entrega = res.getString("fecha_entrega");
                valortotal = res.getInt("valortotal");
                Object entrada[] = {proveedor, fecha, fecha_entrega, valortotal};
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

    public DefaultTableModel leerpedido(JTable tabla, String fecha) {
        String[] registros = new String[5];

        String sql = "SELECT *FROM pedido WHERE fecha_entrega LIKE '%" + fecha + "%' ";

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tabla.getModel();
        //DefaultTableModel model = new DefaultTableModel(null,titulos);

        Conexion con = new Conexion();

        int p = model.getRowCount();

        for (int i = 0; i < p; i++) {
            model.removeRow(0);

        }

        try {
            Statement st = (Statement) con.conectado().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                registros[0] = rs.getString("proveedor");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("fecha_entrega");
                registros[3] = rs.getString("valortotal");

                model.addRow(registros);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }

    public DefaultTableModel filtrar(JTable tabla, String texto) {
        String[] registros = new String[4];

        String sql = "SELECT *FROM productos WHERE nom_producto LIKE '%" + texto + "%' OR proveedor LIKE '%" + texto + "%'";

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tabla.getModel();
        //DefaultTableModel model = new DefaultTableModel(null,titulos);

        //Conexion con = new Conexion();
        int p = model.getRowCount();

        for (int i = 0; i < p; i++) {
            model.removeRow(0);

        }

        try {
            Statement st = (Statement) con.conectado().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                registros[0] = rs.getString("nom_producto");
                registros[1] = rs.getString("proveedor");
                registros[2] = String.valueOf(rs.getInt("unidades"));
                registros[3] = String.valueOf(rs.getInt("precioventa"));
                //registros[4] = "1";

                model.addRow(registros);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }

    public DefaultTableModel leerproducto(JTable tabla, String nombre) {
        String[] registros = new String[5];

        String sql = "SELECT *FROM productos WHERE nom_producto LIKE '%" + nombre + "%' "
                + "OR proveedor LIKE '%" + nombre + "%'";

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tabla.getModel();
        //DefaultTableModel model = new DefaultTableModel(null,titulos);

        int p = model.getRowCount();

        for (int i = 0; i < p; i++) {
            model.removeRow(0);

        }

        try {
            Statement st = (Statement) con.conectado().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                registros[0] = rs.getString("nom_producto");
                registros[1] = rs.getString("preciocompra");
                registros[2] = rs.getString("precioventa");
                registros[3] = rs.getString("unidades");
                registros[4] = rs.getString("proveedor");

                model.addRow(registros);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return model;
    }

    public DefaultTableModel listar(DefaultTableModel tabla) {
        String strConsulta = "SELECT *FROM productos";
        try {
            PreparedStatement ps = con.conectado().prepareStatement(strConsulta);
            ResultSet res = ps.executeQuery();

            String nom_producto = "";
            String proveedor = "";
            int unidades = 0;
            int precio_venta = 0;
            //int cantidad = 1;

            int p = tabla.getRowCount();

            for (int j = 0; j < p; j++) {
                tabla.removeRow(0);
            }

            while (res.next()) {
                nom_producto = res.getString("nom_producto");
                proveedor = res.getString("proveedor");
                unidades = res.getInt("unidades");
                precio_venta = res.getInt("precioventa");
                Object entrada[] = {nom_producto, proveedor, unidades, precio_venta};
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

    public boolean campoVacio(Object a) {
        if (a.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    String result = "";

    public boolean validarnumero(String dato){
        try {
            int dato1=Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    public boolean validarnumpos(int dato){
        if (dato<0) {
            return false;
        }else{
            return true;
        }
        
    }
}
