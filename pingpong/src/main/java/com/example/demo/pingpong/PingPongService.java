package com.example.demo.pingpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PingPongService {
    int i = 0;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String doPong() {
        i = i + 1;
        String out = "Pong " + String.valueOf(i);
        // writeToFile("Ping / Pongs: " + String.valueOf(i));
        insertPingPong();
        return(out);
    }

    public String getPong() {
        String out = "Pong " + String.valueOf(i);
        return(out);
    }

    public void insertPingPong() {
        // create here for convenience
        String sql0 = "CREATE TABLE IF NOT EXISTS mypp (k TEXT PRIMARY KEY, v INT NOT NULL)";
        int res = jdbcTemplate.update(sql0);

        String sql = "INSERT INTO mypp VALUES ('current', " + i + ")" +
                "ON CONFLICT (k) DO UPDATE SET v = " + i;
        jdbcTemplate.update(sql);
    }

}
