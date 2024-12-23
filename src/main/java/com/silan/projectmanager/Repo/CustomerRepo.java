package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {

}
