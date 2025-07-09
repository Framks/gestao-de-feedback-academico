import AlunoService from "../../services/AlunoService"

import {useState, useEffect} from "react"
import { Link } from "react-router-dom";
// import { useNavigate } from "react-router-dom";

const ListarAlunos = () => {

    const [alunos, setAlunos] = useState([])

  useEffect(
    () => {
      AlunoService
      .getAlunos(data => setAlunos(data))
    }
    ,
    []
  )

  const handleLink = (aluno)  => {
    if(aluno.hasOwnProperty('linkTelegram') && aluno.linkTelegram !== null){
        return(<>{aluno.linkTelegram}</>)
    }else{
        return(<>Vázio</>)
    }
  }

  const handleDelete = (id) => {
    if (window.confirm(`Deseja excluir id = ${id}`)) {
      AlunoService.delete(
        id,
      (response) =>{
        let vetornovo = alunos.filter(aluno => aluno.id !== id) 
        setAlunos(vetornovo)
      })
      //navigate(0)
    }
  }

  const rendereizarAlunos = () => {
    const vetorResultado = alunos.map(
        (aluno) => {
            return (
                <tr key={aluno.matricula}>
                    <th scope="row">{aluno.matricula}</th>
                    <td>{aluno.primeiroNome} {aluno.segundoNome}</td>
                    <td>{aluno.email}</td>
                    <td>{handleLink(aluno)}</td>
                    <td>
                        <div className="button-content">
                            <Link 
                              to={`/aluno/editar/${aluno.id}`}
                              className="btn btn-primary"
                            >
                              Editar
                            </Link>
                            <button 
                              type="button" 
                              className="btn btn-danger"
                              onClick={() => handleDelete(aluno.id)}
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
            {rendereizarAlunos()}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ListarAlunos;