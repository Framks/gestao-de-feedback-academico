import { Navigate } from "react-router-dom";
import AuthService from "./AuthService";

const RoleProtectedRoute = ({children, allowedRoles }) => {
    const role = AuthService.getRole();
    if (!role || !allowedRoles.includes(role)) {
        return <Navigate to="/login" />; // Redireciona se o usuário não tiver a role necessária
    }
    return children;
}

export default RoleProtectedRoute;