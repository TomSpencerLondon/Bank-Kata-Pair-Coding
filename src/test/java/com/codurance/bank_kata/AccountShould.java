package com.codurance.bank_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountShould {
  @Mock
  TransactionRepository transactionRepository;

  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account(transactionRepository);
  }

  @Test
  void add_a_deposit() {
    account.deposit(1000);
    verify(transactionRepository, times(1)).addTransaction(1000);
  }

  @Test
  void withdraw() {
    account.withdraw(500);
    verify(transactionRepository, times(1)).addTransaction(-500);
  }
}