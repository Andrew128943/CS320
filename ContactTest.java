import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test void testValidContact() {
        Contact c = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test void  testInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "addr"));
    }

    @Test void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", null, "Doe", "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "12345678901", "Doe", "1234567890", "addr"));
    }

    @Test void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", null, "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "12345678901", "1234567890", "addr"));
    }

    @Test void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", null, "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "123456789", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345abcde", "addr"));
    }

    @Test void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", "a".repeat(31)));
    }
}