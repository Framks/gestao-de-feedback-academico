package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.controller.log_messages.AdminLogMessages;
import com.gestao.feedback_academico.domain.dto.request.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.request.NovoAdminDto;
import com.gestao.feedback_academico.domain.dto.request.NovoProfessorDto;
import com.gestao.feedback_academico.domain.dto.response.AdminDetalhesDto;
import com.gestao.feedback_academico.domain.dto.response.ProfessorDetalhesDto;
import com.gestao.feedback_academico.domain.dto.response.UsuarioDetalhesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    /**
     * Cria um novo professor.
     *
     * @param novoProfessorDto DTO contendo os detalhes do novo professor a ser criado.
     * @return Status 201 Created se o professor for criado com sucesso.
     */
    @Operation(summary = "Criar novo professor", description = "Endpoint para criar um novo professor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Professor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/professores")
    public ResponseEntity<Void> criarProfessor(@Valid @RequestBody NovoProfessorDto novoProfessorDto) {
        log.info(AdminLogMessages.PROFESSOR_CRIADO.getMessage(), novoProfessorDto.login());
        // Implementar a lógica para criar um professor
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Cria um novo admin.
     *
     * @param novoAdminDto DTO contendo os detalhes do novo admin a ser criado.
     * @return Status 201 Created se o admin for criado com sucesso.
     */
    @Operation(summary = "Criar novo admin", description = "Endpoint para criar um novo admin.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Admin criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/admins")
    public ResponseEntity<Void> criarAdmin(@Valid @RequestBody NovoAdminDto novoAdminDto) {
        log.info(AdminLogMessages.ADMIN_CRIADO.getMessage(), novoAdminDto.login());
        // Implementar a lógica para criar um admin
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Cadastra uma nova atividade.
     *
     * @param atividadeCadastroDto DTO contendo os detalhes da nova atividade a ser cadastrada.
     * @return Status 201 Created se a atividade for cadastrada com sucesso.
     */
    @Operation(summary = "Cadastrar nova atividade", description = "Endpoint para cadastrar uma nova atividade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/atividades")
    public ResponseEntity<Void> cadastrarAtividade(@Valid @RequestBody NovaAtividadeDto atividadeCadastroDto) {
        log.info(AdminLogMessages.ATIVIDADE_CADASTRADA.getMessage(), atividadeCadastroDto.nome());
        // Implementar a lógica para cadastrar uma atividade
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Lista todos os usuários.
     *
     * @return Uma lista de {@link UsuarioDetalhesDto} contendo os detalhes de todos os usuários.
     */
    @Operation(summary = "Listar todos os usuários", description = "Endpoint para listar todos os usuários cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDetalhesDto>> listarUsuarios() {
        log.info(AdminLogMessages.USUARIOS_LISTADOS.getMessage());
        List<UsuarioDetalhesDto> usuarios = new ArrayList<>();
        // Implementar a lógica para listar todos os usuários
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    /**
     * Apaga um usuário específico.
     *
     * @param usuarioId O ID do usuário a ser apagado.
     * @return Status 204 No Content se o usuário for apagado com sucesso.
     */
    @Operation(summary = "Apagar um usuário", description = "Endpoint para apagar um usuário específico pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário apagado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/usuarios/{usuarioId}")
    public ResponseEntity<Void> apagarUsuario(@PathVariable @NotNull @Positive Long usuarioId) {
        log.info(AdminLogMessages.USUARIO_APAGADO.getMessage(), usuarioId);
        // Implementar a lógica para apagar um usuário
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Lista todos os professores cadastrados.
     *
     * @return Uma lista de {@link ProfessorDetalhesDto} contendo os detalhes de todos os professores cadastrados.
     */
    @Operation(summary = "Listar todos os professores", description = "Endpoint para listar todos os professores cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professores listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/professores")
    public ResponseEntity<List<ProfessorDetalhesDto>> listarProfessores() {
        log.info(AdminLogMessages.PROFESSORES_LISTADOS.getMessage());
        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Lista todos os admins cadastrados.
     *
     * @return Uma lista de {@link AdminDetalhesDto} contendo os detalhes de todos os admins cadastrados.
     */
    @Operation(summary = "Listar todos os admins", description = "Endpoint para listar todos os admins cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admins listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/admins")
    public ResponseEntity<List<AdminDetalhesDto>> listarAdmins() {
        log.info(AdminLogMessages.ADMINS_LISTADOS.getMessage());

        return ResponseEntity.ok(new ArrayList<>());
    }

    /**
     * Obtém os detalhes de um professor específico pela matrícula.
     *
     * @param matricula A matrícula do professor a ser consultado.
     * @return Os detalhes do professor.
     */
    @Operation(summary = "Obter detalhes de um professor", description = "Endpoint para obter detalhes de um professor específico pela matrícula.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do professor obtidos com sucesso"),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/professores/{matricula}")
    public ResponseEntity<ProfessorDetalhesDto> obterDetalhesProfessor(@PathVariable @NotNull @Positive Long matricula) {
        log.info(AdminLogMessages.PROFESSOR_DETALHES.getMessage(), matricula);

        return ResponseEntity.ok(null);
    }
}
