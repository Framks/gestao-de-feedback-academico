import { useState } from "react";

const CriarProfessor = () =>{

    const atividade = {criadorId:1, nome:"", descricao:"", disponivel:true}

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