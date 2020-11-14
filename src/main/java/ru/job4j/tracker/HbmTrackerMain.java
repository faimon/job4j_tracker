package ru.job4j.tracker;

public class HbmTrackerMain {
    public static void main(String[] args) {
        HbmTracker hbmTracker = new HbmTracker();
        System.out.println(hbmTracker.findByName("Ivan").size());
        System.out.println(hbmTracker.findById(5).getName());
    }
}
