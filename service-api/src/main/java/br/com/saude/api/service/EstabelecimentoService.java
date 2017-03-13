package br.com.saude.api.service;

import br.com.saude.api.domain.entity.Estabelecimento;
import br.com.saude.api.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tawan on 2/28/17.
 */
@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void salvarEstabelecimentos(List<Estabelecimento> estabelecimentos) {
        estabelecimentos.forEach(e -> {
            if (isExisteEstabelecimento(e.getCodUnidade())) {
                estabelecimentoRepository.save(e);
            }
        });
    }

    @Transactional(readOnly = true)
    private Boolean isExisteEstabelecimento(String codUnidade) {
        return estabelecimentoRepository.findByCodUnidade(codUnidade).isEmpty();
    }

    @Transactional(readOnly = true)
    public Page<Estabelecimento> buscar(int offset, int limit) {
        Pageable pageable = new PageRequest(offset, limit);
        return estabelecimentoRepository.findAll(pageable);
    }
}
