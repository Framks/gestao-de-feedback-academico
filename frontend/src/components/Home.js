
import {Link, Outlet} from "react-router-dom"

const Home = () => {
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
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Avaliações Aulas</Link>
                                    </li>
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Ver Avaliações</Link>
                                    </li>
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Cadastrar Aula</Link>
                                    </li>
                                </ul>
                            </li>
                            <li className="nav-item dropdown">
                                <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Atividades</a>
                                <ul className="dropdown-menu bg-dark">
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Avaliações Atividades</Link>
                                    </li>
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Criar Atividade</Link>
                                    </li>
                                    <li>
                                        <Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Ver Atividades</Link>
                                    </li>
                                </ul>
                            </li>
                            <li className="nav-item dropdown">
                                <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Turmas</a>
                                <ul className="dropdown-menu bg-dark">
                                    <li><Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Criar Turma</Link></li>
                                    <li><Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Ver Turmas</Link></li>
                                </ul>
                            </li>
                            <li className="nav-item dropdown">
                                <a href="/" className="nav-link dropdown-toggle text-white" role="button" data-bs-toggle="dropdown" aria-expanded="false">Alunos</a>
                                <ul className="dropdown-menu bg-dark">
                                    <li><Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Cadastrar Aluno</Link></li>
                                    <li><Link className="dropdown-item bg-dark text-white" to="/avaliacao/aula/">Ver Alunos</Link></li>
                                </ul>
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