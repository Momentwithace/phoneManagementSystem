package ace.phoneManagementSystem.services;

import ace.phoneManagementSystem.data.models.Contact;
import ace.phoneManagementSystem.dtos.reponses.ContactResponse;
import ace.phoneManagementSystem.dtos.reponses.RegisterUserResponse;
import ace.phoneManagementSystem.dtos.requests.ContactRequest;
import ace.phoneManagementSystem.dtos.requests.RegisterRequest;

import java.util.List;

public interface UserService {
    RegisterUserResponse register(RegisterRequest registerRequest);
    int numberOfUsers();
    ContactResponse addContact(ContactRequest contactRequest);
    void deleteContact(String contact);
    List<Contact> findContactsBelongingTo(String email);
}
