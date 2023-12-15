package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
     void saveCustomer(String id, String name,String address) throws SQLException, ClassNotFoundException ;

     void updateCustomer(String name,String address,String id) throws SQLException, ClassNotFoundException;
     void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
     boolean exsitCustomer(String id) throws SQLException, ClassNotFoundException ;


     String generateNewId() throws SQLException, ClassNotFoundException;

}
