import { Outlet } from "react-router-dom";
import Navbar from "./NavBar";

function Layout(){
    return(
        <div>
            <Outlet/>
            <Navbar/>
        </div>
    )
}

export default Layout;