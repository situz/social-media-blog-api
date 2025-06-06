package Service;

import Model.Account;
import DAO.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account register(Account account){
        if ((accountDAO.getAccountByUsername(account.getUsername()) == null)
             && (account.getUsername().length() > 0)
             && (account.getPassword().length() >= 4)){
                return accountDAO.insertAccount(account);
        }
        else{
            return null;
        }
    }

    public Account login(String username, String password){
        Account account = accountDAO.getAccount(username, password);
        return account;
    }
    
}
