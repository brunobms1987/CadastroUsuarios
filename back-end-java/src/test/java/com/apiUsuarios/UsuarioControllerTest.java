package com.apiUsuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.apiUsuarios.controller.UsuarioController;
import com.apiUsuarios.domain.Usuario;
import com.apiUsuarios.dto.UsuarioDTO;
import com.apiUsuarios.service.UsuarioService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();

        // Configurar o contexto do request
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void testCadastrarPessoaSucesso() throws Exception {
        // Configurar comportamento esperado do serviço mockado
        
        String requestBody = "{\n" +
                "  \"nome\": \"Bruno\",\n" +
                "  \"email\": \"bruno@bruno.com/testes\",\n" +
                "  \"senha\": \"testes123\",\n" +
                "  \"confirmarSenha\": \"testes123\",\n" +
                "}";  // Forneça o corpo JSON de uma pessoa válida

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                        .andExpect(status().isOk());
                //.andExpect(content().json("Boa")); // Forneça o conteúdo JSON da resposta esperada
    }

    // Outros testes para os métodos do controller
}