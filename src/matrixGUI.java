import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class matrixGUI extends JFrame implements ActionListener, KeyListener {
    public double[][] realMatrix1;
    public double[][] realMatrix2;
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
    private JTable matrix1;
    private JTable matrix2;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;

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
            JButton butt = (JButton) source;
            if (butt.getText().equals("Submit")){
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
                input.setSize(500, 400);
                input.setLocation(450,100);
                input.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                input.setTitle("Input your Matrix Values");

                matrix1 = new JTable(rows1, cols1);
                realMatrix1 = new double[rows1][cols1];
                for (int i=0; i<rows1; i++){
                    for (int c=0; c<cols1; c++){
                        matrix1.setValueAt("0", i, c);
                    }
                }
                matrix2 = new JTable(rows2, cols2);
                realMatrix2 = new double[rows2][cols2];
                for (int i=0; i<rows2; i++){
                    for (int c=0; c<cols2; c++){
                        matrix2.setValueAt("0", i, c);
                    }
                }
                System.out.println(matrix1.getColumnCount());
                System.out.println(matrix1.getRowCount());

                scrollPane1 = new JScrollPane(matrix1);
                scrollPane2 = new JScrollPane(matrix2);
                JButton inputValues = new JButton("Input Values");
                inputValues.addActionListener(this);

                // Add scroll panes to the frame
                input.add(scrollPane1);
                input.add(scrollPane2);
                input.add(inputValues);

                input.setLayout(new java.awt.FlowLayout());

                input.pack();
                input.setVisible(true);
                input.revalidate();
            } else if (butt.getText().equals("Input Values")){
                for (int row=0; row<realMatrix1.length; row++){
                    for (int col=0; col<realMatrix1[0].length; col++){
                        realMatrix1[row][col] = (double) matrix1.getValueAt(row,col);
                    }
                }
                for (int row=0; row<realMatrix2.length; row++){
                    for (int col=0; col<realMatrix2[0].length; col++){
                        realMatrix2[row][col] = (double) matrix2.getValueAt(row,col);
                    }
                }

                System.out.println("Matrix 1 Test: ");
                for (int row=0; row<realMatrix1.length; row++){
                    for (int col=0; col<realMatrix1[0].length; col++){
                        System.out.print(realMatrix1[row][col] + " ");
                    }
                    System.out.println();
                }

                System.out.println("Matrix 2 Test: ");
                for (int row=0; row<realMatrix2.length; row++){
                    for (int col=0; col<realMatrix2[0].length; col++){
                        System.out.print(realMatrix2[row][col] + " ");
                    }
                    System.out.println();
                }
            }
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

