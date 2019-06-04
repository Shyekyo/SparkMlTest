package xiaofan.zhang.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxiaofan on 2019/6/4.
 */
public class demo3 {

    public static void main(String[] args) {
        demo3 demo3 = new demo3();
        char[][] board = {
                 {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        char[][] board1 ={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] board2 ={
                {'.','.','5','.','.','.','.','.','.'},
                {'1','.','.','2','.','.','.','.','.'},
                {'.','.','6','.','.','3','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'3','.','1','5','2','.','.','.','.'},
                {'.','.','.','.','.','.','.','4','.'},
                {'.','.','6','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','9','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        boolean validSudoku = demo3.isValidSudoku(board2);
        System.out.println(validSudoku);
    }

    @Test
    public void test(){

    }

    public boolean isValidSudoku1(char[][] board) {
        boolean[][] rowFlag=new boolean[9][9];
        boolean[][] colFlag=new boolean[9][9];
        boolean[][] cellFlag=new boolean[9][9];
        for(int i=0;i<9;++i){
            for(int j=0;j<9;++j){
                if(board[i][j]>='1'&&board[i][j]<='9'){
                    int c=board[i][j]-'1';
                    if(rowFlag[i][c]||colFlag[c][j]||cellFlag[3 * (i / 3) + j / 3][c]) return false;
                    rowFlag[i][c]=true;
                    colFlag[c][j]=true;
                    cellFlag[3 * (i / 3) + j / 3][c] = true;
                }
            }
        }
        return true;
    }
    boolean canPut(char[][] board, int i, int j, char v) {
        for(int k = 0; k < 9; k++) {
            if(board[i][k] == v
                    || board[k][j] == v
                    || board[i / 3 * 3 + k % 3][j / 3 * 3 + k / 3] == v) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j <9; j++) {
                if(board[i][j] != '.') {
                    char t = board[i][j];
                    board[i][j] = '.';
                    if(!canPut(board, i, j, t))
                        return false;
                    board[i][j] = t;
                }
            }
        }
        return true;
    }







    public boolean isValidSudoku(char[][] board) {
        int kuan=board[0].length;
        int chang=board.length;
        boolean flag=true;
        Map<Character,Boolean> map = new HashMap<>();
        Map<Integer,Map<Character,Boolean>> shu = new HashMap<>();
        Map<Integer,Map<Character,Boolean>> fangge = new HashMap<>();
        int clear=0;
        for(int i=0;i<chang;i++){
            for(int j=0;j<kuan;j++){
                if(board[i][j]=='.') continue;
                if(map.get(board[i][j])!=null){
                    System.out.println(i+"===1==="+j);
                    return false;
                }else{
                    map.put(board[i][j],true);
                }
                if(shu.get(kuan-j)==null){
                    Map<Character,Boolean> nei = new HashMap<>();
                    System.out.println("index i : "+i+" index j : "+j+" value: "+board[i][j]);
                    nei.put(board[i][j],true);
                    shu.put(kuan-j,nei);
                }else{
                    if(shu.get(kuan-j).get(board[i][j])!=null) {
                        System.out.println(i + "===2===" + j);
                        return false;
                    }else{
                        shu.get(kuan-j).put(board[i][j],true);
                    }
                }
                if(i<=2){
                    if(j<=2){
                        System.out.println(i+"----3----"+j);
                        if(fangge.get(4)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(4,nei);
                        }else{
                            if(fangge.get(4).get(board[i][j])!=null) {
                                System.out.println(i+"===3==="+j);
                                return false;
                            }else{
                                fangge.get(4).put(board[i][j],true);
                            }
                        }
                    }else if(j>=3&&j<=5){
                        if(fangge.get(15)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(15,nei);
                        }else{
                            if(fangge.get(15).get(board[i][j])!=null){
                                System.out.println(i+"===4==="+j);
                                return false;
                            }else{
                                fangge.get(15).put(board[i][j],true);
                            }
                        }
                    }else{
                        if(fangge.get(54)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(54,nei);
                        }else{
                            if(fangge.get(54).get(board[i][j])!=null){
                                System.out.println(i+"===5==="+j);
                                return false;
                            }else{
                                fangge.get(54).put(board[i][j],true);
                            }
                        }
                    }
                }else if(i>=3&&i<=5){
                    if(j<=2){
                        if(fangge.get(4)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(4,nei);
                        }else{
                            if(fangge.get(4).get(board[i][j])!=null){
                                System.out.println(i+"===6==="+j);
                                return false;
                            }else{
                                fangge.get(4).put(board[i][j],true);
                            }
                        }
                    }else if(j>=3&&j<=5){
                        if(fangge.get(15)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(15,nei);
                        }else{
                            if(fangge.get(15).get(board[i][j])!=null){
                                System.out.println(i+"===7==="+j);
                                return false;
                            }else{
                                fangge.get(15).put(board[i][j],true);
                            }
                        }
                    }else{
                        if(fangge.get(54)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(54,nei);
                        }else{
                            if(fangge.get(54).get(board[i][j])!=null) {
                                System.out.println(i+"===8==="+j);
                                return false;
                            }else{
                                fangge.get(54).put(board[i][j],true);
                            }
                        }
                    }
                }else{
                    if(j<=2){
                        if(fangge.get(4)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(4,nei);
                        }else{
                            if(fangge.get(4).get(board[i][j])!=null) {
                                System.out.println(i+"===9==="+j);
                                return false;
                            }else{
                                fangge.get(4).put(board[i][j],true);
                            }
                        }
                    }else if(j>=3&&j<=5){
                        if(fangge.get(15)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(15,nei);
                        }else{
                            if(fangge.get(15).get(board[i][j])!=null) {
                                System.out.println(i+"===10==="+j);
                                return false;
                            }else{
                                fangge.get(15).put(board[i][j],true);
                            }
                        }
                    }else{
                        if(fangge.get(54)==null){
                            Map<Character,Boolean> nei = new HashMap<>();
                            nei.put(board[i][j],true);
                            fangge.put(54,nei);
                        }else{
                            if(fangge.get(54).get(board[i][j])!=null){
                                System.out.println(i+"===11==="+j);
                                return false;
                            }else{
                                fangge.get(54).put(board[i][j],true);
                            }
                        }
                    }
                }
            }
            map.clear();
            clear++;
            if(clear%9==3){
                //System.out.println(clear+".....");
                fangge.clear();
                clear=0;
            }
        }
        return flag;
    }
}
