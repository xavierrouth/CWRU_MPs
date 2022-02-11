package homeworkFour;
import java.util.Comparator;
import java.util.Objects;

/** Xavier Routh
 *  Contact class that represents a contact (name, phoneNumber, and email) to be
 stored in a Database
 * @author Xavier Routh
 */
public class Contact implements DatabaseType{
    // Private fields that store the different Strings that make up a contact
    private String name;
    private String phoneNumber;
    private String email;
    /** Constructor
     * Creates a Contact
     * @param name the name of the contact
     * @param phoneNumber the phonenumber of the contact
     * @param email the email of the contact
     */
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    /** Returns a specific comparator that we will use in other parts of our
     program
     * @param trait the trait that the comparator will compare
     * @return a comparator to be used to sort our index
     */
    @Override
    public Comparator<Contact> getComparatorByTrait(String trait) {
        // Returns the proper Comparator depending on the Trait given
        return switch (trait) {
            case "name" -> new Comparator<Contact>() {
                /** Compares both contacts by their name
                 * @param c1 the first contact
                 * @param c2 the second contact
                 * @return returns the difference in comparison
                 */
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getName().compareToIgnoreCase(c2.getName());
                }
            };
            case "phone" -> new Comparator<Contact>() {
                /** Compares both contacts by their phone number
                 * @param c1 the first contact
                 * @param c2 the second contact
                 * @return returns the difference in comparison
                 */
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getPhoneNumber().compareTo(c2.getPhoneNumber());
                }
            };
            case "email" -> new Comparator<Contact>() {
                /** Compares both contacts by their email
                 * @param c1 the first contact
                 * @param c2 the second contact
                 * @return returns the difference in comparison
                 */
                @Override
                public int compare(Contact c1, Contact c2) {
                    return c1.getEmail().compareTo(c2.getEmail());
                }
            };
            default -> null;
        };
    }
    /** getter for Name
     * @return the name
     */
    public String getName() {
        return name;
    }
    /** Setter for name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
    /** Getter for phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /** Setter for phone number
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /** Getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /** Setter for email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /** Test equality, if name, phonenumber, and email are all the same then the
     contacts are equal.
     * @param o the object to test equality with
     * @return True is the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumber,
                contact.phoneNumber) && Objects.equals(email, contact.email);
    }
    /** Returns a contact formatted correctly as a string
     * @return String
     */
    @Override
    public String toString() {
        return this.getName() + " " + this.getPhoneNumber() + " " +
                this.getEmail();
    }
}