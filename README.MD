Teste básico com Junit utilizando o método AAA para validação.


O teste implementado consiste em validar se o método de saque é descontada a taxa de depósito.

Método testado:
```java
{
    public void deposit(Double amount) {
        if (amount > 0) {
            amount -= amount * DEPOSIT_FEE_PERCENTAGE;
            balance += amount;
        }
    }
}
```

Configuração do teste:
```java
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){

        //Arrange
        double amount = 200.0;
        double expectedValue = 196.0;

        Account acc = new Account(1L, 0.0);

        //Act
        acc.deposit(amount);

        //Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());

    }
```