package ace.phoneManagementSystem.data.repository;

import ace.phoneManagementSystem.data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImplementation implements UserRepository{
    private int counter;

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user){
        var userToEdit = findByUserId(user.getUniqueId());
        if(userToEdit == null){
            ++counter;
            user.setUniqueId(counter);
            users.add(user);
        }
        else {
            userToEdit.setFirstName(user.getFirstName());
            userToEdit.setPhoneNumber(user.getPhoneNumber());
            userToEdit.setLastName(user.getLastName());
            userToEdit.setEmail(user.getEmail());
        }
        return user;
    }


    @Override
    public User saveNewUser(User newUser) {
        return null;
    }

    @Override
    public void deleteUser(int id) {
        for (User user : users) {
            if (user.getUniqueId() == id){
                users.remove(user);
                break;
            }
        }

    }

    @Override
    public void deleteUser(User user) {
        for (User user1 : users) {
            if (user1.getUniqueId() == user.getUniqueId()){
                users.remove(user1);
                break;
            }
        }
    }

    @Override
    public List<User> findUserByFirstName(String firstName) {
        List<User> newlist = new ArrayList<>();
        for (User user : users) {
            if(Objects.equals(user.getFirstName(), firstName)){
                newlist.add(user);
            }

        }
        return newlist;
    }

    @Override
    public List<User> findUserByLastName(String lastName) {
        List<User> newlist = new ArrayList<>();
        for (User user : users) {
            if(Objects.equals(user.getLastName(), lastName)){
                newlist.add(user);
            }

        }
        return newlist;
    }

    @Override
    public User findByUserId(int id) {
        for (User user : users) {
            if(user.getUniqueId() == id){
                return user;
            }

        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if(Objects.equals(user.getEmail(), email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return users.size();
    }
}
