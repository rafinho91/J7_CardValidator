package pl.sda;

public class ValidationResult {
    private String issuer = "UNKNOWN";
    private boolean verificationPassed = false;


    public boolean testLuhn(String cardNumber) {
        char[] cardChars = cardNumber.toCharArray();
        int[] cardDigits = new int[cardChars.length];
        int sum = 0;
        for (int i = 0; i < cardChars.length; i++) {
            cardDigits[i] = Integer.parseInt(String.valueOf(cardChars[i]));
        }
        for (int i = cardDigits.length - 2; i >= 0; i -= 2) {
            cardDigits[i] *= 2;
            if (cardDigits[i] > 9) {
                int secondDigit = cardDigits[i] % 10;
                cardDigits[i] = cardDigits[i] / 10 + secondDigit;
            }
        }
        for (int i = 0; i < cardDigits.length; i++) {
            sum += cardDigits[i];
        }
        return (sum % 10) == 0;
    }

    public boolean checkNumberOfDigits(String issuersDigitRule, String actualNumberOfDigits) {
        return Integer.parseInt(issuersDigitRule) == Integer.parseInt(actualNumberOfDigits);
    }

    public boolean checkPrefix(String issuersPrefixRule, String cardNumber) {
        if (issuersPrefixRule.contains("-")) {
            String[] givenRange = issuersPrefixRule.split("-");
            int max = Integer.parseInt(givenRange[1]);
            int min = Integer.parseInt(givenRange[0]);
            int prefixLength = givenRange[0].length();
            String cardPrefix = cardNumber.substring(0, prefixLength);
            while (min < max) {
                int value = min;
                if (Integer.parseInt(cardPrefix) == value) {
                    return true;
                }
                min++;
            }
            return false;
        }
        String[] splitRule = issuersPrefixRule.split(",");
        for (int i = 0; i < splitRule.length; i++) {
            int prefixLength = splitRule[i].length();
            String cardPrefix = cardNumber.substring(0, prefixLength);
            if (Integer.parseInt(cardPrefix) == Integer.parseInt(splitRule[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Validation result: " +
                "issuer='" + issuer + '\'' +
                ", verificationPassed=" + verificationPassed;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public boolean isVerificationPassed() {
        return verificationPassed;
    }

    public void setVerificationPassed(boolean verificationPassed) {
        this.verificationPassed = verificationPassed;
    }
}
