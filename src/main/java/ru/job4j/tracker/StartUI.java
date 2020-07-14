package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                for (Item it: tracker.findAll()) {
                    System.out.println("Id: " + it.getId() + ", name: " + it.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter Id Item:");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.replace(id, new Item())) {
                    System.out.println("Editing was completed successfully");
                }
                else {
                    System.out.println("Error: editing error");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter Id item:");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Deleting was completed successfully");
                }
                else {
                    System.out.println("Error: Deleting error");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id");
                System.out.println("Enter id:");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    System.out.println("Found item: " + tracker.findById(id));
                }
                else {
                    System.out.println("Error: item was not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                Item[] founded = tracker.findByName(name);
                        for (Item it: founded) {
                            System.out.println(it);
                        }
            }
            else if (select == 6) {
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
