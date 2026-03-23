import java.util.*;

class PlannerManager {

    ArrayList<Task> tasks = new ArrayList<>();

    PlannerManager() {
        tasks = FileManager.loadTasks();
    }

    void addTask(Scanner sc) {

        System.out.print("Enter Task Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        System.out.print("Enter Deadline: ");
        String deadline = sc.nextLine();

        System.out.print("Enter Priority (High/Medium/Low): ");
        String priority = sc.nextLine();

        tasks.add(new Task(title, subject, deadline, priority, false));

        FileManager.saveTasks(tasks);

        System.out.println("Task Added Successfully!");
    }

    void showPendingTasks() {

        boolean found = false;

        for (Task t : tasks) {
            if (!t.completed) {
                t.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("No pending tasks.");
    }

    void showCompletedTasks() {

        boolean found = false;

        for (Task t : tasks) {
            if (t.completed) {
                t.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("No completed tasks.");
    }

    void markTaskComplete(Scanner sc) {

        showPendingTasks();

        System.out.print("Enter task title to mark complete: ");

        String name = sc.nextLine();

        for (Task t : tasks) {

            if (t.title.equalsIgnoreCase(name)) {

                t.markComplete();

                FileManager.saveTasks(tasks);

                System.out.println("Task marked completed!");

                return;
            }
        }

        System.out.println("Task not found.");
    }

    void showAnalytics() {

        Analytics.showProgress(tasks);

        Analytics.detectWeakSubject(tasks);
        Analytics.suggestNextStudy(tasks);
    }
}