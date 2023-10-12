import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Model {
	Control c;
    double[][] d;
    double[][] d2;
    double[][] d3;
    double[][] d4;
    
    public Model(Control fromC) {
        c = fromC;
    }
    
    //Save button
    public void saveFile(String file, double[][] dataFile) {
        try {
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(dataFile);
            oo.close();
            fo.close();
            System.out.println("file " + file + " saved");
            System.out.println(dataFile + "Save");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
    
    //Open file button
    public double[][] openFile(String file) {
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            double[][] data = (double[][]) oi.readObject();
            oi.close();
            fi.close();
            System.out.println("file " + file + " opened");
            System.out.println(data);
            return data;
        }
        
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        return d;

    }
    
    //Frame that shows up when you press open file
    public void openFileDisplay(double[][] data) {
        JTextField[][] fieldDisp3 = new JTextField[data.length][data[0].length];
        JPanel zpanel = new JPanel(new GridLayout(data.length, data[0].length, 2, 2));

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {

                fieldDisp3[i][j] = new JTextField();
                fieldDisp3[i][j].setText("" + data[i][j]);
                zpanel.add(fieldDisp3[i][j]);
            }
        }
        c.zframe.setTitle("Open file");
        c.zframe.setLayout(new BorderLayout());
        c.zframe.add(zpanel, BorderLayout.CENTER);

        zpanel.setBackground(c.ourple);
        c.zframe.setBackground(c.ourple);
        c.zframe.setBounds(500, 600, 300, 200);
        c.zframe.setVisible(true);

    }
    
    //Read button
    public void procReadV(int opt) {
        if (opt == 1) {
            c.dat1 = new double[c.numRow1][c.numCol1];
            c.read1.setEnabled(false);
            for (int i = 0; i < c.numRow1; i++) {
                for (int j = 0; j < c.numCol1; j++) {
                	c.dat1[i][j] = Double.parseDouble(c.tf1[i][j].getText());
                }
            }
        }
        if (opt == 2) {
            c.dat2 = new double[c.numRow2][c.numCol2];
            c.read2.setEnabled(false);
            for (int i = 0; i < c.numRow2; i++) {
                for (int j = 0; j < c.numCol2; j++) {
                	c.dat2[i][j] = Double.parseDouble(c.tf2[i][j].getText());
                }
            }
        }
    }
    
    //Add, Subtract, Multiply options
    public void operating(int opt) {

        switch (opt) {
            case 1:

                JTextField[][] tf3 = new JTextField[c.numRow1][c.numCol1];
                JPanel zpanel = new JPanel(new GridLayout(c.numRow1, c.numCol1, 2, 2));
                d2 = new double[c.numRow1][c.numCol1];

                for (int i = 0; i < c.numRow1; i++) {
                    for (int j = 0; j < c.numCol1; j++) {
                        d2[i][j] = c.dat1[i][j] + c.dat2[i][j];
                        tf3[i][j] = new JTextField();
                        tf3[i][j].setText("" + d2[i][j]);
                        zpanel.add(tf3[i][j]);
                    }
                }
                c.zpanel = new JPanel(new GridLayout(1, 4));
                c.zpanel.add(c.clear3);
                c.zpanel.add(c.file3);
                c.zpanel.add(c.save3);
                c.zpanel.add(c.open3);
                c.file3.setForeground(Color.BLACK);

                c.zframe = new JFrame("Addition");
                c.zframe.setLayout(new BorderLayout());
                c.zframe.add(zpanel, BorderLayout.CENTER);
                c.zframe.add(c.zpanel, BorderLayout.SOUTH);
                zpanel.setBackground(c.ourple);
                c.zframe.setBackground(c.ourple);
                c.zframe.setBounds(500, 600, 300, 200);
                c.zframe.setVisible(true);
                break;

            case 2:
                
                JTextField[][] tf4 = new JTextField[c.numRow1][c.numCol1];
                JPanel apanel = new JPanel(new GridLayout(c.numRow1, c.numCol1, 2, 2));
                d3 = new double[c.numRow1][c.numCol1];

                for (int i = 0; i < c.numRow1; i++) {
                    for (int j = 0; j < c.numCol1; j++) {
                        d3[i][j] = c.dat1[i][j] - c.dat2[i][j];
                        tf4[i][j] = new JTextField();
                        tf4[i][j].setText("" + d3[i][j]);
                        apanel.add(tf4[i][j]);
                    }
                }

                c.zpanel = new JPanel(new GridLayout(1, 4));
                c.zpanel.add(c.clear3);
                c.zpanel.add(c.file3);
                c.zpanel.add(c.save3);
                c.zpanel.add(c.open3);
                c.file3.setForeground(Color.BLACK);

                c.zframe = new JFrame("Subtraction");
                c.zframe.setLayout(new BorderLayout());
                c.zframe.add(apanel, BorderLayout.CENTER);
                c.zframe.add(c.zpanel, BorderLayout.SOUTH);
                apanel.setBackground(c.ourple);
                c.zframe.setBackground(c.ourple);
                c.zframe.setBounds(850, 600, 300, 200);
                c.zframe.setVisible(true);
                break;

            case 3:
                JTextField[][] tf5 = new JTextField[c.numRow1][c.numCol2];
                JPanel bpanel = new JPanel(new GridLayout(c.numRow1, c.numCol2, 2, 2));
                d4 = new double[c.numRow1][c.numCol2];

                for (int i = 0; i < c.numRow1; i++) {
                    for (int j = 0; j < c.numCol2; j++) {

                        for (int k = 0; k < c.numRow2; k++) {
                            d4[i][j] += c.dat1[i][k] * c.dat2[k][j];

                        }
                        tf5[i][j] = new JTextField();
                        tf5[i][j].setText("" + d4[i][j]);
                        bpanel.add(tf5[i][j]);

                    }
                }

                c.zpanel = new JPanel(new GridLayout(1, 4));
                c.zpanel.add(c.clear3);
                c.zpanel.add(c.file3);
                c.zpanel.add(c.save3);
                c.zpanel.add(c.open3);
                c.file3.setForeground(Color.BLACK);

                c.zframe = new JFrame("Multiplication");
                c.zframe.setLayout(new BorderLayout());
                c.zframe.add(bpanel, BorderLayout.CENTER);
                c.zframe.add(c.zpanel, BorderLayout.SOUTH);
                bpanel.setBackground(c.ourple);
                c.zframe.setBackground(c.ourple);
                c.zframe.setBounds(850, 600, 300, 200);
                c.zframe.setVisible(true);
                break;

        }
    }
	
    public boolean valRead() {
        if (c.dat1 != null && c.dat2 != null)
            return true;
        else
            return false;
    }

    public boolean valDouble(JTextField datr) {
        try {
            double d = Double.parseDouble(datr.getText());
            return true;
        }

        catch (NumberFormatException e) {
            System.out.println("invalid number ");
            c.output.setText("Invalid number retype");
            return false;
        }

    }
}
