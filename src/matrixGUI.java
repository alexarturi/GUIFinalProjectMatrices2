import javax.swing.*;
import java.awt.event.*;

public class matrixGUI extends JFrame implements ActionListener, KeyListener {
    private JTextField rowField1;
    private JTextField colField1;
    private JButton submitButton;
    private JLabel colLabel1;
    private JLabel rowLabel1;
    private JLabel introLabel;
    private JPanel mainPanel;
    private JTextField rowField2;
    private JTextField colField2;
    private JLabel rowLabel2;
    private JLabel colLabel2;

    public matrixGUI(){
        createUIComponents();
    }

    private void createUIComponents(){
        setContentPane(mainPanel);
        setTitle("Matrix Calculator");
        setSize(500,400);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        submitButton.addActionListener(this);
        colField1.addKeyListener(this);
        rowField1.addKeyListener(this);
        colField2.addKeyListener(this);
        rowField2.addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source instanceof JButton){
            int rows1 = Integer.parseInt(rowField1.getText());
            int cols1 = Integer.parseInt(colField1.getText());
            int rows2 = Integer.parseInt(rowField2.getText());
            int cols2 = Integer.parseInt(colField2.getText());
            System.out.println("Rows 1: " + rows1);
            System.out.println("Columns 1: " + cols1);
            System.out.println("Rows 2: " + rows2);
            System.out.println("Columns 2: " + cols2);
            dispose();

            JFrame input = new JFrame();
            input.setVisible(true);
            input.setSize()
//            JPanel second = new JPanel();
//
//            JTable matrix1 = new JTable();
//            JTable matrix2 = new JTable();
//            second.add(matrix1);
//            second.add(matrix2);
//            setVisible(true);
//            setContentPane(second);
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){

    }

    @Override
    public void keyReleased(KeyEvent e){

    }
}

