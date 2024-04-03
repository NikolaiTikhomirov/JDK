package chatClient;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Server implements Clickable{
    String chatPath;

    public Server (){
    }

    @Override
    public void setPathChat (String login){
        chatPath = login + "chat.txt";
    }

    @Override
    public void loadChat (JTextArea textChat){
        try (
                FileInputStream fr = new FileInputStream(chatPath);
                InputStreamReader isr = new InputStreamReader(fr, StandardCharsets.UTF_8)){
            int b;
            while ((b = isr.read()) != -1) {
                textChat.append(Character.toString((char) b));
            }
        } catch (IOException ex) {
            JTextArea newChat = new JTextArea();
            sendMessage(newChat);
            System.out.println("new chat created");
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void disconnectChat(JTextArea textChat){
        textChat.setText(null);
    }

    @Override
    public void sendMessage (JTextArea textChat, JTextField chatMessage){
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
    public void sendMessage (JTextArea textChat){
        try (
                FileOutputStream fos = new FileOutputStream(chatPath);
                OutputStreamWriter osr = new OutputStreamWriter(fos)){
            textChat.append("");
            osr.append(textChat.getText());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
