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
    private JButton addButton;
    private JButton subtractButton;
    private JButton scalarButton;
    private JButton multiplyButton;
    private JButton inverseButton;
    private JPanel menuPanel;

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
                        matrix1.setValueAt(0.0, i, c);
                    }
                }
                matrix2 = new JTable(rows2, cols2);
                realMatrix2 = new double[rows2][cols2];
                for (int i=0; i<rows2; i++){
                    for (int c=0; c<cols2; c++){
                        matrix2.setValueAt(0.0, i, c);
                    }
                }

                scrollPane1 = new JScrollPane(matrix1);
                scrollPane2 = new JScrollPane(matrix2);
                JButton inputValues = new JButton("Input Values");
                inputValues.addActionListener(this);

                // Add scroll panes to the frame
                input.add(scrollPane1);
                input.add(scrollPane2);

                menuPanel = new JPanel();
                addButton = new JButton("Add");
                addButton.addActionListener(this);
                subtractButton = new JButton("Subtract");
                subtractButton.addActionListener(this);
                scalarButton = new JButton("Scalar Multiplication");
                scalarButton.addActionListener(this);
                multiplyButton = new JButton("Multiply Matrices");
                multiplyButton.addActionListener(this);
                inverseButton = new JButton("Find Inverse");
                inverseButton.addActionListener(this);
                menuPanel.add(inputValues);
                menuPanel.add(addButton);
                menuPanel.add(subtractButton);
                menuPanel.add(scalarButton);
                menuPanel.add(multiplyButton);
                menuPanel.add(inverseButton);
                menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
                input.add(menuPanel);

                input.setLayout(new java.awt.FlowLayout());

                input.pack();
                input.setVisible(true);
                input.revalidate();
            } else if (butt.getText().equals("Input Values")){
                for (int row=0; row<realMatrix1.length; row++){
                    for (int col=0; col<realMatrix1[0].length; col++){
                        if (matrix1.getValueAt(row,col) instanceof String){
                            String temp = (String) matrix1.getValueAt(row,col);
                            realMatrix1[row][col] = Double.parseDouble(temp);
                        } else {
                            realMatrix1[row][col]= (double) matrix1.getValueAt(row,col);
                        }

                    }
                }
                for (int row=0; row<realMatrix2.length; row++){
                    for (int col=0; col<realMatrix2[0].length; col++){
                        if (matrix2.getValueAt(row,col) instanceof String){
                            String temp = (String) matrix2.getValueAt(row,col);
                            realMatrix2[row][col] = Double.parseDouble(temp);
                        } else {
                            realMatrix2[row][col]= (double) matrix2.getValueAt(row,col);
                        }
                    }
                }
            } else if (butt.getText().equals("Add")) {
                JFrame addFrame = new JFrame();

                addFrame.setVisible(true);
                addFrame.setSize(500, 400);
                addFrame.setLocation(450,100);
                addFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                addFrame.setTitle("Matrix Addition");

                addFrame.setLayout(new java.awt.FlowLayout());

                addFrame.pack();
                addFrame.setVisible(true);
                addFrame.revalidate();
            } else if (butt.getText().equals("Subtract")){
                JFrame subtractFrame = new JFrame();

                subtractFrame.setVisible(true);
                subtractFrame.setSize(500, 400);
                subtractFrame.setLocation(450,100);
                subtractFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                subtractFrame.setTitle("Matrix Subtraction");

                subtractFrame.setLayout(new java.awt.FlowLayout());

                subtractFrame.pack();
                subtractFrame.setVisible(true);
                subtractFrame.revalidate();
            } else if (butt.getText().equals("Scalar Multiplication")) {
                JFrame scalarMultiplyFrame = new JFrame();

                scalarMultiplyFrame.setVisible(true);
                scalarMultiplyFrame.setSize(500, 400);
                scalarMultiplyFrame.setLocation(450,100);
                scalarMultiplyFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                scalarMultiplyFrame.setTitle("Scalar Multiplication");

                scalarMultiplyFrame.setLayout(new java.awt.FlowLayout());

                scalarMultiplyFrame.pack();
                scalarMultiplyFrame.setVisible(true);
                scalarMultiplyFrame.revalidate();
            } else if (butt.getText().equals("Multiply Matrices")){
                JFrame matrixMultiplicationFrame = new JFrame();

                matrixMultiplicationFrame.setVisible(true);
                matrixMultiplicationFrame.setSize(500, 400);
                matrixMultiplicationFrame.setLocation(450,100);
                matrixMultiplicationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                matrixMultiplicationFrame.setTitle("Matrix Multiplication");

                matrixMultiplicationFrame.setLayout(new java.awt.FlowLayout());

                matrixMultiplicationFrame.pack();
                matrixMultiplicationFrame.setVisible(true);
                matrixMultiplicationFrame.revalidate();
            } else if (butt.getText().equals("Find Inverse")){
                JFrame inverseFrame = new JFrame();

                inverseFrame.setVisible(true);
                inverseFrame.setSize(500, 400);
                inverseFrame.setLocation(450,100);
                inverseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                inverseFrame.setTitle("Matrix Inversion");

                inverseFrame.setLayout(new java.awt.FlowLayout());

                inverseFrame.pack();
                inverseFrame.setVisible(true);
                inverseFrame.revalidate();
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

