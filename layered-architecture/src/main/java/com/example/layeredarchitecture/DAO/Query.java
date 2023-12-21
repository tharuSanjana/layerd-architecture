package com.example.layeredarchitecture.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Query {
    SqlUtil s = new SqlUtil();

    public boolean joinQuery() throws SQLException, ClassNotFoundException {
        String sql = "SELECT \n" +
                "    o.oid, \n" +
                "    o.date, \n" +
                "    o.customerID, \n" +
                "    c.name, \n" +
                "    c.address\n" +
                "FROM \n" +
                "    orders o\n" +
                "JOIN \n" +
                "    customer c ON o.customerID = c.id;";
        ResultSet rst = s.test(sql);
        while (rst.next()) {
            String oid = rst.getString("oid");
            LocalDate date = rst.getDate("date").toLocalDate();
            String cID = rst.getString("customerID");
            String name = rst.getString("name");
            String address = rst.getString("address");
            System.out.println("oid: " + oid + ", date: " + date + ", customerID: " + cID + ", name: " + name + ", address: " + address);

        }
        return true;
    }
}
