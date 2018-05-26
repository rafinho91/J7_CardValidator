package pl.sda;

public class IssuerInfo {
    private String issuerName;
    private String prefix;
    private String numberOfDigits;


    public IssuerInfo(String issuerName, String prefix, String numberOfDigits) {
        this.issuerName = issuerName;
        this.prefix = prefix;
        this.numberOfDigits = numberOfDigits;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumberOfDigits() {
        return numberOfDigits;
    }
}
