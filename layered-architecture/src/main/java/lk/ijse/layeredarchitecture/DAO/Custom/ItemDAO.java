package lk.ijse.layeredarchitecture.DAO.Custom;

import lk.ijse.layeredarchitecture.DAO.CrudDAO;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item> {
     ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException ;
    Boolean saveItem(Item entity) throws SQLException, ClassNotFoundException ;

     Boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;
    //void updateItem(String description,BigDecimal unitPrice,int qtyOnHand,String code) throws SQLException, ClassNotFoundException;


     boolean existItem(String code) throws SQLException, ClassNotFoundException;
     String generateNewId() throws SQLException, ClassNotFoundException;
     Item searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    boolean update(Item entity) throws SQLException, ClassNotFoundException;


}
