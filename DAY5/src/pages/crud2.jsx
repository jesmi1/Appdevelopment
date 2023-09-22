import React, { useRef, useState } from 'react'
import '../assets/css/crud2.css'

function Crud2() {
    const list = [
        {
            id: 1, 
            PatName: "Seetha",
            Reason:"Chest Pains",
            AppDate: "11/11/2023",
            AppTime:"11:30 am"
             
            
        },
        {
            id: 2, 
            PatName: "Angel",
            Reason:"Infected Finger",
            AppDate: "9/10/2023",
            AppTime:"11:00 am"
            
        },
    ]
    const [lists, setList] = useState(list)
    const [updateState, setUpdateState] = useState(-1)
    return(
        <div className='crud'>
            <div>
            <AddList setList = {setList }/>
            <form onSubmit={handleSubmit}>
            <table>
                {
                    lists.map((current) => (
                        updateState === current.id ? <EditList current={current} lists={lists} setList={setList}/> :
                        <tr>
                            <td>{current.PatName}</td>
                            <td>{current.Reason}</td>
                            <td>{current.AppDate}</td>
                            <td>{current.AppTime}</td>
                            <td>
                                <button className='edit' onClick={() => handleEdit(current.id)}>Edit</button>
                                <button className='delete' type='button' onClick={() => handleDelete(current.id)}>Delete</button>
                            </td>
                        </tr>
                    ))
                }
            </table>
            </form>
            </div>
        </div>
    )

    function handleEdit(id) {
        setUpdateState(id)
    }
    function handleDelete(id) {
        const newlist = lists.filter((li) => li.id !== id)
        setList(newlist)
    }
    function handleSubmit(event) {
        event.preventDefault()
        const PatName = event.target.elements.PatName.value
        const Reason = event.target.elements.Reason.value
        const AppDate = event.target.elements.AppDate.value
        const AppTime = event.target.elements.AppTime.value
        const newlist = lists.map((li) => (
            li.id === updateState ? {...li, PatName:PatName, Reason: Reason, AppDate: AppDate, AppTime: AppTime} : li
        ))

        setList(newlist)
        setUpdateState(-1)
    }
}

function EditList({current, lists, setList}) {
    function handInputPatName(event) {
        const value = event.target.value;
        const newlist = lists.map((li) => (
            li.id === current.id ? {...li, PatName :value} : li
        ))

        setList(newlist)
    }
    function handInputReason(event) {
        const value = event.target.value;
        const newlist = lists.map((li) => (
            li.id === current.id ? {...li, Reason :value} : li
        ))

        setList(newlist)
    }
    function handInputAppDate(event) {
        const value = event.target.value;
        const newlist = lists.map((li) => (
            li.id === current.id ? {...li, AppDate :value} : li
        ))

        setList(newlist)
    }
    function handInputAppTime(event) {
        const value = event.target.value;
        const newlist = lists.map((li) => (
            li.id === current.id ? {...li, AppTime :value} : li
        ))

        setList(newlist)
    }
    return(
        <tr>
            <td><input type="text" onChange={handInputPatName} name='PatName' value={current.PatName}/></td>
            <td><input type="text" onChange={handInputReason} name='Reason' value={current.Reason}/></td>
            <td><input type="text" onChange={handInputAppDate} name='Date_vis' value={current.AppDate}/></td>
            <td><input type="text" onChange={handInputAppTime} name='Doc_id' value={current.AppTime}/></td>
            <td><button type='submit'>Update</button></td>
        </tr>
    )
}

function AddList({setList}) {
    const PatNameRef = useRef()
    const ReasonRef = useRef()
    const AppDateRef = useRef()
    const AppTimeRef = useRef()

    function handleSubmit(event) {
        event.preventDefault();
        const PatName = event.target.elements.PatName.value;
        const Reason = event.target.elements.Reason.value;
        const AppDate = event.target.elements.AppDate.value;
        const AppTime = event.target.elements.AppTime.value;
        const newlist = {
            id: 3,
            PatName,
            Reason,
            AppDate,
            AppTime
        }
        setList((prevList)=> {
            return prevList.concat(newlist)
        })
        PatNameRef.current.value = ""
        ReasonRef.current.value = ""
        AppDateRef.current.value = ""
        AppTimeRef.current.value = ""
    }
    return(
        <form className='addForm' onSubmit={handleSubmit}>
            <input type="text" name="PatName" placeholder="Enter Patient Name" ref={PatNameRef}/>
            <input type="text" name="Reason" placeholder="Enter Reason" ref={ReasonRef}/>
            <input type="text" name="AppDate" placeholder="Enter App_Date" ref={AppDateRef}/>
            <input type="text" name="AppTime" placeholder="Enter App_Time" ref={AppTimeRef}/>
            <button type="submit">Add</button>
        </form>
    )
}

export default Crud2;