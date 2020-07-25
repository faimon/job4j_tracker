package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByKeyAction implements UserAction {
    private final Output out;

    public FindByKeyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        ArrayList<Item> foundedItems = tracker.findByName(name);
        if (foundedItems.size() > 0) {
            for (Item it : foundedItems) {
                out.println(it);
            }
        } else {
            out.println("Error: items were not found");
        }
        return true;
    }
}
