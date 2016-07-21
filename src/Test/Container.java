package Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;

@SaveTo(path = "C:\\test.txt")
public class Container {
    String s="in file";

    @Saver
    public void save(String path) throws IOException {
        FileWriter f = new FileWriter(path);
        try {
            f.write(s);
            System.out.println("done");
        } finally {
            f.close();
        }
    }
}
