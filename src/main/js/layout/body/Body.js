import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Snippets from '../../components/Snippets';
import Latest from "../../components/Latest";

function Body() {
    return (
        <>
                <Switch>
                    <Route path="/latest">
                        <Latest />
                    </Route>
                    <Route path="/">
                        <Snippets />
                    </Route>
                </Switch>
        </>
    );
}

export default Body;