import axios  from "axios";

const URL = "http://localhost:8080/aluno/"

class AlunoSevice{

    static getAlunos( callback ){
        axios.get(URL)
        .then( response => {callback(response.data)})
        .catch(error => console.log(error));
    }
}

export default AlunoSevice;