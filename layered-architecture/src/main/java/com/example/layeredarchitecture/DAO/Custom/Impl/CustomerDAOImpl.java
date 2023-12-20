package com.example.layeredarchitecture.DAO.Custom.Impl;

import com.example.layeredarchitecture.DAO.Custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Customer";
        ResultSet rst = s.test(sql);
       ArrayList<CustomerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"),rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }
    @Override
    public Boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        Boolean test = s.test(sql, dto.getId(),dto.getName(),dto.getAddress());
        return test;
    }
    @Override
    public Boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        Boolean test = s.test(sql, dto.getName(), dto.getAddress(), dto.getId());
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
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
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
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer WHERE id=?";
        ResultSet rst = s.test(sql,newValue);
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
        return customerDTO;

    }

}
