import React from "react";
import { Route, Switch } from "react-router-dom";
import Latest from "../../components/Latest";
import Recipes from "../../components/Recipes";
import NewSnippet from "../../components/NewSnippet";
import ErrorPage from "../../pages/ErrorPage";
import HomePage from "../../pages/HomePage";
import RecipePage from "../../pages/RecipePage";
import UploadPage from "../../pages/UploadPage";

function Body() {
    return (
        <>
            <Switch>
                <Route path="/recipes" component={RecipePage} />
                <Route path="/new" component={UploadPage} />
                <Route path="/latest" component={Latest} />
                <Route path="/error" component={ErrorPage} />
                <Route path="/" component={HomePage} />
            </Switch>
        </>
    );
}

export default Body;