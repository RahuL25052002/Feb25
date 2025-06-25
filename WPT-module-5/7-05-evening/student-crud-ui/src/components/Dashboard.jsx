import { Alert, Container } from "react-bootstrap";

export function Dashboard(){
    return (
        <Container className="mt-4">
            <Alert variant="success">
                <h2>Welcome to student management application</h2>
            </Alert>
            <p>You can perform crud operations on student entity</p>
        </Container>
    )
}