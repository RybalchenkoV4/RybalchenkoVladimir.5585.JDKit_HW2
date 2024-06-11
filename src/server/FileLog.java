package server;

import java.io.FileReader;
import java.io.FileWriter;

public class FileLog implements Repository<String>{
    private static final String LOG_PATH = "src/server/log.txt";

    @Override
    public void save(String message) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
        writer.write(message + "\n");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String load() {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                sb.append((char) c);
            }
            sb.delete(sb.length()-1, sb.length());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
