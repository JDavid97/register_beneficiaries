package interfaces;

import java.util.List;
import models.InventoryProducts;
/**
 *
 * @author judav
 */
public interface DAOInventoryProducts {
    public boolean insert(InventoryProducts inventoryProduct) throws Exception;
    //public boolean modify(InventoryProducts inventoryProduct) throws Exception;
    //public void delete(String idInventoryProducts) throws Exception;
    public List<InventoryProducts> list() throws Exception;
    //public List<InventoryProducts> listByName(String names) throws Exception;
    public InventoryProducts getInventoryProductByIdProduct(int idProduct) throws Exception;
}
