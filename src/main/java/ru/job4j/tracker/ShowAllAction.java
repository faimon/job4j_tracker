package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item it: tracker.findAll()) {
            System.out.println("Id: " + it.getId() + ", name: " + it.getName());
        }
        return true;
    }
}
