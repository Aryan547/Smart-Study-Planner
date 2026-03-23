import java.io.*;
import java.util.*;

class FileManager {

    static final String FILE_PATH = "data/planner.txt";

    static void saveTasks(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Task t : tasks) {
                writer.write(t.toFileString());
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    static ArrayList<Task> loadTasks() {

        ArrayList<Task> tasks = new ArrayList<>();

        try {
            File file = new File(FILE_PATH);

            if (!file.exists())
                return tasks;

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromFileString(line));
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }

        return tasks;
    }
}