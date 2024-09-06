import { useEffect, useState } from "react";
import ProfessorSevice from "../../services/ProfessorService"
import { Link, useNavigate,useParams } from "react-router-dom";

const EditarProfessor = () => {
    const[primeiroNome,setPNome] = useState("")
    const[segundoNome,setSNome] = useState("")
    const role = "PROFESSOR"
    const[matricula, setMatricula] = useState(0)
    const[email, setEmail] = useState("")
    const[link, setLink] = useState("")
    const navigate = useNavigate();

    const {id} = useParams()

    useEffect(
        () => {
            ProfessorSevice.getProfessorById(id,(response) => {
                if(response.status == 200){
                    const professor = response.data
                    //console.log(professor)
                    setPNome(professor.primeiroNome)
                    setSNome(professor.segundoNome)
                    setMatricula(professor.matricula)
                    setEmail(professor.email)
                    setLink(professor.linkTelegram)
                }else{
                    navigate("/error")
                }
            })
        },
        []
    )

    const handleInputPNome = (event) => {
        setPNome(event.target.value)
    }

    const handleInputSNome = (event) => {
        setSNome(event.target.value)
    }

    const handleInputMatricula = (event) => {
        setMatricula(event.target.value)
    }

    const handleInputEmail = (event) => {
        setEmail(event.target.value)
    }

    const handleInputLink = (event) => {
        setLink(event.target.value)
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        let professor = { segundoNome: segundoNome, role:role, primeiroNome: primeiroNome, matricula: matricula, email: email, linkTelegram: link}
        ProfessorSevice.alterProfessors({id,professor},
            (log) => {
                console.log(log.status)
                if(log.status == 200){
                    alert("PROFESSOR Alterado")
                    navigate("/professor/listar")
                }else if(log.status == 403){
                    navigate("/")
                }
        })
    }
    
    return (
        <div className="page-content">
            <h1>Editar Professor</h1>
            <form className="form-content" onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label className="form-label" htmlFor="inputPNome"> Primeiro Nome</label>
                    <input
                        className="form-control"
                        type="text"
                        value={primeiroNome}
                        name="primeiroNome" 
                        id="inputPNome"
                        onChange={handleInputPNome}
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label" htmlFor="inputSNome"> Segundo Nome</label>
                    <input
                        className="form-control"
                        type="text"
                        value={segundoNome}
                        name="segundoNome" 
                        id="inputSNome"
                        onChange={handleInputSNome}
                    />
                </div>
                
                <div className="mb-3">
                    <label className="form-label" htmlFor="inputMatricula">Matricula</label>
                    <input
                        className="form-control"
                        type="number"
                        value={matricula}
                        name="matricula"
                        id="inputMatricula"
                        onChange={handleInputMatricula} 
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label" htmlFor="inputEmail">Email</label>
                    <input
                        className="form-control"
                        type="email"
                        name="email"
                        value={email}
                        id="inputEmail"
                        onChange={handleInputEmail} 
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label" htmlFor="inputLink">Link do Telegram</label>
                    <input
                        className="form-control"
                        type="text"
                        name="link"
                        value={link}
                        id="inputLink"
                        onChange={handleInputLink} 
                    />
                </div>
                
                <div className="div-button-submit">
                    <button
                        type="submit"
                        className="btn btn-primary"
                        style={{marginLeft:0}}
                    >
                        Alterar
                    </button>
                    <Link className="text-danger alter-senha" to="/professor/{id}/altersenha">Alterar senha</Link>
                </div>
            </form>
        </div>
        
    )
}

export default EditarProfessor;