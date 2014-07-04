package modelo;


import entidades.Equipo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloEquipo extends AbstractTableModel {
    List<Equipo> items = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloEquipo() {
       items = new ArrayList<Equipo>();
        headers = new ArrayList<String>();
         headers.add(new String("N.Patrimonial"));
         headers.add(new String("N.Serie"));  
          headers.add(new String("Marca"));
          headers.add(new String("Tipo"));
        headers.add(new String("Modelo"));
        headers.add(new String("Departamento"));
        headers.add(new String("Area"));
         headers.add(new String("Asignado"));
          headers.add(new String("Cargo"));
    }

    public void limpiar()
    {
        items.clear();
    }

       public List<Equipo> listar()
    {
        return items;
    }
   public boolean insertar(Equipo equipo)
    {

        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                  Equipo item = items.get(i);
                    if(item.getStr_id_equipo().equals(equipo.getStr_id_equipo()))
                       igual=false;
                   
                }
            if(igual)
            items.add(equipo);
        return igual;
    }
   
     public void insertarLista(List<Equipo> listaEquipo)
    {
        items =listaEquipo;
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
            Equipo datos = items.get(rowIndex);
        switch(columnIndex)
        {
             case 0:
                 return datos.getStr_id_equipo();
                
            case 1:
                 return datos.getObjComponente().getStr_id_componente();
           case 2:
                return 
                       datos.getObjComponente().getObjModelo().getObjMarca().getStr_nombre();
           case 3:
                return 
                       datos.getObjComponente().getObjModelo().getObjTipo().getStr_nombre();

           case 4:
                return 
                       datos.getObjComponente().getObjModelo().getStr_nombre()+" "+ 
                        datos.getObjComponente().getObjModelo().getStr_caracteristica()+" "+ 
                        datos.getObjComponente().getStr_caracteristica();
            case 5:
                return 
                       datos.getObjEmpleado().getObjArea().getObjDepartamento().getStr_nombre();
           case 6:
                return 
                       datos.getObjEmpleado().getObjArea().getStr_nombre();
          case 7:
                return datos.getObjEmpleado().getStr_apellido()+" "+datos.getObjEmpleado().getStr_nombre();
          case 8:
                return datos.getObjEmpleado().getObjCargo().getStr_nombre();

        }
        return null;
    }
}
