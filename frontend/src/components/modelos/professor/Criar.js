import { useState } from "react";

const CriarProfessor = () =>{

    const [nome, setNome] = useState("")
    const role = "PROFESSOR"
    const [sobrenome, setSobrenome] = useState("")
    const [email, setEmail] = useState("")
    const [senha, setSetnha] = useState("")
    const [matricula, setMatricula] = useState("")
    const [link, setLink] = useState("")


    function handleInputName(event){
        setNome(event.target.value)
    }

    function handleSubmit(event){
        
    }

    return(
        <div className="page-content">
            <form className="form-content" onSubmit={handleSubmit}>
                <div className="md-3">
                    <label className="form-label" htmlFor="inputNome">Nome</label>
                    <input 
                        className="form-control"
                        type="text"
                        name="nome"
                        id="inputNome"
                        onChange={handleInputName}
                    />
                </div>
            </form>
        </div>
    )
}

export default CriarProfessor;