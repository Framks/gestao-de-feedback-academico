import Home from "./components/Home";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import PaginaInicio from "./components/PaginaInicio";
import CriarProfessor from "./components/modelos/professor/Criar";
import ListarProfessor from "./components/modelos/professor/Listar";

import "./components/modelos/style/style.css"
import ListarAlunos from "./components/modelos/aluno/Listar";

const router = createBrowserRouter(
    [
        {
            path: "/", element:<Home/>,
            children:[
                {index:true, element:<PaginaInicio/>},
                {path: "professor/criar/", element:<CriarProfessor/>},
                //{path: "professor/editar/", element:<EditarProfessor/>},
                {path: "professor/listar/", element:<ListarProfessor/>},

                //{path: "aluno/criar/", element:<CriarAlunos/>},
                {path: "aluno/listar/", element:<ListarAlunos/>}
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
