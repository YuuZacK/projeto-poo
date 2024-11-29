package com.fag;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccount;
import com.fag.infra.celcoin.CelcoinBassRepository;
import com.fag.infra.console.ConsoleUserInterface;
import com.fag.infra.swing.SwingUserInterface;
import com.fag.infra.testdb.UserTestDB;
import com.fag.services.BankingService;

public class Main {

    public static void main(String[] args) {
        ConsoleUserInterface consoleUI = new ConsoleUserInterface();
        SwingUserInterface swing = new SwingUserInterface();
        UserTestDB userTestDB = new UserTestDB();
        CelcoinBassRepository celcoinBassRepo = new CelcoinBassRepository();

        BankingService bankingService = new BankingService(consoleUI, userTestDB, celcoinBassRepo);

        while (true) {

            Integer opcao = bankingService.showMenu();

            switch (opcao) {
                case 1:
                    LoginDTO loginDTO = bankingService.getLoginDTO();
                    UserAccount user = bankingService.findUser(loginDTO);

                    if (user != null)
                        bankingService.login(user);

                    break;

                case 2:
                    UserAccount data = bankingService.getUserAccount();

                    bankingService.createUser(data);

                    bankingService.login(data);

                    System.out.println(data.toString());

                    break;

                case 3:
                    bankingService.exitMessage();

                    return;

            }

        }

    }

}