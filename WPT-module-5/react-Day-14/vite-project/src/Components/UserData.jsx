// import { createElement } from "react";
import { Component } from "react";
import  axios  from 'axios';
export class UserData extends Component{
    constructor(){
        super();
        this.state={
            users:[]

        }
    }

    async componentDidMount() {
        try {
          // const response = await fetch("https://jsonplaceholder.typicode.com/users");
          // const data = await response.json();
          // this.setState({ users: data });
          const response=await axios.get("https://jsonplaceholder.typicode.com/users");
          console.log(response.data);
          this.setState({users:response.data})
        } catch (error) {
          console.error(error);
        }
      }
    // 
    
    render() {
        return (
          <div>
            <h1>List of users</h1>
            <table border={1} cellPadding={10}>
              <thead >
                <tr>
                  <th>Id</th>
                  <th>Name</th>
                  <th>Username</th>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>
                {/* {
                
                this.state.users.map((user) => (
                  <tr key={user.id}>
                    <td>{user.id}</td>
                    <td>{user.name}</td>
                    <td>{user.username}</td>
                    <td>{user.email}</td>
                  </tr>
                ))
                } */}
                {
                  this.state.users.map((u)=>{
                    return(
                      <tr>
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
        );
      }
    }
    

// it will call after the render
    // async componentDidMount(){
    //     try{
    //         const response=await fetch("https://jsonplaceholder.typicode.com/users");
    //         const data=await response.json();
    //         console.log(data)
    //         const Id=data.id;
    //         const name=data.name;
    //         const username=data.username;
    //         const email=data.email;

    //         const val=document.getElementById("tbody")
    //         const val2=createElement('tr')
    //         val.innerHTML=`
    //         <td>${Id}</td>
    //          <td>${name}</td>
    //           <td>${username}</td>
    //            <td>${email}}</td> `

    //         val2.appendChild(val);

    //     }catch(error){
    //         console.log(error);
    //     };
    // }