import { useEffect, useState } from "react";
import { Alert, Button, Container, Modal, Table } from "react-bootstrap";
import { deleteStudent, fetchAllStudents } from "../services/StudentService";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

export function StudentList() {

    const [students, setStudents] = useState([]);
    const [dialogVisibility, setDialogVisibility] = useState(false);
    const [selectedStudentId, setSelectedStudentId] = useState();

    const navigate = useNavigate();

    const getStudents = async () => {
        try {
            const response = await fetchAllStudents(); // service api call
            setStudents(response.data);
        } catch (error) {
            console.log(error);
        }

    }
    useEffect(() => {
        getStudents();
    }, []);

    const closeDialog = () => {
        setDialogVisibility(false);
    }

    const handleStudentDelete = async () => {
        try {
            const response = await deleteStudent(selectedStudentId);
            if(response.status===200){
                toast.success('Student removed');
                closeDialog();
                setStudents(students.filter((s)=>s.id!==selectedStudentId));
            }
        } catch (error) {
            console.log(error);
            toast.error('Something went wrong...!');
        }
    }

    return (
        <Container className="mt-4">
            <Alert variant="success">
                <h5>List of students</h5>
            </Alert>
            <Container className="mt-3">
                {
                    students.length > 0 ? <Table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Marks</th>
                                <th>Phone</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                students.map((s) => {
                                    return (
                                        <tr>
                                            <td>{s.id}</td>
                                            <td>{s.name}</td>
                                            <td>{s.marks}</td>
                                            <td>{s.phone}</td>
                                            <td>
                                                <Button variant="primary" className="btn-sm" onClick={()=>{
                                                    navigate(`/edit-student/${s.id}`);
                                                }}>Edit</Button>
                                                &nbsp;&nbsp;
                                                <Button variant="danger" className="btn-sm" onClick={()=>{
                                                    setSelectedStudentId(s.id);
                                                    setDialogVisibility(true);
                                                }}>Delete</Button>
                                            </td>
                                        </tr>
                                    )
                                })
                            }
                        </tbody>
                    </Table> : <h2>No record found !</h2>
                }
                <Modal show={dialogVisibility} onHide={closeDialog} centered>
                    <Modal.Header closeButton>
                        <Modal.Title>Confirmation</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>Are you sure you want to remove data for {selectedStudentId} ?</Modal.Body>
                    <Modal.Footer>
                        <Button variant="success" className="btn-sm" onClick={handleStudentDelete}>
                            Yes
                        </Button> &nbsp;
                        <Button variant="danger" className="btn-sm" onClick={closeDialog}>
                            No
                        </Button>
                    </Modal.Footer>
                </Modal>
            </Container>
        </Container>
    )
}