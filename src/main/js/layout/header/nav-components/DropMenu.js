import React from 'react';
import {NavLink} from "react-router-dom";

function DropMenu() {
    return (
        <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
               data-bs-toggle="dropdown" aria-expanded="false">
                Language
            </a>
            <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                    <NavLink
                        className="dropdown-item"
                        to={{
                            pathname: '/latest',
                            latestByLang : {
                                url: "all/Java",
                                lang: "Java"
                            }
                        }}
                    >Java</NavLink>
                </li>
                <li>
                    <NavLink
                        className="dropdown-item"
                        to={{
                            pathname: '/latest',
                            latestByLang : {
                                url: "all/Kotlin",
                                lang: "Kotlin"
                            }
                        }}
                    >Kotlin</NavLink>
                </li>
                <li>
                    <NavLink
                        className="dropdown-item"
                        to={{
                            pathname: '/latest',
                            latestByLang : {
                                url: "all/JavaScript",
                                lang: "JavaScript"
                            }
                        }}
                    >JavaScript</NavLink>
                </li>
                <li>
                    <NavLink
                        className="dropdown-item"
                        to={{
                            pathname: '/latest',
                            latestByLang : {
                                url: "all/Go",
                                lang: "Go"
                            }
                        }}
                    >Go</NavLink>
                </li>
            </ul>
        </li>
    );
}

export default DropMenu;