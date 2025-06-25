import { Component, useState } from "react";

export class Scoreboard extends Component{
    constructor(){
        super();
        this.state={
            score:0
        }
        this.increseScore=this.increseScore.bind(this);
        this.decreseScore=this.decreseScore.bind(this);
    }

    increseScore(){
        // this.state.score=this.score+1; not update the state thats way

        this.setState({
            score:this.state.score+2
        })
        //after the setscore render function again called
    }
    decreseScore(){
        this.setState({
            score:this.state.score-1
        })
    }
    render(){
        return(
            <div>
                <h1>{this.state.score}</h1>
                <button onClick={this.increseScore}>+</button>
                <button onClick={this.decreseScore}>-</button>
            </div>
        )
    }
}