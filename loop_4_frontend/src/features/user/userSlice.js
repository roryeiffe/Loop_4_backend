import {createSlice} from '@reduxjs/toolkit';

const initialState = {
    id: -1,
    name: 'Default Name',
    total_score: 0,
    current_score: 0,
    vote_count: 0,
    inLoop: false,
}

export const userSlice = createSlice({
    name: 'user',
    initialState: initialState,
    reducers: {
        update: (state, action) => {
            state.id = action.payload.user.id;
            state.name = action.payload.user.name;
            state.total_score = action.payload.user.total_score;
            state.current_score = action.payload.user.current_score;
            state.vote_count = action.payload.user.vote_count;
            state.inLoop = action.payload.user.inLoop;
        }
    }
});

export const {update} = userSlice.actions;
export default userSlice.reducer