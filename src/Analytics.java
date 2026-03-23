// Analytics module for performance tracking and study recommendations

import java.util.*;

class Analytics {

    static void showProgress(ArrayList<Task> tasks) {

        int completed = 0;

        for (Task t : tasks) {
            if (t.completed)
                completed++;
        }

        if (tasks.size() == 0) {
            System.out.println("No tasks available.");
            return;
        }

        double percent = (completed * 100.0) / tasks.size();

        System.out.println("Completion Rate: " + percent + "%");
    }

    static void detectWeakSubject(ArrayList<Task> tasks) {

        HashMap<String, Integer> pendingMap = new HashMap<>();

        for (Task t : tasks) {

            if (!t.completed) {

                pendingMap.put(t.subject,
                        pendingMap.getOrDefault(t.subject, 0) + 1);
            }
        }

        if (pendingMap.isEmpty()) {
            System.out.println("No weak subjects detected.");
            return;
        }

        String weak = null;
        int max = 0;

        for (String sub : pendingMap.keySet()) {

            if (pendingMap.get(sub) > max) {

                max = pendingMap.get(sub);
                weak = sub;
            }
        }

        System.out.println("Weak Subject Detected: " + weak);
    }

    static void suggestNextStudy(ArrayList<Task> tasks) {

    HashMap<String, Integer> pendingMap = new HashMap<>();

    for (Task t : tasks) {

        if (!t.completed) {

            pendingMap.put(t.subject,
                    pendingMap.getOrDefault(t.subject, 0) + 1);
        }
    }

    if (pendingMap.isEmpty()) {

        System.out.println("All tasks completed. Great work!");
        return;
    }

    String focusSubject = null;
    int max = 0;

    for (String sub : pendingMap.keySet()) {

        if (pendingMap.get(sub) > max) {

            max = pendingMap.get(sub);
            focusSubject = sub;
        }
    }

    System.out.println("Recommendation: Focus on " + focusSubject + " next.");
}
}
