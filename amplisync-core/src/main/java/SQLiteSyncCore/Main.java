package SQLiteSyncCore;

import SQLiteSyncCore.SyncServer.CommonTools;
import SQLiteSyncCore.SyncServer.SchemaPublish.SchemaGenerator;

public class Main {

    public static void main(String[] args) {
        System.out.println(test());
        addSubscriber("testSubscriber");
    }

    private static String test() {
        CommonTools tools = new CommonTools();
        final Boolean isConnectionOK = tools.CheckIfDBConnectionIsOK();

        String connectionStatus = "Database connected!";
        if (!isConnectionOK)
            connectionStatus = "Error creating database connection.";

        return "API[" + tools.GetVersionOfSQLiteSyncCOM() + "] SQLite-Sync.COM is working correctly! " + connectionStatus;
    }

    private static void addSubscriber(String subscriberId) {
        final SchemaGenerator schemaGenerator = new SchemaGenerator();
        schemaGenerator.GetFullSchematScript(subscriberId);
    }
}
