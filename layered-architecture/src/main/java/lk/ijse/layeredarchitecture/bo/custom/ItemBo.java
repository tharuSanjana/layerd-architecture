package lk.ijse.layeredarchitecture.bo.custom;

import lk.ijse.layeredarchitecture.DAO.SuperBo;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {
    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException ;
    public Boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;
    public boolean existItem(String code) throws SQLException, ClassNotFoundException;
    public String generateNewId() throws SQLException, ClassNotFoundException;
}
