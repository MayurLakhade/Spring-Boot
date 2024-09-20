package studentmanagement_system.demo4.exception;

public class StudentIdNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public StudentIdNotFoundException(String message){
		super(message);
		
	}
    
}
