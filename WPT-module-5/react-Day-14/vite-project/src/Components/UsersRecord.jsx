import axios from "axios";
import { useEffect, useState } from "react"

export function UsersRecord() {
    const [users, setUsers] = useState([]);

    async function fetchData() {

        const response = await axios.get("https://jsonplaceholder.typicode.com/users");
        console.log(response);
        setUsers(response.data)
    }
    useEffect(() => {
        try {
            // const response=axios.get("https://jsonplaceholder.typicode.com/users");
            // console.log(response);
            fetchData();
           
        } catch (error) {
            console.log(error)
        }
    }, []);
    return (
        <div>
            <h1>List of Users</h1>
            <table border={1} cellPadding={10}>
                <thead >
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        users.map((u) => {
                            return (
                                <tr id={u.id}>
                                    <td>{u.id}</td>
                                    <td>{u.name}</td>
                                    <td>{u.username}</td>
                                    <td>{u.email}</td>
                                    <td>{u.phone}</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}