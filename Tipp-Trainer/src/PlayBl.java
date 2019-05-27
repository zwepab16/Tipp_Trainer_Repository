
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class PlayBl extends AbstractListModel {

    private ArrayList list = new ArrayList<File>();
    private String nowText;

    public PlayBl() {

        File f = new File(".\\levels");
        File[] fileArray = f.listFiles();
        for (File file : fileArray) {
            if (file.getName().endsWith(".txt")) {
                list.add(file);
            }
        }
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public String getElementAt(int i) {
        return list.get(i).toString();
    }

    public String enterGame(int lvl) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader((File)list.get(lvl)));

        String content="";
        String line;

        while ((line = reader.readLine()) != null) {
            content+=line;
         
        }
        nowText=content;
        return content;

    }

    public String getNowText() {
        return nowText;
    }
    
    
    

}
