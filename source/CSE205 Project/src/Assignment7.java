import java.awt.Container;
import javax.swing.JApplet;

public class Assignment7
  extends JApplet
{
  public void init()
  {
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);
    
    setSize(500, 400);
  }
}
