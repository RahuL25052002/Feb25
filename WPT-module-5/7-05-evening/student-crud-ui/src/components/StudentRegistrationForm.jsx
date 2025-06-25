import { useState } from "react";
import { Alert, Button, Col, Container, Form, Row } from "react-bootstrap";
import { registerStudent } from "../services/StudentService";
import { toast } from "react-toastify";

export function StudentRegistrationForm() {

    const [formData, setFormData] = useState({id:'',name:'',phone:'',marks:''});

    const handleChange = (event) => {
        setFormData({...formData,[event.target.name]:event.target.value});
    }

    const handleSubmit = async (event) => {
        try {
            event.preventDefault(); 
            console.log(formData);
            const response = await registerStudent(formData);
            console.log(response);
            if(response.status===200){
                toast.success("Student Registered Successfully")
            }
        } catch (error) {
            console.log(error);
            toast.error("Something went wrong");
        }
        
    }

    return (
        <Container className="mt-4">
            <Alert variant="success">
                <h2>Register a student</h2>
            </Alert>
            <Container className="mt-3">
                <Form onSubmit={handleSubmit}>
                    <Row>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Id</Form.Label>
                                <Form.Control type="text" placeholder="Enter Id" name="id" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Name</Form.Label>
                                <Form.Control type="text" placeholder="Enter Name" name="name" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Marks</Form.Label>
                                <Form.Control type="text" placeholder="Enter Marks" name="marks" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                        <Col lg={4}>
                            <Form.Group className="mb-3">
                                <Form.Label>Phone</Form.Label>
                                <Form.Control type="text" placeholder="Enter Phone" name="phone" onChange={handleChange} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Button type="submit" variant="primary">Register</Button>
                </Form>
            </Container>
        </Container>
    )
}