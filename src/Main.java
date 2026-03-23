// Menu-driven Smart Study Planner interface

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlannerManager manager = new PlannerManager();

        int choice;

        do {

            System.out.println("\nSMART STUDY PLANNER");
            System.out.println("1 Add Task");
            System.out.println("2 View Pending Tasks");
            System.out.println("3 View Completed Tasks");
            System.out.println("4 Mark Task Complete");
            System.out.println("5 Show Performance Report");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    manager.addTask(sc);
                    break;

                case 2:
                    manager.showPendingTasks();
                    break;

                case 3:
                    manager.showCompletedTasks();
                    break;

                case 4:
                    manager.markTaskComplete(sc);
                    break;

                case 5:
                    manager.showAnalytics();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
