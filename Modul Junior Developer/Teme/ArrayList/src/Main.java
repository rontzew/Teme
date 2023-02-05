import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        while(!stop) {
            System.out.print("1) Gestiune Lista Elemente;\n" +
                    "2) Frecventa Maxima;\n" +
                    "0 -> quit: ");
            int option = sc.nextInt();
            switch (option){
                case 0:
                    System.out.println("cya.");
                    stop = true;
                    break;
                case 1:
                    GestiuneListaElemente.gestiune(sc);
                    break;
                case 2:
                    FrecventaMaxima.frecventa(sc);
                    break;
                default:
                    System.out.println("SYKE, THAT'S THE WRONG NUMBER!");
                    break;
            }
        }
    }
}