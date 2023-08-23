package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.domain.PassportOffice;
import edu.java.StudentsAccounting.domain.RegisterOffice;
import org.junit.Test;
import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.exception.DaoException;
import org.junit.*;

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

public class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() throws URISyntaxException, IOException {
        URL url1 = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_project.sql");
        URL url2 = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_data.sql");


        List<String> str1 = Files.readAllLines(Paths.get(url1.toURI()));
        String sql1 = str1.stream().collect(Collectors.joining());

        List<String> str2 = Files.readAllLines(Paths.get(url2.toURI()));
        String sql2 = str2.stream().collect(Collectors.joining());

        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement();) {

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStreet() throws DaoException {
        List<Street> d = new DictionaryDaoImpl().findStreets("pro");
        Assert.assertTrue(d.size() == 2);
    }

    @Test
    public void testPassport() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> po = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        Assert.assertTrue(po.size() == 2);
    }


}