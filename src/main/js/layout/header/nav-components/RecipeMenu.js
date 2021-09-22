import React from 'react';
import {NavLink} from "react-router-dom";

function RecipeMenu() {
    return (
        <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">
                Recipes
            </a>
            <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                    <NavLink
                        className="dropdown-item"
                        to={{
                            pathname: '/recipes',
                            recipe: {
                                name: "Hello world"
                            }
                        }}
                    >Hello world</NavLink>
                </li>
            </ul>
        </li>
    );
}

export default RecipeMenu;