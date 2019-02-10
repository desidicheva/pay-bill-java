//Desislava Dicheva
//Date: 04/20/2014
//Project:The purpose of this assignment is to use Swing components to create a Java application with simple graphical user interface and event handling. 
/*
 * Custom Exception class to generate when the 
 * entered amount is lesser than zero
 */
public class InvalidAmountException extends Exception{

	public InvalidAmountException() {
		super();
	}
	
	public InvalidAmountException( String message ) {
		super(message);
	}
}
