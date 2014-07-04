/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author prac_hbt
 */
public class Software {
   
    private int int_id_software;
    private String str_nombre;
    private int int_tipo;
    private int int_activa;

    public Software() {
    }

    public Software(int int_id_software, String str_nombre, int int_tipo, int int_activa) {
        this.int_id_software = int_id_software;
        this.str_nombre = str_nombre;
        this.int_tipo = int_tipo;
        this.int_activa = int_activa;
    }

    
    public int getInt_id_software() {
        return int_id_software;
    }

    public void setInt_id_software(int int_id_software) {
        this.int_id_software = int_id_software;
    }

    public int getInt_tipo() {
        return int_tipo;
    }

    public void setInt_tipo(int int_tipo) {
        this.int_tipo = int_tipo;
    }

    public int getInt_activa() {
        return int_activa;
    }

    public void setInt_activa(int int_activa) {
        this.int_activa = int_activa;
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
