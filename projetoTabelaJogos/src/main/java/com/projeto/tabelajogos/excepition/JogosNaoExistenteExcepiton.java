package com.projeto.tabelajogos.excepition;

/**
 * Metodo responsavel por lançar uma exeção caso não encontre enm um dado cadatrado
 * @author jbwin
 *
 */
public class JogosNaoExistenteExcepiton extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public JogosNaoExistenteExcepiton(String mensagem) {
		super(mensagem);
	}
	
	public JogosNaoExistenteExcepiton(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
