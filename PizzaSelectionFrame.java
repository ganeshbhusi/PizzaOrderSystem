import java.awt.*;//importing GUI option
import java.awt.event.*;//importing events
import javax.swing.*;//importing swing

//implements means we are using the elements of a Java Interface in our class.
//extends means that we are creating a subclass of the base class we are extending
public class PizzaSelectionFrame extends JFrame implements ActionListener, ItemListener{

   String pizzaList[] = {"chicken pizza", "pepperoni pizza", "veggie pizza"};
   JComboBox<String> dropdownList = new JComboBox<String>(pizzaList);//creating the dropdown list
   ImageIcon icon = new ImageIcon("chicken pizza.PNG");//default image is chicken pizza
   JLabel icon_label = new JLabel(icon);//creating the icon means the image in the JFrame
   //creating 3 Radio buttons which tells the size
   JRadioButton btn_small = new JRadioButton("Small");
   JRadioButton btn_medium = new JRadioButton("Medium");
   JRadioButton btn_large = new JRadioButton("Large");
   //creating CheckBoxes for Topping(s)
   ButtonGroup button_group = new ButtonGroup();//creating button group
   JCheckBox checkBox_Mushroom = new JCheckBox("Mushroom");
   JCheckBox checkBox_Bacon = new JCheckBox("Bacon");
   //creating the button for submitting the order which shows the summary of order
   JButton btn_submit = new JButton("Submit Order");

   public PizzaSelectionFrame(){
       this.setTitle("Order Pizza");//title for the frame
       this.setSize(325, 300);//setting the size of JFrame with 325*300
       this.setLayout(new FlowLayout());//The FlowLayout class puts components in a row, sized at their preferred size
       this.add(icon_label);//adding the label which is having the images to JFrame
       this.add(dropdownList);//adding the dropdown list to JFrame
       this.add(new JLabel("Select Size:"));//text that tells the select size
       button_group.add(btn_small);//adding the first radio button which is tells the option 'Small' to ButtonGroup
       btn_small.setBackground(Color.WHITE);
       btn_small.setSelected(true);//by default making the first radio button selectd
       button_group.add(btn_medium);//adding the first radio button which is tells the option 'Medium' to ButtonGroup
       btn_medium.setBackground(Color.WHITE);
       button_group.add(btn_large);//adding the first radio button which is tells the option 'Large' to ButtonGroup
       btn_large.setBackground(Color.WHITE);
       this.add(btn_small);//adding the first radio button to JFrame
       this.add(btn_medium);//adding the second radio button to JFrame
       this.add(btn_large);//adding the third radio button to JFrame
       this.add(new JLabel("Select Topping(s):"));//adding the label for Select Topping(s)
       this.add(checkBox_Mushroom);//adding the First CheckBox to JFrame
       this.add(checkBox_Bacon);//adding the Second CheckBox to JFrame
       checkBox_Mushroom.setBackground(Color.WHITE);
       checkBox_Bacon.setBackground(Color.WHITE);
       this.add(btn_submit);//adding the button to JFrame
       btn_submit.addActionListener(this);//adding the action listener for the button labeled 'Submit Order'
       dropdownList.addItemListener(this);//adding the item listener which will change the image
       this.setBackground(Color.LIGHT_GRAY);//setting the background of JFrame
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Telling the JFrame that close the frame when we click X button
       this.setVisible(true);//making the frame visible when it opened
   }

   @Override//overriding the actionPerfomed method for actionlister interface 
   public void actionPerformed(ActionEvent arg0) {
       String topping_size;//creating variable for setting the size like Small, Medium and Large
       int summary;//which will give the order summary
       if(btn_small.isSelected())//here it telling that first RadioButton selected then the size will be Small
           topping_size = "Small";
       else if(btn_medium.isSelected())//here it telling that second RadioButton selected then the size will be Small
           topping_size = "Medium";
       else//here it telling that 3rd RadioButton selected then the size will be Small, sonce we have only 3 button of radio buttons, we used else, we can also use 'else if(b3.isSelected())''
           topping_size = "Large";
       String topping="";//setting topping to empty
       summary = 1;//setting order summary default to 1
       if((!checkBox_Mushroom.isSelected()) && (!checkBox_Bacon.isSelected())){//if no toppings were selected
           summary = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, "Order Summary:"+topping_size+" Size "+dropdownList.getSelectedItem().toString(), "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
       }
       else if(checkBox_Mushroom.isSelected() && checkBox_Bacon.isSelected()){//if two toppings are selected
        topping = "Mushroom and Bacon";//setting topping to Mushroom and Bacon
        summary = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, "Order Summary:"+topping_size+" Size "+dropdownList.getSelectedItem().toString()+" with"+topping, "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
       }
       else if(checkBox_Mushroom.isSelected()){//if Mushroom only selected
        topping = "Mushroom";//setting topping to Mushroom
        summary = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, "Order Summary:"+topping_size+" Size "+dropdownList.getSelectedItem().toString()+" with"+topping, "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
       }
       else if(checkBox_Bacon.isSelected()){//if Bacon only selected
        topping = "Bacon";//setting topping to Bacon
        summary = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, "Order Summary:"+topping_size+" Size "+dropdownList.getSelectedItem().toString()+" with"+topping, "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
       }

       if(summary == 0){
           PaymentFrame frame=new PaymentFrame();//calling the PaymentFrame
       }
   }

   @Override//overriding the itemStateChanged method for ItemListener Interface
   public void itemStateChanged(ItemEvent arg0) {
       icon_label.setIcon(new ImageIcon(dropdownList.getSelectedItem().toString()+".png"));//changing the image dynamically when chaning the order item
   }

}