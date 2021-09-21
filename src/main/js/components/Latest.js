import React, {useState, useEffect} from 'react';
import client from '../client';
import Snippet from "./Snippet";

function Latest(props) {
    const url = props.location.latestByLang.url;
    const lang = props.location.latestByLang.lang;
    const [latestSnippets, setLatestSnippets] = useState({codeSnippets: []});

    useEffect(() => {
        client({method: 'GET', path: `/api/code/${url}`}).done(response => {
            // setLatestSnippets(latestSnippets.concat(response.entity._embedded.snippets));
            const data = response.entity._embedded.snippets;
            setLatestSnippets({codeSnippets: data});
        });
    }, [props]);

    return (
        <div>
            <h2>{lang} Snippets</h2>
            {latestSnippets.codeSnippets.map((s) => {
                return <Snippet
                    key={s._links.self.href}
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