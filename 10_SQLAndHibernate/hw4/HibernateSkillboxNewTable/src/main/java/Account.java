import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account { // <mapping class="Account"></mapping>
    LinkedPurchaseList linkedPurchaseList;
    private int acc_bal;

    @Id
    public LinkedPurchaseList getlinkedPurchaseList() {
        return linkedPurchaseList;
    }

    public void setlinkedPurchaseList(LinkedPurchaseList linkedPurchaseList) {
        this.linkedPurchaseList = linkedPurchaseList;
    }

    public int getAcc_bal() {
        return acc_bal;
    }

    public void setAcc_bal(int acc_bal) {
        this.acc_bal = acc_bal;
    }
}

