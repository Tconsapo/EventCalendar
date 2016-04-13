/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainSource;

import Data.Converter;
import Data.Event;
import Visual.MainFrame;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JList;



public class DataWorker {
    
    
    public static String getDir(MainFrame frame, int n){
        String s;
        s = frame.dates.get(n).getText() + "_"
          + frame.monthLabel.getText() + "_"
          + frame.yearLab.getText();
        return s;
    }
    
    /**
     *
     * @param frame
     * @param b
     * @return
     */
    public static String getDir(MainFrame frame, JButton b){
        String s;
        s = b.getText() + "_"
          + frame.monthLabel.getText() + "_"
          + frame.yearLab.getText();
        return s;
    }
    
    /**
     *
     * @param list
     * @param dir
     */
    public static void getEvents(JList<String> list, String dir){
        File f = new File(dir);
        if (f.isDirectory()){
            list.setListData(f.list());
        }
    }
    
    /**
     *
     * @param frame
     * @param n
     * @return
     */
    public static boolean isEventEx(MainFrame frame, int n){
        File f = new File(DataWorker.getDir(frame, n));
        if (f.isDirectory()){
            String[] s = f.list();
            try {
                return !s[0].isEmpty();
            }catch(java.lang.ArrayIndexOutOfBoundsException ex){
                return false;
            }
        }
        else return false;
    }
    
    private static boolean isTime(String t){
        
        int h1 = t.codePointAt(0) - 48;
        int h2 = t.codePointAt(1) - 48;
        char h = t.charAt(2);
        int m1 = t.codePointAt(3) - 48;
        int m2 = t.codePointAt(4) - 48;
        if (h != ':'){
            return false;
        }
        if ((h1 >= 0)&&(h1 < 2)){
            if ((h2 >=0)&&(h2 <= 9)){
                if ((m1 >= 0)&&(m1 <= 5)){
                    if ((m2 >= 0)&&(m2 <= 9)){
                        return true;
                    }
                }
            }
        }
        if (h1 == 2){
            if ((h2 >=0)&&(h2 <= 3)){
                if ((m1 >= 0)&&(m1 <= 5)){
                    if ((m2 >= 0)&&(m2 <= 9)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
        
    public static void createNew(String time, String name, String dir) 
                       throws ParseException, IOException
    {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date t = f.parse(time);
        if (!isTime(time)){
           t = f.parse("ERROR");
        }
        f = new SimpleDateFormat("HH_mm");
        String path = dir + "/" + name + "_" + f.format(t);
        Event e = new Event(path, dir, name, t);
        Converter.toJSON(e);
    }
    
}
