package Inscrieri;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static void showCommands() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua persoana (inscriere)");
        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("remove       - Sterge o persoana existenta din lista");
        System.out.println("update       - Actualizeaza detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de asteptare");
        System.out.println("available    - Numarul de locuri libere");
        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("subscribe_no - Numarul total de persoane inscrise");
        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("save         - Salveaza lista cu invitati");
        System.out.println("restore      - Completeaza lista cu informatii salvate anterior");
        System.out.println("reset        - Sterge informatiile salvate despre invitati");
        System.out.println("quit         - Inchide aplicatia");
    }

    private static void addNewGuest(Scanner sc, GuestsList list) {
        String lastName;
        String firstName;
        String email;
        String phoneNo;
        lastName = sc.nextLine();
        firstName = sc.nextLine();
        email = sc.nextLine();
        phoneNo = sc.nextLine();
        Guest g = new Guest(lastName, firstName, email, phoneNo);
        list.add(g);
    }

    private static void checkGuest(Scanner sc, GuestsList list) {
        int option = sc.nextInt();
        sc.nextLine();

        Guest result = new Guest();

        switch (option){
            case 1:
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                System.out.println(lastName + " " + firstName);
                result = list.search(firstName, lastName);
                break;

            case 2:
                String email = sc.nextLine();
                result = list.search(2, email);
                break;

            case 3:
                String phoneNo = sc.nextLine();
                result = list.search(3, phoneNo);
                break;
        }

        if ((result != null) && (result.fullName().equals("")) &&
                (result.getEmail().equals("")) && (result.getPhoneNumber().equals(""))) {
            System.out.println("Nothing found");
        } else if (result == null) {
            System.out.println("Nothing found");
        } else {
            System.out.print(result);
        }
    }

    private static void removeGuest(Scanner sc, GuestsList list) {
        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                list.remove(firstName, lastName);
                break;

            case 2:
                String email = sc.nextLine();
                list.remove(2, email);
                break;

            case 3:
                String phoneNo = sc.nextLine();
                list.remove(3, phoneNo);
                break;
        }
    }

    private static void updateGuest(Scanner sc, GuestsList list) {
        Guest g = new Guest();

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                g = list.search(firstName, lastName);
                break;

            case 2:
                String email = sc.nextLine();
                g = list.search(2, email);
                break;

            case 3:
                String phoneNo = sc.nextLine();
                g = list.search(3, phoneNo);
                break;
        }

        int changeOption = sc.nextInt();
        sc.nextLine();

        switch (changeOption) {
            case 1:
                String newLastName = sc.nextLine();
                g.setLastName(newLastName);
                break;

            case 2:
                String newFirstName = sc.nextLine();
                g.setFirstName(newFirstName);
                break;

            case 3:
                String newEmail = sc.nextLine();
                g.setEmail(newEmail);
                break;

            case 4:
                String newPhoneNo = sc.nextLine();
                g.setPhoneNumber(newPhoneNo);
                break;
        }
    }

    private static void searchList(Scanner sc, GuestsList list) {
        String toMatch = sc.nextLine();
        List<Guest> result = list.partialSearch(toMatch);
        if (result == null) {
            System.out.println("Nothing found");
        } else {
            System.out.print(list.printSearchResult(result));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        GuestsList list = new GuestsList(size);

        boolean running = true;
        while (running) {
            String command = scanner.nextLine();

            switch (command) {
                case "help":
                    showCommands();
                    break;
                case "add":
                    addNewGuest(scanner, list);
                    break;
                case "check":
                    checkGuest(scanner, list);
                    break;
                case "remove":
                    removeGuest(scanner, list);
                    break;
                case "update":
                    updateGuest(scanner, list);
                    break;
                case "guests":
                    list.showGuestsList();
                    break;
                case "waitlist":
                    list.showWaitingList();
                    break;
                case "available":
                    System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
                    break;
                case "guests_no":
                    System.out.println("Numarul de participanti: " + list.numberOfGuests());
                    break;
                case "waitlist_no":
                    System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
                    break;
                case "subscribe_no":
                    System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
                    break;
                case "search":
                    searchList(scanner, list);
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    scanner.close();
                    running = false;
                    break;
                default:
                    System.out.println("comanda este ->" + command);
                    System.out.println("Comanda introdusa nu este valida.");
                    System.out.println("Incercati inca o data.");
            }
        }
    }
}