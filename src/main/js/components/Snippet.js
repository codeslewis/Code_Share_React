import React from 'react';

function Snippet(props) {
    const {code, lang, date} = props;

    return (
        <div>
            <p>{code}</p>
            <p>{lang}</p>
            <p>{date}</p>
        </div>
    );
}

export default Snippet;