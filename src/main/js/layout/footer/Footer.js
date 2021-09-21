import React from 'react';

function Footer() {
    return (
        <footer className="w-100 py-4 flex-shrink-0 bg-light align-bottom mt-auto">
            <div className="container py-4">
                <div className="row gy-4 gx-5">
                    <div className="text-center">
                        <p className="small text-muted">Made by Lewis Sneddon</p>
                        <a target="_blank" rel="noreferrer" href="https://lewiscode.com">
                            <p className="text-muted">lewiscodes.io</p></a>
                    </div>
                </div>
            </div>
        </footer>
    );
}

export default Footer;