//Desislava Dicheva
//Date: 04/20/2014
//Project:The purpose of this assignment is to use Swing components to create a Java application with simple graphical user interface and event handling. 
import javax.swing.JFrame;

/*
 * Application main class which creates the 
 * PayBillFrame and lets user use the application
 * 
 */
public class PayBillApplication {

	public static void main(String[] args) {

		PayBillGUI payBillFrame = new PayBillGUI();
		payBillFrame.setTitle("Pay the Bill");
		payBillFrame.setVisible( true );
		payBillFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
