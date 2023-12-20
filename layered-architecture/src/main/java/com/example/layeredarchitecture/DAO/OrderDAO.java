package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
     boolean order(String orderId) throws SQLException, ClassNotFoundException;

     boolean order(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
     String generateNewOrederId() throws SQLException, ClassNotFoundException;
      boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
      boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}