package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepository extends JpaRepository <Atm, Long>{
}
