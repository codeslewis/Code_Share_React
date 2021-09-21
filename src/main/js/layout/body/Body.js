import React from "react";
import { Route, Switch } from "react-router-dom";
import Snippets from '../../components/Snippets';
import Latest from "../../components/Latest";
import Recipes from "../../components/Recipes";
import NewSnippet from "../../components/NewSnippet";
import ErrorPage from "../../components/ErrorPage";

function Body() {
    return (
        <>
            <Switch>
                <Route path="/recipes" component={Recipes} />
                <Route path="/new" component={NewSnippet} />
                <Route path="/latest" component={Latest} />
                <Route path="/error" component={ErrorPage} />
                <Route path="/" component={Snippets} />
            </Switch>
        </>
    );
}

export default Body;