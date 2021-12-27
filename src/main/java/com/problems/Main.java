package com.problems;

import com.javafeatures.MethodReference;
import com.javafeatures.Sayable;
import com.problems.dto.*;


import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Method reference
        Sayable sayable = MethodReference::staticMethodExample;
        sayable.say();



        //AddData();
        //StreamClass.CheckStream();
        //StreamClass.reduceExamples();
	    // write your code here
        //AddTwoBinaryNumbers("11","1" );
        //Java8Demo.ListMethod();
        //System.out.println(calLCM(1,2));
       // matrix();
        //findGCD(24,18);
        //removeDuplicateFromSortedArray();

        //how to use genericClass
//        GenericClass<String> genObject;
//        genObject = new GenericClass<>("");
//        genObject.showType();

//        TwoParamGenClass<String, Integer> twoParamGenClass;
//        twoParamGenClass = new TwoParamGenClass<>("", 1);
//        twoParamGenClass.showType();
        //System.out.println(getGCD(2,23));
        //System.out.println(extractAndSumNumbers("sandw3"));



        //OptionalClassUsage();

        //System.out.println("strawberries".substring(2,5));

        //Optional<String> empty = Optional.empty();

        //local thread test
        //ThreadTest();

        //map
        //MapFunction();

        //System.out.println(convertToASCII("Z"));
        //

        int n = 2, m = 15;
        char arr[][] = { { '.', '.', '.', '.', '.',
                '#', '#', '#',
                '#', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '#', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.' } };

        System.out.println(maximumBoarders(n, m, arr));

    }

    private static int maximumBoarders(int n, int m, char[][] arr) {
        int ans = 0, blackWall = 0, whiteWall =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //only first line
                if(i==0 && arr[i][j]=='#'){
                 blackWall++;
                 continue;
                }

                if(arr[i][j]!='.'){
                    blackWall++;
                }
                else {
                    whiteWall++;

                }

                ans = Math.max(blackWall, whiteWall);


            }
        }
        return ans;
    }


    private static int convertToASCII(String a){
        char c = a.charAt(0);
        return (int) c;
    }

    private static void MapFunction() {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
    }

    //You can implement the Runable interface
    //you can extend the Thread class itself
    public static void ThreadTest(){
        Thread t = Thread.currentThread();
        System.out.println(t);

        t.setName("MyNewThread");
        System.out.println(t);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(3000);
            }

            //
        }catch (InterruptedException ie){
            System.out.println("Main Interruption");
        }
    }

    public static void OptionalClassUsage(){
        String[] words = new String[10];
        //String word = words[5].toLowerCase(); //Exception in thread "main" java.lang.NullPointerException
        //System.out.print(word);

        Optional<String> checkNull =
                Optional.ofNullable(words[5]);

        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        } else
            System.out.println("word is null");
    }

    public static int extractAndSumNumbers(String s1){
        String[] numbersOnlyS1 = s1.replaceAll("[^0-9]","").split("");
        System.out.println(numbersOnlyS1.length);
        int sumOfNumbersInS1 = 0;
        for (String n: numbersOnlyS1) {
            sumOfNumbersInS1 += Integer.parseInt(n);
        }


        return sumOfNumbersInS1;


    }

    public static int getGCD(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGCD(n2, n1 % n2);
    }

    public static int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            return 0;
        else {
            int gcd = getGCD(n1, n2);
            return Math.abs(n1 * n2) / gcd;
        }
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;

        // Get LCM of all elements of a
        int lcm = a.get(0);
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer);
        }

        // Get GCD of all elements of b
        int gcd = b.get(0);
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer);
        }

        // Count multiples of lcm that divide the gcd
        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;

            if (gcd % multiple == 0)
                result++;
        }

        return result;
    }

    private static void removeDuplicateFromSortedArray()
    {
        int[] nums  = {1,1,2};
        //created sorted array first

        for(int i=0; i<nums.length; i++){
            //1,1
            for(int j=i+1; j<nums.length; j++){
                //
                if(nums[i] == nums[j]){
                    System.out.print(nums[j]);
                }

            }


        }

    }


    private static void matrix(){
        int[][] board = new int[6][6];

        //filing matrix
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = row*col;
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }




    }

    private static int calLCM(int n1, int n2){
        int lcmRes = 0;
        int lcm = (n1 > n2) ? n1 : n2;
        // Always true
        while(true) {
            if( lcm % n1 == 0 && lcm % n2 == 0 ) {
                //System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
                lcmRes = lcm;
                break;
            }
            ++lcm;
        }
        return  lcmRes;
    }

    private static void AddTwoBinaryNumbers(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0){
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            sb.append(sum % 2);
            carry  = sum / 2;
            i--;
            j--;
        }
        if(carry != 0) sb.append(carry);
        System.out.println(sb.reverse().toString());
    }

    public static void AddData(){
        ArrayList<NamePhoneEmailDTO> mylist = new ArrayList<>();
        mylist.add(new NamePhoneEmailDTO("Jhon Doe","555-444-666","jhon@xyz.com"));
        mylist.add(new NamePhoneEmailDTO("Racy","444-666-777","racy@xyz.com"));

        System.out.println("Original Values");

        mylist.stream().forEach(a -> {
            System.out.println(a.getName()+" "+a.getPhone()+" "+a.getEmail());
        });

        //use of map
        Stream<NamePhoneDTO> streamNamePhone = mylist.stream().map(a-> new NamePhoneDTO(a.getName(), a.getPhone()));
        streamNamePhone.forEach(a -> {
            System.out.println(a.getName()+" "+a.getPhone());
        });


    }

    


}
