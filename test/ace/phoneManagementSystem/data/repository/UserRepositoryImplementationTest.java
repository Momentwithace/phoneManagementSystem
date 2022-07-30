package ace.phoneManagementSystem.data.repository;

import ace.phoneManagementSystem.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplementationTest {
    User newUser;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
       newUser = new User();
       userRepository = new UserRepositoryImplementation();
    }

    @Test
    void testThatWeCanCreateANewUser(){
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        assertEquals(1, userRepository.count());
    }

    @Test
    void testThatWeCanDeleteAUserUsingUserObject(){
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        userRepository.deleteUser(newUser);
        assertEquals(0, userRepository.count());
    }

    @Test
    void testThatWeCanDeleteAUserUsingId(){
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        userRepository.deleteUser(1);
        assertEquals(0, userRepository.count());
    }

    @Test
    void testThatWeCanFindUserUsingId(){
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        assertEquals(1, userRepository.findByUserId(1).getUniqueId());
        assertEquals(1, userRepository.count());
    }



    @Test
    void testThatWeCanFindUserUsingUserFirstname(){
        User newUser1 = new User();
        User newUser2 = new User();
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        newUser1.setFirstName("Ace");
        newUser1.setLastName("Tman");
        newUser1.setEmail("ace@gmail.com");
        newUser1.setPhoneNumber("0907865453");
        newUser1.setPin("1234");
        userRepository.saveNewUser(newUser1);
        newUser2.setFirstName("boyo");
        newUser2.setLastName("Tman");
        newUser2.setEmail("ace@gmail.com");
        newUser2.setPhoneNumber("0907865453");
        newUser2.setPin("1234");
        userRepository.saveNewUser(newUser2);
        assertEquals(3, userRepository.count());
        assertEquals(2, userRepository.findUserByFirstName("Ace").size());
    }


    @Test
    void testThatWeCanFindUserUsingUserLastname(){
        User newUser1 = new User();
        User newUser2 = new User();
        newUser.setFirstName("Ace");
        newUser.setLastName("john");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        newUser1.setFirstName("Ace");
        newUser1.setLastName("Tman");
        newUser1.setEmail("ace@gmail.com");
        newUser1.setPhoneNumber("0907865453");
        newUser1.setPin("1234");
        userRepository.saveNewUser(newUser1);
        newUser2.setFirstName("boyo");
        newUser2.setLastName("paul");
        newUser2.setEmail("ace@gmail.com");
        newUser2.setPhoneNumber("0907865453");
        newUser2.setPin("1234");
        userRepository.saveNewUser(newUser2);
        assertEquals(3, userRepository.count());
        assertEquals(1, userRepository.findUserByLastName("paul").size());
    }

    @Test
    void testThatWeCanFindAllUser(){
        User newUser1 = new User();
        User newUser2 = new User();
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        newUser1.setFirstName("Ace");
        newUser1.setLastName("Tman");
        newUser1.setEmail("ace@gmail.com");
        newUser1.setPhoneNumber("0907865453");
        newUser1.setPin("1234");
        userRepository.saveNewUser(newUser1);
        newUser2.setFirstName("boyo");
        newUser2.setLastName("Tman");
        newUser2.setEmail("ace@gmail.com");
        newUser2.setPhoneNumber("0907865453");
        newUser2.setPin("1234");
        userRepository.saveNewUser(newUser2);
        assertEquals(3, userRepository.count());
        assertEquals(3, userRepository.findAllUser().size());
    }

    @Test
    void testThatWeCanGetUserUsingUserEmail(){
        User newUser1 = new User();
        User newUser2 = new User();
        newUser.setFirstName("Ace");
        newUser.setLastName("Tman");
        newUser.setEmail("ace@gmail.com");
        newUser.setPhoneNumber("0907865453");
        newUser.setPin("1234");
        userRepository.saveNewUser(newUser);
        newUser1.setFirstName("Ace");
        newUser1.setLastName("Tman");
        newUser1.setEmail("ace@gmail.com");
        newUser1.setPhoneNumber("0907865453");
        newUser1.setPin("1234");
        userRepository.saveNewUser(newUser1);
        newUser2.setFirstName("boyo");
        newUser2.setLastName("Tman");
        newUser2.setEmail("ace@gmail.com");
        newUser2.setPhoneNumber("0907865453");
        newUser2.setPin("1234");
        userRepository.saveNewUser(newUser2);
        assertEquals(3, userRepository.count());
        assertEquals("ace@gmail.com", userRepository.findByEmail("ace@gmail.com").getEmail());
    }

}