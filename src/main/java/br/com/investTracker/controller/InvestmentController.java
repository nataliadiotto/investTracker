package br.com.investTracker.controller;

import br.com.investTracker.dto.InvestmentDTO;
import br.com.investTracker.model.Investment;
import br.com.investTracker.service.InvestUpdateRequest;
import br.com.investTracker.service.InvestmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvestmentController {

    private final InvestmentService investmentService;

    @Autowired
    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping("/investment")
    public ResponseEntity<Investment> addInvestment(@RequestBody @Valid InvestmentDTO investmentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(investmentService.addInvestment(investmentDTO));
    }

    @GetMapping("/investments")
    public ResponseEntity<List<Investment>> listAllInvestments() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(investmentService.listAll());
        }

    @PatchMapping("/investment/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable("id") Long id,
                                                       @RequestBody InvestUpdateRequest updateRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(investmentService.updateInvestment(id, updateRequest));
    }


    @DeleteMapping("investment/{id}")
    public ResponseEntity<Investment> deleteInvestment (@PathVariable("id") Long id,
                                                        @RequestBody InvestmentDTO investmentDTO) {
        investmentService.removeInvestment(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}