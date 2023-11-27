
package interfaces;

import java.util.List;
import models.Products;

public interface DAOProducts {
    public boolean insert(Products product) throws Exception;
    public boolean modify(Products product) throws Exception;
    public void delete(String idProducts) throws Exception;
    public List<Products> list() throws Exception;
    public List<Products> listByName(String names) throws Exception;
    public Products getProductById(int idProduct) throws Exception;
}
