import { useEffect, useState } from "react";
import { Container, Form, Button, Card, Row, Col } from "react-bootstrap";

export function CreateTodo() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [todos, setTodos] = useState([]);

    // Fetch todos on mount
    useEffect(() => {
        fetchTodos();
    }, []);

    const fetchTodos = async () => {
        const res = await fetch("http://localhost:3000/todos");
        const data = await res.json();
        setTodos(data.todos); // assuming response has a "todos" array
    };

    const handleAddTodo = async () => {
        if (!title || !description) {
            alert("Please enter both title and description.");
            return;
        }

        await fetch("http://localhost:3000/todo", {
            method: "POST",
            body: JSON.stringify({ title, description }),
            headers: { "Content-Type": "application/json" }
        });

        setTitle("");
        setDescription("");
        fetchTodos(); // refresh todo list
    };

    const handleDelete = async (id) => {
        await fetch(`http://localhost:3000/todo/${id}`, {
            method: "DELETE"
        });

        fetchTodos(); // refresh after deletion
    };

    return (
        <Container className="mt-5 d-flex flex-column align-items-center">
            <Card style={{ width: '30rem', padding: '20px' }}>
                <Card.Body>
                    <Card.Title className="text-center mb-4">Create a Todo</Card.Title>
                    <Form>
                        <Form.Group className="mb-3" controlId="formTitle">
                            <Form.Label>Title</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Enter title"
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                            />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="formDescription">
                            <Form.Label>Description</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Enter description"
                                value={description}
                                onChange={(e) => setDescription(e.target.value)}
                            />
                        </Form.Group>

                        <div className="d-grid">
                            <Button variant="primary" onClick={handleAddTodo}>
                                Add Todo
                            </Button>
                        </div>
                    </Form>
                </Card.Body>
            </Card>

            {/* Todo List */}
            <h3 className="mt-5 mb-3">Your Todos</h3>
            <Row className="justify-content-center">
                {todos.length === 0 && <p>No todos yet.</p>}
                {todos.map((todo) => (
                    <Col key={todo.id} md={6} className="mb-4">
                        <Card>
                            <Card.Body>
                                <Card.Title>{todo.title}</Card.Title>
                                <Card.Text>{todo.description}</Card.Text>
                                <Button
                                    variant="success"
                                    onClick={() => handleDelete(todo.id)}
                                >
                                    Mark as Completed
                                </Button>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    );
}
