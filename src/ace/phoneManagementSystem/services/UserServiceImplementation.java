package ace.phoneManagementSystem.services;

import ace.phoneManagementSystem.Exception.UserExistsException;
import ace.phoneManagementSystem.data.models.Contact;
import ace.phoneManagementSystem.data.models.User;
import ace.phoneManagementSystem.data.repository.ContactRepository;
import ace.phoneManagementSystem.data.repository.ContactRepositoryImplementation;
import ace.phoneManagementSystem.data.repository.UserRepository;
import ace.phoneManagementSystem.data.repository.UserRepositoryImplementation;
import ace.phoneManagementSystem.dtos.reponses.ContactResponse;
import ace.phoneManagementSystem.dtos.reponses.RegisterUserResponse;
import ace.phoneManagementSystem.dtos.requests.ContactRequest;
import ace.phoneManagementSystem.dtos.requests.RegisterRequest;
import ace.phoneManagementSystem.utils.Mapper;

import java.util.List;

public class UserServiceImplementation implements UserService{
    private UserRepository userRepository;
    private RegisterUserResponse registerUserResponse = new RegisterUserResponse();
    private  ContactService contactService;

    public UserServiceImplementation(UserRepository userRepository, ContactService contactService) {
        this.userRepository = userRepository;
        this.contactService = contactService;
    }
    public UserServiceImplementation(){
        this.userRepository = new UserRepositoryImplementation();
        ContactRepository contactRepository = new ContactRepositoryImplementation();
        this.contactService = new ContactServiceImplementation(contactRepository);
    }
    @Override
    public RegisterUserResponse register(RegisterRequest registerRequest) throws UserExistsException {
        validateUser(registerRequest);
        User newUserTodo = new User();
        Mapper.map(registerRequest, newUserTodo);
        userRepository.save(newUserTodo);
        registerUserResponse.setMessage(newUserTodo.getFirstName() + " registered successfully");
        return registerUserResponse;
    }

    private void validateUser(RegisterRequest registerRequest) {
        var savedUser = userRepository.findByEmail(registerRequest.getEmail());
        if(savedUser != null){
            throw new UserExistsException("User with " + registerRequest.getEmail() + " already exists.");
        }
    }

    @Override
    public int numberOfUsers() {
        return userRepository.count();
    }

    @Override
    public ContactResponse addContact(ContactRequest contactRequest) {
        Contact newContact = new Contact();
        Mapper.map(contactRequest, newContact);
        var savedContact = contactService.saveContact(newContact);
        User user = userRepository.findByEmail(contactRequest.getUserEmail());
        user.getContacts().add(savedContact);
        userRepository.saveNewUser(user);
        return null;
    }

    @Override
    public void deleteContact(String contact) {

    }

    @Override
    public List<Contact> findContactsBelongingTo(String email) {
        var user = userRepository.findByEmail(email);
        return user.getContacts();
    }
}
