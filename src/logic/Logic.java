package logic;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.LinkedList;

public class Logic {
    public LinkedList<String> copper = new LinkedList<>();

    public static Boolean startedRecording = false;
    private String currentContent = "";

    public Logic() {
        while (startedRecording) {
            try {
                Thread.sleep(300);
                if (!getClipboardContent().equals(currentContent)) {
                    System.out.println(getClipboardContent());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getClipboardContent() {
        try {
            return (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "---";
    }

    public static void powerButtonPushed() {
        startedRecording = !startedRecording;
    }

//    public void copy(){
//        StringSelection ss = new StringSelection();
//        if (!copper.contains(ss.toString())){
//            copper.add(ss.toString());
//        }
//    }


}
