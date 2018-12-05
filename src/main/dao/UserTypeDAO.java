package main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.model.UserType;

public class UserTypeDAO {
	private final String QUERY_ALL = "select * from usertype";
    
	public List<UserType> getAllUserType () {
        List<UserType> us_type = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer id_ut = resultSet.getInt("idUserType");
               String typeus = resultSet.getString("typeUser");
               
               us_type.add(new UserType(id_ut, typeus));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return us_type;
    }

}
