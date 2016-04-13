//преобразователь событий

package Data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Converter {
    //в json объект
    public static void toJSON(Event event) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File f = new File(event.dir);
        if (!f.isDirectory()){
            f.mkdir();
        }
        mapper.writeValue(new File(event.path), event);
    }
    //в java объект
    public static Event toJavaObject(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), Event.class);
    }

    private Converter() {
    }
    
}
