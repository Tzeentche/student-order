package edu.java.StudentsAccounting.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() throws URISyntaxException, IOException {
        URL url = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_project.sql");

        List<String> str = Files.readAllLines(Paths.get(url.toURI()));
        String sql = str.stream().collect(Collectors.joining());

        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement();) {

            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Before
    public static void startTest() {
        System.out.println("START TEST!");
    }

    @Test
    public void testExample1() {
        System.out.println("TEST 1");
    }

    @Test
    @Ignore
    public void testExample2() {
        System.out.println("TEST 2");
    }

//    @Test
    public void testExample3() {
        System.out.println("TEST 3");
    }


}