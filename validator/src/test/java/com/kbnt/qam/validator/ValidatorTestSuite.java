package com.kbnt.qam.validator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        NamePasswordValidatorUnexpectedSymbolsTest.class,
        NameValidatorTest.class,
        PasswordLengthValidatorTest.class
})
public class ValidatorTestSuite {
}
