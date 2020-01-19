

public class ReverseWordsInASentence {

    public static void main(String[] args) {
        String sentence = "Hello I'am Rajesh";
        System.out.print(reverseWords(sentence));
    }

    private static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        for(int i = 0; i< words.length; ++i) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return String.join(" ", words);
    }
}
