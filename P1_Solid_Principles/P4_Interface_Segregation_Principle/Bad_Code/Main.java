package P1_Solid_Principles.P4_Interface_Segregation_Principle.Bad_Code;

import P1_Solid_Principles.P4_Interface_Segregation_Principle.Bad_Code.impl.DBDAOConnection;
import P1_Solid_Principles.P4_Interface_Segregation_Principle.Bad_Code.impl.FileDAOConnection;

public class Main {
    public static void main(String[] args) {
        IDAOConnection dbConnection = new DBDAOConnection();
        dbConnection.openConnection();
        dbConnection.createRecord();
        dbConnection.deleteRecord();
        dbConnection.closeConnection();

        /**
         * UnsupportedOperationException when below commented methods are called
         */
        // dbConnection.openFile();
        // dbConnection.closeFile();

        IDAOConnection fileConnection = new FileDAOConnection();
        fileConnection.openFile();
        fileConnection.closeFile();
        fileConnection.createRecord();
        fileConnection.deleteRecord();

        /**
         * UnsupportedOperationException when below commented methods are called
         */
        // fileConnection.openConnection();
        // fileConnection.closeConnection();
    }
}
