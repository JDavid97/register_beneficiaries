package ayvdiningroom;

import db.Database;
import interfaces.DAOInventoryProducts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.InventoryProducts;

public class DAOInventoryProductsImpl extends Database implements DAOInventoryProducts{

    @Override
    public boolean insert(InventoryProducts inventoryProduct) throws Exception {
        try {            
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO inventory_products(id_product, amount_product) VALUES (?,?);");
            
            st.setInt(1, inventoryProduct.getId_product());
            st.setDouble(2, inventoryProduct.getAmount_product());                       
            st.executeUpdate();                        
            st.close();                    
            
            return true;
        }catch (Exception e) {            
            System.out.println(e.getMessage());
            return false;
        } finally {
            this.Close();
        }
    }

    @Override
    public List<InventoryProducts> list() throws Exception {                
        List<InventoryProducts> list = null;
        try {
            this.Conect();
            //PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM products");
            PreparedStatement st = this.conexion.prepareStatement("SELECT internal_code, name, sum(amount_product) as total_amount_product, unit_of_measure, price FROM products\n" +
                                                                  "left join inventory_products on products.id = inventory_products.id_product\n"+
                                                                  "GROUP BY products.id, products.name;");
            Object obj = new Object();
            list = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                InventoryProducts inevnInventoryProduct = new InventoryProducts();
                
                inevnInventoryProduct.setId_product(rs.getInt("internal_code"));  
                inevnInventoryProduct.setName_product(rs.getString("name"));   
                inevnInventoryProduct.setAmount_product(rs.getInt("total_amount_product"));   
                inevnInventoryProduct.setUnit_of_measure(rs.getString("unit_of_measure"));   
                inevnInventoryProduct.setPrice(rs.getDouble("price"));                                   
    
                list.add(inevnInventoryProduct);
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.Close();
        }
        
        return list;
    }

    @Override
    public InventoryProducts getInventoryProductByIdProduct(int idProduct) throws Exception {
        InventoryProducts inventoryProduct = new InventoryProducts();
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("SELECT id_product, sum(amount_product) as total_amount_product FROM inventory_products WHERE id_product = ? LIMIT 1");
            
            st.setInt(1,idProduct);                        
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){                                
                inventoryProduct.setId_product(rs.getInt("id_product"));
                inventoryProduct.setAmount_product(rs.getDouble("total_amount_product"));         
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.Close();
        }
        
        return inventoryProduct;
    }
    
}
