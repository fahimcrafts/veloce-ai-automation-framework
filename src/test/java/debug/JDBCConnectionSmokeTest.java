package debug;

import database.DBConnectionManager;

public class JDBCConnectionSmokeTest {
    public static void main(String[] args){
        DBConnectionManager.getConnection();
    }
}
