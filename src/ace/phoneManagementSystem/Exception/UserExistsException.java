package ace.phoneManagementSystem.Exception;

public class UserExistsException  extends RuntimeException{
    public UserExistsException(){
        super();
    }
    public UserExistsException(String message){
        super(message);
    }
    public UserExistsException(Throwable err){
        super(err);
    }
    public UserExistsException(String message, Throwable err){
        super(message, err);
    }
}
