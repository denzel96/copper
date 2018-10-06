import gui.MainFrame;
import logic.Logic;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.LinkedList;


//TODO:
/*
 fut a hatterben
 egy listaban eltarolja a szövegeket es a html kodokat
 mindig lathato az ablak, ez legyen kapcsolhato
 ha mindig lathato. akkor legyen az ablak szelehez dokkolva
 ha ketszer kattint a user egy eltarolt elemre, az szurodjon be
 */

//Működés:
// 1. user kimásol valamit a vágólapra
// 2. bekerül a listába
// 3. megjelenik a gui-n
// 4. ha be akarja illeszteni, akkor kétszer rákattint a lista elemére





public class Main {
    private static LinkedList<String> clipList = new LinkedList<>();

    public static void main(String[] args) {
        Logic l = new Logic();
        new MainFrame();


    }

//    public static void copy() {
//        StringSelection stringSelection = new StringSelection();
//        if (!clipList.contains(stringSelection.toString())) {
//            clipList.add(stringSelection.toString());
//        }
//    }

    public static void paste(Integer i) {
        putOntoClipboard(clipList.get(i));
    }

    public static void putOntoClipboard(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


}
