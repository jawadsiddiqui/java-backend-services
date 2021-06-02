package com.company;

public class Main {

    public static void main(String[] args) {
        StreamClass.CheckStream();
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


    }

    private static void LCM(int n1, int n2){
        int lcm = (n1 > n2) ? n1 : n2;
        // Always true
        while(true) {
            if( lcm % n1 == 0 && lcm % n2 == 0 ) {
                System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
                break;
            }
            ++lcm;
        }
    }


    private static void calLCMByGCD(int n1, int n2){
        int gcd = 1;
        for(int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if(n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }

        int lcm = (n1 * n2) / gcd;
        System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
    }


    private static void findGCD(int n1, int n2){
        int gcd = 1;
        for(int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if(n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }
        System.out.printf("The LCM of %d and %d is %d.", n1, n2, gcd);
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
}
