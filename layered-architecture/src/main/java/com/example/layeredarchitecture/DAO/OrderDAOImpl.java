package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAOImpl implements OrderDAO {
   //Transaction t = new Transaction();
   @Override
   public boolean order(String orderId) throws SQLException, ClassNotFoundException {
      Connection connection = DBConnection.getDbConnection().getConnection();
      PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
      stm.setString(1, orderId);

      if (stm.executeQuery().next()) {

      }

      connection.setAutoCommit(false);


      return true;
   }
   @Override
   public boolean order(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
     // Transaction t = new Transaction();
      Connection connection = DBConnection.getDbConnection().getConnection();
      PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
      stm.setString(1, orderId);
      stm.setDate(2, Date.valueOf(orderDate));
      stm.setString(3, customerId);

     return stm.executeUpdate()>0;
   }
   @Override
   public String generateNewOrederId() throws SQLException, ClassNotFoundException {
      Connection connection = DBConnection.getDbConnection().getConnection();
      Statement stm = connection.createStatement();
      ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

      return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

   }
   public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
      Connection connection = DBConnection.getDbConnection().getConnection();
      PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
      stm.setString(1, orderId);
      return stm.executeQuery().next();
   }
   @Override
   public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
      Connection connection = DBConnection.getDbConnection().getConnection();
      PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
      stm.setString(1, dto.getOrderId());
      stm.setDate(2, Date.valueOf(dto.getOrderDate()));
      stm.setString(3, dto.getCustomerId());
      return stm.executeUpdate()>0;
   }
}
