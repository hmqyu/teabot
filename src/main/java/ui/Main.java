package ui;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    // where the bot reacts to various events that occur, ie. messages
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Message received from " +
                event.getAuthor().getName() + " " +
                event.getAuthor().getId() + ": " +
                event.getMessage().getContentDisplay());

        botResponseMessages(event);
        specificUserMessages(event);
    }

    // the bot responds to certain phrases sent in the channel, if possible
    public void botResponseMessages(MessageReceivedEvent event) {
        goodBot(event);
    }

    // bot thanks someone when they say "good bot"
    public void goodBot(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().toLowerCase().equals("good bot")) {
            event.getChannel().sendMessage("thank you!").queue();
        }
    }

    // the bot does various things depending if a certain user sends a message
    public void specificUserMessages(MessageReceivedEvent event) {
        ikuNeedsAGirlfriend(event);
    }

    // tells iku that he needs a girlfriend every time he types
    public void ikuNeedsAGirlfriend(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals("263815694380957697")) {
            event.getChannel().sendMessage("get a girlfriend dude.").queue();
        }
    }

}