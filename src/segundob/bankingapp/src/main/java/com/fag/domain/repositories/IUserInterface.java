package com.fag.domain.repositories;

import com.fag.domain.dto.BanksLipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccount;

public interface IUserInterface {

    String getBarcode();

    BanksLipDTO getPaymentBanksLipInfo();

    void showBankingLipData(String data);

    Double getPixData();

    void showPixData(String data);

    Integer showInitialScreenMenu();

    Integer showHomeMenu(String userName);

    LoginDTO getLoginData();

    UserAccount getCreatedUserData();

    void showErrorMsg(String msg);

    void showExitMessage();

}
