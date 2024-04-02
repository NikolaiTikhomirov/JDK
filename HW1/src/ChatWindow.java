import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 100;
    JPanel panel = new JPanel(new GridLayout(1, 2));
    JLabel jlb1 = new JLabel("Введите логин: ");
    JTextField jtf1 = new JTextField();

    JPanel panel2 = new JPanel(new GridLayout(1, 2));
    JLabel jlb2 = new JLabel("Введите пароль: ");
    JTextField jtf2 = new JTextField();

    JPanel panel3 = new JPanel(new GridLayout(1, 2));
    JLabel jlb3 = new JLabel("Введите IP адрес сервера: ");
    JTextField jtf3 = new JTextField();

    JPanel panel4 = new JPanel(new GridLayout(1, 2));
    JLabel jlb4 = new JLabel("Введите номер порта: ");
    JTextField jtf4 = new JTextField();

    JButton btnLogin = new JButton("Подключиться");
    JTextArea textChat = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textChat);
    JPanel panelMain = new JPanel(new GridLayout(9, 1));

    JLabel jlb6 = new JLabel("Введите ваше сообщение: ");
    JTextArea chatMessage = new JTextArea();
    JButton pushMsg = new JButton("Отправить сообщение");
    Server server = new Server();
    private EnterAction enterAction = new EnterAction("Submit", this);

    public ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("GB_chat");
        setResizable(true);
        setVisible(true);

        setLayout(new GridLayout(1, 1));
        panel.add(jlb1);
        panel.add(jtf1);
        panel2.add(jlb2);
        panel2.add(jtf2);
        panel3.add(jlb3);
        panel3.add(jtf3);
        panel4.add(jlb4);
        panel4.add(jtf4);
        panelMain.add(panel);
        panelMain.add(panel2);
        panelMain.add(panel3);
        panelMain.add(panel4);
        btnLogin.addActionListener(e -> server.loadChat(textChat));
        panelMain.add(btnLogin);
        textChat.setEditable(false);
        panelMain.add(scrollPane);
        panelMain.add(jlb6);
        panelMain.add(chatMessage);

        int condition = JComponent.WHEN_FOCUSED; // only want this when textarea has focus
        InputMap inputMap = chatMessage.getInputMap(condition); // get input and action maps
        ActionMap actionMap = chatMessage.getActionMap();
        // bind to the enter key stroke:
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        String key = enterStroke.toString();  // key to bind input to action
        // bind the enter key stroke to the enter action:
        inputMap.put(enterStroke, key);
        actionMap.put(key, enterAction);

        pushMsg.addActionListener(e -> server.sendMessage(textChat, chatMessage));
        panelMain.add(pushMsg);
        add(panelMain);
    }
}
