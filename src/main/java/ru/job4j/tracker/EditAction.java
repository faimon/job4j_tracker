package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter Id Item:");
        String name = input.askStr("=== Enter name Item:");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            out.println("Editing was completed successfully");
        } else {
            out.println("Error: editing error");
        }
        return true;
    }
}
