package modelo;


import entidades.Software;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloSoftware extends AbstractTableModel {
    List<Software> items = null;
    List<String> headers = null;
    double totalLista=0;

    public ModeloSoftware() {
       items = new ArrayList<Software>();
        headers = new ArrayList<String>();
        headers.add(new String("Nombre"));
    }

    public void limpiar()
    {
        items.clear();
    }

   public boolean insertar(Software software)
    {

        boolean igual=true;

            for(int i=0;i<items.size();i++)
                {
                  Software item = items.get(i);
                    if(item.getInt_id_software()==(software.getInt_id_software()))
                       igual=false;
                  
                }
            if(igual)
            items.add(software);
        return igual;
    }

    public void insertarLista(List<Software> listaSoftware)
    {
        items =listaSoftware;
    }
    
   public void removerItemDetalle(int rowIndex)
    {

        items.remove(rowIndex);
    }
    
    public List<Software> listar()
    {
        return items;
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
            Software datos = items.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return datos.getStr_nombre();
        }
        return null;
    }
}
