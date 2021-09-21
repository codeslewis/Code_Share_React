'use strict';

import React, {useState, useEffect} from "react";
import client from './client';
import Snippet from "./components/Snippet";
import Navbar from './layout/header/Navbar';
import Footer from "./layout/footer/Footer";

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
            <div className="row">
                    <Snippet
                        code={snippet.code}
                        lang={snippet.lang}
                        date={snippet.date}
                    />
            </div>
            <Footer />
        </>

    );
}

export default App;