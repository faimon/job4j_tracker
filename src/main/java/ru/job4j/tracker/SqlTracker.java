package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());
    private Connection cn;

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            String createTable = "CREATE TABLE IF NOT EXISTS "
                    + "items (id serial primary key, name varchar(100))";
            PreparedStatement st = cn.prepareStatement(createTable);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items(name) VALUES(?)")) {
            ps.setString(1, item.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement ps = cn.prepareStatement("UPDATE items SET name = ? WHERE id = ?")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            int count = ps.executeUpdate();
            rsl = count > 0;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id = ? ")) {
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            rsl = count > 0;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT id, name FROM items")) {
            ResultSet rs = ps.executeQuery();
            while (!rs.isLast()) {
                rs.next();
                rsl.add(new Item(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT id, name FROM items WHERE name = ?")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (!rs.isLast()) {
                rs.next();
                rsl.add(new Item(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try (PreparedStatement ps = cn.prepareStatement("SELECT name FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            rsl = new Item(id, rs.getString("name"));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }
}
