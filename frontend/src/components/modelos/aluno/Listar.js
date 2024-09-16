import ProfessorService from "../../services/ProfessorService"

import {useState, useEffect} from "react"
import { Link } from "react-router-dom";
// import { useNavigate } from "react-router-dom";

const ListarProfessor = () => {

    const [professores, setProfessores] = useState([])
    // const navigate = useNavigate()

  useEffect(
    () => {
      ProfessorService
      .getProfessors(data => setProfessores(data))
    }
    ,
    []
  )

  const handleLink = (professor)  => {
    if(professor.hasOwnProperty('linkTelegram') && professor.linkTelegram !== null){
        return(<>{professor.linkTelegram}</>)
    }else{
        return(<>Vázio</>)
    }
  }

  const handleDelete = (id) => {
    if (window.confirm(`Deseja excluir id = ${id}`)) {
      ProfessorService.deleteProfessor(
        id,
      (response) =>{
        let vetornovo = professores.filter(professor => professor.id != id) 
        setProfessores(vetornovo)
      })
      //navigate(0)
    }
  }

  const renderizarProfessores = () => {
    const vetorResultado = professores.map(
        (professor) => {
            return (
                <tr key={professor.matricula}>
                    <th scope="row">{professor.matricula}</th>
                    <td>{professor.primeiroNome} {professor.segundoNome}</td>
                    <td>{professor.email}</td>
                    <td>{handleLink(professor)}</td>
                    <td>
                        <div className="button-content">
                            <Link 
                              to={`/professor/editar/${professor.id}`}
                              className="btn btn-primary"
                            >
                              Editar
                            </Link>
                            <button 
                              type="button" 
                              className="btn btn-danger"
                              onClick={() => handleDelete(professor.id)}
                            >
                              Apagar
                            </button>
                        </div>
                    </td>
                </tr>
            )
        }
    )
    return vetorResultado;
  };

  return (
    <div className="page-content">
      <h1>Listar Alunos</h1>
      <div className="table-content">
        <table className="table table-striped table-bordered">
          <thead className="table-dark">
            <tr>
              <th scope="col">Matricula</th>
              <th scope="col">Nome</th>
              <th scope="col">Email</th>
              <th scope="col">Contato</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            {renderizarProfessores()}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ListarProfessor;