package com.restapi.logapi.logApi.domain.repository;

import com.restapi.logapi.logApi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long> {

}
