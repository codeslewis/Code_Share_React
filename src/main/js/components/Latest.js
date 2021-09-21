import React, {useState, useEffect} from 'react';
import client from '../client';
import Snippet from "./Snippet";

function Latest() {
    const [latestSnippets, setLatestSnippets] = useState([]);

    useEffect(() => {
        client({method: 'GET', path: '/api/code/latest'}).done(response => {
            setLatestSnippets(latestSnippets.concat(response.entity._embedded.snippets));
        })
    }, []);

    return (
        <div>
            <h2>Latest Snippets</h2>
            {latestSnippets.map((s) => {
                return <Snippet
                    code={s.code}
                    lang={s.lang}
                    date={s.date}
                />
            })}

            {/*{latestSnippets.forEach((i) => console.log(`Latest Snippets repeated: ${i.code}`))}*/}
        </div>
    )
}

export default Latest;