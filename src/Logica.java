import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import Cuentas.Accounts;
import Cuentas.ClassAccount;
import static Cuentas.Accounts.player;

public class Logica {
    
    static ClassAccount ok = new ClassAccount();
    
    final int boardWidth=7;
    final int boardHeight=7;
    int totalMovesPlayed;
    int[][] board;
    
    public Logica(){
        board=new int[boardHeight][boardWidth];
        totalMovesPlayed=0;
    }
    
    public static void main(String args[]){
        Scanner jd = new Scanner(System.in);
        Logica c4=new Logica();
        ClassAccount ca = new ClassAccount(); 
        Connect_Four cf = new Connect_Four();
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bienvenido a Conncet4!!!");
        System.out.println("Ingrese segundo jugador: ");
        String jugador2=jd.next();
        boolean contro=false;
        int r2=ClassAccount.searchUser(jugador2);                     // se llama el metodo buscar, para ello se crea un int r
                                    // verificamos si ya existe el user
                                       if(r2!=-1){
                                           System.out.println("Usuario  existe!");
                                                 }
                                       else{System.out.println("Usuario no existe!");}
        outer:
        while(true){
            int column=0;
            //PLAYER 1.
            
           
            while(true){
            System.out.println("\n\nPlayer "+ok.loggedUser+" juega!:");
            column=jd.nextInt();
            
            if(column==-5){System.out.println("RETIRO! \nGana "+jugador2); Connect_Four.Menu_Principal();}
                if(c4.isPlayable(column)){
                    if(c4.playMove(column, 1)){
                        c4.printBoard();
                        System.out.println("\n\nPlayer 1 gana!!!");
                        ClassAccount c1 = new ClassAccount();
                        
                        
                        
                        // mandar al score y ultimas partidas
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Columna "+column+" esta llena!!");
            }
            c4.printBoard();
            
            //PLAYER 2.    
            while(true){
            
            //System.out.println("\n\n"+jugador2+" juega!:");
            column=jd.nextInt();
            if(column==-5){System.out.println("RETIRO! \nGana Jugador "+ok.loggedUser); Connect_Four.Menu_Principal();}
                if(c4.isPlayable(column)){
                    if(c4.playMove(column, 2)){
                        //c4.printBoard();
                        System.out.println("\n\nPlayer 2 gana!!!");
                         ClassAccount c1 = new ClassAccount();
                         
                        break outer;
                    }
                    break;
                }
                else
                    System.out.println("Column "+column+" esta llena!!");
            }
            c4.printBoard();
            
            if(c4.isFull()){
                System.out.print("Empate!. No hay ganadores sad face!!! ");
                break;
            }
        }
    }
                
    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0)
                    System.out.print("_  ");
                else
                    System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
        
        for(int i=0;i<boardWidth;i++)
            System.out.print("*  ");
        System.out.println();
        
        for(int i=0;i<boardWidth;i++)
            System.out.print(i+"  ");
        System.out.println();
    }
    
    public boolean playMove(int column, int playerNum){
        int i=0;
        for(i=0;i<boardHeight;i++){
            if(board[i][column] == 1 || board[i][column] == 2){
                board[i-1][column]=playerNum;
                break;
            }
        }
        if(i == boardHeight)
            board[i-1][column]=playerNum;
        
        totalMovesPlayed++;
        return isConnected(i-1,column);
    }
    
    public boolean isPlayable(int column){
        return board[0][column] == 0; 
    }
    
    public boolean isFull(){
        return totalMovesPlayed == boardHeight*boardWidth;
    }
    
    public boolean isConnected(int x, int y){
        int num=board[x][y];
        int count=0;
        int i=y;
        
        //HORIZONTAL.
        while(i<boardWidth && board[x][i] == num){
            count++;
            i++;
        }
        i=y-1;
        while(i>=0 && board[x][i] == num){
            count++;
            i--;
        }
        if(count == 4)
            return true;
        
        //VERTICAL.
        count=0;
        int j=x;
        while(j<boardHeight && board[j][y] == num){
            count++;
            j++;
        }
        if(count == 4)
            return true;
        
        //SECONDARY DIAGONAL.
        count=0;
        i=x;
        j=y;
        while(i<boardWidth && j<boardHeight && board[i][j] == num){
            count++;
            i++;
            j++;
        }
        i=x-1;
        j=y-1;
        while(i>=0 && j>=0 && board[i][j] == num){
            count++;
            i--;
            j--;
        }
        if(count == 4)
            return true;
        
        //LEADING DIAGONAL.
        count=0;
        i=x;
        j=y;
        while(i<boardWidth && j>=0 && board[i][j] == num){
            count++;
            i++;
            j--;
        }
        i=x-1;
        j=y+1;
        while(i>=0 && j<boardHeight && board[i][j] == num){
            count++;
            i--;
            j++;
        }
        if(count == 4)
            return true;
        
        return false;
    }
}