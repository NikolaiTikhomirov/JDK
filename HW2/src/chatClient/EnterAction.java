package chatClient;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EnterAction extends AbstractAction {
    ChatWindow chatWindow;
    Clickable server;

    public EnterAction(String name, ChatWindow chatWindow, Clickable server) {
        super(name);
        int mnemonic = name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);  // allow an alt-keystroke mnemonic key
        this.chatWindow = chatWindow;
        this.server = server;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        server.sendMessage(chatWindow.textChat, chatWindow.chatMessage);
    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}

