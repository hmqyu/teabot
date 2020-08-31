import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    private MessageReceivedEvent event;
    private int ikuMessageCount = 0;

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    // prints a message to the console on bot startup
    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("HEEN IS SMEGA CUTE uwu");
    }

    // where the bot reacts to various events that occur, ie. messages
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Message received from " +
                event.getAuthor().getName() + " " +
                event.getAuthor().getId() + ": " +
                event.getMessage().getContentDisplay());

        this.event = event;

        botResponseMessages();
        specificUserMessages();
    }

    // the bot responds to certain phrases sent in the channel, if possible
    public void botResponseMessages() {
        goodBot();
        painMessage();
        angryAtBot();
        botAcceptsApologies();
        botGreetings();
    }

    // send the pain image after a user types "pain."
    public void painMessage() {
        if (event.getMessage().getContentRaw().equals("pain.")) {
            event.getChannel()
                    .sendMessage("https://i.kym-cdn.com/photos/images/newsfeed/001/856/089/47d.png").queue();
        }
    }

    // bot thanks someone when they say "good bot"
    public void goodBot() {
        if (event.getMessage().getContentRaw().equalsIgnoreCase("good bot")) {
            event.getChannel().sendMessage("thank you!").queue();
        }
    }

    // bot swears back if a user curses the bot
    public void angryAtBot() {
        String userMessage = event.getMessage().getContentRaw().toLowerCase();
        if (userMessage.equals("fuck you bot") ||
                userMessage.equals("fuck the bot") ||
                userMessage.equals("fuck this bot") ||
                userMessage.equals("i hate this bot") ||
                userMessage.equals("i hate the bot") ||
                userMessage.equals("the bot sucks") ||
                userMessage.equals("this bot sucks")) {
            event.getChannel().sendMessage("<@" +
                    event.getMessage().getAuthor().getId() +
                    "> fuck you too").queue();
        }
    }

    // bot accepts the apology of the user
    public void botAcceptsApologies() {
        String userMessage = event.getMessage().getContentRaw().toLowerCase();
        if (userMessage.equals("sorry bot") ||
                userMessage.equals("im sorry bot") ||
                userMessage.equals("i'm sorry bot")) {
            event.getChannel().sendMessage("<@" +
                    event.getMessage().getAuthor().getId() +
                    "> it's okay").queue();
        }
    }

    // send the pain image after a user types "pain."
    public void botGreetings() {
        String userMessage = event.getMessage().getContentRaw().toLowerCase();
        if (userMessage.equals("hi bot") ||
                userMessage.equals("hello bot") ||
                userMessage.equals("hey bot") ||
                userMessage.equals("hi") ||
                userMessage.equals("hello") ||
                userMessage.equals("hey")) {
            event.getChannel().sendMessage("<@" +
                    event.getMessage().getAuthor().getId() +
                    "> hi! :-)").queue();
        }
    }

    // the bot does various things depending if a certain user sends a message
    public void specificUserMessages() {
        ikuNeedsAGirlfriend();
        spellAshleysNameWrong();
    }

    // tells iku that he needs a girlfriend every time he types
    // tells him on his first message, and then waits 5 messages before telling him again
    public void ikuNeedsAGirlfriend() {
        if (event.getAuthor().getId().equals("263815694380957697")) {
            ikuMessageCount++;
            if (ikuMessageCount == 5) {
                ikuMessageCount = 0;
            } else if (ikuMessageCount == 1) {
                event.getChannel().sendMessage("get a girlfriend dude.").queue();
            }
        }
    }

    // corrects whoever said ashley's name to ahley
    public void spellAshleysNameWrong() {
        if (event.getMessage().getContentRaw().toLowerCase().contains("ashley")) {
            event.getChannel().sendMessage("*ahley").queue();
        }
    }

    // sets the properties of the embedded image (in this case pain.)
//    public void sendEmbeddedImage() {
//        EmbedBuilder image = new EmbedBuilder();
//        image.setThumbnail("https://i.kym-cdn.com/photos/images/newsfeed/001/856/089/47d.png");
//        event.getChannel().sendMessage(image.build()).queue();
//    }
}