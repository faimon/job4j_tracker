package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item item = new Item();
        item = tracker.findById(id);
        if (item != null) {
            System.out.println("Found item: " + item);
        } else {
            System.out.println("Error: item was not found");
        }
        return true;
    }
}
