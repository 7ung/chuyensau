/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.repositories;

import com.se214h12.nhom4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Stevie
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
