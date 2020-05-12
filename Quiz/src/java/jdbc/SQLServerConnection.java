/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Nghiatq
 */
public class SQLServerConnection {

    /**
     * Get connection to MSSQL Server
     * @return Connection
     */

    private static InitialContext initial;
    private  static Context context;
    private static String dbname, serverName, portNumber, image, username, password;

    static {
        try {
            
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbname = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            image = context.lookup("image").toString();
            username = context.lookup("username").toString();
            password = context.lookup("password").toString();
            
        } catch (Exception e) {
            System.out.println("fail");
        }
    }
    
    public SQLServerConnection() {
    }
    

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }


    public String getImagePath() throws Exception {
        return image;
    }


}
