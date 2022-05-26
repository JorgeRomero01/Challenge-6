import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class TicTacToe {
  
  static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
      System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
      char[][] board = {
        {'_','_','_'},
        {'_','_','_'},
        {'_','_','_'},        
      };
            //Task 2: Call the function printBoard();
      printBoard(board);
      for(int i = 0; i < 9; i++){
        if(i % 2 == 0){
          System.out.println("Turn: X");
          int[] spot = askUser(board); //create new spot array and store the values from askUser [#, #]
          board[spot[0]][spot[1]] = 'X'; 
          //System.out.println(Arrays.toString(askUser(board)));
        }
        else //if(i % 2 == 1)
        {
          System.out.println("Turn: O");
          int[] spot = askUser(board); //create new spot array and store the values from askUser [#, #]
          board[spot[0]][spot[1]] = 'O';
        }
        printBoard(board);
        
        int count = checkWin(board);
        if(count == 3){
          System.out.println("X wins");
          break;
        }
        else if (count == -3){
          System.out.println("O wins");
          break;
        }
      }       
            scan.close();
        }

    public static void printBoard(char[][] board){
      System.out.print("");
      for(int i = 0; i < board.length; i++){
        System.out.print("\t");
        for(int j = 0; j < board[i].length; j++){
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }   

    public static int[] askUser(char[][] board){
      System.out.print("Pick a row and column number: ");
      int row = scan.nextInt();
      int column = scan.nextInt();
      while(board[row][column] == 'X' || board[row][column] == 'O'){
        System.out.print("Sorry, the spot is taken, try again: ");
        row = scan.nextInt();
        column = scan.nextInt();
      }
      return new int[] {row,column};
    }

    public static int checkWin(char[][] board){
      int count = 0;
      for(int i = 0; i < board.length; i++){  //iterate thru all rows
        for(int j = 0; j < board[i].length; j++){ //iterate thru all elements on row 
          if(board[i][j] == 'X'){ //if board location = "X" increment count +1
            count++;
          }
          else if(board[i][j] == 'O'){  //if board location = "O" decrease count -1
            count--;
          }
        }
        if(count == 3 || count == -3){  //if count = 3 or -3 return count
          return count;
        }
        else{ //else reset count to 0
          count = 0;
        }
      } 
      
      for(int i = 0; i < 3; i++){
        for(int k = 0; k < 3 ; k++)
          if(board[k][i] == 'X'){
            count++;
          }
          else if(board[k][i] == 'O'){
            count--;
          }
        
          if(count == 3 || count == -3){  //if count = 3 or -3 return count
            return count;
          }
          else{ //else reset count to 0
            count = 0;
          }
        }

        for(int i = 0; i < 3; i++){
          if(board[i][i] == 'X'){
            count++;
          }
          else if(board[i][i] == 'O'){
            count--;
          }
        }
          if(count == 3 || count == -3){  //if count = 3 or -3 return count
            return count;
          }
          else{ //else reset count to 0
            count = 0;
          }
        

        for(int i = 0; i < 3 ; i++){
          if(board[2 - i][i] == 'X'){
            count++;
          }
          else if(board[2 - i][i] == 'O'){
            count--;
          }
        }
          if(count == 3 || count == -3){  //if count = 3 or -3 return count
            return count;
          }
          else{
            count = 0;
          }
        
        return count;




    }



}
