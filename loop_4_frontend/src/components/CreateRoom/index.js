import axios from 'axios';
import {useState} from 'react';
import { useDispatch} from 'react-redux';
import { update } from '../../features/user/userSlice';

const CreateRoom = () => {

    const dispatch = useDispatch();

    const [userName, setUserName] = useState('');


    const onChangeHandler = (e) => {
        setUserName(e.target.value);
    }

    const onSubmitHandler = (e) => {
        e.preventDefault();
        if(userName !== '') {
            // add room to database
            axios.post('http://localhost:9001/rooms')
            .then(room => {
                // add user to database:
                axios.post('http://localhost:9001/users', {name: userName})
                .then(user => {
                    var userRoomMapping = {roomId: room.data.id, userId: user.data.id};
                    console.log(userRoomMapping);
                    axios.put('http://localhost:9001/rooms/addUser', userRoomMapping)
                    .then((response) => {
                        console.log(response.data)
                        dispatch(update({
                            user: user.data
                        }));
                    })
                    .catch(error => console.error(error));
                })
            })
            .catch(error => console.log(error));
        }
    }



    return (
        <div>
            <h1>Create Room</h1>
            <form onSubmit = {onSubmitHandler}>
                <h3>Enter Name:</h3>
                <input name = "name" value = {userName} onChange = {onChangeHandler}/>
                <button type = "submit">Create Room</button>
            </form>
        </div>
    )
}

export default CreateRoom;