package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO> {
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
    Boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

     Boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;
    //void updateItem(String description,BigDecimal unitPrice,int qtyOnHand,String code) throws SQLException, ClassNotFoundException;


     boolean existItem(String code) throws SQLException, ClassNotFoundException;
     String generateNewId() throws SQLException, ClassNotFoundException;
     ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;


}
