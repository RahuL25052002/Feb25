import  axios  from "axios"
import { useState } from "react"

export function RegistrationForm() {
    const [formdata, setFormData]=useState({id:'',name:'',phone:'',marks:''})
    

    const handleChange= (event)=>{
        // var value;
        // setFormData({...formdata,id:value})

        // console.log(event.target);
        // console.log(event.target.value);

        setFormData({...formdata,[event.target.name]:event.target.value})

        // var val;
        // var value=event.target;
        // setFormData({value:val})
    }

    const handleSubmit= async(event)=>{
        try{
            event.preventDefault();
            console.log(formdata)
            const response= await axios.post("http://localhost:5000/student",formdata)
            console.log(response);
        }catch(error){
            console.log(error);
        }


    }
//     const handleIdChange=()=>{
//         var value;
//         setFormData({...formdata,id:value})
//     }
   
//    const handleNameChange=()=>{
//     var value;
//     setFormData({...formdata,name:value})
//    }
//    const handlePhoneChange=()=>{
//     var value;
//     setFormData({...formdata,phone:value})
//    }
//    const handleMarksChange=()=>{
//     var value;
//     setFormData({...formdata,marks:value})
//    }
    return (
        // <div>
        //     <form action="">
        //         <div>
        //             <label htmlFor="">id</label>
        //             <input type="text" placeholder="Enter id" onChange={handleIdChange}></input>
        //         </div>
        //         <div>
        //             <label htmlFor="">name</label>
        //             <input type="text" placeholder="Enter name" onChange={handleNameChange}></input>
        //         </div>
        //         <div>
        //             <label htmlFor="">phone</label>
        //             <input type="text" placeholder="Enter Phone" onChange={handlePhoneChange}></input>
        //         </div>
        //         <div>
        //             <label htmlFor="">marks</label>
        //             <input type="text" placeholder="Enter marks" onChange={handleMarksChange}></input>
        //         </div>
        //         <button></button>
        //     </form>
        // </div>
        <div >
            <form action=""  onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="">id</label>
                    <input type="text" placeholder="Enter id" onChange={handleChange} name="id"></input>
                </div>
                <div>
                    <label htmlFor="">name</label>
                    <input type="text" placeholder="Enter name" onChange={handleChange} name="name"></input>
                </div>
                <div>
                    <label htmlFor="">phone</label>
                    <input type="text" placeholder="Enter Phone" onChange={handleChange} name="phone"></input>
                </div>
                <div>
                    <label htmlFor="">marks</label>
                    <input type="text" placeholder="Enter marks" onChange={handleChange} name="marks"></input>
                </div>
                <button>Register</button>
            </form>
        </div>
    )
}