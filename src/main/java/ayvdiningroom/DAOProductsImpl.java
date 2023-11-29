package ayvdiningroom;

import db.Database;
import interfaces.DAOProducts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Products;

public class DAOProductsImpl extends Database implements DAOProducts{

    @Override
    public boolean insert(Products product) throws Exception {
        try {            
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO products(name, state, internal_code, price, unit_of_measure) VALUES (?,?,?,?,?);");
            
            st.setString(1, product.getName());
            st.setString(2, product.getState());
            st.setString(3, product.getInternal_code());
            st.setDouble(4, product.getPrice());
            st.setString(5, product.getUnit_of_measure());            
            
            st.executeUpdate();                        
            st.close();                        
            
            return true;
        }catch (java.sql.SQLIntegrityConstraintViolationException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ya se encuentra registrado un producto con código "+product.getInternal_code()+" \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                
                return false;
        }catch (Exception e) {            
            System.out.println(e.getMessage());
            return false;
        } finally {
            this.Close();
        }
    }

    @Override
    public boolean modify(Products product) throws Exception {
        try {            
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("UPDATE products SET name = ?, state = ?, internal_code = ?, price = ?, unit_of_measure = ? WHERE id = ?;");
            
            st.setString(1, product.getName());
            st.setString(2, product.getState());
            st.setString(3, product.getInternal_code());
            st.setDouble(4, product.getPrice());
            st.setString(5, product.getUnit_of_measure());      
            st.setInt(6, product.getId());                         
                        
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
    public void delete(String idProducts) throws Exception {
        try {                   
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM products WHERE ID IN ("+idProducts+");");
            

            st.executeUpdate();
            st.close();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.Close();
        }
    }

    @Override
    public List<Products> list() throws Exception {
        List<Products> list = null;
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM products");
            
            list = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Products product = new Products();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setState(rs.getString("state"));
                product.setInternal_code(rs.getString("internal_code"));
                product.setPrice(rs.getDouble("price"));
                product.setUnit_of_measure(rs.getString("unit_of_measure"));
    
                list.add(product);
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
    public List<Products> listByName(String name) throws Exception {
        List<Products> list = null;
        try {
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM products WHERE name like ?");
            
            st.setString(1, "%" + name + "%");                                    
            list = new ArrayList();
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Products product = new Products();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setState(rs.getString("state"));
                product.setInternal_code(rs.getString("internal_code"));
                product.setPrice(rs.getDouble("price"));
                product.setUnit_of_measure(rs.getString("unit_of_measure"));
 
                list.add(product);
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
    public Products getProductById(int idProduct) throws Exception {
        Products product = new Products();
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM products WHERE id = ? LIMIT 1");
            
            st.setInt(1,idProduct);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){                
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setState(rs.getString("state"));
                product.setInternal_code(rs.getString("internal_code"));
                product.setPrice(rs.getDouble("price"));
                product.setUnit_of_measure(rs.getString("unit_of_measure"));           
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.Close();
        }
        
        return product;
    }   
}
