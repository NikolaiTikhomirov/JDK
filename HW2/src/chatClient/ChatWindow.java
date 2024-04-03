package chatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    JPanel signInPanal = new JPanel(new GridLayout(2, 3));
    JTextField loginField = new JTextField();
    GhostText loginGhost = new GhostText(loginField, "Login");

    JPanel chatPanal = new JPanel(new GridLayout(1, 1));
    JTextField pswField = new JTextField();
    GhostText pswGhost = new GhostText(pswField, "Password");

    JTextField ipField = new JTextField();
    GhostText ipGhost = new GhostText(ipField, "Ip address");

    JTextField portNumField = new JTextField();
    GhostText portGhost = new GhostText(portNumField, "port");

    JButton btnLogin = new JButton("Подключиться");
    JButton btnLogout = new JButton("Отключиться");

    JTextArea textChat = new JTextArea();
    JScrollPane chatScrollPane = new JScrollPane(textChat);
    JPanel messagePanel = new JPanel(new GridLayout(1, 2));

    JTextField chatMessage = new JTextField();

    GhostText chatMessageGhost = new GhostText(chatMessage, "Введите сообщение");
    JButton pushMsg = new JButton("Отправить сообщение");

    Clickable server = new Server();
    private EnterAction enterAction = new EnterAction("Submit", this, server);

    public ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("GB_chat");
        setResizable(true);
        setVisible(true);

        signInPanal.add(loginField);
        signInPanal.add(pswField);
        signInPanal.add(ipField);
        signInPanal.add(portNumField);
        signInPanal.add(btnLogin);
        signInPanal.add(btnLogout);
        add(signInPanal, BorderLayout.NORTH);

        btnLogin.addActionListener(e -> {
            server.setPathChat(loginField.getText());
            server.loadChat(textChat);
        });
        btnLogout.addActionListener(e -> {
            server.setPathChat("");
            server.disconnectChat(textChat);
        });
        textChat.setEditable(false);

        chatPanal.add(chatScrollPane);
        add(chatPanal, BorderLayout.CENTER);

        messagePanel.add(chatMessage, BorderLayout.CENTER);
        messagePanel.add(pushMsg, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);
        pushMsg.addActionListener(e -> server.sendMessage(textChat, chatMessage));

        int condition = JComponent.WHEN_FOCUSED; // only want this when textarea has focus
        InputMap inputMap = chatMessage.getInputMap(condition); // get input and action maps
        ActionMap actionMap = chatMessage.getActionMap();
        // bind to the enter key stroke:
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        String key = enterStroke.toString();  // key to bind input to action
        // bind the enter key stroke to the enter action:
        inputMap.put(enterStroke, key);
        actionMap.put(key, enterAction);

    }
}
