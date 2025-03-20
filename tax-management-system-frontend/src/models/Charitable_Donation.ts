export class Charitable_Donation {
    charitable_donation_id: number;
    form_name: string;
    form: Blob

    constructor(charitable_donation_id: number, form_name: string, form: Blob) {
        this.charitable_donation_id = charitable_donation_id;
        this.form_name = form_name;
        this.form = form;
    }
}