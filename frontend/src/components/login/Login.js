import { useState} from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../services/AuthService";

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = (e) => {
        e.preventDefault();
        AuthService.login({username, password}, (data) => {
            console.log(data)
            sessionStorage.setItem("token", data)
            navigate("/"); // Redireciona para a página inicial
        })
        navigate("/"); // Redireciona para a página inicial
    };

    return (
        <div className="login-container dark">
            <form className="login-form bg-dark text-white" onSubmit={handleLogin}>
                <h2 className="text-center">Login</h2>
                <div className="form-group">
                    <label className="form-label" htmlFor="username">Email</label>
                    <input
                        className="form-control dark-input"
                        id="username"
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>
                <div className="form-group">
                    <label className="form-label" htmlFor="senha">Senha</label>
                    <input
                        id="senha"
                        className="dark-input form-control"
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>
                <div className="div-button-submit mt-3">
                        <button
                            type="submit"
                            className="btn btn-light"
                        >
                            Submeter
                        </button>
                    </div>
            </form>
        </div>
    );
}

export default Login;