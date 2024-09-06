import Home from "./components/Home";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import PaginaInicio from "./components/PaginaInicio";
import CriarProfessor from "./components/modelos/professor/Criar";
import ListarProfessor from "./components/modelos/professor/Listar";
import "./components/services/TokenToRequest";
import PrivateRoute from "./components/services/PrivateRoute";
import "./components/style/style.css"
import ListarAlunos from "./components/modelos/aluno/Listar";
import RoleProtectedRoute from "./components/services/RoleProtectedRoute"
import Login from "./components/login/Login"
import EditarProfessor from "./components/modelos/professor/Editar"

const router = createBrowserRouter(
    [
        {
            path: "/login", element:<Login/>,
        },
        {
            path: "/", element: (
                <PrivateRoute>
                    <Home />
                </PrivateRoute>
            ),
            children:[
                {index:true, element:<PaginaInicio/>},
                {
                    path: "professor/criar/",
                    element:(
                        <RoleProtectedRoute allowedRoles={["ADMIN"]}>
                            <CriarProfessor />
                        </RoleProtectedRoute>
                    )
                },
                {
                    path: "professor/editar/:id",
                    element:
                    <RoleProtectedRoute allowedRoles={["ADMIN"]}>
                        <EditarProfessor/>
                    </RoleProtectedRoute>},
                {
                    path: "professor/listar/",
                    element:(
                        <RoleProtectedRoute allowedRoles={["ADMIN"]}>
                            <ListarProfessor/>
                        </RoleProtectedRoute>
                    )
                    
                },

                //{path: "aluno/criar/", element:<CriarAlunos/>},
                {
                    path: "aluno/listar/",
                    element:
                    <RoleProtectedRoute allowedRoles={["professor", "admin"]}>
                        <ListarAlunos/>
                    </RoleProtectedRoute>
                }
                //{path: "aluno/editar/", element:<EditarAluno/>},

                //{path: "atividade/avaliacoes/", element:</>},
                //{path: "atividade/listar/", element:</>},
                //{path: "atividade/criar/", element:</>},
                //{path: "atividade/editar/", element:</>},

                //{path: "aula/avaliacoes/", element:</>},
                //{path: "aula/listar/", element:</>},
                //{path: "aula/criar/", element:</>},
                //{path: "aula/editar/", element:</>},

                //{path: "turma/criar", elemnent:</>},
                //{path: "turma/listar", elemnent:</>},
                //{path: "turma/editar", elemnent:</>},
            ]
        }
    ]
);

function App() {
    return (
        <RouterProvider router={router} >
        </RouterProvider>
    );
}

export default App;
