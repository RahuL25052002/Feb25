import { useEffect, useState } from "react";
import { Alert, Button, Col, Container, Form, Row } from "react-bootstrap";
import { fetchStudentById, registerStudent, updateStudent } from "../services/StudentService";
import { toast } from "react-toastify";
import { useNavigate, useParams } from "react-router-dom";

export function StudentEditForm() {

    const params = useParams();
    const navigate = useNavigate();
    console.log(params.id);

    const [formData, setFormData] = useState({id:'',name:'',phone:'',marks:''});

    const getStudentData = async () => {
        try {
            const response = await fetchStudentById(params.id);
            setFormData(response.data);
        } catch (error) {
            console.log(error);
            toast.error('Something went wrong...!');
        }
        
    }

    useEffect(()=>{
        getStudentData();
    },[]);

    const handleChange = (event) => {
        setFormData({...formData,[event.target.name]:event.target.value});
    }

    const handleSubmit = async (event) => {
        try {
            event.preventDefault(); 
            console.log(formData);
            const response = await updateStudent(params.id,formData);
            if(response.status===200){
                navigate("/student-list");
            }
        } catch (error) {
            console.log(error);
            toast.error("Something went wrong");
        }
        
    }

    return (
        <Container className="mt-4">
            <Alert variant="success">
                <h2>Edit a student</h2>
            </Alert>
            <Container className="mt-3">
                <Form onSubmit={handleSubmit}>
                    <Row>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Id</Form.Label>
                                <Form.Control type="text" value={formData.id} placeholder="Enter Id" name="id" onChange={handleChange} disabled />
                            </Form.Group>
                        </Col>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Name</Form.Label>
                                <Form.Control type="text" value={formData.name} placeholder="Enter Name" name="name" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Marks</Form.Label>
                                <Form.Control type="text" value={formData.marks} placeholder="Enter Marks" name="marks" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Phone</Form.Label>
                                <Form.Control type="text" value={formData.phone} placeholder="Enter Phone" name="phone" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Button type="submit" variant="primary">Update</Button>
                </Form>
            </Container>
        </Container>
    )
}