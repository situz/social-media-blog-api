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
    
}
