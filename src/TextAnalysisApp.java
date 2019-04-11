import processing.core.PApplet;
import java.util.ArrayList;

public class TextAnalysisApp extends PApplet {
    private static TextAnalysisApp app;
    private WordBank wordBank;
    //private CatsPerYear catData;

    public static void main(String[] args){
        PApplet.main("TextAnalysisApp");
    }

    public TextAnalysisApp(){
        app = this;
    }

    public void settings(){
        size(1000, 500);
    }

    public void setup(){
        // catData = new CatsPerYear();
        wordBank = new WordBank();
        System.out.println("maternal is at " + wordBank.find("maternal")); // 1376
    }

    public void draw(){
        background(255);
        ArrayList<WordOccurrence> wordOccurrences = wordBank.getWordOccurrences();
        for (WordOccurrence wordOccurrence : wordOccurrences){
            float x = random(width);
            float y = random(height);
            float diameter = wordOccurrence.getOccurrences() * 10;
            noFill();
            ellipse(x, y, diameter, diameter);
            textAlign(CENTER);
            textSize(diameter/2);
            fill(0, 150);
            text(wordOccurrence.getWord(), x, y);
        }


        noLoop();
    }

    public static TextAnalysisApp getApp(){
        return app;
    }
}
