package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFabric;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {

        //Arrange
        double amount = 200.0;
        double expectedValue = 196.0;

        Account acc = AccountFabric.createEmptyAccount();

        //Act
        acc.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());

    }


    @Test
    public void depositShouldDoNothingIfAmountIsLessThenZero() {

        //Arrange
        double amount = -200.0;
        double expectedValue = 400.0;

        Account acc = AccountFabric.createAccount(expectedValue);

        //Act
        acc.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());

    }


    @Test
    public void fullWithdrawShouldEmptyValueAndReturnBalance() {

        //Arrange
        double expectedValue = 0.0;
        double initialValue = 5000.0;

        Account acc = AccountFabric.createAccount(initialValue);

        //Act
       double result =  acc.fullWithdraw();

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
        Assertions.assertEquals(initialValue, result);


    }

    @Test
    public void withdrawShouldTrowExceptionIfAmountIsGreaterThenThanBalance() {

        //Arrange
        double initialValue = 5000.0;
        double incorrectWithdrawValue = 15000.0;

        Account acc = AccountFabric.createAccount(initialValue);

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Act
            acc.withdraw(incorrectWithdrawValue);

        });
    }


}
