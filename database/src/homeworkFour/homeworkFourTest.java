
package homeworkFour;
        import org.junit.jupiter.api.Test;
        import java.util.ArrayList;
        import static org.junit.jupiter.api.Assertions.*;
public class homeworkFourTest {
    public static void main(String[] args) {}
    @Test
    public void contactTest() {
        // Test constructor and getters / setters
        Contact contact1 = new Contact("Xavier", "216-000-0000", "xrr@case");
        assertEquals(contact1.getName(), "Xavier");
        assertEquals(contact1.getPhoneNumber(), "216-000-0000");
        assertEquals(contact1.getEmail(), "xrr@case");
        Contact contact2 = new Contact("Xavier", "216-000-0000", "xrr@case");
        //Test Equals();
        assertEquals(contact1, contact2);
        contact2.setEmail("xrr@gmail");
        assertNotEquals(contact2, contact1);
        //Test to String
        assertEquals("Xavier 216-000-0000 xrr@case", contact1.toString());
    }
    @Test
    public void databaseTest() {
        // Test Print List
        Contact contact1 = new Contact("Xavier", "216-000-0000", "xrr@case");
        Contact contact2 = new Contact("George", "216-999-0000", "george@case");
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contact1);
        contacts.add(contact2);
        ContactDatabase<Contact> database = new ContactDatabase<>();
        database.printList(contacts);
    }
}