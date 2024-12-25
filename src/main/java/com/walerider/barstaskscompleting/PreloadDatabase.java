package com.walerider.barstaskscompleting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class PreloadDatabase {
    private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository,AccountRepository accountRepository,TransactionRepository transactionRepository) {
        clientRepository.deleteAll();
        accountRepository.deleteAll();
        transactionRepository.deleteAll();
        return args -> {
            log.info("Preloading data..." + clientRepository.save(new Client("First","123@ya.ru")));
            log.info("Preloading data..." + clientRepository.save(new Client("Second","1234@ya.ru")));
            log.info("Preloading data..." + clientRepository.save(new Client("Third","12345@ya.ru")));
            log.info("Preloading data..." + accountRepository.save(new Account(Integer.toUnsignedLong(1),Integer.toUnsignedLong(1),Integer.toUnsignedLong(1000))));
            log.info("Preloading data..." + accountRepository.save(new Account(Integer.toUnsignedLong(1),Integer.toUnsignedLong(2),Integer.toUnsignedLong(5000))));
            log.info("Preloading data..." + accountRepository.save(new Account(Integer.toUnsignedLong(1),Integer.toUnsignedLong(3),Integer.toUnsignedLong(200))));
            log.info("Preloading data..." + accountRepository.save(new Account(Integer.toUnsignedLong(2),Integer.toUnsignedLong(4),Integer.toUnsignedLong(2100))));
            log.info("Preloading data..." + accountRepository.save(new Account(Integer.toUnsignedLong(3),Integer.toUnsignedLong(5),Integer.toUnsignedLong(22100))));
            log.info("Preloading data..." + transactionRepository.save(new Transaction(Integer.toUnsignedLong(1),Integer.toUnsignedLong(1000),new Date(2024,10,30))));
            log.info("Preloading data..." + transactionRepository.save(new Transaction(Integer.toUnsignedLong(1),Integer.toUnsignedLong(2000),new Date(2024,10,30))));
            log.info("Preloading data..." + transactionRepository.save(new Transaction(Integer.toUnsignedLong(3),Integer.toUnsignedLong(1000),new Date(2024,11,15))));

        };

        }

}
