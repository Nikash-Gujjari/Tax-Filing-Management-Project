import axios from 'axios';
import { useState } from 'react';
import { Cpa }  from '../models/Cpa';
import React from 'react';

export const CpaTable = () => {

    const [cpas, setCpas] = useState([]);

    const getAllCpas = async () => {
        await axios.get('http://localhost:8080/cpa/')
                   .then(response => {
                        setCpas(response.data.map((cpa: any) => {
                            return {
                                cpa: new Cpa(cpa.id, cpa.first_name, cpa.last_name, cpa.email, cpa.username, cpa.password, cpa.role)
                            }
                        }));
                   });
    }
    return (
        <table>
                <thead>
                    <tr>
                        <th> CPA Id </th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        cpas.map((cpa: any) => {
                            return (
                                <tr key={ cpa.cpa.id }>
                                    <td>{cpa.cpa.first_name}</td>
                                    <td>{ cpa.cpa.last_name }</td>
                                    <td>{ cpa.cpa.email }</td>
                                    <td>{ cpa.cpa.role }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>

    );


};