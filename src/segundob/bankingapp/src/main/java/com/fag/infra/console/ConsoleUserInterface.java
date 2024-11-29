package com.fag.infra.console;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccount;
import com.fag.domain.repositories.IUserInterface;

public class ConsoleUserInterface implements IUserInterface {

    private Scanner inputScanner = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("--------BANCO DIGITAL BALA-------/n");
        System.out.println("[1] Login/n");
        System.out.println("[2] Cadastro/n");
        System.out.println("[3] Sair");

        Integer option = inputScanner.nextInt();

        return option;
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO loginData = new LoginDTO();

        System.out.println("Digite o seu documento\n");
        String document = inputScanner.nextLine();

        System.out.println("Digite a sua senha\n");
        String password = inputScanner.nextLine();

        loginData.setDocument(document);
        loginData.setPassword(password);

        return loginData;
    }

    @Override
    public UserAccount getCreatedUserData() {
        UserAccount userAccount = new UserAccount();

        System.out.println("Informe seu documento\n");
        String document = inputScanner.nextLine();

        System.out.println("Informe seu email\n");
        String email = inputScanner.nextLine();

        System.out.println("Informe seu nome\n");
        String name = inputScanner.nextLine();

        System.out.println("Informe sua senha\n");
        String password = inputScanner.nextLine();

        userAccount.setDocument(document);
        userAccount.setEmail(email);
        userAccount.setName(name);
        userAccount.setPassword(password);

        return userAccount;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        System.out.println("Bem vindo " + userName + "!\n");
        System.out.println(" 1- Consultar Boleto\n");
        System.out.println("2- Pagar Boleto\n");
        System.out.println("3- Gerar QR Code PIX\n");
        System.out.println("4- Logout");

        Integer option = inputScanner.nextInt();

        return option;
    }

    @Override
    public void showErrorMsg(String msg) {
        System.out.println("Erro " + msg);
    }

    @Override
    public void showExitMessage() {
        System.out.println("Obrigado por utilizar a aplicação");
    }

}