package xiaofan.zhang.demo;

/**
 * Created by zhangxiaofan on 2019/6/5.
 */
public class demo4 {
    public static void main(String[] args) {
        demo4 demo4 = new demo4();
        int[][] matrix ={
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        int[][] matrix1 ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        demo4.rotate(matrix1);
        demo4.print(matrix1);
    }
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1)  / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][(n - 1 - j)];
                matrix[n - 1 - i][(n - 1 - j)] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        int length = matrix[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }

        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }
    public void print(int[][] matrix1){
        for (int i = 0; i <matrix1.length ; i++) {
            for (int j = 0; j <matrix1[0].length ; j++) {
                System.out.print(matrix1[i][j] +" , ");
            }
            System.out.println();
        }
    }
}
