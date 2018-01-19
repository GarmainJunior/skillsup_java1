package ua.dp.skillsup.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JdbcTest {

    private Connection conn;

    @Before
    public void setUp() throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void testUser() throws Exception {
        Statement statement = conn.createStatement();
        statement.execute("" +
                "CREATE TABLE USER\n" +
                "(\n" +
                "    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "    USERNAME VARCHAR(64) NOT NULL UNIQUE,\n" +
                "    PASSWORD VARCHAR(60) NOT NULL,\n" +
                "    EMAIL VARCHAR(64) NOT NULL,\n" +
                ");");
        statement.close();

        statement = conn.createStatement();
        statement.execute("INSERT INTO user(USERNAME, PASSWORD, EMAIL) VALUES\n" +
                "  ('admin','$2a$08$DobXCJtm7dQwfNz3J0ZILevNNXVslyrY2j0J2dKOBG56uPpBooVoy',\n" +
                "   'helen.moore@gmail.com');");
        statement.execute("INSERT INTO user (USERNAME, PASSWORD, EMAIL) VALUES\n" +
        "('piter', 'root', 'xbox')");

        statement.close();

        ResultSet resultSet = conn.prepareStatement("select * from user").executeQuery();
        meth(resultSet);
        Statement executeStatement = conn.createStatement();

//executeStatement
//        ("CREATE TABLE POST\n" +
//                        "(\n" +
//                        "ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
//                "AVTHOR VARCHAR (60)NOT NULL UNIQUE,\n" +
//                "TITLE VARCHAR (60) NOT NULL, \n " +
//                "CONTENT VARCHAR(max) NOT NULL, \n" +
//                ");");
//



    }

    private void meth(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(2)  + " | " + resultSet.getString(3));
            }

    }
}
