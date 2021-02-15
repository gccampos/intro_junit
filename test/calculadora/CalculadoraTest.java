package calculadora;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

	private Calculadora calc;

	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}

	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);
		Assertions.assertEquals(9, soma);
	}

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(5, 4);
		Assertions.assertEquals(1, subtracao);
	}

	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(5, 4);
		Assertions.assertEquals(20, multiplicacao);
	}

	@DisplayName("Testa a divisão de dois números")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@DisplayName("Testa a divisão de um número por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		} catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}
	}

	@DisplayName("Testa the division de um número por zero com exception")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@DisplayName("Testa a somatória de um número")
	@Test
	public void testSomatoria() {
		int somatoria = 10;
		assertEquals(calc.somatoria(4), somatoria);
	}

	@DisplayName("Testa se um número é positivo")
	@Test
	public void testEhPositivo() {
		int numero = -10;
		assertTrue(!calc.ehPositivo(numero));
	}

	@DisplayName("Testa se um número é igual a outro")
	@Test
	public void testCompara() {
		int num1 = 1;
		int num2 = 4;
		assertAll("compara",
				() -> assertEquals(0, calc.compara(num1, num1)),
				() -> assertEquals(1, calc.compara(num2, num1)),
				() -> assertEquals(-1, calc.compara(num1, num2))
		);
	}

}
