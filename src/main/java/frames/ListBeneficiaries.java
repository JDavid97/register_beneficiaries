/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
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
        //excelToTable();
    }

    private void excelToTable () {
        // Ruta del archivo Excel
        String excelFilePath = "";
        
        excelFilePath = pMenu.getFilePath();
        System.out.println("RUTA: "+excelFilePath);
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPaneListBeneficiaries = new javax.swing.JScrollPane();
        jtableListBeneficiaries = new javax.swing.JTable();
        jbAddBeneficiarie = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Listado de beneficiarios");
        jLabel1.setPreferredSize(new java.awt.Dimension(299, 32));
        jLabel1.setRequestFocusEnabled(false);

        jButton1.setBackground(new java.awt.Color(38, 69, 159));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");

        jtableListBeneficiaries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneListBeneficiaries.setViewportView(jtableListBeneficiaries);

        jbAddBeneficiarie.setBackground(new java.awt.Color(38, 69, 159));
        jbAddBeneficiarie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbAddBeneficiarie.setForeground(new java.awt.Color(255, 255, 255));
        jbAddBeneficiarie.setText("Nuevo");
        jbAddBeneficiarie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddBeneficiarieActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(38, 69, 159));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Editar");

        jButton4.setBackground(new java.awt.Color(38, 69, 159));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Borrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbAddBeneficiarie, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPaneListBeneficiaries)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneListBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddBeneficiarie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddBeneficiarieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBeneficiarieActionPerformed
        // TODO add your handling code here:
        PanelAddBeneficiarie pAddUser = new PanelAddBeneficiarie();
        pAddUser.setSize(1057, 660);
        pAddUser.setLocation(0, 0);                  
        
        pMenu.setPanelContent(pAddUser);
   
    }//GEN-LAST:event_jbAddBeneficiarieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneListBeneficiaries;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbAddBeneficiarie;
    private javax.swing.JTable jtableListBeneficiaries;
    // End of variables declaration//GEN-END:variables
}
