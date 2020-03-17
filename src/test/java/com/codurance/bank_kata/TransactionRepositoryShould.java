package com.codurance.bank_kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionRepositoryShould {
  private TransactionRepository transactionRepository;

  @Mock
  Clock clock;

  @BeforeEach
  void setUp() {
    transactionRepository = new TransactionRepository(clock);
  }

  @Test
  void add_transaction() {
    when(clock.date()).thenReturn("13/04/2014");
    transactionRepository.addTransaction(1000);
    assertEquals(1, transactionRepository.getTransactions().size());
    assertEquals(transactionRepository.getTransactions().get(0), new Transaction(1000, "13/04/2014"));
  }


}