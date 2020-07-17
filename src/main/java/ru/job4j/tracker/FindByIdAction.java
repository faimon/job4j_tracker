package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item item = new Item();
        item = tracker.findById(id);
        if (item != null) {
            out.println("Found item: " + item);
        } else {
            out.println("Error: item was not found");
        }
        return true;
    }
}
