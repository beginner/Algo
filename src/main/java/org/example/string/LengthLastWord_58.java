package org.example.string;

public class LengthLastWord_58 {

    public static void main(String[] args) {
        LengthLastWord_58 problem = new LengthLastWord_58();
        String s = "a";
        System.out.println(problem.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        int read = s.length() - 1;

        // Clear spaces from right
        while (s.charAt(read) == ' ') read--;

        int end = read;
        for (int i = read; i >=0; i--) {
            char c = s.charAt(i);
            if (c == ' ') return end - i; // word ended here hence we return since we have to return the last word length
        }
        // That means this was the only word so length is end + 1
        return end + 1;
    }
}
