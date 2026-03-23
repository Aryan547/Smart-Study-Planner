class Subject {
    String name;
    int totalTasks;
    int completedTasks;

    Subject(String name) {
        this.name = name;
        totalTasks = 0;
        completedTasks = 0;
    }

    void addTask() {
        totalTasks++;
    }

    void completeTask() {
        completedTasks++;
    }

    double getCompletionRate() {
        if (totalTasks == 0) return 0;
        return (completedTasks * 100.0) / totalTasks;
    }
}