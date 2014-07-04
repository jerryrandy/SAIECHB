/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;





import entidades.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class EquipoDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";
         
              public static String verificarNSerie(String nSerie) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
              Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
             String sql="SELECT id_equipo From equipo Where id_equipo="+nSerie;
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                   rpta = dr.getString(1);  
            }

        } catch (Exception e) {
            throw new Exception("Verifica "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }

         public static boolean insertar(Equipo objEquipo) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
               String sql="INSERT INTO equipo (id_equipo,id_componente,id_empleado,estado) VALUES ('"+
                       objEquipo.getStr_id_equipo()+"','"+objEquipo.getObjComponente().getStr_id_componente()+
                        "','"+objEquipo.getObjEmpleado().getInt_id_empleado()+"','"+objEquipo.getInt_estado()+"');";
           
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
            String IdComponente= objEquipo.getObjComponente().getStr_id_componente();
           if(rpta)
           {           
                         ComponenteDAO.actualizarEstado(IdComponente,2);            
           }
          
        } catch (Exception e) {
            throw new Exception("Registrar Equipo "+e.getMessage(), e);
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

        

         
         
         
         
            public static List<Equipo> listarTodosOrdenado(int Estado) throws Exception
    {
        List<Equipo> listEquipo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {           
              Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
                     String sql="SELECT equipo.id_equipo,equipo.id_componente,"
                             + "equipo.id_empleado,equipo.estado,componente.id_modelo,"
                             + "componente.caracteristica,modelo.id_marca,modelo.id_tipo,modelo.nombre,"
                             + "modelo.caracteristica,marca.nombre,tipo.nombre,empleado.id_cargo,"
                             + "empleado.id_area,empleado.apellidos,empleado.nombres,area.nombre,"
                             + "area.id_departamento,departamento.nombre,cargo.nombre from equipo "
                             + "inner join empleado inner join area inner join departamento inner join "
                             + "cargo inner join componente join modelo join tipo join marca where "
                             + "equipo.id_empleado=empleado.id_empleado and empleado.id_area=area.id_area "
                             + "and area.id_departamento=departamento.id_departamento and empleado.id_cargo=cargo.id_cargo "
                             + "and equipo.id_componente=componente.id_componente and componente.id_modelo=modelo.id_modelo "
                             + "and modelo.id_marca=marca.id_marca and modelo.id_tipo=tipo.id_tipo and equipo.estado='"+Estado+"' order by marca.nombre ASC";
        
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listEquipo == null)
                    listEquipo = new ArrayList<Equipo>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(13));
                    objCargo.setStr_nombre(dr.getString(20));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(18));
                    objDepartamento.setStr_nombre(dr.getString(19));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(14));
                    objArea.setStr_nombre(dr.getString(17));
                    objArea.setObjDepartamento(objDepartamento);                      
                    
                    
                    Empleado objEmpleado=new Empleado();
                    objEmpleado.setInt_id_empleado(dr.getInt(3));
                    objEmpleado.setStr_apellido(dr.getString(15));
                    objEmpleado.setStr_nombre(dr.getString(16));               
                    objEmpleado.setObjArea(objArea);
                    objEmpleado.setObjCargo(objCargo);
                    
                     Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(7));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(8));
                objTipo.setStr_nombre(dr.getString(12));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(5));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(9));
                 objModelo.setStr_caracteristica(dr.getString(10));
                 
                   Componente objComponente = new Componente();
                    objComponente.setStr_id_componente(dr.getString(2));
                    objComponente.setStr_caracteristica(dr.getString(6));
                    objComponente.setObjModelo(objModelo);

                                             
                 Equipo equipo = new Equipo(dr.getString(1),objComponente,objEmpleado,dr.getInt(4));
 
                listEquipo.add(equipo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Equipos "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listEquipo;
    }
           
             public static boolean eliminar(String IdEquipo) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
              Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="Delete From equipo Where id_equipo like '"+IdEquipo+"'";
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Equipo "+e.getMessage(), e);
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
