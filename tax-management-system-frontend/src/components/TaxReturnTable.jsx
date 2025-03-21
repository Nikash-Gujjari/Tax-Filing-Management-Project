import axios from 'axios';
import { useState } from 'react';
import { Tax_Return } from '../models/Tax_Return.ts';
import React from 'react';

export const TaxReturnTable = (props) => {

    const [taxreturns, setTaxReturns] = useState([]);

    // Use Cpa Params
    const getAllCpas = async () => {
        await axios.get('http://localhost:8080/taxreturn')
                   .then(response => {
                        setTaxReturns(response.data.map((taxreturn: any) => {
                            return {
                                taxreturn: new Tax_Return(taxreturn.id, taxreturn.filing_status)
                            }
                        }));
                   });
    }
    return (
        <table>
                <thead>
                    <tr>
                        <th>Tax Return Id</th>
                        <th>Filing Status</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        taxreturns.map((taxreturn: any) => {
                            return (
                                <tr key={ taxreturn.taxreturn.id }>
                                    <td>{ taxreturn.filing_status }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>

    );


};