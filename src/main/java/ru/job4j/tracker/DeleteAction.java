package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id item:");
        if (tracker.delete(id)) {
            System.out.println("Deleting was completed successfully");
        } else {
            System.out.println("Error: Deleting error");
        }
        return true;
    }
}
