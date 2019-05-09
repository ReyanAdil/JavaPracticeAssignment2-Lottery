
import java.util.*;
public class Main {

    public static void main(String[] args) {


        //calling function takeUserInput() which will return a list of 6 distinct numbers between 1-49
        ArrayList<Integer> userInput = takeUserInput();
                System.out.println("\nYour Input Numbers: " + userInput);

        //calling function randomLotteryNumber() which returns a list of 6 distinct random numbers between 1-49
        ArrayList<Integer> randomLotteryNumber = createRandomLottery();
        System.out.println("Lucky Numbers were: " + randomLotteryNumber);

        // calling function checkIfLotteryMatch() which takes list userInput and randomLotteryNumber, compares them and if finds matching
        // numbers in the two list, stores them in a new list lotteryMatch. In the end returns the list lotteryMatch
        ArrayList<Integer> lotteryMatch = checkIfLotteryMatch(userInput, randomLotteryNumber);
        System.out.println("Matched Lottery: " + lotteryMatch + "\n");
        if(lotteryMatch.size() == 6){
            System.out.println("Congratulations You have a JACKPOT!!!");
        }else if(lotteryMatch.size()>0){
            System.out.println("Congratulations!! You have " + (lotteryMatch.size()) + " lucky match(es) \n");
            System.out.println(lotteryMatch);
            }else System.out.println("Sorry you lost!! Better Luck Next Time");

    }

    public static ArrayList<Integer> createRandomLottery(){
        Random randomCreate = new Random();
        int tempNumber; boolean addNumberToList;
        ArrayList<Integer> randomLotteryNumber = new ArrayList<>();
        do{
            addNumberToList = true;
            tempNumber = randomCreate.nextInt(50) + 1; //tempNumber stores random number
            for(int j = 0; j < randomLotteryNumber.size(); j++){
                if(randomLotteryNumber.get(j) == tempNumber){ // if tempNumber is already in the list randomLotteryNumber then breaks the loop and flags addNumberToList as false
                    addNumberToList = false;
                    break;
                }
            }
            if(addNumberToList)
                randomLotteryNumber.add(tempNumber); // if tempNumber is not in the list randomLotteryNumber then adds tempNumber to the list
        }while(randomLotteryNumber.size() < 6);
        return randomLotteryNumber;
    }



    public static ArrayList<Integer> takeUserInput(){
        ArrayList<Integer> userInput = new ArrayList<>();
        int tempInput; int count = 1;
        boolean shouldAddToUserInput;
        Scanner input = new Scanner(System.in);
        do{
            try{
                System.out.println("\n Input number " + count + ": ");
                tempInput = input.nextInt();  //tempInput stores input number by user temporarily
                shouldAddToUserInput = true;
                for (int i = 0; i < userInput.size(); i++) {
                    if (userInput.get(i) == tempInput) { //to avoid duplicates if tempInput is already in the list UserInput breaks checking loop and flags shouldAddToUserInput to false
                        shouldAddToUserInput = false;
                        break;
                    }
                }
                if (shouldAddToUserInput && tempInput < 50 && tempInput > 0) { //else if tempInput is not in the list userInput then adds it to the list
                    userInput.add(tempInput);
                    count++;
                } else {
                    System.out.println("Invalid Input, Try Again"); // Exception handling if user inputs number less than 1 and greater than 49
                }
                if(count > 6) break;
            }catch (Exception e) {
                System.out.println("Invalid Input Only Integer Numbers Allowed. Try Again \n"); //Exception handling if user input anything other than Integer Numbers
                input.nextLine(); //clear input.nextInt() buffer
            }

        }while(true);



        return userInput;
    }

    public static ArrayList<Integer> checkIfLotteryMatch(ArrayList<Integer> userInput, ArrayList<Integer> randomLotteryNumber){
        ArrayList<Integer> lotteryMatch = new ArrayList<>();
        for(int i = 0; i < randomLotteryNumber.size(); i++){
            for(int j = 0; j < userInput.size(); j++){
                if(randomLotteryNumber.get(j) == userInput.get(i)){
                    lotteryMatch.add(randomLotteryNumber.get(j));
                    break;
                }
            }
        }
        return lotteryMatch;
    }
}
