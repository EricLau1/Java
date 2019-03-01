import React, { Component } from 'react';

import './styles.css';

export default class ProductList extends Component {

    render() {
        const { products } = this.props;
        console.log(products);
        return (
            <div>
                 {products.length > 0? 
                <table className="table-products">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Quantidade</th>
                            <th>Preço</th>
                        </tr>
                    </thead>
                    <tbody>
                    {products.map(product => (
                        <tr key={product.id}>
                            <td>{product.name}</td>
                            <td>{product.quantity}</td>
                            <td>$ {product.price},00</td>
                        </tr>
                    ))}
                    </tbody>
                </table>: 
                <p>Lista vazia...</p> }
            </div>
        );
    }
}