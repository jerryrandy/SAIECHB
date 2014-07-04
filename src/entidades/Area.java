/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class Area {
   private int int_id_area;
    private Departamento objDepartamento;
   private String str_nombre;
   private int intl_activa;
  
     private String str_descripcion;
   
    public Area() {
    }

    
    
    public Area(int int_id_area, Departamento objDepartamento, String str_nombre, int intl_activa, String str_descripcion) {
        this.int_id_area = int_id_area;
        this.objDepartamento = objDepartamento;
        this.str_nombre = str_nombre;
        this.intl_activa = intl_activa;
        this.str_descripcion = str_descripcion;
    }  

    public int getIntl_activa() {
        return intl_activa;
    }

    public Departamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(Departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }
    

    public void setIntl_activa(int intl_activa) {
        this.intl_activa = intl_activa;
    }


    public int getInt_id_area() {
        return int_id_area;
    }

    public void setInt_id_area(int int_id_area) {
        this.int_id_area = int_id_area;
    }

    public String getStr_descripcion() {
        return str_descripcion;
    }

    public void setStr_descripcion(String str_descripcion) {
        this.str_descripcion = str_descripcion;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    

     @Override
    public String toString()
    {
        return str_nombre;
    }
}
