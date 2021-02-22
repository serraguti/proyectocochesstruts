package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Coche;
import oracle.jdbc.OracleDriver;

public class RepositoryCoches {
    private Connection getConnection() throws SQLException{
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn = DriverManager.getConnection(cadena,"system","oracle");
        return cn;
    }
    
    public ArrayList<Coche> getCoches() throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select * from coches";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Coche> coches = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("IDCOCHE");
            String marca = rs.getString("MARCA");
            String modelo = rs.getString("MODELO");
            String conductor = rs.getString("CONDUCTOR");
            String imagen = rs.getString("IMAGEN");
            Coche car = new Coche(id, marca, modelo, conductor, imagen);
            coches.add(car);
        }
        rs.close();
        cn.close();
        return coches;
    }
    
    public Coche buscarCoche(int idcoche) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select * from coches where idcoche=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idcoche);
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            int id = rs.getInt("IDCOCHE");
            String marca = rs.getString("MARCA");
            String modelo = rs.getString("MODELO");
            String conductor = rs.getString("CONDUCTOR");
            String imagen = rs.getString("IMAGEN");
            Coche car = new Coche(id, marca, modelo, conductor, imagen);
            rs.close();
            cn.close();
            return car;
        }else{
            rs.close();
            cn.close();
            return null;
        }
    }
    
    public void insertarCoche(int id, String marca, String modelo
    , String conductor, String imagen) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "insert into coches values (?,?,?,?,?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.setString(2, marca);
        pst.setString(3, modelo);
        pst.setString(4, conductor);
        pst.setString(5, imagen);
        pst.executeUpdate();
        cn.close();
    }
    
    public void modificarCoche(int id, String marca, String modelo
    , String conductor, String imagen) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "update coches set marca=?, modelo=? "
                + ", conductor=?, imagen=? where idcoche=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, marca);
        pst.setString(2, modelo);
        pst.setString(3, conductor);
        pst.setString(4, imagen);
        pst.setInt(5, id);
        pst.executeUpdate();
        cn.close();
    }
    
    public void eliminarCoche(int id) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "delete from coches where idcoche=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        cn.close();
    }
    
    public ArrayList<Coche> buscarCochesMarca(String marca) throws SQLException{
        Connection cn = this.getConnection();
        String sql = "select * from coches where upper(marca) like upper(?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, "%" + marca + "%");
        ResultSet rs = pst.executeQuery();
        ArrayList<Coche> coches = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("IDCOCHE");
            String marc = rs.getString("MARCA");
            String modelo = rs.getString("MODELO");
            String conductor = rs.getString("CONDUCTOR");
            String imagen = rs.getString("IMAGEN");
            Coche car = new Coche(id, marc, modelo, conductor, imagen);
            coches.add(car);
        }
        rs.close();
        cn.close();
        if (coches.size() == 0){
            return null;
        }else{
            return coches;
        }
    }
}
