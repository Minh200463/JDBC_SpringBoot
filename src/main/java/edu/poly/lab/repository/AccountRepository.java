package edu.poly.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.lab.model.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, String> {

}
