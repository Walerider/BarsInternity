package com.walerider.barstaskscompleting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class RestfulController {
    private final ClientRepository clientRepo;
    private final AccountRepository accountRepo;
    private final TransactionRepository transactionRepo;
    public RestfulController(ClientRepository clientRepo, AccountRepository accountRepo, TransactionRepository transactionRepo) {
        this.clientRepo = clientRepo;
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }
    @PostMapping("/clients/createClient")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        clientRepo.save(client);
        return new ResponseEntity<>("Клиент создан", HttpStatus.CREATED);
    }
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return (List<Client>) clientRepo.findAll();
    }
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientRepo.findById(id).get();
    }
    @PutMapping("/clients/{id}")
    public Client updateClient(@RequestBody Client newClient,@PathVariable Long id) {
        return clientRepo.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setEmail(newClient.getEmail());
                    return clientRepo.save(client);
                })
                .orElseGet(() -> {
                    return clientRepo.save(newClient);
                });
    }
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientRepo.deleteById(id);
        return new ResponseEntity<>("Клиент с id " + id + " удалён", HttpStatus.OK);
    }
    //не делал в отдельном пути, считаю, что правильно
    //Получение счёта
    @PostMapping("/clients/{id}/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Account account, @PathVariable Long id) {
        account.setClientId(id);
        accountRepo.save(account);
        return new ResponseEntity<>("Счёт создан", HttpStatus.CREATED);
    }
    //не делал в отдельном пути, считаю, что правильно
    @GetMapping("/clients/{id}/getAccounts")
    public List<Account> getAllAccountsForClient(@RequestParam Long id) {
        return accountRepo.findAllByClientId(id);
    }
    @GetMapping("accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountRepo.findById(id).get();
    }
    @PutMapping("accounts/{id}")
    public Account updateAccount(@RequestBody Account newAccount, @PathVariable Long id) {
        return accountRepo.findById(id)
                .map(account -> {
                    account.setAccountNumber(newAccount.getAccountNumber());
                    account.setBalance(newAccount.getBalance());
                    return accountRepo.save(account);
                })
                .orElseGet(() -> {
                    return accountRepo.save(newAccount);
                });
    }
    @DeleteMapping("accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountRepo.deleteById(id);
        return new ResponseEntity<>("Счёт с id" + id + " удалён", HttpStatus.OK);
    }
    @PostMapping("accounts/{id}/createTransaction")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction, @PathVariable Long id) {
        transaction.setAccountId(id);
        transactionRepo.save(transaction);
        return new ResponseEntity<>("Транзакция создана", HttpStatus.CREATED);
    }
    @GetMapping("accounts/{id}/getTransactions")
    public List<Transaction> getAllTransactionsForAccount(@PathVariable Long id) {
        return transactionRepo.findAllByAccountId(id);
    }
    @GetMapping("transaction/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionRepo.findById(id).get();
    }
    //А зачем изменение транзакций?
    @PutMapping("transaction/{id}")
    public Transaction updateTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {
        return transactionRepo.findById(id)
                .map(transaction -> {
                    transaction.setTransactionDate(newTransaction.getTransactionDate());
                    transaction.setAmount(newTransaction.getAmount());
                    return transactionRepo.save(transaction);
                })
                .orElseGet(() -> {
                    return transactionRepo.save(newTransaction);
                });
    }
    @DeleteMapping("transaction/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id) {
        transactionRepo.deleteById(id);
        return new ResponseEntity<>("Транзакция с id" + id + " удалена", HttpStatus.OK);
    }
}
