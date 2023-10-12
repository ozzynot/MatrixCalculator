import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame{

	//Initializing stuff
	public Color ourple = new Color(0x4D1979);

    double[][] dat1;
    double[][] dat2;

    JTextField[][] tf1;
    JTextField[][] tf2;

    JFrame frame = new JFrame();

    JFrame frameX;
    JFrame frameY;

    JTextField col1 = new JTextField(10);
    JTextField col2 = new JTextField(10);
    JTextField row1 = new JTextField(10);
    JTextField row2 = new JTextField(10);

    JButton create = new JButton("Create");
    JButton execute = new JButton("Execute");
    JButton quit = new JButton("QUIT");
    JButton reset = new JButton("Reset");
    String[] s1 = { "Select", "Multiplication", "Addition", "Subtraction" };
    JComboBox box = new JComboBox(s1);
    
    JLabel l1 = new JLabel("First Matrix rows/cols", JLabel.CENTER);
    JLabel l2 = new JLabel("Second Matrix rows/cols", JLabel.CENTER);

    JPanel panelX;
    JPanel panelY;

    JTextField output = new JTextField(50);

    int numRow1;
    int numRow2;
    int numCol1;
    int numCol2;
    
    //Saving and reading stuff
    JPanel xpanel;
    public JButton save1 = new JButton("Save");
    public JButton open1 = new JButton("Open");
    public JButton read1 = new JButton("Read");
    public JTextField file1 = new JTextField(10);

    JPanel ypanel;
    public JButton save2 = new JButton("Save");
    public JButton open2 = new JButton("Open");
    public JButton read2 = new JButton("Read");
    public JTextField file2 = new JTextField(10);

    JPanel zpanel;
    public JButton save3 = new JButton("Save");
    public JButton open3 = new JButton("Open");
    public JButton read3 = new JButton("Read");
    public JButton clear3 = new JButton("Clear");
    public JTextField file3 = new JTextField(10);
    public JTextArea ta = new JTextArea(5, 20);
	
	public static void main(String[] args) {
		new View();
	}
	
	View() {
		output.setText(" Feedback ");
        output.setFont(new Font("SansSerif", Font.PLAIN, 16));
        output.setEditable(false);
        
        l1.setForeground(Color.white);
        l1.setFont(new Font("SansSerif", Font.BOLD, 20));
        l2.setForeground(Color.white);
        l2.setFont(new Font("SansSerif", Font.BOLD, 20));

        frame.setLayout(new GridLayout(6, 2, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 400);
        frame.getContentPane().setBackground(ourple);
        frame.setTitle("Matrix Calculations");
        frame.add(l1);
        frame.add(l2);
        frame.add(row1);
        frame.add(row2);
        frame.add(col1);
        frame.add(col2);
        frame.add(create);
        frame.add(box);
        frame.add(execute);
        frame.add(reset);
        frame.add(quit);
        frame.add(output);

        frame.setVisible(true);

	}

}
