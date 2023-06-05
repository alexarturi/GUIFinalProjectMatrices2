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
    private JButton scalarButton1;
    private JButton scalarButton2;
    private JButton multiplyButton;
    private JButton inverseButton1;
    private JButton inverseButton2;
    private JPanel menuPanel;
    private JButton performScalarMultiplication1;
    private JButton performScalarMultiplication2;
    private double scalar;
    private JTextField input;

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
                scalarButton1 = new JButton("Scalar Multiplication: Matrix 1");
                scalarButton1.addActionListener(this);
                scalarButton2 = new JButton("Scalar Multiplication: Matrix 2");
                scalarButton2.addActionListener(this);
                multiplyButton = new JButton("Multiply Matrices");
                multiplyButton.addActionListener(this);
                inverseButton1 = new JButton("Find Inverse: Matrix 1");
                inverseButton1.addActionListener(this);
                inverseButton2 = new JButton("Find Inverse: Matrix 2");
                inverseButton2.addActionListener(this);
                menuPanel.add(inputValues);
                menuPanel.add(addButton);
                menuPanel.add(subtractButton);
                menuPanel.add(multiplyButton);
                menuPanel.add(scalarButton1);
                menuPanel.add(scalarButton2);
                menuPanel.add(inverseButton1);
                menuPanel.add(inverseButton2);
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
                addFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                addFrame.setTitle("Matrix Addition");

                double[][] temp = MatrixSolver.add(realMatrix1, realMatrix2);
                if (temp==null){
                    JLabel nullReturn = new JLabel("Sorry this operation couldn't be performed");
                    addFrame.add(nullReturn);
                } else {
                    JTable addMatrix = new JTable(temp.length, temp[0].length);
                    for (int row = 0; row< temp.length; row++){
                        for (int col = 0; col< temp[0].length; col++){
                            addMatrix.setValueAt(temp[row][col], row, col);
                        }
                    }
                    JScrollPane addScroll = new JScrollPane(addMatrix);
                    addFrame.add(addScroll);
                }
                addFrame.setLayout(new java.awt.FlowLayout());

                addFrame.pack();
                addFrame.setVisible(true);
                addFrame.revalidate();
            } else if (butt.getText().equals("Subtract")){
                JFrame subtractFrame = new JFrame();

                subtractFrame.setVisible(true);
                subtractFrame.setSize(500, 400);
                subtractFrame.setLocation(450,100);
                subtractFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                subtractFrame.setTitle("Matrix Subtraction");

                double[][] temp = MatrixSolver.subtract(realMatrix1, realMatrix2);
                if (temp==null){
                    JLabel nullReturn = new JLabel("Sorry this operation couldn't be performed");
                    subtractFrame.add(nullReturn);
                } else {
                    JTable subMatrix = new JTable(temp.length, temp[0].length);
                    for (int row = 0; row< temp.length; row++){
                        for (int col = 0; col< temp[0].length; col++){
                            subMatrix.setValueAt(temp[row][col], row, col);
                        }
                    }
                    JScrollPane addScroll = new JScrollPane(subMatrix);
                    subtractFrame.add(addScroll);
                }

                subtractFrame.setLayout(new java.awt.FlowLayout());

                subtractFrame.pack();
                subtractFrame.setVisible(true);
                subtractFrame.revalidate();
            } else if (butt.getText().equals("Scalar Multiplication: Matrix 1")) {
                JFrame scalarMultiplyFrame = new JFrame();

                scalarMultiplyFrame.setVisible(true);
                scalarMultiplyFrame.setSize(500, 400);
                scalarMultiplyFrame.setLocation(450,100);
                scalarMultiplyFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                scalarMultiplyFrame.setTitle("Input your constant");

                input = new JTextField(10);
                scalarMultiplyFrame.add(input);
                performScalarMultiplication1 = new JButton("Perform Scalar Multiplication: Matrix 1");
                performScalarMultiplication1.addActionListener(this);
                scalarMultiplyFrame.add(performScalarMultiplication1);

                scalarMultiplyFrame.setLayout(new java.awt.FlowLayout());

                scalarMultiplyFrame.setVisible(true);
                scalarMultiplyFrame.revalidate();
            } else if (butt.getText().equals("Scalar Multiplication: Matrix 2")){
                JFrame scalarMultiplyFrame = new JFrame();

                scalarMultiplyFrame.setVisible(true);
                scalarMultiplyFrame.setSize(500, 400);
                scalarMultiplyFrame.setLocation(450,100);
                scalarMultiplyFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                scalarMultiplyFrame.setTitle("Input your constant");

                input = new JTextField(10);
                scalarMultiplyFrame.add(input);
                performScalarMultiplication2 = new JButton("Perform Scalar Multiplication: Matrix 2");
                performScalarMultiplication2.addActionListener(this);
                scalarMultiplyFrame.add(performScalarMultiplication2);

                scalarMultiplyFrame.setLayout(new java.awt.FlowLayout());

                scalarMultiplyFrame.pack();
                scalarMultiplyFrame.setVisible(true);
                scalarMultiplyFrame.revalidate();
            } else if (butt.getText().equals("Multiply Matrices")){
                JFrame matrixMultiplicationFrame = new JFrame();

                matrixMultiplicationFrame.setVisible(true);
                matrixMultiplicationFrame.setSize(500, 400);
                matrixMultiplicationFrame.setLocation(450,100);
                matrixMultiplicationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                matrixMultiplicationFrame.setTitle("Matrix Multiplication");

                double[][] temp = MatrixSolver.multiply(realMatrix1, realMatrix2);
                if (temp==null){
                    JLabel nullReturn = new JLabel("Sorry this operation couldn't be performed");
                    matrixMultiplicationFrame.add(nullReturn);
                } else {
                    JTable multiplyMatrix = new JTable(temp.length, temp[0].length);
                    for (int row = 0; row< temp.length; row++){
                        for (int col = 0; col< temp[0].length; col++){
                            multiplyMatrix.setValueAt(temp[row][col], row, col);
                        }
                    }
                    JScrollPane addScroll = new JScrollPane(multiplyMatrix);
                    matrixMultiplicationFrame.add(addScroll);
                }

                matrixMultiplicationFrame.setLayout(new java.awt.FlowLayout());

                matrixMultiplicationFrame.pack();
                matrixMultiplicationFrame.setVisible(true);
                matrixMultiplicationFrame.revalidate();
            } else if (butt.getText().equals("Find Inverse: Matrix 1")){
                JFrame inverseFrame = new JFrame();

                inverseFrame.setVisible(true);
                inverseFrame.setSize(500, 400);
                inverseFrame.setLocation(450,100);
                inverseFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                inverseFrame.setTitle("Matrix Inversion");

                double[][] temp = MatrixSolver.findInverse(realMatrix1);
                if (temp==null){
                    JLabel nullReturn = new JLabel("Sorry this operation couldn't be performed");
                    inverseFrame.add(nullReturn);
                } else {
                    JTable inverseMatrix = new JTable(temp.length, temp[0].length);
                    for (int row = 0; row< temp.length; row++){
                        for (int col = 0; col< temp[0].length; col++){
                            inverseMatrix.setValueAt(temp[row][col], row, col);
                        }
                    }
                    JScrollPane addScroll = new JScrollPane(inverseMatrix);
                    inverseFrame.add(addScroll);
                }

                inverseFrame.setLayout(new java.awt.FlowLayout());

                inverseFrame.pack();
                inverseFrame.setVisible(true);
                inverseFrame.revalidate();
            } else if (butt.getText().equals("Find Inverse: Matrix 2")){
                JFrame inverseFrame = new JFrame();

                inverseFrame.setVisible(true);
                inverseFrame.setSize(500, 400);
                inverseFrame.setLocation(450,100);
                inverseFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                inverseFrame.setTitle("Matrix Inversion");

                double[][] temp = MatrixSolver.findInverse(realMatrix2);
                if (temp==null){
                    JLabel nullReturn = new JLabel("Sorry this operation couldn't be performed");
                    inverseFrame.add(nullReturn);
                } else {
                    JTable inverseMatrix = new JTable(temp.length, temp[0].length);
                    for (int row = 0; row< temp.length; row++){
                        for (int col = 0; col< temp[0].length; col++){
                            inverseMatrix.setValueAt(temp[row][col], row, col);
                        }
                    }
                    JScrollPane addScroll = new JScrollPane(inverseMatrix);
                    inverseFrame.add(addScroll);
                }
                inverseFrame.setLayout(new java.awt.FlowLayout());

                inverseFrame.pack();
                inverseFrame.setVisible(true);
                inverseFrame.revalidate();
            } else if (butt.getText().equals("Perform Scalar Multiplication: Matrix 1")) {
                JFrame answerFrame = new JFrame("Scalar Multiplication");
                answerFrame.setVisible(true);
                answerFrame.setSize(500, 400);
                answerFrame.setLocation(450,100);
                answerFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                double num = Double.parseDouble(input.getText());
                double[][] temp = MatrixSolver.scalarMultiplication(num, realMatrix1);

                JTable scalarMatrix = new JTable(temp.length, temp[0].length);
                for (int row = 0; row< temp.length; row++){
                    for (int col = 0; col< temp[0].length; col++){
                        scalarMatrix.setValueAt(temp[row][col], row, col);
                    }
                }
                JScrollPane addScroll = new JScrollPane(scalarMatrix);
                answerFrame.add(addScroll);

                answerFrame.setLayout(new java.awt.FlowLayout());

                answerFrame.pack();
                answerFrame.setVisible(true);
                answerFrame.revalidate();
            } else if (butt.getText().equals("Perform Scalar Multiplication: Matrix 2")) {
                JFrame answerFrame = new JFrame("Scalar Multiplication");
                answerFrame.setVisible(true);
                answerFrame.setSize(500, 400);
                answerFrame.setLocation(450,100);
                answerFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                double num = Double.parseDouble(input.getText());
                System.out.println(input.getText());
                double[][] temp = MatrixSolver.scalarMultiplication(num, realMatrix2);

                JTable scalarMatrix = new JTable(temp.length, temp[0].length);
                for (int row = 0; row< temp.length; row++){
                    for (int col = 0; col< temp[0].length; col++){
                        scalarMatrix.setValueAt(temp[row][col], row, col);
                    }
                }
                JScrollPane addScroll = new JScrollPane(scalarMatrix);
                answerFrame.add(addScroll);

                answerFrame.setLayout(new java.awt.FlowLayout());

                answerFrame.pack();
                answerFrame.setVisible(true);
                answerFrame.revalidate();
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