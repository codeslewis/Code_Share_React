import React from 'react';

function Snippet(props) {
    const {code, lang, date, self, langLink} = props;
    return (
        <div className="card w-50">
            <h6 className="alert alert-primary card-header">{lang}</h6>
            <code className="card-body code">{code}</code>
            <span className="card-footer">{date}</span>

        </div>
    );
}

export default Snippet;