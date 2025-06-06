package Service;

import Model.Account;
import Model.Message;
import DAO.AccountDAO;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;
    private AccountDAO accountDAO;

    public MessageService(){
        this.messageDAO = new MessageDAO();
        this.accountDAO = new AccountDAO();
    }

    public MessageService(MessageDAO messageDAO, AccountDAO accountDAO){
        this.messageDAO = messageDAO;
        this.accountDAO = accountDAO;
    }

    public Message createMessage(Message message){
        if (message.getMessage_text() != null
        && message.getMessage_text().length() > 0
        && message.getMessage_text().length() <= 255
        && accountDAO.getAccountById(message.getPosted_by()) != null){
            return messageDAO.insertMessage(message);
        }
        else{
            return null;
        }
    }

    public List<Message> getAllMessages(){
        return messageDAO.getAllMessages();
    }
    
    public Message getMessageById(int id){
        return messageDAO.getMessageById(id);
    }

    public Message deleteMessageById(int id){
        return messageDAO.deleteMessageById(id);
    }

    public Message updateMessageTextById(String message_text, int id){
        if ((messageDAO.getMessageById(id) != null)
        && (message_text != null)
        && (message_text.length()>0)
        && (message_text.length()<=255)){
            return messageDAO.updateMessageTextById(message_text, id);
        }
        else{
            return null;
        }
    }

    public List<Message> getAllMessagesByUser(int account_id){
        return messageDAO.getAllMessagesByUser(account_id);
    }
}
