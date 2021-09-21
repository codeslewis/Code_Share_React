import React from "react";

function NewSnippet(props) {
    const name = props.location.newSnippetProps.name;

    return (
        <div className="container">
            <form className="row g-3">
                <div className="col-md-6">
                    <label htmlFor="language" className="form-label">Programming Language</label>
                    <input type="text" id="language" className="form-control" />
                    <label htmlFor="code_snippet" className="form-label">Upload a new code snippet for problem: {name}</label>
                    <textarea className="form-control" id="code_snippet" rows="3"></textarea>
                    <button id="send_snippet" className="btn btn-primary" type="submit" onClick="send()">Submit</button>
                </div>
            </form>
        </div>
    );
}

function send() {
    let object = {
        "code": document.getElementById("code_snippet").value,
        "lang": document.getElementById("language").value
    };

    let json = JSON.stringify(object);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new/1/1', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status === 200) {
        alert("Success!");
    }
}

export default NewSnippet;