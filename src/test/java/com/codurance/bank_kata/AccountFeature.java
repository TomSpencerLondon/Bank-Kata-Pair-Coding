package com.codurance.bank_kata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


//  Date       || Amount || Balance
//          14/01/2012 || -500   || 2500
//          13/01/2012 || 2000   || 3000
//          10/01/2012 || 1000   || 1000
@ExtendWith(MockitoExtension.class)
public class AccountFeature {

  private Account account;
  @Mock
  Clock clock;

  @Mock
  Console console;
  private TransactionRepository transactionRepository;

  @BeforeEach
  void setUp() {
    transactionRepository = new TransactionRepository(clock);
    account = new Account(transactionRepository);
    console = new Console();
  }

  @Test
  void print_current_statement_to_console_with_transactions() {

    account.deposit(1000);
    account.deposit(2000);
    account.withdraw(500);

    account.printStatement();

    String statement = "Date || Amount || Balance\n" +
                       "14/01/2012 || -500 || 2500\n" +
                       "13/01/2012 || 2000 || 3000\n" +
                       "10/01/2012 || 1000 || 1000\n";

    verify(console, times(1)).print(statement);
  }
}
