package com.projeto.tabelajogos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.tabelajogos.domain.Jogos;
import com.projeto.tabelajogos.excepition.JogosNaoExistenteExcepiton;
import com.projeto.tabelajogos.repository.IJogosRepository;

/**
 * Class JogosService responsavel por fazer as validaçoes antes dos dados serem salvos
 * @author jbwin
 *
 */
@Service
public class JogosService {

	@Autowired
	private IJogosRepository jogosRepository;

	/**
	 * Metodo responsavel por lista todos os dados
	 * @return
	 */
	public List<Jogos> listar() {
		return jogosRepository.findAll();
	}

	/**
	 * Metodo responsavel por fazer os caulculos dos recordes e salvar no banco
	 * @param jogo
	 * @return
	 */
	public Jogos salvar(Jogos jogo) {
		 Jogos last = jogosRepository.findTopByOrderByIdDesc();

		if (jogosRepository.count() > 0) {
			last = jogosRepository.findTopByOrderByIdDesc();
		}

		if (last != null) {
			
			if (last.getMinimoTemporada() > jogo.getPlacar()) {
				jogo.setMinimoTemporada(jogo.getPlacar());
				
				jogo.setRecordeMinimo(last.getRecordeMinimo()+1);
			}
			
			else {
				jogo.setMinimoTemporada(last.getMinimoTemporada());
				jogo.setRecordeMinimo(last.getRecordeMinimo());
			}
			
			if (last.getMaximoTemporada() < jogo.getPlacar()) {
				jogo.setMaximoTemporada(jogo.getPlacar());
				
				jogo.setRecordeMaximo(last.getRecordeMaximo()+1);
			}
			
			else {
				jogo.setMaximoTemporada(last.getMaximoTemporada());
				jogo.setRecordeMaximo(last.getRecordeMaximo());
			}
			
		} else {
			jogo.setMinimoTemporada(jogo.getPlacar());
			jogo.setMaximoTemporada(jogo.getPlacar());
			jogo.setRecordeMinimo(0);
			jogo.setRecordeMaximo(0);
		}
		
		return jogosRepository.save(jogo);
	}
	

	/**
	 * Metodo responsalve por fazer pesquisa por id
	 * @param id
	 * @return
	 */
	public Optional<Jogos> buscar(Long id) {
		Optional<Jogos> j = jogosRepository.findById(id);

		if (j == null) {
			throw new JogosNaoExistenteExcepiton("O jogo não pôde ser encontrado.");
		}
		return j;
	}

	/**
	 * Metodo responsavel por deleatar dados
	 * @param id
	 */
	public void deletar(Long id) {
		try {
			jogosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new JogosNaoExistenteExcepiton("O jogo não pôde ser encontrado.");
		}
	}

	/**
	 * Metodo responsalvel por atualizar dados
	 * @param jogos
	 */
	public void atualizar(Jogos jogos) {
		verificarExistencia(jogos);
		jogosRepository.save(jogos);
	}

	/**
	 * Metodo responsalvel por verificar se o dado existe
	 * @param jogos
	 */
	private void verificarExistencia(Jogos jogos) {
		buscar(jogos.getId());
	}

}
