package database;

import models.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProgressDataRetriever {
    public static Progress getProgressById(int id){
        Progress progress = null;

        String query = "SELECT * FROM progress WHERE id = ?";

        try(
            Connection connection = DBConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                progress = new Progress(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("workouts_completed"),
                        resultSet.getInt("calories_burned"),
                        resultSet.getDate("last_updated")
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return progress;
    }
}
