import React from 'react';
import {Link} from "react-router-dom";

function Recipe(props) {
    const {title, description, type, code} = props;

    return (
        <div className="card w-50">
            <h6 className="alert alert-primary card-header">{title}</h6>
            <code className="card-body">{description}</code>
            <div className="card-footer">
                <p>{type}</p>
                <a href={code}><button className="btn btn-outline-primary m-1">Code</button></a>
                <Link
                    className="btn btn-outline-primary m-1"
                    role="button"
                    to={{
                        pathname: '/new',
                        newSnippetProps : {
                            name: `${title}`
                        }
                    }}
                >
                    New
                </Link>
            </div>
        </div>
    );
}

export default Recipe;