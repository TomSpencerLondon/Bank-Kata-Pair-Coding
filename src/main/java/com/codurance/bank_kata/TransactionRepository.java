package com.codurance.bank_kata;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {
  private LinkedList transactions;
  private Clock clock;

  public TransactionRepository(Clock clock) {
    this.clock = clock;
    transactions = new LinkedList<Transaction>();
  }

  public void addTransaction(int amount) {
    transactions.add(new Transaction(amount, clock.date()));
  }

  public List<Transaction> getTransactions() {
    return unmodifiableList(transactions);
  }
}
