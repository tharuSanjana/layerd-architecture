package lk.ijse.layeredarchitecture.bo.custom.Impl;

import lk.ijse.layeredarchitecture.DAO.Custom.ItemDAO;
import lk.ijse.layeredarchitecture.DAO.DAOFactory;
import lk.ijse.layeredarchitecture.bo.custom.ItemBo;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllItems();
    }
    public Boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.deleteItem(code);
    }
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.existItem(code);
    }
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
}
