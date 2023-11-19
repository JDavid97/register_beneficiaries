package ayvdiningroom;

import db.Database;
import interfaces.DAOBeneficiaries;
import java.sql.PreparedStatement;
import java.util.List;
import models.Beneficiaries;

public class DAOBeneficiariesImpl extends Database implements DAOBeneficiaries{

    @Override
    public void insert(Beneficiaries beneficiarie) throws Exception {
        try {
            System.out.println("SI ENTRO 2");
            this.Conect();
            System.out.println("SI ENTRO3");
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO beneficiaries(names, lastnames, type_document, num_document, age, neighborhood, address, phone) VALUES (?,?,?,?,?,?,?,?);");
            
            st.setString(1, beneficiarie.getNames());
            st.setString(2, beneficiarie.getLastnames());
            st.setString(3, beneficiarie.getType_document());
            st.setString(4, beneficiarie.getNum_document());
            st.setInt(5, beneficiarie.getAge());
            st.setString(6, beneficiarie.getNeighborhood());
            st.setString(7, beneficiarie.getAddress());
            st.setString(8, beneficiarie.getPhone()); 
            System.out.println("Consulta SQL: " + st.toString());
            st.executeUpdate();
            System.out.println("SI ENTRO4");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.Close();
        }
    }

    @Override
    public void modify(Beneficiaries beneficiarie) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Beneficiaries beneficiarie) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Beneficiaries> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
