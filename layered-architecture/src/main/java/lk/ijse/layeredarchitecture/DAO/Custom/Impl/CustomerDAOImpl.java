package lk.ijse.layeredarchitecture.DAO.Custom.Impl;

import lk.ijse.layeredarchitecture.DAO.Custom.CustomerDAO;
import lk.ijse.layeredarchitecture.DAO.SqlUtil;
import lk.ijse.layeredarchitecture.entity.Customer;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public ArrayList<Customer> getAllCustomer() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Customer";
        ResultSet rst = s.test(sql);
       ArrayList<Customer> getAllCustomer = new ArrayList<>();
        while (rst.next()){
            Customer customer = new Customer(rst.getString("id"),rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customer);
        }
        return getAllCustomer;
    }
    @Override
    public Boolean saveCustomer(Customer entity) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        Boolean test = s.test(sql, entity.getId(),entity.getName(),entity.getAddress());
        return test;
    }
    @Override
    public Boolean updateCustomer(Customer entity) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        Boolean test = s.test(sql, entity.getName(), entity.getAddress(), entity.getId());
        return test;

}
    @Override
    public Boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Customer WHERE id=?";
        Boolean test = s.test(sql, id);
        return test;
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT id FROM Customer WHERE id=?";
        ResultSet rst = s.test(sql, id);
       if (rst.next()){
           return true;
       }else{
           return false;
       }

    }


    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1;";
        ResultSet rst = s.test(sql);
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }

    }

    @Override
    public Customer search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public Customer searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer WHERE id=?";
        ResultSet rst = s.test(sql,newValue);
        rst.next();
        Customer customer = new Customer(newValue + "", rst.getString("name"), rst.getString("address"));
        return customer;

    }

}
