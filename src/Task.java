class Task {
    String title;
    String subject;
    String deadline;
    String priority;
    boolean completed;

    Task(String title, String subject, String deadline, String priority, boolean completed) {
        this.title = title;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = completed;
    }

    void markComplete() {
        completed = true;
    }

    String toFileString() {
        return title + "," + subject + "," + deadline + "," + priority + "," + completed;
    }

    static Task fromFileString(String line) {
        String[] parts = line.split(",");
        return new Task(parts[0], parts[1], parts[2], parts[3],
                Boolean.parseBoolean(parts[4]));
    }

    void display() {
        System.out.println("Task: " + title +
                " | Subject: " + subject +
                " | Deadline: " + deadline +
                " | Priority: " + priority +
                " | Status: " + (completed ? "Done" : "Pending"));
    }
}