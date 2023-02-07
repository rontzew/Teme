import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while(!stop) {
            System.out.print("""
                    1) Gestiune Lista Elemente;
                    2) Frecventa Maxima;
                    0) -> quit:\s""");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0 -> {
                    System.out.println("cya.");
                    stop = true;
                    sc.close();
                }
                case 1 -> GestiuneListaElemente.gestiune(sc);
                case 2 -> MaxFrequency.frequency(sc);
                default -> System.out.println("SYKE, THAT'S THE WRONG NUMBER!");
            }
        }
    }
}