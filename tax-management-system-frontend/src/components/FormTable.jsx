import axios from 'axios';
import { useState } from 'react';
import { Form } from '../models/Form';
import React from 'react';

export const FormTable = () => {

    const [forms, setforms] = useState([]);

    const getAllCpas = async () => {
        await axios.get('http://localhost:8080/form')
                   .then(response => {
                        setforms(response.data.map((form: any) => {
                            return {
                                form: new Form(form.id, form.form_name, form.form_type, form.form)
                            }
                        }));
                   });
    }
    return (
        <table>
                <thead>
                    <tr>
                        <th>Form Id</th>
                        <th>Form Name</th>
                        <th>Form Type</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        forms.map((form: any) => {
                            return (
                                <tr key={ form.form.id }>
                                    <td>{ form.form.form_name}</td>
                                    <td>{ form.form_type }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>

    );


};