package P1_Solid_Principles.P4_Interface_Segregation_Principle.Bad_Code.impl;

import P1_Solid_Principles.P4_Interface_Segregation_Principle.Bad_Code.IDAOConnection;

public class DBDAOConnection implements IDAOConnection {

    @Override
    public void openConnection() {
        System.out.println("DB connection established!");
    }

    @Override
    public void closeConnection() {
        System.out.println("DB connection terminated!");
    }

    @Override
    public void openFile() {
        throw new UnsupportedOperationException("Unimplemented method 'openFile'");
    }

    @Override
    public void closeFile() {
        throw new UnsupportedOperationException("Unimplemented method 'closeFile'");
    }

    @Override
    public void createRecord() {
        System.out.println("Record created");
    }

    @Override
    public void deleteRecord() {
        System.out.println("Record deleted");
    }

}
