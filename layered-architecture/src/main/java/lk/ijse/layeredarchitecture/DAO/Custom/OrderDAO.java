package lk.ijse.layeredarchitecture.DAO.Custom;

import lk.ijse.layeredarchitecture.DAO.CrudDAO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDAO> {
      String generateNewOrederId() throws SQLException, ClassNotFoundException;
      boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
      boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
}