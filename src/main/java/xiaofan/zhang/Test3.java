package xiaofan.zhang;

/**
 * Created by zhangxiaofan on 2019/4/9.
 */
public class Test3 {
    static int[][] map = new int[8][8];

    public static void main(String[] args) {
        show();
    }
    static int count = 1;
    static void show(){
        System.out.println("第"+count+"种摆法");
        count++;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                System.out.println(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
