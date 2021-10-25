
package opal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {

    public int id;

    public int creditCardId;

    public double amount;

    public int customerId;

    public Card card;

    public int opalCardId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getOpalCardId() {
        return opalCardId;
    }

    public void setOpalCardId(int opalCardId) {
        this.opalCardId = opalCardId;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", creditCardId=" + creditCardId + ", amount=" + amount + ", customerId=" + customerId + ", card=" + card + ", opalCardId=" + opalCardId + '}';
    }

}
