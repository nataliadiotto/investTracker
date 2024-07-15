package br.com.investTracker.repository;

import br.com.investTracker.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
