import React, { Component } from 'react';
import './App.css';
import 'whatwg-fetch'
import Main from '../Main';


class App extends Component {


render() {
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
        </a>
      </header>
      <Main />
    </div>
  );
}
}


export default App;
