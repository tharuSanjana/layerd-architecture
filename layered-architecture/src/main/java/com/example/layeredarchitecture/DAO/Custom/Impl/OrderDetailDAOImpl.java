package com.example.layeredarchitecture.DAO.Custom.Impl;

import com.example.layeredarchitecture.DAO.Custom.OrderDetailDAO;
import com.example.layeredarchitecture.DAO.SqlUtil;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
//import sun.security.ec.XECParameters;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
        SqlUtil s = new SqlUtil();
   @Override
   public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

       String sql = "INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)";
       Boolean test = s.test(sql, dto.getOid(),dto.getItemCode(), dto.getUnitPrice(),dto.getQty());
       return test;
   }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
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
        return null;
    }

    @Override
    public OrderDetailDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
}

