package com.projeto.tabelajogos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.tabelajogos.domain.Jogos;
import com.projeto.tabelajogos.service.JogosService;

/**
 * Class JogosController e responsavel por fazer controler de acesso pela url
 * @author jbwin
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/jogos")
public class JogosController {

	@Autowired
	private JogosService service;

	/**
	 * Metodo responsavel por lista todos os dados cadastrados
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Jogos>> listar() {
		List<Jogos> jogos = service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(jogos);
		
	}
	
	/**
	 * Metodo responsavel por salvar os jogos  
	 * @param salvar dados
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Validated @RequestBody Jogos jogos) {

		jogos = service.salvar(jogos);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(jogos.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	/**
	 * Metodo responsavel por deletar os jogos cadastrados
	 * @param deletar dados
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * 
	 * @param Metodo responsavel por atualizar dados cadastrados
	 * @param atualizar daodos
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Jogos jogos, @PathVariable("id") Long id) {
		jogos.setId(id);
		service.atualizar(jogos);

		return ResponseEntity.noContent().build();
	}

	/**
	 * Metodo responsavel por pesquisar dados por ID especifico 
	 * @param pesquisa por id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Jogos>> buscar(@PathVariable("id") Long id) {
		Optional<Jogos> jogos = service.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(jogos);
	}
	
}

