package com.algoexperts;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String string = "abcfbbbbbbbbbbbvvvvvvvvbbbbbbbacd";
        long time = System.currentTimeMillis();
        System.out.println(firstNonRepeatingCharacter(string));
        System.out.println(System.currentTimeMillis()-time + " milisecond");
        System.out.println(firstNonRepeatingCharacterSecondSolution(string));
    }

    public static int firstNonRepeatingCharacter(String string) {
        int i=0;

        while(i<string.length()){
            boolean duplicate = false;
            for(int j=0;j<string.length();j++){
                if(string.charAt(i)==string.charAt(j) && i!=j){
                    duplicate = true;
                }
            }
            if(!duplicate) { return i; };
            i++;
        }
        return -1;
    }

    /**
     * O(n) time | O(1) space
     * @param string
     * @return
     */
    public static int firstNonRepeatingCharacterSecondSolution(String string) {
        for (int i = 0; i < string.length() ; i++) {
            boolean duplicate = false;
            for (int j = i+1; j < string.length(); j++) {
                if(string.charAt(i)==string.charAt(j)){
                    duplicate = true;
                }
            }
            if(!duplicate) { return i; };
        }
        return -1;
    }
}


