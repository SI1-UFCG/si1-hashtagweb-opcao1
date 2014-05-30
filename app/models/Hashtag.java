package models;

public class Hashtag {

	private static final char JOGADOR_O = 'O';
	private static final char JOGADOR_X = 'X';
	private static final char VAZIA = 0;
	private char jogadorDaVez;
	private char[][] tabuleiro;

	public Hashtag() {
		jogadorDaVez = 'X';
		tabuleiro = new char[3][3];
	}

	public boolean isEmpty() {
		return true;
	}

	public char getJogadorNaVez() {
		return this.jogadorDaVez;
	}

	/**
	 * 
	 * @param posicaoHorizontal
	 *            Começa em 0.
	 * @param posicaoVertical
	 *            Começa em 0.
	 */
	public void jogar(int posicaoHorizontal, int posicaoVertical)
			throws JogadaInvalidaException {
		ocupaCasa(posicaoHorizontal, posicaoVertical, jogadorDaVez);
		alternaJogadorNaVez();
	}

	private void ocupaCasa(int posicaoHorizontal, int posicaoVertical,
			char jogador) throws JogadaInvalidaException {
		if(casaDesocupada(posicaoHorizontal, posicaoVertical)){
			tabuleiro[posicaoHorizontal][posicaoVertical] = jogador;
		} else {
			throw new JogadaInvalidaException("Casa ocupada");
		}
	}

	private boolean casaDesocupada(int posicaoHorizontal, int posicaoVertical) {
		return tabuleiro[posicaoHorizontal][posicaoVertical] == VAZIA;
	}

	private void alternaJogadorNaVez() {
		if (jogadorDaVez == JOGADOR_X) {
			jogadorDaVez = JOGADOR_O;
		} else {
			jogadorDaVez = JOGADOR_X;
		}
	}

}
