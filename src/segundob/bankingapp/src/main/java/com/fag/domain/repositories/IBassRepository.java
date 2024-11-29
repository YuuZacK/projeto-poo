package com.fag.domain.repositories;

import com.fag.domain.dto.BanksLipDTO;

public interface IBassRepository {
    String consultarBoleto(String linhaDigitável);

    String pagarBoleto(String dadosBoletoConsultado);
    
    String gerarQRCode(String dadosPix);

    
}
