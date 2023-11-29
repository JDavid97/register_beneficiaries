/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;

import ayvdiningroom.DAOInventoryProductsImpl;
import ayvdiningroom.DAOProductsImpl;
import interfaces.DAOInventoryProducts;
import interfaces.DAOProducts;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.InventoryProducts;
import models.Products;

/**
 *
 * @author judav
 */
public class PanelInventory extends javax.swing.JPanel {
    PanelMenu pMenu;
    Map<String, Integer> idMap = new HashMap<>();
    
    public PanelInventory(PanelMenu pMenu) {
        initComponents();
        this.pMenu = pMenu;
        loadProducts();
        loadInventoryProducts();
    }

    public JTable getjtInventoryProducts() {
        return jtInventoryProducts;
    }

    public void setjtInventoryProducts(JTable jTable1) {
        this.jtInventoryProducts = jTable1;
    }        

    private void loadProducts(){           
        try {
            DAOProducts dao = new DAOProductsImpl();                                   
            dao.list().forEach((b) -> addOpcWithID(jcbProducts, idMap, b.getName(), b.getId()));               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void loadInventoryProducts(){
        jtInventoryProducts.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        try {
            DAOInventoryProducts dao = new DAOInventoryProductsImpl();
            DefaultTableModel model = (DefaultTableModel) jtInventoryProducts.getModel();
                        
            dao.list().forEach((b) -> model.addRow(new Object[]{b.getId_product(), b.getName_product(), b.getAmount_product(), b.getUnit_of_measure(), b.getPrice()}));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // Clase para personalizar el renderizador de celdas
    private class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(jTable, value, isSelected, hasFocus, row, column);

            // Cambiar el color de fondo para las filas no ocupadas
            if (value == null) {
                component.setBackground(new Color(255, 255, 255)); // Color personalizado
            } else {
                component.setBackground(jtInventoryProducts.getBackground());
            }

            return component;
        }
    }
    
    private static void addOpcWithID(JComboBox<String> comboBox, Map<String, Integer> idMap, String opcion, int id) {
        comboBox.addItem(opcion);
        idMap.put(opcion, id);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtabInventory = new javax.swing.JTabbedPane();
        jpRegisterMovements = new javax.swing.JPanel();
        jgSaveInventoryProduct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbProducts = new javax.swing.JComboBox<>();
        jlInternal_code = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlExist = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtCantProduct = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jlUnitOfMeasure = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpActualInventory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInventoryProducts = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jtabInventory.setToolTipText("");

        jpRegisterMovements.setBackground(new java.awt.Color(255, 255, 255));
        jpRegisterMovements.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jgSaveInventoryProduct.setBackground(new java.awt.Color(0, 204, 204));
        jgSaveInventoryProduct.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jgSaveInventoryProduct.setForeground(new java.awt.Color(255, 255, 255));
        jgSaveInventoryProduct.setText("CONFIRMAR MOVIMIENTO");
        jgSaveInventoryProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jgSaveInventoryProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jgSaveInventoryProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgSaveInventoryProductActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jcbProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        jcbProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductsActionPerformed(evt);
            }
        });

        jLabel2.setText("Código interno:");

        jLabel4.setText("Existencia:");

        jLabel3.setText("Cantidad:");

        jLabel5.setText("Unidades:");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel6.setText("Registrar Movimientos");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpRegisterMovementsLayout = new javax.swing.GroupLayout(jpRegisterMovements);
        jpRegisterMovements.setLayout(jpRegisterMovementsLayout);
        jpRegisterMovementsLayout.setHorizontalGroup(
            jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegisterMovementsLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegisterMovementsLayout.createSequentialGroup()
                        .addComponent(jgSaveInventoryProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegisterMovementsLayout.createSequentialGroup()
                        .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlExist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlInternal_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbProducts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtCantProduct)
                            .addComponent(jlUnitOfMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegisterMovementsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33)))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jpRegisterMovementsLayout.setVerticalGroup(
            jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegisterMovementsLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbProducts)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlInternal_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlExist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCantProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRegisterMovementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlUnitOfMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(jgSaveInventoryProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        jtabInventory.addTab("Registrar Movimientos", jpRegisterMovements);

        jpActualInventory.setBackground(new java.awt.Color(255, 255, 255));

        jtInventoryProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre del producto", "Cantidad", "Unidad de medida", "Costo/Unidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtInventoryProducts);
        if (jtInventoryProducts.getColumnModel().getColumnCount() > 0) {
            jtInventoryProducts.getColumnModel().getColumn(0).setMaxWidth(300);
        }

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel7.setText("Inventario Actual");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpActualInventoryLayout = new javax.swing.GroupLayout(jpActualInventory);
        jpActualInventory.setLayout(jpActualInventoryLayout);
        jpActualInventoryLayout.setHorizontalGroup(
            jpActualInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpActualInventoryLayout.createSequentialGroup()
                .addContainerGap(411, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(407, 407, 407))
        );
        jpActualInventoryLayout.setVerticalGroup(
            jpActualInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpActualInventoryLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtabInventory.addTab("Inventario actual", jpActualInventory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jtabInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jtabInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jtabInventory.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jgSaveInventoryProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgSaveInventoryProductActionPerformed
        String amount_product, idProduct;        
        
        idProduct = (String) jcbProducts.getSelectedItem();        
        amount_product = jtCantProduct.getText();                   
                        
        if(amount_product.isEmpty() || idProduct.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO", JOptionPane.WARNING_MESSAGE);
            jcbProducts.requestFocus();
            return;
        }                      
                
        try {   
            InventoryProducts inventoryProduct = new InventoryProducts();
            
            if (idProduct != null) {
                int idSelected = idMap.get(idProduct);                
                
                inventoryProduct.setId_product(idSelected);
                inventoryProduct.setAmount_product(Double.parseDouble(amount_product)); 
                
                DAOInventoryProducts dao = new DAOInventoryProductsImpl();
                DAOInventoryProducts daoInventoryProducts = new DAOInventoryProductsImpl();  
                if(dao.insert(inventoryProduct)){
                    javax.swing.JOptionPane.showMessageDialog(null, "Se ingresó "+amount_product+" "+jlUnitOfMeasure.getText()+" (es/s) de "+jcbProducts.getSelectedItem()+". \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                    
                    InventoryProducts inventoryProductsSelected = daoInventoryProducts.getInventoryProductByIdProduct(idSelected);
                    jlExist.setText(Double.toString(inventoryProductsSelected.getAmount_product()));                    
                    jtCantProduct.setText("");   
                } 
            }            
                          
        }catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el movimiento. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());                
        }           
    }//GEN-LAST:event_jgSaveInventoryProductActionPerformed

    private void jcbProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductsActionPerformed
        //System.out.println("SELECCIONO: "+jcbProducts.getSelectedItem());
        
        String sel = (String) jcbProducts.getSelectedItem();
        if (sel != null) {
            int idSelected = idMap.get(sel);                        
            try {                
                DAOProducts daoProducts = new DAOProductsImpl(); 
                DAOInventoryProducts daoInventoryProducts = new DAOInventoryProductsImpl();                                                               
                Products productSelected = daoProducts.getProductById(idSelected);
                                
                jlInternal_code.setText(productSelected.getInternal_code());
                jlUnitOfMeasure.setText(productSelected.getUnit_of_measure());
                
                InventoryProducts inventoryProductsSelected = daoInventoryProducts.getInventoryProductByIdProduct(idSelected);
                jlExist.setText(Double.toString(inventoryProductsSelected.getAmount_product()));                                                                               
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jcbProductsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbProducts;
    private javax.swing.JButton jgSaveInventoryProduct;
    private javax.swing.JLabel jlExist;
    private javax.swing.JLabel jlInternal_code;
    private javax.swing.JLabel jlUnitOfMeasure;
    private javax.swing.JPanel jpActualInventory;
    private javax.swing.JPanel jpRegisterMovements;
    private javax.swing.JTextField jtCantProduct;
    private javax.swing.JTable jtInventoryProducts;
    private javax.swing.JTabbedPane jtabInventory;
    // End of variables declaration//GEN-END:variables
}
