import axios from "axios";

export function login(formData){
    return axios.post('http://localhost:7800/admin/login',formData);
}