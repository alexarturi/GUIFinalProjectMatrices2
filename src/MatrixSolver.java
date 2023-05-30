public class MatrixSolver {

    public static double[][] add(double[][] matrix1, double[][] matrix2) {
        if (matrix1.length!=matrix2.length || matrix1[0].length!=matrix2[0].length) {
            return null;
        }

        double[][] ret = new double[matrix1.length][matrix1[0].length];

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[0].length; col++) {
                ret[row][col] = matrix1[row][col] + matrix2[row][col];
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
                ret[row][col] = matrix1[row][col] - matrix2[row][col];
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
                ret[row][col]*=100;
                ret[row][col] = (double)Math.round(ret[row][col])/100;
            }
        }
        return ret;
    }

    public static boolean isInverse(double[][] matrix1, double[][] matrix2) {
        double[][] product = multiply(matrix1,matrix2);
        double[][] identity = new double[product.length][product[0].length];

        for (int i = 0; i < identity.length; i++) {
            if (i < identity[0].length) {
                identity[i][i] = 1;
            }
            else {
                break;
            }
        }

        for (double[] row : identity) {
            for (double col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < identity.length; row++) {
            for (int col = 0; col < identity[0].length; col++) {
                if (product[row][col]!=identity[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double[][] findInverse(double[][] matrix){
        if (matrix.length != matrix[0].length || (matrix.length!=2 || matrix[0].length!=2)){
            return null;
        }

        double[][] ret = new double[matrix.length][matrix.length];
        if (ret.length==2){
            ret[0][0] = matrix[1][1];
            ret[0][1] = -1 * matrix[0][1];
            ret[1][0] = -1 * matrix[1][0];
            ret[1][1] = matrix[0][0];
            double multiplier = (1.0)/(matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
            for (int row = 0; row<ret.length; row++){
                for (int col = 0; col<ret[0].length; col++){
                    ret[row][col] *= multiplier;
                }
            }
        }
        for (int row = 0; row < ret.length; row++) {
            for (int col = 0; col < ret[0].length; col++) {
                ret[row][col]*=100;
                ret[row][col] = (double)Math.round(ret[row][col])/100;
            }
        }
        if (Math.abs(ret[0][0])>1000000) {
            return null;
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
                matrix[row][col]*=100;
                matrix[row][col] = (double)Math.round(matrix[row][col])/100;
            }
        }
        return matrix;
    }
}