import React, {useEffect, useState} from 'react';
import Recipe from "../components/Recipe";
import client from "../client";

function RecipePage(props) {

    const [recipes, setRecipes] = useState({codingProblems: []})

    useEffect(() => {
        client({method: 'GET', path: `/api/recipes/all`})
            .done(response => {
                const data = response.entity._embedded.recipes;
                setRecipes({codingProblems: data});
            });
    }, []);

    return (
        <div>
            {recipes.codingProblems.map(recipe => {
                return (
                    <Recipe
                        key={recipe["title"]}
                        title={recipe["title"]}
                        description={recipe["description"]}
                        type={recipe["type"]}
                        code={recipe["_links"]["Code for this recipe"].href}
                    />
                );
            })}
        </div>
    );
}

export default RecipePage;