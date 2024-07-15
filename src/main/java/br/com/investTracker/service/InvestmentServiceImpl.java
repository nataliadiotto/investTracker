package br.com.investTracker.service;

import br.com.investTracker.dto.InvestmentDTO;
import br.com.investTracker.model.Investment;
import br.com.investTracker.repository.InvestmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public InvestmentServiceImpl(InvestmentRepository investmentRepository, ModelMapper modelMapper) {
        this.investmentRepository = investmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Investment> listAll() {
        List<Investment> investmentList = investmentRepository.findAll();
        if (investmentList.isEmpty()) {
            //throw new ResourceNotFoundException("investments");
        }
        return investmentList;
    }

    @Override
    public Investment addInvestment(InvestmentDTO investmentDTO) {
        Investment convertedInvestment = investmentDTO.toEntity();
        return investmentRepository.save(convertedInvestment);
    }

    @Override
    public Investment updateInvestment(Long id, InvestUpdateRequest updateRequest) {
        Optional<Investment> optionalInvestment = investmentRepository.findById(id);
        if (optionalInvestment.isPresent()) {
            Investment updatedInvestment = optionalInvestment.get();

            if (updateRequest.ticker() != null) updatedInvestment.setTicker(updateRequest.ticker());
            if (updateRequest.quantity() != null) updatedInvestment.setQuantity(updateRequest.quantity());
            if (updateRequest.buyingPrice() != null) updatedInvestment.setBuyingPrice(updateRequest.buyingPrice());
            if (updateRequest.sellingPrice() != null) updatedInvestment.setSellingPrice(updateRequest.sellingPrice());

            Investment savedInvestment = investmentRepository.save(updatedInvestment);
            return savedInvestment;

    } else {
            return null;
        }

    }

    @Override
    public void removeInvestment(Long id) {
        Optional<Investment> optionalInvestment = investmentRepository.findById(id);
        optionalInvestment.ifPresent(investment -> investmentRepository.deleteById(investment.getId()));

    }

    @Override
    public BigDecimal investmentVariation(Long id) {
        return null;
    }
}
