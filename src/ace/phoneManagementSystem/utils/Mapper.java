package ace.phoneManagementSystem.utils;

import ace.phoneManagementSystem.data.models.Contact;
import ace.phoneManagementSystem.data.models.User;
import ace.phoneManagementSystem.dtos.requests.ContactRequest;
import ace.phoneManagementSystem.dtos.requests.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest registerRequest, User newUserToDo){
        newUserToDo.setEmail(registerRequest.getEmail());
        newUserToDo.setPin(registerRequest.getPin());
        newUserToDo.setFirstName(registerRequest.getFirstName());
        newUserToDo.setLastName(registerRequest.getLastName());
    }
    public static void map(Contact contact, Contact newContact){
        newContact.setPhoneNumber(contact.getPhoneNumber());
        newContact.setEmail(contact.getEmail());
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
    }

    public static void map(ContactRequest contactRequest, Contact newContact){
        newContact.setLastName(contactRequest.getLastName());
        newContact.setEmail(contactRequest.getEmail());
        newContact.setFirstName(contactRequest.getFirstName());
        newContact.setPhoneNumber(contactRequest.getPhoneNumber());
    }
}
