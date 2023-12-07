package com.example.houduan.dao;

import com.example.houduan.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessDao extends JpaRepository<Business, Integer> {
    Business findByBusinessName(String business_name);
    Business findByBusinessId(Integer business_id);
    Business findByBusinessNameAndPassword(String business_name, String password);
}
