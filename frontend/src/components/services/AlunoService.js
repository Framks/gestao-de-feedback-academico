import axios  from "axios";

const URL = "https://gestao-de-feedback-academico.onrender.com"

class AlunoSevice{

    static getAlunos( callback ){
        axios.get(URL)
        .then( response => {callback(response.data)})
        .catch(error => console.log(error));
    }
}

export default AlunoSevice;