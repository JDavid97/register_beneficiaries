
package interfaces;

import java.util.List;
import models.Beneficiaries;

public interface DAOBeneficiaries {
    public void insert(Beneficiaries beneficiarie) throws Exception;
    public void modify(Beneficiaries beneficiarie) throws Exception;
    public void delete(Beneficiaries beneficiarie) throws Exception;
    public List<Beneficiaries> list() throws Exception;
}
