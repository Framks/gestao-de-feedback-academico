import axios from "axios";
import {jwtDecode} from "jwt-decode";
import URL from "./URL_base"

const local = URL

class AuthService{

    static async login({username, password}, callback) {
        try {
            console.log(local+"/login")
            const response = await axios.post("http://localhost:8080/login", { email:username, senha:password });
            callback(response.data);
        } catch (error) {
            if (error.response) {
                console.log('Erro no Axios com resposta:', error.response.data);
              } else if (error.request) {
                console.log('Erro no Axios sem resposta:', error.request);
              } else {
                console.log('Erro ao configurar a requisição Axios:', error.message);
              }
        }
    }

    static getRole(){
        const token = sessionStorage.getItem("token")
        if(!token) return null;
        const decoded = jwtDecode(token);
        return decoded.role;
    }
}

export default AuthService;