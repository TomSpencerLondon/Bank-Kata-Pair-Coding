package com.codurance.bank_kata;

public class Account {

  private TransactionRepository transactionRepository;
  private Formatter formatter;

  public Account(TransactionRepository transactionRepository, Formatter formatter) {
    this.transactionRepository = transactionRepository;
    this.formatter = formatter;
  }

  public void deposit(int amount) {
    transactionRepository.addTransaction(amount);
  }

  public void withdraw(int amount) {
    transactionRepository.addTransaction(-amount);
  }

  public void printStatement() {
    formatter.print(transactionRepository.getTransactions());
  }
}
