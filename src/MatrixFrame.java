import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MatrixFrame extends JFrame {
    private JTable table1;
    private JTable table2;

    public MatrixFrame(int[][] matrix1, int[][] matrix2) {
        super("Matrix Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table1 = new JTable(matrix1.length, matrix1[0].length);
        table2 = new JTable(matrix2.length, matrix2[0].length);

        // Populate table1
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                table1.setValueAt(matrix1[i][j], i, j);
            }
        }

        // Populate table2
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                table2.setValueAt(matrix2[i][j], i, j);
            }
        }

        // Create scroll panes for tables
        JScrollPane scrollPane1 = new JScrollPane(table1);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        // Add scroll panes to the frame
        getContentPane().add(scrollPane1);
        getContentPane().add(scrollPane2);

        // Set layout to display tables side by side
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        MatrixFrame frame = new MatrixFrame(matrix1, matrix2);
    }
}