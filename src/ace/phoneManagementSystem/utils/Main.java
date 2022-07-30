package ace.phoneManagementSystem.utils;

import ace.phoneManagementSystem.contollers.UserController;
import ace.phoneManagementSystem.dtos.requests.ContactRequest;
import ace.phoneManagementSystem.dtos.requests.RegisterRequest;

import java.util.Scanner;

public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static UserController userController = new UserController();
    public static void main(String[] args){
        displayMainMenu();
    }

    private static void displayMainMenu() {
        String prompt = """
                    WELCOME TO FAKE CALLER APP
                1 -> Create an Account
                2 -> Add contact to a user
                3 -> Find contact belonging to a user
                """;
        String userInput = input(prompt);
        switch (userInput.charAt(0)){
            case '1' -> createAccount();
            case '2' -> addContactToUser();
            case '3' -> findContactBelongingToUser();
        }

    }

    private static String input(String prompt) {
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }


    private static void findContactBelongingToUser() {
        var contacts = userController.findContactBelongingTo(input("Enter your email"));
        contacts.forEach(contact -> System.out.println(contact.toString()));
        displayMainMenu();
    }

    private static void addContactToUser() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setUserEmail(input("Enter your email: "));
        contactRequest.setEmail(input("Enter contact email: "));
        contactRequest.setFirstName(input("Enter your firstName: "));
        contactRequest.setLastName(input("Enter your lastName"));
        contactRequest.setPhoneNumber(input("Enter your phone number"));
        userController.addContact(contactRequest);
        displayMainMenu();
    }

    private static void createAccount() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName(input("Enter first name: "));
        registerRequest.setLastName(input("Enter last name: "));
        registerRequest.setEmail(input("Enter email: "));
        registerRequest.setPin(input("Enter pin: "));
        userController.registerUser(registerRequest);
        System.out.println("done");
        displayMainMenu();
    }

}
