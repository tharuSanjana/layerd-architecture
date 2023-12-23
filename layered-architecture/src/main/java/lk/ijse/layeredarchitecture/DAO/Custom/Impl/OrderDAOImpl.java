package lk.ijse.layeredarchitecture.DAO.Custom.Impl;

import lk.ijse.layeredarchitecture.DAO.Custom.OrderDAO;
import lk.ijse.layeredarchitecture.DAO.QueryDAO;
import lk.ijse.layeredarchitecture.DAO.SqlUtil;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
   //Transaction t = new Transaction();
   SqlUtil s = new SqlUtil();
   QueryDAO q = new QueryDAO();

   @Override
   public String generateNewOrederId() throws SQLException, ClassNotFoundException {
     String sql = "SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;";
      ResultSet rst = s.test(sql);
      return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";

   }
   public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {

      String sql = "SELECT oid FROM `Orders` WHERE oid=?";
      ResultSet rst = s.test(sql,orderId);
      if (rst.next()){
         return  true;
      }else{
         return false;
      }
   }
   @Override
   public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
       q.joinQuery();

      String sql = "INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)";
      Boolean test = s.test(sql,dto.getOrderId(),Date.valueOf(dto.getOrderDate()),dto.getCustomerId());
      return test;




   }


   @Override
   public ArrayList<OrderDAO> getAll() throws SQLException, ClassNotFoundException {
      return null;
   }

   @Override
   public boolean save(OrderDAO dto) throws SQLException, ClassNotFoundException {
      return false;
   }

   @Override
   public boolean update(OrderDAO dto) throws SQLException, ClassNotFoundException {
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
   public OrderDAO search(String newValue) throws SQLException, ClassNotFoundException {
      return null;
   }
}
