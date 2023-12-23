package lk.ijse.layeredarchitecture.DAO;

import lk.ijse.layeredarchitecture.DAO.Custom.Impl.CustomerDAOImpl;
import lk.ijse.layeredarchitecture.DAO.Custom.Impl.ItemDAOImpl;
import lk.ijse.layeredarchitecture.DAO.Custom.Impl.OrderDAOImpl;
import lk.ijse.layeredarchitecture.DAO.Custom.Impl.OrderDetailDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){

        return daoFactory == null? daoFactory = new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }
    public CrudDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            default:
                return null;
        }


    }
}
