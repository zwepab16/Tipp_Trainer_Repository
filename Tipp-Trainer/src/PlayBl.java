
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class PlayBl extends AbstractListModel {

    /**
     * The list and the current text varaible are here!
     */
    private ArrayList list = new ArrayList<File>();
    private String nowText;

    /**
     * Searches for all .txt files in the "levels" folder
     * and saves them into the list
     */
    public PlayBl() {

        File f = new File(".\\levels");
        File[] fileArray = f.listFiles();
        for (File file : fileArray) {
            if (file.getName().endsWith(".txt")) {
                list.add(file);
            }
        }
    }

    /**
     * 
     * @return Size of List 
     */
    @Override
    public int getSize() {
        return list.size();
    }

    /**
     * 
     * @param i The Selected Level
     * @return element at the right position! 
     */
    @Override
    public String getElementAt(int i) {
        return list.get(i).toString();
    }
/**
 * 
 * @param lvl The User's selected Level
 * @return The text from the selected Level from a .txt file!
 * @throws IOException 
 */
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

    /**
     * @return the Text the User is playing!
     */
    public String getNowText() {
        return nowText;
    }
    
    
    

}
