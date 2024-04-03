package chatClient;

import javax.swing.*;

public interface Clickable {
    void setPathChat (String login);
    void sendMessage(JTextArea textChat, JTextField chatMessage);
    void disconnectChat(JTextArea textChat);
    void loadChat(JTextArea textChat);
}
