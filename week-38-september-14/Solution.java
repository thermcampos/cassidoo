

public class Solution {
    public static void main(String[] args) {
        System.out.println("Longest in order for [The autumn leaves almost glow.]=" + normalize("The autumn leaves almost glow."));
        System.out.println("Longest in order for [A cool sheep sleeps.]=" + normalize("A cool sheep sleeps."));
        System.out.println("Longest in order for [The nearly empty room held only a dusty, forgotten book.]=" + normalize("The nearly empty room held only a dusty, forgotten book."));
        System.out.println("Longest in order for [She always believed that effort and honesty would eventually bring success.]=" + normalize("She always believed that effort and honesty would eventually bring success."));
        System.out.println("Longest in order for [In a big, hot desert, the lone traveler found a small, cool spot.]=" + normalize("In a big, hot desert, the lone traveler found a small, cool spot."));
    }

    /**
     * Normalize a text, breaking it in words and making it
     * all lowercase. Also dropping all non-letter characters.
     * Note that words are 2 length minimum. 
     *
     * @param text The text to be normalized.
     * @return Array of Strings containings words (2 letters or more)
     */
    private static String normalize(String text) {
        String word = "";

        boolean DEBUG = false;
        
        int last = 0;
        int len = text.length();
        String biggestWord = "";
        for (int i=0; i<len; i++) {
            char currentChar = text.charAt(i);
            if (DEBUG) {
                System.out.println("currentChar=[" + currentChar + "] - biggestWord=[" + biggestWord + "]");
            }
            int intValue = (int) currentChar;
            char validChar = ' ';
            if (intValue >= 65 && intValue <= 90) {
                validChar = (char) (currentChar + 32);
                intValue = (int) validChar;
            }
            
            // if value is lowercase, consider it too
            else if (intValue >= 97 && intValue <= 122) {
                validChar = currentChar;
            }

            // if it's valid, save it and go to next
            if (validChar != ' ') {
                if (DEBUG) {
                    System.out.println("validChar is valid=[" + validChar + "] --- debug word=[" + word + "] and biggestWord=[" + biggestWord + "]");
                }
                // core: validates next
                if (intValue >= last) {
                    if (DEBUG) {
                        System.out.println("-- Current is bigger than last - current=[" + intValue + "], last=[" + last + "]");
                    }
                    word += validChar;
                    last = intValue;

                    // check if current word is bigger than last one
                    if (word.length() > 1 && word.length() > biggestWord.length()) {
                        biggestWord = word;
                        if (DEBUG) {
                            System.out.println("## new 1 biggestWord=[" + biggestWord + "]");
                        }
                    }
                } else {
                    // check if current word is bigger than last one
                    if (word.length() > 1 && word.length() > biggestWord.length()) {
                        biggestWord = word;
                        if (DEBUG) {
                            System.out.println("## new 2 biggestWord=[" + biggestWord + "]");
                        }
                    }

                    if (DEBUG) {
                        System.out.println("-- Current is NOT bigger than last - current=[" + intValue + "], last=[" + last + "]");
                    }
                    // discard the word (find the next blank space and go there)
                    int nextWord = text.indexOf(" ", i);
                    if (nextWord > -1) {
                        if (DEBUG) {
                            System.out.println("Go to 1 - index=[" + nextWord + "] from current index=[" + i + "]");
                        }
                        i = nextWord;
                        word = "";
                        last = 0;
                        //biggestWord = "";
                        if (DEBUG) {
                            System.out.println("\n\n");
                        }
                    } else {
                        break;
                    }
                }
            }

            // if it's a blank space, break the word
            if (intValue == 32) {
                if (DEBUG) {
                    System.out.println("#####");
                }
                if (word.length() > 1 && word.length() > biggestWord.length()) {
                    biggestWord += word;
                    if (DEBUG) {
                        System.out.println("## new biggestWord=[" + biggestWord + "]");
                    }
                } else {
                    word = "";
                    last = 0;
                    if (DEBUG) {
                        System.out.println("\n\n");
                    }
                }
            }
        }

        return biggestWord;
    }
}
