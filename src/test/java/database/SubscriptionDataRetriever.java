package database;

import models.Subscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubscriptionDataRetriever {
    public static Subscription getSubscriptionByUserId(int userId){
        Subscription subscription = null;

        String query = "SELECT id, user_id, type, price, active FROM subscriptions WHERE user_id = ?";

        try(
            Connection connection = DBConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                subscription = new Subscription(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("type"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("active")
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return subscription;
    }
}
