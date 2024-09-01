import AlunoService from "../../services/AlunoService"

import {useState, useEffect} from "react"
import { Link } from "react-router-dom";
// import { useNavigate } from "react-router-dom";

const ListarAlunos = () => {

    const [Alunos, setAlunos] = useState([])
    // const navigate = useNavigate()

  useEffect(
    () => {
      AlunoService
      .getAlunos(data => setAlunos(data))
    }
    ,
    []
  )

  const handleLink = (Aluno)  => {
    console.log(Aluno)
    if(Aluno.hasOwnProperty('linkTelegram') && Aluno.linkTelegram !== null){
        return(<>{Aluno.linkTelegram}</>)
    }else{
        return(<>Vázio</>)
    }
  }

  const handleDelete = (id) => {
    if (window.confirm(`Deseja excluir id = ${id}`)) {
      AlunoService.deleteAluno(
        id,
      (response) =>{
        let vetornovo = Alunos.filter(Aluno => Aluno.id != id) 
        setAlunos(vetornovo)
      })
      //navigate(0)
    }
  }

  const renderizarAlunos = () => {
    const vetorResultado = Alunos.map(
        (Aluno) => {
            return (
                <tr key={Aluno.matricula}>
                    <th scope="row">{Aluno.matricula}</th>
                    <td>{Aluno.primeiroNome} {Aluno.segundoNome}</td>
                    <td>{Aluno.email}</td>
                    <td>{handleLink(Aluno)}</td>
                    <td>
                        <div className="button-content">
                            <Link 
                              to={`/Aluno/editar/${Aluno.id}`}
                              className="btn btn-primary"
                            >
                              Editar
                            </Link>
                            <button 
                              type="button" 
                              className="btn btn-danger"
                              onClick={() => handleDelete(Aluno.id)}
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
      <h1>Listar Aluno</h1>
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
            {renderizarAlunos()}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ListarAlunos;