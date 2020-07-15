package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        for (Item it: tracker.findAll()) {
            System.out.println("Id: " + it.getId() + ", name: " + it.getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter Id Item:");
        String name = input.askStr("=== Enter name Item:");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)) {
            System.out.println("Editing was completed successfully");
        } else {
            System.out.println("Error: editing error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter Id item:");
        if (tracker.delete(id)) {
            System.out.println("Deleting was completed successfully");
        } else {
            System.out.println("Error: Deleting error");
        }
    }

    public static void findItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id");
        int id = input.askInt("Enter id:");
        Item item = new Item();
        item = tracker.findById(id);
        if (item != null) {
            System.out.println("Found item: " + item);
        } else {
            System.out.println("Error: item was not found");
        }
    }

    public static void findItemByKey(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name:");
        Item[] foundedItems = tracker.findByName(name);
        if (foundedItems.length > 0) {
            for (Item it : foundedItems) {
                System.out.println(it);
            }
        } else {
            System.out.println("Error: items were not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu();
            select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItem(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByKey(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}