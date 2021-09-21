'use strict';

import React, {useState, useEffect} from "react";
import client from './client';
import Snippet from "./components/Snippet";
import Navbar from './layout/header/Navbar';

function App() {
    const [snippet, setSnippet] = useState({});


    useEffect(() => {
        client({method: 'GET', path: '/api/code/1'}).done(response => {
            setSnippet(response.entity);
        })
    }, []);

    return (
        <>
            <Navbar />
            <div className="card">
                <h2 className="alert alert-primary">Code Snippet</h2>
                <div className="card-body">
                    <Snippet
                        code={snippet.code}
                        lang={snippet.lang}
                        date={snippet.date}
                    />
                </div>
            </div>
        </>

    );
}

export default App;