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


    useEffect(() => {
        client({method: 'GET', path: '/api/code/1'}).done(response => {
            setSnippet(response.entity);
        })
    }, []);

    return (
        <div className="row">
            <Snippet
                code={snippet.code}
                lang={snippet.lang}
                date={snippet.date}
            />
        </div>
    );
}

export default Snippets;