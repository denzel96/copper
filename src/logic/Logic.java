package logic;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.LinkedList;

public class Logic {
    public static LinkedList<String> copper = new LinkedList<>();
    private String currentContent = "";

    public Logic() {
        Thread t = new Thread(() -> {
            while (true) {
                String copied = getClipboardContent();
                if (!currentContent.equals(copied)) {
                    currentContent = copied;
                    if (!copper.contains(currentContent)) {
                        copper.add(copied);
                    }
                    System.out.println("added: " + getClipboardContent());
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(copper);
            }
        });
        t.run();
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

    public static void paste(Integer i) {
        putOntoClipboard(copper.get(i));
    }

    private static void putOntoClipboard(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
