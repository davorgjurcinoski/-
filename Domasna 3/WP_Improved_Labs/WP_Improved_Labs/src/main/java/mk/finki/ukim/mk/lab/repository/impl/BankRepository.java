package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository <Bank, Long> {
}
