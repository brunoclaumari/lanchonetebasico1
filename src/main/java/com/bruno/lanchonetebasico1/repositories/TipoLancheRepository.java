package com.bruno.lanchonetebasico1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.lanchonetebasico1.model.TipoLanche;

@Repository
public interface TipoLancheRepository extends JpaRepository<TipoLanche, Long> {

}
