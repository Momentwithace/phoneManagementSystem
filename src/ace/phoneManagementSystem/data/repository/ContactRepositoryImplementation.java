package ace.phoneManagementSystem.data.repository;

import ace.phoneManagementSystem.data.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepositoryImplementation implements ContactRepository{
    private int counter;
    private List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact){
        var contactToEdit = findContactById(contact.getId());
        if(contactToEdit == null){
            counter++;
            contact.setId(counter);
            contacts.add(contact);
        }
        else {
            contactToEdit.setFirstName(contact.getFirstName());
            contactToEdit.setPhoneNumber(contact.getPhoneNumber());
            contactToEdit.setLastName(contact.getLastName());
            contactToEdit.setEmail(contact.getEmail());
        }
        return contact;
    }

    @Override
    public void deleteContact(int id) {
        for (Contact contact : contacts) {
            if(contact.getId() == id){
                contacts.remove(contact);
                break;
            }
        }

    }

    @Override
    public void deleteContact(Contact newContact) {
        for (Contact contact : contacts) {
           if(contact.getId() == newContact.getId()){
                contacts.remove(newContact);
                break;
            }
        }
    }


    @Override
    public List<Contact> findByContactFirstName(String firstName) {
        List<Contact> newContactList = new ArrayList<>();
        for (Contact contact : contacts) {
            if(Objects.equals(contact.getFirstName(), firstName)){
                newContactList.add(contact);
            }
        }
        return newContactList;
    }

    @Override
    public List<Contact> findByContactLastName(String lastName) {
        List<Contact> newContactList = new ArrayList<>();
        for (Contact contact : contacts) {
            if(Objects.equals(contact.getLastName(), lastName)){
                newContactList.add(contact);
            }
        }
        return newContactList;
    }

    @Override
    public Contact findContactById(int id) {
        for (Contact contact : contacts) {
            if(contact.getId() == id){
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAllContact() {
        return contacts;
    }

    @Override
    public Contact update(Contact newContact) {
        return null;
    }

    @Override
    public Contact findByEmail(String email) {
        for (Contact contact : contacts) {
            if(Objects.equals(contact.getEmail(), email)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return contacts.size();
    }
 }

