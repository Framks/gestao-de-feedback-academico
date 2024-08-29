import { useState } from "react";

const CriarProfessor = () =>{

    const turma = {idprofessor:0,codigo:"",disciplina:"",semestre:1,ano:1}


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