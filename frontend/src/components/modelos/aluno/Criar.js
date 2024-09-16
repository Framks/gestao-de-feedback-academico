import { useState } from "react";
import ProfessorSevice from "../../services/ProfessorService";
import { useNavigate } from "react-router-dom";

const CriarProfessor = () =>{

    const[primeiroNome,setPNome] = useState("")
    const[segundoNome,setSNome] = useState("")
    const role = "PROFESSOR"
    const[matricula, setMatricula] = useState(0)
    const[email, setEmail] = useState("")
    const[senha, setSenha] = useState("")
    const[link, setLink] = useState("")
    const navigate = useNavigate();

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

    const handleInputSenha =(event) =>{
        setSenha(event.target.value)
    }

    const handleInputLink = (event) => {
        setLink(event.target.value)
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        let professor = { segundoNome: segundoNome, role:role, primeiroNome: primeiroNome, matricula: matricula, email: email, senha : senha, linkTelegram: link}
        ProfessorSevice.postProfessors(professor,
            (log) => {
                console.log(log.status)
                if(log.status == 200){
                    alert("PROFESSOR ADCIONADO")
                    navigate("/professor/listar")
                }else if(log.status == 403){
                    navigate("/")
                }
        })
    }
    
    return (
        <div className="page-content">
            <h1>Criar Professor</h1>
            <form className="form-content" onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label className="form-label" htmlFor="inputPNome"> Primeiro Nome</label>
                    <input
                        className="form-control"
                        type="text"
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
                        id="inputEmail"
                        onChange={handleInputEmail} 
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label" htmlFor="inputESenha">Senha</label>
                    <input
                        className="form-control"
                        placeholder="Senha"
                        type="password"
                        name="senha"
                        id="inputESenha"
                        onChange={handleInputSenha} 
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label" htmlFor="inputLink">Link do Telegram</label>
                    <input
                        className="form-control"
                        type="text"
                        name="link"
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
                        Submeter
                    </button>
                </div>
            </form>
        </div>
        
    )
}

export default CriarProfessor;