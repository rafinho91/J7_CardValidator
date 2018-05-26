package pl.sda;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        String cardNumber = "4234343434343434";  // VISA number
        String filePath = "C:\\sda\\J7_CardValidator\\CardIssuersInformation.csv";

        SDACardValidator validator = new SDACardValidator();
        ValidationResult validationResult = validator.analyze(FileType.CSV, filePath, cardNumber);
        System.out.println(validationResult.toString());
        Card visa = SDACardGenerator.generate(FileType.CSV, filePath, "VISA");
        System.out.println(visa.toString());


    }
}
