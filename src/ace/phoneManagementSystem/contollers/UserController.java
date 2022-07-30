package ace.phoneManagementSystem.contollers;

import ace.phoneManagementSystem.data.models.Contact;
import ace.phoneManagementSystem.dtos.reponses.ContactResponse;
import ace.phoneManagementSystem.dtos.reponses.RegisterUserResponse;
import ace.phoneManagementSystem.dtos.requests.ContactRequest;
import ace.phoneManagementSystem.dtos.requests.RegisterRequest;
import ace.phoneManagementSystem.services.UserService;
import ace.phoneManagementSystem.services.UserServiceImplementation;

import java.util.List;

public class UserController {
    public UserService userService = new UserServiceImplementation();
    public RegisterUserResponse registerUser(RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

    public ContactResponse addContact(ContactRequest contactRequest){
        return userService.addContact(contactRequest);
    }

    public List<Contact> findContactBelongingTo(String email){
        return userService.findContactsBelongingTo(email);
    }
}
