//класс события
package Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Event {
    //Путь к файлу
    @JsonProperty("path")
    public String path;
    //Папка с файлом (день)
    @JsonProperty("Dir")
    public String dir;
    //Имя события
    @JsonProperty("eventName")
    public String eventName;
    //Время события
    @JsonProperty("Time")
    public Date time;
    //Список участников
    @JsonProperty("persons")
    private ArrayList<String> persons;
    
    public Event(){
        
    }
    
    //(путь, папка, имя, время)
    public Event(String s, String d, String e, Date t){
        this.path = s;
        this.dir = d;
        this.eventName = e;
        this.time = t;
        persons = new ArrayList();
    }
    
    public Event(Event e){
        this.path = e.path;
        this.dir = e.dir;
        this.eventName = e.eventName;
        this.persons = e.getPersons();
        this.time = e.time;
    }
    
    //обновление события
    public void reOpen(Event e){
        this.path = e.path;
        this.dir = e.dir;
        this.eventName = e.eventName;
        this.persons = e.getPersons();
        this.time = e.time;
    }
    //добавление участника
    public void addPerson(String name){
        this.persons.add(name);
    }
    //удаление участника
    public void delPerson(String name){
        this.persons.remove(name);
    }
    //передача списка участников
    public ArrayList<String> getPersons(){
        return this.persons;
    }   
    //изменение имени события
    public void reName(String name) throws IOException{
        Event e = new Event(this);
        e.eventName = name;
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        e.path = e.dir + "/" + e.eventName + "_" + out.format(e.time);
        Converter.toJSON(e);
        delete(this);
        this.reOpen(Converter.toJavaObject(e.path));
    }
    //изменение времени события
    public void reTime(Date t) throws IOException{
        Event e = new Event(this);
        e.time = t;
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        e.path = e.dir + "/" + e.eventName + "_" + out.format(e.time);
        Converter.toJSON(e);
        delete(this);
        this.reOpen(Converter.toJavaObject(e.path));
    }
    //удаление файла
    public static void delete(Event e){
        File f = new File(e.path);
        f.delete();
    }
      
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(this.dir);
        build.append("\n");
        build.append(this.path);
        build.append("\n");
        build.append(this.eventName);
        build.append("  ");
        SimpleDateFormat out = new SimpleDateFormat("HH:mm");
        build.append(out.format(time));
        build.append("\n");
        for (Object person: persons) {
            build.append(person);
            build.append("\n");
        }
        return build.toString();
    }
}
