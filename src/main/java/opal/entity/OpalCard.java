/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.entity;

/**
 *
 * @author chengming
 */
public class OpalCard {
    
    private int cardId;
    private String cardNo;
    private String securityCode;
    private String nickname;
    private String cardType;
    
    public OpalCard(int cardId,String cardNo,String securityCode,String nickname,String cardType){
        this.cardId=cardId;
        this.cardNo=cardNo;
        this.securityCode=securityCode;
        this.nickname=nickname;
        this.cardType=cardType;
    }
    
    public OpalCard(){}
    
     public int getCardId(){
        return cardId;
    }
    
    public void setCardId(int cardId){
        this.cardId = cardId;
    } 
   
    public String getCardNo(){
        return cardNo;
    }
    
    public void setCardNo(String cardNo){
        this.cardNo = cardNo;
    } 
    
     public String getsecurityCode(){
        return securityCode;
    }
    
    public void setsecurityCode(String securityCode){
        this.securityCode = securityCode;
    } 
    public String getnickname(){
        return nickname;
    }
    
    public void setnickname(String nickname){
        this.nickname = nickname;
    } 
    public String getcardType(){
        return cardType;
    }
    
    public void setcardType(String cardType){
        this.cardType = cardType;
    } 
            
}
