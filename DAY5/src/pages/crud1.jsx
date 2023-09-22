import React, { useRef, useState } from 'react'
import '../assets/css/crud1.css'

function Crud1() {
    const list = [
        {
            id: 1, 
            name: "Fridge",
            brand:"Samsung"
            
            
        },
        {
            id: 2, 
            name: "Iron Box",
            brand:"Philips"
            
            
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
                            <td>{current.name}</td>
                            <td>{current.brand}</td>
                            
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
        const name = event.target.elements.name.value
        const brand = event.target.elements.brand.value
        
        const newlist = lists.map((li) => (
            li.id === updateState ? {...li, name:name, brand: brand} : li
        ))

        setList(newlist)
        setUpdateState(-1)
    }
}

function EditList({current, lists, setList}) {
    function handInputname(event) {
        const value = event.target.value;
        const newlist = lists.map((li) => (
            li.id === current.id ? {...li, name :value} : li
        ))

        setList(newlist)
    }
    function handInputbrand(event) {
        const value = event.target.value;
        const newlist = lists.map((li) => (
            li.id === current.id ? {...li, brand :value} : li
        ))

        setList(newlist)
    }
   
   
    return(
        <tr>
            <td><input type="text" onChange={handInputname} name='name' value={current.name}/></td>
            <td><input type="text" onChange={handInputbrand} name='brand' value={current.brand}/></td>
           
            <td><button type='submit'>Update</button></td>
        </tr>
    )
}

function AddList({setList}) {
    const nameRef = useRef()
    const brandRef = useRef()
  

    function handleSubmit(event) {
        event.preventDefault();
        const name = event.target.elements.name.value;
        const brand = event.target.elements.brand.value;
        
        const newlist = {
            id: 3,
            name,
            brand
        }
        setList((prevList)=> {
            return prevList.concat(newlist)
        })
        nameRef.current.value = ""
        brandRef.current.value = ""
        
    }
    return(
        <form className='addForm' onSubmit={handleSubmit}>
            <input type="text" name="name" placeholder="Enter Appliance Name" ref={nameRef}/>
            <input type="text" name="brand" placeholder="Enter Brand Name" ref={brandRef}/>
           
            <button type="submit">Add</button>
        </form>
    )
}

export default Crud1;