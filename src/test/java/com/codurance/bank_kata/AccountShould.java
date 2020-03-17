package com.codurance.bank_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountShould {
  @Mock
  TransactionRepository transactionRepository;

  private Account account;
  @Mock
  private Formatter formatter;

  @BeforeEach
  void setUp() {
    account = new Account(transactionRepository, formatter);
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

  @Test
  void print_statement() {
    when(transactionRepository.getTransactions()).thenReturn(asList(
            new Transaction(100, "13/04/2014")
    ));
    account.printStatement();
    verify(formatter, times(1)).print(transactionRepository.getTransactions());
  }
}