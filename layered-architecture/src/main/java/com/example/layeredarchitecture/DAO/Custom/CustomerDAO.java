package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
     Boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

     Boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
     Boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;


     String generateNewId() throws SQLException, ClassNotFoundException;
     CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;
}
