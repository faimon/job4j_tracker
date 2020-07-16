package ru.job4j.tracker;

public class FindByKeyAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        Item[] foundedItems = tracker.findByName(name);
        if (foundedItems.length > 0) {
            for (Item it : foundedItems) {
                System.out.println(it);
            }
        } else {
            System.out.println("Error: items were not found");
        }
        return true;
    }
}
