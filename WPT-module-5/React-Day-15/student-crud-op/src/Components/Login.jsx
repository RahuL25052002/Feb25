import { Button, Container, Form } from "react-bootstrap";


export function Login(){
    return(
        <Container>
            <Row>
                <Col lg={4}>
                <Form >
                <Form.Group className="mb-3">
                    <Form.Label></Form.Label>
                    <Form.Control></Form.Control>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label></Form.Label>
                    <Form.Control></Form.Control>
                </Form.Group>
                <Button variant="succress"></Button>
                </Form>
                </Col>
            </Row>
        </Container>
    )
}