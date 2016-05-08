package mainSource;

import Data.Converter;
import Data.Event;
import Visual.MainFrame;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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

    public static String getDir(MainFrame frame, JButton b){
        String s;
        s = b.getText() + "_"
          + frame.monthLabel.getText() + "_"
          + frame.yearLab.getText();
        return s;
    }

    public static void getEvents(ArrayList<String> list, String dir){
        File f = new File(dir);
        if (f.isDirectory()){
            list.clear();
            Collections.addAll(list, f.list());
        }
    }
    
    public static void setEvents(JList<String> list, ArrayList<String> listData){
        String[] s = new String[listData.size()];
        int i = 0;
        for (String event: listData){
            if (event.length() > 6){
                StringBuilder sb = new StringBuilder();
                sb.append(event);
                sb.setCharAt(sb.length()-3,':');
                sb.setCharAt(sb.length()-6,' ');
                s[i] = sb.toString();
                i++;
            }
        }
        list.setListData(s);
    }
    
    public static String getEvent(String text){
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.setCharAt(sb.length()-3,'_');
        sb.setCharAt(sb.length()-6,'_');
        return sb.toString();
    }
    
    public static String getName(String text){
        return text.replaceAll("_", " ");
    }
    
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
    
    public static boolean isTime(String t){
        
        if (t.length() != 5) return false;
        int h1 = Character.getNumericValue(t.charAt(0));
        int h2 = Character.getNumericValue(t.codePointAt(1));
        char h = t.charAt(2);
        int m1 = Character.getNumericValue(t.codePointAt(3));
        int m2 = Character.getNumericValue(t.codePointAt(4));
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
        
    public static boolean createNew(String time, String name, String dir) 
                       throws ParseException, IOException
    {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date t = f.parse(time);
        if (!isTime(time)){
           t = f.parse("ERROR");
        }
        f = new SimpleDateFormat("HH_mm");
        String path = dir + "/" + name + "_" + f.format(t);
        File ev = new File(path);
        if (ev.exists()){
            return false;
        }
        Event e = new Event(path, dir, name, t);
        Converter.toJSON(e);
        return true;
    }
    
    public static void delete(String time, String name, String dir) 
                       throws ParseException, IOException
    {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date t = f.parse(time);
        if (!isTime(time)){
           t = f.parse("ERROR");
        }
        f = new SimpleDateFormat("HH_mm");
        String path = dir + "/" + name + "_" + f.format(t);
        File ev = new File(path);
        if (ev.exists()){
            ev.delete();
        }
    }
}
