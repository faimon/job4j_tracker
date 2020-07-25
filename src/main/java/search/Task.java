package search;

public class Task {
    private String desc;
    private int priority;
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getNumber() {
        return number;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
