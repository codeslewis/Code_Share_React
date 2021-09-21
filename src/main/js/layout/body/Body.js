import React from "react";
import { Route, Switch } from "react-router-dom";
import Snippets from '../../components/Snippets';
import Latest from "../../components/Latest";
import Recipes from "../../components/Recipes";

function Body() {
    return (
        <>
            <Switch>
                <Route path="/recipes">
                    <Recipes />
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