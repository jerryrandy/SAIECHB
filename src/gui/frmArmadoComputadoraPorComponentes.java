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
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.*;
/**
 *
 * @author Toditos
 */
public class frmArmadoComputadoraPorComponentes extends javax.swing.JFrame {

    private Usuario objUsuarioAdmin = new Usuario();
    private TipoCOM objTipoCOM = new TipoCOM();
    private ComponenteCOM objComponenteCOM = new ComponenteCOM();
    private DepartamentoCOM objDepartamentoCOM = new DepartamentoCOM();
     private AreaCOM objAreaCOM = new AreaCOM();
    private EmpleadoCOM objEmpleadoCOM= new EmpleadoCOM(); 
    private ComputadorCOM objComputadorCOM= new ComputadorCOM(); 
     private CPUCOM objCPUCOM= new CPUCOM(); 
     private MonitorCOM objMonitorCOM= new MonitorCOM(); 
           private AccesoriosCOM objAccesoriosCOM= new AccesoriosCOM(); 
           private CPatrimonialCOM objCPatrimonialCOM= new CPatrimonialCOM();
           private SoftwareCOM objSoftwareCOM= new SoftwareCOM();
           

     
      private ModeloDetalleCPU modeloTablaComponente = new ModeloDetalleCPU();
       private ModeloAccesorios modeloTablaAccesorios = new ModeloAccesorios();
      
      
   private DefaultComboBoxModel ComboSoftware = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboComponenteCPU = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboComponenteMonitor = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboTipo = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboDepartamento = new DefaultComboBoxModel();
      private DefaultComboBoxModel ComboArea = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboEmpleado = new DefaultComboBoxModel();
     private DefaultComboBoxModel ComboComponenteAcc = new DefaultComboBoxModel();
     
     private DefaultListModel modeloEmpleado = new DefaultListModel();
     

    public frmArmadoComputadoraPorComponentes(Usuario usuario) {
        initComponents();
           this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);
         this.objUsuarioAdmin = usuario;
         cb_ListarTipo.setModel(ComboTipo);

         cb_ListarComponenteCPU.setModel(ComboComponenteCPU);
         
        
         tablaDetalleCPU.setModel(modeloTablaComponente);
         tablaDetalleAcc.setModel(modeloTablaAccesorios);

         
          cb_ListarArea.setModel(ComboArea);
         cb_ListarDepartamento.setModel(ComboDepartamento);
         


         cb_ListarEmpleado.setModel(ComboEmpleado);
         
         jListaEmpleado.setModel(modeloEmpleado);
         cb_ListarSistema.setModel(ComboSoftware);
          cb_ListarComponenteAcc.setModel(ComboComponenteAcc);
          cb_ListarComponenteMonitor.setModel(ComboComponenteMonitor);
         
         tablaDetalleCPU.getColumnModel().getColumn(0).setMaxWidth(100);
         tablaDetalleAcc.getColumnModel().getColumn(0).setMaxWidth(100);
           tablaDetalleCPU.getColumnModel().getColumn(0).setMinWidth(100);
         tablaDetalleAcc.getColumnModel().getColumn(0).setMinWidth(100);
           tablaDetalleAcc.getColumnModel().getColumn(1).setMaxWidth(100);
            tablaDetalleAcc.getColumnModel().getColumn(1).setMinWidth(100);
           
         listarComboTipo();
         listarComboMonitor();
         listarComboDepartamento();
         listarEmpleado();
         listarComboAccesorios();
         listarSistema();

    }
       public void listarEmpleado()
    {     
         modeloEmpleado.clear();
        try {
            List<Empleado> listEmpleado = objEmpleadoCOM.listarEmpleadoAsignado(0);
            if(listEmpleado!=null)
            {
                for(Empleado e : listEmpleado)
                {
                    modeloEmpleado.addElement(e);
                }
            }           
        } catch (Exception e) {
         
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
        
        }
    }
          
         public void listarComboTipo()
    {
        ComboTipo.removeAllElements();
        ComboTipo.addElement("(Seleccione una Opcion)");
        try {
            List<Tipo> listTipo = objTipoCOM.listarTipoUbicacionActivo(2);
            if(listTipo!=null)
            {
                for(Tipo t : listTipo)
                {
                    ComboTipo.addElement(t);
                }
            }
        } catch (Exception e) {
      
        }
    }
              public void listarSistema()
    {
        ComboSoftware.removeAllElements();
        ComboSoftware.addElement("(Seleccione una Opcion)");
        try {
            List<Software> listSoftware = objSoftwareCOM.listarTipoActivo(1);
            if(listSoftware!=null)
            {
                for(Software s : listSoftware)
                {
                    ComboSoftware.addElement(s);
                }
            }
        } catch (Exception e) {
      
        }
    }
         
            
         public void listarComboMonitor()
    {
        ComboComponenteMonitor.removeAllElements();
        ComboComponenteMonitor.addElement("(Seleccione una Opcion)");
         try {
            List<Componente> listComponente = objComponenteCOM.listarComponentesxUbicacion(1,1);
            if(listComponente!=null)
            {
                for(Componente c : listComponente)
                {
                    ComboComponenteMonitor.addElement(c);
                }
            }
        } catch (Exception e) {
           
        }
          
         
  
    }
         
            public void listarComboAccesorios()
    {
        ComboComponenteAcc.removeAllElements();
        ComboComponenteAcc.addElement("(Seleccione una Opcion)");
         try {
            List<Componente> listComponente = objComponenteCOM.listarComponentesxUbicacion(3,1);
            if(listComponente!=null)
            {
                for(Componente c : listComponente)
                {
                    ComboComponenteAcc.addElement(c);
                }
            }
        } catch (Exception e) {
           
        }
  
    }
          

       public void limpiarControles()
    {
        cb_ListarSistema.setSelectedIndex(0);
        cb_ListarDepartamento.setSelectedIndex(0);
      cb_ListarComponenteAcc.setSelectedIndex(0);
     cb_ListarComponenteMonitor.setSelectedIndex(0);
             cb_ListarTipo.setSelectedIndex(0);
      txtIdComputador.setText("");
      txtIdMonitor.setText("");
      txtIdCPU.setText("");
      txtNPAccesorios.setText("");
      txtBuscar.setText("");
      modeloTablaAccesorios.limpiar();
      modeloTablaAccesorios.fireTableDataChanged();
      modeloTablaComponente.limpiar();
      modeloTablaComponente.fireTableDataChanged();

       listarEmpleado();

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cb_ListarComponenteMonitor = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        txtIdMonitor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblNPMonitor = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleCPU = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cb_ListarTipo = new javax.swing.JComboBox();
        cb_ListarComponenteCPU = new javax.swing.JComboBox();
        btnAgregarCPU = new javax.swing.JButton();
        btnQuitarCPU = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtIdCPU = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblNPCPU = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        cb_ListarEmpleado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_ListarArea = new javax.swing.JComboBox();
        cb_ListarDepartamento = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListaEmpleado = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnAgregarAc = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDetalleAcc = new javax.swing.JTable();
        cb_ListarComponenteAcc = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        txtNPAccesorios = new javax.swing.JTextField();
        btnQuitarCPU1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblNPAcc = new javax.swing.JLabel();
        txtIdComputador = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblNComputador = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cb_ListarSistema = new javax.swing.JComboBox();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Armado de Computador por Componentes");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));

        jPanel5.setBackground(new java.awt.Color(153, 51, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Armado de Computador por Componentes");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computador.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(158, 158, 158))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel21.setText("Nro. Patrimonial :");

        txtIdMonitor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdMonitorKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/monitor.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNPMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cb_ListarComponenteMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtIdMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNPMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarComponenteMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Serie", "Descripcion"
            }
        ));
        tablaDetalleCPU.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaDetalleCPU);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Tipo :");

        cb_ListarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarTipoActionPerformed(evt);
            }
        });

        btnAgregarCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_detalle_prod.png"))); // NOI18N
        btnAgregarCPU.setToolTipText("Agregar Componentes");
        btnAgregarCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCPUActionPerformed(evt);
            }
        });

        btnQuitarCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_detalle_prod.png"))); // NOI18N
        btnQuitarCPU.setToolTipText("Quitar Componentes");
        btnQuitarCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregarCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarCPU))
                    .addComponent(cb_ListarComponenteCPU, javax.swing.GroupLayout.Alignment.TRAILING, 0, 401, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cb_ListarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuitarCPU)
                    .addComponent(btnAgregarCPU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarComponenteCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setText("Nro. Patrimonial :");

        txtIdCPU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdCPUKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cpu.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNPCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNPCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(txtIdCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnGrabar)
                .addComponent(btnLimpiar))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel10.setText("Encargado :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setText("Cargo :");

        lblCargo.setFont(new java.awt.Font("Arial", 1, 12));
        lblCargo.setText("Autogenerado");

        cb_ListarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarEmpleadoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Departamento :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Area :");

        cb_ListarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarAreaActionPerformed(evt);
            }
        });

        cb_ListarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarDepartamentoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 51, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jListaEmpleado.setVerifyInputWhenFocusTarget(false);
        jListaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListaEmpleado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_ListarEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_ListarArea, 0, 199, Short.MAX_VALUE)
                                    .addComponent(cb_ListarDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ListarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ListarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_ListarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCargo)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Accesorios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btnAgregarAc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_detalle_prod.png"))); // NOI18N
        btnAgregarAc.setToolTipText("Agregar Accesorios");
        btnAgregarAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAcActionPerformed(evt);
            }
        });

        tablaDetalleAcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Serie", "Descripcion"
            }
        ));
        tablaDetalleAcc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(tablaDetalleAcc);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel22.setText("Nro. Patrimonial :");

        txtNPAccesorios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNPAccesoriosKeyReleased(evt);
            }
        });

        btnQuitarCPU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_detalle_prod.png"))); // NOI18N
        btnQuitarCPU1.setToolTipText("Quitar Accesorios");
        btnQuitarCPU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCPU1ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mouse.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNPAccesorios, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNPAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btnAgregarAc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarCPU1))
                            .addComponent(cb_ListarComponenteAcc, 0, 358, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(txtNPAccesorios, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNPAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarAc)
                            .addComponent(btnQuitarCPU1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_ListarComponenteAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtIdComputador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdComputadorKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel23.setText("Nombre de Computador:");

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sistema Operativo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sisoperativo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(cb_ListarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIdComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(txtIdComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
    if(objUsuarioAdmin.getInt_nivel()==1)
     new frmPrincipalAdmin(objUsuarioAdmin).setVisible(true);
    else
        new frmPrincipalUser(objUsuarioAdmin).setVisible(true);

}//GEN-LAST:event_formWindowClosed

    private void cb_ListarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarTipoActionPerformed
        // TODO add your handling code here:
            ComboComponenteCPU.removeAllElements();
            ComboComponenteCPU.addElement("(Seleccione una Opcion)");
         if(cb_ListarTipo.getSelectedIndex()!=0)
         {
        try {
            List<Componente> listComponente = objComponenteCOM.listarComponentesxTipo(((Tipo)cb_ListarTipo.getSelectedItem()).getInt_id_tipo(),1);
            if(listComponente!=null)
            {
                for(Componente c : listComponente)
                {
                    ComboComponenteCPU.addElement(c);
                }
            }
        } catch (Exception e) {
         
        }
         cb_ListarComponenteCPU.setModel(ComboComponenteCPU);
      
         }

    }//GEN-LAST:event_cb_ListarTipoActionPerformed

    
    private void btnAgregarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCPUActionPerformed

 if(cb_ListarTipo.getSelectedIndex()!=0 && cb_ListarComponenteCPU.getSelectedIndex()!=0)
 {

        Componente objComponente = new Componente();
        objComponente.setStr_id_componente(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getStr_id_componente());
        objComponente.setInt_estado(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getInt_estado());
        objComponente.setInt_garantia(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getInt_garantia());
        objComponente.setStr_caracteristica(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getStr_caracteristica());
        objComponente.setObjModelo(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getObjModelo());

        CPU.DetalleCPU items = new CPU.DetalleCPU(objComponente);
           
      if(!modeloTablaComponente.insertarDetalle(items))
                    JOptionPane.showMessageDialog(this,"Numero de Serie Duplicado");
                    else
                    modeloTablaComponente.fireTableDataChanged();
           cb_ListarTipo.setSelectedIndex(0);
               cb_ListarComponenteCPU.setSelectedIndex(0);


 }
 else
             JOptionPane.showMessageDialog(this,"Selecione un Tipo o un Componente");
        
             
    
    }//GEN-LAST:event_btnAgregarCPUActionPerformed

    private void btnQuitarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCPUActionPerformed
        // TODO add your handling code here:
         if(tablaDetalleCPU.getSelectedRow()>-1)
        {
            

            modeloTablaComponente.removerItemDetalle(tablaDetalleCPU.getSelectedRow());
            modeloTablaComponente.fireTableDataChanged();

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
        }
        
    }//GEN-LAST:event_btnQuitarCPUActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        
  try {
     
       boolean cpu=false,monitor=false,Computador=false;


        Software objSoftware= new Software();
        objSoftware.setInt_id_software(((Software)cb_ListarSistema.getSelectedItem()).getInt_id_software());
        
        CPU objCPU = new CPU();
        objCPU.setStr_id_cpu(txtIdCPU.getText());
        objCPU.setObjSoftware(objSoftware);
        objCPU.setInt_estado(0);
        objCPU.setDetalleCPU(modeloTablaComponente.listar());
       
        
        if(objCPatrimonialCOM.insertar(txtIdCPU.getText()))
        cpu= objCPUCOM.insertar(objCPU);
        
        Monitor objMonitor = new Monitor();
        objMonitor.setStr_id_monitor(txtIdMonitor.getText());
        objMonitor.setObjComponente(((Componente)cb_ListarComponenteMonitor.getSelectedItem()));
         if(objCPatrimonialCOM.insertar(txtIdMonitor.getText()))
         {
        monitor=objMonitorCOM.insertar(objMonitor);
          objComponenteCOM.actualizarEstado(objMonitor.getObjComponente().getStr_id_componente(),2);            
         }
  
        Computador objComputador= new Computador();
       objComputador.setObjCPU(objCPU);
        objComputador.setObjMonitor(objMonitor);
        objComputador.setObjEmpleado(((Empleado)cb_ListarEmpleado.getSelectedItem()));
        objComputador.setInt_estado(0);
        objComputador.setStr_id_computador(txtIdComputador.getText());
        Computador = objComputadorCOM.insertar(objComputador);
     
        if(modeloTablaAccesorios!=null)
         for(Accesorios objAccesorios: modeloTablaAccesorios.listar())
               {                   
   
                    if(objCPatrimonialCOM.insertar(objAccesorios.getStr_id_accesorios()))
                    {
                    objAccesoriosCOM.insertarAccComputador(objAccesorios,objComputador.getStr_id_computador());
                     objComponenteCOM.actualizarEstado(objAccesorios.getObjComponente().getStr_id_componente(),2);  
                    }

               }
             
         if(cpu && monitor && Computador )
            JOptionPane.showMessageDialog(this,"Se Registro Correctamemte");

      
        } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPorComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }

      listarComboMonitor();
       listarComboTipo();
         listarComboMonitor();
         listarComboDepartamento();
         listarEmpleado();
         listarComboAccesorios();
         limpiarControles();

    }//GEN-LAST:event_btnGrabarActionPerformed

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
        
        }
    }//GEN-LAST:event_cb_ListarDepartamentoActionPerformed

    private void cb_ListarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarAreaActionPerformed

       
        ComboEmpleado = new DefaultComboBoxModel();
        ComboEmpleado.removeAllElements();
        ComboEmpleado.addElement("(Seleccione una Opcion)");
         if(cb_ListarArea.getSelectedIndex()!=0)
            try {
                List<Empleado> listEmpleado = objEmpleadoCOM.listarEmpleadoXAreaAsigando(((Area)cb_ListarArea.getSelectedItem()).getInt_id_area(),0);
                if(listEmpleado!=null)
                {
                    for(Empleado e : listEmpleado)
                    {
                        ComboEmpleado.addElement(e);
                    }
                }           
            } catch (Exception e) {
              
            }
         cb_ListarEmpleado.setModel(ComboEmpleado);
          if(cb_ListarArea.getSelectedIndex()==0 && cb_ListarDepartamento.getSelectedIndex()==0)
               lblCargo.setText("Autogenerado");
          
    }//GEN-LAST:event_cb_ListarAreaActionPerformed

    private void cb_ListarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarEmpleadoActionPerformed
        // TODO add your handling code here:
         if(cb_ListarArea.getSelectedIndex()!=0 && cb_ListarEmpleado.getSelectedIndex()!=0)
                lblCargo.setText(((Empleado)cb_ListarEmpleado.getSelectedItem()).getObjCargo().getStr_nombre());
    }//GEN-LAST:event_cb_ListarEmpleadoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
          modeloEmpleado.clear();
        try {
            List<Empleado> listEmpleado = objEmpleadoCOM.listarFiltroAsignado(txtBuscar.getText(),0);
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

    private void jListaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaEmpleadoMouseClicked
        // TODO add your handling code here:
                String criterio = jListaEmpleado.getSelectedValue().toString();
       if(!"".equals(criterio))
       {         

                  
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
                   
                    int empleado=((Empleado)jListaEmpleado.getModel().getElementAt(jListaEmpleado.getSelectedIndex())).getInt_id_empleado();
                   for(int i=1;i<cb_ListarEmpleado.getItemCount();i++)
                   {
                       int buscarEmpleado=((Empleado)cb_ListarEmpleado.getModel().getElementAt(i)).getInt_id_empleado();
                       if(empleado==buscarEmpleado)
                             cb_ListarEmpleado.setSelectedIndex(i); 
                   }

       }       
    }//GEN-LAST:event_jListaEmpleadoMouseClicked

private void btnAgregarAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAcActionPerformed
// TODO add your handling code here:
   if(!txtNPAccesorios.getText().equals("") && cb_ListarComponenteAcc.getSelectedIndex()!=0  )
   {
       Componente objComponente = new Componente();
       objComponente.setStr_id_componente(((Componente)cb_ListarComponenteAcc.getSelectedItem()).getStr_id_componente());
        objComponente.setInt_estado(((Componente)cb_ListarComponenteAcc.getSelectedItem()).getInt_estado());
        objComponente.setInt_garantia(((Componente)cb_ListarComponenteAcc.getSelectedItem()).getInt_garantia());
        objComponente.setStr_caracteristica(((Componente)cb_ListarComponenteAcc.getSelectedItem()).getStr_caracteristica());
        objComponente.setObjModelo(((Componente)cb_ListarComponenteAcc.getSelectedItem()).getObjModelo());

        Accesorios items = new Accesorios (txtNPAccesorios.getText(),objComponente);
           
      if(!modeloTablaAccesorios.insertar(items))
                    JOptionPane.showMessageDialog(this,"Numero de Patrimonial o Serie Duplicado");
                    else
                    modeloTablaAccesorios.fireTableDataChanged();
            cb_ListarComponenteAcc.setSelectedIndex(0);
   }
 else
             JOptionPane.showMessageDialog(this,"Ingrese un Nro. Patrimonial o Selecione un Accesorio");
   txtNPAccesorios.setText("");
   
        
}//GEN-LAST:event_btnAgregarAcActionPerformed

private void btnQuitarCPU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCPU1ActionPerformed
// TODO add your handling code here:
        if(tablaDetalleAcc.getSelectedRow()>-1)
        {
            

            modeloTablaAccesorios.removerItemDetalle(tablaDetalleAcc.getSelectedRow());
            modeloTablaAccesorios.fireTableDataChanged();

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
        }
}//GEN-LAST:event_btnQuitarCPU1ActionPerformed

private void txtIdComputadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdComputadorKeyReleased
// TODO add your handling code here:
        try {
            // TODO add your handling code here:
                if(!objComputadorCOM.verificarNombre(txtIdComputador.getText()).equals("") )
                {
                     txtIdComputador.setBackground(Color.red);
                     lblNComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNComputador.setToolTipText("El Nombre del Computador es Repetido");
                }
                else{
                    txtIdComputador.setBackground(Color.white);
                    lblNComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNComputador.setToolTipText("El Campo Es Correcto");
                }
                     } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPorComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_txtIdComputadorKeyReleased

private void txtIdMonitorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdMonitorKeyReleased
        try {
            // TODO add your handling code here:
                if(!"".equals(objCPatrimonialCOM.verificarNSerie(txtIdMonitor.getText())))
                {
                     txtIdMonitor.setBackground(Color.red);
                     lblNPMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNPMonitor.setToolTipText("El Codigo Patrimonial es Repetido");
                }
                else{
                    txtIdMonitor.setBackground(Color.white);
                    lblNPMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNPMonitor.setToolTipText("El Campo Es Correcto");
                }
                    
                    
        } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPorComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_txtIdMonitorKeyReleased

private void txtNPAccesoriosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNPAccesoriosKeyReleased
        try {
            // TODO add your handling code here:
                 if(!"".equals(objCPatrimonialCOM.verificarNSerie(txtNPAccesorios.getText())))
                 {
                             txtNPAccesorios.setBackground(Color.red);
                     lblNPAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNPAcc.setToolTipText("El Codigo Patrimonial es Repetido");
                            }
                             else{
                    txtNPAccesorios.setBackground(Color.white);
                    lblNPAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNPAcc.setToolTipText("El Campo Es Correcto");
                }
        } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPorComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                             
}//GEN-LAST:event_txtNPAccesoriosKeyReleased

private void txtIdCPUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCPUKeyReleased
// TODO add your handling code here:
     try {
            // TODO add your handling code here:
                 if(!"".equals(objCPatrimonialCOM.verificarNSerie(txtIdCPU.getText())))
                            {
                                txtIdCPU.setBackground(Color.red);
                     lblNPCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png")));
                     lblNPCPU.setToolTipText("El Codigo Patrimonial es Repetido");
                            }
                             else{
                    txtIdCPU.setBackground(Color.white);
                    lblNPCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar_check.gif")));
                    lblNPCPU.setToolTipText("El Campo Es Correcto");
                }
        } catch (Exception ex) {
            Logger.getLogger(frmArmadoComputadoraPorComponentes.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
}//GEN-LAST:event_txtIdCPUKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

 limpiarControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed
 
    
    
  
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAc;
    private javax.swing.JButton btnAgregarCPU;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitarCPU;
    private javax.swing.JButton btnQuitarCPU1;
    private javax.swing.JComboBox cb_ListarArea;
    private javax.swing.JComboBox cb_ListarComponenteAcc;
    private javax.swing.JComboBox cb_ListarComponenteCPU;
    private javax.swing.JComboBox cb_ListarComponenteMonitor;
    private javax.swing.JComboBox cb_ListarDepartamento;
    private javax.swing.JComboBox cb_ListarEmpleado;
    private javax.swing.JComboBox cb_ListarSistema;
    private javax.swing.JComboBox cb_ListarTipo;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jListaEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblNComputador;
    private javax.swing.JLabel lblNPAcc;
    private javax.swing.JLabel lblNPCPU;
    private javax.swing.JLabel lblNPMonitor;
    private javax.swing.JTable tablaDetalleAcc;
    private javax.swing.JTable tablaDetalleCPU;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdCPU;
    private javax.swing.JTextField txtIdComputador;
    private javax.swing.JTextField txtIdMonitor;
    private javax.swing.JTextField txtNPAccesorios;
    // End of variables declaration//GEN-END:variables
}
