package com.example.houduan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessId;
    private String businessName;
    private String password;

    public String toString(){
        return "Business{"+
                "ID=" + businessId + '\'' +
                "name" + businessName + '\'' +
                "password" + password + '\'' +
                "}";
    }

}
