package com.cognizant.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userControllerRepository extends JpaRepository<user,String> {

}
