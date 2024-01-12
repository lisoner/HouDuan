package org.example.dao;
import org.example.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDao extends JpaRepository<Business, Long> {
    Business findByNameAndPassword(String name, String password);
}
