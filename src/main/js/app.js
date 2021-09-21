'use strict';

import React, {useState, useEffect} from "react";
import ReactDOM from 'react-dom';
import client from './client';
import Snippet from "./components/Snippet";

function App() {
    const [snippet, setSnippet] = useState({});


    useEffect(() => {
        client({method: 'GET', path: '/api/code/1'}).done(response => {
            setSnippet(response.entity);
        })
    }, []);

    return (
        <div>
            <h2>react</h2>
            <Snippet
                code={snippet.code}
                lang={snippet.lang}
                date={snippet.date}
            />
        </div>
    );
}

export default App;
// ReactDOM.render(
//     <App />,
//     document.getElementById('react')
// )