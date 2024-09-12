package com.cms_dev.evaluacionu1;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static final List<String> pendingTasks = new ArrayList<>();
    private static final List<String> completedTasks = new ArrayList<>();

    public static void addTask(String task) {
        pendingTasks.add(task);
    }

    public static void completeTask(int index) {
        if (index >= 0 && index < pendingTasks.size()) {
            completedTasks.add(pendingTasks.remove(index));
        }
    }

    public static void removeCompleteTask(int index) {
        if (index >= 0 && index < completedTasks.size()) {
            completedTasks.remove(index);
        }
    }

    public static List<String> getPendingTasks() {
        return new ArrayList<>(pendingTasks);
    }

    public static List<String> getCompletedTasks() {
        return new ArrayList<>(completedTasks);
    }
}
