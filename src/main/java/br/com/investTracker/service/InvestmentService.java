package br.com.investTracker.service;

import br.com.investTracker.dto.InvestmentDTO;
import br.com.investTracker.model.Investment;

import java.math.BigDecimal;
import java.util.List;

public interface InvestmentService {

    List<Investment> listAll();

    Investment addInvestment(InvestmentDTO investmentDTO);

    Investment updateInvestment(Long id, InvestUpdateRequest updateRequest);

    void removeInvestment(Long id);

    BigDecimal investmentVariation(Long id);

    //List<Investment> filterByName(???)

}
