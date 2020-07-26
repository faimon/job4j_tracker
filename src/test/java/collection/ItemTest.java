package collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSortIncrease() {
        Item item = new Item("d");
        Item item2 = new Item("c");
        Item item3 = new Item("b");
        Item item4 = new Item("a");
        List<Item> list = new ArrayList<>();
        list.add(item);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        Collections.sort(list, new SortByItem());
        List<Item> exceptedList = new ArrayList<>();
        Item exceptedItem = new Item("a");
        Item exceptedItem2 = new Item("b");
        Item exceptedItem3 = new Item("c");
        Item exceptedItem4 = new Item("d");
        exceptedList.add(exceptedItem);
        exceptedList.add(exceptedItem2);
        exceptedList.add(exceptedItem3);
        exceptedList.add(exceptedItem4);
        assertEquals(exceptedList, list);
    }

    @Test
    public void whenSortDecrease() {
        Item item = new Item("a");
        Item item2 = new Item("b");
        Item item3 = new Item("c");
        Item item4 = new Item("d");
        List<Item> list = new ArrayList<>();
        list.add(item);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        Collections.sort(list, new ReverseSortbyItem());
        List<Item> exceptedList = new ArrayList<>();
        Item exceptedItem = new Item("d");
        Item exceptedItem2 = new Item("c");
        Item exceptedItem3 = new Item("b");
        Item exceptedItem4 = new Item("a");
        exceptedList.add(exceptedItem);
        exceptedList.add(exceptedItem2);
        exceptedList.add(exceptedItem3);
        exceptedList.add(exceptedItem4);
        assertEquals(exceptedList, list);
    }

}
