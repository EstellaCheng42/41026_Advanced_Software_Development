
package opal.entity;

import java.math.BigDecimal;

/**
 *
 * @author sunyuanwei
 */
public class Card {
    public int id;
    public User user;
    public double balance;
    public String cardNum;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }

    public String getCardNum(){
        return cardNum;
    }
    
    public void setCardNum(String cardNum){
        this.cardNum = cardNum;
    }
}

