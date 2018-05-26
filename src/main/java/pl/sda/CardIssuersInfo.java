package pl.sda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CardIssuersInfo {
    public static final String ISSUER_NAME = "issuerName";
    public static final String PREFIX = "prefix";
    public static final String NUMBER_OF_DIGITS = "numberOfDigits";
    private List<Map<String ,String>> infoMap;

    public CardIssuersInfo(List<Map<String, String>> infoMap) {
        this.infoMap = infoMap;
    }

    public List<IssuerInfo> create(){
        List<IssuerInfo> listOfIssuers = new ArrayList<>();
        for (int i = 0; i < infoMap.size(); i++) {
            Map<String, String> nextIssuer = infoMap.get(i);
            String issuerName = nextIssuer.get(ISSUER_NAME);
            String prefix = nextIssuer.get(PREFIX);
            String numberOfDigits = nextIssuer.get(NUMBER_OF_DIGITS);
            IssuerInfo issuerInfo = new IssuerInfo(issuerName,prefix,numberOfDigits);
            listOfIssuers.add(issuerInfo);
        }
        return listOfIssuers;
    }

    @Override
    public String toString() {
        return "CardIssuersInfo{" +
                "infoMap=" + infoMap +
                '}';
    }
}
