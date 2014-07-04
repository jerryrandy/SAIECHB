/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Toditos
 */
public class Usuario {
    private int int_id_usuario;
        private String str_nombre;  
     private String str_apellido;
    private String str_usuario;
    private String str_clave;
     private int int_nivel;
    private int int_activa;

    public Usuario() {
    }

    public Usuario(int int_id_usuario, String str_nombre, String str_apellido, String str_usuario, String str_clave, int int_nivel, int int_activa) {
        this.int_id_usuario = int_id_usuario;
        this.str_nombre = str_nombre;
        this.str_apellido = str_apellido;
        this.str_usuario = str_usuario;
        this.str_clave = str_clave;
        this.int_nivel = int_nivel;
        this.int_activa = int_activa;
    }

    public int getInt_activa() {
        return int_activa;
    }

    public void setInt_activa(int int_activa) {
        this.int_activa = int_activa;
    }

    public int getInt_id_usuario() {
        return int_id_usuario;
    }

    public void setInt_id_usuario(int int_id_usuario) {
        this.int_id_usuario = int_id_usuario;
    }

    public int getInt_nivel() {
        return int_nivel;
    }

    public void setInt_nivel(int int_nivel) {
        this.int_nivel = int_nivel;
    }

    public String getStr_apellido() {
        return str_apellido;
    }

    public void setStr_apellido(String str_apellido) {
        this.str_apellido = str_apellido;
    }

    public String getStr_clave() {
        return str_clave;
    }

    public void setStr_clave(String str_clave) {
        this.str_clave = str_clave;
    }

    public String getStr_nombre() {
        return str_nombre;
    }

    public void setStr_nombre(String str_nombre) {
        this.str_nombre = str_nombre;
    }

    public String getStr_usuario() {
        return str_usuario;
    }

    public void setStr_usuario(String str_usuario) {
        this.str_usuario = str_usuario;
    }
    
     @Override
    public String toString()
    {
        return str_apellido +" "+ str_nombre;
    }
    
    
}
