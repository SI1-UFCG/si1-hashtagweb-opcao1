package controllers;

import models.Hashtag;
import models.JogadaInvalidaException;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	private static Hashtag jogoAtual = new Hashtag();

	public static Result index() {
		return ok(index.render("jogo rolando", jogoAtual));
	}

	public static Result jogada() {
		DynamicForm requestData = Form.form().bindFromRequest();

		int x = Integer.parseInt(requestData.get("x"));
		int y = Integer.parseInt(requestData.get("y"));

		try {
			jogoAtual.jogar(x, y);
		} catch (JogadaInvalidaException e) {
			return ok(index.render("Jogada inválida: " + e.getMessage(), jogoAtual));
		}

		return ok(index.render("e o jogo continua", jogoAtual));
	}
}
