import { Component } from "react";

export class DemoComponent extends Component{
    render(){
        return(
            <div>
                <h1>{this.props.heading}</h1>
                <p>{this.props.text}</p>
            </div>
        )
    }
}