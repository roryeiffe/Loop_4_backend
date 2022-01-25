import JoinRoom from "./pages/JoinRoom";
import { Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import CreateRoom from "./components/CreateRoom";

function App() {
  return (
    <Routes>
      <Route path = "/join" element = { <JoinRoom/> } />
      <Route path = "/create" element = { <CreateRoom/> } />
      <Route path = "/" element = { <HomePage/> } />
    </Routes>
  );
}

export default App;
