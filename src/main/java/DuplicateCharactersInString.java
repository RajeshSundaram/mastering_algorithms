import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class DuplicateCharactersInString {

    public static void main(String[] args) {
        String input = "abcdefabcdf";
        Character[] duplicates = findDuplicateChars(input);
        for(char c: duplicates) {
            System.out.print(c + " ");
        }
        IntStream.range(1,5).forEach(i -> System.out.println());
        findDuplicateUsingSpace(input);
    }

    private static void findDuplicateUsingSpace(String input) {
        Set<Character> duplicates = new HashSet<>();
        List<Character> nonDuplicates = new ArrayList<>();
        for(char c : input.toCharArray()) {
            if(!nonDuplicates.contains(c)) {
                nonDuplicates.add(c);
            } else {
                duplicates.add(c);
            }
            if(duplicates.contains(c)) {
                nonDuplicates.remove((Character) c);
            }
        }
        duplicates.forEach(System.out::print);
    }

    private static Character[] findDuplicateChars(String input) {
        input = input.toLowerCase();
        char[] inputChars = input.toCharArray();
        Set<Character> duplicates = new HashSet<>();
        for(char c: inputChars) {
            if(!duplicates.contains(c)) {
                if(input.indexOf((int)c) != input.lastIndexOf((int)c)) {
                    duplicates.add(c);
                }
            }
        }
        return duplicates.toArray(new Character[duplicates.size()]);
    }


}
