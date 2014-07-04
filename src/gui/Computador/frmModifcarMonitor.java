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
public class frmModifcarMonitor extends javax.swing.JFrame {
    
    private Usuario objUsuarioAdmin = new Usuario();
     private Computador objComputador= new Computador();
       private MonitorCOM objMonitorCOM= new MonitorCOM(); 
       private HistorialComponenteCOM objHistorialComponenteCOM = new HistorialComponenteCOM();

private ComponenteCOM objComponenteCOM= new ComponenteCOM(); 
private ComputadorCOM objComputadorCOM= new ComputadorCOM(); 

      
      private DefaultComboBoxModel ComboComponenteMonitor = new DefaultComboBoxModel();

    
     

    public frmModifcarMonitor(Usuario usuario,Computador objComputador) {
        initComponents();
           this.setIconImage (new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage()); 
         setLocationRelativeTo(null);

          this.objComputador=objComputador;
          this.objUsuarioAdmin = usuario;
    
          
          cb_ListarComponenteMonitor.setModel(ComboComponenteMonitor);
         
        
        
           LlenarCapos();
           listarComboMonitor();

   

    }
         public void listarComboMonitor()
    {
        ComboComponenteMonitor.removeAllElements();
        ComboComponenteMonitor.addElement("(Seleccione una Opcion)");
         try {
            List<Monitor> listMonitor = objMonitorCOM.ListarMonitorXEstado(4);
            if(listMonitor!=null)
            {
                for(Monitor c : listMonitor)
                {
                    ComboComponenteMonitor.addElement(c);
                }
            }
        } catch (Exception e) {
           
        }
          
         
  
    }
       
    public void LlenarCapos()
    {
         lblIdComputador.setText(objComputador.getStr_id_computador());
            lblIdMonitor.setText(objComputador.getObjMonitor().getStr_id_monitor());
            
            
        try {
            Componente objComponente;
            objComponente = objComponenteCOM.buscarComponenteXId(objComputador.getObjMonitor().getObjComponente().getStr_id_componente());
            lblMonitor.setText(String.valueOf(objComponente));
        } catch (Exception ex) {
            Logger.getLogger(frmModifcarMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }

             
    } 
           
 

  
      
  

       public void limpiarControles()
    {


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
        jLabel21 = new javax.swing.JLabel();
        lblIdMonitor1 = new javax.swing.JLabel();
        lblIdMonitor = new javax.swing.JLabel();
        lblMonitor = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cb_ListarComponenteMonitor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        lblIdMonitorN = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblIdComputador = new javax.swing.JLabel();

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
        setTitle("Formulario de Ingreso de Equipo");
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
        jLabel1.setText("Modificacion de Monitor");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computador.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitor Actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel21.setText("Nro. Patrimonial :");

        lblIdMonitor1.setFont(new java.awt.Font("Arial", 1, 12));
        lblIdMonitor1.setText("Modelo:");

        lblIdMonitor.setFont(new java.awt.Font("Arial", 1, 12));
        lblIdMonitor.setText("Autogenerado");

        lblMonitor.setFont(new java.awt.Font("Arial", 1, 12));
        lblMonitor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMonitor.setText("Autogenerado");

        chkEstado.setFont(new java.awt.Font("Arial", 1, 12));
        chkEstado.setSelected(true);
        chkEstado.setText("Monitor Operativo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblIdMonitor1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblIdMonitor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonitor)
                    .addComponent(lblIdMonitor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden.png"))); // NOI18N
        btnModificar.setText("Modifcar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnModificar)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Monitor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        cb_ListarComponenteMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ListarComponenteMonitorActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/monitor.png"))); // NOI18N

        lblIdMonitorN.setFont(new java.awt.Font("Arial", 1, 12));
        lblIdMonitorN.setText("Autogenerado");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel22.setText("Nro. Patrimonial :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIdMonitorN, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cb_ListarComponenteMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cb_ListarComponenteMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lblIdMonitorN))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel23.setText("Nombre de Computador:");

        lblIdComputador.setFont(new java.awt.Font("Arial", 1, 14));
        lblIdComputador.setText("Autogenerado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIdComputador)
                .addContainerGap(197, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, 0, 468, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblIdComputador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

  new frmMostrarComputadora(objUsuarioAdmin,objComputador).setVisible(true);

  
}//GEN-LAST:event_formWindowClosed

    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       if(cb_ListarComponenteMonitor.getSelectedIndex()!=0)
        try {
            
            if(chkEstado.isSelected()){
               objComponenteCOM.actualizarEstado(objComputador.getObjMonitor().getObjComponente().getStr_id_componente(),4); 
               objHistorialComponenteCOM.insertar(objComputador.getObjMonitor().getObjComponente().getStr_id_componente(),"Se Retiro en el computador "+objComputador.getStr_id_computador());
           
            }
                else
            {
                objComponenteCOM.actualizarEstado(objComputador.getObjMonitor().getObjComponente().getStr_id_componente(),3); 
                  objHistorialComponenteCOM.insertar(objComputador.getObjMonitor().getObjComponente().getStr_id_componente(),"Se Inhabilito en el computador "+objComputador.getStr_id_computador());
           
                
            }

              objComponenteCOM.actualizarEstado(((Monitor)cb_ListarComponenteMonitor.getSelectedItem()).getObjComponente().getStr_id_componente(),2);     
            objHistorialComponenteCOM.insertar(((Monitor)cb_ListarComponenteMonitor.getSelectedItem()).getObjComponente().getStr_id_componente(),"Se Inserto en el computador "+objComputador.getStr_id_computador());   
              objComputador.setObjMonitor(((Monitor)cb_ListarComponenteMonitor.getSelectedItem()));
            
            objComputadorCOM.actualizar(objComputador);
            
                
             this.dispose();
            
        } catch (Exception ex) {
            Logger.getLogger(frmModifcarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

           

    }//GEN-LAST:event_btnModificarActionPerformed

    private void cb_ListarComponenteMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ListarComponenteMonitorActionPerformed
        // TODO add your handling code here:
         if(cb_ListarComponenteMonitor.getSelectedIndex()!=0)
             lblIdMonitorN.setText(((Monitor)cb_ListarComponenteMonitor.getSelectedItem()).getStr_id_monitor());
         else
             lblIdMonitorN.setText("");
    }//GEN-LAST:event_cb_ListarComponenteMonitorActionPerformed
 
    
    
  
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cb_ListarComponenteMonitor;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblIdComputador;
    private javax.swing.JLabel lblIdMonitor;
    private javax.swing.JLabel lblIdMonitor1;
    private javax.swing.JLabel lblIdMonitorN;
    private javax.swing.JLabel lblMonitor;
    // End of variables declaration//GEN-END:variables
}