import React from 'react';
import Snippet from './Snippet';

function Snippets(props) {
    return (
        <div>
            {props.map((snip) => {
                return (
                    <Snippet
                        code={snip.code}
                        lang={snip.lang}
                        date={snip.date}
                    />
                );
            })}
        </div>
    );
}

export default Snippets;