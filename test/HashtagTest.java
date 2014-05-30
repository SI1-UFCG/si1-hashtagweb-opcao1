

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import models.Hashtag;
import models.JogadaInvalidaException;

import org.junit.Before;
import org.junit.Test;

public class HashtagTest {

	private Hashtag hashtag;

	@Before
	public void setup() {
		hashtag = new Hashtag();
	}

	@Test
	public void devePossuirTabuleiroVazioNoInicio() {
		assertTrue(hashtag.isEmpty());
	}

	@Test
	public void deveAlternarJogadasEntreJogadores() throws Exception {
		char jogador1 = hashtag.getJogadorNaVez();
		hashtag.jogar(0, 0);

		char jogador2 = hashtag.getJogadorNaVez();

		assertNotEquals(jogador1, jogador2);

		hashtag.jogar(0, 1);

		char jogador3 = hashtag.getJogadorNaVez();

		assertEquals(jogador1, jogador3);
	}

	@Test
	public void devePermitirJogadasApenasEmCasasVazias() throws Exception {
		
		hashtag.jogar(0, 0);
		char j1 = hashtag.getJogadorNaVez();
		try{
			hashtag.jogar(0, 0);
			fail();
		}catch(JogadaInvalidaException e){
			//ok
		}
		
		assertEquals(j1, hashtag.getJogadorNaVez());
		hashtag.jogar(0, 1);
		assertNotEquals(j1, hashtag.getJogadorNaVez());
	}
}
