
package interfaces;

import java.util.List;
import models.Beneficiaries;

public interface DAOBeneficiaries {
    public boolean insert(Beneficiaries beneficiarie) throws Exception;
    public boolean modify(Beneficiaries beneficiarie) throws Exception;
    public void delete(String idBeneficiarie) throws Exception;
    public List<Beneficiaries> list() throws Exception;
    public List<Beneficiaries> listByName(String names) throws Exception;
    public Beneficiaries getBeneficiarieById(int idBeneficiarie) throws Exception;
}
