package br.com.saude.api.application;


import br.com.saude.api.domain.entity.Estabelecimento;
import br.com.saude.api.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tawan on 2/28/17.
 */
@RestController
@RequestMapping(value = "/estabelecimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstabelecimentoRestController {

    private static final Integer QTD_ESTABELECIMENTOS = 5000;

    private static final String URL_API_ESTABELECIMENTOS = "http://mobile-aceite.tcu.gov.br:80/mapa-da-saude/rest/estabelecimentos?quantidade=" + QTD_ESTABELECIMENTOS;

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @RequestMapping(value = "/consultar/dados", method = RequestMethod.GET)
    public ResponseEntity manterEstabelecimentos() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> request = RequestEntity
                .get(URI.create(URL_API_ESTABELECIMENTOS))
                .build();

        ResponseEntity<Estabelecimento[]> response = restTemplate.exchange(request, Estabelecimento[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            estabelecimentoService.salvarEstabelecimentos(Arrays.asList(response.getBody()));
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscar/{offset}/{limit}",method = RequestMethod.GET)
    public ResponseEntity<List<Estabelecimento>> buscar(@PathVariable("offset") int offset,
                                                        @PathVariable("limit") int limit) {
        return new ResponseEntity<List<Estabelecimento>>(estabelecimentoService.buscar(offset, limit), HttpStatus.OK);

    }

}
