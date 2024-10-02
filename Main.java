import java.security.PublicKey;
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
    }

    public static void showTodoList() {
        System.out.println("TODO List");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + "." + todo);
            }
        }
    }

    public static void addTodoList(String todo) {
        resizeArrayIfFull();
        for (int i = 0; i < todos.length; i++) {
            if ((todos[i] == null)) {
                todos[i] = todo;
                break;
            }
        }
    }

    public static void resizeArrayIfFull() {
        // cek whether todos is full
        Boolean isFull = true;
        // isFull = isArrayFull(isFull);

        // if Full, resize current array to two times bigger
        if (isFull) {
            //resizeArrayToTwoTimesBigger();
        }
    }

    public static Boolean isArray() {
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                return false;
            }
        }
        return true;
    }

    public static void resizerArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < temp.length; i++) {
            todos[i] = temp[i];
        }
    }

    public static boolean removeTodoList(Integer number) {
        // TODO: add validation

        for (int i = number - 1; i < todos.length; i++) {
            if (i == (todos.length - 1)) {
                todos[i] = null;
            } else {
                // replace with the elemen on the right
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelectedTodoNotValid(Integer number) {
        // cek if the number is zero or less than zero
        if (number <= 0){
            return true;
        }

        // check if the number is greater then the todos size/length
        if (number - 1 > todos.length - 1){
            return true;
        }

        //check whether the elemen is already null
        if (todos[number - 1] == null) {
        }
        return false;
    }

    public static boolean editTodoList(Integer number, String newTodo){
        if (isSelectedTodoNotValid(number)){
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
}