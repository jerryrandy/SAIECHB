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
import java.util.ArrayList;
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
public class frmModificarCPU extends javax.swing.JFrame {
    
    private Usuario objUsuarioAdmin = new Usuario();
    private List<Componente> listComponenteOperativo = new ArrayList<Componente>();
    private List<Componente> listComponenteNoOperativo = new ArrayList<Componente>();
    private ComponenteCOM objComponenteCOM = new ComponenteCOM();
    private TipoCOM objTipoCOM = new TipoCOM();
    HistorialComponenteCOM objHistorialComponenteCOM = new HistorialComponenteCOM();

    
           private SoftwareCOM objSoftwareCOM= new SoftwareCOM(); 
        
           private CPUCOM objCPUCOM= new CPUCOM(); 

       
      private ModeloDetalleCPU modeloTablaComponenteActual = new ModeloDetalleCPU();
      private ModeloDetalleCPU modeloTablaComponenteNuevo = new ModeloDetalleCPU();


      private DefaultComboBoxModel ComboSoftware = new DefaultComboBoxModel();
      
        private DefaultComboBoxModel ComboComponenteCPU = new DefaultComboBoxModel();
         private DefaultComboBoxModel ComboTipo = new DefaultComboBoxModel();
         
         
      
          
           
   

    public frmModificarCPU(Usuario usuario) {
        initComponents();
           this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);    
         this.objUsuarioAdmin = usuario;
         btnActivar.setVisible(false);
         
        cb_ListarTipo.setModel(ComboTipo);
         tablaDetalleCPUActual.setModel(modeloTablaComponenteActual);
          tablaDetalleCPUNuevo.setModel(modeloTablaComponenteNuevo);
      cb_ListarComponenteCPU.setModel(ComboComponenteCPU);
         cb_ListarSistema.setModel(ComboSoftware);
         tablaDetalleCPUActual.getColumnModel().getColumn(0).setMaxWidth(100);
           tablaDetalleCPUActual.getColumnModel().getColumn(0).setMinWidth(100);
           tablaDetalleCPUNuevo.getColumnModel().getColumn(0).setMaxWidth(100);
           tablaDetalleCPUNuevo.getColumnModel().getColumn(0).setMinWidth(100);
listarSistema();
listarCPU();
listarComboTipo();

    }
             public void listarCPU()
    {
         DefaultListModel modeloCPU = new DefaultListModel();
         modeloCPU.clear();
        try {
             List<CPU> listCPU =new ArrayList<CPU>();
            if(chkEstadoCPU.isSelected())
            listCPU = objCPUCOM.listarTodosOrdenado(1);
            else
                listCPU = objCPUCOM.listarTodosOrdenado(2);
            if(listCPU!=null)
            {
                for(CPU c : listCPU)
                {
                    modeloCPU.addElement(c);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        jListaCPU.setModel(modeloCPU);
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
         
     public void limpiarControles()
    {
   
        txtBuscar.setText("");
        lblIdCPU.setText("Autogenerado");  
       chkEstadoCPU.setSelected(true);
       chkEstado.setSelected(true);
       cb_ListarSistema.setSelectedIndex(0);
       cb_ListarTipo.setSelectedIndex(0);
       modeloTablaComponenteActual.limpiar();
        modeloTablaComponenteActual.fireTableDataChanged();
        
        modeloTablaComponenteNuevo.limpiar();
            modeloTablaComponenteNuevo.fireTableDataChanged();
            listarCPU();

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
        chkEstadoCPU = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleCPUActual = new javax.swing.JTable();
        btnQuitarCPU1 = new javax.swing.JButton();
        chkEstado = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        lblContador = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblIdCPU = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cb_ListarSistema = new javax.swing.JComboBox();
        btnRestaurar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalleCPUNuevo = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cb_ListarTipo = new javax.swing.JComboBox();
        cb_ListarComponenteCPU = new javax.swing.JComboBox();
        btnAgregarCPU = new javax.swing.JButton();
        btnQuitarCPU = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListaCPU = new javax.swing.JList();
        txtBuscar = new javax.swing.JTextField();

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
        setTitle("Formulario de Modificacion del CPU");
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
        jLabel1.setText("Modificacion del CPU");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computador.png"))); // NOI18N

        chkEstadoCPU.setFont(new java.awt.Font("Arial", 1, 14));
        chkEstadoCPU.setForeground(new java.awt.Color(255, 255, 255));
        chkEstadoCPU.setSelected(true);
        chkEstadoCPU.setText("CPU Operativo");
        chkEstadoCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkEstadoCPU)
                .addGap(77, 77, 77)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkEstadoCPU)
                .addGap(39, 39, 39))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPUActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleCPUActual.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaDetalleCPUActual);

        btnQuitarCPU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnQuitarCPU1.setToolTipText("Quitar Componentes");
        btnQuitarCPU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCPU1ActionPerformed(evt);
            }
        });

        chkEstado.setFont(new java.awt.Font("Arial", 1, 12));
        chkEstado.setSelected(true);
        chkEstado.setText("Componente Operativo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel2.setText("Compoentes Retirados :");

        lblContador.setFont(new java.awt.Font("Arial", 1, 11));
        lblContador.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnQuitarCPU1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(lblContador, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitarCPU1)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkEstado)
                        .addComponent(jLabel2)
                        .addComponent(lblContador))))
        );

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setText("Nro. Patrimonial :");

        lblIdCPU.setFont(new java.awt.Font("Arial", 1, 12));
        lblIdCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdCPU.setText("Autogenerado");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel25.setText("Sistema Operativo :");

        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editclear.png"))); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarSistema, 0, 141, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdCPU, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRestaurar))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(lblIdCPU))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(cb_ListarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRestaurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPUNuevo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleCPUNuevo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tablaDetalleCPUNuevo);

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_ListarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregarCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarCPU))
                    .addComponent(cb_ListarComponenteCPU, 0, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cb_ListarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuitarCPU)
                    .addComponent(btnAgregarCPU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarComponenteCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden.png"))); // NOI18N
        btnModificar.setText("Modifcar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editclear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btn_check.png"))); // NOI18N
        btnActivar.setText("Activar CPU");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActivar))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnActivar)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListaCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaCPUMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListaCPU);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
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

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:
   if(objUsuarioAdmin.getInt_nivel()==1)
            new frmPrincipalAdmin(objUsuarioAdmin).setVisible(true);
            else
                new frmPrincipalUser(objUsuarioAdmin).setVisible(true);



}//GEN-LAST:event_formWindowClosed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        
        
           DefaultListModel modeloCPU = new DefaultListModel();
         modeloCPU.clear();
        try {
             List<CPU> listCPU =new ArrayList<CPU>();
            if(chkEstadoCPU.isSelected())
            listCPU = objCPUCOM.listarFiltro(txtBuscar.getText(),1);
            else
                listCPU = objCPUCOM.listarFiltro(txtBuscar.getText(),2);
            if(listCPU!=null)
            {
                for(CPU c : listCPU)
                {
                    modeloCPU.addElement(c);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        jListaCPU.setModel(modeloCPU);
        
        
        
        
        

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jListaCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaCPUMouseClicked
        // TODO add your handling code here:
         if(jListaCPU.getSelectedIndex()>=0)
        {
         CPU objCPU = ((CPU)jListaCPU.getModel().getElementAt(jListaCPU.getSelectedIndex()));
     
        lblIdCPU.setText(objCPU.getStr_id_cpu());
        try {    
              Software sistemaSoftware = objSoftwareCOM.buscarSistemaXCPU(objCPU.getStr_id_cpu());
              objCPU.setObjSoftware(sistemaSoftware);
               
                String sistema=sistemaSoftware.getStr_nombre();

                   for(int i=0;i<=ComboSoftware.getSize();i++)
                   {
                       String buscar=String.valueOf(ComboSoftware.getElementAt(i));
                       if(sistema.equals(buscar))
                             cb_ListarSistema.setSelectedIndex(i); 
                   }
                 
             modeloTablaComponenteActual.limpiar();
            
             List<Componente> listCPU = objComponenteCOM.listarComponentesXCPU(objCPU.getStr_id_cpu());
            if(listCPU!=null)
             for(Componente componente : listCPU)
                {
                    CPU.DetalleCPU items = new CPU.DetalleCPU(componente);
                    modeloTablaComponenteActual.insertarDetalle(items);
     
                }
             
            modeloTablaComponenteActual.fireTableDataChanged();
            
            
        } catch (Exception ex) {}
       
        }

    }//GEN-LAST:event_jListaCPUMouseClicked
   
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {


            objCPUCOM.actualizarSistema(lblIdCPU.getText(), ((Software) cb_ListarSistema.getSelectedItem()).getInt_id_software());

            if (listComponenteOperativo != null) {
                for (Componente comoponente : listComponenteOperativo) {
                    if (objCPUCOM.eliminarCPUComponete(lblIdCPU.getText(), comoponente.getStr_id_componente())) {
                        objComponenteCOM.actualizarEstado(comoponente.getStr_id_componente(), 1);
                    }
              objHistorialComponenteCOM.insertar(comoponente.getStr_id_componente(),"Se Retiro en el CPU "+lblIdCPU.getText());
                }
            }

            if (listComponenteNoOperativo != null) {
                for (Componente comoponente : listComponenteNoOperativo) {
                    if (objCPUCOM.eliminarCPUComponete(lblIdCPU.getText(), comoponente.getStr_id_componente())) {
                        objComponenteCOM.actualizarEstado(comoponente.getStr_id_componente(), 3);
                    }
                        objHistorialComponenteCOM.insertar(comoponente.getStr_id_componente(),"Se Inhabilito en el CPU "+lblIdCPU.getText());

                }
            }

            if (modeloTablaComponenteNuevo != null) {
                for (CPU.DetalleCPU objDetalle : modeloTablaComponenteNuevo.listar()) {

                    String idComponente = objDetalle.getObjComponente().getStr_id_componente();
                    if (objCPUCOM.insertarCPUcomponentes(lblIdCPU.getText(), idComponente)) {
                        objComponenteCOM.actualizarEstado(idComponente, 2);
                    }
                  objHistorialComponenteCOM.insertar(idComponente,"Se Inserto en el CPU "+lblIdCPU.getText());    

                }
            }

         

        } catch (Exception ex) {
        }
        limpiarControles();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnQuitarCPU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCPU1ActionPerformed
        // TODO add your handling code here:
          if(tablaDetalleCPUActual.getSelectedRow()>-1)
        {
            Componente objComponente = new Componente();
            
            objComponente = modeloTablaComponenteActual.listar().get(tablaDetalleCPUActual.getSelectedRow()).getObjComponente();
            if(chkEstado.isSelected())
            listComponenteOperativo.add(objComponente);
            else
            listComponenteNoOperativo.add(objComponente);
            
            int c=Integer.valueOf(lblContador.getText());
            c++;
            modeloTablaComponenteActual.removerItemDetalle(tablaDetalleCPUActual.getSelectedRow());
            modeloTablaComponenteActual.fireTableDataChanged();
            lblContador.setText(String.valueOf(c));
            chkEstado.setSelected(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnQuitarCPU1ActionPerformed

    private void btnAgregarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCPUActionPerformed
        // TODO add your handling code here:
         if(cb_ListarTipo.getSelectedIndex()!=0 && cb_ListarComponenteCPU.getSelectedIndex()!=0)
 {

        Componente objComponente = new Componente();
        objComponente.setStr_id_componente(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getStr_id_componente());
        objComponente.setInt_estado(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getInt_estado());
        objComponente.setInt_garantia(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getInt_garantia());
        objComponente.setStr_caracteristica(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getStr_caracteristica());
        objComponente.setObjModelo(((Componente)cb_ListarComponenteCPU.getSelectedItem()).getObjModelo());

        CPU.DetalleCPU items = new CPU.DetalleCPU(objComponente);
           
      if(!modeloTablaComponenteNuevo.insertarDetalle(items))
                    JOptionPane.showMessageDialog(this,"Numero de Serie Duplicado");
                    else
                    modeloTablaComponenteNuevo.fireTableDataChanged();
           cb_ListarTipo.setSelectedIndex(0);
               cb_ListarComponenteCPU.setSelectedIndex(0);


 }
 else
             JOptionPane.showMessageDialog(this,"Selecione un Tipo o un Componente");
        
    }//GEN-LAST:event_btnAgregarCPUActionPerformed

    private void btnQuitarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCPUActionPerformed
        // TODO add your handling code here:
           if(tablaDetalleCPUNuevo.getSelectedRow()>-1)
        {
            

            modeloTablaComponenteNuevo.removerItemDetalle(tablaDetalleCPUNuevo.getSelectedRow());
            modeloTablaComponenteNuevo.fireTableDataChanged();

        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnQuitarCPUActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        // TODO add your handling code here:
        lblContador.setText("0");
        listComponenteNoOperativo.clear();
        listComponenteOperativo.clear();
        chkEstado.setSelected(true);
        if(jListaCPU.getSelectedIndex()>=0)
        {
         CPU objCPU = ((CPU)jListaCPU.getModel().getElementAt(jListaCPU.getSelectedIndex()));
     
        lblIdCPU.setText(objCPU.getStr_id_cpu());
        try {    
              Software sistemaSoftware = objSoftwareCOM.buscarSistemaXCPU(objCPU.getStr_id_cpu());
              objCPU.setObjSoftware(sistemaSoftware);
               
                String sistema=sistemaSoftware.getStr_nombre();

                   for(int i=0;i<=ComboSoftware.getSize();i++)
                   {
                       String buscar=String.valueOf(ComboSoftware.getElementAt(i));
                       if(sistema.equals(buscar))
                             cb_ListarSistema.setSelectedIndex(i); 
                   }
                 
             modeloTablaComponenteActual.limpiar();
            
             List<Componente> listCPU = objComponenteCOM.listarComponentesXCPU(objCPU.getStr_id_cpu());
            if(listCPU!=null)
             for(Componente componente : listCPU)
                {
                    CPU.DetalleCPU items = new CPU.DetalleCPU(componente);
                    modeloTablaComponenteActual.insertarDetalle(items);
     
                }
             
            modeloTablaComponenteActual.fireTableDataChanged();
            
            
        } catch (Exception ex) {}
       
        }
        
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void cb_ListarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarTipoActionPerformed
        // TODO add your handling code here:
        
         ComboComponenteCPU.removeAllElements();
        ComboComponenteCPU.addElement("(Seleccione una Opcion)");
        if (cb_ListarTipo.getSelectedIndex() != 0) {
            try {
                List<Componente> listComponente = objComponenteCOM.listarComponentesxTipo(((Tipo) cb_ListarTipo.getSelectedItem()).getInt_id_tipo(), 1);
                if (listComponente != null) {
                    for (Componente c : listComponente) {
                        ComboComponenteCPU.addElement(c);
                    }
                }
            } catch (Exception e) {
            }
            cb_ListarComponenteCPU.setModel(ComboComponenteCPU);

        }
    }//GEN-LAST:event_cb_ListarTipoActionPerformed

    private void chkEstadoCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstadoCPUActionPerformed
        // TODO add your handling code here:
        if(chkEstadoCPU.isSelected())
          btnActivar.setVisible(false);
        else
             btnActivar.setVisible(true);
        listarCPU();
       txtBuscar.setText("");
    }//GEN-LAST:event_chkEstadoCPUActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarControles();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        // TODO add your handling code here:
        if(!lblIdCPU.getText().equals("Autogenerado")){
                int i = JOptionPane.showConfirmDialog(this, "Esta seguro que desea Habilitar el CPU con n/p: "+lblIdCPU.getText(), "Confirmar Habilitacion", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                     try {
                            objCPUCOM.actualizarEstado(lblIdCPU.getText(),1);
                            } catch (Exception ex) {}
                    }
                chkEstadoCPU.setSelected(true);
                 btnActivar.setVisible(false);
                listarCPU();
                
              }
            else
             JOptionPane.showMessageDialog(this, "Seleccione Una CPU");
            
            
    }//GEN-LAST:event_btnActivarActionPerformed

   
    

    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregarCPU;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitarCPU;
    private javax.swing.JButton btnQuitarCPU1;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JComboBox cb_ListarComponenteCPU;
    private javax.swing.JComboBox cb_ListarSistema;
    private javax.swing.JComboBox cb_ListarTipo;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JCheckBox chkEstadoCPU;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListaCPU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblIdCPU;
    private javax.swing.JTable tablaDetalleCPUActual;
    private javax.swing.JTable tablaDetalleCPUNuevo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
