package tests.factory;

import entities.Account;

public class AccountFabric {

    public  static Account createEmptyAccount(){
        return new Account(1L,0.0);
    }


    public  static Account createAccount(double amount){
        return new Account(1L, amount);
    }


}
