package com.sql_injection.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
public class ClientController {

    String url = "jdbc:postgresql://localhost:5432/sql_injection";
    String uname = "postgres";
    String pwd = "root";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/client")
    public Client createUser(@RequestBody Client user) {
        String sql = "INSERT INTO client (name, password) VALUES (?, ?) RETURNING id";
        Long id = jdbcTemplate.queryForObject(sql, new Object[]{user.getName(), user.getPassword()}, Long.class);
        user.setId(id);
        return user;
    }

    @GetMapping("/client")
    public String getUserById(@RequestParam String id) throws SQLException {
        Connection con = DriverManager.getConnection(url, uname, pwd);
        Statement st = con.createStatement();
        String query = "select name from client where id='" + id + "'";

        ResultSet rs = st.executeQuery(query);
        StringBuilder result = new StringBuilder();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                result.append((rs.getString(i) + " ")+"\n");
            }

        }


        con.close();
        return result.toString();
    }
}