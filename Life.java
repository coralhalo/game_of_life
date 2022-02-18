//import javax.swing.text.StyledEditorKit.ForegroundAction;
import java.util.Arrays;

public class Life{
    //instance variables: an array of cells to play the game; named as gameArray
    public int[] gameArray ; 
    //constructor: take one param = size of array.
    public Life(int arrSize){
        gameArray = new int[10];
        //- hard-code values at each index 
        gameArray[0] = 1; 
        gameArray[1] = 0; 
        gameArray[2] = 1; 
        gameArray[3] = 0; 
        gameArray[4] = 0;
        gameArray[5] = 1; 
        gameArray[6] = 1; 
        gameArray[7] = 1; 
        gameArray[8] = 1; 
        gameArray[9] = 1;  
       
       //- another way i could do is:  loop through and randomly assign values to each index
       
    } 

    //isAlive(index) : returns true if cell at position is alive 
    public boolean isAlive(int i){
        //for(int n=0; n<gameArray.length; n++){ //going through every index in the array 
            if(gameArray[i] == 1){
                return true ; // cell at position alive 
            } else {
                return false; //cell at position not alive 
            }

        

    }
    //shouldDie(index): true if cell i has two live neighbors.
    public boolean shouldDie(int i){
    // forneighbors that don't exist, check check) 
        if ((i==0) ){  //y6uit never dies once it becomes alive 
            return false; 
        }
        //checking for the last input in the array and it's alive neighbor 
        else if (i == gameArray.length -1 )  {
            return false; 
        }
        else if (gameArray[i+1] == 1 && gameArray[i-1] == 1){
            return true;
        } 
        else{
            return false;
        }
        
        
    }
    //copyArray(firstArray, secondArray):
    //copies the values of the first array in the 2nd one. doesn't return anything. 
    
    public static void copyArray( int[] firstArray, int []secondArray){
        //secondArray = new int [firstArray.length ]; 
        for(int n=0; n< firstArray.length ; n++) {
            secondArray[n] = firstArray[n]; 

        //another method: 
       // int[] secondArray = firstArray.clone();     
        }
    
    }

    //toString(
    public String toString(){
        
        return Arrays.toString(gameArray); 
    }


    //advanceTime() 
    public int[] advanceTime(){
        
   
    //copy the array of the cells=>
        int[] cell = new int[10]; 
        copyArray(gameArray, cell);   
        
    // move through the copy and make changes according tothe rules.
        for (int i=0; i<cell.length ; i++){
        
            if ((isAlive(i) == true)){
                 //two cases can happen : die itself or make the neighbor alive. 
                if (shouldDie(i) == false){ 
      
                    if ((i<gameArray.length -1)){ // changes neighbor on the right 
                        //System.out.println(" time to save my neighbors"); 
                        cell[i+1] = 1; 
                        if(i>0 && cell[i]==1 && cell[i-1]== 0){
                            cell[i-1] = 1; 

                        }
                    
                        //System.out.println("saved my neighbors"); 
                    }
                    
                    else if(  (i == gameArray.length )){ // edge case: changes the neighbor on left
                        //System.out.println(" am i here yet");
                        cell[i-1] =1;
                    } 
                } 
                else{
                    cell[i] = 0;

                }
            }
            else if (i == 0){
                if(cell[i+1] == 1){
                cell[i] = 1; 
                }
            }    
        }    
        //for (int i=0; i< cell.length; i++){
          //  System.out.println(cell[i]);
        //}    
        
        
    // update the array of cells to the values in the copy. 
        copyArray(cell, gameArray); 
    //return the  updated array 
    
        return gameArray;  
    }
    //main function 
    public static void main(String[] args){
    //two constant variables:
        final var timeSteps = 10;  //timeSteps: should be 10
        //System.out.println(timeSteps);
        //gameSize: should be 10
        final int gameSize = 10; 
        //System.out.println(gameSize); 
        //create new life object using gameSize for the size of the array 
        Life myGame = new Life(gameSize); //creating a new life  object 
        for (int n=0; n <= timeSteps; n++){
            //myGame.advanceTime();
            System.out.println(myGame.toString()); 
            myGame.advanceTime();
        }
        
 
    //print the initial values held in the array 
    //run the game timeSteps time, printing the array at the end of each step. 
    }
}