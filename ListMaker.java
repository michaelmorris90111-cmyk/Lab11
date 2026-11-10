import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static final ArrayList<String> myArrList = new ArrayList<>();

    static void main() {
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        do {
            String userChoice = "";
            System.out.println("What would you like to do");
            System.out.println("Q/q - quit");
            System.out.println("A/a - add to the list");
            System.out.println("I/i - insert to a specific location in the list");
            System.out.println("D/d - delete an item from the list");
            System.out.println("P/p - print the list");
            String a = SafeInput.getRegExString(in, "", "[AaDdIiPpQq]");

            if (a.equalsIgnoreCase("a")){
                add(in, "What would you like to add to the list: ");
            }else if(a.equalsIgnoreCase("I")){
                insert(in);
            }else if(a.equalsIgnoreCase("d")){
                delete(in);
            }else if(a.equalsIgnoreCase("p")){
                display();
                System.out.println();
                System.out.println();
            }else if(a.equalsIgnoreCase("q")){
                quit = quit(in);
            }
        } while(!quit);
    }
    private static void display(){
        for(int i = 0; i < myArrList.size(); i++){
            System.out.println(i + ")" + " " + myArrList.get(i));
        }
    }
    private static void add (Scanner pipe, String prompt){
        System.out.print(prompt);
        myArrList.add(pipe.nextLine());
    }
    private static void insert (Scanner pipe){
        System.out.println("What would you like to add to the list: ");
        String input = pipe.nextLine();
        myArrList.add(SafeInput.getRangedInt(pipe, "Enter the index for your input", 0, myArrList.size()), input);

    }
    private static void delete (Scanner pipe){
        display();
        myArrList.remove(SafeInput.getRangedInt(pipe, "Enter the index for what you want to delete", 0, myArrList.size()));
    }
    private static boolean quit(Scanner pipe){
        boolean quit = SafeInput.getYNConfirm(pipe, "Are you sure you want to quit?");
        return quit;
    }
}