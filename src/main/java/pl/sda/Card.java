package pl.sda;

public class Card {
    private String issuerName;
    private String cardNumber;

    public Card() {
    }

    public Card(String issuerName, String cardNumber) {

        this.issuerName = issuerName;
        this.cardNumber = cardNumber;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "issuerName='" + issuerName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
