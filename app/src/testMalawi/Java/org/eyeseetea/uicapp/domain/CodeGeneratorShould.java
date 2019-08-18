package org.eyeseetea.uicapp.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CodeGeneratorShould {
    @Test
    public void return_valid_code_if_is_not_twin() {
        Client noTwinClient = givenAClient(0);

        String code = new CodeGenerator().generateCode(noTwinClient);

        Assert.assertEquals("AHESBA020275F0", code);
    }

    @Test
    public void return_valid_code_if_is_twin() {
        Client twinClient = givenAClient(1);

        String code = new CodeGenerator().generateCode(twinClient);

        Assert.assertEquals("AHESBA020275F1", code);
    }

    private Client givenAClient(int twinNumber) {
        String mother = "Sarah";
        String surname = "James";
        String district = "Zomba";

        Long dateOfBirth = new GregorianCalendar(1975, Calendar.FEBRUARY, 2).getTime().getTime();

        String sex = "FEMALE";

        boolean isTwin = (twinNumber == 0);

        return new Client(mother, surname, district, dateOfBirth, sex, isTwin, twinNumber);
    }
}