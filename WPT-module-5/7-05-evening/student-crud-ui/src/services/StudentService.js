import axios from "axios";

export function fetchAllStudents(){
    return axios.get("http://localhost:7800/student");
}

export function registerStudent(formData){
    return axios.post("http://localhost:7800/student",formData);
}

export function deleteStudent(id){
    return axios.delete(`http://localhost:7800/student/${id}`);
}

export function fetchStudentById(id){
    return axios.get(`http://localhost:7800/student/${id}`);
}

export function updateStudent(id,formData){
    return axios.put(`http://localhost:7800/student/${id}`,formData)
}