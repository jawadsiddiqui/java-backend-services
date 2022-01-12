package com.algoexperts;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String string = "abcfacd";
        System.out.println(firstNonRepeatingCharacter(string));

    }

    public static int firstNonRepeatingCharacter(String string) {
        int i=0;

        while(i<string.length()){
            boolean duplicate = false;
            for(int j=0;j<string.length();j++){
                if(string.charAt(i)==string.charAt(j) && i!=j){
                    System.out.println(string.charAt(i) + "" + string.charAt(j));
                    duplicate = true;
                }
            }
            if(!duplicate) { return i; };
            i++;
        }
        return -1;
    }
}
