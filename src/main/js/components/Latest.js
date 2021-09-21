import React, {useState, useEffect} from 'react';
import client from '../client';
import Snippet from "./Snippet";

function Latest(props) {
    const {url} = props;
    const [latestSnippets, setLatestSnippets] = useState({codeSnippets: []});

    useEffect(() => {
        client({method: 'GET', path: `/api/code/${url}`}).done(response => {
            // setLatestSnippets(latestSnippets.concat(response.entity._embedded.snippets));
            const data = response.entity._embedded.snippets;
            setLatestSnippets({codeSnippets: data});
        });
    }, []);

    return (
        <div>
            <h2>Latest Snippets</h2>
            {latestSnippets.codeSnippets.map((s) => {
                // console.log(s._links);
                return <Snippet
                    code={s.code}
                    lang={s.lang}
                    date={s.date}
                    self={s._links.self.href}
                    langLinks={s._links["All Code in this Language"].href}
                />
            })}
        </div>
    )
}

export default Latest;