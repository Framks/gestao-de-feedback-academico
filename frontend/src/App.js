import Home from "./components/Home";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

const router = createBrowserRouter(
    [
        {
            path: "/", element:<Home/>,
            children:[]
        }
    ]
);

function App() {
    return (
        <RouterProvider router={router}>
        </RouterProvider>
    );
}

export default App;
