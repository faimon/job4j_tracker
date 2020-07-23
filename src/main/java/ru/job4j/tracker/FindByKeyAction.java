package ru.job4j.tracker;

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
        Item[] foundedItems = tracker.findByName(name);
        if (foundedItems.length > 0) {
            for (Item it : foundedItems) {
                out.println(it);
            }
        } else {
            out.println("Error: items were not found");
        }
        return true;
    }
}