#telegrambotapi
Java implementation of the [Telegram Bot API] (https://core.telegram.org/bots/api)

Usage
-----
To use the Telegram bot API, simply download the latest release, and add it to your project. That will give you access to all objects and methods of the API, via the ```TelegramBot``` class. Everything else (commands, handling updates received via ```getUpdates(<offset>, <limit>, <timeout>)```, etc.) is up to you.

Example
--------

```java
TelegramBot myBot = new TelegramBot(<token>);
try {
    User user = myBot.getMe();
    System.out.println("My bot has this user ID: " + user.getId());
} catch (CommandFailedException e) {
    System.err.println("Whoops!");
}

```

License
-------
telegrambotapi is distributed under the terms of the [GNU GPL version 3](http://www.gnu.org/licenses/gpl-3.0.txt) or, at your option, any later version.