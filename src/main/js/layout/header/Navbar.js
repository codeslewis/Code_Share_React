import React from "react";
import {NavLink, BrowserRouter} from "react-router-dom";
import NavBrand from "./nav-components/NavBrand";
import DropMenu from "./nav-components/DropMenu";
import RecipeMenu from "./nav-components/RecipeMenu";

function Navbar() {

    return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <NavBrand />
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <NavLink
                                    className="nav-link active"
                                    aria-current="page"
                                    to={{
                                        pathname: '/latest',
                                        latestByLang: {
                                            url: "latest",
                                            lang: "Latest"
                                        }
                                    }}
                                >Latest Snippets</NavLink>
                            </li>
                            <RecipeMenu />
                            <DropMenu />

                        </ul>

                    </div>
                </div>
            </nav>
    )
}

export default Navbar;