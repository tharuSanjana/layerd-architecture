package com.example.layeredarchitecture.DAO.Custom.Impl;

import com.example.layeredarchitecture.DAO.Custom.ItemDAO;
import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Item";
        ResultSet rst = s.test(sql);
        ArrayList<ItemDTO> getAllItem = new ArrayList<>();
        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(rst.getString("code"),rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
            getAllItem.add(itemDTO);
        }
        return getAllItem;
    }
    @Override
    public Boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        Boolean test = s.test(sql,itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
        return test;
    }
    @Override
    public Boolean deleteItem(String code) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Item WHERE code=?";
        Boolean test = s.test(sql,code);
        return test;
    }


    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        Boolean test = s.test(sql, itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand(), itemDTO.getCode());
        return test;
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
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {

        String sql = "SELECT code FROM Item WHERE code=?";
        ResultSet rst = s.test(sql, code);
        if (rst.next()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
       String sql = "SELECT code FROM Item ORDER BY code DESC LIMIT 1;";
        ResultSet rst = s.test(sql);
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Item WHERE code=?";
        ResultSet rst= s.test(sql, newItemCode);
        rst.next();
        ItemDTO item = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }
}
