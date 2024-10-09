import java.util.Scanner;

public class Main {
    public static String[] todos = new String[3];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("BEFORE DELETE");
        addTodoList("Mewarnai");
        addTodoList("Membaca");
        addTodoList("Bersepeda");
        addTodoList("Berkhotbah");
        showTodoList();
        removeTodoList(3);
        System.out.println("AFTER DELETE");
        showTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODO List:");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static boolean addTodoList(String todo) {
        resizeArrayIfFull();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                return true;
            }
        }
        return false;
    }

    public static void resizeArrayIfFull() {
        if (isArrayFull()) {
            resizeArrayToTwoTimesBigger();
        }
    }

    public static boolean isArrayFull() {
        for (String todo : todos) {
            if (todo == null) {
                return false;
            }
        }
        return true;
    }

    public static void resizeArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        System.arraycopy(temp, 0, todos, 0, temp.length);
    }

    public static boolean removeTodoList(int number) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        for (int i = number - 1; i < todos.length - 1; i++) {
            todos[i] = todos[i + 1];
        }
        todos[todos.length - 1] = null;
        return true;
    }

    private static boolean isSelectedTodoNotValid(int number) {
        return number <= 0 || number > todos.length || todos[number - 1] == null;
    }

    public static boolean editTodoList(int number, String newTodo) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }

    public static String input(String info) {
        System.out.print(info + ": ");
        return scanner.nextLine();
    }

    public static void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showTodoList();
            System.out.println("Menu:");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            String selectMenu = input("Pilih");
            switch (selectMenu) {
                case "1":
                    showMenuAddTodoList();
                    break;
                case "2":
                    showMenuRemoveTodoList();
                    break;
                case "3":
                    showMenuEditTodoList();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void showMenuRemoveTodoList() {
        System.out.println("Menghapus Todo List");
        String number = input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")) {
            return;
        } else {
            boolean success = removeTodoList(Integer.parseInt(number));
            if (!success) {
                System.out.println("Gagal menghapus todo list nomor: " + number);
            }
        }
    }

    public static void showMenuAddTodoList() {
        System.out.println("Menambah Todo List");
        String todo = input("Masukkan todo baru (x jika batal)");
        if (todo.equals("x")) {
            return;
        } else {
            addTodoList(todo);
        }
    }

    public static void showMenuEditTodoList() {
        System.out.println("Mengedit Todo List");
        String selectedTodo = input("Nomor todo yang akan diubah (x jika batal)");
        if (selectedTodo.equals("x")) {
            return;
        }
        String newTodo = input("Masukkan todo baru (x jika batal)");
        if (newTodo.equals("x")) {
            return;
        }
        boolean success = editTodoList(Integer.parseInt(selectedTodo), newTodo);
        if (success) {
            System.out.println("Berhasil mengedit todo.");
        } else {
            System.out.println("Gagal mengedit todo.");
        }
    }
}
