package lk.ijse.layeredarchitecture.DAO.Custom;

import lk.ijse.layeredarchitecture.DAO.CrudDAO;
import lk.ijse.layeredarchitecture.entity.Customer;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
     ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException;
     Boolean saveCustomer(Customer entity) throws SQLException, ClassNotFoundException ;

     Boolean updateCustomer(Customer entity) throws SQLException, ClassNotFoundException;
     Boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;


     String generateNewId() throws SQLException, ClassNotFoundException;
     Customer searchCustomer(String newValue) throws SQLException, ClassNotFoundException;
}
