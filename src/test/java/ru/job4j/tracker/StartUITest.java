package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[] {"0", "Vasyan", "1"});
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Vasyan"));
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Ivan");
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", "1", "Igor", "1"});
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Igor"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Item item = new Item("Ivan");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input in = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions =  {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Item firstItem = new Item("Ivan");
        Item secondItem = new Item(("Vas"));
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1"});
        UserAction[] actions =  {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + firstItem.toString() + System.lineSeparator()
                + secondItem.toString() + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Show all items" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByKey() {
        Item item = new Item("Ivan");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Ivan", "1"});
        UserAction[] actions =  {
                new FindByKeyAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Item item = new Item("Ivan");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1", "1"});
        UserAction[] actions =  {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "Found item: " + item.toString() + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Find item by Id" + System.lineSeparator() + "1. Exit" + System.lineSeparator()
        ));
    }
}