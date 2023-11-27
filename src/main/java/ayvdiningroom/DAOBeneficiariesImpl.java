package ayvdiningroom;

import db.Database;
import interfaces.DAOBeneficiaries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Beneficiaries;

public class DAOBeneficiariesImpl extends Database implements DAOBeneficiaries{

    @Override
    public boolean insert(Beneficiaries beneficiarie) throws Exception {
        try {            
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO beneficiaries(names, lastnames, type_document, num_document, age, neighborhood, address, phone) VALUES (?,?,?,?,?,?,?,?);");
            
            st.setString(1, beneficiarie.getNames());
            st.setString(2, beneficiarie.getLastnames());
            st.setString(3, beneficiarie.getType_document());
            st.setString(4, beneficiarie.getNum_document());
            st.setInt(5, beneficiarie.getAge());
            st.setString(6, beneficiarie.getNeighborhood());
            st.setString(7, beneficiarie.getAddress());
            st.setString(8, beneficiarie.getPhone()); 
            
            st.executeUpdate();                        
            st.close();            
            javax.swing.JOptionPane.showMessageDialog(null, beneficiarie.getNames()+" se registró correctamente. \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
            
            return true;
        }catch (java.sql.SQLIntegrityConstraintViolationException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ya se encuentra registrado un beneficiario con numero de documento "+beneficiarie.getNum_document()+" \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);          
                
                return false;
        }catch (Exception e) {            
            System.out.println(e.getMessage());
            return false;
        } finally {
            this.Close();
        }
    }

    @Override
    public void modify(Beneficiaries beneficiarie) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String idsBeneficiaries) throws Exception {
        try {                   
            this.Conect();            
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM beneficiaries WHERE ID IN ("+idsBeneficiaries+");");
            

            st.executeUpdate();
            st.close();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.Close();
        }
    }

    @Override
    public List<Beneficiaries> list() throws Exception {
        List<Beneficiaries> list = null;
        try {
            this.Conect();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM beneficiaries");
            
            list = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Beneficiaries beneficiarie = new Beneficiaries();
                beneficiarie.setId(rs.getInt("id"));
                beneficiarie.setNames(rs.getString("names"));
                beneficiarie.setLastnames(rs.getString("lastNames"));
                beneficiarie.setType_document(rs.getString("type_document"));
                beneficiarie.setNum_document(rs.getString("num_document"));
                beneficiarie.setAge(rs.getInt("age"));
                beneficiarie.setNeighborhood(rs.getString("neighborhood"));
                beneficiarie.setAddress(rs.getString("address"));
                beneficiarie.setPhone(rs.getString("phone"));
                list.add(beneficiarie);
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
    
}
