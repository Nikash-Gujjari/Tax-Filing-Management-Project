import axios from 'axios';
import { useState } from 'react';
import { Taxpayer } from '../models/Taxpayer.ts';
import React from 'react';

export const TaxpayerTable = (props) => {

    const [taxpayers, settaxpayers] = useState([]);

    // Use Cpa Params
    const getAllCpas = async () => {
        await axios.get('http://localhost:8080/taxpayer')
                   .then(response => {
                        settaxpayers(response.data.map((taxpayer: any) => {
                            return {
                                taxpayer: new Taxpayer(taxpayer.id, taxpayer.first_name, taxpayer.middle_name, taxpayer.last_name, taxpayer.social_security_number, taxpayer.address, taxpayer.date_of_birth, taxpayer.bank_account_number, taxpayer.bank_routing_number)
                            }
                        }));
                   });
    }
    return (
        <table>
                <thead>
                    <tr>
                        <th>Taxpayer Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Date of Birth</th>
                        <th>Social Security Number</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        taxpayers.map((taxpayer: any) => {
                            return (
                                <tr key={ taxpayer.taxpayer.id }>
                                    <td>{ taxpayer.first_name}</td>
                                    <td>{ taxpayer.last_name }</td>
                                    <td>{ taxpayer.date_of_birth }</td>
                                    <td>{ taxpayer.social_security_number }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>

    );


};