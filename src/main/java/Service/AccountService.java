package Service;

import Model.Account;
import DAO.AccountDAO;

import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account addAccount(Account account){
        if ((accountDAO.getAccountByUsername(account.getUsername()) == null)
             && (account.getUsername().length() > 0)
             && (account.getPassword().length() >= 4)){
                return accountDAO.insertAccount(account);
        }
        else{
            return null;
        }
    }
    
}
