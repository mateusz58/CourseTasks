package com.kodilla.jdbc;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbManagerTestSuite {

    DbManager dbManager;

    ScriptRunner sr;

    Statement statement;

    void prepareDataAndTables() throws SQLException, FileNotFoundException {
        statement.executeUpdate("DROP TABLE IF EXISTS USERS ");
        statement.executeUpdate("DROP TABLE IF EXISTS ISSUES_LISTS ");
        statement.executeUpdate("DROP TABLE IF EXISTS ISSUES ");

        Reader createTables = new BufferedReader(new FileReader("src/test/resources/data/CREATE_TABLE.sql"));
        Reader fillWithRandomData = new BufferedReader(new FileReader("src/test/resources/data/FILL.sql"));

        sr.runScript(createTables);
        sr.runScript(fillWithRandomData);
    }

    @BeforeEach
    void setUp() throws SQLException, IOException {
        dbManager = DbManager.getInstance();
        statement = dbManager.getConnection().createStatement();
        sr = new ScriptRunner(dbManager.getConnection());
        prepareDataAndTables();
    }

    @Test
    void checkIfconnectionSingletonProcessed() {
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testIfQueryForSelectingUserWithAtLeastTwoPosts() throws SQLException {
        //when
        ResultSet rs = statement.executeQuery("SELECT U.ID, U.FIRST_NAME, U.LAST_NAME FROM USERS U,ISSUES P WHERE U.id = P.user_id and (SELECT COUNT(*) FROM ISSUES V WHERE U.id = V.user_id )>=2;");
        int expected = 1;

        //then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRST_NAME") + ", " +
                    rs.getString("LAST_NAME"));
            counter++;
        }
        assertEquals(4, counter);
    }
}
