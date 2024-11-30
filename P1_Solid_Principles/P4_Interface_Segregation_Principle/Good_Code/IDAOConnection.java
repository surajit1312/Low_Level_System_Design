package P1_Solid_Principles.P4_Interface_Segregation_Principle.Good_Code;

public interface IDAOConnection {
    public void openConnection();

    public void closeConnection();

    public void openFile();

    public void closeFile();

    public void createRecord();

    public void deleteRecord();
}
