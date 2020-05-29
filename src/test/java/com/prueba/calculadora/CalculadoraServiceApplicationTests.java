package com.prueba.calculadora;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.prueba.calculadora.controllers.CalculadoraController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraServiceApplicationTests {

 @Autowired
	private CalculadoraController calculadoraController;

 @Autowired
 private MockMvc mockMvc;

	@Test
	void sumaTest_OK() throws Exception {
		mockMvc.perform(
				get("/suma")
					.param("operador1", String.valueOf(2))
				  .param("operador2", String.valueOf(3.2))
		).andExpect(status().isOk());
	}

	@Test
	void sumaTest_KO_1() throws Exception {
		mockMvc.perform(
				get("/suma")
						.param("operador1", "as")
						.param("operador2", String.valueOf(3.2))
		).andExpect(status().isInternalServerError());
	}

	@Test
	void sumaTest_KO_2() throws Exception {
		mockMvc.perform(
				get("/suma")
						.param("operador2", String.valueOf(3.2))
		).andExpect(status().isInternalServerError());
	}
}
