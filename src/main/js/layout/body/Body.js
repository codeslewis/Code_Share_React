import React from "react";
import { Route, Switch } from "react-router-dom";
import Snippets from '../../components/Snippets';
import Latest from "../../components/Latest";

function Body() {
    return (
        <>
            <Switch>
                <Route path="/java">
                    <Latest url="all/java"/>
                </Route>
                <Route path="/latest">
                    <Latest url="latest"/>
                </Route>
                <Route path="/">
                    <Snippets />
                </Route>
            </Switch>
        </>
    );
}

export default Body;