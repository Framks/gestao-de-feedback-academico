
import {Link, Outlet} from "react-router-dom"
import AuthService from "./services/AuthService";
import logout from "./login/LogOut";

const Home = () => {

    const role = AuthService.getRole();

    return(
        <div>
            <div className="navbar navbar-expand-lg bg-dark">
                <div className="container-fluid">
                    <a className="navbar-brand text-white " href="/">Home</a>
                    <button className="navbar-toggler bg-secondary bg-gradient" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            
                            <li className="nav-item dropdown">
                                <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Aulas</a>
                                <ul className="dropdown-menu bg-dark">
                                    {role === "ALUNO" && (
                                        <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/aula/avaliacao/">Avaliar Aulas</Link>
                                        </li>
                                    )}
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/aula/listar/">Ver Avaliações</Link>
                                    </li>
                                    { (role === "PROFESSOR") && (
                                        <>
                                            <li>
                                                <Link className="dropdown-item bg-dark text-white" to="/aula/criar/">Cadastrar Aula</Link>
                                            </li>
                                            <li>
                                                <Link className="dropdown-item bg-dark text-white" to="/aula/">Ver Aulas</Link>
                                            </li>
                                        </>
                                    )}
                                </ul>
                            </li>
                            {
                                (role === 'ALUNO' || role === 'PROFESSOR') && (
                                    <li className="nav-item dropdown">
                                    <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Atividades</a>
                                    <ul className="dropdown-menu bg-dark">
                                        {role === 'ALUNO' && (
                                            <li>
                                                <Link className="dropdown-item bg-dark text-white" to="/atividade/avaliar">Avaliar Atividades</Link>
                                            </li>
                                        )}
                                        {role === 'PROFESSOR' && (
                                            <>
                                                <li>
                                                    <Link className="dropdown-item bg-dark text-white" to="/atividade/criar/">Criar Atividade</Link>
                                                </li>
                                                <li>
                                                    <Link className="dropdown-item bg-dark text-white" to="/atividade/listar/">Ver Atividades</Link>
                                                </li>
                                            </>
                                        )}
                                        <li>
                                            <Link className="dropdown-item bg-dark text-white" to="/atividade/avaliacao/">Avaliações Atividades</Link>
                                        </li>
                                    </ul>
                                </li>
                                )
                            }
                            {
                                (role === 'PROFESSOR' || role === 'ADMIN') && (
                                    <>
                                        <li className="nav-item dropdown">
                                            <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Turmas</a>
                                            <ul className="dropdown-menu bg-dark">
                                                <li><Link className="dropdown-item bg-dark text-white" to="/turma/criar/">Criar Turma</Link></li>
                                                <li><Link className="dropdown-item bg-dark text-white" to="/turma/listar/">Ver Turmas</Link></li>
                                            </ul>
                                        </li>
                                        <li className="nav-item dropdown">
                                            <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Alunos</a>
                                            <ul className="dropdown-menu bg-dark">
                                                <li><Link className="dropdown-item bg-dark text-white" to="/aluno/listar/">Cadastrar Aluno</Link></li>
                                                <li><Link className="dropdown-item bg-dark text-white" to="/aluno/listar/">Ver Alunos</Link></li>
                                            </ul>
                                        </li>
                                    </>
                                )
                            }
                            {
                                role === 'ADMIN' && (
                                    <li className="nav-item dropdown">
                                        <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Professor</a>
                                        <ul className="dropdown-menu bg-dark">
                                            <li><Link className="dropdown-item bg-dark text-white" to="/professor/criar/">Cadastrar Professor</Link></li>
                                            <li><Link className="dropdown-item bg-dark text-white" to="/professor/listar/">Ver Professores</Link></li>
                                        </ul>
                                    </li>
                                )
                            }
                        </ul>
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <button className="btn btn-danger" onClick={() => logout()}>Logout</button>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link text-white" to="/perfil">Perfil</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <Outlet/>
        </div>
    )
}

export default Home;