import javax.swing.*;
import java.awt.event.ActionEvent;

public class EnterAction extends AbstractAction {
    ChatWindow chatWindow;

    public EnterAction(String name, ChatWindow chatWindow) {
        super(name);
        int mnemonic = name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);  // allow an alt-keystroke mnemonic key
        this.chatWindow = chatWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Server().sendMessage(chatWindow.textChat, chatWindow.chatMessage);
    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}

