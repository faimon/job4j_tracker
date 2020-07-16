package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id Item:");
        String name = input.askStr("=== Enter name Item:");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            System.out.println("Editing was completed successfully");
        } else {
            System.out.println("Error: editing error");
        }
        return true;
    }
}
