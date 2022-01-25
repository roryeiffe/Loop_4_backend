import axios from 'axios';
import {useState} from 'react';
import { useDispatch } from 'react-redux';
import { update } from '../../features/user/userSlice';

const JoinRoom = () => {

    const [info, setInfo] = useState({userName: '', password: ''});

    const dispatch = useDispatch();

    const onChangeHandler = (e) => {
        setInfo({...info, [e.target.name]: e.target.value});
    }

    const onSubmitHandler = (e) => {
        e.preventDefault();
        // add user:
        axios.post('http://localhost:9001/users', {name: info.userName})
        .then(user => { 
            axios.get('http://localhost:9001/rooms/password/' + info.password)
            .then(room => {
                axios.put('http://localhost:9001/rooms/addUser', {roomId: room.data.id, userId: user.data.id})
                .then((response) => {
                    console.log(response.data)
                    dispatch(update({
                        user: user.data
                    }));
                })
            })
        })
    }
    
    return (
        <div>
            <h1>Join Room</h1>
            <form onSubmit = {onSubmitHandler}>
                <h3>Enter Name:</h3>
                <input name = 'userName' value = {info.userName} onChange = {onChangeHandler}/>
                <h3>Enter Room ID:</h3>
                <input name = 'password' value = {info.password} onChange = {onChangeHandler}/>
                <button type = 'submit'>Join Room</button>
            </form>
        </div>
    )
}

export default JoinRoom;