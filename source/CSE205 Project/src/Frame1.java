import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame1
{
  public static void main(String[] args)
  {
    JFrame frame1 = new JFrame("Title");
    frame1.setDefaultCloseOperation(3);
    JButton button1 = new JButton("Button1");
    Container cont1 = frame1.getContentPane();
    cont1.add(button1);
    frame1.setSize(200, 250);
    frame1.setVisible(true);
  }
}
