package lk.ijse.layeredarchitecture.bo.custom;

import lk.ijse.layeredarchitecture.DAO.SuperBo;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;
import lk.ijse.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo extends SuperBo {

   // public ArrayList<CustomerDTO> getAllCustomer() throws Exception;

    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    public Boolean saveCustomer(CustomerDTO entity) throws SQLException, ClassNotFoundException;


    public Boolean updateCustomer(CustomerDTO entity) throws SQLException, ClassNotFoundException ;


    public Boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;


    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;


    public String generateNewId() throws SQLException, ClassNotFoundException;


    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException ;


    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(Customer entity) throws SQLException, ClassNotFoundException ;


    public boolean update(Customer entity) throws SQLException, ClassNotFoundException ;


    public boolean delete(String id) throws SQLException, ClassNotFoundException ;


    public boolean exist(String id) throws SQLException, ClassNotFoundException;


    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException;

}
