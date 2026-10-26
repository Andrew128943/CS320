import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private ContactService service;

    @BeforeEach void setUp() {
        service = new ContactService();
        service.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test void testAddContact() {
        service.addContact(new Contact("2", "Jane", "Smith", "0987654321", "456 Oak Ave"));
        assertEquals("Jane", service.getContact("2").getFirstName());
    }

    @Test void testAddDuplicateId() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave")));
    }

    @Test void testDeleteContact() {
        service.deleteContact("1");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("1"));
    }

    @Test void testUpdateContact() {
        service.updateContact("1", "Jim", "Beam", "1112223333", "789 Pine Rd");
        Contact c = service.getContact("1");
        assertEquals("Jim", c.getFirstName());
        assertEquals("Beam", c.getLastName());
        assertEquals("1112223333", c.getPhone());
        assertEquals("789 Pine Rd", c.getAddress());
    }
}