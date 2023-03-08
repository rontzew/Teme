package Inscrieri;

import java.util.ArrayList;
import java.util.List;

class GuestsList {

    private int availableSeats;
    private List<Guest> guestList;
    private List<Guest> waitingList;

    public GuestsList(int guestsCapacity) {
        this.availableSeats = guestsCapacity;
        this.guestList = new ArrayList<>();
        this.waitingList = new ArrayList<>();
    }

    /**
     * Add a new, unique guest to the list.
     *
     * @param 'g' the guest to be added
     * @return '-1' if the guest is already present, '0' if he is a guest, or the
     *         number on the waiting list
     */

    public int add(Guest g) {
        if (!isOnTheListAlready(g)){
            if(numberOfAvailableSpots() > 0){
                guestList.add(g);
                System.out.println("[" + g.fullName() + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
                return 0;
            }else{
                waitingList.add(g);
                System.out.println("[" + g.fullName() + "] Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + waitingList.size() +
                        ". Te vom notifica daca un loc devine disponibil.");
                return waitingList.size();
            }
        }
        return -1;
    }

    /**
     * Check if someone is already registered (either as a guest, or on the waiting
     * list).
     *
     * @param g the guest we are searching for
     * @return true if present, false if not
     */
    private boolean isOnTheListAlready(Guest g) {
        if((guestList.contains(g))||(waitingList.contains(g))){
            return true;
        }
        return false;
    }

    /**
     * Search for a guest based on first and last name. Return the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return the guest if found, null if not
     */
    public Guest search(String firstName, String lastName) {
        for (int i = 0; i < guestList.size(); i++){
            Guest g = guestList.get(i);
            if(g.fullName().equals(lastName + " " + firstName)){
                return guestList.get(i);
            }
        }
        for (int i = 0; i < waitingList.size(); i++){
            Guest g = waitingList.get(i);
            if(g.fullName().equals(lastName + " " + firstName)){
                return waitingList.get(i);
            }
        }
        return null;
    }

    /**
     * Search for a guest based on email or phone number. Return the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return the guest if found, null if not
     */
    public Guest search(int opt, String match) {
        if(opt == 2){
            for(int i = 0; i < guestList.size(); i++) {
                Guest g = guestList.get(i);
                if (g.getEmail().equals(match)){
                    return g;
                }
            }
            for(int i = 0; i < waitingList.size(); i++) {
                Guest g = waitingList.get(i);
                if (g.getEmail().equals(match)){
                    return g;
                }
            }
        }else if(opt == 3){
            for(int i = 0; i < guestList.size(); i++) {
                Guest g = guestList.get(i);
                if (g.getPhoneNumber().equals(match)){
                    return g;
                }
            }
            for(int i = 0; i < waitingList.size(); i++) {
                Guest g = waitingList.get(i);
                if (g.getPhoneNumber().equals(match)){
                    return g;
                }
            }
        }
        return null;
    }

    /**
     * Remove a guest based on first and last name. Remove the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return true if removed, false if not
     */
    public boolean remove(String firstName, String lastName) {

        Guest toRemove = search(firstName, lastName);
        if (toRemove != null) {
            guestList.remove(toRemove);
            if((guestList.size() < availableSeats) && (waitingList.size()!=0)) {
                guestList.add(waitingList.get(0));
                System.out.println("Felicitari " + guestList.get(guestList.size()-1).fullName() + "! Locul tau la eveniment este confirmat. Te asteptam!");
            }
            waitingList.remove(0);
            return true;
        }
        return false;
    }

    /**
     * Remove a guest based on email or phone number. Remove the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return true if removed, false if not
     */
    public boolean remove(int opt, String match) {
        if(opt == 2) {
            Guest toRemove = search(2, match);
            if (toRemove != null) {
                guestList.remove(toRemove);
                if((guestList.size() < availableSeats) && (waitingList.size()!=0)) {
                    guestList.add(waitingList.get(0));
                    System.out.println("Felicitari " + guestList.get(guestList.size()-1).fullName() + "! Locul tau la eveniment este confirmat. Te asteptam!");
                }
                waitingList.remove(0);
                return true;
            }
        }
        if(opt == 3) {
            Guest toRemove = search(3, match);
            if (toRemove != null) {
                guestList.remove(toRemove);
                if((guestList.size() < availableSeats) && (waitingList.size()!=0)) {
                    guestList.add(waitingList.get(0));
                    System.out.println("Felicitari " + guestList.get(guestList.size()-1).fullName() + "! Locul tau la eveniment este confirmat. Te asteptam!");
                }
                waitingList.remove(0);
                return true;
            }
        }
        return false;
    }

    // Show the list of guests.
    public void showGuestsList() {
        for(int i = 0; i < guestList.size(); i++) {
            System.out.print((i+1) + ". " + guestList.get(i).toString());
        }
    }


    // Show the people on the waiting list.
    public void showWaitingList() {
        if(waitingList.size() == 0) {
            System.out.println("Lista de asteptare este goala...");
        } else {
            for (int i = 0; i < waitingList.size(); i++) {
                System.out.print((i + 1) + ". " + waitingList.get(i).toString());
            }
        }
    }

    /**
     * Show how many free spots are left.
     *
     * @return the number of spots left for guests
     */
    public int numberOfAvailableSpots() {
        if(guestList.size() == availableSeats){
            return 0;
        }
        return availableSeats - guestList.size();
    }

    /**
     * Show how many guests there are.
     *
     * @return the number of guests
     */
    public int numberOfGuests() {
        return guestList.size();
    }

    /**
     * Show how many people are on the waiting list.
     *
     * @return number of people on the waiting list
     */
    public int numberOfPeopleWaiting() {
        return waitingList.size();
    }

    /**
     * Show how many people there are in total, including guests.
     *
     * @return how many people there are in total
     */
    public int numberOfPeopleTotal() {
        return guestList.size() + waitingList.size();
    }

    /**
     * Find all people based on a partial value search.
     *
     * @param match the match we are looking for
     * @return a list of people matching the criteria
     */

    public List<Guest> partialSearch(String match) {
        List<Guest> partialSearchResults  = new ArrayList<Guest>(3);
        for(int i = 0; i < guestList.size(); i++){
            Guest searchMatch = guestList.get(i);
            if(searchMatch.fullName().toLowerCase().contains(match.toLowerCase()) ||
               searchMatch.getEmail().toLowerCase().contains(match.toLowerCase()) ||
               searchMatch.getPhoneNumber().toLowerCase().contains(match.toLowerCase())){
                partialSearchResults.add(searchMatch);
            }
        }
        for(int i = 0; i < waitingList.size(); i++){
            Guest searchMatch = waitingList.get(i);
            if(searchMatch.fullName().toLowerCase().contains(match.toLowerCase()) ||
               searchMatch.getEmail().toLowerCase().contains(match.toLowerCase()) ||
               searchMatch.getPhoneNumber().toLowerCase().contains(match.toLowerCase())){
                partialSearchResults.add(searchMatch);
            }
        }
        if(partialSearchResults.size() != 0){
            return partialSearchResults;
        }
       return null;
    }

    public String printSearchResult(List<Guest> searchResult){
        String result = "";

        for(Guest guest : searchResult){
         result += guest.toString();
        }
        return result;
    }

    @Override
    public String toString() {
        String displayGuests = "";

        for (int i = 0; i < guestList.size() - 1; i++){
            displayGuests +=((i+1) + ". Nume: " + guestList.get(i).getFirstName() + " " + guestList.get(i).getLastName() +
                    ", Email: " + guestList.get(i).getEmail() +
                    ", Telefon: " + guestList.get(i).getPhoneNumber() + "\n");
        }
        displayGuests += guestList.size() + guestList.get(guestList.size() - 1).toString();

        return displayGuests;
    }
}