// Assignment #: 6
//         Name: Steve Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: Store Panel class creates a store panel object that will be used in Assignment 6 class to create the layout for the Store Inventory
//                  tab. It will have text fields for a user to input the computer specs which will be added to a computer object and displayed on
//                  the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StorePanel extends JPanel
 {
   private ArrayList compList;
   private PurchasePanel purchasePanel;
   private JButton store;
   private JPanel tools, console;
   private JLabel msg, nameL, priceL, memoryL, cputypeL, cpuspeedL;
   private JTextField nameF, priceF, memoryF, cputypeF, cpuspeedF;
   private JScrollPane scroll;
   private JTextArea info;

   public StorePanel(ArrayList compList, PurchasePanel pPanel) // constructor 
    {
      this.compList = compList;
      this.purchasePanel = pPanel;
      
	  msg=new JLabel("");  //setting the message text that the user will see if something is wrong
      msg.setForeground(Color.red);
      msg.setVisible(false);

      nameL=new JLabel("Brand Name");   //creating the labels the user will see
      priceL=new JLabel("Price");
      memoryL=new JLabel("Memory");
      cputypeL=new JLabel("CPU Type");
      cpuspeedL=new JLabel("CPU Speed");

      nameF= new JTextField();  //the text fileds the user can type into to add specs
      priceF= new JTextField();
      memoryF= new JTextField();
      cputypeF= new JTextField();
      cpuspeedF= new JTextField();

      store=new JButton("Store");   //the button the user will be able to push
      store.addActionListener(new ButtonListener());

      tools=new JPanel();   //adding the lables and text fields to the panel
      tools.setLayout(new GridLayout(5, 2));
      tools.add(nameL);
      tools.add(nameF);
      tools.add(priceL);
      tools.add(priceF);
      tools.add(memoryL);
      tools.add(memoryF);
      tools.add(cputypeL);
      tools.add(cputypeF);
      tools.add(cpuspeedL);
      tools.add(cpuspeedF);

      console=new JPanel(); 
      console.setLayout(new BoxLayout(console, BoxLayout.Y_AXIS));

      console.add(msg);
      console.add(tools);
      console.add(store);

      info=new JTextArea(); //area where user can see computers added
      info.setText("No Computer");
      scroll=new JScrollPane(info);

      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      add(console);
      add(scroll);

    }



  private class ButtonListener implements ActionListener    // used to check if user entered information correctly
   {
    public void actionPerformed(ActionEvent event)
     {
         // if there is no error, add a computer to computer list
         // otherwise, show an error message
         String name, price, memory, cputype, cpuspeed;
         Computer comp=new Computer();
         name=nameF.getText();
		 price=priceF.getText();
		 memory=memoryF.getText();
		 cputype=cputypeF.getText();
		 cpuspeed=cpuspeedF.getText();

		 if(name.equals("") || price.equals("") || memory.equals("") || cputype.equals("")
		 || cpuspeed.equals(""))
		 {
			 msg.setText("Please enter all fields");
			 msg.setVisible(true);
		 }
		 else
		 {
			 try                                             // creates computer object and prints specs in Text Area on right side
			 {
				 comp.setBrandName(name);
				 comp.setPrice(Double.parseDouble(price));
				 comp.setMemory(Integer.parseInt(memory));
				 comp.setCPU(cputype,Integer.parseInt(cpuspeed));

				 if((info.getText()).equalsIgnoreCase("No Computer"))
				 {
					 info.setText("");
				 }
			info.append(comp.toString());
			compList.add(comp);
			purchasePanel.addCheckBox(comp);
			msg.setText("Computer added");
			msg.setVisible(true);
			nameF.setText("");
			priceF.setText("");
			memoryF.setText("");
			cputypeF.setText("");
		    cpuspeedF.setText("");
     	}
     catch(NumberFormatException ex)
     {
		 msg.setText("Enter a number for price, memory and Speed");
		 msg.setVisible(true);
	 }
  }
}
}
}