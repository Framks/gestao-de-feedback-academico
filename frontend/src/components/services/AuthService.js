import axios from "axios";
import {jwtDecode} from "jwt-decode";

const URL = "https://gestao-de-feedback-academico.onrender.com"

class AuthService{

    static async login({username, password}, callback) {
        try {
            const response = await axios.post(URL+"/login", { email:username, senha:password });
            callback(response.data);
        } catch (error) {
            console.error("Erro ao fazer login", error);
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