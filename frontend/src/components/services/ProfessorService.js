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
            callback(response.data)
        })
        .catch(error => {
            console.log(error)
        })
    }
}

export default ProfessorSevice;