package com.gmail.shnapi007;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import com.samczsun.skype4j.exceptions.ConnectionException;
import com.samczsun.skype4j.exceptions.InvalidCredentialsException;
import com.samczsun.skype4j.exceptions.NotParticipatingException;

public class SkypeBot {

    public static void main(String[] args) {
        SkypeBot bot = new SkypeBot();
        bot.start();
    }

    private void start() {

        Skype skype = new SkypeBuilder(BotInfo.NAME, BotInfo.PASSWORD).withAllResources().build();

        try {
            System.out.println("logining into skype account!");
            skype.login();
        } catch (InvalidCredentialsException e) {
            e.printStackTrace();
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (NotParticipatingException e) {
            e.printStackTrace();
        }

        registerEvents(skype);

        try {
            skype.subscribe();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }

        System.out.println("subscribed");

    }
    private void registerEvents(Skype skype){
        skype.getEventDispatcher().registerListener(new UserChat());
    }
}


