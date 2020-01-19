

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a = {
                {1,2},
                {1,2}
        };
        int[][] b = {
                {1,2},
                {1,2}
        };
        int[][] multiplication = multiply(a, b);
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b.length];
        for(int i=0;i < a[0].length; i++) {
            for(int j=0; j < b.length; j++) {
                int sum = 0;
                for(int k=0;k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
        return result;
    }
}
