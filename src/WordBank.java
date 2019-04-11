import java.util.ArrayList;
import java.util.Arrays;

public class WordBank implements Searchable, Sortable {
    private ArrayList<String> wordBank;
    private ArrayList<WordOccurrence> wordOccurrences;

    public WordBank(){
        wordBank = generateWordBank();
        sort(); // sorts the generated word bank alphabetically
        wordOccurrences = generateWordOccurrences();
    }

    public ArrayList<WordOccurrence> getWordOccurrences(){
        return wordOccurrences;
    }

    public int find(String key){
        return SearchingMethods.search(wordBank, key);
    }

    public void sort(){
        SortingMethods.sort(wordBank);
    }

    private ArrayList<String> generateWordBank(){
        TextAnalysisApp app = TextAnalysisApp.getApp();
        //String url = "http://www.gutenberg.org/files/1321/1321-0.txt";
        String url = "data/WasteLand.txt";
        String[] rawtext = app.loadStrings(url);
        String everything = app.join(rawtext, "");
        String delimiters = " ,.?!;:[](){}'’“”\"\\/-*_1234567890\t";
        String[] allwords = app.splitTokens(everything, delimiters);
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < allwords.length; i++){
            String s = allwords[i];
            words.add(s);
        }
        return words;
    }

    private ArrayList<WordOccurrence> generateWordOccurrences(){
        long start = System.nanoTime();
        sort();
        long finish = System.nanoTime();
        System.out.println(finish - start);

        ArrayList<WordOccurrence> wordOccurrences = new ArrayList<WordOccurrence>();
        String currentWord = wordBank.get(0);
        int count = 1;
        for (int i = 1; i < wordBank.size(); i++){
            if (!wordBank.get(i).equalsIgnoreCase(currentWord)){
                addWordOccurrence(wordOccurrences, new WordOccurrence(currentWord, count));
                currentWord = wordBank.get(i);
                count = 1;
            } else {
                count++;
            }
        }
        return wordOccurrences;
    }

    private void addWordOccurrence(ArrayList<WordOccurrence> wordOccurrences, WordOccurrence wordOccurrence){
        int i = 0;
        boolean inserted = false;
        while (!inserted && i < wordOccurrences.size()){
            if (wordOccurrence.getOccurrences() < wordOccurrences.get(i).getOccurrences()){
                i++;
            } else {
                wordOccurrences.add(i, wordOccurrence);
                inserted = true;
            }
        }
        if (i ==  wordOccurrences.size()){ // insertion at end (including first insertion)
            wordOccurrences.add(wordOccurrence);
        }
    }
}