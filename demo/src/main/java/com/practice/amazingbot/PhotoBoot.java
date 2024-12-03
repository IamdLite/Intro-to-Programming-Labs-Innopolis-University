package com.practice.amazingbot;
import java.util.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;


public class PhotoBoot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update){

        // has the bot received any  message ?

        if(update.hasMessage() && update.getMessage().hasText()){

            // set message variable
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            // create a message object
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chat_id));
            message.setText("you said: " + message_text);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

        else if (update.hasMessage() && update.getMessage().hasPhoto()){

            // Message contains photo

            // set variables

            long chat_id = update.getMessage().getChatId();

            // Arrays of photo objects with different sizes
            // We will get the bigggest ohoto from that array

            List<PhotoSize> photos = update.getMessage().getPhoto();

            // Get photo id
            String f_id = photos.stream()
                          .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                          .findFirst()
                          .orElse(null).getFileId();
            
            // Get photo width
            int f_width = photos.stream()
                          .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                          .findFirst()
                          .orElse(null).getWidth();
            
            // Get photo height
            int f_height =  photos.stream()
                        .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                        .findFirst()
                        .orElse(null).getHeight();

            // Set photo caption
            String caption = "file_id: " + f_id + "\nwidth: " + f_width + "\nheight: " + f_height;


            // Send photo

            SendPhoto photo = new SendPhoto();
            photo.setChatId(String.valueOf(chat_id));
            photo.setPhoto(new InputFile(f_id));
            photo.setCaption(caption);


            try{
                execute(photo);
            } catch (TelegramApiException e){
                e.printStackTrace();
            }



        }

    }

    @Override
    public String getBotUsername(){
        return "PhotoBoot";
    }

    @Override
    public String getBotToken(){
        return "6951800087:AAExzHZnvj4CvpublY4lbfgl0VNHy_5WaBg";
    }



    
}
