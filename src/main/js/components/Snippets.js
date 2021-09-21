import React, {useState, useEffect} from 'react';
import client from '../client';
import Snippet from './Snippet';

// function Snippets(props) {
//     const {snips} = props;
//     return (
//         <div>
//             {snips.map((snip) => {
//                 return (
//                     <Snippet
//                         code={snip.code}
//                         lang={snip.lang}
//                         date={snip.date}
//                     />
//                 );
//             })}
//         </div>
//     );
// }

function Snippets() {
    const [snippet, setSnippet] = useState({});
    const [self, setSelf] = useState({});
    const [langLinks, setLangLinks] = useState({});

    useEffect(() => {
        client({method: 'GET', path: '/api/code/1'}).done(response => {
            setSnippet(response.entity);
            setSelf(response.entity._links.self);
            setLangLinks(response.entity._links["All Code in this Language"])
        })
    }, []);

    // console.log(snippet._links);
    // console.log(`Links: ${self.href}`);
    // console.log(`Language Links: ${langLinks.href}`);

    return (
        <div className="row">
            <Snippet
                code={snippet.code}
                lang={snippet.lang}
                date={snippet.date}
                self={self.href}
                langLink={langLinks.href}
            />
        </div>
    );
}

export default Snippets;