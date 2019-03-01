import React, { Component } from 'react';
import './App.css';

import ProductList from './components/ProductList';

class App extends Component {

  state = {
    products: [],
  };

  componentDidMount() {

      fetch("http://localhost:8080/api/products")
        .then(response => response.json())
        .then(json => this.setState({ products: json }))
        .catch(e => console.log(e));
  }

  render() {

    let { products } = this.state;
    console.log(products);
    return (
      <div className="App">
          <h1> Lista de Produtos </h1>
          <ProductList products={products} /> 
      </div>
    );
  }
}

export default App;
