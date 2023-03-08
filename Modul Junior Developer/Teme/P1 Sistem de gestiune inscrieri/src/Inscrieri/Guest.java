package Inscrieri;
public class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    //Getters
    public String getLastName () {
    return this.lastName;
}
    public String getFirstName() {
    return this.firstName;
}
    public String getEmail () {
    return this.email;
}
    public String getPhoneNumber () {
    return this.phoneNumber;
}

    //Setters
    public void setLastName(String newLastName){
            this.lastName = newLastName;
    }
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
    }

    public Guest() {}

    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode()) +
                ((this.firstName == null) ? 0 : this.firstName.hashCode())+ ((this.email == null) ? 0 : this.email.hashCode())+
                ((this.phoneNumber == null) ? 0 : this.lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Guest testGuest = (Guest) obj;
        return this.lastName.equals(testGuest.lastName) && this.firstName.equals(testGuest.firstName) &&
                this.email.equals(testGuest.email) && this.phoneNumber.equals(testGuest.phoneNumber);
    }

    @Override
    public String toString() {
        return "Nume: " + this.fullName() + ", Email: " + this.email + ", Telefon: " + this.phoneNumber +"\n";
    }

    public String fullName() {
        return this.lastName + " " + this.firstName;
    }

}
