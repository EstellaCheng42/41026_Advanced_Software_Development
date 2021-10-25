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
public class SecurityRequest {
    private int requestId;
    private String cardNo;
    private String datetime;
    private String status;
    
    public SecurityRequest(int requestId,String cardNo, String datetime,String status){
        this.requestId=requestId;
        this.cardNo=cardNo;
        this.datetime=datetime;
        this.status=status;
    }

    public SecurityRequest(){}
    
    public int getRequestId(){
        return requestId;
    }
    public void setRequestId(int requestId){
        this.requestId=requestId;
    }
    public String getCardNo(){
        return cardNo;
    }
    
    public void setCardNo(String cardNo){
        this.cardNo = cardNo;
    } 
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String date) {
        this.datetime = datetime;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
