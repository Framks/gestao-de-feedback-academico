import Home from "./components/Home";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import PaginaInicio from "./components/PaginaInicio";
import CriarProfessor from "./components/modelos/professor/Criar";

const router = createBrowserRouter(
    [
        {
            path: "/", element:<Home/>,
            children:[
                {index:true, element:<PaginaInicio/>},
                {path: "professor/criar/", element:<CriarProfessor/>}
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
