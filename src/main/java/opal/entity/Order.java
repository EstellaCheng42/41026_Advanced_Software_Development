package opal.entity;

/**
 *
 * @author Administrator
 */
public class Order {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private int addvalue;
    private String deliveryaddress;
    private String state;
    private String code;
    private String receivername;
    private String cardtype;
    private int uid;
    private int status;
    private String cardnumber;
    private String cvv;
    private String ownername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAddvalue() {
        return addvalue;
    }

    public void setAddvalue(int addvalue) {
        this.addvalue = addvalue;
    }

    public String getDeliveryaddress() {
        return deliveryaddress;
    }

    public void setDeliveryaddress(String deliveryaddress) {
        this.deliveryaddress = deliveryaddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCardnumber(){
        return cardnumber;
    }
    
    public void setCardnumber(String cardnumber){
        this.cardnumber = cardnumber;
    }
    
    public String getCvv(){
        return cvv;
    }
    
    public void setCvv(String cvv){
        this.cvv=cvv;
    }
    
    public String getOwnername(){
        return ownername;
    }
    
    public void setOwnername(String ownername){
        this.ownername=ownername;
    }
}
