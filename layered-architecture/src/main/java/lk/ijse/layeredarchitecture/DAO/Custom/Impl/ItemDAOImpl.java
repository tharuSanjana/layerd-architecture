package lk.ijse.layeredarchitecture.DAO.Custom.Impl;

import lk.ijse.layeredarchitecture.DAO.Custom.ItemDAO;
import lk.ijse.layeredarchitecture.DAO.SqlUtil;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.entity.Customer;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    SqlUtil s = new SqlUtil();
    @Override
    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Item";
        ResultSet rst = s.test(sql);
        ArrayList<Item> getAllItem = new ArrayList<>();
        while (rst.next()){
            Item item = new Item(rst.getString("code"),rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
            getAllItem.add(item);
        }
        return getAllItem;
    }



    @Override
    public Boolean saveItem(Item entity) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        Boolean test = s.test(sql,entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
        return test;
    }
    @Override
    public Boolean deleteItem(String code) throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM Item WHERE code=?";
        Boolean test = s.test(sql,code);
        return test;
    }


    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Item dto) throws SQLException, ClassNotFoundException {
        return false;
    }


    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        Boolean test = s.test(sql, entity.getDescription(), entity.getUnitPrice(), entity.getQtyOnHand(), entity.getCode());
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
    public Item search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public Item searchItem(String newItemCode) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Item WHERE code=?";
        ResultSet rst= s.test(sql, newItemCode);
        rst.next();
        Item item = new Item(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }
}
