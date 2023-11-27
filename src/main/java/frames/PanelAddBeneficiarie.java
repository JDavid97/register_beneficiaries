/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;

import ayvdiningroom.DAOBeneficiariesImpl;
import interfaces.DAOBeneficiaries;
import java.awt.datatransfer.DataFlavor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Beneficiaries;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author judav
 */
public class PanelAddBeneficiarie extends javax.swing.JPanel {
    private PanelMenu pMenu;       
    boolean isEdit = false;    
    Beneficiaries beneficiarieToEdit;
    
    public PanelAddBeneficiarie() {
        initComponents();              
    }

    public PanelAddBeneficiarie(Beneficiaries beneficiarie) {
        initComponents();       
        beneficiarieToEdit = beneficiarie;
        editBeneficiarie(beneficiarieToEdit);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSaveBeneficiarie = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtNames = new javax.swing.JTextField();
        jtLastNames = new javax.swing.JTextField();
        jcbDocumentType = new javax.swing.JComboBox<>();
        jtDocumentNum = new javax.swing.JTextField();
        jtAge = new javax.swing.JTextField();
        jtNeighborhood = new javax.swing.JTextField();
        jtAddress = new javax.swing.JTextField();
        jtPhone = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1033, 654));

        jbSaveBeneficiarie.setBackground(new java.awt.Color(102, 151, 255));
        jbSaveBeneficiarie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbSaveBeneficiarie.setForeground(new java.awt.Color(255, 255, 255));
        jbSaveBeneficiarie.setText("Registrar");
        jbSaveBeneficiarie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSaveBeneficiarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveBeneficiarieActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombres");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apedillos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de documento");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Número del documento");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Barrio");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Edad");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Dirección");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Teléfono");

        jtNames.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jtLastNames.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jcbDocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Cedula", "Tarjeta de identidad", "Registro civil" }));
        jcbDocumentType.setBorder(null);
        jcbDocumentType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcbDocumentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDocumentTypeActionPerformed(evt);
            }
        });

        jtDocumentNum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtDocumentNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDocumentNumActionPerformed(evt);
            }
        });

        jtAge.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jtNeighborhood.setToolTipText("");
        jtNeighborhood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNeighborhoodActionPerformed(evt);
            }
        });

        jtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtNames, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                        .addComponent(jtDocumentNum)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jcbDocumentType, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtAge)))
                        .addComponent(jtPhone))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSaveBeneficiarie, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jtNeighborhood, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(jtLastNames))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtLastNames, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbSaveBeneficiarie, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtNames, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbDocumentType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtDocumentNum, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(140, 140, 140))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaveBeneficiarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveBeneficiarieActionPerformed
        String names, lastNames, age, documentType, documentNumber, neighborhood, phone, address;        
        
        names = jtNames.getText();
        lastNames = jtLastNames.getText();
        age = jtAge.getText();
        documentType = (String) jcbDocumentType.getSelectedItem();
        documentNumber = jtDocumentNum.getText();
        neighborhood = jtNeighborhood.getText();
        phone = jtPhone.getText();
        address = jtAddress.getText();
        
        if(names.isEmpty() || lastNames.isEmpty() || age.isEmpty() || documentType.isEmpty() || documentNumber.isEmpty()
                || neighborhood.isEmpty() || phone.isEmpty() || address.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.WARNING_MESSAGE);
            jtNames.requestFocus();
            return;
        }                             
        
        if(!isEdit){           
            try {   
                Beneficiaries beneficiarie = new Beneficiaries();
        
                beneficiarie.setNames(names);
                beneficiarie.setLastnames(lastNames);
                beneficiarie.setType_document(documentType);
                beneficiarie.setNum_document(documentNumber);
                beneficiarie.setAge(Integer.parseInt(age));
                beneficiarie.setNeighborhood(neighborhood);
                beneficiarie.setAddress(phone);
                beneficiarie.setPhone(address);
                
                DAOBeneficiaries dao = new DAOBeneficiariesImpl();
                if(dao.insert(beneficiarie)){
                    jtNames.setText("");
                    jtLastNames.setText("");
                    jtAge.setText("");
                    jcbDocumentType.setSelectedIndex(0);
                    jtDocumentNum.setText("");
                    jtNeighborhood.setText("");
                    jtPhone.setText("");
                    jtAddress.setText("");

                    jtNames.requestFocus();
                }                           

            }catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el beneficiario \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());                
            }   
        }else{
            try {
                beneficiarieToEdit.setNames(names);
                beneficiarieToEdit.setLastnames(lastNames);
                beneficiarieToEdit.setType_document(documentType);
                beneficiarieToEdit.setNum_document(documentNumber);
                beneficiarieToEdit.setAge(Integer.parseInt(age));
                beneficiarieToEdit.setNeighborhood(neighborhood);
                beneficiarieToEdit.setAddress(phone);
                beneficiarieToEdit.setPhone(address);
                
                DAOBeneficiaries dao = new DAOBeneficiariesImpl();
                if(dao.modify(beneficiarieToEdit)){
                    javax.swing.JOptionPane.showMessageDialog(null, beneficiarieToEdit.getNames()+" se editó correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);                            
                }                           
            
            }catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al editar el beneficiario \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());                
            }
        }        
                      
    }//GEN-LAST:event_jbSaveBeneficiarieActionPerformed
    
    private void editBeneficiarie(Beneficiaries beneficiarieToEdit) {                                                 
        jtNames.setText(beneficiarieToEdit.getNames());
        jtLastNames.setText(beneficiarieToEdit.getLastnames());
        jtAge.setText(Integer.toString(beneficiarieToEdit.getAge()));        
        jtDocumentNum.setText(beneficiarieToEdit.getNum_document());
        jtNeighborhood.setText(beneficiarieToEdit.getNeighborhood());
        jtPhone.setText(beneficiarieToEdit.getPhone());
        jtAddress.setText(beneficiarieToEdit.getAddress());
        
        jbSaveBeneficiarie.setText("Guardar");
        
        isEdit = true;
        
        // Combobox        
        String typeDocument = beneficiarieToEdit.getType_document();

        // Obtiene el modelo del JComboBox
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) jcbDocumentType.getModel();

        // Busca el índice del tipo de documento en el modelo del JComboBox
        int index = -1;
        for (int i = 0; i < model.getSize(); i++) {
            if (typeDocument.equals(model.getElementAt(i))) {
                index = i;
                break;
            }
        }
        
        jcbDocumentType.setSelectedIndex(index);                         
    }     
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jtNames.setText("");
        jtLastNames.setText("");
        jtAge.setText("");
        jcbDocumentType.setSelectedIndex(0);
        jtDocumentNum.setText("");
        jtNeighborhood.setText("");
        jtPhone.setText("");
        jtAddress.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcbDocumentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDocumentTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDocumentTypeActionPerformed

    private void jtDocumentNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDocumentNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDocumentNumActionPerformed

    private void jtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtAddressActionPerformed

    private void jtNeighborhoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNeighborhoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNeighborhoodActionPerformed

    private void clear(){             
        //FileManagement objetoB = new FileManagement();
        
        System.out.println("RUTA: "+pMenu.getFilePath());         
        //.out.println("RUTA2: "+objetoB.filePath);   
        jtNames.setText("");
        jtLastNames.setText("");
        jtAge.setText("");
        jtDocumentNum.setText("");
        jtNeighborhood.setText("");
        jtAddress.setText("");
        jtPhone.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbSaveBeneficiarie;
    private javax.swing.JComboBox<String> jcbDocumentType;
    private javax.swing.JTextField jtAddress;
    private javax.swing.JTextField jtAge;
    private javax.swing.JTextField jtDocumentNum;
    private javax.swing.JTextField jtLastNames;
    private javax.swing.JTextField jtNames;
    private javax.swing.JTextField jtNeighborhood;
    private javax.swing.JTextField jtPhone;
    // End of variables declaration//GEN-END:variables
}
