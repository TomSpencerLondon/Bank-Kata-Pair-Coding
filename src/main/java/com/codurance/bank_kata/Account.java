package com.codurance.bank_kata;

public class Account {

  private TransactionRepository transactionRepository;

  public Account(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public void deposit(int amount) {
    transactionRepository.addTransaction(amount);
  }

  public void withdraw(int amount) {
    transactionRepository.addTransaction(-amount);
  }

  public void printStatement() {
    throw new UnsupportedOperationException();
  }
}
