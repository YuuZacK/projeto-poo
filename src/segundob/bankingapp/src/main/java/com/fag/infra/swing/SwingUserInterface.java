package com.fag.infra.swing;

import javax.swing.JOptionPane;

import com.fag.domain.dto.BanksLipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccount;
import com.fag.domain.repositories.IUserInterface;

public class SwingUserInterface implements IUserInterface {

    @Override
    public Integer showInitialScreenMenu() {
        String menu = "--------BANCO DIGITAL BALA-------\n"
                .concat("[1] Login\n")
                .concat("[2] Cadastro\n")
                .concat("[3] Sair");

        String escolha = JOptionPane.showInputDialog(null, menu, "Menu Show", JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(escolha);
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO loginData = new LoginDTO();

        String document = JOptionPane.showInputDialog(null, "Digite seu documento");
        if (document == null) {
            return null;
        }

        String password = JOptionPane.showInputDialog(null, "Digite sua senha");
        if (password == null) {
            return null;
        }

        loginData.setDocument(document);
        loginData.setPassword(password);

        return loginData;
    }

    @Override
    public UserAccount getCreatedUserData() {
        UserAccount userAccount = new UserAccount();
        String document = JOptionPane.showInputDialog(null, "Informe seu documento", "Informe seus dados", 1);

        String name = JOptionPane.showInputDialog(null, "Informe seu nome", "Informe seus dados", 0);

        String email = JOptionPane.showInputDialog(null, "Informe seu email", "Informe seus dados", 1);

        String password = JOptionPane.showInputDialog(null, "Digite sua senha", "Informe seus dados" ,0);

        userAccount.setDocument(document);
        userAccount.setName(name);
        userAccount.setEmail(email);
        userAccount.setPassword(password);

        return userAccount;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        String menu = "Bem Vindo " + userName + "\n"
                .concat("[1] Consulta Boleto\n")
                .concat("[2] Pagar Boleto\n")
                .concat("[3] Gerar QR Code\n")
                .concat("[4] Logout");

        String escolha = JOptionPane.showInputDialog(null, menu, "Menu Show", JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(escolha);
    }

    @Override
    public void showErrorMsg(String msg) {
        JOptionPane.showMessageDialog(null, "Erro", msg, JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showExitMessage() {
        JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação", "Flw!", JOptionPane.CANCEL_OPTION);
    }

    @Override
    public String getBarcode() {
        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser consultado",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);

        return barcode;
    }

    @Override
    public BanksLipDTO getPaymentBankslipInfo() {
        BanksLipDTO bankslipDTO = new BanksLipDTO();

        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser pago",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);
        String transactionId = JOptionPane.showInputDialog(
                null,
                "Insira o identificador de pagamento",
                "Identificador",
                JOptionPane.INFORMATION_MESSAGE);

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(transactionId);

        return bankslipDTO;
    }

    @Override
    public void showBankslipData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados boleto",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showPixData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados PIX",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Double getPixData() {
        String amount = JOptionPane.showInputDialog(
                null,
                "Insira o valor do PIX",
                "Valor transação",
                JOptionPane.INFORMATION_MESSAGE);

        return Double.parseDouble(amount);
    }

}