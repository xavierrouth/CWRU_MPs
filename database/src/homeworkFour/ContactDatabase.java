package homeworkFour;
import java.util.*;
/** Xavier Routh
 *  database class that only stores Contacts
 * @param <T> The data type that is stored in the database, in this case it must be
Contact
 * @author Xavier Routh
 */
public class ContactDatabase<T extends Contact> extends Database<Contact>{
    /** Prints out a list with numbers
     * @param iterable Any type of list that we should print
     */
    public void printList(Iterable<T> iterable) {
        int i = 1;
        Iterator<T> iterator = iterable.iterator();
        // Loops through all elements in the iterable, and prints them out
        while (iterator.hasNext()) {
            System.out.println((i + " " + iterator.next().toString()));
            i++;
        }
    }
    /** Main method that reads the users input
     * @param args Arguments
     * @throws Exception If something goes wrong
     */
    public static void main(String[] args) throws Exception {
        // Creates a new database to interact with
        ContactDatabase<Contact> database = new ContactDatabase<>();
        // Creates a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // This is the trait we are currently looking at
        String trait = null;
        // Variable that stores the last list we accessed
        List<Contact> lastList = null;
        // Loop through and read user input
        do {
            String input = scanner.next();
            switch (input) {
                // Exit the program
                case "quit" -> System.exit(0);
                // Add a new contact to the database
                case "add" -> {
                    String name = scanner.next();
                    String phoneNumber = scanner.next();
                    String email = scanner.next();
                    // System.out.println(name + phoneNumber + email);
                    database.add(new Contact(name, phoneNumber, email));
                }
                //Print out a list by the trait
                case "listby" -> {
                    trait = scanner.next();
                    if (trait.equals("name") || trait.equals("phone") ||
                            trait.equals("email")) {
                        lastList = database.getList(trait);
                        database.printList(database.getList(trait));
                    }
                }
                // Find an element in the database
                case "find" -> {
                    trait = scanner.next();
                    String value = scanner.next();
                    Contact contact = switch (trait) {
                        case "name" -> new Contact(value, null, null);
                        case "phone" -> new Contact(null, value, null);
                        case "email" -> new Contact(null, null, value);
                        default -> new Contact(null, null, null);
                    };
                    lastList = (database.lookup(trait, contact));
                    database.printList(lastList);
                }
                // Delete an element from the database
                case "delete" -> {
                    Iterator<Contact> iterator = lastList.iterator();
                    int i = 0;
                    int elementIndex = scanner.nextInt();
                    Contact currentContact;
                    while (iterator.hasNext()) {
                        currentContact = iterator.next();
                        if (i == elementIndex) {
                            database.delete(currentContact);
                            i++;
                        }
                    }
                }
                // Creates a new index to organize the database by
                case "makeindex" -> {
                    trait = scanner.next();
                    database.makeIndex(trait);
                }
                default -> System.out.println("Error: invalid command");
            }
            scanner.nextLine();
        } while (true);
    }
}