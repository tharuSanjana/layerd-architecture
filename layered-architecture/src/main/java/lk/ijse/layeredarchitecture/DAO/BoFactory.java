package lk.ijse.layeredarchitecture.DAO;

import lk.ijse.layeredarchitecture.bo.custom.Impl.CustomerBoImpl;
import lk.ijse.layeredarchitecture.bo.custom.Impl.ItemBoImpl;
import lk.ijse.layeredarchitecture.bo.custom.Impl.PlaceOrderBoImpl;

public class BoFactory  {
    private static BoFactory boFactory;
    private BoFactory(){

    }
    public static BoFactory boFactory(){
        return boFactory == null? boFactory = new BoFactory():boFactory;
    }
    public enum BOTypes{
        CUSTOMER,ITEM,PLACE_ORDER
    }
    public void getBo(){

    }
    public SuperBo getBoTypes(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();

            default:
                return null;
        }
    }
}
