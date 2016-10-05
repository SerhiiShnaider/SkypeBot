package com.gmail.shnapi007;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import com.samczsun.skype4j.chat.Chat;

/**
 * Created by Elvis on 29.09.2016.
 */
public class Utils {
    public static void sendMessage(String myMessage, Chat myChats) throws Exception {
        ChatterBotFactory myFactory = new ChatterBotFactory();
        ChatterBot myBot = myFactory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession mySession = myBot.createSession();

        myMessage = mySession.think(myMessage);
        final Chat chats = myChats;
        chats.sendMessage(myMessage);
    }
}
