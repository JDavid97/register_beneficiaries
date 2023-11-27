/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;

import ayvdiningroom.DAOBeneficiariesImpl;
import interfaces.DAOBeneficiaries;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Beneficiaries;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author judav
 */
public class ListBeneficiaries extends javax.swing.JPanel {
    private PanelMenu pMenu;
   
    public ListBeneficiaries(PanelMenu pMenu) {
        initComponents();                
        this.pMenu = pMenu;
        loadBeneficiaries();               
    }   
    
    private void loadBeneficiaries(){
        try {
            DAOBeneficiaries dao = new DAOBeneficiariesImpl();
            DefaultTableModel model = (DefaultTableModel) jtableListBeneficiaries.getModel();
            
            List<models.Beneficiaries> lista = dao.list();
            dao.list().forEach((b) -> model.addRow(new Object[]{b.getId(), b.getNames(), b.getLastnames(), b.getType_document(), b.getNum_document(), b.getAge(), b.getNeighborhood(), b.getAddress(), b.getPhone()}));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void excelToTable () {
        // Ruta del archivo Excel
        String excelFilePath = "";
        
        excelFilePath = pMenu.getFilePath();        
        DefaultTableModel model = new DefaultTableModel();
        
        jtableListBeneficiaries.setModel(model);
        
        int startRow = 13;  
        int startColumn = 2;

        try (FileInputStream inputStream = new FileInputStream(excelFilePath)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            // Agregar encabezados de columna al modelo
            Row headerRow = sheet.getRow(0);
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                Cell cell = headerRow.getCell(i);
                model.addColumn(cell.getStringCellValue());
            }

            // Agregar filas al modelo desde el archivo Excel
            for (int rowIndex = startRow; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row currentRow = sheet.getRow(rowIndex);
                
                if (currentRow != null) {
                    Object[] rowData = new Object[currentRow.getPhysicalNumberOfCells()];

                    for (int cellIndex = startColumn; cellIndex < currentRow.getPhysicalNumberOfCells(); cellIndex++) {
                        Cell cell = currentRow.getCell(cellIndex);

                        switch (cell.getCellType()) {
                            case STRING:
                                rowData[cellIndex] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                rowData[cellIndex] = cell.getNumericCellValue();
                                break;
                            case BOOLEAN:
                                rowData[cellIndex] = cell.getBooleanCellValue();
                                break;
                            default:
                                // Puedes manejar otros tipos de celda según sea necesario
                                rowData[cellIndex] = "";
                        }
                    }               
                    // Agregar la fila al modelo
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtBeneficiarieSearch = new javax.swing.JTextField();
        jbSearchBeneficiaries = new javax.swing.JButton();
        jScrollPaneListBeneficiaries = new javax.swing.JScrollPane();
        jtableListBeneficiaries = new javax.swing.JTable();
        jbAddBeneficiarie = new javax.swing.JButton();
        jbEditBeneficiarie = new javax.swing.JButton();
        jbDeleteBeneficiaries = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jtBeneficiarieSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBeneficiarieSearchActionPerformed(evt);
            }
        });

        jbSearchBeneficiaries.setBackground(new java.awt.Color(102, 151, 255));
        jbSearchBeneficiaries.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbSearchBeneficiaries.setForeground(new java.awt.Color(255, 255, 255));
        jbSearchBeneficiaries.setText("Buscar");
        jbSearchBeneficiaries.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearchBeneficiaries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchBeneficiariesActionPerformed(evt);
            }
        });

        jtableListBeneficiaries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombres", "Apellidos", "Tipo de documento", "Número de documento", "Edad", "Barrio", "Correo", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneListBeneficiaries.setViewportView(jtableListBeneficiaries);
        if (jtableListBeneficiaries.getColumnModel().getColumnCount() > 0) {
            jtableListBeneficiaries.getColumnModel().getColumn(0).setMaxWidth(40);
            jtableListBeneficiaries.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        jbAddBeneficiarie.setBackground(new java.awt.Color(102, 151, 255));
        jbAddBeneficiarie.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbAddBeneficiarie.setForeground(new java.awt.Color(255, 255, 255));
        jbAddBeneficiarie.setText("Nuevo");
        jbAddBeneficiarie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddBeneficiarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddBeneficiarieActionPerformed(evt);
            }
        });

        jbEditBeneficiarie.setBackground(new java.awt.Color(102, 151, 255));
        jbEditBeneficiarie.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbEditBeneficiarie.setForeground(new java.awt.Color(255, 255, 255));
        jbEditBeneficiarie.setText("Editar");
        jbEditBeneficiarie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditBeneficiarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditBeneficiarieActionPerformed(evt);
            }
        });

        jbDeleteBeneficiaries.setBackground(new java.awt.Color(102, 151, 255));
        jbDeleteBeneficiaries.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbDeleteBeneficiaries.setForeground(new java.awt.Color(255, 255, 255));
        jbDeleteBeneficiaries.setText("Borrar");
        jbDeleteBeneficiaries.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDeleteBeneficiaries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteBeneficiariesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneListBeneficiaries, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAddBeneficiarie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditBeneficiarie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbDeleteBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtBeneficiarieSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSearchBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBeneficiarieSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearchBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneListBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbDeleteBeneficiaries, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jbEditBeneficiarie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAddBeneficiarie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddBeneficiarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBeneficiarieActionPerformed
        PanelAddBeneficiarie pAddBeneficiarie = new PanelAddBeneficiarie();
        pAddBeneficiarie.setSize(1097, 685);
        pAddBeneficiarie.setLocation(0, 0);                  
        
        pMenu.setPanelContent(pAddBeneficiarie);
        pMenu.setjlTitleContent("Adicionar beneficiario");
    }//GEN-LAST:event_jbAddBeneficiarieActionPerformed

    private void jtBeneficiarieSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBeneficiarieSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBeneficiarieSearchActionPerformed

    private void jbDeleteBeneficiariesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteBeneficiariesActionPerformed
        String names = "";
        String idsBeneficiaries = "";
        int count = 0;
        
        if(jtableListBeneficiaries.getSelectedRow() > -1){                    
            for (int i : jtableListBeneficiaries.getSelectedRows()){    
                idsBeneficiaries += jtableListBeneficiaries.getValueAt(i, 0)+",";                        
                names += jtableListBeneficiaries.getValueAt(i, 1)+", ";                
                count++;
            }   

            idsBeneficiaries = idsBeneficiaries.substring(0, idsBeneficiaries.length()-1);
            names = names.substring(0, names.length()-2);

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar a "+names+"?", "Confirmar salida", JOptionPane.YES_NO_OPTION);                 

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    DAOBeneficiaries dao = new DAOBeneficiariesImpl();
                    dao.delete(idsBeneficiaries);    

                    if(count == 1){
                        javax.swing.JOptionPane.showMessageDialog(this, names+" se eliminó correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(this, names+" se eliminaron correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                    }   
                    DefaultTableModel model = (DefaultTableModel) jtableListBeneficiaries.getModel(); 
                    model.setRowCount(0);

                    loadBeneficiaries();
                }catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar los registros \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.getMessage());
                } 
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar los registros a eliminar. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbDeleteBeneficiariesActionPerformed
    
    private void jbEditBeneficiarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditBeneficiarieActionPerformed
        if(jtableListBeneficiaries.getSelectedRow() > -1){
            int idBeneficiarie = (int) jtableListBeneficiaries.getValueAt(jtableListBeneficiaries.getSelectedRow(), 0);
            
            try {
                    DAOBeneficiaries dao = new DAOBeneficiariesImpl();
                    Beneficiaries beneficiarie = dao.getBeneficiarieById(idBeneficiarie);                                                               

                    PanelAddBeneficiarie pEditBeneficiarie = new PanelAddBeneficiarie(beneficiarie);
                    pEditBeneficiarie.setSize(1097, 685);
                    pEditBeneficiarie.setLocation(0, 0);  
                    
                    pMenu.setPanelContent(pEditBeneficiarie);
                    pMenu.setjlTitleContent("Editar beneficiario");
                    
                    
                }catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al editar el registro \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.getMessage());
                }               
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para editar. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_jbEditBeneficiarieActionPerformed

    private void jbSearchBeneficiariesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchBeneficiariesActionPerformed
        try {
            DAOBeneficiaries dao = new DAOBeneficiariesImpl();
            DefaultTableModel model = (DefaultTableModel) jtableListBeneficiaries.getModel();
                        
            model.setRowCount(0);
            //List<models.Beneficiaries> list = dao.listByName(jtBeneficiarieSearch.getName());
            dao.listByName(jtBeneficiarieSearch.getText()).forEach((b) -> model.addRow(new Object[]{b.getId(), b.getNames(), b.getLastnames(), b.getType_document(), b.getNum_document(), b.getAge(), b.getNeighborhood(), b.getAddress(), b.getPhone()}));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbSearchBeneficiariesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneListBeneficiaries;
    private javax.swing.JButton jbAddBeneficiarie;
    private javax.swing.JButton jbDeleteBeneficiaries;
    private javax.swing.JButton jbEditBeneficiarie;
    private javax.swing.JButton jbSearchBeneficiaries;
    private javax.swing.JTextField jtBeneficiarieSearch;
    private javax.swing.JTable jtableListBeneficiaries;
    // End of variables declaration//GEN-END:variables
}
