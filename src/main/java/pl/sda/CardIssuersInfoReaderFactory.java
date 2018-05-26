package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Map;
// todo add other filetypes
public class CardIssuersInfoReaderFactory {

    public static CardIssuersInfo read(FileType fileType, String filePath) throws IOException {
        switch (fileType){
            case CSV:
                CSVFileReader fileReader = new CSVFileReader();
                return new CardIssuersInfo(fileReader.read(filePath));
            case PDF:

            case JSON:

            case XML:

        }

        return null;
    }
}
