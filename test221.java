import org.apache.commons.text.similarity.LevenshteinDistance;
public class test221 {
    public static void main(String[] args) {
        LevenshteinDistance ld = new LevenshteinDistance();
        int distance = ld.apply("kitten", "sitting");
        System.out.println("Levenshtein Distance: " + distance); // Output: 3
    }
}

