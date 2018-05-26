package pl.sda;

import org.junit.Assert;
import org.junit.Test;

public class ValidationResultTest {

    @Test
    public void testLuhnTest(){
        //given
        String cardNumber = "4234343434343434";
        String badCardNumber = "1234123412341234";
        ValidationResult result = new ValidationResult();
        ValidationResult badResult = new ValidationResult();
        //when

        //then
        Assert.assertTrue(result.testLuhn(cardNumber));
        Assert.assertFalse(badResult.testLuhn(badCardNumber));
    }

    @Test
    public void checkNumberOfDigitsTest(){
        //given
        String  numberOfDigits = "16";
        ValidationResult result = new ValidationResult();
        //then
        Assert.assertTrue(result.checkNumberOfDigits("16",numberOfDigits));
        Assert.assertFalse(result.checkNumberOfDigits("15",numberOfDigits));
    }

    @Test
    public void checkPrefix(){
        //given
        String cardNumber = "4567345634577";
        ValidationResult result = new ValidationResult();
        //then
        Assert.assertTrue(result.checkPrefix("4",cardNumber));
        Assert.assertTrue(result.checkPrefix("22,45",cardNumber));
        Assert.assertTrue(result.checkPrefix("42-48",cardNumber));

    }
}
