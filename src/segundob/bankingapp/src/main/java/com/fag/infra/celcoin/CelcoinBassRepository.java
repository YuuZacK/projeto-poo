package com.fag.infra.celcoin;

import com.fag.domain.repositories.IBassRepository;

public class CelcoinBassRepository implements IBassRepository {

    //gerar token

    @Override
    public String consultarBoleto(String linhaDigitável) {
        System.out.println("Consultando Boleto " + linhaDigitável + " na celcoin");

        return "";
    }

    @Override
    public String pagarBoleto(String dadosBoletoConsultado) {
        System.out.println("Pagando Boleto " + dadosBoletoConsultado + " na celcoin");

        return "";
    }

    @Override
    public String gerarQRCode(String dadosPix) {
        System.out.println("Gerando QR Code Pix " + dadosPix + " na celcoin");

        return "";
    }

}

