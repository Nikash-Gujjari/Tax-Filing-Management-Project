export class education_expense {
    education_expense_id: number;
    form_name: string;
    form: Blob

    constructor(education_expense_id: number, form_name: string, form: Blob) {
        this.education_expense_id = education_expense_id;
        this.form_name = form_name;
        this.form = form;
    }
}