import React from 'react';
import Snippet from './Snippet';

function Snippets(props) {
    const {snips} = props;
    return (
        <div>
            {snips.map((snip) => {
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