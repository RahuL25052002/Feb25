import { Component } from "react";


//class component
// export class MyComponent extends Component{
//     render(){
//         return(
//             <div>
//                 <h1>My Component</h1>
//             </div>
//         )
//     }
// }


//Function component
export function MyComponent(props){
        return(
            <div>
                {/* <h1>My Component</h1> */}
                <h1>{props.heading}</h1>
                <p>{props.text}</p>
                 
            </div>
        )
}