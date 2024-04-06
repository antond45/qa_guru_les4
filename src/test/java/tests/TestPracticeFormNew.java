package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;




public class TestPracticeFormNew extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testPositiveForAllRegistration() {
        //заполнить данные
        registrationPage.openPage()
                .firstName("Anton")
                .lastName("test")
                .email("anton@test.test")
                .userNumber("9876666666")
                .userGender("Other")
                .dateOfBirth("14", "May", "1997")
                .userAdress("tst")
                .userHobbies("Sports")
                .userSubjects("Maths")
                .userState("NCR" )
                .userCity("Noida")
                .upLoadUserPicture("Screenshot_5.png");

        //отправить данные
        registrationPage.clickSubmit();


//        Проверка данных
        registrationPage.checkFormResult(
                "Anton test",
                "anton@test.test",
                "Other",
                "9876666666",
                "14 May,1997",
                "Maths",
                "Sports",
                "Screenshot_5.png",
                "tst",
                "NCR Noida");

    }

    @Test
    void testWithRequiredFieldsPositive(){
        registrationPage.openPage();

        registrationPage.firstName("Anton")
                .lastName("tst")
                .userGender("Other")
                .userNumber("9876666666")
                .dateOfBirth("14", "May", "1997");

        registrationPage.clickSubmit();

        registrationPage.checkOneResult("Student Name", "Anton tst")
                .checkOneResult("Gender", "Other")
                .checkOneResult("Mobile", "9876666666")
                .checkOneResult("Date of Birth", "14 May,1997");
    }

    @Test
    void testNegativeRegistration(){
        registrationPage.openPage();

        registrationPage.firstName("Anton")
                .email("anton@test.test")
                .userGender("Other")
                .userNumber("9876666666")
                .dateOfBirth("14", "May", "1997")
                .userSubjects("Maths")
                .userHobbies("Sports")
                .upLoadUserPicture("Screenshot_5.png")
                .userAdress("tst")
                .userState("NCR")
                .userCity("Noida");

        registrationPage.clickSubmit();

        registrationPage.checkResultNegative();
    }



}
