package Data;

import static Data.Event.delete;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {
    
    public EventTest() {
    }
 
    @Test
    public void testReOpen() throws ParseException {
        System.out.println("reOpen");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        e.addPerson("a");
        e.addPerson("b");
        e.addPerson("c");
        e.addPerson("d");
        e.addPerson("e");
        Event after = new Event();
        after.reOpen(e);
        assertEquals(e.toString(),after.toString());
    }

    @Test
    public void testAddPerson() throws ParseException {
        System.out.println("addPerson");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        e.addPerson("a");
        StringBuilder build = new StringBuilder();
        build.append("test");
        build.append("\n");
        build.append("test/json");
        build.append("\n");
        build.append("json");
        build.append("  ");
        SimpleDateFormat out1 = new SimpleDateFormat("HH:mm");
        build.append(out1.format(t));
        build.append("\n");
        build.append("a");
        build.append("\n");
        assertEquals(e.toString(), build.toString());
    }

    @Test
    public void testDelPerson() throws ParseException {
        System.out.println("delPerson");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        e.addPerson("a");
        e.addPerson("b");
        e.delPerson("a");
        StringBuilder build = new StringBuilder();
        build.append("test");
        build.append("\n");
        build.append("test/json");
        build.append("\n");
        build.append("json");
        build.append("  ");
        SimpleDateFormat out1 = new SimpleDateFormat("HH:mm");
        build.append(out1.format(t));
        build.append("\n");
        build.append("b");
        build.append("\n");
        assertEquals(e.toString(), build.toString());
    }

    @Test
    public void testGetPersons() throws ParseException {
        System.out.println("getPersons");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        e.addPerson("a");
        e.addPerson("b");
        ArrayList<String> ex = new ArrayList();
        ex.add("a");
        ex.add("b");
        assertEquals(e.getPersons(), ex);
    }

    @Test
    public void testReName() throws Exception {
        System.out.println("reName");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        File f = new File("oldPaths");
        f.mkdir();
        e.reName("new name");
        assertEquals(e.eventName, "new name");
        for (File d: f.listFiles())
            d.delete();
        f.delete();
    }

    @Test
    public void testReTime() throws Exception {
        System.out.println("reTime");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        String newTime = "11_46";
        Date _t = out.parse(newTime);
        File f = new File("oldPaths");
        f.mkdir();
        e.reTime(_t);
        assertEquals(out.format(e.time), out.format(_t));
        for (File d: f.listFiles())
            d.delete();
        f.delete();
    }

    @Test
    public void testDelete() throws ParseException, IOException {
        System.out.println("delete");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_46";
        Date t = out.parse(time);
        Event e = new Event("test/json", "test", "json", t);
        Converter.toJSON(e);
        delete(e);
        File f = new File(e.path);
        assertEquals(f.exists(), false);
    }
}
