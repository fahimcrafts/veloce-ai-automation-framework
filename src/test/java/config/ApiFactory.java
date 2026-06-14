package config;

import api.UserApi;
import api.WorkoutApi;

public class ApiFactory {
    private final String baseUrl;

    public ApiFactory(String baseUrl){
        this.baseUrl=baseUrl;
    }

    public UserApi userApi(){
        return new UserApi(baseUrl);
    }

    public WorkoutApi workoutApi(){
        return new WorkoutApi(baseUrl);
    }
}
