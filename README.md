# Teabot ☕

## Table Of Contents

* [Project Description](#project-description)
* [Setup](#setup)
* [Walkthrough](#walkthrough)

## Project Description
The **Teabot** is a Discord bot, specifically meant for the **Tea Party Infinite** server. It is used to play some basic games, such as Rock-Paper-Scissors, as well as other gambling games that are shown belown. There are also some other features and bot responses that are used to mess around with certain people, and more.

## Setup

### Prerequisites 

1) [`Java`](https://www.java.com/en/download/manual.jsp) must be installed on your device.
2) [`Gradle`](https://gradle.org/install/) must also be install on your device to install other packages.
3) [`IntelliJ`](https://www.jetbrains.com/idea/download/#section=windows) is needed to build and run the code.

Then, use Git to clone this respository in IntelliJ and run the code. Make sure to install the required dependencies when prompted using Gradle. Next, you will need to create a Discord Bot account. [`Here`](https://discordpy.readthedocs.io/en/stable/discord.html) are some instructions to create one. Then, copy and paste the token for you discord bot into the "token" field in the Main.java file, and invite the bot to your server!

## Walkthrough

# Games

The 2 currently supported games are **Rock-Paper-Scissors** and **Cockfight**. 

Here are some instructions on how to play **Rock-Paper-Scissors** using the Teabot: 

Use the `!rps` command to start the game. The bot will respond with a message saying `Choose thy weapon:` where it will wait for the same user to reply with a message saying `rock`, `paper`, or `scissors`. The bot will then respond with a message saying what it picked as well as if th user lost or won. A future update is to allowing users to use their currency and gamble with this game.

Here are some instructions on how to play **Cockfight** using the Teabot:

A user can use the `!daily` command to first gain some money. This command can only be used one per day and gives the user a random amount of money between $300 and $500. Next, the user is able to purchase a chickn with the `!buy chicknen` command. Each chickn has their own win percentage when playing the game and it is completely random and determined when the chicken is purhchased. The user can now play the cockfight game using the `!cockfight <amount>` command where they may specify the amount of money they want to gamble. After this command, the bot will respons with one of two messages, saying whether you won and the amount of money you won, or whether you lost. If your chicken loses a cockfight, it dies and is lost forever. 

The user may also purchase multiple chickens and use `!display chickens` to show their current list of chickens. If the user has multiple chicken, they can use the command `!assign chicken <number>` to assign that chicken as their primary chicken.

Remember to use the `!save` command to save current use currencies and chicken inventories!

There is also a `!help` command which will show a full list of commands that are currently available and their functions.

# Other fun features

The Teabot can also respond to certain messages with pre-set responses. Here are some examples below. Try out the bot to see what other responses you can get!

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928949189235335239/unknown.png">

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928949609156476928/unknown.png">

<img src="https://cdn.discordapp.com/attachments/749751927604117527/928949911406407710/unknown.png">

The bot is also able to detect messages from specfic users and respond to only their messages as well. In this case, these user-specific messages are for select members of our Tea Party Infinite server. For example, whenever a certain user types anything in chat, the bot responds with `get a girlfrien dude.`

You are welcome to install the Teabot in your Discord Server and have all the fun you want!

