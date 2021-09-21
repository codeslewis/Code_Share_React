'use strict';

// tag::vars[]
// React = require('react');
// const ReactDOM = require('react-dom');
// const client = require('./client');
//
// const Snippets = require('./components/Snippets');const
import React, {useState, useEffect} from "react";
import ReactDOM from 'react-dom';
import client from './client';
import Snippets from "./components/Snippets";
import Snippet from "./components/Snippet";
// end::vars[]

// tag::app[]
function App() {
    // const [snippets, setSnippets] = useState([]);
    const [snippet, setSnippet] = useState({});


    useEffect(() => {
        // client({method: 'GET', path: '/api/code/latest'}).done(response => {
        //     setSnippets(response._embedded.snippets);
        // })
        client({method: 'GET', path: '/api/code/1'}).done(response => {
            setSnippet(response.entity);
        })
    }, []);

    console.log(snippet.code);
    // {console.log(snippets[0])}


    return (
        <div>
            <h2>react</h2>
            {/*<Snippets props={snippets} />*/}
            {/*<Snippet*/}
            {/*    code={snippet.code}*/}
            {/*    lang={snippet.lang}*/}
            {/*    date={snippet.date}*/}
            {/*/>*/}
            <Snippet
                code={snippet.code}
                lang={snippet.lang}
                date={snippet.date}
            />
        </div>
    );
}
// class App extends React.Component { // <1>
//
//     constructor(props) {
//         super(props);
//         this.state = {snippets: []};
//     }
//
//     componentDidMount() { // <2>
//         // client({method: 'GET', path: '/api/employees'}).done(response => {
//         //     this.setState({employees: response.entity._embedded.employeeList});
//         // });
//         client({method: 'GET', path: '/api/code/latest'}).done(response => {
//             this.setState({snippets: response.entity._embedded.snippets});
//         });
//
//     }
//
//     render() { // <3>
//         return (
//             // <EmployeeList employees={this.state.employees}/>
//             <div>
//                 <h2>react</h2>
//                 {console.log(this.state.snippets)}
//                 <Snippets props={this.state.snippets} />
//             </div>
//         )
//     }
// }
// end::app[]

// tag::employee-list[]
// class EmployeeList extends React.Component{
//     render() {
//         const employees = this.props.employees.map(employee =>
//             <Employee key={employee._links.self.href} employee={employee}/>
//         );
//         return (
//             <table>
//                 <tbody>
//                 <tr>
//                     <th>Name</th>
//                     <th>Role</th>
//                 </tr>
//                 {employees}
//                 </tbody>
//             </table>
//         )
//     }
// }
// end::employee-list[]

// tag::employee[]
// class Employee extends React.Component{
//     render() {
//         return (
//             <tr>
//                 <td>{this.props.employee.name}</td>
//                 <td>{this.props.employee.role}</td>
//             </tr>
//         )
//     }
// }
// end::employee[]

// tag::render[]
ReactDOM.render(
    <App />,
    document.getElementById('react')
)
// end::render[]