package br.com.saude.api.repository;

import br.com.saude.api.domain.entity.Estabelecimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tawan on 2/28/17.
 */
@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    @Query(" select e from Estabelecimento e " +
            " where e.codUnidade = :codUnidade ")
    List<Estabelecimento> findByCodUnidade(@Param("codUnidade") String codUnidade);

    @Override
    Page<Estabelecimento> findAll(Pageable page);
}
