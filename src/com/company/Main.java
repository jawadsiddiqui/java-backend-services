package com.company;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        AddData();
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
        System.out.println(extractAndSumNumbers("sandw3"));

        FunctionalInterface functionalInterface = t -> true;
        OptionalClassUsage();

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
            System.out.println(a.Name+" "+a.Phone+" "+a.Email);
        });

        //use of map
        Stream<NamePhoneDTO> streamNamePhone = mylist.stream().map(a-> new NamePhoneDTO(a.Name, a.Phone));
        streamNamePhone.forEach(a -> {
            System.out.println(a.Name+" "+a.Phone);
        });

        //map filter
        Stream<NamePhoneDTO> streamNamePhonefilter = mylist.stream().filter(a -> a.Name.equals("Jhon Doe")).map(a-> new NamePhoneDTO(a.Name, a.Phone));

        streamNamePhonefilter.forEach(a -> {
            System.out.println(a.Name+" "+a.Phone);
        });

        Stream<NamePhoneDTO> namePhone = mylist.stream().map(a-> new NamePhoneDTO(a.Name,a.Phone));

        List<NamePhoneDTO> list = namePhone.collect(Collectors.toList());

        for (NamePhoneDTO e: list){
            System.out.println(e.Name);
        }


//        LinkedList<NamePhoneDTO> npList = namePhone.collect(
//                () -> new LinkedList<>(),  //returns new linkedList
//                (l, elm) -> list.add(elm), //
//                (la, lb) -> la.addAll(lb)
//        );

    }
}
