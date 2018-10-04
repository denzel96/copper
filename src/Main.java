import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Timer;

public class Main {
    private static LinkedList<String> clipList = new LinkedList<>();

    public static void main(String[] args) {
        String myString = "This text will be copied into clipboard when running this code!";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

//    public static void copy() {
//        StringSelection stringSelection = new StringSelection();
//        if (!clipList.contains(stringSelection.toString())) {
//            clipList.add(stringSelection.toString());
//        }
//    }

    public static void paste(Integer i) {
        String toPaste = clipList.get(i);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(toPaste), null);
    }


}
