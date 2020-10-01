package com.projeto.tabelajogos.excepition;

/**
 * Metodo responsavel por lançar uma exeção caso ja tenha o mesmo dado cadatrado
 * @author jbwin
 *
 */
public class JogosExistenteExcepition extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public JogosExistenteExcepition(String mensagem) {
		super(mensagem);
	}
	
	public JogosExistenteExcepition(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
