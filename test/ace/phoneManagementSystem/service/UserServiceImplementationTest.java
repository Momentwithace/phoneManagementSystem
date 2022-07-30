package ace.phoneManagementSystem.service;

import ace.phoneManagementSystem.Exception.UserExistsException;
import ace.phoneManagementSystem.data.repository.ContactRepository;
import ace.phoneManagementSystem.data.repository.ContactRepositoryImplementation;
import ace.phoneManagementSystem.data.repository.UserRepository;
import ace.phoneManagementSystem.data.repository.UserRepositoryImplementation;
import ace.phoneManagementSystem.dtos.requests.ContactRequest;
import ace.phoneManagementSystem.dtos.requests.RegisterRequest;
import ace.phoneManagementSystem.services.ContactService;
import ace.phoneManagementSystem.services.ContactServiceImplementation;
import ace.phoneManagementSystem.services.UserService;
import ace.phoneManagementSystem.services.UserServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceImplementationTest {
    UserService userService;
    UserRepository userRepository = new UserRepositoryImplementation();
    ContactRepository contactRepository = new ContactRepositoryImplementation();
    ContactService contactService = new ContactServiceImplementation(contactRepository);
    RegisterRequest registerRequest;
    ContactRequest contactRequest;

    @BeforeEach
    void SetUp(){
        userService = new UserServiceImplementation(userRepository, contactService);
        registerRequest = new RegisterRequest();
        contactRequest = new ContactRequest();

    }

    @Test
    void testThatNewAccountIsCreated(){
        registerRequest.setEmail("ace@gmail.com");
        registerRequest.setFirstName("Ace");
        registerRequest.setLastName("boyo");
        registerRequest.setPin("8978");
        userService.register(registerRequest);
        assertEquals(1, userService.numberOfUsers());
    }

    @Test
    void testThatDuplicateEmailThrowsException(){
        registerRequest.setEmail("ace@gmail.com");
        registerRequest.setFirstName("Ace");
        registerRequest.setLastName("boyo");
        registerRequest.setPin("8978");
        userService.register(registerRequest);

        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setEmail("ace@gmail.com");
        registerRequest2.setFirstName("Ace");
        registerRequest2.setLastName("boyo");
        registerRequest2.setPin("8978");
        assertEquals(1, userService.numberOfUsers());
        assertThrows(UserExistsException.class, () -> userService.register(registerRequest2));
    }

    @Test
    void testThatAccountCanAddContacts(){
        registerRequest.setEmail("ace@gmail.com");
        registerRequest.setFirstName("Ace");
        registerRequest.setLastName("boyo");
        registerRequest.setPin("8978");
        userService.register(registerRequest);

        contactRequest.setEmail("ace@gmail.com");
        contactRequest.setFirstName("Ace");
        contactRequest.setLastName("boyo");
        contactRequest.setPhoneNumber("0907865453");
        contactRequest.setUserEmail("ace@gmail.com");
        userService.addContact(contactRequest);
        assertEquals(1, userService.findContactsBelongingTo("ace@gmail.com").size());
    }
}
