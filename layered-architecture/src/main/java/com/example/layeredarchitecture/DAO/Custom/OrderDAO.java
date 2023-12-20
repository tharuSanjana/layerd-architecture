package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDAO> {
      String generateNewOrederId() throws SQLException, ClassNotFoundException;
      boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
      boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}