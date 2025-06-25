import { useState } from "react"

export function ScoreCard(){
    const [score,setScore]=useState(0);
    const increseScore=()=>{
        setScore(score+2);
    }
    const decreaseScore=()=>{
        setScore(score-1);
    }
    return(
    
        <div>
            <h1>{score}</h1>
            <button onClick={increseScore}>+</button>
            <button onClick={decreaseScore}>-</button>
        </div>
    )
}