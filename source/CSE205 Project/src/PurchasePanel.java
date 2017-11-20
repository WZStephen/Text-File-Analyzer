// Assignment #: 6
//         Name: Steve Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: Purchase Panel class is used to create a purchase panel object used in assignemt 6. it keeps track of the coputers 
//               entered into the storepanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PurchasePanel extends JPanel
 {
   private ArrayList compList;
   private JPanel lPanel, rPanel;
   private JLabel msg;
   private JTextField money;
   private JScrollPane scroll;

   public PurchasePanel(ArrayList compList)
    {
      this.compList = compList;

      // orgranize components for purchase panel
      msg=new JLabel("Current Total Purchase");
      money=new JTextField(10);
      money.setText("$0.00");
      money.setEditable(false);

      rPanel=new JPanel();      //creating layout and adding panels and textfields
      rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.Y_AXIS));
      rPanel.add(msg);
      rPanel.add(money);

      lPanel=new JPanel();
      lPanel.setPreferredSize(new Dimension(400,300));
      scroll=new JScrollPane(lPanel);

      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
      add(scroll);
      add(rPanel);

    }

	public void addCheckBox(Computer comp) //checkbox used to indicate whether or not the computer should be added to the purchase
	{
		JLabel msg1 = new JLabel("success");
		JCheckBox temp=new JCheckBox(comp.toString());
		//temp.addItemListener(new CheckBoxListener());
		lPanel.add(msg1);
		lPanel.add(temp);
	}

 private class CheckBoxListener implements ItemListener //listener to add the computer to the purchase amount when box is checked
  {
       public void itemStateChanged(ItemEvent event)
        {
            // compute the total purchase amount when a check box is
            // checked or unchecked.

            double amount=0.0;

            for(int i=0; i<compList.size(); i++)
            {
				if(((JCheckBox)lPanel.getComponent(i)).isSelected())
				{
					amount+=((Computer)compList.get(i)).getPrice();
				}
			}

			money.setText("$"+amount);
        }
  }
}