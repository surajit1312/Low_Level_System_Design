package P1_Solid_Principles.P4_Interface_Segregation_Principle.Good_Code.impl;

import P1_Solid_Principles.P4_Interface_Segregation_Principle.Good_Code.IDAOConnection;

public class FileDAOConnection implements IDAOConnection {

    @Override
    public void openConnection() {
        throw new UnsupportedOperationException("Unimplemented method 'openConnection'");
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Unimplemented method 'closeConnection'");
    }

    @Override
    public void openFile() {
        System.out.println("File opened!");
    }

    @Override
    public void closeFile() {
        System.out.println("File closed!");
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
