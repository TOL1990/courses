package home12.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Leonid on 27.03.2016.
 */
public class DAOUtils {
    public static void close (Connection myCon, Statement mySt, ResultSet myRs) throws SQLException
    {
        if(myRs !=null )myRs.close();
        if(mySt != null) mySt.close();
        if(myCon != null) myCon.close();
    }
    public static void close(Statement mySt,ResultSet myRs)throws SQLException
    {
        close(null, mySt, myRs);
    }
    public static void close(Statement mySt)throws SQLException
    {
        close(null, mySt, null);
    }

}
