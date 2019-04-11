import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

public class CatsPerYear {
    private ArrayList<CatDatum> cats;

    public CatsPerYear() {
        cats = new ArrayList<CatDatum>();
        TextAnalysisApp app = TextAnalysisApp.getApp();
        Table table = app.loadTable("CatsPerYear.csv", "header");
        for (TableRow row : table.rows()) {
            int year = row.getInt("year");
            float cat = row.getFloat("cats");
            cats.add(new CatDatum(year, cat));
        }
        System.out.println("Imported cat data");
    }
}
