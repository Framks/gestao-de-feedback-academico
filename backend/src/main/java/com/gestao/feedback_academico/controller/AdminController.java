package com.gestao.feedback_academico.controller;

import com.gestao.feedback_academico.domain.usecase.AdminService;
import com.gestao.feedback_academico.domain.dto.NovaAtividadeDto;
import com.gestao.feedback_academico.domain.dto.NovoAdminDto;
import com.gestao.feedback_academico.domain.dto.NovoProfessorDto;
import com.gestao.feedback_academico.domain.dto.AdminDetalhesDto;
import com.gestao.feedback_academico.domain.dto.AtividadeDetalhesDto;
import com.gestao.feedback_academico.domain.dto.ProfessorDetalhesDto;
import com.gestao.feedback_academico.domain.dto.UsuarioDetalhesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    /**
     * Cria um novo professor.
     *
     * @param novoProfessorDto DTO contendo os dados do novo professor.
     * @return Detalhes do professor criado.
     */
    @Operation(
            summary = "Criar novo professor",
            description = "Endpoint para criar um novo professor.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Professor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/professores")
    public ResponseEntity<ProfessorDetalhesDto> criarProfessor(
            @Parameter(description = "DTO contendo os dados do novo professor", required = true)
            @Valid @RequestBody NovoProfessorDto novoProfessorDto
    ) {
        ProfessorDetalhesDto professorCriado = adminService.criarProfessor(novoProfessorDto);
        return new ResponseEntity<>(professorCriado, HttpStatus.CREATED);
    }

    /**
     * Cria um novo admin.
     *
     * @param novoAdminDto DTO contendo os dados do novo admin.
     * @return Detalhes do admin criado.
     */
    @Operation(
            summary = "Criar novo admin",
            description = "Endpoint para criar um novo admin.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Admin criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos, por exemplo, campos obrigatórios ausentes"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/admins")
    public ResponseEntity<AdminDetalhesDto> criarAdmin(
            @Parameter(description = "DTO contendo os dados do novo admin", required = true)
            @Valid @RequestBody NovoAdminDto novoAdminDto
    ) {
        AdminDetalhesDto adminCriado = adminService.criarAdmin(novoAdminDto);
        return new ResponseEntity<>(adminCriado, HttpStatus.CREATED);
    }

    /**
     * Cadastra uma nova atividade.
     *
     * @param atividadeCadastroDto DTO contendo os dados da nova atividade.
     * @return Detalhes da atividade cadastrada.
     */
    @Operation(
            summary = "Cadastrar nova atividade",
            description = "Endpoint para cadastrar uma nova atividade.",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Atividade cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos, por exemplo, campos obrigatórios ausentes"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/atividades")
    public ResponseEntity<AtividadeDetalhesDto> cadastrarAtividade(
            @Parameter(description = "DTO contendo os dados da nova atividade", required = true)
            @Valid @RequestBody NovaAtividadeDto atividadeCadastroDto
    ) {
        AtividadeDetalhesDto atividadeCriada = adminService.cadastrarAtividade(atividadeCadastroDto);
        return new ResponseEntity<>(atividadeCriada, HttpStatus.CREATED);
    }

    /**
     * Lista todos os usuários cadastrados.
     *
     * @return Lista de detalhes dos usuários.
     */
    @Operation(
            summary = "Listar todos os usuários",
            description = "Endpoint para listar todos os usuários cadastrados.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDetalhesDto>> listarUsuarios() {
        List<UsuarioDetalhesDto> usuarios = adminService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    /**
     * Apaga um usuário específico pelo login.
     *
     * @param login Login do usuário a ser apagado.
     * @return Resposta indicando que a operação foi bem-sucedida.
     */
    @Operation(
            summary = "Apagar um usuário",
            description = "Endpoint para apagar um usuário específico pelo login.",
            method = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário apagado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado, por exemplo, login inexistente"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/usuarios/{login}")
    public ResponseEntity<Void> apagarUsuario(
            @Parameter(description = "Login do usuário a ser apagado", required = true)
            @PathVariable @NotNull String login
    ) {
        adminService.apagarUsuario(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Lista todos os professores cadastrados.
     *
     * @return Lista de detalhes dos professores.
     */
    @Operation(
            summary = "Listar todos os professores",
            description = "Endpoint para listar todos os professores cadastrados.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professores listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/professores")
    public ResponseEntity<List<ProfessorDetalhesDto>> listarProfessores() {
        List<ProfessorDetalhesDto> professorDetalhesDtoList = adminService.listarProfessores();
        return ResponseEntity.ok(professorDetalhesDtoList);
    }

    /**
     * Lista todos os admins cadastrados.
     *
     * @return Lista de detalhes dos admins.
     */
    @Operation(
            summary = "Listar todos os admins",
            description = "Endpoint para listar todos os admins cadastrados.",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admins listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/admins")
    public ResponseEntity<List<AdminDetalhesDto>> listarAdmins() {
        List<AdminDetalhesDto> adminDetalhesDtoList = adminService.listarAdmins();
        return ResponseEntity.ok(adminDetalhesDtoList);
    }

    /**
     * Obtém detalhes de um professor específico pela matrícula.
     *
     * @param matricula Matrícula do professor a ser consultado.
     * @return Detalhes do professor consultado.
     */
    @Operation(
            summary = "Obter detalhes de um professor",
            description = "Endpoint para obter detalhes de um professor específico pela matrícula.",
            method = "GET",
            parameters = @Parameter(
                    name = "matricula",
                    in = ParameterIn.PATH,
                    description = "Matrícula do professor para obter detalhes",
                    required = true,
                    schema = @Schema(type = "integer", format = "int64")
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalhes do professor obtidos com sucesso"),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado, por exemplo, matrícula inexistente"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/professores/{matricula}")
    public ResponseEntity<ProfessorDetalhesDto> obterDetalhesProfessor(
            @Parameter(description = "Matrícula do professor para obter detalhes", required = true)
            @PathVariable @NotNull @Positive Long matricula
    ) {
        ProfessorDetalhesDto professorDetalhesDto = adminService.obterDetalhesProfessor(matricula);
        return ResponseEntity.ok(professorDetalhesDto);
    }
}
