/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


/**
 *
 * @author Toditos
 */
public class Departamento {
    private int int_id_departamento;
    private String str_nombre;
    private String str_iniciales;
    private int intl_activa;
    
    private String str_descripcion;
     

    public Departamento() {
    }

    public Departamento(int int_id_departamento, String str_nombre, String str_iniciales) {
        this.int_id_departamento = int_id_departamento;
        this.str_nombre = str_nombre;
        this.str_iniciales = str_iniciales;
    }

    
    public Departamento(int int_id_departamento, String str_nombre, String str_iniciales, int intl_activa, String str_descripcion) {
        this.int_id_departamento = int_id_departamento;
        this.str_nombre = str_nombre;
        this.str_iniciales = str_iniciales;
        this.intl_activa = intl_activa;
        this.str_descripcion = str_descripcion;
    }



    public String getStr_iniciales() {
        return str_iniciales;
    }

    public void setStr_iniciales(String str_iniciales) {
        this.str_iniciales = str_iniciales;
    }
    
    


    public int getInt_id_departamento() {
        return int_id_departamento;
    }

    public void setInt_id_departamento(int int_id_departamento) {
        this.int_id_departamento = int_id_departamento;
    }

    public int getIntl_activa() {
        return intl_activa;
    }

    public void setIntl_activa(int intl_activa) {
        this.intl_activa = intl_activa;
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
