package modelo;


import entidades.Portatil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloPortatil extends AbstractTableModel {
    List<Portatil> items = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloPortatil() {
       items = new ArrayList<Portatil>();
        headers = new ArrayList<String>();
        headers.add(new String("Nombre"));
         headers.add(new String("Nr. Patrimonial"));        
        headers.add(new String("Departamento"));
        headers.add(new String("Area"));
         headers.add(new String("Asignado"));
          headers.add(new String("Cargo"));
    }

    public void limpiar()
    {
        items.clear();
    }

       public List<Portatil> listar()
    {
        return items;
    }
   public boolean insertar(Portatil portatil)
    {

        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                  Portatil item = items.get(i);
                    if(item.getStr_id_portatil().equals(portatil.getStr_id_portatil()))
                       igual=false;
                   
                }
            if(igual)
            items.add(portatil);
        return igual;
    }
   
     public void insertarLista(List<Portatil> listaPortatil)
    {
        items =listaPortatil;
    }

   public void removerItemDetalle(int rowIndex)
    {

        items.remove(rowIndex);
    }
    


    public int getRowCount() {
        return items.size();
    }

    public int getColumnCount() {
        return headers.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return headers.get(columnIndex).toString();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
            Portatil datos = items.get(rowIndex);
        switch(columnIndex)
        {
             case 0:
                 return datos.getStr_nombre();
            case 1:
                return datos.getStr_id_portatil();
           case 2:
                return 
                       datos.getObjEmpleado().getObjArea().getObjDepartamento().getStr_nombre();
           case 3:
                return 
                       datos.getObjEmpleado().getObjArea().getStr_nombre();
          case 4:
                return datos.getObjEmpleado().getStr_apellido()+" "+datos.getObjEmpleado().getStr_nombre();
          case 5:
                return datos.getObjEmpleado().getObjCargo().getStr_nombre();
              
        }
        return null;
    }
}
