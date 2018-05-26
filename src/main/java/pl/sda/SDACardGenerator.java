package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SDACardGenerator {
    public static Card generate(FileType fileType, String filePath, String cardIssuerName) throws IOException {
        CardIssuersInfo cardIssuersInfo = CardIssuersInfoReaderFactory.read(fileType, filePath);
        List<IssuerInfo> listOfIssuers = cardIssuersInfo.create();
        for (IssuerInfo issuer : listOfIssuers) {
            if (issuer.getIssuerName().equals(cardIssuerName)) {
                StringBuilder builder = new StringBuilder();
                while (builder.length() != Integer.valueOf(issuer.getNumberOfDigits())) {
                    builder.append(Integer.parseInt(issuer.getPrefix()));
                    Random random = new Random();
                    builder.append(random.nextInt(10));
                    // todo DODAC SPRAWDZENIE LUHNA!!! ostatnia liczba dopełnia do luhna
                }
                String generatedCardNumber = builder.toString();
                Card card = new Card(cardIssuerName,generatedCardNumber);
                return card;
            }
        }
        return null;
    }
}
