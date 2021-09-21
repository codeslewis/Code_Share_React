import React from 'react';

function Recipe(props) {
    const {title, description, type, code} = props;

    return (
        <div className="card w-50">
            <h6 className="alert alert-primary card-header">{title}</h6>
            <code className="card-body">{description}</code>
            <span className="card-footer">{type}</span>
            <a href={code}><button className="btn btn-outline-primary">Code</button></a>
        </div>
    );
}

export default Recipe;