//This class show help information
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AnaAndRepPanel extends JPanel{
	//private ArrayList filelist;
	private JPanel upPane, lowPanel;
	private JLabel msg, msg1;
	private JScrollPane scroll;
	private OpenFilePanel openfilepanel;
	
	public AnaAndRepPanel(ArrayList filelist, OpenFilePanel openfilepanel)
	{
		msg = new JLabel("Help Information: ");
		
		upPane = new JPanel();
		upPane.setLayout(new BoxLayout(upPane, BoxLayout.Y_AXIS));
		upPane.add(msg);
		
		
		
		
		
		
		
		
		scroll = new JScrollPane(upPane);
		add(scroll);
		
		
		
	}

}
