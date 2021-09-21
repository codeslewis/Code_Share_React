

import React, {useState, useEffect} from "react";
import client from './client';
import Snippet from "./components/Snippet";
import Navbar from './layout/header/Navbar';
import Footer from "./layout/footer/Footer";
import Body from "./layout/body/Body";
import {BrowserRouter} from "react-router-dom";

function App() {
    // const [snippet, setSnippet] = useState({});
    //
    //
    // useEffect(() => {
    //     client({method: 'GET', path: '/api/code/1'}).done(response => {
    //         setSnippet(response.entity);
    //     })
    // }, []);

    return (
        <>
            <BrowserRouter>
                <Navbar />
                {/*<div className="row">*/}
                {/*        <Snippet*/}
                {/*            code={snippet.code}*/}
                {/*            lang={snippet.lang}*/}
                {/*            date={snippet.date}*/}
                {/*        />*/}
                {/*</div>*/}
                <Body />
                <Footer />
            </BrowserRouter>
        </>

    );
}

export default App;