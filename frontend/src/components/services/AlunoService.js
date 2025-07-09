import axios  from "axios";
import URL from "./URL_base"

class AlunoSevice{

    static getAlunos( callback ){
        axios.get(URL+"/aluno/")
        .then( response => {callback(response.data)})
        .catch(error => console.log(error));
    }

    static postAlunos(novo, callback){
        axios.post(URL+"/aluno/", novo)
        .then(response => {
            callback(response)
        })
        .catch(error => {
            console.log(error)
            callback(null)
        })
    }

    static delete(id, callback){
        axios.delete(URL+`/aluno/${id}`).then((response) => {
            callback(response)
        }).catch((error) => {
            console.log(error)
        })
    }

    static getById(id, callback) {
        axios.get(URL+`/aluno/${id}`).then(
            (response) => callback(response)
        ).catch((error) => console.log(error))
    }

    static alter({id, professor}, callback){
        axios.put(URL+`/aluno/${id}`,professor)
        .then((response) => {
            callback(response)
        })
        .catch((error) => console.log(error))
    }
}

export default AlunoSevice;