package database;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDataRetriever {

    public static User getUserById(int userId){
        User user = null;

        String query = "SELECT id, name, email FROM users WHERE id = " + userId;

        try(
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
                ){
                if(resultSet.next()){
                user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUserByEmail(String email){
        User user = null;

        String query = "SELECT id, name, email FROM users WHERE email = ?";

        try(
                Connection connection = DBConnectionManager.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
                ){
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user= new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
        }   catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
