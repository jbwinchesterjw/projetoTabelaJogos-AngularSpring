package com.projeto.tabelajogos.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.tabelajogos.domain.DetalhesErro;
import com.projeto.tabelajogos.excepition.JogosExistenteExcepition;
import com.projeto.tabelajogos.excepition.JogosNaoExistenteExcepiton;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	/**
	 * Metodo responsalve por verificar se o jogo nao existe no banco de dados
	 * @param 
	 * @param request
	 * @return
	 */
	@ExceptionHandler(JogosNaoExistenteExcepiton.class)
	public ResponseEntity<DetalhesErro> handleJogoNaoEncontradoException
							(JogosNaoExistenteExcepiton e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Jogo não pôde ser encontrado");
		//erro.setMensagemDesenvolvedor("http://erros.mensagem.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	/**
	 * Metodo responsalve por verificar se o jogo ja existe no banco de dados
	 * @param 
	 * @param request
	 * @return
	 */
	@ExceptionHandler(JogosExistenteExcepition.class)
	public ResponseEntity<DetalhesErro> handleJogoExistenteException
							(JogosExistenteExcepition e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Jogo já existente");
		//erro.setMensagemDesenvolvedor("http://erros.mensagem.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	/**
	 * Metodo responsalve por verificar as requisições feita para o sevidor
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
							(DataIntegrityViolationException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida");
		//erro.setMensagemDesenvolvedor("http://erros.mensagem.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
