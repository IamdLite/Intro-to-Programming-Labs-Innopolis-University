package com.practice.amazingbot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AmazingBot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update){

        // check if update has a message and the message has text
        if(update.hasMessage() && update.getMessage().hasText()){

            // Set variable

            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            // Create a message object

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chat_id));
            message.setText("you said: " + message_text);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername(){
        return "AmazingBot";
    }

    @Override
    public String getBotToken(){
        
    return "6951800087:AAExzHZnvj4CvpublY4lbfgl0VNHy_5WaBg";


    }


    
}
