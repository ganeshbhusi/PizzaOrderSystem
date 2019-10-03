import java.awt.GridLayout;//importing grid layout from awt
import java.awt.event.*;//importing events
import javax.swing.*;//importing swing
//implements means we are using the elements of a Java Interface in our class.
//extends means that we are creating a subclass of the base class we are extending
public class PaymentFrame extends JFrame implements ActionListener{
   // creating the labels for the payment frame
   JLabel name_surname = new JLabel("Name and Surname:");
   JLabel address = new JLabel("Address:");
   JLabel credit_card = new JLabel("Credit Card Number:");
   JLabel exp_date = new JLabel("Expiration Date:");
   JLabel cvc = new JLabel("CVC:");
  // creating the text fields for the jframe and setting the size of 20
   JTextField textField1 = new JTextField();
   JTextField textField2 = new JTextField();
   JTextField textField3 = new JTextField();
   JTextField textField4 = new JTextField();
   JTextField textField5 = new JTextField();
  //creating the button that has the name 'Pay'
   JButton pay_button = new JButton("Pay");
  //creating the PaymentFrame
   public PaymentFrame(){
       this.setTitle("Payment");//title for the frame
       this.setLayout(new GridLayout(6,2,5,5));//setting the layout with (2 rows, 6 columns, 5 px horizontal gap, 5px vertical gap
       //adding the lable1
       this.add(name_surname);
       //adding the textfied1
       this.add(textField1);
       //adding the lable2
       this.add(address);
       this.add(textField2);//adding the textfied2
       this.add(credit_card);//adding the lable3
       this.add(textField3);//adding the textfied3
       this.add(exp_date);//adding the lable4
       this.add(textField4);//adding the textfied4
       this.add(cvc);//adding the lable5
       this.add(textField5);//adding the textfied5
       this.add(pay_button);//adding the button to the Frame
       pay_button.addActionListener(this);//adding the actionlister to the button
       this.setSize(600, 200);//setting the size of the JFrame to 600*200
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Telling the JFrame that close the JFrame when we click X button
       this.setVisible(true);//making the JFrame visible when it opened
   }

   @Override//overriding the actionperfoemd function
   public void actionPerformed(ActionEvent arg0) {
       JOptionPane.showMessageDialog(this,"Your order will be delivered in 30 minutes");//it will show the dialog box when click button
       System.exit(0);//after clicking that button, the jar file will be closed
   }
}