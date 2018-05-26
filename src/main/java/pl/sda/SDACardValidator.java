package pl.sda;

import java.io.IOException;
import java.util.List;

public class SDACardValidator {
    public ValidationResult analyze(FileType fileType, String filePath, String cardNumber) throws IOException {
        ValidationResult result = new ValidationResult();
        CardIssuersInfo issuersInfo = CardIssuersInfoReaderFactory.read(fileType, filePath);
        List<IssuerInfo> issuersInfoList = issuersInfo.create();
        if (result.testLuhn(cardNumber)) {
            for (IssuerInfo issuer : issuersInfoList) {
                if (result.checkNumberOfDigits(issuer.getNumberOfDigits(), String.valueOf(cardNumber.length()))) {
                    if (result.checkPrefix(issuer.getPrefix(),String.valueOf(cardNumber))){
                        result.setIssuer(issuer.getIssuerName());
                        result.setVerificationPassed(true);
                    }
                }
            }
        }
        return result;
    }
}
