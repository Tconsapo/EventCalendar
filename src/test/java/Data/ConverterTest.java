package Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConverterTest {
    
    public ConverterTest() {
    }
    
    @Test
    public void testToJSON() throws Exception {
        System.out.println("toJSON");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event event = new Event("test/json", "test", "json", t);
        Converter.toJSON(event);
        Event javaObject = Converter.toJavaObject(event.path);
        assertEquals(javaObject.toString(), event.toString());
    }

    @Test
    public void testToJavaObject() throws Exception {
        System.out.println("toJavaObject");
        SimpleDateFormat out = new SimpleDateFormat("HH_mm");
        String time = "11_00";
        Date t = out.parse(time);
        Event event = new Event("test/json", "test", "json", t);
        Converter.toJSON(event);
        Event javaObject = Converter.toJavaObject(event.path);
        assertEquals(javaObject.toString(), event.toString());
    }
    
}
