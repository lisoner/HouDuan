package org.example.dao;// CustomerDao.java
import org.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
    Customer findByNameAndPassword(String name, String password);
}
