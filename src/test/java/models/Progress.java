package models;

import java.util.Date;

public class Progress {
    private int id;
    private int userId;
    private int workoutsCompleted;
    private int caloriesBurned;
    private Date lastUpdated;

    public Progress(int id, int userId, int workoutsCompleted, int caloriesBurned, Date lastUpdated) {
        this.id = id;
        this.userId = userId;
        this.workoutsCompleted = workoutsCompleted;
        this.caloriesBurned = caloriesBurned;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getWorkoutsCompleted() {
        return workoutsCompleted;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }
}
