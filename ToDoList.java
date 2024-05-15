import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

//Kelas Task digunakan untuk merepresentasikan tugas (to-do) dalam program
class Task {        
    public int priority;
    public String task;

    public Task(int priority, String task) {
        this.priority = priority;
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}

//Membandingkan dua objek Task (t1 dan t2) berdasarkan prioritasnya
class TaskComparator implements Comparator<Task> {
    public int compare(Task t1, Task t2) {
        if (t1.priority > t2.priority) {         
            return 1;
        }
        else if (t1.priority < t2.priority) {       
            return -1;
        }       
        return 0;
    }
}

//Kelas ToDoList adalah class utama yang menjalankan program to-do list
public class ToDoList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        PriorityQueue<Task> todoList = new PriorityQueue<>(5, new TaskComparator());

        char ch;

        do {
            System.out.println("To-Do List");
            System.out.println("1. Simpan tugas \n2. Tampilkan tugas \n3. Tandai tugas selesai \n4. Hapus jadwal task");
            int choice = s.nextInt(); s.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama tugas:");
                    String tugas = s.nextLine();
                    System.out.print("Masukkan prioritas:");
                    int prioritas = s.nextInt();

                    todoList.add(new Task(prioritas, tugas));

                    System.out.println("Tugas " + tugas + " berhasil ditambahkan ke list");
                    break;
                case 2:
                    System.out.println("Tugas terdekat yang harus diselesaikan: " + todoList.peek().getTask());
                    break;
                case 3:
                    System.out.println(todoList.poll().getTask() + " selesai dilaksanakan, berikutnya " + todoList.peek().getTask());
                    break;
                case 4:
                    todoList.clear();
                    System.out.println("To-Do List berhasil dikosongkan");
                break;
            }

            System.out.println("Lanjut? (y/n)");

            ch = s.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

    }
}