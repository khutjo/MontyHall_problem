/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montyhall;

import java.util.Random;

/**
 *
 * @author khutjo_laptop
 */
public class PlayLogic {
    private int rightdoor;
    private String outputstring;
    private int GameRounds;
    private int FirstChoice;
    private int SecondChoice;
    private int MyChoice;
    private Random randgen;
    
    
    public PlayLogic (){
        randgen = new Random(new Random(155).nextInt(1000));
        setrightdoor();
    }
    
    public void setrightdoor(){
        rightdoor = randgen.nextInt(3);
        System.out.println("in and new = " + rightdoor);
        GameRounds = 0;
        FirstChoice = -1;
        SecondChoice = -1;
        MyChoice = -1;
    }
    
    private void setmychoice(){
        
        for (int i = 0; i < 3; i++){
            if (i != rightdoor && i != FirstChoice){
                MyChoice = i;
            }
        }

    }
    
    private void setoutput(String input){outputstring = input;}
    public int getMyChoice(){return MyChoice;}
    public boolean isend(){return (GameRounds == 2 ? true : false);}
    
    public int results(){return rightdoor;}
    
    public boolean MyChoice(int door){
        if (GameRounds == 0){
        System.out.println(door);
            GameRounds++;
            FirstChoice = door;
            setmychoice();
            int tempnum = 1 + MyChoice;
            setoutput("well door No"+ tempnum +" is the bad one do you want to switch");
                    System.out.println(door + " door " + GameRounds + " round " + FirstChoice + " First " + rightdoor+" right" + MyChoice +" mychoice");
            return true;
        }else if (GameRounds == 1 && door != MyChoice){
        System.out.println(door);
            SecondChoice = door;
            GameRounds++;
            if (SecondChoice == rightdoor)
                setoutput("good move you win");
            else if (FirstChoice == rightdoor)
                setoutput("you should have listend to your gut");
            return true;
        }
        return false;
    }
    
    public String getoutput(){return outputstring;}
 
}
