import java.util.ArrayList;

public class SearchingMethods {
    public SearchingMethods(){
    }

    public static int search(ArrayList<String> words, String key){
        return SearchingMethods.linearSearch(words, key);
        //return SearchingMethods.binarySearch(words, key);
    }

    private static int linearSearch(ArrayList<String> words, String key){
        int i = 0;
        boolean found = false;
        int position = -1;
        while (i < words.size() && !found) {
            if (words.get(i).equals(key)) {
                position = i;
                found = true;
            }
            i++;
        }
        return position;
    }

    private static int binarySearch(ArrayList<String> words, String key) {
        int low = 0;
        int high = words.size() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            String cur = words.get(mid);

            if(cur.equals(key)) {
                return mid;
            } else if(cur.compareToIgnoreCase(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
