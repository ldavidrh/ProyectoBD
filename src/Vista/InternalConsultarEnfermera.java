/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.ControlArea;
import Controlador.ControlEmpleado;
import Controlador.ControlEnfermera;
import Controlador.ControlPersona;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis
 */
public class InternalConsultarEnfermera extends javax.swing.JInternalFrame {
    ControlPersona controlPersona;
    ControlEmpleado controlEmpleado;
    ControlEnfermera controlEnfermera;
    ControlArea controlArea;
    /**
     * Creates new form InternalBuscarEnfermera
     */
    public InternalConsultarEnfermera(ControlEnfermera controlEnfermera, ControlEmpleado controlEmpleado, ControlPersona controlPersona, ControlArea controlArea) {
        this.controlPersona = controlPersona;
        this.controlEmpleado = controlEmpleado;
        this.controlEnfermera = controlEnfermera;
        this.controlArea = controlArea;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FieldCedula = new javax.swing.JTextField();
        ButtonConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Consultar enfermera");

        jLabel1.setText("Ingrese la cedula de la enfermera que desea consultar");

        FieldCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldCedulaActionPerformed(evt);
            }
        });

        ButtonConsultar.setText("Consultar");
        ButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(FieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonConsultar))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(ButtonConsultar))
        );

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCedulaActionPerformed

    private void ButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConsultarActionPerformed
        // TODO add your handling code here:
        try {
            if (this.FieldCedula.getText().trim().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "Ingrese la cédula de la enfermera", "Atención", JOptionPane.WARNING_MESSAGE);
            } else {
                String cedula = this.FieldCedula.getText().trim();
                String consulta = "";
                String[] enfermera = controlEnfermera.consultarEnfermera(cedula);
                if (enfermera == null) {
                    consulta = "No existe una enfermera con esa cédula en el hospital";
                } else {
                    String[] persona = controlPersona.consultarPersona(cedula);
                    String[] empleado = controlEmpleado.consultarEmpleado(cedula);                    
                    String[] area = controlArea.consultarArea(empleado[4]);
                    String[] jefe = controlEmpleado.consultarEmpleado(empleado[5]);
                    consulta = "DATOS PESONALES\nNombre: " + persona[1] + "\nDirección: " + persona[2] + "\nTeléfono: " + persona[3]
                            + "\n\nPERFIL PROFESIONAL\nAños de experiencia: " + enfermera[1] + 
                            "\n\nDATOS DEL EMPLEADO\nCargo: " + empleado[1] + "\nSalario: " + empleado[2] + "\nEmail: " + empleado[3];
                            
                    if (area != null) {
                        consulta += "\nÁrea: " + area[1] + ". cód: " + area[0];
                    }
                    if (jefe != null) {
                        consulta += "\nJefe: " + jefe[1] + ". cc: " + jefe[0];
                    }
                }
                this.TextArea.setText(consulta);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());                   
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error desde la vista");
        }
    }//GEN-LAST:event_ButtonConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonConsultar;
    private javax.swing.JTextField FieldCedula;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
