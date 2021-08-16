import com.fesva.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static class Example extends TelegramLongPollingBot {
        public static void main(String[] args) {
            ApiContextInitializer.init(); // Инициализируем апи
            TelegramBotsApi botapi = new TelegramBotsApi();
            try {
                botapi.registerBot(new Bot());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getBotUsername() {
            return "USER";
            //возвращаем юзера
        }

        @Override
        public void onUpdateReceived(Update e) {
            // Тут будет то, что выполняется при получении сообщения
            Message msg = e.getMessage(); // Это нам понадобится
            String txt = msg.getText();
            if (txt.equals("/start")) {
                try {
                    sendMsg(msg, "Hello, world! This is simple bot!");
                } catch (TelegramApiException telegramApiException) {
                    telegramApiException.printStackTrace();
                }
            }
        }

        @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
        private void sendMsg(Message msg, String text) throws TelegramApiException {
            SendMessage s = new SendMessage();
            s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
            s.setText(text);
            //Чтобы не крашнулась программа при вылете Exception
            try {
                sendMessage(s);
            } catch (Exception telegramApiException) {
                telegramApiException.printStackTrace();
            }
        }

        private void sendMessage(SendMessage s) {

        }

        @Override
        public String getBotToken() {
            return "YOUR_BOT_TOKEN";
            //Токен бота
        }

        /*
        public void onUpdateReceived(Update update) {

        }

         */
    }
}
