import axios  from "axios";

const URL = "http://localhost:8080/professor/"

class ProfessorSevice{

    static getProfessors( callback ){
        axios.get(URL)
        .then( response => {callback(response.data)})
        .catch(error => console.log(error));
    }

    static postProfessors(novo, callback){
        axios.post(URL, novo)
        .then(response => {
            callback(response)
        })
        .catch(error => {
            console.log(error)
            callback(null)
        })
    }

    static deleteProfessor(id, callback){
        axios.delete(URL+`${id}`).then((response) => {
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
        axios.put(URL+`${id}`,professor)
        .then((response) => {
            callback(response)
        })
        .catch((error) => console.log(error))
    }
}

export default ProfessorSevice;