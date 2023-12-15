package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
    void saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException ;

     void deleteItem(String code) throws SQLException, ClassNotFoundException ;
    void updateItem(String description,BigDecimal unitPrice,int qtyOnHand,String code) throws SQLException, ClassNotFoundException;


     boolean existItem(String code) throws SQLException, ClassNotFoundException;
     String generateNewId() throws SQLException, ClassNotFoundException;
}
