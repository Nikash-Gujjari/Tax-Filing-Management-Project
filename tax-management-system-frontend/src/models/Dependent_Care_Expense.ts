export class Dependent_Care_Expense {
    dependent_care_expense_id: number;
    form_name: string;
    form: Blob

    constructor(depndent_care_expense_id: number, form_name: string, form: Blob) {
        this.dependent_care_expense_id = depndent_care_expense_id;
        this.form_name = form_name;
        this.form = form;
    }
}