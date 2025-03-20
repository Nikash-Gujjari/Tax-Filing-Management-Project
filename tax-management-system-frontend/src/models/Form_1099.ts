export class form_1099 {
    form_1099_id: number;
    form_name: string;
    form: Blob

    constructor(form_1099_id: number, form_name: string, form: Blob) {
        this.form_1099_id = form_1099_id;
        this.form_name = form_name;
        this.form = form;
    }
}