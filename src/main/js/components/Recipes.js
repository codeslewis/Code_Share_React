import React, {useState, useEffect} from 'react';
import client from '../client';
import Recipe from "./Recipe";

function Recipes() {
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

export default Recipes;