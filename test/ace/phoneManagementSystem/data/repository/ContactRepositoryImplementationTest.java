package ace.phoneManagementSystem.data.repository;

import ace.phoneManagementSystem.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplementationTest {
    Contact newContact;
    ContactRepository newContactRepository;

    @BeforeEach
    void setUp() {
        newContact = new Contact();
        newContactRepository = new ContactRepositoryImplementation();
    }

    @Test
    public void saveContact_countIncreaseTest(){
        newContact.setFirstName("Ace");
        newContact.setLastName("Odogwu");
        newContact.setPhoneNumber("111111");
        newContact.setEmail("ace@gmail.go");
        newContactRepository.save(newContact);
        assertEquals(1, newContactRepository.count());

    }

    @Test
    public void saveContact_findByTest(){
        newContact.setFirstName("Ace");
        newContact.setLastName("Odogwu");
        newContact.setPhoneNumber("111111");
        newContact.setEmail("ace@gmail.go");
        newContactRepository.save(newContact);
        assertEquals(1, newContactRepository.count());
        Contact savedContact = newContactRepository.findContactById(1);
        assertEquals("Ace", savedContact.getFirstName());

    }

    @Test
    public void deleteContactById() {
        Contact newContact1 = new Contact();
        newContact.setFirstName("Ace");
        newContact.setLastName("Odogwu");
        newContact.setPhoneNumber("111111");
        newContact.setEmail("ace@gmail.go");
        newContactRepository.save(newContact);

        newContact1.setFirstName("Eden");
        newContact1.setLastName("Elenwoke");
        newContact1.setPhoneNumber("22222");
        newContact1.setEmail("eden@gmail.go");
        newContactRepository.save(newContact1);

        assertEquals(2, newContactRepository.count());
        newContactRepository.deleteContact(1);
        assertEquals(1, newContactRepository.count());
    }

    @Test
    public void findByFirstName() {
        Contact newContact1 = new Contact();
        Contact newContact3 = new Contact();

        newContact.setFirstName("Eden");
        newContact.setLastName("Odogwu");
        newContact.setPhoneNumber("111111");
        newContact.setEmail("ace@gmail.go");
        newContactRepository.save(newContact);

        newContact1.setFirstName("Eden");
        newContact1.setLastName("Elenwoke");
        newContact1.setPhoneNumber("22222");
        newContact1.setEmail("eden@gmail.go");
        newContactRepository.save(newContact1);

        newContact3.setFirstName("Ace");
        newContact3.setLastName("Enwe");
        newContact3.setPhoneNumber("333333");
        newContact3.setEmail("ace1@gmail.go");
        newContactRepository.save(newContact3);

        assertEquals("Ace", newContact3.getFirstName());
        assertEquals(3, newContactRepository.count());
        assertEquals(2, newContactRepository.findByContactFirstName("Eden").size());

    }

    @Test
    public void findByLastName() {
        Contact contactTwo = new Contact();
        Contact contactThree = new Contact();
        newContact.setFirstName("Ace");
        newContact.setLastName("Odogwu");
        newContact.setPhoneNumber("111111");
        newContact.setEmail("ace@gmail.go");
        newContactRepository.save(newContact);

        contactTwo.setFirstName("Eden");
        contactTwo.setLastName("Elenwoke");
        contactTwo.setPhoneNumber("22222");
        contactTwo.setEmail("eden@gmail.go");
        newContactRepository.save(contactTwo);

        contactThree.setFirstName("Ace");
        contactThree.setLastName("joe");
        contactThree.setPhoneNumber("333333");
        contactThree.setEmail("ace1@gmail.go");
        newContactRepository.save(contactThree);
//        assertEquals(1, newContactRepository.findByContactLastName("odogwu").size());
        assertEquals(3, newContactRepository.count());
        assertEquals(1, newContactRepository.findByContactLastName("Elenwoke").size());
    }

    @Test
    public void update() {
        Contact contactTwo = new Contact();
        newContact.setFirstName("Ace");
        newContact.setLastName("Odogwu");
        newContact.setPhoneNumber("111111");
        newContact.setEmail("ace@gmail.go");
        newContactRepository.save(newContact);
        assertEquals(1, newContact.getId());

        newContact.setFirstName("Bread");
        newContact.setLastName("Tea");
        newContactRepository.save(newContact);
        contactTwo.setFirstName("Eden");
        contactTwo.setLastName("Elenwoke");
        newContactRepository.save(contactTwo);

        assertEquals("Bread", newContact.getFirstName());
        assertEquals(1, newContact.getId());
        assertEquals(2, contactTwo.getId());
        assertEquals(2, newContactRepository.count());

    }

}
