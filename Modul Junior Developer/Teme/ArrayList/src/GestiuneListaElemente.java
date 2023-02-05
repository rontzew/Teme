import java.util.ArrayList;
import java.util.Scanner;

public class GestiuneListaElemente {
    public static void gestiune(Scanner sc){
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        System.out.println("\n" +
                "\t List has been created\n" +
                "\t List is empty? " + list.isEmpty() + "\n" +
                "\t Size of list is: " + list.size() + "\n" +
                "\t Elements in list are: " + list + "\n\n" +
                "\t Adding elements to the list...");

        list.add(4);
        list.add(2);
        list.add(3);
        list.add(8);list.add(34);list.add(254);list.add(983);list.add(4);list.add(5);

        System.out.println("\t Elements in list are: " + list + "\n\n"  +
                "\t Adding element \"1\" at index 2 of the list...");

        list.add(2,1);

        System.out.println("\t Elements in list are: " + list + "\n\n" +
                "\t First apparition of element \"1\" is: " + list.indexOf(1) + "\n" +
                "\t Last index of element \"4\" is: " + list.lastIndexOf(4) + "\n" +
                "\t Removing the element from index 3...");
        list.remove(3);

        System.out.println("\t Elements in list are: " + list + "\n\n" +
                "\t Replacing the element at index 4 with \"22\"...");

        list.set(4, 22);

        System.out.println("\t Elements in list are: " + list + "\n\n" +
                "\t Does the list contain element \"22\"? " + list.contains(22) + "\n" +
                "\t Clearing the list...");

        list.clear();

        System.out.println("\t Elements in list are: " + list + "\n\n" +
                "\t ===End of exercise===\n\n");

        //ArrayList.remove(list);
    }
}
