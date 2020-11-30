package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in = SqlTracker
                .class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Ignore
    @Test
    public void whenAddItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }
    @Ignore
    @Test
    public void whenReplaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("desc"));
            tracker.replace(item.getId(), new Item("new desc"));
            assertThat(tracker.findByName("new desc").size(), is(1));
        }
    }
    @Ignore
    @Test
    public void whenDeleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("desc"));
            tracker.delete(item.getId());
            assertThat(tracker.findByName("desc").size(), is(0));
        }
    }
    @Ignore
    @Test
    public void whenFindById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("desc"));
            assertThat(tracker.findById(item.getId()), is(item));
        }
    }
}