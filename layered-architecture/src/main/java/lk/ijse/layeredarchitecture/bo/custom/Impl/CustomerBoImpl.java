package lk.ijse.layeredarchitecture.bo.custom.Impl;

import lk.ijse.layeredarchitecture.DAO.Custom.CustomerDAO;
import lk.ijse.layeredarchitecture.DAO.DAOFactory;
import lk.ijse.layeredarchitecture.bo.custom.CustomerBo;
import lk.ijse.layeredarchitecture.entity.Customer;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
        public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        ArrayList<Customer> customers = customerDAO.getAllCustomer();
        for (Customer customer: customers){
            customerDTOS.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        }
            return customerDTOS;
        }

        @Override
        public Boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
            return customerDAO.saveCustomer(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
        }

        @Override
        public Boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
            return customerDAO.updateCustomer(new Customer( dto.getName(), dto.getAddress(),dto.getId()));
        }

        @Override
        public Boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
            return customerDAO.deleteCustomer(id);
        }

        @Override
        public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
            return customerDAO.existCustomer(id);
        }

        @Override
        public String generateNewId() throws SQLException, ClassNotFoundException {
            return customerDAO.generateNewId();
        }

    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
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
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


}
