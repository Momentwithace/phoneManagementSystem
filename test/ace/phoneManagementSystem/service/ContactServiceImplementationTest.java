package ace.phoneManagementSystem.service;

import ace.phoneManagementSystem.data.models.Contact;
import ace.phoneManagementSystem.data.repository.ContactRepository;
import ace.phoneManagementSystem.data.repository.ContactRepositoryImplementation;
import ace.phoneManagementSystem.services.ContactService;
import ace.phoneManagementSystem.services.ContactServiceImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceImplementationTest {
    @Test
    void testThatContactIsAdded(){
        ContactRepository contactRepository = new ContactRepositoryImplementation();
        ContactService contactService = new ContactServiceImplementation(contactRepository);
        Contact contact = new Contact("Ace", "paul", "0907865453", "ace@gmail.com");
        var savedContact = contactService.saveContact(contact);
        assertEquals(1, contactService.getNumberOfContacts());
        assertEquals(1, savedContact.getId());



    }
}
