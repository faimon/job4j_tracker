package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "Ivan");
        hbmTracker.add(item);
        assertThat(hbmTracker.findAll().size(), is(1));
    }

    @Test
    public void whenDeleteItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "Ivan");
        hbmTracker.add(item);
        hbmTracker.delete(item.getId());
        assertThat(hbmTracker.findAll().size(), is(0));
    }

    @Test
    public void whenReplaceItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "Ivan");
        Item item2 = new Item(1, "Vasya");
        hbmTracker.add(item);
        hbmTracker.replace(item.getId(), item2);
        assertThat(hbmTracker.findAll().get(0).getName(), is("Vasya"));
    }

    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "Ivan");
        hbmTracker.add(item);
        assertThat(hbmTracker.findByName("Ivan").get(0), is(item));
    }

    @Test
    public void whenFindById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item(1, "Ivan");
        hbmTracker.add(item);
        assertThat(hbmTracker.findById(item.getId()), is(item));
    }
}