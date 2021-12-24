package com.problems.transactionchallenge;

import java.util.List;
import java.util.stream.Collectors;



class Trans{
    String firstName;
    String lastName;
    String email;
    String amount;
    String transId;
}
public class Transactions {
    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        if (creditLimit>200){
           return null; //transactions.stream().map(Trans).filter().collect(Collectors.toList());
        }

        return transactions.stream().collect(Collectors.toList());
    }
}
