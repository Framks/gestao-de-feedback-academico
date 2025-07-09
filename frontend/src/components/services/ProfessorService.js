import axios  from "axios";
import URL from "./URL_base"


class ProfessorSevice{

    static getProfessors( callback ){
        axios.get(URL+"/professor/")
        .then( response => {callback(response.data)})
        .catch(error => console.log(error));
    }

    static postProfessors(novo, callback){
        axios.post(URL+"/professor/", novo)
        .then(response => {
            callback(response)
        })
        .catch(error => {
            console.log(error)
            callback(null)
        })
    }

    static deleteProfessor(id, callback){
        axios.delete(URL+`/professor/${id}`).then((response) => {
            callback(response)
        }).catch((error) => {
            console.log(error)
        })
    }

    static getProfessorById(id, callback) {
        axios.get(URL+`${id}`).then(
            (response) => callback(response)
        ).catch((error) => console.log(error))
    }

    static alterProfessors({id, professor}, callback){
        axios.put(URL+`/professor/${id}`,professor)
        .then((response) => {
            callback(response)
        })
        .catch((error) => console.log(error))
    }
}

export default ProfessorSevice;