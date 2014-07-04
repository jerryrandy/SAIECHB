package modelo;


import entidades.Computador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloComputador extends AbstractTableModel {
    List<Computador> items = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloComputador() {
       items = new ArrayList<Computador>();
        headers = new ArrayList<String>();
        headers.add(new String("Nombre"));
        headers.add(new String("Departamento"));
        headers.add(new String("Area"));
         headers.add(new String("Asignado"));
          headers.add(new String("Cargo"));
    }

    public void limpiar()
    {
        items.clear();
    }

       public List<Computador> listar()
    {
        return items;
    }
   public boolean insertar(Computador computador)
    {

        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                  Computador item = items.get(i);
                    if(item.getStr_id_computador().equals(computador.getStr_id_computador()))
                       igual=false;
                   
                }
            if(igual)
            items.add(computador);
        return igual;
    }
   
     public void insertarLista(List<Computador> listaComputador)
    {
        items =listaComputador;
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
            Computador datos = items.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getStr_id_computador();
           case 1:
                return 
                       datos.getObjEmpleado().getObjArea().getObjDepartamento().getStr_nombre();
           case 2:
                return 
                       datos.getObjEmpleado().getObjArea().getStr_nombre();
          case 3:
                return datos.getObjEmpleado().getStr_apellido()+" "+datos.getObjEmpleado().getStr_nombre();
          case 4:
                return datos.getObjEmpleado().getObjCargo().getStr_nombre();
              
        }
        return null;
    }
}
