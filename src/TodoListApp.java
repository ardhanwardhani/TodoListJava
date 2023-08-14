import java.util.Scanner;

public class TodoListApp {

    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("Todo List");
        for(var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". "+ todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus : Aplikasi Todo List";
        model[2] = "Belajar OOP di Java";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo) {
        var isFull = true;
        // cek apakah model penuh?
        for (var i = 0; i < model.length; i++){
            if(model[i] == null){
                //  model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        // menambah ke posisi yang data arraynya null
        for(var i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for(int i = 0; i < 25; i++){
            addTodoList("Todo ke-"+ i);
        }

        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean deleteTodoList(Integer number){
        if((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null) {
            return false;
        }else{
            for(int i = (number - 1); i < model.length; i++){
                if(i == (model.length) - 1){
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testDeleteTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = deleteTodoList(20);
        System.out.println(result);

        result = deleteTodoList(7);
        System.out.println(result);

        result = deleteTodoList(2);
        System.out.println(result);

        showTodoList();

    }

    public static String input(String info){
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * Menamiplkan view todo list
     */
    public static  void viewShowTodoList(){
        while(true){
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")) {
                viewDeleteTodoList();
            }else if(input.equalsIgnoreCase("x")){
                break;
            }else{
                System.out.println("Pilihan Tidak Valid!");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static  void viewAddTodoList(){
        System.out.println("Menambah Todo List");
        var todo = input("Todo (x untuk Cancel)");

        if(todo.equalsIgnoreCase("X")){
            viewShowTodoList();
        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewDeleteTodoList(){
        System.out.println("Menghapus Todo");

        var number = input("Nomor Todo Yang Dihapus (x untuk Cancel) ");

        if (number.equalsIgnoreCase("x")){
            // batal
        }else{
            boolean success = deleteTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal Menghapus Todo " + number);
            }
        }
    }

    public static void testViewDeleteTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewDeleteTodoList();

        showTodoList();
    }
}