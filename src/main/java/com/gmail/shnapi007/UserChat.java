package com.gmail.shnapi007;

import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;

/**
 * Created by Elvis on 29.09.2016.
 */
public class UserChat implements Listener {

    @EventHandler
    public void onChat(MessageReceivedEvent e) {
        try {
            Utils.sendMessage(e.getMessage().getContent().asPlaintext(), e.getChat());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
