package entidades;
import java.io.Serializable;
import java.util.List;


public class CPU implements Serializable {

    private String str_id_cpu;
    private Software objSoftware;
    private int int_estado;
    private List<DetalleCPU> detalleAccesorios;
    
    public CPU() {
      
    }

    public CPU(String str_id_cpu, Software objSoftware, int int_estado) {
        this.str_id_cpu = str_id_cpu;
        this.objSoftware = objSoftware;
        this.int_estado = int_estado;
    }

    public CPU(String str_id_cpu, Software objSoftware, int int_estado, List<DetalleCPU> detalleAccesorios) {
        this.str_id_cpu = str_id_cpu;
        this.objSoftware = objSoftware;
        this.int_estado = int_estado;
        this.detalleAccesorios = detalleAccesorios;
    }
    

       
    public static class DetalleCPU implements Serializable
    {
        private Componente objComponente;
         private int int_estado;

        public DetalleCPU(Componente objComponente) {
            this.objComponente = objComponente;
        }

        public DetalleCPU(Componente objComponente, int int_estado) {
            this.objComponente = objComponente;
            this.int_estado = int_estado;
        }

        public int getInt_estado() {
            return int_estado;
        }

        public void setInt_estado(int int_estado) {
            this.int_estado = int_estado;
        }

       

        public Componente getObjComponente() {
            return objComponente;
        }

        public void setObjComponente(Componente objComponente) {
            this.objComponente = objComponente;
        }
 
    }

    public List<DetalleCPU> getDetalleAccesorios() {
        return detalleAccesorios;
    }

    public void setDetalleAccesorios(List<DetalleCPU> detalleAccesorios) {
        this.detalleAccesorios = detalleAccesorios;
    }

    public Software getObjSoftware() {
        return objSoftware;
    }

    public void setObjSoftware(Software objSoftware) {
        this.objSoftware = objSoftware;
    }



    public String getStr_id_cpu() {
        return str_id_cpu;
    }

    public void setStr_id_cpu(String str_id_cpu) {
        this.str_id_cpu = str_id_cpu;
    }

    public List<DetalleCPU> getDetalleCPU() {
        return detalleAccesorios;
    }

    public void setDetalleCPU(List<DetalleCPU> detalleCPU) {
        this.detalleAccesorios = detalleCPU;
    }

    public int getInt_estado() {
        return int_estado;
    }

    public void setInt_estado(int int_estado) {
        this.int_estado = int_estado;
    }

      @Override
    public String toString()
    {
        return str_id_cpu;
    }

}
