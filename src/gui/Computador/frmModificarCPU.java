/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmArea.java
 *
 * Created on 06/09/2011, 05:59:13 PM
 */
package gui.Computador;
import gui.frmMantenimientoComputadoras;
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
public class frmModificarCPU extends javax.swing.JFrame {
    

    private Usuario objUsuarioAdmin = new Usuario();
    private ComponenteCOM objComponenteCOM = new ComponenteCOM();
      private CPUCOM objCPUCOM = new CPUCOM();

   private ComputadorCOM objComputadorCOM= new ComputadorCOM(); 
          
           private SoftwareCOM objSoftwareCOM= new SoftwareCOM(); 

       private Computador objComputador= new Computador();
       
      private ModeloDetalleCPU modeloTablaComponenteActual = new ModeloDetalleCPU();
      private ModeloDetalleCPU modeloTablaComponenteNuevo = new ModeloDetalleCPU();


      


    public frmModificarCPU(Usuario usuario,Computador objComputador) {
        initComponents();
           this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);
         this.objComputador=objComputador;
         this.objUsuarioAdmin = usuario;
        
         tablaDetalleCPUActual.setModel(modeloTablaComponenteActual);
         tablaDetalleCPUNuevo.setModel(modeloTablaComponenteNuevo);
         tablaDetalleCPUActual.getColumnModel().getColumn(0).setMaxWidth(100);
           tablaDetalleCPUActual.getColumnModel().getColumn(0).setMinWidth(100);
            tablaDetalleCPUNuevo.getColumnModel().getColumn(0).setMaxWidth(100);
           tablaDetalleCPUNuevo.getColumnModel().getColumn(0).setMinWidth(100);

LlenarCampos();

listarCPU();
    }
      
            public void listarCPU()
    {
        DefaultComboBoxModel ComboCPU = new DefaultComboBoxModel();
        ComboCPU.removeAllElements();
          ComboCPU.addElement("(Seleccione una Opcion)");
        try {
            List<CPU> listCPU = objCPUCOM.listarTodosOrdenado(1);
            if(listCPU!=null)
            {
                for(CPU c : listCPU)
                {
                    ComboCPU.addElement(c);
                }
            }
        } catch (Exception e) {
      
        }
         cb_ListarCPU.setModel(ComboCPU);
    }
         
    
    public void LlenarCampos()
    {
         lblIdComputador.setText(objComputador.getStr_id_computador());
        lblIdCPU.setText(objComputador.getObjCPU().getStr_id_cpu());
            
        try {    
              Software sistemaSoftware = objSoftwareCOM.buscarSistemaXCPU(objComputador.getObjCPU().getStr_id_cpu());
                 lblSistema.setText(sistemaSoftware.getStr_nombre());
        
             List<Componente> listCPU = objComponenteCOM.listarComponentesXCPU(objComputador.getObjCPU().getStr_id_cpu());
                if(listCPU!=null)
             for(Componente componente : listCPU)
                {
                    CPU.DetalleCPU items = new CPU.DetalleCPU(componente);
                    modeloTablaComponenteActual.insertarDetalle(items);
     
                }
             
            modeloTablaComponenteActual.fireTableDataChanged();
            
            
        } catch (Exception ex) {
            Logger.getLogger(frmModificarCPU.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalleCPUActual = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        lblIdCPU = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblSistema = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        lblIdComputador = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalleCPUNuevo = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblSistemaNuevo = new javax.swing.JLabel();
        cb_ListarCPU = new javax.swing.JComboBox();
        btnModificar = new javax.swing.JButton();

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
        setTitle("Formulario de Ingreso de Computador");
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
        jLabel1.setText("Modificacion de CPU");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computador.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPUActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleCPUActual.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaDetalleCPUActual);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel24.setText("Nro. Patrimonial :");

        lblIdCPU.setFont(new java.awt.Font("Arial", 1, 12));
        lblIdCPU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdCPU.setText("Autogenerado");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel25.setText("Sistema Operativo :");

        lblSistema.setFont(new java.awt.Font("Arial", 1, 12));
        lblSistema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSistema.setText("Autogenerado");

        chkEstado.setFont(new java.awt.Font("Arial", 1, 12));
        chkEstado.setSelected(true);
        chkEstado.setText("CPU Operativo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                        .addGap(46, 46, 46)
                        .addComponent(chkEstado)
                        .addGap(18, 18, 18))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdCPU)
                    .addComponent(jLabel24)
                    .addComponent(chkEstado))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblSistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel23.setText("Nombre de Computador:");

        lblIdComputador.setFont(new java.awt.Font("Arial", 1, 14));
        lblIdComputador.setText("Autogenerado");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Componentes del CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tablaDetalleCPUNuevo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleCPUNuevo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tablaDetalleCPUNuevo);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel26.setText("Nro. Patrimonial :");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel27.setText("Sistema Operativo :");

        lblSistemaNuevo.setFont(new java.awt.Font("Arial", 1, 12));
        lblSistemaNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSistemaNuevo.setText("Autogenerado");

        cb_ListarCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_ListarCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSistemaNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(128, 128, 128))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cb_ListarCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblSistemaNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden.png"))); // NOI18N
        btnModificar.setText("Modifcar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIdComputador)
                .addContainerGap(190, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblIdComputador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
// TODO add your handling code here:

   new frmMostrarComputadora(objUsuarioAdmin,objComputador).setVisible(true);


}//GEN-LAST:event_formWindowClosed

    private void cb_ListarCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarCPUActionPerformed
        // TODO add your handling code here:
        if(cb_ListarCPU.getSelectedIndex()!=0)
        try {    
             
                 lblSistemaNuevo.setText(((CPU)cb_ListarCPU.getSelectedItem()).getObjSoftware().getStr_nombre());
        
             List<Componente> listCPU = objComponenteCOM.listarComponentesXCPU(((CPU)cb_ListarCPU.getSelectedItem()).getStr_id_cpu());
             if(listCPU!=null)
             for(Componente componente : listCPU)
                {
                    CPU.DetalleCPU items = new CPU.DetalleCPU(componente);
                    modeloTablaComponenteNuevo.insertarDetalle(items);
     
                }
             
            modeloTablaComponenteNuevo.fireTableDataChanged();
            
            
        } catch (Exception ex) {
            Logger.getLogger(frmModificarCPU.class.getName()).log(Level.SEVERE, null, ex);
        }
        else{
            modeloTablaComponenteNuevo.limpiar();
            modeloTablaComponenteNuevo.fireTableDataChanged();
            lblSistemaNuevo.setText("Autogenerado");
        }
            
        
    }//GEN-LAST:event_cb_ListarCPUActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
          if(cb_ListarCPU.getSelectedIndex()!=0)
        try {
            String IdCPU = objComputador.getObjCPU().getStr_id_cpu();
            
            objComputador.setObjCPU(((CPU)cb_ListarCPU.getSelectedItem()));
            
            if(objComputadorCOM.actualizar(objComputador));
            {
                if(chkEstado.isSelected())
                objCPUCOM.actualizarEstado(IdCPU,1);
                else
                    objCPUCOM.actualizarEstado(IdCPU,2);
                objCPUCOM.actualizarEstado(((CPU)cb_ListarCPU.getSelectedItem()).getStr_id_cpu(),0);
                
            }
                
             this.dispose();
            
        } catch (Exception ex) {
            Logger.getLogger(frmModifcarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

     
    
    
  
    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cb_ListarCPU;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIdCPU;
    private javax.swing.JLabel lblIdComputador;
    private javax.swing.JLabel lblSistema;
    private javax.swing.JLabel lblSistemaNuevo;
    private javax.swing.JTable tablaDetalleCPUActual;
    private javax.swing.JTable tablaDetalleCPUNuevo;
    // End of variables declaration//GEN-END:variables
}
