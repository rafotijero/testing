package com.codigo.unit_testing;

import com.codigo.unit_testing.aggregates.request.EmpresaRequest;
import com.codigo.unit_testing.aggregates.response.BaseResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testSumaAssertNotEquals() {
		// ARRANGE
		int resultadoEsperado = 10;
		int actual;

		//ACT: Ejecutamos la prueba
		actual = 5 + 5;

		//ASSERT: Afirmar el resultado esperado
		assertNotEquals(resultadoEsperado, actual, "Los valores deben ser diferentes tanto el esperado como el actual ");
	}

	@Test
	void testAssertTrue() {
		// ARRANGE
		boolean condicion;

		// ACT
		condicion = 1 > 2;

		// ASSERT
		assertTrue(condicion, "El primer valor debe ser mayor al segundo");

	}

	@Test
	void testAssertFalse() {
		// ARRANGE
		boolean condicion;

		// ACT
		condicion = 1 > 2;

		// ASSERT
		assertFalse(condicion, "El primer valor no debe ser mayor al segundo");

	}

	@Test
	void testAssertNull() {
		String dato = null;

		assertNull(dato, "El valor esperado no es nulo");
	}

	@Test
	void testAssertNotNull() {
		String dato = null;

		dato = "Hola";

		assertNotNull(dato, "El valor esperado no es nulo");
	}

	@Test
	void testAssertArrayEquals() {
		int[] arregloEsperado = {1,2,3};
		int[] actual = {1,2,3};

		assertArrayEquals(arregloEsperado, actual, "Los arreglos deben ser iguales");
	}

	@Test
	void testAssertThrows() {

		assertThrows(ArithmeticException.class, () -> {
			int resultado = 10 / 0;
		}, "La excepción generada no es la que se espera");

	}

	@Test
	void testAssertSame() {

		String dato1 = "1";
		String dato2 = "1";
		String dato3 = new String("1");

		assertSame(dato1, dato3);

	}

	@Test
	void testAssertSame1() {
		EmpresaRequest instancia1 = SingleService.getInstance();
		instancia1.setDistrito("Jesús María");
		EmpresaRequest instancia2 = SingleService.getInstance();
		EmpresaRequest instancia3 = new EmpresaRequest();

		assertSame(instancia1, instancia3, "Las instancias no son iguales");
	}

	@Test
	void testAssertSame2() {
		BaseResponse instancia1 = SingleService.getInstanceBaseResponse();
		BaseResponse instancia2 = SingleService.getInstanceBaseResponse();
		BaseResponse instancia3 = new BaseResponse<>();
		BaseResponse instancia4 = new BaseResponse<>();

		assertSame(instancia1, instancia3, "Las instancias no son iguales");
	}

}
