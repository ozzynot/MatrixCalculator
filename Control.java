/*
 * Fall 2023 COSC 20203
 * @author: Oscar Arenas
 * Lab 1
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Control extends View implements ActionListener{
	Model m;
    JFrame zframe = new JFrame();
	
	public static void main(String[] args) {
		new Control();
	}
	
	public Control() {
		m = new Model(this);
        setButtons();
	}
	
	//Making the buttons pay attention to being pressed
	public void setButtons() {
        create.addActionListener(this);
        execute.addActionListener(this);
        quit.addActionListener(this);
        reset.addActionListener(this); 
        box.addActionListener(this);
        save1.addActionListener(this);
        open1.addActionListener(this);
        save2.addActionListener(this);
        open2.addActionListener(this);
        save3.addActionListener(this);
        open3.addActionListener(this);
        read1.addActionListener(this);
        read2.addActionListener(this);
    }
	
	//Making buttons do what their label says
	public void actionPerformed(ActionEvent e) {
        String selButton = e.getActionCommand();
        String s = (String) box.getSelectedItem();
        System.out.println("calling action perform " + " " + selButton + " " + s);

        if (selButton.equals("Create"))
            addPanel();
        if (selButton.equals("Execute") && s.equals("Addition"))
            m.operating(1);
        if (selButton.equals("Execute") && s.equals("Subtraction"))
            m.operating(2);
        if (selButton.equals("Execute") && s.equals("Multiplication"))
            m.operating(3);
        if (selButton.equals("Quit")) {
        	frame.dispose();
        	zframe.dispose();
        	frameX.dispose();
        	frameY.dispose();	
        	System.exit(0);	}
        if (selButton.equals("Reset")) {
        	frame.dispose();
        	new Control();	}
        if (e.getSource() == save1)
            m.saveFile(file1.getText(), dat1);
        if (e.getSource() == save2)
            m.saveFile(file2.getText(), dat2);
        if ((e.getSource() == save3) && (s.equals("Addition")))
            m.saveFile(file3.getText(), m.d2);
        if ((e.getSource() == save3) && (s.equals("Subtraction")))
            m.saveFile(file3.getText(), m.d3);
        if ((e.getSource() == save3) && (s.equals("Multiplication")))
            m.saveFile(file3.getText(), m.d4);
        if (e.getSource() == open1)
            m.openFileDisplay(m.openFile(file1.getText()));
        if (e.getSource() == open2)
            m.openFileDisplay(m.openFile(file2.getText()));
        if (e.getSource() == open3)
            m.openFileDisplay(m.openFile(file3.getText()));
        if (e.getSource() == read1)
            m.procReadV(1);
        if (e.getSource() == read2)
            m.procReadV(2);
    }
	
    public void addPanel() {
        if (validInt(row1) && validInt(col1) && validInt(row2) && validInt(col2)) {
            output.setText(" ");
            numRow1 = Integer.parseInt(row1.getText());
            numRow2 = Integer.parseInt(row2.getText());
            numCol1 = Integer.parseInt(col1.getText());
            numCol2 = Integer.parseInt(col2.getText());

            //Other frames
            frameX = new JFrame("X Matrix");
            frameX.setLayout(new BorderLayout());
            frameY = new JFrame("Y Matrix");
            frameY.setLayout(new BorderLayout());
            xpanel = new JPanel(new GridLayout(numRow1, numCol1, 2, 2));
            ypanel = new JPanel(new GridLayout(numRow2, numCol2, 2, 2));
            tf1 = new JTextField[numRow1][numCol1];
            tf2 = new JTextField[numRow2][numCol2];

            //Saving and reading
            xpanel = new JPanel(new GridLayout(1, 4));
            xpanel.setPreferredSize(new Dimension(300, 30));
            frameX.add(xpanel, BorderLayout.SOUTH);
            xpanel.add(read1);
            xpanel.add(file1);
            xpanel.add(save1);
            xpanel.add(open1);

            ypanel = new JPanel(new GridLayout(1, 4));
            ypanel.setPreferredSize(new Dimension(300, 30));
            frameY.add(ypanel, BorderLayout.SOUTH);
            ypanel.add(read2);
            ypanel.add(file2);
            ypanel.add(save2);
            ypanel.add(open2);

            xpanel.setBackground(ourple);
            ypanel.setBackground(ourple);
            frameY.add(ypanel, BorderLayout.CENTER);
            frameX.add(xpanel, BorderLayout.CENTER);

            for (int i = 0; i < numRow1; ++i) {
                for (int j = 0; j < numCol1; ++j) {
                    tf1[i][j] = new JTextField(10);
                    xpanel.add(tf1[i][j]);
                }
            }
            for (int i = 0; i < numRow2; ++i) {
                for (int j = 0; j < numCol2; ++j) {
                    tf2[i][j] = new JTextField(10);
                    ypanel.add(tf2[i][j]);
                }
            }
            frameX.setBounds(500, 400, 300, 200);
            frameY.setBounds(850, 400, 300, 200);
            frameX.setVisible(true);
            frameY.setVisible(true);

        }
    }
    
    public boolean validInt(JTextField datr) {
        try {
            int d = Integer.parseInt(datr.getText());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Integer ");
            output.setText("Invalid integer, retype");
            return false;
        }
    }
}
