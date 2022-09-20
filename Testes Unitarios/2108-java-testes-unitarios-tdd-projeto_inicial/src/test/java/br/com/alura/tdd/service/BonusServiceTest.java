package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;

	@BeforeEach // Anotação que serve para chamar o método em cada um dos testes do JUnit
	public void chamarBonus() {
		this.service = new BonusService();
	}

	@Test
	void bonusZeroParaSalarioAlto() {
		assertThrows(IllegalArgumentException.class,
			() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

	}

	@Test
	void bonusDezPorCentoDoSalarioBaixo() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2000")));
		assertEquals(new BigDecimal("200.00"), bonus);
	}

	@Test
	void bonusDezPorCentoSalarioIgualADezMil() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
