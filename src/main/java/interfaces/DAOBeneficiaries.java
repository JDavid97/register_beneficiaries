
package interfaces;

import java.util.List;
import models.Beneficiaries;

public interface DAOBeneficiaries {
    public boolean insert(Beneficiaries beneficiarie) throws Exception;
    public void modify(Beneficiaries beneficiarie) throws Exception;
    public void delete(String idBeneficiarie) throws Exception;
    public List<Beneficiaries> list() throws Exception;
}
