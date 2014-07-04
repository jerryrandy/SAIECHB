
package dao;



import entidades.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
      public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";
    
              public static int insertar(Empleado objEmpleado) throws Exception
    {
        
        int rpta=-1;
        Connection conn = null;
        Statement stmt = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            stmt = (Statement) conn.createStatement();
            String sql="INSERT INTO empleado (id_cargo, id_area, apellidos,nombres,usuario,activa,estado) VALUES ('"+
                     objEmpleado.getObjCargo().getInt_id_cargo()+"','"+objEmpleado.getObjArea().getInt_id_area()+
                     "', '"+objEmpleado.getStr_apellido()+"','"+objEmpleado.getStr_nombre()+
                    "', '"+objEmpleado.getStr_usuario()+"','"+objEmpleado.getInt_activa()+"','0');";
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
             ResultSet resulset = stmt.getGeneratedKeys();

            if (resulset.next()) {
                rpta = resulset.getInt(1);
            }
            
        } catch (Exception e) {
            throw new Exception("Registrar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
          
       
       public static boolean actualizar(Empleado objEmpleado) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
             String sql="UPDATE empleado SET id_cargo='"+objEmpleado.getObjCargo().getInt_id_cargo()+
                     "', id_area='"+objEmpleado.getObjArea().getInt_id_area()+
                     "',apellidos='"+objEmpleado.getStr_apellido()+"',nombres='"+objEmpleado.getStr_nombre()+
                     "',usuario='"+objEmpleado.getStr_usuario()+"',activa='"+objEmpleado.getInt_activa()+
                     "' WHERE id_empleado = '"+objEmpleado.getInt_id_empleado()+"'";
          
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Actualizar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

        public static List<Empleado> listarFiltro(String filtro) throws Exception
    {
        List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo and (empleado.nombres like '%"+filtro+"%' or "
                    + "empleado.apellidos like '%"+filtro+"%' or area.nombre like '%"+filtro+"%' or "
                    + "departamento.nombre like '"+filtro+"%' or empleado.usuario like '"+filtro+"%') "
                    + "order by empleado.apellidos ASC";
                    
                   
         
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }

              public static List<Empleado> listarFiltroAsignado(String filtro,int Estado) throws Exception
    {
        List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo and (empleado.nombres like '%"+filtro+"%' or "
                    + "empleado.apellidos like '%"+filtro+"%' or area.nombre like '%"+filtro+"%' or "
                    + "departamento.nombre like '"+filtro+"%' or empleado.usuario like '"+filtro+"%') "
                    + "and empleado.estado="+Estado+"  order by empleado.apellidos ASC";
                    
                   
          
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }

    public static List<Empleado> listarTodosOrdenado()throws Exception
    {
        List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo order by empleado.apellidos ASC";
            
            
          
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

         while(dr.next())
            {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }
    
      public static List<Empleado> listarTodosActivos()throws Exception
    {
        List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo and empleado.activa=1 order by empleado.apellidos ASC";
            
            
          
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

         while(dr.next())
            {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }


     public static List<Empleado> listarEmpleadoXArea(int idArea)throws Exception
    {
       List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo and area.id_area="+idArea+" order by empleado.apellidos ASC";
            
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
             {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }
     
          public static List<Empleado> listarEmpleadoXAreaAsigando(int idArea,int Estado)throws Exception
    {
       List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo and area.id_area="+idArea
                    +" and empleado.activa=1 and empleado.estado="+Estado+" order by empleado.apellidos ASC";
            
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
             {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }
     
      public static List<Empleado> listarEmpleadoAsignado(int Estado)throws Exception
    {
       List<Empleado> listEmpleado = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT empleado.id_empleado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre from empleado inner join area inner join departamento "
                    + "inner join cargo  where empleado.id_area=area.id_area and area.id_departamento=departamento.id_departamento "
                    + "and empleado.id_cargo=cargo.id_cargo and empleado.activa=1 and empleado.estado="+Estado+" order by empleado.apellidos ASC";
            
          
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
             {
                 if(listEmpleado == null)
                    listEmpleado = new ArrayList<Empleado>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(2));
                    objCargo.setStr_nombre(dr.getString(12));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(10));
                    objDepartamento.setStr_nombre(dr.getString(11));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(3));
                    objArea.setStr_nombre(dr.getString(9));
                    objArea.setObjDepartamento(objDepartamento);
                
                 Empleado objEmpleado = new Empleado(dr.getInt(1),objCargo,objArea,dr.getString(4),dr.getString(5),dr.getString(6),dr.getInt(7),dr.getInt(8));
                listEmpleado.add(objEmpleado);
            }

        } catch (Exception e) {
            throw new Exception("Listar Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEmpleado;
    }
      
              public static boolean actualizarEstado(int IdEmpleado,int Estado) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="UPDATE empleado SET estado='"+Estado+
                    "' WHERE id_empleado = '"+IdEmpleado+"'";
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Estado "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
              
               
       public static boolean eliminar(int IdEmpleado) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="Delete From empleado Where id_empleado="+IdEmpleado;
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Empleado "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

}
