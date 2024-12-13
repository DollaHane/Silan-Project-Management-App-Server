package com.silan.projectmanager.Repo;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Ulid> {

}
