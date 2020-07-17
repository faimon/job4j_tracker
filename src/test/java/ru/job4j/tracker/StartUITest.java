package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StartUITest {

  /*  @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[] {"0", "Vasyan", "1"});
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Vasyan"));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Ivan");
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", "1", "Igor", "1"});
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Igor"));
    }

    @Test
    public void whenDeleteItem() {
        Item item = new Item("Ivan");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions =  {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    } */
}