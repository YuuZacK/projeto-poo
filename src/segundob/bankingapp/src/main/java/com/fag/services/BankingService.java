package com.fag.services;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccount;
import com.fag.domain.repositories.IBassRepository;
import com.fag.domain.repositories.IUserInterface;
import com.fag.domain.repositories.IUserRepository;

public class BankingService {

    private IUserInterface gui;

    private IUserRepository userDB;

    private IBassRepository bassRepository;

    private Integer accountnumber = 1;

    public BankingService(IUserInterface gui, IUserRepository userDB,
        IBassRepository bassRepository) {

        this.gui = gui;

        this.userDB = userDB;

        this.bassRepository = bassRepository;
    }

    public Integer showMenu() {
        return gui.showInitialScreenMenu();
    }

    public LoginDTO getLoginDTO() {
        return gui.getLoginData();
    }

    public UserAccount getUserAccount() {
        UserAccount data = gui.getCreatedUserData();
        String uuid = UUID.randomUUID().toString();

        data.setId(uuid);
        data.setAccountnumber(accountnumber.toString());
        data.setCreatedAt(LocalDateTime.now());

        accountnumber++;

        return data;
    }

    public void exitMessage() {
        gui.showExitMessage();
    }

    public void login(UserAccount userAccount) {
        Integer option = gui.showHomeMenu(userAccount.getName());

        switch (option) {
            case 1:
                bassRepository.consultarBoleto("Consultar Boleto");
                break;

            case 2:
                bassRepository.pagarBoleto("Pagar Boleto");
                break;

            case 3:
                bassRepository.gerarQRCode("Gerar QR Code");
                break;

                case 4:
                gui.showExitMessage();
                return;
        }

    }

    public UserAccount createUser(UserAccount user) {
        return userDB.createUser(user);
    }

    public UserAccount findUser(LoginDTO loginDTO) {
        UserAccount user = userDB.findUserby(loginDTO.getDocument());

        if (user == null) {
            gui.showErrorMsg("O Usuário não foi encontrado");
        }

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            gui.showErrorMsg("Credencial Inválida");
        }

        return user;
    }

}