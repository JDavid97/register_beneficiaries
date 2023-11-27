/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames.products;

import ayvdiningroom.DAOBeneficiariesImpl;
import ayvdiningroom.DAOProductsImpl;
import frames.PanelAddBeneficiarie;
import frames.PanelMenu;
import interfaces.DAOBeneficiaries;
import interfaces.DAOProducts;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Beneficiaries;
import models.Products;

/**
 *
 * @author judav
 */
public class PanelProducts extends javax.swing.JPanel {

    PanelMenu pMenu;
    
    public PanelProducts(PanelMenu pMenu) {
        initComponents();
        this.pMenu = pMenu;
        loadProducts();
    }    
    
    private void loadProducts(){
        try {
            DAOProducts dao = new DAOProductsImpl();
            DefaultTableModel model = (DefaultTableModel) jtableListProducts.getModel();
            
            //List<models.Products> lista = dao.list();
            dao.list().forEach((b) -> model.addRow(new Object[]{b.getId(), b.getName(), b.getState(), b.getInternal_code(), b.getPrice(), b.getUnit_of_measure()}));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtSearchProducts = new javax.swing.JTextField();
        jbSearchProducts = new javax.swing.JButton();
        jScrollPaneListProducts = new javax.swing.JScrollPane();
        jtableListProducts = new javax.swing.JTable();
        jbAddProduct = new javax.swing.JButton();
        jbEditProduct = new javax.swing.JButton();
        jbDeleteProducts = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jbSearchProducts.setBackground(new java.awt.Color(102, 151, 255));
        jbSearchProducts.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbSearchProducts.setForeground(new java.awt.Color(255, 255, 255));
        jbSearchProducts.setText("Buscar");
        jbSearchProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearchProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchProductsActionPerformed(evt);
            }
        });

        jtableListProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Estado", "Código interno", "Precio", "Unidad de medida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneListProducts.setViewportView(jtableListProducts);
        if (jtableListProducts.getColumnModel().getColumnCount() > 0) {
            jtableListProducts.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jbAddProduct.setBackground(new java.awt.Color(102, 151, 255));
        jbAddProduct.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbAddProduct.setText("Nuevo");
        jbAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddProductActionPerformed(evt);
            }
        });

        jbEditProduct.setBackground(new java.awt.Color(102, 151, 255));
        jbEditProduct.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbEditProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbEditProduct.setText("Editar");
        jbEditProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditProductActionPerformed(evt);
            }
        });

        jbDeleteProducts.setBackground(new java.awt.Color(102, 151, 255));
        jbDeleteProducts.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jbDeleteProducts.setForeground(new java.awt.Color(255, 255, 255));
        jbDeleteProducts.setText("Borrar");
        jbDeleteProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDeleteProducts.setPreferredSize(new java.awt.Dimension(87, 32));
        jbDeleteProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteProductsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbDeleteProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPaneListProducts)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jbSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearchProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneListProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDeleteProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddProductActionPerformed
        PanelAddProduct pAddProduct = new PanelAddProduct();
        pAddProduct.setSize(1097, 685);
        pAddProduct.setLocation(0, 0);                  
        
        pMenu.setPanelContent(pAddProduct);
        pMenu.setjlTitleContent("Adicionar producto");
    }//GEN-LAST:event_jbAddProductActionPerformed

    private void jbSearchProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchProductsActionPerformed
        try{
            DAOProducts dao = new DAOProductsImpl();
            DefaultTableModel model = (DefaultTableModel) jtableListProducts.getModel();
            
            model.setRowCount(0);
            dao.listByName(jtSearchProducts.getText()).forEach((p) -> model.addRow(new Object[]{p.getId(), p.getName(), p.getState(), p.getInternal_code(), p.getPrice(), p.getUnit_of_measure()}));          
            
        }catch(Exception e){
            System.out.println(e.getMessage());            
        }
    }//GEN-LAST:event_jbSearchProductsActionPerformed

    private void jbDeleteProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteProductsActionPerformed
        String names = "";
        String idsProducts = "";
        int count = 0;
        
        if(jtableListProducts.getSelectedRow() > -1){                    
            for (int i : jtableListProducts.getSelectedRows()){    
                idsProducts += jtableListProducts.getValueAt(i, 0)+",";                        
                names += jtableListProducts.getValueAt(i, 1)+", ";                
                count++;
            }   

            idsProducts = idsProducts.substring(0, idsProducts.length()-1);
            names = names.substring(0, names.length()-2);

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar: "+names+"?", "Confirmar salida", JOptionPane.YES_NO_OPTION);                 

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    DAOProducts dao = new DAOProductsImpl();
                    dao.delete(idsProducts);    

                    if(count == 1){
                        javax.swing.JOptionPane.showMessageDialog(this, names+" se eliminó correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(this, names+" se eliminaron correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                    }   
                    DefaultTableModel model = (DefaultTableModel) jtableListProducts.getModel(); 
                    model.setRowCount(0);

                    loadProducts();
                }catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar los registros \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.getMessage());
                } 
            }
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar los registros a eliminar. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbDeleteProductsActionPerformed

    private void jbEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditProductActionPerformed
        if(jtableListProducts.getSelectedRow() > -1){
            int idProduct = (int) jtableListProducts.getValueAt(jtableListProducts.getSelectedRow(), 0);
            
            try {
                    DAOProducts dao = new DAOProductsImpl();
                    Products product = dao.getProductById(idProduct);                                                               

                    PanelAddProduct pEditProduct = new PanelAddProduct(product);
                    pEditProduct.setSize(1097, 685);
                    pEditProduct.setLocation(0, 0);  
                    
                    pMenu.setPanelContent(pEditProduct);
                    pMenu.setjlTitleContent("Editar producto");
                    
                    
                }catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al editar el registro \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.getMessage());
                }               
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para editar. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEditProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneListProducts;
    private javax.swing.JButton jbAddProduct;
    private javax.swing.JButton jbDeleteProducts;
    private javax.swing.JButton jbEditProduct;
    private javax.swing.JButton jbSearchProducts;
    private javax.swing.JTextField jtSearchProducts;
    private javax.swing.JTable jtableListProducts;
    // End of variables declaration//GEN-END:variables
}
