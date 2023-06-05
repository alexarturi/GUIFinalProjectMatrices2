public class MatrixSolver {

    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length!=matrix2.length || matrix1[0].length!=matrix2[0].length) {
            return null;
        }

        double[][] ret = new double[matrix1.length][matrix1[0].length];

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                ret[row][col] = round(matrix1[row][col] + matrix2[row][col],3);
            }
        }

        return ret;
    }

    public static double[][] subtract(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length!=matrix2.length || matrix1[0].length!=matrix2[0].length) {
            return null;
        }

        double[][] ret = new double[matrix1.length][matrix1[0].length];

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                ret[row][col] = round(matrix1[row][col] - matrix2[row][col],3);
            }
        }

        return ret;
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        if (matrix1[0].length!=matrix2.length) {
            return null;
        }
        double[][] ret = new double[matrix1.length][matrix2[0].length];
        for (int row = 0; row < ret.length; row++) {
            for (int col = 0; col < ret[0].length; col++) {
                for (int i = 0; i < ret.length; i++) {
                    ret[row][col] += matrix1[row][i]*matrix2[i][col];
                }
            }
        }

        for (int row = 0; row < ret.length; row++) {
            for (int col = 0; col < ret[0].length; col++) {
                ret[row][col] = round(ret[row][col],3);
            }
        }
        return ret;
    }

    public static double[][] scalarMultiplication(double scalar, double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col]*=scalar;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = round(matrix[row][col],3);
            }
        }
        return matrix;
    }

    public static double[][] findInverse(double[][] matrix) {
        if (matrix.length != matrix[0].length){
            return null;
        }
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            double pivot = augmentedMatrix[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        boolean isPossible = false;
        for (double[] row : inverseMatrix) {
            for (double col : row) {
                if (col!=0) {
                    isPossible = true;
                    break;
                }
            }
        }

        if (!isPossible) {
            return null;
        }

        for (int row = 0; row < inverseMatrix.length; row++) {
            for (int col = 0; col < inverseMatrix[0].length; col++) {
                inverseMatrix[row][col] = round(inverseMatrix[row][col],3);
            }
        }

        if (Math.abs(inverseMatrix[0][0])>100000){
            return null;
        }

        return inverseMatrix;
    }

    public static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long temp = Math.round(value);
        return (double) temp / factor;
    }
}