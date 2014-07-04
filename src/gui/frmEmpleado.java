/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmArea.java
 *
 * Created on 06/09/2011, 05:59:13 PM
 */
package gui;
import com.*;
import entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.ModeloSoftware;
/**
 *
 * @author Toditos
 */
public class frmEmpleado extends javax.swing.JFrame {
    private Usuario objUsuarioAdmin = new Usuario();
     private AreaCOM objAreaCOM = new AreaCOM();
     private CargoCOM objCargoCOM = new CargoCOM();
     private DepartamentoCOM objDepartamentoCOM = new DepartamentoCOM();
     private EmpleadoCOM objEmpleadoCOM= new EmpleadoCOM();     
       private SoftwareCOM objSoftwareCOM= new SoftwareCOM();
           
     private List<Software> listSoftwareEliminado = new ArrayList<Software>();
             
     private DefaultComboBoxModel ComboArea = new DefaultComboBoxModel();     
     private DefaultComboBoxModel ComboDepartamento = new DefaultComboBoxModel();    
     private DefaultComboBoxModel ComboCargo = new DefaultComboBoxModel();
   private DefaultComboBoxModel ComboProgramas = new DefaultComboBoxModel();
   
     private DefaultListModel modeloEmpleado = new DefaultListModel();
     
       private ModeloSoftware modeloTablaSoftware = new ModeloSoftware();
  
     

    /** Creates new form frmArea */
    public frmEmpleado(Usuario usuario) {
        initComponents();
         setLocationRelativeTo(null);
         this.objUsuarioAdmin = usuario;
            this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         cb_ListarArea.setModel(ComboArea);
         cb_ListarDepartamento.setModel(ComboDepartamento);
         cb_ListarCargo.setModel(ComboCargo);
         jListaEmpleado.setModel(modeloEmpleado);
     cb_ListarProgramas.setModel(ComboProgramas);
     
         tablaProgramas.setModel(modeloTablaSoftware);
        listarComboDepartamento();
         listarComboCargo();
         listarEmpleado();
         listarProgramas();
     
        
    }
       public void listarEmpleado()
    {     
         modeloEmpleado.clear();
        try {
            List<Empleado> listEmpleado = objEmpleadoCOM.listarTodosOrdenado();
            if(listEmpleado!=null)
            {
                for(Empleado e : listEmpleado)
                {
                    modeloEmpleado.addElement(e);
                }
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    
                     public void listarProgramas()
    {
        ComboProgramas.removeAllElements();
        ComboProgramas.addElement("(Seleccione una Opcion)");
        try {
            List<Software> listSoftware = objSoftwareCOM.listarTipoActivo(3);
            if(listSoftware!=null)
            {
                for(Software s : listSoftware)
                {
                    ComboProgramas.addElement(s);
                }
            }
        } catch (Exception e) {
      
        }
    }
         public void listarComboCargo()
    {
        ComboCargo.removeAllElements();
        ComboCargo.addElement("(Seleccione una Opcion)");
        
        try {
            List<Cargo> listCargo = objCargoCOM.listarActivosOrdenado();
            if(listCargo!=null)
            {
                for(Cargo c : listCargo)
                {
                    ComboCargo.addElement(c);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
          

          public void listarComboDepartamento()
    {
        ComboDepartamento.removeAllElements();
        ComboDepartamento.addElement("(Seleccione una Opcion)");
        try {
            List<Departamento> listDepartamento = objDepartamentoCOM.listarTodosOrdenado();
            if(listDepartamento!=null)
            {
                
                for(Departamento d : listDepartamento)
                {
                    ComboDepartamento.addElement(d);
                }
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
          
    
   
       public void limpiarControles()
    {
        lblIdEmpleado.setText("Autogenerado");
         txtNombres.setText("");  
          txtUsuario.setText("");  
          txtApellidos.setText("");  
       cboEstado.setSelectedIndex(0);
       cb_ListarDepartamento.setSelectedIndex(0);
       cb_ListarCargo.setSelectedIndex(0);
       cb_ListarProgramas.setSelectedIndex(0);
       modeloTablaSoftware.limpiar();
        modeloTablaSoftware.fireTableDataChanged();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblIdEmpleado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_ListarDepartamento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cb_ListarArea = new javax.swing.JComboBox();
        cb_ListarCargo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaProgramas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cb_ListarProgramas = new javax.swing.JComboBox();
        btnAgregarSoft = new javax.swing.JButton();
        btnQuitarSoft = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaEmpleado = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Mantenimiento de Empleados");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jPanel5.setBackground(new java.awt.Color(153, 51, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de Empleado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_user.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editclear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/update.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addGap(131, 131, 131))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Codigo :");

        lblIdEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblIdEmpleado.setText("Autogenerado");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Departamento :");

        cb_ListarDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccione una Opcion)" }));
        cb_ListarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarDepartamentoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Area :");

        cb_ListarArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccione una Opcion)" }));

        cb_ListarCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccione una Opcion)" }));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Cargo :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setText("Apellidos :");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel9.setText("Nombres :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Usuario :");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setText("Estado :");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Activo", "Activo" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdEmpleado)
                            .addComponent(cb_ListarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_ListarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_ListarArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblIdEmpleado))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_ListarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_ListarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_ListarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Sofware "));

        tablaProgramas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProgramas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(tablaProgramas);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setText("Sofware del Negocio :");

        cb_ListarProgramas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccione una Opcion)" }));

        btnAgregarSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_detalle_prod.png"))); // NOI18N
        btnAgregarSoft.setToolTipText("Agregar Accesorios");
        btnAgregarSoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSoftActionPerformed(evt);
            }
        });

        btnQuitarSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_detalle_prod.png"))); // NOI18N
        btnQuitarSoft.setToolTipText("Quitar Accesorios");
        btnQuitarSoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSoftActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sisoperativo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnAgregarSoft)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarSoft))
                    .addComponent(cb_ListarProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_ListarProgramas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitarSoft)
                            .addComponent(btnAgregarSoft)))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel3, 0, 248, Short.MAX_VALUE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jListaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListaEmpleado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    limpiarControles();

}//GEN-LAST:event_btnLimpiarActionPerformed

private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

    if(lblIdEmpleado.getText().equals("Autogenerado") && !txtNombres.getText().equals("") && !txtApellidos.getText().equals("") && !txtUsuario.getText().equals("")
            && cb_ListarDepartamento.getSelectedIndex()!=0 && cb_ListarArea.getSelectedIndex()!=0 && cb_ListarCargo.getSelectedIndex()!=0)  
        try {        
            Area objArea = new Area();
            objArea.setInt_id_area(((Area)cb_ListarArea.getSelectedItem()).getInt_id_area());
            
            Cargo objCargo = new Cargo();
            objCargo.setInt_id_cargo(((Cargo)cb_ListarCargo.getSelectedItem()).getInt_id_cargo());
            
            Empleado objEmpleado = new Empleado();
            objEmpleado.setObjCargo(objCargo);
            objEmpleado.setObjArea(objArea);
            objEmpleado.setInt_activa(cboEstado.getSelectedIndex());
            objEmpleado.setStr_nombre(txtNombres.getText());
            objEmpleado.setStr_apellido(txtApellidos.getText());
            objEmpleado.setStr_usuario(txtUsuario.getText());      
             int idEmpleado=objEmpleadoCOM.insertar(objEmpleado);
            if(idEmpleado>0)
            {  for(Software objSoftware: modeloTablaSoftware.listar())
               {                   
                   
                    objSoftwareCOM.insertarXEmpleado(idEmpleado, objSoftware.getInt_id_software());
               }
                
                JOptionPane.showMessageDialog(this,"Se Registro Correctamemte");
            }

            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this,e.getMessage());
            //JOptionPane.showMessageDialog(this,"Nombre Usuario Duplicado");
        }       
     else
            JOptionPane.showMessageDialog(this,"Todos los Datos son Necesarios");
     listarEmpleado();
     limpiarControles();
    
}//GEN-LAST:event_btnGrabarActionPerformed

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:

   if(objUsuarioAdmin.getInt_nivel()==1)
     new frmPrincipalAdmin(objUsuarioAdmin).setVisible(true);
    else
        new frmPrincipalUser(objUsuarioAdmin).setVisible(true);

}//GEN-LAST:event_formWindowClosed

private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
// TODO add your handling code here:
      modeloEmpleado.clear();
        try {
            List<Empleado> listEmpleado = objEmpleadoCOM.listarFiltro(txtBuscar.getText());
            if(listEmpleado!=null)
            {
                for(Empleado e : listEmpleado)
                {
                    modeloEmpleado.addElement(e);
                }
            }           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    
}//GEN-LAST:event_txtBuscarKeyReleased

private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed


   if(!lblIdEmpleado.getText().equals("Autogenerado")){
     if(!txtNombres.getText().equals("") && !txtApellidos.getText().equals("") && !txtUsuario.getText().equals("")
            && cb_ListarDepartamento.getSelectedIndex()!=0 && cb_ListarArea.getSelectedIndex()!=0 && cb_ListarCargo.getSelectedIndex()!=0)  
        try {       
              
            Area objArea = new Area();
            objArea.setInt_id_area(((Area)cb_ListarArea.getSelectedItem()).getInt_id_area());
            
            Cargo objCargo = new Cargo();
            objCargo.setInt_id_cargo(((Cargo)cb_ListarCargo.getSelectedItem()).getInt_id_cargo());
            
            Empleado objEmpleado = new Empleado();
            objEmpleado.setObjCargo(objCargo);
            objEmpleado.setObjArea(objArea);
            objEmpleado.setInt_activa(cboEstado.getSelectedIndex());
            objEmpleado.setStr_nombre(txtNombres.getText());
            objEmpleado.setStr_apellido(txtApellidos.getText());
            objEmpleado.setStr_usuario(txtUsuario.getText());
            objEmpleado.setInt_id_empleado(Integer.parseInt(lblIdEmpleado.getText()));
            
          
              
            if(objEmpleadoCOM.actualizar(objEmpleado))
            {
                for(Software objSoftware: listSoftwareEliminado)
               {        
    
                   objSoftwareCOM.eliminarXEmpleado(objEmpleado.getInt_id_empleado(), objSoftware.getInt_id_software());
           
               }       
                for(Software objSoftware: modeloTablaSoftware.listar())
               {                   
                   
                    objSoftwareCOM.insertarXEmpleado(objEmpleado.getInt_id_empleado(), objSoftware.getInt_id_software());
               }
                
                JOptionPane.showMessageDialog(this,"Se Actualizo Correctamemte");
            }
            

        
              
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this,e.getMessage());
           // JOptionPane.showMessageDialog(this,"Nombre Usuario Duplicado");
        }       
     else
            JOptionPane.showMessageDialog(this,"Todos los Datos son Necesarios");
          }
        else
     JOptionPane.showMessageDialog(this,"Seleccione un Empleado");
     limpiarControles();
     listarEmpleado();
}//GEN-LAST:event_btnActualizarActionPerformed

    private void jListaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaEmpleadoMouseClicked
        // TODO add your handling code here:
         String criterio = jListaEmpleado.getSelectedValue().toString();
       if(!"".equals(criterio))
       {                

                txtApellidos.setText((((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getStr_nombre()));
                txtNombres.setText(((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getStr_apellido());
                txtUsuario.setText(String.valueOf(((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getStr_usuario()));
                lblIdEmpleado.setText(String.valueOf(((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getInt_id_empleado()));

                cboEstado.setSelectedIndex((((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getInt_activa()));
                
                
                int departamento=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getObjArea().getObjDepartamento().getInt_id_departamento();
                
                   for(int i=1;i<cb_ListarDepartamento.getItemCount();i++)
                   {
                       int buscarDepartamento=((Departamento)cb_ListarDepartamento.getModel().getElementAt(i)).getInt_id_departamento();
                       if(departamento==buscarDepartamento)
                             cb_ListarDepartamento.setSelectedIndex(i); 
                   }
                   
                  int area=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getObjArea().getInt_id_area();

                    for(int i=1;i<cb_ListarArea.getItemCount();i++)
                   {
                       int buscarArea=((Area)cb_ListarArea.getModel().getElementAt(i)).getInt_id_area();
                       if(area==buscarArea)
                             cb_ListarArea.setSelectedIndex(i); 
                   }
                   
                    int cargo=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getObjCargo().getInt_id_cargo();

                   for(int i=1;i<cb_ListarCargo.getItemCount();i++)
                   {
                       int buscarCargo=((Cargo)cb_ListarCargo.getModel().getElementAt(i)).getInt_id_cargo();
                       if(cargo==buscarCargo)
                             cb_ListarCargo.setSelectedIndex(i); 
                   }
                   
                   modeloTablaSoftware.limpiar();
                 
                      try {
                List<Software>  listSoftwareEmpresarial = objSoftwareCOM.listarTipoXEmpleado(((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getInt_id_empleado(),3);
           
                if(listSoftwareEmpresarial!=null)
                   for(Software software : listSoftwareEmpresarial)
                {
           
                  modeloTablaSoftware.insertar(software);
     
                }
                      } catch (Exception e) {}
                modeloTablaSoftware.fireTableDataChanged();

       }
    }//GEN-LAST:event_jListaEmpleadoMouseClicked

private void btnAgregarSoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSoftActionPerformed
        // TODO add your handling code here:
         if(cb_ListarProgramas.getSelectedIndex()!=0)
 {


      if(!modeloTablaSoftware.insertar((Software)cb_ListarProgramas.getSelectedItem()))
                    JOptionPane.showMessageDialog(this,"Software Duplicado");
                    else
                    modeloTablaSoftware.fireTableDataChanged();
                    cb_ListarProgramas.setSelectedIndex(0);
             

 }
 else
             JOptionPane.showMessageDialog(this,"Selecione un Software");
        
        
}//GEN-LAST:event_btnAgregarSoftActionPerformed

private void btnQuitarSoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSoftActionPerformed
        // TODO add your handling code here:
          if(tablaProgramas.getSelectedRow()>-1)
        {
            Software objSoftware = new Software();
            objSoftware = modeloTablaSoftware.listar().get(tablaProgramas.getSelectedRow());
            listSoftwareEliminado.add(objSoftware);

            modeloTablaSoftware.removerItemDetalle(tablaProgramas.getSelectedRow());
            modeloTablaSoftware.fireTableDataChanged();
          
        }
        else
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
          
          
}//GEN-LAST:event_btnQuitarSoftActionPerformed

private void cb_ListarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarDepartamentoActionPerformed
// TODO add your handling code here:
 ComboArea.removeAllElements();
 ComboArea.addElement("(Seleccione una Opcion)");
 if(cb_ListarDepartamento.getSelectedIndex()!=0)
        try {
            List<Area> listGrupo = objAreaCOM.listarActivosXDepartamento(((Departamento)cb_ListarDepartamento.getSelectedItem()).getInt_id_departamento());
            if(listGrupo!=null)
            {
                for(Area c : listGrupo)
                {
                    ComboArea.addElement(c);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
}//GEN-LAST:event_cb_ListarDepartamentoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         if(!lblIdEmpleado.getText().equals("Autogenerado"))
        {
            try {
            if(objEmpleadoCOM.eliminar(Integer.parseInt(lblIdEmpleado.getText())))
            {
                JOptionPane.showMessageDialog(this,"Se Elimino Correctamemte");
                  listarEmpleado();
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"No se puede Eliminar el Empleado por que es Usado por otra tabla");
            }            
        }
        else
            JOptionPane.showMessageDialog(this,"Seleccione un Area");
        limpiarControles();
    }//GEN-LAST:event_btnEliminarActionPerformed


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarSoft;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitarSoft;
    private javax.swing.JComboBox cb_ListarArea;
    private javax.swing.JComboBox cb_ListarCargo;
    private javax.swing.JComboBox cb_ListarDepartamento;
    private javax.swing.JComboBox cb_ListarProgramas;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListaEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JTable tablaProgramas;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
