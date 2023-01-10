package com.nttdata.backend;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class EmployeeTest {

	@Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void consultarEmpleadoCreado() throws Exception {
    	
    	MvcResult resultadoConsultarEmpleado = mvc.perform(
                MockMvcRequestBuilders.get("/employee/consult")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ConsultEmployee("C", "23445322"))))
    			.andDo(print())
    			.andExpect(status().isOk())
                .andReturn();
    	
    	@SuppressWarnings("unused")
		ConsultEmployeeResult resultado = objectMapper.readValue(resultadoConsultarEmpleado.getResponse().getContentAsString(), ConsultEmployeeResult.class);
    	
    }
    
    @Test
    public void consultarEmpleadoCreadoParametrosInvalidos() throws Exception {
    	
    	MvcResult resultadoConsultarEmpleado = mvc.perform(
                MockMvcRequestBuilders.get("/employee/consult")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ConsultEmployee("c", "23445322"))))
    			.andDo(print())
    			.andExpect(status().isBadRequest())
                .andReturn();
    	
    	@SuppressWarnings("unused")
		ConsultEmployeeResult resultado = objectMapper.readValue(resultadoConsultarEmpleado.getResponse().getContentAsString(), ConsultEmployeeResult.class);
    	
    }
    
    @Test
    public void consultarEmpleadoCreadoParametrosObligatorios() throws Exception {
    	
    	MvcResult resultadoConsultarEmpleado = mvc.perform(
                MockMvcRequestBuilders.get("/employee/consult")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ConsultEmployee("", "23445322"))))
    			.andDo(print())
    			.andExpect(status().isBadRequest())
                .andReturn();
    	
    	@SuppressWarnings("unused")
		ConsultEmployeeResult resultado = objectMapper.readValue(resultadoConsultarEmpleado.getResponse().getContentAsString(), ConsultEmployeeResult.class);
    	
    }
    
    @Test
    public void consultarEmpleadoNoCreado() throws Exception {
    	
    	MvcResult resultadoConsultarEmpleado = mvc.perform(
                MockMvcRequestBuilders.get("/employee/consult")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ConsultEmployee("P", "23445322"))))
    			.andDo(print())
    			.andExpect(status().isNotFound())
                .andReturn();
    	
    	@SuppressWarnings("unused")
		ConsultEmployeeResult resultado = objectMapper.readValue(resultadoConsultarEmpleado.getResponse().getContentAsString(), ConsultEmployeeResult.class);
    	
    }
    
    @Test
    public void errorConsultarEmpleado() throws Exception {
    	
    	MvcResult resultadoConsultarEmpleado = mvc.perform(
                MockMvcRequestBuilders.get("/employee/consult")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ConsultEmployee())))
    			.andDo(print())
    			.andExpect(status().isInternalServerError())
                .andReturn();
    	
    	@SuppressWarnings("unused")
		ConsultEmployeeResult resultado = objectMapper.readValue(resultadoConsultarEmpleado.getResponse().getContentAsString(), ConsultEmployeeResult.class);
    	
    }
	
}
