import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Quiz {
    static String[] option = {"1)Poll ", "2)Ask Som Sir", "3)Phone a Friend", "4) Exclusive 50/50 offer"};
    private static int fc=0;
    public static void main(String[] args) throws IOException{
        //reading file line by line
        BufferedReader easy = new BufferedReader(new FileReader("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\Questions\\Easy.txt"));
        BufferedReader easy1 = new BufferedReader(new FileReader("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\Questions\\EasyAnswer.txt"));
        BufferedReader med = new BufferedReader(new FileReader("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\Questions\\Medium.txt"));
        BufferedReader med1 = new BufferedReader(new FileReader("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\Questions\\MediumAnswer.txt"));
        BufferedReader hard = new BufferedReader(new FileReader("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\Questions\\Hard.txt"));
        BufferedReader hard1 = new BufferedReader(new FileReader("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\Questions\\HardAnswer.txt"));
        Scanner sc = new Scanner(System.in);
        User user = new User(); //Instantiating a new User Object
        FileWriter fw = new FileWriter("C:\\Users\\Bishal\\Desktop\\Quiz Enigma\\ScoreBoard.txt",true);
        char[] x = new char[10];
        System.out.println("Welcome to the QuizMania");
        System.out.println("Enter your name");
        user.name = sc.nextLine();
        String userName = user.name.toUpperCase();
        System.out.println("Enter your semester");
        user.semester = sc.nextLine();
        System.out.println("Enter your section");
        user.section = sc.next().charAt(0);
        System.out.println("Enter your contact no.");
        user.contact = sc.nextLong();
        System.out.println("Press e to continue");
        String file1;
        String file2;
        boolean flag = true;
        int right=0, wrong=0;
        int i = 0;
        while (flag) { //input validation
            char e = sc.next().charAt(0);
            if (e == 'e') {
                flag = false; //to end the loop
                System.out.println("EASY ROUND");
                System.out.println("10 points for correct answer");
                char[] answer1 = {'c', 'd', 'a', 'a', 'c', 'b', 'a', 'c', 'd', 'c'};
                while ((file1 = easy.readLine()) != null) {
                    file2 = easy1.readLine();
                    //two files are being read simultaneously line by line until there is no text
                    System.out.println(file1);
                    System.out.println(file2);
                    char input = sc.next().charAt(0);
                    x[i] = input; // saving answers of user for each and every question in an array
                    if (input == answer1[i]) {
                        System.out.println("Correct answer, you earned 10 points ");
                        System.out.println();
                        right++;
                    } else {
                        System.out.println("Incorrect answer");
                        System.out.println("The correct option is "+answer1[i]);
                        System.out.println();
                        wrong++;
                    }
                    i++; // to refer the index of array
                }
            } else {
                System.out.println("Enter key e to continue");
            }
        }
        flag = true;
        user.easyTotal = easyPoint(x); // calling method easyPoint for points in round 1
        System.out.println("Summary of Round 1");
        System.out.println("Correct answers: "+right);
        System.out.println("Incorrect answers: "+ wrong);
        System.out.println("Congratulations " + userName + ",you have earned " + user.easyTotal + " points in Round 1");
        //writing in file
        fw.write("\n Participant name: "+userName);
        fw.write("\n Semester: "+user.semester);
        fw.write("\n Section: "+user.section);
        fw.write("\n Contact no.: "+user.contact);
        fw.write("\n");
        fw.write("\n Round 1");
        fw.write("\n Correct answers = "+right);
        fw.write("\n Incorrect answers = "+wrong);
        fw.write("\n Total score in round 1: "+ user.easyTotal);
        fw.write("\n");
        System.out.println();
        System.out.println("Let the round 2 begin");
        System.out.println("Press m to continue");
        right=0;
        wrong=0;
        while (flag) { //input validation
            char m = sc.next().charAt(0);
            if (m == 'm') {
                i=0;
                flag = false;
                System.out.println("WELCOME TO ROUND 2");
                System.out.println("-5 for wrong answer,10 for correct ");
                System.out.println();
                char[] answer2 = {'a', 'b', 'c', 'b', 'a', 'd', 'a', 'a', 'b', 'b'};
                while ((file1 = med.readLine()) != null) {
                    file2 = med1.readLine();
                    System.out.println(file1);
                    System.out.println(file2);
                    char input2 = sc.next().charAt(0);
                    x[i] = input2;
                    if (input2 == answer2[i]) {
                        System.out.println("Correct answer, you earned 10 points ");
                        System.out.println();
                        right++;
                    } else {
                        System.out.println("Wrong! Your point is deducted by 5 points.");
                        System.out.println("The correct option is "+answer2[i]);
                        System.out.println();
                        wrong++;
                    }
                    i++;
                }
            } else {
                System.out.println("enter the m key to continue");
            }
        }
        flag = true;
        user.midTotal = medPoint(x);
        System.out.println("Summary of Round 2");
        System.out.println("Correct answers: "+right);
        System.out.println("Incorrect answers: "+ wrong);
        System.out.println("Congratulations " + userName + ",you have earned " + user.midTotal + " points in round 2");
        fw.write("\n Round 2");
        fw.write("\n Correct answers = "+right);
        fw.write("\n Incorrect answers = "+wrong);
        fw.write("\n Total score in round 2: "+ user.midTotal);
        fw.write("\n");
        System.out.println();
        System.out.println("Let the round 3 begin");
        System.out.println("Press h to continue");
        right=0;
        wrong=0;
        while (flag) { //input validation
            char h = sc.next().charAt(0);
            if (h== 'h') {
                i=0;
                flag = false;
                System.out.println();
                System.out.println("Round 3");
                System.out.println("GO BIG OR GO HOME");
                System.out.println("20 points for correct answer, -10 for incorrect");
                System.out.println();
                char[] answer3 = {'b', 'c', 'b', 'b', 'c', 'd', 'a', 'b', 'b', 'd'};
                int count = 0; // for counting the number of times the lifeLine is used
                while ((file1 = hard.readLine()) != null) {
                    file2 = hard1.readLine();
                    System.out.println(file1);
                    System.out.println(file2);
                    fc++;
                    System.out.println();
                    if (count < 4) // to ensure the user can use its lifeLines only 4 times
                    {
                        System.out.println("Do you want to use lifeline?");
                        System.out.println("Press y for yes and n for no");
                        char lifeline = sc.next().charAt(0);
                        boolean temp = true;
                        while (temp) { //input validation
                            if (lifeline == 'y') {
                                count++; // counting use of lifeLine
                                lifeLine();
                                temp = false;
                            } else if (lifeline == 'n') {
                                temp = false;
                                System.out.println("Enter your option");
                            } else
                            {
                                System.out.println("Enter either Y or n ");
                                lifeline = sc.next().charAt(0);
                            }
                        }
                    }
                    char input3 = sc.next().charAt(0);
                    x[i] = input3;
                    if (input3 == answer3[i])
                    {
                        System.out.println("Correct answer, you earned 20 points! ");
                        System.out.println();
                        right++;
                    }
                    else
                    {
                        System.out.println("Wrong! Your point is deducted by 10 points.");
                        System.out.println("The correct option is "+answer3[i]);
                        System.out.println();
                        wrong++;
                    }
                    i++;
                }
            }
            else
            {
                System.out.println("enter the h key to continue");
            }
        }
        user.hardTotal = hardPoint(x);
        System.out.println("Summary of Round 3");
        System.out.println("Correct answers: "+right);
        System.out.println("Incorrect answers: "+ wrong);
        System.out.println("Congratulations " + userName + ",you have earned " + user.hardTotal + " points in round 3");
        fw.write("\n Round 3");
        fw.write("\n Correct answers = "+right);
        fw.write("\n Incorrect answers = "+wrong);
        fw.write("\n Total score in round 3: "+ user.hardTotal);
        fw.write("\n");
        System.out.println();
        System.out.println("Total points from all round is: ");
        user.total = user.easyTotal + user.midTotal + user.hardTotal;
        fw.write("\n Your total points from all the round is : "+user.total);
        fw.write("\n");
        System.out.println(user.total);
        System.out.println("\n Thank you for playing");
        fw.write("\n");
        fw.close(); // to end writing file
    }

    public static int easyPoint(char[] arr) {
        //For the calculation of points gained by user in round 1
        int point = 0;
        char[] answer = {'c', 'd', 'a', 'a', 'c', 'b', 'a', 'c', 'd', 'c'};
        /*created an array which is used to compared right answers
        by calling array of saved answer by user to give points.*/
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == answer[i]) {
                point += 10;
            }
        }
        return point;
    }

    public static int medPoint(char[] arr) {
        //For the calculation of points gained by user in round 2
        int point = 0;
        char[] answer = {'a', 'b', 'c', 'b', 'a', 'd', 'a', 'a', 'b', 'b'};
        /*created an array which is used to compared right answers
        by calling array of saved answer by user to give points.*/
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == answer[i]) {
                point += 10;
            } else if (arr[i] != answer[i]) {
                point -= 5;
            }
        }
        return point;
    }

    public static int hardPoint(char[] arr) {
        //For the calculation of points gained by user in round 3
        int point = 0;
        char[] answer = {'b', 'c', 'b', 'b', 'c', 'd', 'a', 'b', 'b', 'd'};
        /*created an array which is used to compared right answers
        by calling array of saved answer by user to give points.*/
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == answer[i]) {
                point += 20;
            } else if (arr[i] != answer[i]) {
                point -= 10;
            }
        }
        return point;
    }

    public static void lifeLine() {
        //For enabling the lifeline feature in round 3 to give user extra chances
        Random random = new Random();
        FiftyFifty fifty = new FiftyFifty();
        // Instantiating a new fifty Object
        Scanner sc2= new Scanner(System.in);
        Timer time=new Timer();
        //Class timer was used for counting time
        System.out.println("Which lifeline would you like to use?");
        boolean flag = true;
        for (String s : option) {
            System.out.print(s + " ");
        }
        System.out.println();
        int n = sc2.nextInt();
        while (flag) // input validation between 1 to 4
        {
            if (n > 0 && n <5) {
                flag = false;
            } else {
                System.out.println("Enter 1,2,3 or 4");
                n = sc2.nextInt();
            }
        }
        if (n == 1)
        {
            //random numbers are generated to act as public's vote
            int n1 = random.nextInt(100);
            int n2 = random.nextInt(100-n1);
            int n3 = random.nextInt(100-n1-n2);
            int n4 = 100-n1-n2-n3;
            System.out.println("The audience chooses as ");
            System.out.println("Option a ="+n1);
            System.out.println("Option b ="+n2);
            System.out.println("Option c ="+n3);
            System.out.println("Option d ="+n4);
            System.out.println();
            System.out.println("CAUTION, audience may be wrong!!!");
            System.out.println("Choose One Option");
        }
        else if(n==2)
        {
            System.out.println("Hello SOM sir, the participant needs your help.....");
            System.out.println("Choose One Option");
        }
        else if(n==3)
        {
            System.out.println("Enter your friend's phone no.");
            long number = sc2.nextLong();
            System.out.println("Dialing " + number +"......");
            System.out.println("You have 20 seconds to ask your friend.");
            time.schedule(new CountDown(), 1000, 1000);
            //CountDown class was inorder to print from 20 to 1, with delay 1000=1sec
        }
        else {
            System.out.println("Your two choices are: ");
            //using switch case to print 50-50 option for respective question
            switch (fc)
            {
                case 1:
                    fifty.setOne("a) 8 bit b) 16 bit");
                    System.out.println(fifty.getOne());
                    break;
                case 2:
                    fifty.setTwo("a)\" \" c)null");
                    System.out.println(fifty.getTwo());
                    break;
                case 3:
                    fifty.setThree("a)true  b) false");
                    System.out.println(fifty.getThree());
                    break;
                case 4:
                    fifty.setTwo("b) 1996 c) 1972");
                    System.out.println(fifty.getTwo());
                    break;
                case 5:
                    fifty.setTwo("a) static b) try");
                    System.out.println(fifty.getTwo());
                    break;
                case 6:
                    fifty.setTwo("c) a data container d) anything");
                    System.out.println(fifty.getTwo());
                    break;
                case 7:
                    fifty.setTwo("a) Compilation error c) num being 6.7");
                    System.out.println(fifty.getTwo());
                    break;
                case 8:
                    fifty.setTwo("b) James Gosling or d) Jim LeValley");
                    System.out.println(fifty.getTwo());
                    break;
                case 9:
                    fifty.setTwo("b) public or d)all of them");
                    System.out.println(fifty.getTwo());
                    break;
                case 10:
                    fifty.setTwo("a) Encapsulation or d) All of these");
                    System.out.println(fifty.getTwo());
                    break;
            }
        }

        for (int i = 0; i < option.length; i++) {
            if (n == (i + 1)) {
                option[i]="Already Used";
            }
        }
    }
}