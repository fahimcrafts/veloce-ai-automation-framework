package debug;

import utils.DBConnectionManager;

public class JDBCConnectionSmokeTest {
    public static void main(String[] args){
        DBConnectionManager.getConnection();
    }
}
