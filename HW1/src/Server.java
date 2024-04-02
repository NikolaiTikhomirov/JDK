import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Server {
    String chatPath;

    public Server (){
        chatPath = "chat.txt";
    }

    public void loadChat (JTextArea textChat){
        try (
                FileInputStream fr = new FileInputStream(chatPath);
                InputStreamReader isr = new InputStreamReader(fr, StandardCharsets.UTF_8)){
            int b;
            while ((b = isr.read()) != -1) {
                textChat.append(Character.toString((char) b));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void sendMessage (JTextArea textChat, JTextArea chatMessage){
        try (
                FileOutputStream fos = new FileOutputStream(chatPath);
                OutputStreamWriter osr = new OutputStreamWriter(fos)){
            textChat.append(chatMessage.getText() + "\n");
            osr.append(textChat.getText());
            chatMessage.setText(null);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
